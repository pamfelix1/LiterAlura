# LiterAlura

## Descrição

LiterAlura é um projeto de aplicação em Java que permite aos usuários interagir de forma textual para realizar pesquisas de livros e autores usando a API Gutendex e armazenar os resultados em um banco de dados PostgreSQL. A aplicação utiliza Spring Boot, Spring JPA e Hibernate para gerenciamento de persistência e transações.

## Funcionalidades

1. **Buscar livros por título**: Consome a API Gutendex para buscar livros pelo título fornecido pelo usuário.
2. **Listar livros registrados**: Lista todos os livros que foram registrados no banco de dados.
3. **Listar autores registrados**: Lista todos os autores que foram registrados no banco de dados.
4. **Listar autores em determinado ano**: Lista todos os autores que estavam vivos em um determinado ano.
5. **Listar livros em um determinado idioma**: Lista todos os livros registrados em um determinado idioma.

## Tecnologias Utilizadas

- **Java 11**
- **Spring Boot**
- **Spring JPA**
- **Hibernate**
- **PostgreSQL**
- **RestTemplate (para consumir API Gutendex)**

## Pré-requisitos

- **Java 11** ou superior
- **Maven** para gerenciamento de dependências
- **PostgreSQL** como banco de dados


