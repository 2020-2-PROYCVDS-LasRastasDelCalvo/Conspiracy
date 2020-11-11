package edu.eci.cvds.services;

import edu.eci.cvds.entities.*;

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

    public void insertarEquipo(int idEquipo,int[] elementos, int idLab, int idUsuario) throws HistorialEquiposException;

    public void relacionarElementoEquipo(int idElemento, int idEquipo) throws HistorialEquiposException;

    public List<Elemento> buscarElemento(String elemento) throws  HistorialEquiposException;

    public void insertarNovedad(Novedad novedad) throws  HistorialEquiposException;

    public Usuario consultarUsuarioPorCorreo(String correo )throws  HistorialEquiposException;

    public List<Laboratorio> consultarLaboratorios() throws HistorialEquiposException;


    public void registrarLaboratorio(int idUsuario,int idLab, String nombreLab, List<Equipo> aAsociar) throws HistorialEquiposException;

    public void asociarEquipo(int idLab, int idEquipo) throws HistorialEquiposException;

    public List<Equipo> consultarEquiposDisponibles() throws HistorialEquiposException;

    public void asociarEquipoLabExistente( List<Equipo> equipos, int idUsuario, int idLab)throws HistorialEquiposException;

    public void asociarElementoEquipo(int idUsuario,List<Elemento> elementosSeleccionados,Integer idEquipo ) throws HistorialEquiposException;

    public Equipo consultarEquipo(int idEquipo) throws HistorialEquiposException;

    public void darDeBajaElemento( int idUsuario, Elemento elemento )throws HistorialEquiposException;
}