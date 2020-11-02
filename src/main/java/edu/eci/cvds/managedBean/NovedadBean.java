package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/31/2020
 */

@SuppressWarnings("deprecation")
@ManagedBean(name = "novedad")
@RequestScoped
public class NovedadBean  extends BasePageBean {
    @Inject
    private HistorialServicios historialServicios;
    private List<Novedad> novedades;

    @PostConstruct
    public void init(){
        super.init();
        try {
            novedades = historialServicios.consultarNovedades();
        } catch (HistorialEquiposException e) {
            e.printStackTrace();
        }
    }
    public void consultar(){
        novedades = null;
        try{
            novedades = historialServicios.consultarNovedades();
        }
        catch (Exception exception) {
        }
    }

    public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        this.novedades = novedades;
    }
}
