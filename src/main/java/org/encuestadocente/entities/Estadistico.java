package org.encuestadocente.entities;

public class Estadistico {

	private int idGrupo;
	private int encuestaId;
	private int criterioId;
	private int preguntaId;
	private int valorEncuesta;
	private int conteoValor;
	
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public int getEncuestaId() {
		return encuestaId;
	}
	public void setEncuestaId(int encuestaId) {
		this.encuestaId = encuestaId;
	}
	public int getCriterioId() {
		return criterioId;
	}
	public void setCriterioId(int criterioId) {
		this.criterioId = criterioId;
	}
	public int getPreguntaId() {
		return preguntaId;
	}
	public void setPreguntaId(int preguntaId) {
		this.preguntaId = preguntaId;
	}
	public int getValorEncuesta() {
		return valorEncuesta;
	}
	public void setValorEncuesta(int valorEncuesta) {
		this.valorEncuesta = valorEncuesta;
	}
	public int getConteoValor() {
		return conteoValor;
	}
	public void setConteoValor(int conteoValor) {
		this.conteoValor = conteoValor;
	}
}
