package edu.eci.cvds.services.impl;


import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.*;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;
import javax.inject.Inject;
import java.util.ArrayList;
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


    /*
    Consultar / SELECT / Buscar
     */
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
    public Equipo consultarEquipo(int idEquipo) throws HistorialEquiposException{
        try{
            return equipoDAO.consultarEquipo(idEquipo);
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException);
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
    public List<Elemento> buscarElemento(String elemento) throws HistorialEquiposException{
        try {
            return elementoDAO.buscarElemento(elemento);
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

    /*
    Insertar / INSERT / Agregar
     */
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
    public void insertarEquipo(Integer idEquipo,int[] elementos, int idLab, int idUsuario ) throws HistorialEquiposException{
        try {
            equipoDAO.registrarEquipo(idEquipo,idLab);
            String cadena ="";
            for( int elemento : elementos){
                relacionarElementoEquipo(elemento,idEquipo);
                cadena+= elemento+", ";
                insertarNovedad(new Novedad("Asociación de elemento a equipo ","El elemento con id "+elemento+" fue asociado al equipo "+idEquipo,idUsuario,elemento,idEquipo));
            }
            insertarNovedad( new Novedad("Registro del Equipo", "El equipo con id "+idEquipo+" fue registrado y se le asignaron los elementos: "+cadena,idEquipo, idUsuario));
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

    /*
    Actualizar / UPDATE / Asociar / Dar de baja / Relacionar
     */

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
    public void asociarEquipo(int idLab, int idEquipo) throws HistorialEquiposException {
        try {
            equipoDAO.asociar(idLab, idEquipo);
        } catch (PersistenceException e) {
            throw new HistorialEquiposException(e.getMessage(),e );
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
    public void asociarElementoEquipo(int idUsuario, List<Elemento> elementosSeleccionados, Integer idEquipo) throws HistorialEquiposException {
        try{
            ArrayList<String> evalElemento = new ArrayList<String>();
            //Testeando esta mondá
            Equipo evalEquipo = consultarEquipo(idEquipo);
            if (evalEquipo == null){
                throw new PersistenceException("Equipo no existente.");
            }
            //Garantiza que no se asocien más elementos de lo posible
            if (elementosSeleccionados.size() > 4){
                throw new PersistenceException("Cantidad de elementos a asociar a un solo equipo no valida.");
            }
            //Garantiza que no se asocien más de un elemento del mismo tipo
            for (Elemento e: elementosSeleccionados){
                if (evalElemento.contains(e.getTipo())){
                    throw new PersistenceException("Cantidad de elementos de un mismo tipo a asociar a un solo equipo no valida.");
                }
                evalElemento.add(e.getTipo());
            }
            //Aquí ya debe de asociar los elementos SI O SI
            for (Elemento e: elementosSeleccionados){
                for (Elemento q: evalEquipo.getElementos()){
                    if (e.getTipo().equals(q.getTipo())){
                        elementoDAO.asociarEquipo(q.getIdElemento(),null);
                        insertarNovedad( new Novedad("Retiro de elemento","El elemento con id " + q.getIdElemento() + " de tipo " + q.getTipo() + " fue retirado del equipo"+ q.getIdEquipo() +".",idUsuario,q.getIdElemento(),idEquipo));
                        break;
                    }
                }
                elementoDAO.asociarEquipo(e.getIdElemento(),idEquipo);
                insertarNovedad(new Novedad("Asociacion elemento-equipo","El elemento con id "+ e.getIdElemento() +" de tipo " + e.getTipo() + " fue asociado al equipo con id " + idEquipo +".",idUsuario,e.getIdElemento(),idEquipo));
            }
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException);
        }
    }

    @Override
    public void cambiarEstadoElemento(int idUsuario, Elemento elemento) throws HistorialEquiposException {
        try{
            String change = elemento.getEstado().equals("ACTIVO") ? "INACTIVO" : "ACTIVO";
            if (elemento.getDisponible() == 0){
                throw new PersistenceException("Un elemento asociado a un equipo no se puede dar de baja.");
            }
            elementoDAO.cambiarEstadoElemento(elemento.getIdElemento(),change);
            if (change.equals("INACTIVO")){
                insertarNovedad(new Novedad("Elemento dado de baja","El elemento con id "+ elemento.getIdElemento() +" de tipo " + elemento.getTipo() + " fue dado de baja.",idUsuario,elemento.getIdElemento(), null) );
            }
            else{
                insertarNovedad(new Novedad("Elemento activo","El elemento con id "+ elemento.getIdElemento() +" de tipo " + elemento.getTipo() + " fue activado otra vez.",idUsuario,elemento.getIdElemento(), null) );
            }
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException);
        }
    }
}
