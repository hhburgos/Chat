package Modelo;

import java.io.Serializable;

public class Perfil implements Serializable {
	
	private String nickname;
	private String ip;
	private String mensaje; 
	//foto
	
	public Perfil (String ip, String nickname, String mensaje) {
		this.nickname = nickname;
		this.ip = ip;
		this.mensaje = mensaje;
	}
	
	
// GETTERS Y SETTERS	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


}
