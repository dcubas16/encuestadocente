package org.encuestadocente.dao;

import org.encuestadocente.entities.Usuario;

public interface UsuarioDAO {

	Usuario obtenerUsuario(String email, String password);

}
