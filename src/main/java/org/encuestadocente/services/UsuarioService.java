package org.encuestadocente.services;

import org.encuestadocente.entities.Usuario;

public interface UsuarioService {

	Usuario obtenerUsuario(String email, String password);

}
