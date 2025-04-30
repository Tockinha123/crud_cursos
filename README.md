# CRUD para plataforma de Cursos

**Este projeto foi criado como atividade prática da Trilha Java da Rocketseat.**

## 📖 Visão Geral

API RESTful simples para gerenciamento de cursos, desenvolvida em **Java 21** com **Spring Boot 3.4.5**. Permite operações CRUD (Create, Read, Update, Delete) sobre recursos de cursos, incluindo validação de dados e persistência em banco PostgreSQL.

## 🛠 Tecnologias e Dependências

- **Java** 21 
- **Spring Boot** 3.4.5 
- **Spring Web** 
- **Spring Data JPA**
- **Hibernate** (via JPA)
- **Validation**
- **Lombok**
- **Banco de dados**: PostgreSQL  (versão padrão do Docker Hub)

## 📂 Estrutura do Projeto

```
└── Crud_Cursos
    ├── src
    │   ├── main
    │   │   ├── java/br/com/tockinha/crud_cursos
    │   │   │   ├── CourseEntity.java      // Entidade JPA
    │   │   │   ├── CourseStatus.java      // Enum de status
    │   │   │   └── CrudCursosApplication.java // Main Spring Boot
    │   │   └── resources
    │   │       └── application.properties  // Configurações (não commitadas)
    │   └── test
    │       └── java/br/com/tockinha/crud_cursos
    │           └── CrudCursosApplicationTests.java
    ├── docker-compose.yml               // Definição do serviço PostgreSQL
    ├── pom.xml                          // Configuração Maven
    └── .gitignore
```

## 🗄 Modelagem de Dados

```java

@Entity(name = "courses")
public class CourseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String category;

    @Enumerated(EnumType.STRING)
    private CourseStatus active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

```

```java
public enum CourseStatus {
    ACTIVE,
    INACTIVE
}
```

## 🚀 Endpoints da API

| Método | URL                    | Descrição                           |
|--------|------------------------|-------------------------------------|
| GET    | `/courses/`            | Listar todos os cursos              |
| GET    | `/courses/{id}`        | Obter curso por ID                  |
| POST   | `/courses/`            | Criar novo curso                    |
| PUT    | `/courses/{id}`        | Atualizar curso existente           |
| PATCH  | `/courses/{id}/active` | Muda o estado da váriavel `active`  |
| DELETE | `/courses/{id}`        | Excluir curso                       |


## 🔧 Requisitos e Configuração Inicial

1. **Pré-requisitos**:
    - Java 21 instalado
    - Maven (incluído no wrapper `mvnw`)
    - Docker & Docker Compose
    - Git

2. **Clone do repositório**:
```bash
git clone https://github.com/Tockinha123/crud_cursos.git
cd crud_cursos
```

3. **Configuração do banco de dados**:
    - Crie dois arquivos na raiz:
        - `db_user_secret`: usuário do Postgres (ex: `postgres`)
        - `db_password_secret`: senha do Postgres (ex: `postgres`)

    - Execute o Docker Compose:
```bash
docker-compose up -d
```

4. **Variáveis de ambiente**:
    - Configure em `src/main/resources/application.properties` ou via variáveis de ambiente:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5431/crud_cursos
      spring.datasource.username=<usuário>
      spring.datasource.password=<senha>
      spring.jpa.hibernate.ddl-auto=update
      ```

## ▶️ Como Executar a Aplicação

No Linux/Mac:
```bash
./mvnw spring-boot:run
```
No Windows:
```bash
mvnw.cmd spring-boot:run
```
A API estará disponível em `http://localhost:8080`.


