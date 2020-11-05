package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistence.PersistenceException;
import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/2/2020
 */
public interface EquipoDAO {
    public void registrarEquipo(int idLab) throws PersistenceException;
    public ArrayList<Equipo> consultarEquipos()  throws PersistenceException;
    public void generarNovedades(int idEquipo, int idElemento, String titulo, String detalle, int idUsuario )  throws PersistenceException;

}
