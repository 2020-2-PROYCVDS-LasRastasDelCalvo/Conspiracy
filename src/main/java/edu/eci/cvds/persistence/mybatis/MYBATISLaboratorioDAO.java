package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.LaboratorioDAO;
import edu.eci.cvds.persistence.mybatis.mappers.LaboratorioMapper;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/6/2020
 */
public class MYBATISLaboratorioDAO implements LaboratorioDAO {
    @Inject
    private LaboratorioMapper laboratorioMapper;

    @Override
    public List<Laboratorio> consultarLaboratorios() throws PersistenceException {
        try{
            return laboratorioMapper.consultarLaboratorios();
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar los laboratorios en la base de datos",exception );
        }

    }

    @Override
    public void registrarLaboratorio(int idLab, String nombreLab) throws PersistenceException {
        try{
            System.out.println("I'm trying to registrarLaboratorio(int idLab, String nombreLab) at MYBATISLaboratorioDAO.");
            laboratorioMapper.registrarLaboratorio(idLab, nombreLab);
        }
        catch (Exception exception){
            throw new PersistenceException(exception.getMessage(),exception );
        }
    }

}
