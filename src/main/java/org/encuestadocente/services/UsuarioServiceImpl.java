package org.encuestadocente.services;

import org.encuestadocente.dao.UsuarioDAO;
import org.encuestadocente.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario obtenerUsuario(String email, String password) {

		return usuarioDAO.obtenerUsuario(email, password);
	}

}
