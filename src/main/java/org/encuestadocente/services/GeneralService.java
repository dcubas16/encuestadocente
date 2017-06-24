package org.encuestadocente.services;

import java.util.List;
import org.encuestadocente.entities.Curso;
import org.encuestadocente.entities.Encuesta;

public interface GeneralService {

	public List<Curso> obtenerCursosPorAlumno(String idAlumno);
	public Encuesta obtenerEncuesta(int idEncuesta);
}
