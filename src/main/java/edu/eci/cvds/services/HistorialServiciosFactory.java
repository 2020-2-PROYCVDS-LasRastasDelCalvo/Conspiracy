package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.mybatis.MyBATISElementoDAO;
import edu.eci.cvds.persistence.mybatis.MyBATISEquipoDAO;
import edu.eci.cvds.persistence.mybatis.MyBATISNovedadDAO;
import edu.eci.cvds.persistence.mybatis.dao.ElementoDAO;
import edu.eci.cvds.persistence.mybatis.dao.EquipoDAO;
import edu.eci.cvds.persistence.mybatis.dao.NovedadDAO;
import edu.eci.cvds.security.Log;
import edu.eci.cvds.security.ShiroLogger;
import edu.eci.cvds.services.impl.HistorialServiciosImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class HistorialServiciosFactory {

    private static HistorialServiciosFactory instance = new HistorialServiciosFactory();
    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);

                bind(Log.class).to(ShiroLogger.class);
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(EquipoDAO.class).to(MyBATISEquipoDAO.class);
                bind(HistorialServicios.class).to(HistorialServiciosImpl.class);
            }
        });
    }

    private HistorialServiciosFactory(){
        optInjector = Optional.empty();
    }

    public HistorialServicios getHistorialServicios(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(HistorialServicios.class);
    }


    public HistorialServicios getHistorialServiciosTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(HistorialServicios.class);
    }


    public static HistorialServiciosFactory getInstance(){
        return instance;
    }

}