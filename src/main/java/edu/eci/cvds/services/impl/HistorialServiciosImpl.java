package edu.eci.cvds.services.impl;


import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.ElementoDAO;
import edu.eci.cvds.persistence.mybatis.dao.NovedadDAO;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;
import javax.inject.Inject;
import java.util.List;

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
    public void insertarElemento(String tipo, String nombre, String descripcion, int cantidad) throws HistorialEquiposException {
        try{
            Elemento elemento = new Elemento(tipo, nombre, descripcion, cantidad );
            elementoDAO.registrarElemento( elemento );
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

}
