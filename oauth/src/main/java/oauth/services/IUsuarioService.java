package oauth.services;

import oauth.models.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
