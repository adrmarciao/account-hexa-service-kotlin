# Microservice 
Construindo microservice de conta para fins didáticos.

## Arquitetura

Microservice com arquitetura Hexagonal

<img src="https://uploads-ssl.webflow.com/5eebed4f86986c7148161d11/5f4fe4418bbe242216f77452_hexagonal-architecture-v3.png" height="200" />

## Estrutura de pacotes

A estrutura adotada nesse microserviço foi dividas em pacotes, mas pode ser divida em pequenos modulos isolados. 
Dessa forma os pacotes foram dividos em:

 - Adapter (Implementação de conectores, podendo ser dividídos em outputs e inputs)
   - Controller
   - DTO
   - Repository 
 - Application (Implementação da camada de domain)
   - config
   - exception
   - model
   - service
 - Ports (Interface de comunicação)

## Frameworks/Libs/Ferramentas

* [Spring Boot](https://www.springbot.com/)
* [Hibernate](https://hibernate.org/)
* [Docker](https://docs.docker.com/)
* [Liquibase](https://www.liquibase.org/)
* [Gradle](https://gradle.org/)
* [PostgreSQL](https://www.postgresql.org/)
* [JacksonJSON](https://www.baeldung.com/jackson/)
* [Webflux](https://docs.spring.io/spring-framework/docs/5.0.0.M5/spring-framework-reference/html/web-reactive.html)
* [Swagger](https://swagger.io/)

## Executar


Para executar o projeto, é necessário instalado:
 - Docker;
 - Gradle ou usar o gradle da importação do projeto;
 - Docker-compose;
 
### Buildar Projeto

      gradlew clean
      gradlew build

### Criar imagem

      docker-compose up

Ao executar o comando a cima. A imagem será criada automáticamente, caso não exista.

## Endpoints

![endpoints](files/endpoints.png)

Caso esteja rodando localmente a aplicação. A documentação estará disponível [aqui](http://localhost:8080/webjars/swagger-ui/index.html#/).

Obs: Caso queira apenas enviar um topico para Kafka, basta executar o endpoint.

## Objetivos

- Criar projeto initial com arquitetura hexagonal :heavy_check_mark:
- Adicionar Liquibase :heavy_check_mark:
- Adicionar WebFlux :heavy_check_mark:
- Adicionar R2DBC :heavy_check_mark:
- Criar docker-compose para facilitar desenvolvimento :heavy_check_mark:
- Adicionar Kubernetes :heavy_check_mark:
- Adicionar comunicação com Kafka :heavy_check_mark:
- Adicionar teste unitário
