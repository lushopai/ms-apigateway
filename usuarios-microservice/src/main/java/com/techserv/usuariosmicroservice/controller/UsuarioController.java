package com.techserv.usuariosmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techserv.usuariosmicroservice.entity.Usuario;
import com.techserv.usuariosmicroservice.repository.UsuarioRepository;
import com.techserv.usuariosmicroservice.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService  service;
	
	@GetMapping("/")
	public List<Usuario> home() {
		return service.findAll();
	}
	
	@GetMapping("/buscar")
	public Usuario findByUsername(@RequestParam String term) {
		return service.findByUsername(term);
	}

}
