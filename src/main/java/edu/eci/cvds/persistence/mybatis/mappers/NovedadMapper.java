package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Novedad;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/31/2020
 */
public interface NovedadMapper {

    /**
     * Metodo que consulta todas la novedades que se encuentran en la base de datos ordenada de la mas reciente a las mas antigua.
     */
    public void consultarNovedades();

    /**
     * Metodo que consulta el historial de novedades que ha tenido un equipo especifico
     * @param idEquipo, int que representa el identificador del equipo
     * @return  List<Novedad>, la lista de novedades que posee ese equipo
     */
    public void consultarNovedadEquipo( @Param("idEquipo") int idEquipo );


    /**
     * Metodo que consulta el historial de novedades que ha tenido un elemento especifico
     * @param idElemento, int que representa el identificador del elemento
     * @return  List<Novedad>, la lista de novedades que posee ese equipo
     */
    public List<Novedad> consultarNovedadElemento( @Param("idElemento") int idElemento );

    /**
     * Metodo que se encarga de añadir una nueva novedad para un equipo en la base de datos
     * @param novedad, Novedad novedad a insertar en la base de datos
     * @param idEquipo, int id del equipo al cual se le insertara la novedad
     */
    public void addNovedadEquipo( @Param("novedad") Novedad novedad, @Param("idEquipo") int idEquipo );

    /**
     * Metodo que se encarga de añadir una nueva novedad para un elemento en la base de datos
     * @param novedad, Novedad novedad a insertar en la base de datos
     * @param idEquipo, int id del equipo al cual se le insertara la novedad
     * @param idElemento, , int id del elemento al cual se le insertara la novedad
     */
    public void addNovedadElemento( @Param("novedad") Novedad novedad, @Param("idEquipo") int idEquipo, @Param("idElemento") int idElemento );
    
}
