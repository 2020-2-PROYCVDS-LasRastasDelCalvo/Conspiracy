package edu.eci.cvds.services;

import edu.eci.cvds.entities.Novedad;

import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/31/2020
 */
public interface HistorialServicios {
    public List<Novedad> consultarNovedades() throws HistorialEquiposException;
}