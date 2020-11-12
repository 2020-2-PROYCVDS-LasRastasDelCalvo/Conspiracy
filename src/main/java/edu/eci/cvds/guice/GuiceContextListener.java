package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.persistence.mybatis.dao.*;
import edu.eci.cvds.security.Log;
import edu.eci.cvds.security.ShiroLogger;
import edu.eci.cvds.services.*;
import edu.eci.cvds.services.impl.*;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // TODO Add service class associated to Stub implementation
                bind(Log.class).to(ShiroLogger.class);
                //DAO
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(EquipoDAO.class).to(MyBATISEquipoDAO.class);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(LaboratorioDAO.class).to(MYBATISLaboratorioDAO.class);
                //Servicios
                bind(HistorialServicios.class).to(HistorialServiciosImpl.class);
                bind(ServiciosEquipo.class).to(ServiciosEquipoImpl.class);
                bind(ServiciosElemento.class).to(ServiciosElementoImpl.class);
                bind(ServiciosLaboratorio.class).to(ServiciosLaboratorioImpl.class);
                bind(ServiciosNovedad.class).to(ServiciosNovedadImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}