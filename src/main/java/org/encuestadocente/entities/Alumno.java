package org.encuestadocente.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "ALUMNO", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
@Inheritance(strategy=InheritanceType.JOINED)
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="ID")
	private String id;
	
	@Column(name = "NOMBRES", nullable = false)
	private String nombres;
	
	@Column(name = "AP_PATERNO", nullable = false)
	private String apPaterno;

	@Column(name = "AP_MATERNO", nullable = false)
	private String apMaterno;

	@Column(name = "NUM_DOC_IDENT", nullable = false)
	private String numDocIdent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
