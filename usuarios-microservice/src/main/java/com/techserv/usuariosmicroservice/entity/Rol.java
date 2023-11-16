package com.techserv.usuariosmicroservice.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_roles")
@Data
@NoArgsConstructor
public class Rol implements Serializable {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true,length = 30)
	private String nombre;
	
	//@ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
	//private List<Usuario> usuarios;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
