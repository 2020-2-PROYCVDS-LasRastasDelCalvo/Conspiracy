package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/31/2020
 */
public interface NovedadDAO  {

    /**
     * Metodo que consulta todas la novedades que se encuentran en la base de datos ordenada de la mas reciente a las mas antigua.
     * @return List<Novedad>, lista de novedades.
     */
    public List<Novedad> cargarNovedades() throws PersistenceException;

    /**
     * Metodo que consulta el historial de novedades que ha tenido un equipo especifico
     * @param idEquipo, int que representa el identificador del equipo
     * @return  List<Novedad>, la lista de novedades que posee ese equipo
     */
    public List<Novedad> cargarNovedadesEquipo( @Param("idEquipo") int idEquipo )  throws PersistenceException;


    /**
     * Metodo que consulta el historial de novedades que ha tenido un elemento especifico
     * @param idElemento, int que representa el identificador del elemento
     * @return  List<Novedad>, la lista de novedades que posee ese equipo
     */
    public List<Novedad> cargarNovedadesElemento( @Param("idElemento") int idElemento ) throws PersistenceException;

    /**
     * Metodo que se encarga de añadir una nueva novedad para un equipo en la base de datos
     * @param novedad, Novedad novedad a insertar en la base de datos
     * @param idEquipo, int id del equipo al cual se le insertara la novedad
     */
    public void guardarNovedadEquipo( @Param("novedad") Novedad novedad, @Param("idEquipo") int idEquipo ) throws PersistenceException;

    /**
     * Metodo que se encarga de añadir una nueva novedad para un elemento en la base de datos
     * @param novedad, Novedad novedad a insertar en la base de datos
     * @param idEquipo, int id del equipo al cual se le insertara la novedad
     * @param idElemento, , int id del elemento al cual se le insertara la novedad
     */
    public void guardarNovedadElemento( @Param("novedad") Novedad novedad, @Param("idEquipo") int idEquipo, @Param("idElemento") int idElemento ) throws PersistenceException;
}
