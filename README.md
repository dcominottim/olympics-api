# Olympics API

Para executar o servidor, rode

```
mvn wildfly-swarm:run
```

# Considerações de design

Este projeto foi baseado em princípios de DDD (Domain-Driven Design), CQRS (Command Query Responsibility Seggregation) e, principalmente, Orientação a Objetos. Deste modo, trabalhei com os seguintes objetivos:

1. Dar ênfase ao design do Domain Model, isto é, às entidades do sistema e seus *comportamentos*. Para isso, foi aplicada uma estratégia de design baseada em "Traits", que se tornou mais factível no Java 8 devido à inclusão de métodos "default". Note que com o lançamento iminente do Java 9, os métodos acessores (getters e, principalmente, setters) poderão ser privados em vez de públicos, aprimorando o quesito de encapsulamento conforme apropriado. Todo o comportamento das entidades foi implementado a partir desse design que torna possível que outras variações sejam implementadas com rapidez e minimizando duplicação de código.

2. Dar ênfase ao aspecto de testabilidade e interpretação de código, utilizando nomes claros para a nomeação de classes, métodos, variáveis, etc., separando funcionalidades do sistema em pequenos métodos os mais genéricos possíveis, fazendo uso do conceito de injeção de dependências por meio de construtores (protegendo assim as invariantes das classes), usando interfaces e polimorfismo abundantemente, etc.

3. Dar ênfase a padrões de design que permitam ao sistema uma evolução consistente e correta, com a internacionalização de mensagens de erro, separação de representações REST de entidades do sistema -- representações essas modeladas como "View Objects", que a princípio podem parecer redundantes mas permitem a evolução das entidades independentemente da API externa do sistema, além de maximizar a performance para operações de leitura, por exemplo.

# Possíveis melhorias

Este projeto foi desenvolvido em pouquíssimo tempo por diversas razões. Todavia, seu design deixa claro algumas intenções e possibilidades para o futuro, como por exemplo

1. Implementação de testes de integração a partir dos endpoints REST, possivelmente basedos em Arquillian;
2. Implementação do requisito HATEOAS para APIs REST;
3. Implementação de documentação baseada em Swagger (OpenAPI 3.0).


# Endpoints REST

## URL base
http://localhost:8080/olympics


## Competitions

### GET
#### /competitions

Retorna todas as competições cadastradas


### GET
#### /competitions?modalityId={valor}

Retorna todas as competições cadastradas para determinada modalidade especificada por seu ID


### POST
#### /competitions

Registra uma nova competição

Exemplo de payload:

```
{
  "competitor1": { "id": 1 },
  "competitor2": { "id": 2 },
  "local": { "id": 1},
  "step": { "id": 4},
  "startDateTime": "2017-08-16T06:01:00.344Z",
  "endDateTime": "2017-08-16T06:34:32.344Z",
  "modality": { "id": 3 }
}
```

## Competitors

### GET
#### /competitors

Retorna os participantes cadastrados


## Modalities

### GET
#### /modalities

Retorna as modalidades cadastradas


## Locals

### GET
#### /locals

Retorna os locais cadastrados


## Steps

### GET
#### /steps

Retorna as etapas cadastradas


