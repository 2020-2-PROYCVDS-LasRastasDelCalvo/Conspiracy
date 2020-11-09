package edu.eci.cvds.entities;

import java.sql.Date;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class Novedad {
    private int idNovedad;
    private int idUsuario;
    private int idEquipo;
    private Integer idElemento;
    private  String titulo;
    private String detalle;
    private String correo;
    private Date fecha;

    public Novedad(){}

    public  Novedad(int idNovedad, String titulo, String detalle, Date fecha, int idUsuario, Integer idElemento, int idEquipo, String correo){
        this.idNovedad = idNovedad;
        this.titulo = titulo;
        this.detalle = detalle;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idElemento = idElemento;
        this.idEquipo = idEquipo;
        this.correo = correo;
    }

    public  Novedad( String titulo, String detalle, int idUsuario, int idEquipo){
        this.titulo = titulo;
        this.detalle = detalle;
        this.idUsuario = idUsuario;
        this.idEquipo = idEquipo;
        //setFecha();
    }

    public  Novedad( String titulo, String detalle, int idUsuario, Integer idElemento, int idEquipo){
        this.titulo = titulo;
        this.detalle = detalle;
        this.idUsuario = idUsuario;
        this.idElemento = idElemento;
        this.idEquipo = idEquipo;
        //setFecha();
    }

    public  Novedad(int idNovedad, String titulo, String detalle, int idUsuario,  Integer idElemento, int idEquipo, String correo){
        this.idNovedad = idNovedad;
        this.titulo = titulo;
        this.detalle = detalle;
        this.idUsuario = idUsuario;
        this.idElemento = idElemento;
        this.idEquipo = idEquipo;
        this.correo = correo;
        setFecha();
    }

    public Date getFecha() { return fecha; }

    public void setFecha() {
        long millis=System.currentTimeMillis();
        fecha = new java.sql.Date(millis);
    }

    public int getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(int idNovedad) {
        this.idNovedad = idNovedad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
