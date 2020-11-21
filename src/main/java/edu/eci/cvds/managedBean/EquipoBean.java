package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.HistorialServicios;
import edu.eci.cvds.services.ServiciosElemento;
import edu.eci.cvds.services.ServiciosEquipo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/2/2020
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "equipoBean")
@SessionScoped
public class EquipoBean extends BasePageBean {
    @Inject
    private HistorialServicios historialServicios;

    @Inject
    private ServiciosEquipo serviciosEquipo;

    @Inject
    private ServiciosElemento serviciosElemento;

    private Subject subject = SecurityUtils.getSubject();
    private int disponible;
    private int laboratorio;
    private int idEquipo;
    private int idLab;
    private String message;
    private Elemento torreSeleccionada;
    private Elemento mouseSeleccionado;
    private Elemento pantallaSeleccionada;
    private Elemento tecladoSeleccionado;
    private Usuario usuario;
    private List<Elemento> tablaTorre;
    private List<Elemento> tablaMouse;
    private List<Elemento> tablaPantalla;
    private List<Elemento> tablaTeclado;
    private FacesMessage.Severity estado;
    private Equipo equipoSeleccionado;
    private List<Equipo> equiposSeleccionados;
    private List<Equipo> equipos;
    private List<Equipo> equipSeleccionados;

    @PostConstruct
    public void init(){
        super.init();
        try{
            usuario= historialServicios.consultarUsuarioPorCorreo((String) subject.getSession().getAttribute("correo"));
            subject.getSession().setAttribute("usuario",usuario);
            actualizar();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    private boolean elementosSel(){
        boolean sirve = true;
        if (torreSeleccionada == null){
            sirve = false;
        }
        if (mouseSeleccionado== null){
            sirve = false;}
        if (pantallaSeleccionada== null){
                sirve = false;}
        if (tecladoSeleccionado== null){
                    sirve = false;}
        return sirve;
    }

    public void registrarEquipo(){
        try {
            sinErrores();
            if (!elementosSel()){
                throw new Exception("Debe de seleccionar un elemento de cada tipo para poder registrar el equipo");
            }
            int[] elementos = {torreSeleccionada.getIdElemento(),mouseSeleccionado.getIdElemento(),pantallaSeleccionada.getIdElemento(),tecladoSeleccionado.getIdElemento()};
            serviciosEquipo.insertarEquipo(idEquipo,elementos,laboratorio,usuario.getIdUsuario());
        }
        catch (Exception exception) {
            conErrores(exception.getMessage());
        }
    }

    public void conErrores( String message){
        this.message = message;
        estado = FacesMessage.SEVERITY_WARN;
    }

    public void sinErrores( ){
        this.message = "Se registro de forma exitosa.";
        estado = FacesMessage.SEVERITY_INFO;
    }


    public void actualizar(){
        try{
            sinErrores();
            equipos = serviciosEquipo.consultarEquipos();
            tablaTorre = serviciosElemento.buscarElemento("Torre");
            tablaMouse = serviciosElemento.buscarElemento("Mouse");
            tablaPantalla = serviciosElemento.buscarElemento("Pantalla");
            tablaTeclado = serviciosElemento.buscarElemento("Teclado");
            equipos = serviciosEquipo.consultarEquipos();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void asociarEquipLab(){
        try{
            sinErrores();
            serviciosEquipo.asociarEquipoLabExistente( equipSeleccionados, usuario.getIdUsuario(), idLab);
        }
        catch (Exception exception){
            conErrores( exception.getMessage() );
        }
    }

    public void cambiarEstadoEquipo(){
        try{
            sinErrores();
            for( Equipo equipo: equiposSeleccionados){
                serviciosEquipo.cambiarEstadoEquipo(usuario.getIdUsuario(),equipo);
            }

        }
        catch (Exception exception){
            conErrores( exception.getMessage() );
        }
    }

    public void actualizarEquiposDispo(){
        try{
            sinErrores();
            equipos = serviciosEquipo.consultarEquiposActivos();
        }
        catch (Exception exception){
            conErrores( exception.getMessage() );
        }
    }

    /**
     * Metodo que muestra en un mensaje del estado del registrar elemento
     */
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(estado, "Registrar", message));
    }

    public HistorialServicios getHistorialServicios() {
        return historialServicios;
    }

    public void setHistorialServicios(HistorialServicios historialServicios) { this.historialServicios = historialServicios; }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public int getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(int laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Elemento getTorreSeleccionada() {
        return torreSeleccionada;
    }

    public void setTorreSeleccionada(Elemento torreSeleccionada) {
        this.torreSeleccionada = torreSeleccionada;
    }

    public Elemento getMouseSeleccionado() {
        return mouseSeleccionado;
    }

    public void setMouseSeleccionado(Elemento mouseSeleccionado) {
        this.mouseSeleccionado = mouseSeleccionado;
    }

    public Elemento getPantallaSeleccionada() {
        return pantallaSeleccionada;
    }

    public void setPantallaSeleccionada(Elemento pantallaSeleccionada) { this.pantallaSeleccionada = pantallaSeleccionada; }

    public Elemento getTecladoSeleccionado() {
        return tecladoSeleccionado;
    }

    public void setTecladoSeleccionado(Elemento tecladoSeleccionado) {
        this.tecladoSeleccionado = tecladoSeleccionado;
    }

    public FacesMessage.Severity getEstado() {
        return estado;
    }

    public void setEstado(FacesMessage.Severity estado) {
        this.estado = estado;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Elemento> getTablaTorre() {
        return tablaTorre;
    }

    public void setTablaTorre(List<Elemento> tablaTorre) {
        this.tablaTorre = tablaTorre;
    }

    public List<Elemento> getTablaMouse() {
        return tablaMouse;
    }

    public void setTablaMouse(List<Elemento> tablaMouse) {
        this.tablaMouse = tablaMouse;
    }

    public List<Elemento> getTablaPantalla() {
        return tablaPantalla;
    }

    public void setTablaPantalla(List<Elemento> tablaPantalla) {
        this.tablaPantalla = tablaPantalla;
    }

    public List<Elemento> getTablaTeclado() {
        return tablaTeclado;
    }

    public void setTablaTeclado(List<Elemento> tablaTeclado) {
        this.tablaTeclado = tablaTeclado;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public List<Equipo> getEquipSeleccionados() {
        return equipSeleccionados;
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    public void setEquipSeleccionados(List<Equipo> equipSeleccionados) {
        this.equipSeleccionados = equipSeleccionados;
    }

    public Equipo getEquipoSeleccionado() { return equipoSeleccionado; }

    public List<Equipo> getEquiposSeleccionados() {
        return equiposSeleccionados;
    }

    public void setEquiposSeleccionados(List<Equipo> equiposSeleccionados) {
        this.equiposSeleccionados = equiposSeleccionados;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) { this.equipoSeleccionado = equipoSeleccionado; }
}


