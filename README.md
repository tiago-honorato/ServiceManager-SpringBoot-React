# Web service de Gestão de Serviços 🛠️📋

Aplicação para a gestão de serviços utilizando backend Java Spring Boot e frontend React. Demonstra como realizar operações de CRUD (Create, Read, Update, Delete) e gerenciar serviços, incluindo o controle de pagamentos e status de cancelamento.

<img src="https://github.com/tiago-honorato/ServiceManager-SpringBoot-React/assets/85461392/da7ab345-78ec-4f88-a8e1-af8779fbd1e6">

## Funcionalidades 📊
- Cadastro de serviços
- Listagem de todos os serviços
- Listagem de serviços com pagamento pendente
- Listagem de serviços cancelados
- Atualização de serviços
- Cancelamento de serviços
- Exclusão de serviços

## Tecnologias Utilizadas ⚙️
- Spring Boot
- Java 17
- Spring Data JPA
- MySQL
- React
- Bootstrap
- Axios

## Estrutura do Projeto 📁

### Backend

```plaintext
backservico/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── servico/
│   │   │           └── backservico/
│   │   │               ├── controller/
│   │   │               │   └── ServicoController.java
│   │   │               ├── entity/
│   │   │               │   └── Servico.java
│   │   │               ├── repository/
│   │   │               │   └── ServicoRepository.java
│   │   │               ├── service/
│   │   │               │   └── ServicoService.java
│   │   │               └── BackservicoApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
│       └── java/
├── .mvn/
├── .settings/
├── src/
├── target/
├── .classpath
├── .gitignore
├── .project
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```

### Frontend

```plaintext
frontservico/
├── node_modules/
├── public/
│   ├── favicon.ico
│   ├── index.html
│   ├── logo192.png
│   ├── logo512.png
│   ├── manifest.json
│   └── robots.txt
├── src/
│   ├── servico/
│   │   ├── Servico.css
│   │   └── Servico.jsx
│   ├── App.css
│   ├── App.js
│   ├── App.test.js
│   ├── index.css
│   ├── index.js
│   ├── logo.svg
│   ├── reportWebVitals.js
│   └── setupTests.js
├── .gitignore
├── package-lock.json
├── package.json
└── README.md
```

## Pré-requisitos

- Java 17
- Node.js
- MySQL

## Configuração do Ambiente 🔧

### Backend

1. Clone o repositório:

    ```bash
    git clone https://github.com/tiago-honorato/ServiceManager-SpringBoot-React.git
    cd ServiceManager-SpringBoot-React
    ```

2. Execute o arquivo `create-database.sql` para criar o schema "sistemaservicos".

3. Configure o banco de dados MySQL no arquivo `application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/sistemaservicos
    spring.datasource.username=SeuUsuario
    spring.datasource.password=SuaSenha
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    ```

4. Execute a aplicação:

    ```bash
    ./mvnw spring-boot:run
    ```

### Frontend

1. Navegue até a pasta do frontend:

    ```bash
    cd frontend
    ```

2. Instale as dependências:

    ```bash
    npm install
    ```

3. Inicie a aplicação:

    ```bash
    npm start
    ```

A aplicação frontend estará disponível em `http://localhost:3000`.

## Endpoints da API

### GET `/api/servico/`
Retorna todos os serviços.

### GET `/api/servico/pagamentoPendente`
Retorna todos os serviços com pagamento pendente.

### GET `/api/servico/cancelados`
Retorna todos os serviços cancelados.

### POST `/api/servico/`
Adiciona um novo serviço.

### POST `/api/servico/{id}`
Cancela um serviço pelo ID.

### PUT `/api/servico/`
Atualiza um serviço existente.

### DELETE `/api/servico/{id}`
Exclui um serviço pelo ID.

## Interface do Usuário

A interface permite:

- Inserir um novo serviço.
- Listar todos os serviços, serviços com pagamento pendente e serviços cancelados.
- Alterar, excluir e cancelar serviços.
