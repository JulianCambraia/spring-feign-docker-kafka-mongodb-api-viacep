package br.com.juliancambraia.endereco.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data usado para implementar automaticamente Getters, Setters, toString
 * @AllArgsConstructor usado para criar o um construtor com todos os parâmetros
 * @NoArgsConstructor usado para criar um construtor vazio - construtor padrão
 * @Builder usado para facilitar as consultas nos objetos
 * @JsonIgnoreProperties usado para não gerar erro caso o contrato da Api de Ceps dos correios retornada tenha mudado os
 * parâmetros
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoResponse {

        private String cep;
        private String logradouro;
        private String complemento;
        private String bairro;
        private String localidade;
        private String uf;
        private Long numero;
}
