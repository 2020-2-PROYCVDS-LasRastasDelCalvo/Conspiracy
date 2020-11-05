package edu.eci.cvds.services;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
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

    public List<Elemento> consultarElementos() throws HistorialEquiposException;

    public void insertarElemento(String tipo, String nombre, String descripcion) throws HistorialEquiposException;

    public List<Equipo> consultarEquipos() throws HistorialEquiposException;

    public void insertarEquipo( int torreSeleccionada, int mouseSeleccionado, int pantallaSeleccionada, int tecladoSeleccionado ) throws HistorialEquiposException;


}