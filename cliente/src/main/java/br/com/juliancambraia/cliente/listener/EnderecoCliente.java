package br.com.juliancambraia.cliente.listener;

import br.com.juliancambraia.cliente.model.Endereco;
import br.com.juliancambraia.cliente.service.EnderecoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class EnderecoCliente {

    private EnderecoService service;

    public EnderecoCliente(EnderecoService service) {
        this.service = service;
    }

    @KafkaListener(topics = "${topic.endereco-cliente}", groupId = "${spring.kafka.consumer.group-id}")
    public void obterEnderecoCliente(String enderecoString) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Endereco endereco = mapper.readValue(enderecoString, Endereco.class);

        service.save(endereco);
        log.info("Mensagem endereco: {}", enderecoString);
    }
}
