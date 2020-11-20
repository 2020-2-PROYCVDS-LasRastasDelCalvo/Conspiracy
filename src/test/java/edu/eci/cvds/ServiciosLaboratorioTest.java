package edu.eci.cvds;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServiciosFactory;
import edu.eci.cvds.services.ServiciosLaboratorio;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/19/2020
 */
public class ServiciosLaboratorioTest {
    @Inject
    private ServiciosLaboratorio serviciosLaboratorio;

    public ServiciosLaboratorioTest() {
        serviciosLaboratorio = HistorialServiciosFactory.getInstance().getServiciosLaboratorioTesting();
    }

    /*
    CONSULTAR
    */
    @Test
    public void consultarLaboratorios() throws HistorialEquiposException {
        List<Laboratorio> laboratorios = serviciosLaboratorio.consultarLaboratorios();
        Assert.assertTrue( laboratorios.size() != 0 );
    }

    @Test
    public void deberiaConsultarLaboratorio() throws HistorialEquiposException{
        int idLab = 2;

        Laboratorio laboratorio = serviciosLaboratorio.consultarLaboratorio( idLab );
        Assert.assertEquals(laboratorio.getIdLaboratorio().intValue(),idLab);
    }

    @Test
    public void noDeberiaEncontrarLaboratorio() throws HistorialEquiposException{
        int idLab = -1;

        Laboratorio laboratorio = serviciosLaboratorio.consultarLaboratorio( idLab );
        Assert.assertTrue(laboratorio == null );
    }

    /*
    INSERT
     */
    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaRegistrarLaboratorioPoridRepetido() throws HistorialEquiposException {
        int idUsuario = 10048240;
        int idLab = new Integer(2);
        String nombreLab = "Laboratorio Prueba";
        serviciosLaboratorio.registrarLaboratorio(idUsuario,idLab,nombreLab,null);
        fail();
    }

    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaRegistrarLaboratorioPornombreRepetido() throws HistorialEquiposException {
        int idUsuario = 10048240;
        int idLab = new Integer(2);
        String nombreLab = "Ingeniería de Software";
        serviciosLaboratorio.registrarLaboratorio(idUsuario,idLab,nombreLab,null);
        fail();

    }

    @Test
    public void deberiaRegistrarLaboratorio() throws HistorialEquiposException {
        int idUsuario = 10048240;
        int idLab = new Integer(77);
        String nombreLab = "Laboratorio Prueba";
        try{
            serviciosLaboratorio.registrarLaboratorio(idUsuario, idLab, nombreLab, null );
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            Assert.assertTrue( serviciosLaboratorio.consultarLaboratorio(idLab) != null );
        }
    }


/**
    public void cambiarEstado(int idUsuario, Laboratorio laboratorioSeleccionado) throws HistorialEquiposException {
        try{
            String estado = ( laboratorioSeleccionado.getEstado().equals("ABIERTO")) ? "CERRADO":"ABIERTO";
            laboratorioDAO.cambiarEstado(laboratorioSeleccionado, estado);
            if( estado.equals("CERRADO") && laboratorioSeleccionado.getIdLaboratorio() != 1){
                for( Equipo equipo: laboratorioSeleccionado.getEquipos()){
                    serviciosEquipo.asociarEquipo(1, equipo.getIdEquipo());
                    serviciosNovedad.insertarNovedad( new Novedad(" Retiro de equipo de laboratorio","El equipo con id "+equipo.getIdEquipo()+" fue retirado del laboratorio "+laboratorioSeleccionado.getNombre(),idUsuario,null,equipo.getIdEquipo()));
                }
            }
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }
*/
}