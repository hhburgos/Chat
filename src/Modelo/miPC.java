package Modelo;

import java.net.InetAddress;

import java.net.UnknownHostException;
//import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class miPC {
    //static private final Logger LOGGER = Logger.getLogger("mx.com.hash.checkip.CheckIP");

    public static String obtenerIP() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        return ip.getHostAddress();
    }
    
//    static public void main(String[] args) throws UnknownHostException {
//    	System.out.println(miPC.obtenerIP());   
//    	
//    }    
    
//    public static void main(String[] args) {
//    	Date date = new Date();
//    	//Caso 1: obtener la hora y salida por pantalla con formato:
//    	DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//    	System.out.println("Hora: "+hourFormat.format(date));
//    	//Caso 2: obtener la fecha y salida por pantalla con formato:
//    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//    	System.out.println("Fecha: "+dateFormat.format(date));
//    	//Caso 3: obtenerhora y fecha y salida por pantalla con formato:
//    	DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
//    	System.out.println("Hora y fecha: "+hourdateFormat.format(date));
//    }

    public static String dameHM (Date d) {
    	DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    	return hourFormat.format(d);
    }
}