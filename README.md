DevShowcase API

Sobre o projeto

A DevShowcase API é uma aplicação backend desenvolvida com Java e Spring Boot para gerenciar perfis, projetos, tecnologias e feedbacks.

O projeto faz parte do Projeto Integrador e tem como objetivo desenvolver uma API REST com persistência de dados e validação de informações.

Tecnologias utilizadas

- Java 21
- Spring Boot
- Maven
- Spring Web MVC
- Spring Data JPA
- Bean Validation
- Banco de dados H2
- PostgreSQL
- Swagger / OpenAPI

Funcionalidades

- Cadastro e consulta de perfis.
- Cadastro e consulta de projetos.
- Cadastro, consulta, atualização e exclusão de tecnologias.
- Cadastro e consulta de feedbacks.
- Validação de dados recebidos pela API.
- Relacionamento entre as entidades do sistema.

Como executar o projeto

1. Instale o Java 21.
2. Abra a pasta do projeto no Visual Studio Code.
3. Abra o terminal na pasta que contém o arquivo "pom.xml".
4. Execute o comando:

.\mvnw.cmd spring-boot:run

5. Aguarde a aplicação iniciar.

Documentação da API

Com a aplicação em execução, acesse:

http://localhost:8080/swagger-ui/index.html

A interface Swagger permite visualizar e testar os endpoints disponíveis.

Banco de dados

O projeto utiliza o banco H2 em memória para persistência durante a execução da aplicação. Os dados podem ser apagados quando o servidor é reiniciado.

Repositório

"DevShowcase API no GitHub" (https://github.com/cejmas2025/devshowcase-api)

Interface do projeto

"DevShowcase UI no GitHub" (https://github.com/cejmas2025/Devshowcase-ui)

Organização das tarefas

As atividades do projeto são organizadas no Trello, com cartões para desenvolvimento, validação, testes e documentação.

Trello: inserir aqui o link do quadro do projeto.