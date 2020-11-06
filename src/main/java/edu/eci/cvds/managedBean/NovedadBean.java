package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
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
    private HistorialServicios historialServicios;
    private List<Novedad> novedades;

    @PostConstruct
    public void init(){
        super.init();
        consultar();
    }
    public void consultar(){
        try{
            novedades = historialServicios.consultarNovedades();
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
