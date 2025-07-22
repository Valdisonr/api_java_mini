# API Java Mini com Spring Boot

Projeto de uma API RESTful desenvolvida em Java utilizando Spring Boot, com arquitetura baseada em DTOs, mapeamento automático via MapStruct, e persistência com JPA Repository.

## Descrição

Esta aplicação gerencia entidades como **Cliente** e **Pessoa**, implementando operações CRUD (Create, Read, Update, Delete) de forma simples e eficiente. O projeto utiliza DTOs para validar e transferir dados, e MapStruct para realizar o mapeamento automático entre entidades e DTOs, mantendo a camada de persistência limpa.

## Tecnologias Utilizadas

- Java 21  
- Spring Boot 3.5.3  
- Spring Data JPA  
- Hibernate  
- MapStruct 1.5.5  
- Bean Validation (jakarta.validation)  
- MySQL Connector/J  
- Maven para gerenciamento de dependências  
- Docker para containerização  

## Funcionalidades

- Cadastro, listagem, atualização e exclusão de Clientes e Pessoas  
- Validação dos dados de entrada com anotações de Bean Validation  
- Mapeamento automático entre DTOs e entidades com MapStruct  
- Tratamento de exceções e respostas HTTP adequadas  
- Estrutura organizada com pacotes para Controller, Service, Repository, DTO e Mapper  

## Como Rodar

### Localmente

1. Clone o repositório:  
   git clone https://github.com/Valdisonr/api_java_mini.git
src/main/java/com/apijava/api_java_mini/
├── controller/    # Controllers REST
├── dto/           # Data Transfer Objects com validação
├── entity/        # Entidades JPA
├── mapper/        # Interfaces MapStruct para conversão
├── repository/    # Repositórios Spring Data JPA
├── service/       # Serviços com lógica de negócio

## Contato

Valdison Rodrigues Metelis  
Analista Desenvolvedor  
[GitHub](https://github.com/Valdisonr)  
Email: valdison@outlook.com


