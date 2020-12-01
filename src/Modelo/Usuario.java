package Modelo;

import java.net.UnknownHostException;

public class Usuario {
	
	private String ipServer, nickname, correo; // + foto
	
	public Usuario (String correo, String ipServer) {
		this.correo = correo;
		this.ipServer = ipServer;
		//this.nickname = 
		
//		try {
//			this.ipServer = miPC.obtenerIP();
//		} 
//		catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
