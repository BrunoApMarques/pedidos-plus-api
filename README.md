🔐 auth-users-api — API de Autenticação e Gerenciamento de Usuários (Java + Spring Boot + JWT)










API REST desenvolvida com Java + Spring Boot + JWT para autenticação de usuários, cadastro, login e proteção de rotas.

Inclui boas práticas de segurança e estrutura aplicada no mercado.


🚀 Tecnologias Utilizadas
Tecnologia	Função
☕ Java 17+	Linguagem principal
🍃 Spring Boot	Framework
🔐 Spring Security	Responsable pela segurança
🔑 JWT	Autenticação
🧂 BCrypt	Criptografia de senhas
🐙 Git & GitHub	Versionamento
🧪 JUnit/Mockito	Testes automatizados (futuro)

📁 Estrutura do Projeto


src/
main/
java/
com/
bruno/
auth/api
 ├── controller     # Login e cadastro
 ├── model          # Entidade User
 ├── repository     # UserRepository
 └── service        # Regra de negócio + JWT
 

🔐 Fluxo de Autenticação JWT

1️⃣ O usuário envia email + senha
2️⃣ A API valida e gera um JWT Token
3️⃣ O token deve ser enviado no header:

Authorization: Bearer SEU_TOKEN_AQUI


4️⃣ As rotas protegidas só respondem se o token for válido

🔗 Endpoints da API
👤 Cadastro de usuário
🆕 Criar usuário

POST /auth/register

Body:

{
  "nome": "Bruno Marques",
  "email": "bruno@gmail.com",
  "senha": "123456"
}


Resposta:

{
  "id": 1,
  "nome": "Bruno Marques",
  "email": "bruno@gmail.com"
}

🔑 Login (gera o token JWT)
🔐 Login

POST /auth/login

Body:

{
  "email": "bruno@gmail.com",
  "senha": "123456"
}


Resposta:

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}

🛡 Rotas protegidas
📄 Buscar dados do usuário logado

GET /auth/me

Header:

Authorization: Bearer SEU_TOKEN


Resposta:

{
  "id": 1,
  "nome": "Bruno Marques",
  "email": "bruno@gmail.com"
}

🛠 Como rodar o projeto localmente
1️⃣ Clonar o repositório
git clone https://github.com/BrunoApMarques/auth-users-api.git
cd auth-users-api

2️⃣ Rodar a aplicação
mvn spring-boot:run

3️⃣ Testar os endpoints com Postman ou Insomnia
🧪 Testes Automatizados (Planned)

Testes unitários da camada Service

MockMvc nos endpoints

Testes do fluxo JWT

🐳 Rodar com Docker (Opcional — futuro)
docker build -t auth-users-api .
docker run -p 8080:8080 auth-users-api

🗺 Roadmap (Evoluções Futuras)

Atualizar estrutura para DTOs

Implementar refresh token

Adicionar Swagger/OpenAPI

Criar logs estruturados

Criar roles (USER / ADMIN)

👨‍💻 Autor

Bruno Marques
Desenvolvedor Back-end Java | Spring Boot | Microsserviços | Segurança
🔗 GitHub: https://github.com/BrunoApMarques
