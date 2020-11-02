package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.services.HistorialServicios;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 29/10/2020
 */

@SuppressWarnings("deprecation")
@ManagedBean(name = "elemento")
@RequestScoped
public class ElementoBean extends BasePageBean {
    @Inject
    private HistorialServicios historialServicios;

    private String tipo;
    private String nombre;
    private String descripcion;
    private String[] opciones = {"Torre","Pantalla","Mouse","Teclado"};
    private List<Elemento> elementos;

    @PostConstruct
    public void init(){
        super.init();
        try{
            elementos = historialServicios.consultarElementos();
        }
        catch (Exception exception){
        }
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
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

    public List<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(List<Elemento> elementos) {
        this.elementos = elementos;
    }
}
