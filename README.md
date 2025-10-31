# 🧩 Pedidos Plus API

API REST construída com **Spring Boot 3**, **Java 17** e **H2 Database**, para gerenciamento de **clientes e pedidos**.  
Desenvolvida para fins de estudo e prática de arquitetura RESTful, boas práticas e versionamento com Git.

---

## 🚀 Tecnologias

| Stack | Descrição |
|--------|------------|
| ☕ **Java 17** | Linguagem principal do projeto |
| ⚙️ **Spring Boot 3** | Framework para criação de APIs REST |
| 🗃 **Spring Data JPA** | Mapeamento objeto-relacional |
| 🧩 **H2 Database** | Banco de dados em memória para testes |
| 🧰 **Lombok** | Geração automática de getters e setters |
| 📘 **Springdoc OpenAPI** | Geração automática da documentação Swagger |

---

## 🧱 Arquitetura do Projeto

---

src/
├── main/
│ ├── java/com/bruno/pedidosplusapi/
│ │ ├── controller/ → Endpoints REST
│ │ ├── model/ → Entidades e enums
│ │ ├── repository/ → Interfaces JPA
│ │ └── service/ → Regras de negócio
│ └── resources/
│ └── application.properties
└── test/ → Testes unitários e integrados


---

## ⚙️ Configuração e Execução

### 🔧 Requisitos
- **Java 17+**
- **Maven 3.9+**

### ▶️ Executar localmente
Clone o projeto:

bash
git clone https://github.com/BrunoApMarques/pedidos-plus-api.git
cd pedidos-plus-api

Execute a aplicação:
mvn spring-boot:run


Acesse no navegador:
👉 http://localhost:8080/swagger-ui.html


🧪 Endpoints Principais

👤 Clientes

| Método   | Endpoint         | Descrição                |
| -------- | ---------------- | ------------------------ |
| `POST`   | `/clientes`      | Cadastra um novo cliente |
| `GET`    | `/clientes`      | Lista todos os clientes  |
| `GET`    | `/clientes/{id}` | Busca um cliente pelo ID |
| `PUT`    | `/clientes/{id}` | Atualiza um cliente      |
| `DELETE` | `/clientes/{id}` | Remove um cliente        |

.....

