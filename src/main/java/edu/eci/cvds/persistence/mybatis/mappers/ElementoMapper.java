package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Elemento;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 31/10/2020
 */
public interface ElementoMapper {

    public void registrarElemento(@Param("tipo") Elemento elemento);

}
