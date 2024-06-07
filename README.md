# Projeto Employee Management - Sistematização
Este projeto é uma aplicação Spring Boot para gerenciamento de funcionários, incluindo operações CRUD (Create, Read, Update, Delete) para funcionários e suas informações associadas, como telefones, emails e doenças. Abaixo estão as instruções para clonar o projeto e executá-lo em sua máquina local, além de detalhes sobre os endpoints disponíveis.

Índice
- [Pré-requisitos](#Pré-requisitos)
- [Clonar e Configurar o Projeto](#Clonar-e-Configurar-o-Projeto)
- [Executar a Aplicação](#Executar-a-aplicação)
- [Endpoints da API](#Endpoints-da-API)

## Pré-requisitos
Antes de começar, verifique se você tem os seguintes softwares instalados em sua máquina:

- JDK 11 ou superior
- Maven
- PostgreSQL

## Clonar e Configurar o Projeto
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Acesse o diretório do projeto:
```bash
cd seu-repositorio
```

3. Configure o banco de dados:

Crie um banco de dados PostgreSQL chamado (nome de sua escolha).
Atualize o arquivo application.properties com suas credenciais do banco de dados:
```markdown
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
4. Instale as dependências:
```bash
./mvnw clean install
```

## Executar a Aplicação
Inicie a aplicação Spring Boot:

```bash
./mvnw spring-boot:run
```
A aplicação estará disponível em http://localhost:8080.

## Endpoints da API
Abaixo estão os endpoints disponíveis para o gerenciamento de funcionários e suas informações associadas.

Funcionario
GET /employees

Descrição: Obtém todos os funcionários.
Exemplo de resposta:

```markdown
[
  {
    "id": "43effaef-2f92-497e-8587-6545f4964b04",
    "nome": "João",
    "nascimento": "1990-01-01T00:00:00.000+00:00",
    "telefones": [
      {
        "id": "16ce7fbd-8ce7-4daa-b1dd-c90d6e2cecbd",
        "telefone": "123456789",
        "tipo": "celular"
      }
    ],
    "emails": [
      {
        "id": "9261a734-cf90-4af4-b1f1-e6fac0b75251",
        "email": "joao@hotmail.com"
      }
    ],
    "doencas": [
      {
        "id": "70013430-90a0-4187-9fbf-a2e960d99d6d",
        "doenca": "Gripe",
        "descricao": "nao pode qualquer coisa"
      }
    ]
  }
]
```
POST /employees

Descrição: Cria um novo funcionário.
Exemplo de corpo da requisição:
```markdown
{
  "nome": "Maria",
  "nascimento": "1985-03-15T00:00:00.000+00:00",
  "telefones": [
    {
      "telefone": "987654321",
      "tipo": "residencial"
    }
  ],
  "emails": [
    {
      "email": "maria@example.com"
    }
  ],
  "doencas": [
    {
      "doenca": "Alergia",
      "descricao": "nao pode frutos do mar"
    }
  ]
}
```
PUT /employees/update/{id}

Descrição: Atualiza um funcionário existente pelo ID.
Exemplo de corpo da requisição:
```markdown
{
  "nome": "Maria Silva",
  "nascimento": "1985-03-15T00:00:00.000+00:00",
  "telefones": [
    {
      "telefone": "987654321",
      "tipo": "residencial"
    },
    {
      "telefone": "1122334455",
      "tipo": "celular"
    }
  ],
  "emails": [
    {
      "email": "maria.silva@example.com"
    }
  ],
  "doencas": [
    {
      "doenca": "Alergia",
      "descricao": "nao pode frutos do mar"
    }
  ]
}
```
DELETE /employees/delete/{employeeId}

Descrição: Deleta um funcionário pelo ID.
Exemplo de resposta:
```markdown
{
  "message": "Employee deleted"
}
```
