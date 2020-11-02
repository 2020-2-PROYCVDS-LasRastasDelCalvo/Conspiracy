package edu.eci.cvds.entities;

import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class Elemento {
    private int idElemento;
    private String tipo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private ArrayList<Novedad> novedades;

    public Elemento(){

    }
    public Elemento( String tipo, String nombre, String descripcion, int cantidad){
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.novedades = new ArrayList<Novedad>();
    }

    public Elemento(int id, String tipo, String nombre, String descripcion, int cantidad){
        this.idElemento = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.novedades = new ArrayList<Novedad>();
    }

    public Elemento(int id, String tipo, String nombre, String descripcion, ArrayList<Novedad> novedades, int cantidad){
        this.idElemento = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.novedades = novedades;
    }

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(ArrayList<Novedad> novedades) {
        this.novedades = novedades;
    }

    public int getCantidad() { return cantidad;}

    public void setCantidad(int cantidad) { this.cantidad = cantidad;}
}
