package edu.eci.cvds.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import com.google.inject.Inject;
import javax.servlet.http.HttpSession;
import edu.eci.cvds.security.Log;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 28/10/2020
 * @version 2.0 29/10/2020
 * Clase encargada del logg-in con la seguridad de apache shiro
 */

@SuppressWarnings("deprecation")
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean extends BasePageBean  {
    @Inject
    private Log log;
    private String correo;
    private String contraseña;
    private Subject usuarioActual;
    private String message;
    private FacesMessage.Severity estado;
    /**
     * Metodo que realiza el login del usuario
     * FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"log","Usuario desconocido."));
     */
    public void doLogIn(){
        try{
            sinErrores();
            usuarioActual = SecurityUtils.getSubject();
            if (log.isLogged()) {
                System.out.println("Ya esta loggeado----------------------------");
                //throw new HistorialEquiposException("Ya estas loggeado");//solo atrapar los errores.
            }
            else {
                log.login(correo, contraseña, false);
                redireccionar();
            }
        }
        catch( Exception exception){
            message = exception.getMessage();
            estado = FacesMessage.SEVERITY_WARN;
            restablecer();
        }
    }

    /**
     * metodo que establece los mensajes a mostrar en caso que no exista un error
     */
    public void sinErrores(){
        message ="Login exitoso";
        estado = FacesMessage.SEVERITY_INFO;
    }

    /**
     * Metodo que redirecciona al usuario a una pagina, dependiendo de su rol
     */
    public void redireccionar() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            if (esAdmin()) {
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("correo", correo);
                facesContext.getExternalContext().redirect("../admin/admin.xhtml");
            }
            else if (esUsuario()) {
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("correo", correo);
                facesContext.getExternalContext().redirect("../usuario/usuario.xhtml");
            }
        }
        catch (Exception exception) {
            logOut();
        }
    }

    /**
     * Metodo que cierra la sesion del usuario actual
     */
    public void logOut(){
        try{
            log.logout();
            restablecer();
        }
        catch(Exception exception){
        }
    }

    /**
     * Funcion que retorna si el rol del usuario actual es Admin
     * @return boolean, que dice si el rol del usuario actual es Admin
     */
    public boolean esAdmin() {
        return usuarioActual.hasRole("administrador");
    }

    /**
     * Funcion que retorna si el rol del usuario actual es Usuario
     * @return  boolean, que dice si el rol del usuario actual es Usuario
     */
    public boolean esUsuario() {
        return usuarioActual.hasRole("usuario");
    }

    /**
     * Metodo que retorna el correo que el usuario ingreso
     * @return String, cadena que representa el correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo que establece el correo del usuario
     * @param correo, String que representa el correo a establecer
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo que establece la contraseña del usuario
     * @param contraseña, String que representa la contraseña del usuario
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Metodo que retorna la contraseña del usuario
     * @return String, cadena que representa la contraseña del usuario
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * metodo que restablece los valores de los input
     */
    public void restablecer(){
        contraseña = "";
        correo = "";
    }

    /**
     * Metodo que muestra en un mensaje del estado del log in
     */
    public void estadoLogin() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(estado, "LogIn", message));
    }
}
