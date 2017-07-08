package org.encuestadocente.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.InheritanceType;


@Entity
@Table(name = "ENCUESTA", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
@Inheritance(strategy=InheritanceType.JOINED)
public class Encuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="ID")
	private int id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "INSTRUCCIONES", nullable = false)
	private String instruccion;
	
	@Column(name = "ESTADO", nullable = false)
	private int estado;

	@Transient
	private List<Criterio> listaCriterio;
	
	@Transient
	private List<Pregunta> listaPregunta;
	
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
