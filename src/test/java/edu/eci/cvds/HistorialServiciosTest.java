package edu.eci.cvds;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;
import edu.eci.cvds.services.HistorialServiciosFactory;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/5/2020
 */
public class HistorialServiciosTest {

    @Inject
    private HistorialServicios historialServicios;


    public HistorialServiciosTest() {
        historialServicios = HistorialServiciosFactory.getInstance().getHistorialServiciosTesting();
    }
    /*
    @Before
    public void setUp() {
    }
    */

    @Test
    public void consultarUsuarioSinError() throws HistorialEquiposException {
        String correo = "admin";
        Usuario u = historialServicios.consultarUsuarioPorCorreo(correo);
        Assert.assertEquals(u.getCorreo(), correo);
    }



}
