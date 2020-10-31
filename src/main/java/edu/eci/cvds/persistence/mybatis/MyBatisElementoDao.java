package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.ElementoDao;
import edu.eci.cvds.persistence.mybatis.mappers.ElementoMapper;

import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 31/10/2020
 */
public class MyBatisElementoDao implements ElementoDao {
    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public void registrarElemento(Elemento elemento){
        elementoMapper.registrarElemento(elemento);
    }

    @Override
    public ArrayList<Elemento> consultarElementos() {
        return elementoMapper.consultarElementos();
    }
}
