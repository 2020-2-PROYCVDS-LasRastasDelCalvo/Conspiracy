package edu.eci.cvds;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServiciosFactory;
import edu.eci.cvds.services.ServiciosElemento;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Test
    public void deberiaBuscarElementoPorTipo() throws HistorialEquiposException{
        String elemento = "Torre";
        Assert.assertTrue(serviciosElemento.buscarElemento(elemento).size() != 0 );
    }

    @Test
    public void noDeberiaEncontrarElementoPorTipo() throws HistorialEquiposException{
        String elemento = "No deberia existir.";
        Assert.assertTrue(serviciosElemento.buscarElemento(elemento).size() == 0 );
    }

    @Test
    public void deberiaCambiarEstadoElemento() throws HistorialEquiposException {
        String tipo = "Mouse";
        List<Elemento> elementos = serviciosElemento.buscarElemento(tipo);
        HashMap<String,String> estados = new HashMap<String,String>();
        String estado;
        for( Elemento elemento: elementos) {
            estado = (elemento.getEstado().equals("INACTIVO")) ? "ACTIVO" : "INACTIVO";
            String key = elemento.getIdElemento()+"";
            estados.put(key,estado);
            serviciosElemento.cambiarEstadoElemento( 10048240,elemento );
        }
        elementos = serviciosElemento.buscarElemento(tipo);
        for( Elemento elemento: elementos) {
            estado = elemento.getEstado();
            //Assert.assertFalse( estados.get(elemento.getIdElemento()+"") == estado );
        }
    }

    @Test
    public void noDeberiaCambiarEstadoElementoPorAsocia() throws HistorialEquiposException {
        //No se puede dar de baja a un elemento asociado a un equipo, se garantiza que solo se muestra los elementos disponibles
        List<Elemento> elementos = serviciosElemento.buscarElemento("Torre");
        for(Elemento elemento: elementos){
            if( elemento.getIdEquipo()!= null ){ elementos.remove(elemento);}
        }
        Assert.assertFalse(elementos.size() == 3);
    }

    @Test
    public void deberiaInsertarElemento() throws HistorialEquiposException {
        String elemento = "Esto es una prueba";
        serviciosElemento.insertarElemento("Torre",elemento,"Descripcion");
        // Assert.assertTrue( serviciosElemento.buscarElemento("Torre").size() >= 4 );
    }

    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaInsertarElementoPorTipoIncorrecto() throws HistorialEquiposException {
        //NO deberia dejarlo insetar por colocar un tipo diferente a torre, pantalla, teclado ..

        serviciosElemento.insertarElemento("Tipo Invalido","Nombre","Descripcion");
    }

    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaRelacionarElementoEquipoPorEquipoNoExistente() throws HistorialEquiposException {
        //deberia fallar ya que no existe el equipo con id 999
        serviciosElemento.asociarElementoEquipo(10048240 ,null,new Integer(999));
    }

    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaRelacionarElementoEquipoPorCantidadMaximaDeElementos() throws HistorialEquiposException {
        //Un equipo puede tener maximo 4 elementos
        ArrayList<Elemento> elementos = new ArrayList<Elemento>();
        for( int x =0 ; x< 5;x++){
            elementos.add(new Elemento());
        }
        serviciosElemento.asociarElementoEquipo(10048240 ,elementos,new Integer(1));
    }

    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaRelacionarElementoEquipoElementosDadosDeBaja() throws HistorialEquiposException {
        //Un equipo no puede relacionar elementos dados de baja
        ArrayList<Elemento> elementos = new ArrayList<Elemento>();
        String [] tipos = {"Torre","Pantalla","Mouse","Teclado"};
        for( int x =0 ; x< 4;x++){
            Elemento elemento = new Elemento();
            elemento.setTipo( tipos[x]);
            if( x%2 == 0){elemento.setEstado("INACTIVO"); }
            elementos.add(elemento);
        }
        serviciosElemento.asociarElementoEquipo(10048240 ,elementos,new Integer(1));
    }

    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaRelacionarElementoEquipoPorAsignarMismosTiposDeElementos() throws HistorialEquiposException {
        //un equipos puede tener maximo un elemento del mismo tipo

        ArrayList<Elemento> elementos = new ArrayList<Elemento>();
        String [] tipos = {"Torre","Torre","Mouse","Teclado"};
        for( int x =0 ; x< 4;x++){
            Elemento elemento = new Elemento();
            elemento.setTipo( tipos[x]);
            elemento.setEstado("ACTIVO");
            elementos.add(elemento);
        }
        serviciosElemento.asociarElementoEquipo(10048240 ,elementos,new Integer(4));
    }
}
