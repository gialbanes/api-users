# E-commerce: Projeto de API RESTful em Java com Spring Boot

Este é um projeto pessoal de back-end desenvolvido para demonstrar habilidades em construção de APIs RESTful, com foco em segurança, arquitetura e boas práticas de desenvolvimento. O sistema simula uma API para um e-commerce, permitindo o gerenciamento de usuários e itens de carrinho com autenticação e autorização baseadas em JWT.

---

## ✨ Destaques e Funcionalidades

### 🔒 Autenticação e Autorização com JWT

- Sistema completo de login e registro de usuários
- Geração de tokens JWT para acesso seguro às rotas
- Permissões controladas por perfis: `ROLE_ADMIN` e `ROLE_CUSTOMER`

### 📚 Boas Práticas de Código

- Utilização de DTOs (Data Transfer Objects) para separar a camada de persistência da camada de comunicação com o cliente
- Arquitetura em camadas (`Controller`, `Service`, `Repository`) para manter a separação de responsabilidades
- Uso de Annotations e Injeção de Dependências do Spring para um código limpo e desacoplado

### 📈 Validação de Dados

- Validação de dados de entrada com `@Valid` para garantir a integridade das informações

---

### 📦 Gerenciamento de Produtos

- Endpoints para criar, editar, listar e excluir produtos
- Acesso restrito a usuários com o papel `ADMIN`

```http
GET     /product/**     → Lista produtos
POST    /product        → Cria novo produto
PUT     /product        → Atualiza produto existente
DELETE  /product        → Remove produto
```

### 👥 Gerenciamento de Usuários
- Endpoints para editar, listar e excluir usuários
- Acesso restrito a ADMIN

```http
GET     /user/**        → Lista usuários
PUT     /user           → Atualiza usuário
DELETE  /user           → Remove usuário
```

### 🗂️ Gerenciamento de Categorias
- Endpoints para criar, editar, listar e excluir categorias de produtos
- Acesso restrito a ADMIN

```http
GET     /category/**    → Lista categorias
POST    /category       → Cria nova categoria
PUT     /category       → Atualiza categoria
DELETE  /category       → Remove categoria
```

### 🛒 Gerenciamento de Carrinho

- Endpoints para adicionar, remover e gerenciar itens no carrinho de compras
- Acesso restrito a usuários com o papel `CUSTOMER`

```http
POST    /cartItem       → Adiciona item ao carrinho
GET     /cartItem       → Lista itens do carrinho
PUT     /cartItem       → Atualiza item do carrinho
DELETE  /cartItem       → Remove item do carrinho
```

### ⭐ Lista de Favoritos
- Endpoints para gerenciar produtos favoritos
- Acesso restrito a `CUSTOMER`

```http
GET     /favorite       → Lista favoritos do usuário
POST    /favorite       → Adiciona produto aos favoritos
DELETE  /favorite       → Remove produto dos favoritos
```

### 📝 Avaliações de Produtos
- Endpoints para criar e visualizar avaliações
- Acesso restrito a CUSTOMER

```http
GET     /rating         → Lista avaliações
POST    /rating         → Cria nova avaliação
```

--- 

## 🛠️ Tecnologias Utilizadas

- ☕ **Linguagem**: Java (versão 17)
- 🍃 **Framework**: Spring Boot
- 💾 **ORM**: Spring Data JPA
- 🔐 **Segurança**: Spring Security e JWT (Auth0)
- 🐘 **Banco de Dados**: PostgreSQL
- 📦 **Gerenciador de Dependências**: Maven
- ✨ **Outros**: Lombok, Spring Validation

---

## ⚙️ Pré-requisitos

Para rodar este projeto em sua máquina local, você precisará ter instalado:

- Java Development Kit (JDK) 17 ou superior
- Apache Maven

---

## 💻 Como Rodar o Projeto

### 1. Clonar o Repositório

```bash
git clone https://github.com/gialbanes/e-commerce.git
cd e-commerce
```
## 2. Configurar o Banco de Dados

Crie um banco de dados vazio chamado `e-commerce` no seu PostgreSQL local.  
Em seguida, atualize o arquivo `src/main/resources/application.properties` com as credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/e-commerce
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```` 


## 📂 Estrutura do Projeto

```text
com.portfolio.e-commerce
├── controller   # Camada de entrada (HTTP)
├── service      # Lógica de negócio
├── repository   # Persistência de dados
├── entity       # Representação das tabelas
├── dto          # Objetos de Transferência de Dados
└── security     # Configurações de segurança (JWT, Spring Security)
```

## 👤 Autor

**Giovana Albanês**  
🔗 [LinkedIn](https://www.linkedin.com/in/giovanaalbanes/)  
📧 gialbanesantos@gmail.com
