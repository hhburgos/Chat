package Modelo;

import java.net.InetAddress;
import java.net.UnknownHostException;
//import java.util.logging.Logger;

public class miPC {
    //static private final Logger LOGGER = Logger.getLogger("mx.com.hash.checkip.CheckIP");

    public static String obtenerIP() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        return ip.getHostAddress();
    }
    
    static public void main(String[] args) throws UnknownHostException {
    	System.out.println(miPC.obtenerIP());        
    }    

}