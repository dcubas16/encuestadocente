package org.encuestadocente.entities;

public class Usuario {

	private int id;
	private String email;
	private String password;
	private int idTipoUsuario;
	private int estado;
	private String idAlumno;
	private String nombres;
	private String apPaterno;
	private String apMaterno;
	private String numDocIdent;	
	private int idAdministrativo;
	private String admNombres;
	private String admApPaterno;
	private String admApMaterno;
	private String admNumDocIdent;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getNumDocIdent() {
		return numDocIdent;
	}
	public void setNumDocIdent(String numDocIdent) {
		this.numDocIdent = numDocIdent;
	}
	public String getAdmNombres() {
		return admNombres;
	}
	public void setAdmNombres(String admNombres) {
		this.admNombres = admNombres;
	}
	public String getAdmApPaterno() {
		return admApPaterno;
	}
	public void setAdmApPaterno(String admApPaterno) {
		this.admApPaterno = admApPaterno;
	}
	public String getAdmApMaterno() {
		return admApMaterno;
	}
	public void setAdmApMaterno(String admApMaterno) {
		this.admApMaterno = admApMaterno;
	}
	public String getAdmNumDocIdent() {
		return admNumDocIdent;
	}
	public void setAdmNumDocIdent(String admNumDocIdent) {
		this.admNumDocIdent = admNumDocIdent;
	}
	public void setIdAdministrativo(int idAdministrativo) {
		this.idAdministrativo = idAdministrativo;
	}
	public int getIdAdministrativo() {
		return idAdministrativo;
	}
	
}
