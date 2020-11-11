package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.HistorialServicios;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
    private List<Elemento> elementosSeleccionados;
    private Usuario usuario;
    private Subject subject = SecurityUtils.getSubject();
    private Elemento elementoBaja;

    @PostConstruct
    public void init(){
        super.init();
        try{
            usuario= historialServicios.consultarUsuarioPorCorreo((String) subject.getSession().getAttribute("correo"));
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
        try {
            sinErrores();
            historialServicios.asociarElementoEquipo(usuario.getIdUsuario(), elementosSeleccionados, idEquipo );
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void restablecer(){
        tipo = null ;
        nombre =null;
        descripcion = null;
    }

    public void actualizar(){
        try{
            sinErrores();
            elementos = historialServicios.consultarElementos();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void cambiarEstadoElemento(){
        try{
            sinErrores();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Error en cambiarEstadoElemento en ElementoBean.");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            historialServicios.cambiarEstadoElemento( usuario.getIdUsuario(),elementoBaja);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Pasé el metodo de cambiar estado PELOTUDO.");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        catch (Exception exception) {
            conErrores( "Hubo un error al cambiar el estado del elemento HIJUEPUTA.");
        }
    }

    /**
     * Metodo que muestra en un mensaje del estado del registrar elemento
     */
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(estado, "Registrar", message));
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

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public List<Elemento> getElementosSeleccionados() {
        return elementosSeleccionados;
    }

    public void setElementosSeleccionados(List<Elemento> elementosSeleccionados) {
        this.elementosSeleccionados = elementosSeleccionados;
    }

    public Elemento getElementoBaja() {
        return elementoBaja;
    }

    public void setElementoBaja(Elemento elementoBaja) {
        this.elementoBaja = elementoBaja;
    }
}
