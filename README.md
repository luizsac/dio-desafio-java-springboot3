# API REST para Controle de Estoque

## Descrição

Esta é uma API REST simples desenvolvida em Java usando Spring Boot, Spring Security, JPA, Hibernate, Lombok e JWT para autenticação. A API permite o gerenciamento de produtos em uma loja de produtos veterinários e agropecuários, com suporte para múltiplas filiais.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- **Spring Security**
- **JWT (JSON Web Token)**
- **JPA/Hibernate**
- **Lombok**
- **H2 Database** (para ambiente de desenvolvimento/teste)
- **Gradle** (para gerenciamento de dependências)
- **OpenAPI** (para documentação da API)

## Funcionalidades

- **Autenticação JWT**: A API utiliza JSON Web Tokens para autenticação e autorização.
- **CRUD de Produtos**: Gerenciamento de produtos no estoque, incluindo múltiplas filiais.
- **Filiais**: Gerenciamento de estoque distribuído entre várias filiais da loja.

## Como Executar o Projeto

### Pré-requisitos

- **JDK 21+**
- **Gradle 7.x+**

### Passos para Rodar a Aplicação

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. **Compile e Execute a Aplicação:**

   ```bash
   ./gradlew bootRun
   ```

3. **Acesse a Documentação da API:**

A documentação gerada pelo OpenAPI está disponível em:

```bash
http://localhost:8080/swagger-ui/index.html
```

### Endpoints Principais

- **Autenticação**: `POST /api/auth/authenticate`
   - Payload:
     ```json
     {
       "username": "admin",
       "password": "admin123"
     }
     ```

   - Resposta: Token JWT

- **Produtos**: `GET /api/produtos`
   - Autorizado apenas para usuários autenticados.

- **Filiais**: `GET /api/filiais`
   - Autorizado apenas para usuários autenticados.

### Variáveis de Ambiente

- `JWT_SECRET`: A chave secreta usada para assinar os tokens JWT. Configure-a no seu ambiente para maior segurança.

## Estrutura do Projeto

- **config/**: Configurações do Spring Security.
- **controller/**: Controladores REST.
- **domain/**: Entidades JPA.
- **repository/**: Repositórios JPA.
- **security/**: Configurações e utilitários de segurança, incluindo JWT.
- **service/**: Serviços de negócios e lógica da aplicação.

## Testes

Para executar os testes, utilize o seguinte comando:

```bash
./gradlew test
```

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.