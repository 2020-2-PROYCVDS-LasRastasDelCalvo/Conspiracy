package edu.eci.cvds.managedBean;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.HistorialServicios;
import edu.eci.cvds.services.ServiciosEquipo;
import edu.eci.cvds.services.ServiciosLaboratorio;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.model.chart.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Random;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/6/2020
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "laboratorioBean")
@SessionScoped
public class LaboratorioBean extends BasePageBean {
    @Inject
    private HistorialServicios historialServicios;

    @Inject
    private ServiciosLaboratorio serviciosLaboratorio;

    @Inject
    private ServiciosEquipo serviciosEquipo;

    private int idLaboratorio;
    private String nombreLaboratorio;
    private String message;
    private Laboratorio labSelec;
    private Usuario usuario;
    private List<Equipo> aAsociar;
    private List<Laboratorio> laboratorios;
    private List<Laboratorio> laboratoriosSeleccionados;
    private List<Equipo> disponibles;
    private PieChartModel pieModel;
    private BarChartModel barModel;
    private FacesMessage.Severity estado;
    private Subject subject = SecurityUtils.getSubject();

    @PostConstruct
    public void init() {
        super.init();
        try {
            usuario= historialServicios.consultarUsuarioPorCorreo((String) subject.getSession().getAttribute("correo"));
            actualizar();
            createBarModel();
            createPieModel();
        } catch (Exception exception) {
            conErrores(exception.getMessage());
        }
    }

    private PieChartModel  createPieModel() {
        pieModel = new PieChartModel();

        pieModel.set("Abiertos",serviciosLaboratorio.consultarNumeroLaboratoriosPorEstado("ABIERTO"));
        pieModel.set("Cerrados",serviciosLaboratorio.consultarNumeroLaboratoriosPorEstado("CERRADO"));
        pieModel.setTitle("");
        pieModel.setShowDataLabels(true);
        pieModel.setDataLabelFormatString("%dK");
        pieModel.setLegendPosition("e");
        pieModel.setShowDatatip(true);
        pieModel.setShowDataLabels(true);
        pieModel.setDataFormat("value");
        pieModel.setDataLabelFormatString("%d");
        pieModel.setSeriesColors("ff8c00,87cefa");
        return pieModel;

    }

    private BarChartModel createBarModel(){
        barModel = new BarChartModel();
        ChartSeries serie = new BarChartSeries();
        for(Laboratorio lab: laboratorios){
            serie.set(lab.getNombre(), lab.getEquipos().size());
        }
        barModel.addSeries(serie);
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Laboratorios");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad equipos");
        yAxis.setMin(0);
        return barModel;
    }

    private String randomColor(){
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);

        // format it as hexadecimal string and print
        String colorCode = String.format("#%06x", rand_num);
        return colorCode;
    }

    public void actualizar(){
        try{
            sinErrores();
            laboratorios = serviciosLaboratorio.consultarLaboratorios();
            disponibles = serviciosEquipo.consultarEquiposDisponibles();
            pieModel = createPieModel();
            barModel = createBarModel();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void registrarLab(){
        try{
            sinErrores();
            serviciosLaboratorio.registrarLaboratorio(usuario.getIdUsuario(),idLaboratorio, nombreLaboratorio, aAsociar);
        }
        catch (Exception exception){
            conErrores(exception.getMessage());
        }
    }

    public void cambiarEstado(){
        try{
            sinErrores();
            for(Laboratorio laboratorio:laboratoriosSeleccionados){
                serviciosLaboratorio.cambiarEstado(usuario.getIdUsuario(),laboratorio);
            }
            actualizar();
        }
        catch( Exception exception){
            conErrores(exception.getMessage());
        }
    }

    public void cambiarEstadoIndividual(){
        try{
            sinErrores();
            serviciosLaboratorio.cambiarEstado(usuario.getIdUsuario(),labSelec);
            actualizar();
        }
        catch( Exception exception){
            conErrores(exception.getMessage());
        }
    }

    public void conErrores( String message ){
        this.message = message;
        estado = FacesMessage.SEVERITY_WARN;
    }

    public void sinErrores( ){
        this.message = "Se registro de forma exitosa.";
        estado = FacesMessage.SEVERITY_INFO;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }

    public FacesMessage.Severity getEstado() {
        return estado;
    }

    public void setEstado(FacesMessage.Severity estado) {
        this.estado = estado;
    }

    /**
     * Metodo que muestra en un mensaje del estado del registrar elemento
     */
    public void info() { FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(estado, "Registrar", message)); }

    public List<Equipo> getaAsociar() { return aAsociar; }

    public void setaAsociar(List<Equipo> aAsociar) { this.aAsociar = aAsociar; }

    public List<Equipo> getDisponibles() { return disponibles; }

    public void setDisponibles(List<Equipo> disponibles) { this.disponibles = disponibles; }

    public Laboratorio getLabSelec() {
        return labSelec;
    }

    public void setLabSelec(Laboratorio labSelec) {
        this.labSelec = labSelec;
    }

    public List<Laboratorio> getLaboratoriosSeleccionados() {
        return laboratoriosSeleccionados;
    }

    public void setLaboratoriosSeleccionados(List<Laboratorio> laboratoriosSeleccionados) {
        this.laboratoriosSeleccionados = laboratoriosSeleccionados;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
}
