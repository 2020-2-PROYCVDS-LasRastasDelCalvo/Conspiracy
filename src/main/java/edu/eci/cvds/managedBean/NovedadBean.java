package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.HistorialServicios;
import edu.eci.cvds.services.ServiciosNovedad;

import javax.annotation.PostConstruct;
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
            exception.printStackTrace();
        }
    }

    public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        this.novedades = novedades;
    }
}
