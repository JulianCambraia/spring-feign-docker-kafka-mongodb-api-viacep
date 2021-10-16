package br.com.juliancambraia.endereco.resource;

import br.com.juliancambraia.endereco.http.EnderecoJson;
import br.com.juliancambraia.endereco.response.EnderecoResponse;
import br.com.juliancambraia.endereco.service.EnderecoService;
import br.com.juliancambraia.endereco.service.ViaCepService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
@Log4j2
public class EnderecoResource {

    private final ViaCepService cepService;

    private final EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoResponse> obterCep(@PathVariable("cep") String cep) {
        EnderecoResponse enderecoResponse = cepService.obterCep(cep);
        return ResponseEntity.ok(enderecoResponse);
    }

    @PostMapping
    public ResponseEntity<EnderecoResponse> enviarEndereco(@RequestBody EnderecoJson enderecoJson) throws JsonProcessingException {
        log.info("## Dados enviados pelo cliente :{}", enderecoJson);
        EnderecoResponse enderecoResponse = cepService.obterCep(enderecoJson.getCep());
        enderecoResponse.setComplemento(enderecoJson.getComplemento());
        enderecoResponse.setNumero(enderecoJson.getNumero());

        ObjectMapper mapper = new ObjectMapper();
        String message = mapper.writeValueAsString(enderecoResponse);

        enderecoService.sendMessage(message);
        log.info("## Endereco retornado pela API de CEP: {}", enderecoResponse);

        return ResponseEntity.ok(enderecoResponse);

    }

}
