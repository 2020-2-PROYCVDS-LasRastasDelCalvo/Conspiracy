package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Elemento;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 31/10/2020
 */
public interface ElementoDao {
    public void registrarElemento(Elemento elemento);
    public ArrayList<Elemento> consultarElementos();
    public int consultarElementoDisponible();
    public void asociarEquipo();


}

