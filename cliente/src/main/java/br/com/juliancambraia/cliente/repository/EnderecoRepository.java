package br.com.juliancambraia.cliente.repository;

import br.com.juliancambraia.cliente.model.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {
    public Endereco save(Endereco endereco);
}
