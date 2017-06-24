package org.encuestadocente.entities;

public class Grupo {

	private int id;
	private String nombre;
	private int idCarreraProfesional;
	private int idGrupo;
	private String nombreGrupo;
	private int idDocente;
	private String docenteApPaterno;
	private String docenteApMaterno;
	private String docenteNombres;
	private String docenteNumDocIdent;
	private String docenteNombreCompleto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdCarreraProfesional() {
		return idCarreraProfesional;
	}
	public void setIdCarreraProfesional(int idCarreraProfesional) {
		this.idCarreraProfesional = idCarreraProfesional;
	}
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNombreGrupo() {
		return nombreGrupo;
	}
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public String getDocenteApPaterno() {
		return docenteApPaterno;
	}
	public void setDocenteApPaterno(String docenteApPaterno) {
		this.docenteApPaterno = docenteApPaterno;
	}
	public String getDocenteApMaterno() {
		return docenteApMaterno;
	}
	public void setDocenteApMaterno(String docenteApMaterno) {
		this.docenteApMaterno = docenteApMaterno;
	}
	public String getDocenteNombres() {
		return docenteNombres;
	}
	public void setDocenteNombres(String docenteNombres) {
		this.docenteNombres = docenteNombres;
	}
	public String getDocenteNumDocIdent() {
		return docenteNumDocIdent;
	}
	public void setDocenteNumDocIdent(String docenteNumDocIdent) {
		this.docenteNumDocIdent = docenteNumDocIdent;
	}
	public String getDocenteNombreCompleto() {
		return docenteNombreCompleto;
	}
	public void setDocenteNombreCompleto(String docenteNombreCompleto) {
		this.docenteNombreCompleto = docenteNombreCompleto;
	}
}
