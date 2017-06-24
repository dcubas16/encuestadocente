package org.encuestadocente.dao;

import org.encuestadocente.entities.Usuario;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Usuario obtenerUsuario(String email, String password) {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery(" SELECT U.id AS id "
						+ " ,U.EMAIL AS email "
						+ " ,U.PASSWORD AS password "
						+ " ,U.TIPO_USUARIO AS idTipoUsuario "
						+ " ,U.ESTADO  AS estado "
						+ " ,A.ID AS idAlumno "
						+ " ,A.NOMBRES AS nombres "
						+ " ,A.AP_PATERNO AS apPaterno "
						+ " ,A.AP_MATERNO AS apMaterno "
						+ " ,A.NUM_DOC_IDENT AS numDocIdent "
						+ " ,IFNULL(ADM.ID, 0)  AS idAdministrativo "
						+ " ,ADM.NOMBRES AS admNombres "
						+ " ,ADM.AP_PATERNO AS admApPaterno "
						+ " ,ADM.AP_MATERNO AS admApMaterno "
						+ " ,ADM.NUM_DOC_IDENT AS admNumDocIdent "
						+ " FROM encuestadocente.usuario U "
						+ " INNER JOIN detalle_usuario_alumno_administra DUAA ON U.ID = DUAA.ID_USUARIO "
						+ " LEFT JOIN ALUMNO A ON A.ID = DUAA.ID_ALUMNO "
						+ " LEFT JOIN ADMINISTRATIVO ADM ON ADM.ID = DUAA.ID_ADMINISTRATIVO "
						+ " WHERE U.EMAIL = :email "
						+ " AND U.PASSWORD = :password LIMIT 1")
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("email", StandardBasicTypes.STRING)
				.addScalar("password", StandardBasicTypes.STRING)
				.addScalar("idTipoUsuario", StandardBasicTypes.INTEGER)
				.addScalar("estado", StandardBasicTypes.INTEGER)
				.addScalar("idAlumno", StandardBasicTypes.STRING)
				.addScalar("nombres", StandardBasicTypes.STRING)
				.addScalar("apPaterno", StandardBasicTypes.STRING)
				.addScalar("apMaterno", StandardBasicTypes.STRING)
				.addScalar("numDocIdent", StandardBasicTypes.STRING)
				.addScalar("idAdministrativo", StandardBasicTypes.INTEGER)
				.addScalar("admNombres", StandardBasicTypes.STRING)
				.addScalar("admApPaterno", StandardBasicTypes.STRING)
				.addScalar("admApMaterno", StandardBasicTypes.STRING)
				.addScalar("admNumDocIdent", StandardBasicTypes.STRING)
				.setResultTransformer(Transformers.aliasToBean(Usuario.class));

		query.setParameter("email", email);
		query.setParameter("password", password);

		Usuario usuario = (Usuario) query.uniqueResult();

		return usuario;
	}

}
