package org.encuestadocente.dao;

import java.util.List;

import org.encuestadocente.entities.CabeceraEncuesta;
import org.encuestadocente.entities.DetallePreguntaAlumnoGrupo;
import org.encuestadocente.entities.Encuesta;
import org.encuestadocente.entities.Estadistico;
import org.encuestadocente.entities.RespuestaTransaccion;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EncuestaDAOImpl implements EncuestaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CabeceraEncuesta obtenerCabeceraEncuesta(String idAlumno) {

		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT A.NUM_DOC_IDENT AS alumnoNumDocIdent " + ",A.AP_PATERNO AS alumnoApPaterno "
						+ ",A.AP_MATERNO AS alumnoApMaterno " + ",A.NOMBRES  AS alumnoNombres " + ",F.ID AS facultadId "
						+ ",F.NOMBRE AS facultadNombre " + ",CP.ID AS carreraProfId "
						+ ",CP.NOMBRE AS carreraProfNombre " + ",C.ID AS cursoId " + ",C.NOMBRE AS cursoNombre "
						+ ",G.ID AS grupoId " + ",G.NOMBRE AS grupoNombre " + ",D.ID AS docenteId "
						+ ",D.NUM_DOC_IDENT AS docenteNumDocIdent " + ",D.AP_PATERNO AS docenteApPaterno "
						+ ",D.AP_MATERNO AS docenteApMaterno " + ",D.NOMBRES AS docenteNombres " 
						+ "FROM FACULTAD F "
						+ "INNER JOIN CARRERA_PROFESIONAL CP ON F.ID = CP.ID_FACULTAD "
						+ "INNER JOIN CURSO C ON C.ID_CARRERA_PROF = CP.ID "
						+ "INNER JOIN GRUPO G ON G.ID_CURSO = C.ID " + "INNER JOIN DOCENTE D ON D.ID = G.ID_DOCENTE "
						+ "INNER JOIN DETALLE_ALUMNO_GRUPO DAG ON DAG.ID_GRUPO = G.ID "
						+ "INNER JOIN ALUMNO A ON DAG.ID_ALUMNO = A.ID " + "WHERE A.ID = :idAlumno " + "LIMIT 1")
				.addScalar("alumnoNumDocIdent", StandardBasicTypes.STRING)
				.addScalar("alumnoApPaterno", StandardBasicTypes.STRING)
				.addScalar("alumnoApMaterno", StandardBasicTypes.STRING)
				.addScalar("alumnoNombres", StandardBasicTypes.STRING)
				.addScalar("facultadId", StandardBasicTypes.INTEGER)
				.addScalar("facultadNombre", StandardBasicTypes.STRING)
				.addScalar("carreraProfId", StandardBasicTypes.INTEGER)
				.addScalar("carreraProfNombre", StandardBasicTypes.STRING)
				.addScalar("cursoId", StandardBasicTypes.INTEGER).addScalar("cursoNombre", StandardBasicTypes.STRING)
				.addScalar("grupoId", StandardBasicTypes.INTEGER).addScalar("grupoNombre", StandardBasicTypes.STRING)
				.addScalar("docenteId", StandardBasicTypes.INTEGER)
				.addScalar("docenteNumDocIdent", StandardBasicTypes.STRING)
				.addScalar("docenteApPaterno", StandardBasicTypes.STRING)
				.addScalar("docenteApMaterno", StandardBasicTypes.STRING)
				.addScalar("docenteNombres", StandardBasicTypes.STRING)
				.setResultTransformer(Transformers.aliasToBean(CabeceraEncuesta.class));

		query.setParameter("idAlumno", idAlumno);

		CabeceraEncuesta cabeceraEncuesta = (CabeceraEncuesta) query.uniqueResult();

		return cabeceraEncuesta;
	}

	@Override
	public RespuestaTransaccion guardarEncuesta(DetallePreguntaAlumnoGrupo[] listaDetalle) {

		try{
		
			for (DetallePreguntaAlumnoGrupo detallePreguntaAlumnoGrupo : listaDetalle) {

				Query query = sessionFactory.getCurrentSession()
						.createSQLQuery("INSERT INTO DETALLE_PREGUNTA_ALUMNO_GRUPO(ID_PREGUNTA, ID_ALUMNO_GRUPO, VALOR) "
								+" VALUES( :idPregunta , :idAlumnoGrupo , :valor ); ");
				query.setParameter("idPregunta", detallePreguntaAlumnoGrupo.getIdPregunta());
				query.setParameter("idAlumnoGrupo", detallePreguntaAlumnoGrupo.getIdAlumnoGrupo());
				query.setParameter("valor", detallePreguntaAlumnoGrupo.getValor());
				query.executeUpdate();
				
				
			}			
			return new RespuestaTransaccion(true, "");
			
		}catch(Exception ex){
			
			return new RespuestaTransaccion(false, ex.getMessage());
		}
	}
 
	@Override
	public List<DetallePreguntaAlumnoGrupo> obtenerDetallesEncuestaAlumnoGrupo(int idAlumnoGrupo, int idEncuesta) {

		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery(" SELECT DPAG.ID AS id "
						+ " ,DPAG.ID_PREGUNTA AS idPregunta "
						+ " ,DPAG.ID_ALUMNO_GRUPO AS idAlumnoGrupo "
						+ " ,DPAG.VALOR AS valor "
						+ " FROM GRUPO G "
						+ " INNER JOIN DETALLE_ALUMNO_GRUPO DAG ON G.ID = DAG.ID_GRUPO "
						+ " INNER JOIN ALUMNO A ON A.ID = DAG.ID_ALUMNO "
						+ " INNER JOIN DETALLE_PREGUNTA_ALUMNO_GRUPO DPAG ON DPAG.ID_ALUMNO_GRUPO = DAG.ID "
						+ " INNER JOIN PREGUNTA P ON P.ID = DPAG.ID_PREGUNTA "
						+ " INNER JOIN CRITERIO C ON C.ID = P.ID_CRITERIO "
						+ " INNER JOIN ENCUESTA E ON E.ID = C.ID_ENCUESTA "
						+ " WHERE E.ID = :idEncuesta "
						+ " AND DAG.ID = :idDetalleGrupoAlumno ")
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("idPregunta", StandardBasicTypes.INTEGER)
				.addScalar("idAlumnoGrupo", StandardBasicTypes.INTEGER)
				.addScalar("valor", StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(DetallePreguntaAlumnoGrupo.class));
				
		query.setParameter("idEncuesta", idEncuesta);
		query.setParameter("idDetalleGrupoAlumno", idAlumnoGrupo);
		

		@SuppressWarnings("unchecked")
		List<DetallePreguntaAlumnoGrupo> listaDetallePreguntaAlumnoGrupo = query.list();

		return listaDetallePreguntaAlumnoGrupo;	
	}

	@Override
	public Encuesta obtenerEncuestaActiva() {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT E.ID AS id, E.NOMBRE AS nombre, "
							+ "E.INSTRUCCIONES AS instruccion, E.ESTADO AS estado  "
							+ "FROM ENCUESTA E "
							+ "WHERE E.ESTADO = 1 ")
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("instruccion", StandardBasicTypes.STRING)
				.addScalar("estado", StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(Encuesta.class));

		Encuesta encuesta = (Encuesta)query.uniqueResult();
		
		return encuesta;
	}

	@Override
	public List<Estadistico> obtenerEstadisticas(int idGrupo, int idEncuesta) {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery(" SELECT DAG.ID_GRUPO as idGrupo "
						+ " , E.ID AS encuestaId "
						+ " , C.ID AS criterioId "
						+ " , P.ID AS preguntaId "
						+ " , DPAG.VALOR AS valorEncuesta "
						+ " , COUNT(1) AS conteoValor "
						+ " FROM ENCUESTA E "
						+ " INNER JOIN CRITERIO C ON E.ID = C.ID_ENCUESTA "
						+ " INNER JOIN PREGUNTA P ON P.ID_CRITERIO = C.ID "
						+ " INNER JOIN DETALLE_PREGUNTA_ALUMNO_GRUPO DPAG ON DPAG.ID_PREGUNTA = P.ID "
						+ " INNER JOIN DETALLE_ALUMNO_GRUPO DAG ON DAG.ID = DPAG.ID_ALUMNO_GRUPO "
						+ " WHERE E.ID = :idEncuesta "
						+ " AND DAG.ID_GRUPO = :idGrupo "
						+ " GROUP BY DAG.ID_GRUPO, E.ID, C.ID, P.ID, DPAG.VALOR ")
				.addScalar("idGrupo", StandardBasicTypes.INTEGER)
				.addScalar("encuestaId", StandardBasicTypes.INTEGER)
				.addScalar("criterioId", StandardBasicTypes.INTEGER)
				.addScalar("preguntaId", StandardBasicTypes.INTEGER)
				.addScalar("valorEncuesta", StandardBasicTypes.INTEGER)
				.addScalar("conteoValor", StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(Estadistico.class));

		query.setParameter("idEncuesta", idEncuesta);
		query.setParameter("idGrupo", idGrupo);
		
		@SuppressWarnings("unchecked")
		List<Estadistico> estadisticos = query.list();
		
		return estadisticos;
	}

}
