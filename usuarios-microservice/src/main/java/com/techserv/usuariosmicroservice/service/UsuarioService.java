package com.techserv.usuariosmicroservice.service;

import com.techserv.usuariosmicroservice.entity.Usuario;

public interface UsuarioService {
	
	public Usuario findByUsername(String term);
	

}
