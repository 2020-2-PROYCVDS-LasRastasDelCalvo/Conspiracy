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

    private int idUsuario;
    private int idElemento;
    private int idEquipo;
    private String correo;


    public  Novedad(int id, String titulo, String detalle, Date fecha, int idUsuario, int idElemento, int idEquipo, String correo){
        this.idNovedad = id;
        this.titulo = titulo;
        this.detalle = detalle;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idElemento = idElemento;
        this.idEquipo = idEquipo;
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
