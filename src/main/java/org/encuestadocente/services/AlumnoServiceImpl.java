package org.encuestadocente.services;

import org.encuestadocente.dao.AlumnoDAO;
import org.encuestadocente.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoDAO alumnoDAO;
	
	
	@Override
	public Alumno obtenerAlumno() {

		Alumno alumno = alumnoDAO.obtenerAlumno();
		return alumno;
	}

}
