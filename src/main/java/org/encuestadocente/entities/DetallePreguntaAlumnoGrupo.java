package org.encuestadocente.entities;

public class DetallePreguntaAlumnoGrupo {


	private int id;
	private int idPregunta;
	private int idAlumnoGrupo;
	private int valor;
	
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public int getIdAlumnoGrupo() {
		return idAlumnoGrupo;
	}
	public void setIdAlumnoGrupo(int idAlumnoGrupo) {
		this.idAlumnoGrupo = idAlumnoGrupo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
