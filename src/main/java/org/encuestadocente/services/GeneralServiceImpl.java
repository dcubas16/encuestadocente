package org.encuestadocente.services;

import java.util.List;

import org.encuestadocente.dao.GeneralDAO;
import org.encuestadocente.entities.Curso;
import org.encuestadocente.entities.Encuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralServiceImpl implements GeneralService {

	@Autowired
	private GeneralDAO generalDAO;
	
	@Override
	public List<Curso> obtenerCursosPorAlumno(String idAlumno) {
	
		return generalDAO.obtenerCursosPorAlumno(idAlumno);
	}

	@Override
	public Encuesta obtenerEncuesta(int idEncuesta) {
		
		Encuesta encuesta = new Encuesta();
		
		encuesta.setListaCriterio(generalDAO.obtenerListaCriterios(idEncuesta));
		encuesta.setListaPregunta(generalDAO.obtenerListaPreguntas(idEncuesta));
		encuesta.setInstruccion(generalDAO.obtenerInstruccion(idEncuesta));
				
		return encuesta;
	}

}
