package org.encuestadocente.entities;

public class Curso {
	
	private int id;
	private String nombre;
	private int idCarreraProfesional;
	private String docenteNombres;
	private int idAlumnoGrupo;
	
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
	public String getDocenteNombres() {
		return docenteNombres;
	}
	public void setDocenteNombres(String docenteNombres) {
		this.docenteNombres = docenteNombres;
	}
	public int getIdAlumnoGrupo() {
		return idAlumnoGrupo;
	}
	public void setIdAlumnoGrupo(int idAlumnoGrupo) {
		this.idAlumnoGrupo = idAlumnoGrupo;
	}
}
