package org.encuestadocente.dao;

import java.util.List;

import org.encuestadocente.entities.CarreraProfesional;
import org.encuestadocente.entities.Criterio;
import org.encuestadocente.entities.Curso;
import org.encuestadocente.entities.Encuesta;
import org.encuestadocente.entities.Facultad;
import org.encuestadocente.entities.Grupo;
import org.encuestadocente.entities.Pregunta;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GeneralDAOImpl implements GeneralDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Curso> obtenerCursosPorAlumno(String idAlumno) {

		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT C.ID AS id " + ",C.NOMBRE AS nombre "
						+ ",C.id_carrera_prof  as idCarreraProfesional"
						+ ",CONCAT(D.ap_paterno, ' ', D.ap_Materno , ', ', D.nombreS) AS docenteNombres "
						+ ",DAG.ID AS idAlumnoGrupo " + "FROM CURSO C " + "INNER JOIN GRUPO G ON G.ID_CURSO = C.ID "
						+ "INNER JOIN DOCENTE D ON D.ID = G.ID_DOCENTE "
						+ "INNER JOIN DETALLE_ALUMNO_GRUPO DAG ON DAG.ID_GRUPO = G.ID "
						+ "INNER JOIN ALUMNO A ON DAG.ID_ALUMNO = A.ID " + "WHERE A.ID = :idAlumno ")
				.addScalar("id", StandardBasicTypes.INTEGER).addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("idCarreraProfesional", StandardBasicTypes.INTEGER)
				.addScalar("docenteNombres", StandardBasicTypes.STRING)
				.addScalar("idAlumnoGrupo", StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(Curso.class));

		query.setParameter("idAlumno", idAlumno);

		@SuppressWarnings("unchecked")
		List<Curso> listaCurso = query.list();

		return listaCurso;
	}

	@Override
	public List<Criterio> obtenerListaCriterios(int idEncuesta) {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT C.ID AS id " + ",C.DESCRIPCION AS descripcion  " + ",C.ORDEN AS orden  "
						+ ",C.PONDERACION AS ponderacion  " + ",C.ID_ENCUESTA AS idEncuesta  " + "FROM CRITERIO C "
						+ "WHERE C.ID_ENCUESTA = :idEncuesta " + "ORDER BY C.ORDEN")
				.addScalar("id", StandardBasicTypes.INTEGER).addScalar("descripcion", StandardBasicTypes.STRING)
				.addScalar("orden", StandardBasicTypes.INTEGER).addScalar("ponderacion", StandardBasicTypes.INTEGER)
				.addScalar("idEncuesta", StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(Criterio.class));

		query.setParameter("idEncuesta", idEncuesta);

		@SuppressWarnings("unchecked")
		List<Criterio> listaCriterio = query.list();

		return listaCriterio;
	}

	@Override
	public List<Pregunta> obtenerListaPreguntas(int idEncuesta) {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT P.ID AS id " + ",P.DESCRIPCION AS descripcion " + ",P.ORDEN AS orden "
						+ ",P.ID_CRITERIO AS idCriterio " + "FROM ENCUESTA E "
						+ "INNER JOIN CRITERIO C ON E.ID = C.ID_ENCUESTA "
						+ "INNER JOIN PREGUNTA P ON C.ID = P.ID_CRITERIO " + "WHERE E.ID = :idEncuesta "
						+ "ORDER BY P.ID_CRITERIO, P.ORDEN ")
				.addScalar("id", StandardBasicTypes.INTEGER).addScalar("descripcion", StandardBasicTypes.STRING)
				.addScalar("orden", StandardBasicTypes.INTEGER).addScalar("idCriterio", StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(Pregunta.class));

		query.setParameter("idEncuesta", idEncuesta);

		@SuppressWarnings("unchecked")
		List<Pregunta> listaPregunta = query.list();

		return listaPregunta;
	}

	@Override
	public String obtenerInstruccion(int idEncuesta) {

		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery(
						"SELECT E.INSTRUCCIONES AS instruccion " + "FROM ENCUESTA E " + "WHERE E.ID = :idEncuesta ")
				.addScalar("instruccion", StandardBasicTypes.STRING)
				.setResultTransformer(Transformers.aliasToBean(Encuesta.class));

		query.setParameter("idEncuesta", idEncuesta);

		Encuesta encuesta = (Encuesta) query.uniqueResult();

		return encuesta.getInstruccion();
	}

	@Override
	public List<Facultad> obtenerFacultades() {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery(
								"SELECT F.ID AS id " 
								+ " , F.NOMBRE AS nombre " 
								+ " FROM FACULTAD F " 
								+ " ORDER BY F.NOMBRE")
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.setResultTransformer(Transformers.aliasToBean(Facultad.class));

		@SuppressWarnings("unchecked")
		List<Facultad> listaFacultad = query.list();

		return listaFacultad;
	}

	@Override
	public List<CarreraProfesional> obtenerCarrerasProfesionalesPorFacultad(int idFacultad) {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery(
								"SELECT CP.ID AS id "
							+ " , CP.NOMBRE AS nombre "
							+ " , CP.ID_FACULTAD AS idFacultad "
							+ " FROM CARRERA_PROFESIONAL CP "
							+ " WHERE CP.ID_FACULTAD = :idFacultad "
							+ " ORDER BY CP.NOMBRE")
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("idFacultad", StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(CarreraProfesional.class));

		query.setParameter("idFacultad", idFacultad);
		
		@SuppressWarnings("unchecked")
		List<CarreraProfesional> listaCarreraProfesional = query.list();

		return listaCarreraProfesional;
	}

	@Override
	public List<Curso> obtenerCursosPorCarreraProfesional(int idCarreraProfesional) {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery(
								"SELECT C.ID AS id "
							+ " , C.NOMBRE AS nombre "
							+ " , C.ID_CARRERA_PROF AS idCarreraProfesional "
							+ " FROM CURSO C "
							+ " WHERE C.ID_CARRERA_PROF = :idCarreraProfesional "
							+ " ORDER BY C.NOMBRE")
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("idCarreraProfesional", StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(Curso.class));
		
		query.setParameter("idCarreraProfesional", idCarreraProfesional);

		@SuppressWarnings("unchecked")
		List<Curso> listaCurso = query.list();

		return listaCurso;
	}

	@Override
	public List<Grupo> obtenerGruposPorCurso(int idCurso) {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery(" SELECT C.ID AS id "
						+ " , C.NOMBRE AS nombre "
						+ " , C.ID_CARRERA_PROF AS idCarreraProfesional "
						+ " , G.ID AS idGrupo "
						+ " , G.NOMBRE AS nombreGrupo "
						+ " , D.ID AS idDocente "
						+ " , D.AP_PATERNO AS docenteApPaterno "
						+ " , D.AP_MATERNO AS docenteApMaterno "
						+ " , D.NOMBRES AS docenteNombres "
						+ " , D.NUM_DOC_IDENT AS docenteNumDocIdent "
						+ " , CONCAT(D.AP_PATERNO, ' ', D.AP_MATERNO , ', ', D.NOMBRES) AS docenteNombreCompleto "
						+ " FROM CURSO C "
						+ " INNER JOIN GRUPO G ON C.ID = G.ID_CURSO "
						+ " INNER JOIN DOCENTE D ON D.ID = G.ID_DOCENTE "
						+ " WHERE C.ID = :idCurso "
						+ " ORDER BY C.NOMBRE ")
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("idCarreraProfesional", StandardBasicTypes.INTEGER)
				.addScalar("idGrupo", StandardBasicTypes.INTEGER)
				.addScalar("nombreGrupo", StandardBasicTypes.STRING)
				.addScalar("idDocente", StandardBasicTypes.INTEGER)
				.addScalar("docenteApPaterno", StandardBasicTypes.STRING)
				.addScalar("docenteApMaterno", StandardBasicTypes.STRING)
				.addScalar("docenteNombres", StandardBasicTypes.STRING)
				.addScalar("docenteNumDocIdent", StandardBasicTypes.STRING)
				.addScalar("docenteNombreCompleto", StandardBasicTypes.STRING)
				.setResultTransformer(Transformers.aliasToBean(Grupo.class));
		
		query.setParameter("idCurso", idCurso);

		@SuppressWarnings("unchecked")
		List<Grupo> grupos = query.list();

		return grupos;
	}

}
