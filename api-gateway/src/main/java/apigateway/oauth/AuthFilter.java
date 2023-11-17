package apigateway.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import apigateway.dto.UserDto;
import apigateway.util.JwtUtil;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

	private final WebClient.Builder builder;
	
    @Autowired
    private RouterValidator validator;
    
    @Autowired
    private JwtUtil jwtUtil;

	public AuthFilter(WebClient.Builder builder) {
		super(Config.class);
		this.builder = builder;

	}

	@Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
                	System.out.println("TOKEN A VALIDAR :{}" +authHeader.toString());
//                    //REST call to AUTH service
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
                    //jwtUtil.validateToken(authHeader);

                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange);
        });
    }

	public static class Config {

	}
	
	
	public String validarToken() {
		return builder.build()
				.post()
				.uri("http://localhost:8080/oauth/token")
				.retrieve()
				.bodyToMono(String.class)
				.log()
				.block();
	}

}
