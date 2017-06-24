package org.encuestadocente.entities;

import java.util.List;

public class Encuesta {
	
	private int id;
	
	private String nombre;
	
	private String instruccion;

	private List<Criterio> listaCriterio;
	
	private List<Pregunta> listaPregunta;
	
	private int estado;

	public List<Criterio> getListaCriterio() {
		return listaCriterio;
	}

	public void setListaCriterio(List<Criterio> listaCriterio) {
		this.listaCriterio = listaCriterio;
	}

	public List<Pregunta> getListaPregunta() {
		return listaPregunta;
	}

	public void setListaPregunta(List<Pregunta> listaPregunta) {
		this.listaPregunta = listaPregunta;
	}

	public String getInstruccion() {
		return instruccion;
	}

	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}

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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
