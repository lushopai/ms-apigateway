package oauth.models;

import java.util.List;

import lombok.Data;


@Data
public class Usuario {
	

	private Long id;
	private String username;
	private String password;
	private Boolean enabled;
	private String nombre;
	private String email;
	

	private List<Rol> roles;


	
	

}
