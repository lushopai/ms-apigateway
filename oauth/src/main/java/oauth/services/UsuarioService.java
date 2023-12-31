package oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import oauth.clients.UsuarioFeignClient;
import oauth.models.Usuario;

@Service
public class UsuarioService implements UserDetailsService,IUsuarioService {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UsuarioFeignClient client;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = client.findByUsername(username);
		
		if(usuario == null) {
			LOGGER.error("error en el login");
			throw new UsernameNotFoundException("Error en el login, no existe el usuario en el sistema : " + username);
		}
		LOGGER.info("usuario encontrado :{}",usuario);
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(auth -> LOGGER.info("ROLE : " + auth.getAuthority()))
				.collect(Collectors.toList());
		LOGGER.info("usuario autenticado");
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);

	}

	@Override
	public Usuario findByUsername(String username) {
		return client.findByUsername(username);
	}

}
