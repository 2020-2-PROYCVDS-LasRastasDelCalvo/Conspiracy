package edu.eci.cvds.services;

import edu.eci.cvds.entities.Novedad;
import java.util.List;
/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/12/2020
 */

public interface ServiciosNovedad {
    /*
    SELECT
     */
    public List<Novedad> consultarNovedades() throws HistorialEquiposException;

    /*
    INSERT
     */
    public void insertarNovedad(Novedad novedad) throws  HistorialEquiposException;
}
