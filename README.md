# API REST de Cadastro de Clientes (com Integração ViaCEP)

[![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)

API RESTful para gerenciamento de clientes, desenvolvida como projeto prático do bootcamp da Digital Innovation One (DIO) e expandida com diversas funcionalidades avançadas para ambiente de produção. O sistema consome a API pública do ViaCEP para preenchimento automático de endereços.

## 🚀 Melhorias e Funcionalidades Implementadas

Além do escopo original do curso, este projeto foi refatorado para incluir práticas de nível Pleno/Sênior:

* **Refatoração Arquitetural (Normalização de Dados):** Desacoplamento de dados específicos do cliente (Número da casa e Complemento) da tabela de Endereços. A tabela de `Endereco` atua como um dicionário único de ruas, otimizando o armazenamento no banco de dados.
* **Validações de Entrada (Spring Validation):** Implementação de anotações como `@NotBlank` e `@NotNull` no Model e `@Valid` no Controller, impedindo a inserção de dados inconsistentes (ex: clientes sem nome).
* **Tratamento de Integrações Externas (CEP Fantasma):** Proteção contra "Falsos Positivos" da API do ViaCEP. Se um CEP estiver no formato correto mas for inexistente no Brasil, o sistema intercepta o JSON de erro do ViaCEP e lança uma `IllegalArgumentException`, bloqueando a gravação de endereços em branco no banco.
* **Migração de Banco de Dados:** Substituição do H2 (em memória) pelo MySQL em um container Docker, garantindo persistência real dos dados.
* **Busca Personalizada:** Criação de endpoints adicionais (ex: busca filtrada por nome usando recursos nativos do Spring Data JPA).

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3** (Web, Data JPA, Validation)
* **Spring Cloud OpenFeign** (Para consumo da API ViaCEP)
* **MySQL** (Persistência de Dados)
* **Docker** (Infraestrutura)
* **Swagger/Springdoc OpenAPI** (Documentação da API)

## ⚙️ Como executar o projeto localmente

### 1. Subindo o Banco de Dados (Docker)
Execute o comando abaixo no seu terminal para criar e rodar o container do MySQL:
```bash
docker run --name mysql-spring -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=lab_spring -p 3306:3306 -d mysql:8.0
```

### 2. Rodando a Aplicação
Você pode rodar a aplicação diretamente pela sua IDE (IntelliJ/Eclipse) executando a classe `Application.java`, ou via terminal utilizando o Gradle:
```bash
./gradlew bootRun
```

### 3. Acessando a Documentação (Swagger)
Com a aplicação rodando, acesse a interface interativa do Swagger no seu navegador para testar os endpoints:
```text
http://localhost:8080/swagger-ui.html
```

## 📝 Exemplo de Payload (POST /clientes)

```json
{
  "nome": "Fátima",
  "numero": "123",
  "complemento": "Apto 45 Bloco B",
  "endereco": {
    "cep": "58102-337"
  }
}
```

---
Desenvolvido com dedicação por Marcelo Abrantes durante os estudos de aprimoramento em Java e Spring Framework.
