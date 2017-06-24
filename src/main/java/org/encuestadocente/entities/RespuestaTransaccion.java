package org.encuestadocente.entities;

public class RespuestaTransaccion {

	private boolean esExito;
	private String mensaje;
	
	public RespuestaTransaccion(boolean esExito, String mensaje) {
		super();
		this.esExito = esExito;
		this.mensaje = mensaje;
	}
	
	public boolean isEsExito() {
		return esExito;
	}
	public void setEsExito(boolean esExito) {
		this.esExito = esExito;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
