package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
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
 * @version 11/2/2020
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "equipoBean")
@SessionScoped
public class EquipoBean extends BasePageBean {
    @Inject
    private HistorialServicios historialServicios;

    private int disponible;
    private int laboratorio;
    private String message;
    private Elemento torreSeleccionada;
    private Elemento mouseSeleccionado;
    private Elemento pantallaSeleccionada;
    private Elemento tecladoSeleccionado;
    private List<Elemento> tablaTorre;
    private List<Elemento> tablaMouse;
    private List<Elemento> tablaPantalla;
    private List<Elemento> tablaTeclado;
    private FacesMessage.Severity estado;
    private List<Equipo> equipos;


    @PostConstruct
    public void init(){
        super.init();
        try{
            System.out.println("Trying to init() on EquipoBean mah boi.");
            equipos = historialServicios.consultarEquipos();
            tablaTorre = historialServicios.buscarElemento("Torre");
            tablaMouse = historialServicios.buscarElemento("Mouse");
            tablaPantalla = historialServicios.buscarElemento("Pantalla");
            tablaTeclado = historialServicios.buscarElemento("Teclado");
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    private boolean messirve(){
        boolean sirve = true;
        if (torreSeleccionada == null){
            sirve = false;
        }
        if (mouseSeleccionado== null){
            sirve = false;}

            if (pantallaSeleccionada== null){
                sirve = false;}

                if (tecladoSeleccionado== null){
                    sirve = false;}
                return sirve;
    }

    public void registrarEquipo(){
        try {
            historialServicios.insertarEquipo();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void conErrores( String message){
        this.message = message;
        estado = FacesMessage.SEVERITY_WARN;
    }

    public void sinErrores( ){
        this.message = "Se registro de forma exitosa.";
        estado = FacesMessage.SEVERITY_INFO;
    }


    public void actualizar(){
        try{
            System.out.println("Trying to actualizar() on EquipoBean mah boi.");
            equipos = historialServicios.consultarEquipos();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            conErrores( exception.getMessage());
        }
    }

    /**
     * Metodo que muestra en un mensaje del estado del registrar elemento
     */
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(estado, "Registrar", message));
    }

    public HistorialServicios getHistorialServicios() {
        return historialServicios;
    }

    public void setHistorialServicios(HistorialServicios historialServicios) {
        this.historialServicios = historialServicios;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public int getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(int laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Elemento getTorreSeleccionada() {
        return torreSeleccionada;
    }

    public void setTorreSeleccionada(Elemento torreSeleccionada) {
        this.torreSeleccionada = torreSeleccionada;
    }

    public Elemento getMouseSeleccionado() {
        return mouseSeleccionado;
    }

    public void setMouseSeleccionado(Elemento mouseSeleccionado) {
        this.mouseSeleccionado = mouseSeleccionado;
    }

    public Elemento getPantallaSeleccionada() {
        return pantallaSeleccionada;
    }

    public void setPantallaSeleccionada(Elemento pantallaSeleccionada) {
        this.pantallaSeleccionada = pantallaSeleccionada;
    }

    public Elemento getTecladoSeleccionado() {
        return tecladoSeleccionado;
    }

    public void setTecladoSeleccionado(Elemento tecladoSeleccionado) {
        this.tecladoSeleccionado = tecladoSeleccionado;
    }

    public FacesMessage.Severity getEstado() {
        return estado;
    }

    public void setEstado(FacesMessage.Severity estado) {
        this.estado = estado;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Elemento> getTablaTorre() {
        return tablaTorre;
    }

    public void setTablaTorre(List<Elemento> tablaTorre) {
        this.tablaTorre = tablaTorre;
    }

    public List<Elemento> getTablaMouse() {
        return tablaMouse;
    }

    public void setTablaMouse(List<Elemento> tablaMouse) {
        this.tablaMouse = tablaMouse;
    }

    public List<Elemento> getTablaPantalla() {
        return tablaPantalla;
    }

    public void setTablaPantalla(List<Elemento> tablaPantalla) {
        this.tablaPantalla = tablaPantalla;
    }

    public List<Elemento> getTablaTeclado() {
        return tablaTeclado;
    }

    public void setTablaTeclado(List<Elemento> tablaTeclado) {
        this.tablaTeclado = tablaTeclado;
    }
}


