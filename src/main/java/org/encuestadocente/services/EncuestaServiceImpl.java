package org.encuestadocente.services;

import java.util.List;

import org.encuestadocente.dao.EncuestaDAO;
import org.encuestadocente.entities.CabeceraEncuesta;
import org.encuestadocente.entities.DetallePreguntaAlumnoGrupo;
import org.encuestadocente.entities.Encuesta;
import org.encuestadocente.entities.RespuestaTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncuestaServiceImpl implements EncuestaService {

	@Autowired	
	private EncuestaDAO encuestaDAO;

	@Override 
	public CabeceraEncuesta obtenerCabeceraEncuesta(String idAlumno) {
		return encuestaDAO.obtenerCabeceraEncuesta(idAlumno);
	}

	@Override
	public RespuestaTransaccion guardarEncuesta(DetallePreguntaAlumnoGrupo[] listaDetalle) {
		return encuestaDAO.guardarEncuesta(listaDetalle);
	}

	@Override
	public List<DetallePreguntaAlumnoGrupo> obtenerDetallesEncuestaAlumnoGrupo(int idAlumnoGrupo, int idEncuesta) {
		return encuestaDAO.obtenerDetallesEncuestaAlumnoGrupo(idAlumnoGrupo, idEncuesta);
	}

	@Override
	public Encuesta obtenerEncuestaActiva() {
		return encuestaDAO.obtenerEncuestaActiva();
	}

}
