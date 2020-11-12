package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.*;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.ServiciosElemento;
import edu.eci.cvds.services.ServiciosEquipo;
import edu.eci.cvds.services.ServiciosNovedad;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ServiciosElementoImpl implements ServiciosElemento {
    @Inject
    private ElementoDAO elementoDAO;

    @Inject
    private ServiciosNovedad serviciosNovedad;

    @Inject
    private ServiciosEquipo serviciosEquipo;

    /*
    SELECT
     */
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
    public List<Elemento> buscarElemento(String elemento) throws HistorialEquiposException{
        try {
            return elementoDAO.buscarElemento(elemento);
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    /*
    UPDATE
     */
    @Override
    public void cambiarEstadoElemento(int idUsuario, Elemento elemento) throws HistorialEquiposException {
        try{
            String change = elemento.getEstado().equals("ACTIVO") ? "INACTIVO" : "ACTIVO";
            if (elemento.getDisponible() == 0){
                throw new PersistenceException("Un elemento asociado a un equipo no se puede dar de baja.");
            }
            elementoDAO.cambiarEstadoElemento(elemento.getIdElemento(),change);
            if (change.equals("INACTIVO")){
                serviciosNovedad.insertarNovedad(new Novedad("Elemento dado de baja","El elemento con id "+ elemento.getIdElemento() +" de tipo " + elemento.getTipo() + " fue dado de baja.",idUsuario,elemento.getIdElemento(), null) );
            }
            else{
                serviciosNovedad.insertarNovedad(new Novedad("Elemento activo","El elemento con id "+ elemento.getIdElemento() +" de tipo " + elemento.getTipo() + " fue activado otra vez.",idUsuario,elemento.getIdElemento(), null) );
            }
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException);
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
    public void asociarElementoEquipo(int idUsuario, List<Elemento> elementosSeleccionados, Integer idEquipo) throws HistorialEquiposException {
        try{
            ArrayList<String> evalElemento = new ArrayList<String>();
            //Testeando esta mondá
            Equipo evalEquipo = serviciosEquipo.consultarEquipo(idEquipo);
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
                        serviciosNovedad.insertarNovedad( new Novedad("Retiro de elemento","El elemento con id " + q.getIdElemento() + " de tipo " + q.getTipo() + " fue retirado del equipo"+ q.getIdEquipo() +".",idUsuario,q.getIdElemento(),idEquipo));
                        break;
                    }
                }
                elementoDAO.asociarEquipo(e.getIdElemento(),idEquipo);
                serviciosNovedad.insertarNovedad(new Novedad("Asociacion elemento-equipo","El elemento con id "+ e.getIdElemento() +" de tipo " + e.getTipo() + " fue asociado al equipo con id " + idEquipo +".",idUsuario,e.getIdElemento(),idEquipo));
            }
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException);
        }
    }
    /*
    INSERT
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
}