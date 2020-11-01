package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.HistorialServicios;
import javax.faces.bean.ManagedBean;
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
@SessionScoped
public class NovedadBean  extends BasePageBean {
    @Inject
    private HistorialServicios historialServicios;
    private List<Novedad> novedades;

    public List<Novedad> consultar(){
        try{
            if( novedades == null ){
                 novedades = historialServicios.consultarNovedades();
            }
            return novedades;
        }
        catch (Exception exception) {
        }
        return null;
    }

    public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        this.novedades = novedades;
    }
}
