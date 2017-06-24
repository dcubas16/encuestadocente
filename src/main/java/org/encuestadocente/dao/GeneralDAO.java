package org.encuestadocente.dao;

import java.util.List;

import org.encuestadocente.entities.CarreraProfesional;
import org.encuestadocente.entities.Criterio;
import org.encuestadocente.entities.Curso;
import org.encuestadocente.entities.Facultad;
import org.encuestadocente.entities.Grupo;
import org.encuestadocente.entities.Pregunta;

public interface GeneralDAO {

	List<Curso> obtenerCursosPorAlumno(String idAlumno);
	List<Criterio> obtenerListaCriterios(int idEncuesta);
	List<Pregunta> obtenerListaPreguntas(int idEncuesta);
	String obtenerInstruccion(int idEncuesta);
	List<Facultad> obtenerFacultades();
	List<CarreraProfesional> obtenerCarrerasProfesionalesPorFacultad(int idFacultad);
	List<Curso> obtenerCursosPorCarreraProfesional(int idCarreraProfesional);
	List<Grupo> obtenerGruposPorCurso(int idCurso);

}
