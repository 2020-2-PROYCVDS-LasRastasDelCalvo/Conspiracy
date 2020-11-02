package edu.eci.cvds.persistence.mybatis.mappers;

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
public interface ElementoMapper {
    public ArrayList<Elemento> consultarElementos();
    public void registrarElemento(@Param("tipo") Elemento elemento);
    public void asociarEquipo(@Param("idEquipo") int idEquipo);//asociar  un equipo con un elemento disponible

}
