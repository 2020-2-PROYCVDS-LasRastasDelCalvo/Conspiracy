package edu.eci.cvds;

import com.google.inject.Inject;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;
import edu.eci.cvds.services.HistorialServiciosFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

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
            historialServicios.consultarElementos();
        } catch (HistorialEquiposException historialEquiposException) {
            fail();
        }
    }
    /**
    @Test
    public void deberiaRegistrarElEquipo() throws HistorialEquiposException{
        int[] elementos = {6,7,8,9};
        historialServicios.insertarEquipo( 13,elementos, 1 );
    }
    **/
    @Test( expected = HistorialEquiposException.class )
    public void deberiaFallarAlRegistrarElEquipoPorElementoInvalido() throws HistorialEquiposException{
        //deberia dar error ya que no existe el elemnto con id 101
        int[] elementos = {101,6,7,8};
        historialServicios.insertarEquipo( 14,elementos, 1 );
    }

    @Test( expected = HistorialEquiposException.class )
    public void deberiaFallarAlRegistrarElEquipoPorElementoYaAsignado() throws HistorialEquiposException{
        //esta prueba deberia fallar ya que los elementos que se intentan asociar al equipo, No se encuentran disponibles
        // torre, mouse, pantalla , teclado
        int[] elementos = {1,3,2,4};
        historialServicios.insertarEquipo( 14,elementos, 1 );
    }
}
