package br.com.juliancambraia.endereco.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class EnderecoService {

    @Value("${topic.endereco-cliente}")
    private String topicEnderecoCliente;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoService.class);


    public void sendMessage(String message) {
        this.kafkaTemplate.send(topicEnderecoCliente, message);
        LOGGER.info("Mensagem enviada para o topic.endereco-cliente: {}", message);
    }
}
