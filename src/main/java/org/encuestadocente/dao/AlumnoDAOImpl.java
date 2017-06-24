package org.encuestadocente.dao;

import org.encuestadocente.entities.Alumno;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AlumnoDAOImpl implements AlumnoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Alumno obtenerAlumno() {

		String idObtener = "000001";
		Alumno alumno = (Alumno) sessionFactory.getCurrentSession().get(Alumno.class, idObtener);

		return alumno;
	}
}
