<h2>Digital Innovation: Bootcamp GFT Java & AWS Developer</h2>

Objetivo é desenvolver um pequeno sistema para o gerenciamento de crianças e seus respectivos responsáveis de uma empresa de playground infantil através de uma API REST, criada com o Spring Boot.

Foram utilizados:

* Setup inicial de projeto com o Spring Boot Initialzr 
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (cadastro, leitura, atualização e remoção de pessoas de um sistema)
* Relação de cada uma das operações acima com o padrão arquitetural REST
* Desenvolvimento de testes unitários para validação das funcionalidades
* Implantação do sistema na nuvem através do Heroku

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/child
```

Links para execução do projeto usando Heroku
```
* [Listar todos] https://childapi-icc.herokuapp.com/api/v1/child
* [Listar por id] https://childapi-icc.herokuapp.com/api/v1/child/1
* [Incluir] https://childapi-icc.herokuapp.com/api/v1/child
* [Alterar] https://childapi-icc.herokuapp.com/api/v1/child/1
* [Excluir] https://childapi-icc.herokuapp.com/api/v1/child/1
```

Exemplo de paylod para inclusão de criança:
```
{
    "firstName":"Andrea",
    "lastName":"Marinho",       
    "birthDate":"10-10-1976",    
    "parents":[{
        "firstName":"Mariatila",
        "lastName":"Marinho",
        "cpf":"076.185.841-50",  
        "type":"MOTHER",
        "phones":[{
                "type":"HOME",
                "number":"1234567891019"
            }]

    }]
    
}
```

Exemplo de paylod para alteração de criança:
```
    {
        "id": 11,
        "firstName": "Joao",
        "lastName": "Pedrosa",
        "birthDate": "15-08-2013",
        "parents": [
            {
                "id": 2,
                "firstName": "Karla",
                "lastName": "Pedrosa",
                "cpf": "331.881.331-11",
                "type": "MOTHER",
                "phones": [
                    {
                        "id": 3,
                        "type": "HOME",
                        "number": "1234567891019"
                    }
                ]
            },
            {
                "id": 4,
                "firstName": "Karlos",
                "lastName": "Pedrosa",
                "cpf": "069.808.366-09",
                "type": "FATHER",
                "phones": [
                    {
                        "id": 5,
                        "type": "HOME",
                        "number": "1234567891019"
                    }
                ]
            }
        ]
    }
```
Alguns regras de negócio : 

* CPF do responsável é único. 
* Criança com idade máxima 10 anos

São necessários os seguintes pré-requisitos para a execução do projeto:

* Java 11 ou versões superiores
* Maven 3.6.3 ou versões superiores
* Visual Studio Code 1.61.0 ou versões superiores
* Controle de versão GitHub integrado na IDE
* Conta no GitHub para o armazenamento do seu projeto na nuvem.
* Conta no Heroku para o deploy do projeto na nuvem


Links úteis:

* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)
* [Referência do VSCode para download](https://code.visualstudio.com/)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial do Spring Initialzr, para setup do projeto](https://start.spring.io/)
* [Site oficial do Heroku](https://www.heroku.com/)
* [Site oficial do GIT](https://git-scm.com/)
* [Site oficial do GitHub](http://github.com/)
* [Documentação oficial do Lombok](https://projectlombok.org/)
* [Documentação oficial do Map Struct](https://mapstruct.org/)
* [Referência para o padrão arquitetural REST](https://restfulapi.net/)
