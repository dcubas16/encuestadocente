package org.encuestadocente.dao;

import java.util.List;

import org.encuestadocente.entities.CabeceraEncuesta;
import org.encuestadocente.entities.DetallePreguntaAlumnoGrupo;
import org.encuestadocente.entities.Encuesta;
import org.encuestadocente.entities.RespuestaTransaccion;

public interface EncuestaDAO {

	CabeceraEncuesta obtenerCabeceraEncuesta(String idAlumno);

	RespuestaTransaccion guardarEncuesta(DetallePreguntaAlumnoGrupo[] listaDetalle);

	List<DetallePreguntaAlumnoGrupo> obtenerDetallesEncuestaAlumnoGrupo(int idAlumnoGrupo, int idEncuesta);

	Encuesta obtenerEncuestaActiva();

}
