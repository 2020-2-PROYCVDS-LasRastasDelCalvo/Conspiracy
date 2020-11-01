package edu.eci.cvds.entities;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class Novedad {
    private int idNovedad;
    private  String titulo;
    private String detalle;
    private Date fecha;

    private String idUsuario;
    private String idElemento;
    private String idEquipo;
    private String nombreUsuario;


    public  Novedad(int id, String titulo, String detalle, Date fecha){
        this.idNovedad = id;
        this.titulo = titulo;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public  Novedad(int id, String titulo, String detalle){
        this.idNovedad = id;
        this.titulo = titulo;
        this.detalle = detalle;
        setFecha();
    }

    public int getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(int idNovedad) {
        this.idNovedad = idNovedad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() { return fecha; }

    public void setFecha() {
        long millis=System.currentTimeMillis();
        fecha = new java.sql.Date(millis);
    }

}
