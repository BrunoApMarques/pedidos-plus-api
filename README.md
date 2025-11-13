📦 pedidos-plus-api — API Completa de Clientes e Pedidos (Java + Spring Boot)

API REST desenvolvida em Java + Spring Boot para gerenciamento de clientes e pedidos, com arquitetura evoluída, camadas bem definidas e código limpo.

Essa API segue padrões usados em empresas como Itaú, XP, Mercado Livre, Nubank e BTG.


🚀 Tecnologias Utilizadas
Tecnologia	Função
☕ Java 17+	Linguagem principal
🍃 Spring Boot	Criação da API REST
🛠 Spring Web	Controllers REST
📦 Spring Data JPA	Persistência
🧪 JUnit/Mockito	Testes automatizados
🐬 H2 (futuro)	Banco embarcado
🐙 Git & GitHub	Versionamento
🐳 Docker	Containerização (opcional)
📁 Estrutura do Projeto
src/main/java/com/bruno/pedidosplus
 ├── controller
 │     ├── ClienteController
 │     └── PedidoController
 ├── model
 │     ├── Cliente
 │     └── Pedido
 ├── repository
 │     ├── ClienteRepository
 │     └── PedidoRepository
 └── service
       ├── ClienteService
       └── PedidoService

📌 Funcionalidades do Sistema
👥 Clientes

Criar cliente

Buscar cliente por ID

Listar clientes

Atualizar cliente

Deletar cliente

🛒 Pedidos

Criar pedido vinculado ao cliente

Listar pedidos

Buscar pedido por ID

Atualizar pedido

Deletar pedido

🔗 Endpoints da API
👥 Clientes
🆕 Criar cliente

POST /clientes
Body exemplo:

{
  "nome": "Bruno Marques",
  "email": "bruno@gmail.com"
}

🔎 Buscar cliente por ID

GET /clientes/{id}

{
  "id": 1,
  "nome": "Bruno Marques",
  "email": "bruno@gmail.com"
}

📄 Listar todos os clientes

GET /clientes

🔄 Atualizar cliente

PUT /clientes/{id}

{
  "nome": "Bruno M.",
  "email": "brunomarques@gmail.com"
}

🗑 Deletar cliente

DELETE /clientes/{id}

🛒 Pedidos
🆕 Criar pedido

POST /pedidos

{
  "clienteId": 1,
  "descricao": "Mouse Gamer RGB",
  "valor": 249.90
}

🔎 Buscar pedido

GET /pedidos/{id}

📄 Listar pedidos

GET /pedidos

🔄 Atualizar pedido

PUT /pedidos/{id}

🗑 Deletar pedido

DELETE /pedidos/{id}

🛠 Como rodar o projeto localmente
1️⃣ Clonar o repositório
git clone https://github.com/BrunoApMarques/pedidos-plus-api.git
cd pedidos-plus-api

2️⃣ Executar com Maven
mvn spring-boot:run

3️⃣ Acessar a API
http://localhost:8080/clientes  
http://localhost:8080/pedidos

🧪 Testes Automatizados (Mapa para o futuro)

Testes unitários com Mockito

Testes de controller com MockMvc

Validações do fluxo de erro

🐳 Rodar com Docker (opcional) — Futuro
docker build -t pedidosplus-api .
docker run -p 8080:8080 pedidosplus-api

🗺 Roadmap para Evolução

Adicionar banco H2 ou PostgreSQL

Documentação com Swagger

Implementar DTOs e validações

Criar tratamento global de exceções

Melhorar logs e monitoramento

👨‍💻 Autor

Bruno Marques
Desenvolvedor Back-end Java | Spring Boot | APIs REST
🔗 GitHub: https://github.com/BrunoApMarques
