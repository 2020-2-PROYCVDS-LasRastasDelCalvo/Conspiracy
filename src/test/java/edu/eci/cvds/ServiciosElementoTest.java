package edu.eci.cvds;

import com.google.inject.Inject;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServiciosFactory;
import edu.eci.cvds.services.ServiciosElemento;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/12/2020
 */
public class ServiciosElementoTest {
    @Inject
    private ServiciosElemento serviciosElemento;


    public ServiciosElementoTest() {
        serviciosElemento = HistorialServiciosFactory.getInstance().getServiciosElementoTesting();
    }

    @Test
    public void consultarElementos() {
        try {
            serviciosElemento.consultarElementos();
        } catch (HistorialEquiposException historialEquiposException) {
            fail();
        }
    }
}
