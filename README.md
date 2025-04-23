# 🏰 Projeto Mercado Medieval

Este é um projeto desenvolvido em Java com Spring Boot que simula um **mercado medieval**. Nele, personagens como guerreiros, magos e arqueiros podem comprar, vender e gerenciar itens mágicos como espadas, grimórios e elixires.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.1.0
- Spring Data JPA
- Banco de dados H2 (memória)
- Maven

## 🛠️ Como Rodar o Projeto

1. Clone o repositório ou extraia o `.zip`:
   ```bash
   git clone https://github.com/seu-usuario/mercado-medieval.git
   ```

2. Navegue até a pasta do projeto e compile:
   ```bash
   mvn spring-boot:run
   ```

3. Acesse a aplicação em:
   ```
   http://localhost:8080
   ```

4. Acesse o console do banco H2 (opcional):
   ```
   http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:mercado
   ```

## 📦 Endpoints Disponíveis

### Personagens

- `POST /personagens` – Criar personagem
- `GET /personagens` – Listar todos
- `GET /personagens/buscar-por-nome?nome=...` – Buscar por nome
- `GET /personagens/buscar-por-classe?classe=...` – Buscar por classe
- `PUT /personagens/{id}` – Atualizar personagem
- `DELETE /personagens/{id}` – Remover personagem

### Itens

- `POST /itens` – Criar item
- `GET /itens` – Listar todos
- `GET /itens/buscar-por-nome?nome=...` – Buscar por nome parcial
- `GET /itens/buscar-por-tipo?tipo=...` – Buscar por tipo
- `GET /itens/buscar-por-raridade?raridade=...` – Buscar por raridade
- `GET /itens/buscar-por-preco?min=...&max=...` – Buscar por faixa de preço

## 🔁 Exemplo de Requisição

```bash
curl -X POST http://localhost:8080/personagens \
-H "Content-Type: application/json" \
-d '{
  "nome": "Arthorius",
  "classe": "guerreiro",
  "nivel": 10,
  "moedas": 300
}'
```

## 📋 Regras de Validação

- `nivel`: entre **1 e 99**
- `classe`: deve ser **guerreiro**, **mago** ou **arqueiro**
- `raridade`: deve ser **comum**, **raro**, **épico** ou **lendário**

## 🧙‍♂️ Sobre

Projeto realizado para fins educativos e avaliativos, com foco em boas práticas de API REST, Java e Spring Boot. Inspirado em RPGs clássicos com uma pitada de criatividade mágica ✨.