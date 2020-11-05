package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.EquipoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.EquipoMapper;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/2/2020
 */
public class MyBATISEquipoDAO implements EquipoDAO {
    @Inject
    private EquipoMapper equipoMapper;

    @Override
    public void registrarEquipo(int idLab) throws PersistenceException {
        try{
            equipoMapper.registrarEquipo(idLab);
        }
        catch (Exception exception){
            throw new PersistenceException("Surgio un error al Registrar el equipo.",exception);
        }
    }

    @Override
    public ArrayList<Equipo> consultarEquipos() throws PersistenceException {
        try{
            return equipoMapper.consultarEquipos();
        }
        catch (Exception exception){
            throw new PersistenceException("Surgio un error al consultar los equipos.",exception);
        }
    }

    @Override
    public void generarNovedades(int idEquipo, int idElemento, String titulo, String detalle, int idUsuario) throws PersistenceException {
        try{
            equipoMapper.generarNovedades(idEquipo, idElemento, titulo, detalle, idUsuario);
        }
        catch (Exception exception){
            throw new PersistenceException("Surgio un error al Registrar el equipo.",exception);
        }
    }
}
