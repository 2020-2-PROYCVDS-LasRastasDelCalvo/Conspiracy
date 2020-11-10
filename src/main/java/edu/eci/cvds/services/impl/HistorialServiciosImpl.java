package edu.eci.cvds.services.impl;


import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.*;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/31/2020
 */
public class HistorialServiciosImpl implements HistorialServicios{
    @Inject
    private NovedadDAO novedadDAO;

    @Inject
    private ElementoDAO elementoDAO;

    @Inject
    private EquipoDAO equipoDAO;

    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private LaboratorioDAO laboratorioDAO;

    @Override
    public List<Novedad> consultarNovedades() throws HistorialEquiposException{
        try{
            return novedadDAO.cargarNovedades();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public List<Elemento> consultarElementos() throws HistorialEquiposException {
        try{
            return elementoDAO.consultarElementos();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public void insertarElemento(String tipo, String nombre, String descripcion) throws HistorialEquiposException {
        try{
            Elemento elemento = new Elemento(tipo, nombre, descripcion);
            elementoDAO.registrarElemento( elemento );
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public List<Equipo> consultarEquipos() throws HistorialEquiposException {
        try{
            return equipoDAO.consultarEquipos();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public void insertarEquipo(int idEquipo,int[] elementos, int idLab, int idUsuario ) throws HistorialEquiposException{
        try {
            equipoDAO.registrarEquipo(idEquipo,idLab);
            for( int elemento : elementos){
                relacionarElementoEquipo(elemento,idEquipo);
                insertarNovedad(new Novedad("Asociación de elemento a equipo ","El elemento con id "+elemento+" fue asociado al equipo "+idEquipo,idUsuario,elemento,idEquipo));
            }
            insertarNovedad( new Novedad("Registro del Equipo", "El equipo con id "+idEquipo+" fue registrado y se le asignaron los elementos: "+elementos.toString(),idUsuario, idEquipo));
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public void relacionarElementoEquipo(int idElemento, int idEquipo) throws HistorialEquiposException {
            try{
                elementoDAO.asociarEquipo( idElemento, idEquipo);
            }
            catch (PersistenceException persistenceException){
                throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
            }
    }

    @Override
    public List<Elemento> buscarElemento(String elemento) throws HistorialEquiposException{
        try {
            return elementoDAO.buscarElemento(elemento);
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public void insertarNovedad(Novedad novedad) throws HistorialEquiposException {
        try{
            novedadDAO.guardarNovedadEquipo( novedad );
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public Usuario consultarUsuarioPorCorreo(String correo) throws HistorialEquiposException {
        try{
            Optional<Usuario> usuarioOptional = Optional.ofNullable(usuarioDAO.consultarPorCorreo( correo ));
            usuarioOptional.orElseThrow(() -> new HistorialEquiposException(HistorialEquiposException.NO_CLIENTE));
            return usuarioOptional.get();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public List<Laboratorio> consultarLaboratorios() throws HistorialEquiposException {
        try{
            return laboratorioDAO.consultarLaboratorios();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public void registrarLaboratorio(int idUsuario,int idLab, String nombreLab, List<Equipo> aAsociar) throws HistorialEquiposException {
        try{
            laboratorioDAO.registrarLaboratorio(idLab, nombreLab);
            for (Equipo equipo: aAsociar){
                asociarEquipo(idLab, equipo.getIdEquipo());
                insertarNovedad(new Novedad("Asociación de equipo a laboratorio","El equipo con id "+idLab+" fue asociado al laboratorio "+nombreLab+" con id "+idLab,idUsuario,null,equipo.getIdEquipo()));
            }
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public void asociarEquipo(int idLab, int idEquipo) throws HistorialEquiposException {
        try {
            equipoDAO.asociar(idLab, idEquipo);
        } catch (PersistenceException e) {
            throw new HistorialEquiposException(e.getMessage(),e );
        }
    }

    @Override
    public List<Equipo> consultarEquiposDisponibles() throws HistorialEquiposException{
        try{
            return equipoDAO.consultarEquiposDisponibles();
        }
        catch(PersistenceException e){
            throw new HistorialEquiposException(e.getMessage(),e);
        }
    }

    @Override
    public void asociarEquipoLabExistente(List<Equipo> equipos, int idUsuario, int idLab) throws HistorialEquiposException {
        try{
            Optional<Laboratorio> optionalLaboratorio = Optional.ofNullable( laboratorioDAO.consultarLaboratorio( idLab ) );
            optionalLaboratorio.orElseThrow(() -> new HistorialEquiposException(HistorialEquiposException.NO_LAB));

            for( Equipo equipo: equipos){
                asociarEquipo(idLab,equipo.getIdEquipo());
                insertarNovedad( new Novedad(" Retiro de equipo de laboratorio","El equipo con id "+equipo.getIdEquipo()+" fue retirado del laboratorio con id "+equipo.getIdLab(),idUsuario,null,equipo.getIdEquipo()));
                insertarNovedad( new Novedad(" Asociacion de equipo a un laboratorio","El equipo con id "+equipo.getIdEquipo()+" fue asociado al laboratorio con id "+idLab,idUsuario,null,equipo.getIdEquipo() ) );
            }
        }
        catch(PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException);
        }
    }

    @Override
    public void asociarElementoEquipo(int idUsuario, List<Elemento> elementosSeleccionados, int idEquipo) throws HistorialEquiposException {

    }


}
