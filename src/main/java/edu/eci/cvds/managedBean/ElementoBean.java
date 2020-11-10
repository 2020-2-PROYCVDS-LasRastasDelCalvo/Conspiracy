package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
@ManagedBean(name = "elementoBean")
@SessionScoped
public class ElementoBean extends BasePageBean {
    @Inject
    private HistorialServicios historialServicios;

    private int idEquipo;
    private String message;
    private FacesMessage.Severity estado;
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
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void registrarElemento(){
        try {
            sinErrores();
            historialServicios.insertarElemento( tipo, nombre, descripcion);
            restablecer();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void asociarEquipo(){
        System.out.println("entre al bean Elemento");
    }

    public void restablecer(){
        tipo = null ;
        nombre =null;
        descripcion = null;
    }

    public void conErrores( String message){
        this.message = message;
        estado = FacesMessage.SEVERITY_WARN;
    }

    public void sinErrores( ){
        this.message = "Se registro de forma exitosa.";
        estado = FacesMessage.SEVERITY_INFO;
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

    public void actualizar(){
        try{
            elementos = historialServicios.consultarElementos();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    /**
     * Metodo que muestra en un mensaje del estado del registrar elemento
     */
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(estado, "Registrar", message));
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}
