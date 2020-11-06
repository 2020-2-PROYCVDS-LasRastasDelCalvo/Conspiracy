package edu.eci.cvds.services;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 *
 * Clase que representa las posibles excepciones que pueden encontrarse en el servicio Historial de Equipos
 */
public class HistorialEquiposException extends Exception{
    public static final  String NO_CLIENTE = "No existe un cliente con ese id en la base de datos.";

    public HistorialEquiposException(String message,Exception exception){
        super(message,exception);
    }
    public HistorialEquiposException(){
        super();
    }
    public HistorialEquiposException(String message){
        super(message);
    }
}
