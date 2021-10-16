# Prova de Conceito API Pública Consutal CEP do ViaCEP com o uso das tecnologias Spring boot, OpenFeign, Kafka, Docker, MongoDB


## Objetivo

Esta Prova de conceito irá demonstrar como podemos consumir dados acessando uma API pública (no caso API de consulta CEP do ViaCEP) usando as tecnologias Spring Boot, Feign Client, Kafka (Producer e Consumer) e Banco NoSQL MongoDB.

Seguindo o fluxo da arquitetura demonstrada na imagem abaixo teremos: 

Clientes diversos realizando requisições do tipo GET a uma API de consulta pública para obter dados de endereço completo através do seu CEP.

O Cliente será representado por chamadas GET e POST no Postman. 

A comunicação entre as APIs interna e externa se dará através do OpenFeign.
Uma vez termos consumido estes dados de Endereço iremos armazená-los em uma Fila Kafka (Producer), e, este Kafka estará instalado localmente em um container Docker.
Para que consigamos visualizar se as mensagens (Payloads) estão sendo enviadas para um Tópico Kafka usaremos o KafkaDrop, um client dependente do Kafka que também estará containirizado (Zookeeper, Kafka e KafkaDrop)

A próxima etapa será a construção de uma outra API Cliente que terá como objetivo consumir da fila do Kafka e obter todas as mensagens postadas, em seguida persisti-las em um banco de dados, que neste caso optei pelo banco noSQL MongoDB.


![alt text](https://github.com/JulianCambraia/spring-feign-docker-kafka-mongo-receitaws/blob/main/images/arquitetura-poc.png?raw=true)
