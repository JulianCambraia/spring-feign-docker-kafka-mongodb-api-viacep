package br.com.juliancambraia.endereco.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
public class CepFeignConfig {
    @Value("{api.cep.username}")
    private String usuario;

    @Value("{api.cep.senha}")
    private String senha;

    private BasicAuthenticationInterceptor authenticationInterceptor;

    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptor() {
        return new BasicAuthenticationInterceptor(usuario, senha);
    }
}
