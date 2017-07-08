package org.encuestadocente.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PREGUNTA", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
@Inheritance(strategy=InheritanceType.JOINED)
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="ID")
	private int id;
	
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;
	
	@Column(name = "ORDEN", nullable = false)
	private int orden;
	
	@Column(name = "ID_CRITERIO", nullable = false)
	private int idCriterio;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public int getIdCriterio() {
		return idCriterio;
	}
	public void setIdCriterio(int idCriterio) {
		this.idCriterio = idCriterio;
	}
}
