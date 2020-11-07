package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Laboratorio;
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
 * @version 11/6/2020
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "laboratorioBean")
@SessionScoped
public class LaboratorioBean extends BasePageBean {
    @Inject
    private HistorialServicios historialServicios;

    private int idLaboratorio;
    private String nombreLaboratorio;
    private String message;
    private List<Laboratorio> laboratorios;
    private FacesMessage.Severity estado;

    @PostConstruct
    public void init() {
        super.init();
        try {
            actualizar();
        } catch (Exception exception) {
            conErrores(exception.getMessage());
        }
    }
    public void actualizar(){
        try{
            sinErrores();
            laboratorios = historialServicios.consultarLaboratorios();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void conErrores( String message ){
        this.message = message;
        estado = FacesMessage.SEVERITY_WARN;
    }

    public void sinErrores( ){
        this.message = "Se registro de forma exitosa.";
        estado = FacesMessage.SEVERITY_INFO;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }

    public FacesMessage.Severity getEstado() {
        return estado;
    }

    public void setEstado(FacesMessage.Severity estado) {
        this.estado = estado;
    }

    /**
     * Metodo que muestra en un mensaje del estado del registrar elemento
     */
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(estado, "Registrar", message));
    }

}
