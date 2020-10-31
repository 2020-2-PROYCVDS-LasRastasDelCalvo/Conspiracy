package edu.eci.cvds.entities;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class Equipo {

    private int idEquipo;
    private Date fechaRegistro;
    private int disponible;
    private ArrayList<Elemento>elementos;
    private ArrayList<Novedad> novedades;

    public Equipo(int idEquipo,Date fechaRegistro,int disponible,ArrayList<Elemento>elementos){
       this.idEquipo = idEquipo;
       this.fechaRegistro = fechaRegistro;
       this.disponible = disponible;
       this.elementos = elementos;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
}
