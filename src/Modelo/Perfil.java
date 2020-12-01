package Modelo;

import java.io.Serializable;

public class Perfil implements Serializable {

	private String nickname;
	private String ipEmisor;
	private String ipDestinatario;
	private String mensaje; 
	//foto
	
	public Perfil (String ipEmisor, String ipDestinatario, String nickname, String mensaje) {
		this.nickname = nickname;
		this.ipEmisor = ipEmisor;
		this.ipDestinatario = ipDestinatario;
		this.mensaje = mensaje;
	}
	
	
// GETTERS Y SETTERS	
	
	public String getIpEmisor() {
		return ipEmisor;
	}

	public void setIpEmisor(String ipEmisor) {
		this.ipEmisor = ipEmisor;
	}

	public String getIpDestinatario() {
		return ipDestinatario;
	}

	public void setIpDestinatario(String ipDestinatario) {
		this.ipDestinatario = ipDestinatario;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


}
