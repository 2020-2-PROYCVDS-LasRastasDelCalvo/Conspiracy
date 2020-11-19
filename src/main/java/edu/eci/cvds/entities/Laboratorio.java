package edu.eci.cvds.entities;

import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class Laboratorio {
    private int idLaboratorio;
    private String nombre;
    private String estado;
    private ArrayList<Equipo> equipos;

    public Laboratorio(){ }

    public Laboratorio(int idLaboratorio, String nombre,String estado ){
        this.idLaboratorio = idLaboratorio;
        this.nombre = nombre;
        this.equipos = new ArrayList<Equipo>();
    }

    public Laboratorio(int idLaboratorio, String nombre, ArrayList<Equipo> equipos,String estado){
        this.idLaboratorio = idLaboratorio;
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
