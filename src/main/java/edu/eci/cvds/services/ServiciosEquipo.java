package edu.eci.cvds.services;

import edu.eci.cvds.entities.*;

import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/12/2020
 */

public interface ServiciosEquipo {
    /*
    SELECT
     */
    public List<Equipo> consultarEquipos() throws HistorialEquiposException;

    public List<Equipo> consultarEquiposDisponibles() throws HistorialEquiposException;

    public Equipo consultarEquipo(int idEquipo) throws HistorialEquiposException;

    /*
    INSERT
     */
    public void insertarEquipo(Integer idEquipo,int[] elementos, int idLab, int idUsuario) throws HistorialEquiposException;

    /*
    UPDATE
     */
    public void asociarEquipo(int idLab, int idEquipo) throws HistorialEquiposException;

    public void asociarEquipoLabExistente( List<Equipo> equipos, int idUsuario, int idLab)throws HistorialEquiposException;
}
