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

public interface ServiciosLaboratorio {
    /*
    SELECT
     */
    public List<Laboratorio> consultarLaboratorios() throws HistorialEquiposException;

    public Laboratorio consultarLaboratorio(int idLab) throws HistorialEquiposException;

    /*
    INSERT
     */
    public void registrarLaboratorio(int idUsuario,int idLab, String nombreLab, List<Equipo> aAsociar) throws HistorialEquiposException;
}
