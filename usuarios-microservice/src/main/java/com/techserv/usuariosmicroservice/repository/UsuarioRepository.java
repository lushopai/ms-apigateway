package com.techserv.usuariosmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.techserv.usuariosmicroservice.entity.Usuario;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	public Usuario findByUsername(String term);

}
