package br.com.juliancambraia.cliente.service;

import br.com.juliancambraia.cliente.model.Endereco;
import br.com.juliancambraia.cliente.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public Endereco save(Endereco endereco) {
        repository.save(endereco);
        return endereco;
    }

    public List<Endereco> getListaDeEnderecos() {
        return repository.findAll();
    }
}
