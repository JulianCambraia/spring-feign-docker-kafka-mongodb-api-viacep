package br.com.juliancambraia.endereco.service;

import br.com.juliancambraia.endereco.response.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Interface principal que faz a chamada a API externa do ViaCep atraves de OpenFeign
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json")
    EnderecoResponse obterCep(@PathVariable("cep") String cep);
}
