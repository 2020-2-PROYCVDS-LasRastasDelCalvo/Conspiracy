package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.ServiciosNovedad;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/31/2020
 */

@SuppressWarnings("deprecation")
@ManagedBean(name = "novedadBean")
@RequestScoped
public class NovedadBean  extends BasePageBean  implements Serializable {

    @Inject
    private ServiciosNovedad serviciosNovedad;

    private int idEquipo;
    private int idElemento;
    private String message;
    private FacesMessage.Severity estado;
    private List<Novedad> novedades;

    @PostConstruct
    public void init(){
        super.init();
        consultar();
    }
    public void consultar(){
        try{
            novedades = serviciosNovedad.consultarNovedades();
        }
        catch (Exception exception) {
        }
    }

    public void consultarPorEquipo(){
        try{
            novedades = serviciosNovedad.consultarPorEquipo(idEquipo);
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void consultarPorElemento(){
        try{
            novedades = serviciosNovedad.consultarPorElemento(idElemento);
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

    public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        this.novedades = novedades;
    }

    public int getIdEquipo() { return idEquipo; }

    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }

    public int getIdElemento() { return idElemento; }

    public void setIdElemento(int idElemento) { this.idElemento = idElemento; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public FacesMessage.Severity getEstado() { return estado; }

    public void setEstado(FacesMessage.Severity estado) { this.estado = estado; }
}
