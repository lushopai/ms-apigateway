package com.techserv.usuariosmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techserv.usuariosmicroservice.entity.Usuario;
import com.techserv.usuariosmicroservice.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	@Autowired
	private UsuarioRepository  repository;

	@Override
	public Usuario findByUsername(String term) {
		
		return repository.findByUsername(term);
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

}
