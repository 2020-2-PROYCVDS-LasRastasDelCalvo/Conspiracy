package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.*;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.ServiciosNovedad;

import javax.inject.Inject;
import java.util.List;

public class ServiciosNovedadImpl implements ServiciosNovedad {
    @Inject
    private NovedadDAO novedadDAO;

    /*
    SELECT
     */
    @Override
    public List<Novedad> consultarNovedades() throws HistorialEquiposException {
        try{
            return novedadDAO.cargarNovedades();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }
    /*
    INSERT
     */
    @Override
    public void insertarNovedad(Novedad novedad) throws HistorialEquiposException {
        try{
            novedadDAO.guardarNovedadEquipo( novedad );
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }
}
