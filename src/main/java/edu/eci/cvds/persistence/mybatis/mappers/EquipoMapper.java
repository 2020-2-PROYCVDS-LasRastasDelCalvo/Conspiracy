package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface EquipoMapper {

    public void registrarEquipo( @Param("equipo") Equipo equipo) throws PersistenceException;
    public ArrayList<Equipo> consultarEquipos()  throws PersistenceException;
    public void generarNovedades( @Param("idEquipo") int idEquipo, @Param("idElemento") int idElemento, @Param("titulo") String titulo, @Param("detalle") String detalle, @Param("idUsuario") int idUsuario )  throws PersistenceException;
}
