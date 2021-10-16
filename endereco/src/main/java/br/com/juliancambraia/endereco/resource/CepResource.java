package br.com.juliancambraia.endereco.resource;

import br.com.juliancambraia.endereco.response.EnderecoResponse;
import br.com.juliancambraia.endereco.service.ViaCepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cep")
public class CepResource {

    private ViaCepService cepService;

    public CepResource(ViaCepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoResponse> obterCep(@PathVariable("cep") String cep) {
        EnderecoResponse enderecoResponse = cepService.obterCep(cep);
        return  ResponseEntity.ok(enderecoResponse);
    }
}
