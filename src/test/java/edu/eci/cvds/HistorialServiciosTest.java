package edu.eci.cvds;

import com.google.inject.Inject;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;
import edu.eci.cvds.services.HistorialServiciosFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
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
    private SqlSession sqlSession;
    @Inject
    private HistorialServicios historialServicios;

    public HistorialServiciosTest() {
        historialServicios = HistorialServiciosFactory.getInstance().getHistorialServiciosTesting();
    }
    @Before
    public void setUp() {
    }

    @Test
    public void consultarElementos() {
        try {
            System.out.println(historialServicios.consultarElementos());
        } catch (HistorialEquiposException historialEquiposException) {
            historialEquiposException.printStackTrace();
        }
    }


}
