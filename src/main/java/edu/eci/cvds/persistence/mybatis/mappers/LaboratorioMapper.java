package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/6/2020
 */
public interface LaboratorioMapper {
    /**
     * Metodo que consulta los laboratorios existentes en la base de datos
     * @throws PersistenceException, en caso que ocurra un error de persistencia
     */
    public List<Laboratorio> consultarLaboratorios() throws PersistenceException;

    public void registrarLaboratorio(@Param ("idLab")int idLab, @Param ("nombreLab") String nombreLab) throws PersistenceException;
}
