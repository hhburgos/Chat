package Modelo;

import java.io.Serializable;
import java.util.Date;

public class Mensaje implements Serializable {

	private String ipEmisor, ipDestinatario, nickname, mensaje;
	private Date momento;
	
	public Mensaje (String ipEmisor, String ipDestinatario, String nickname, String mensaje) {
		this.nickname = nickname;
		this.ipEmisor = ipEmisor;
		this.ipDestinatario = ipDestinatario;
		this.mensaje = mensaje;
		momento = new Date();
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


	public Date getMomento() {
		return momento;
	}


	public void setMomento(Date momento) {
		this.momento = momento;
	}


}
