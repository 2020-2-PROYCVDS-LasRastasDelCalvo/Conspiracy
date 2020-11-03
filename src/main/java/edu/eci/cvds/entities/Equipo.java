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
    private int disponible;
    private int idLab;
    private Date fechaRegistro;
    private ArrayList<Elemento>elementos;
    private ArrayList<Novedad> novedades;

    public Equipo(){
    }
    public Equipo(int idEquipo, int idLab, Date fechaRegistro, int disponible, ArrayList<Novedad>novedades){
        this.idEquipo = idEquipo;
        this.fechaRegistro = fechaRegistro;
        this.disponible = disponible;
        this.elementos = new ArrayList<Elemento>();
        this.idLab = idLab;
        this.novedades = novedades;
    }

    public Equipo(int idEquipo, int idLab, Date fechaRegistro, int disponible, ArrayList<Elemento>elementos, ArrayList<Novedad> novedades ){
       this.idEquipo = idEquipo;
       this.fechaRegistro = fechaRegistro;
       this.disponible = disponible;
       this.elementos = elementos;
       this.idLab = idLab;
       this.novedades = novedades;
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

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public void setNovedades(ArrayList<Novedad> novedades) {
        this.novedades = novedades;
    }

    public ArrayList<Novedad> getNovedades() {
        return novedades;
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }
}
