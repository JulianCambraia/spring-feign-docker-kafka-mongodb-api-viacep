package br.com.juliancambraia.cliente.controller;

import br.com.juliancambraia.cliente.model.Endereco;
import br.com.juliancambraia.cliente.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

    private EnderecoService service;

    public EnderecoResource(EnderecoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco) {
        service.save(endereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getListaDeEnderecos() {
        List<Endereco> listaEnderecos = service.getListaDeEnderecos();
        return ResponseEntity.ok(listaEnderecos);
    }
}
