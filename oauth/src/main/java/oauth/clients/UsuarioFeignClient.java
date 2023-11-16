package oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "usuarios-microservice")
public interface UsuarioFeignClient {
	
	@GetMapping("/api/usuarios/buscar")
	public oauth.models.Usuario findByUsername(@RequestParam String term);
	
	
	

}
