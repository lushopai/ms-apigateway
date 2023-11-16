package com.techserv.usuariosmicroservice.service;

import java.util.List;

import com.techserv.usuariosmicroservice.entity.Usuario;

public interface UsuarioService {
	
	public Usuario findByUsername(String term);
	
	public List<Usuario> findAll();
	

}
