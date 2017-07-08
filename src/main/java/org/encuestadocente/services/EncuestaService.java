package org.encuestadocente.services;

import java.util.List;

import org.encuestadocente.entities.CabeceraEncuesta;
import org.encuestadocente.entities.Criterio;
import org.encuestadocente.entities.DetallePreguntaAlumnoGrupo;
import org.encuestadocente.entities.Encuesta;
import org.encuestadocente.entities.Pregunta;
import org.encuestadocente.entities.RespuestaTransaccion;

public interface EncuestaService {

	CabeceraEncuesta obtenerCabeceraEncuesta(String idAlumno);
	RespuestaTransaccion guardarEncuesta(DetallePreguntaAlumnoGrupo[] listaDetalle);
	List<DetallePreguntaAlumnoGrupo> obtenerDetallesEncuestaAlumnoGrupo(int idAlumnoGrupo, int idEncuesta);
	Encuesta obtenerEncuestaActiva();
	Encuesta guardarEncuesta(String nombre, String instrucciones);
	Criterio guardarCriterio(Criterio criterio);
	boolean eliminarCriterio(int idEncuesta, int idCriterio);
	Pregunta guardarPregunta(Pregunta pregunta);

}
