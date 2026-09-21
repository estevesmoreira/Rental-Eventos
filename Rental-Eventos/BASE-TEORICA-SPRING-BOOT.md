# BASE TEÓRICA — JAVA + SPRING BOOT + JPA + REST + SECURITY + JWT

> **Objetivo:** este arquivo é a base conceitual para a prova.  
> O outro manual responde principalmente **“como implementar?”**. Este responde **“o que é?”, “por que existe?”, “qual a diferença?”, “quando usar?” e “o que podem perguntar?”**.
>
> A referência prática é o projeto **Rental Eventos** e sua arquitetura com Java, Spring Boot, JPA, PostgreSQL, Validation, Spring Security, JWT, Swagger/OpenAPI, DTOs, Repository, Service e Controller. As explicações teóricas ampliam essa base com fundamentos gerais necessários para compreender e adaptar o projeto a outros minimundos.

---

# SUMÁRIO

1. [Mapa mental do sistema](#sec-01)
2. [Java: conceitos essenciais para a prova](#sec-02)
3. [Spring Framework x Spring Boot](#sec-03)
4. [IoC, Injeção de Dependência, Beans e anotações Spring](#sec-04)
5. [Maven, `pom.xml`, dependências e build](#sec-05)
6. [Cliente, servidor, API, HTTP, REST e JSON](#sec-06)
7. [Arquitetura em camadas: Entity, DTO, Repository, Service e Controller](#sec-07)
8. [DTOs e validação](#sec-08)
9. [Banco relacional, PostgreSQL, PK, FK e constraints](#sec-09)
10. [JPA, Hibernate e ORM](#sec-10)
11. [Relacionamentos JPA: OneToOne, OneToMany, ManyToOne e ManyToMany](#sec-11)
12. [Cascade, Fetch, LAZY/EAGER e serialização](#sec-12)
13. [Repository e Spring Data JPA](#sec-13)
14. [Service e regras de negócio](#sec-14)
15. [Controller, endpoints e parâmetros HTTP](#sec-15)
16. [CRUD e semântica dos métodos HTTP](#sec-16)
17. [Códigos HTTP: 200, 201, 204, 400, 401, 403, 404, 409 e 500](#sec-17)
18. [Exceções e tratamento de erros](#sec-18)
19. [Autenticação, autorização e Spring Security](#sec-19)
20. [Senha, hash, BCrypt e PasswordEncoder](#sec-20)
21. [JWT por dentro](#sec-21)
22. [JWT x sessão e autenticação stateless](#sec-22)
23. [Roles, Authorities, `hasRole` e `hasAuthority`](#sec-23)
24. [OAuth2 Resource Server no projeto](#sec-24)
25. [Swagger, OpenAPI e documentação da API](#sec-25)
26. [`application.properties` e configuração](#sec-26)
27. [Maven Wrapper, cache `.m2` e funcionamento offline](#sec-27)
28. [Modelagem de um minimundo](#sec-28)
29. [Tipos Java mais importantes](#sec-29)
30. [Enums](#sec-30)
31. [`record` x classe tradicional](#sec-31)
32. [`Optional`](#sec-32)
33. [Transações e `@Transactional`](#sec-33)
34. [Persistência, estado de entidade e erros comuns do JPA](#sec-34)
35. [DDL, `ddl-auto` e mudanças no banco](#sec-35)
36. [Component Scan e organização de packages](#sec-36)
37. [Diferenças que você precisa saber de cabeça](#sec-37)
38. [Armadilhas conceituais comuns](#sec-38)
39. [Possíveis perguntas de prova — respostas curtas](#sec-39)
40. [Perguntas de raciocínio e cenários](#sec-40)
41. [Perguntas orais rápidas](#sec-41)
42. [Checklist teórico final](#sec-42)
43. [Resumo de uma página](#sec-43)

---

<a id="sec-01"></a>
# 1. MAPA MENTAL DO SISTEMA

Antes de estudar anotações isoladas, entenda o caminho completo.

```text
CLIENTE
   |
   | HTTP + JSON
   v
CONTROLLER
   |
   | DTO
   v
SERVICE
   |
   | Entity / regras de negócio
   v
REPOSITORY
   |
   | JPA / Hibernate / SQL
   v
BANCO POSTGRESQL
```

Na volta:

```text
BANCO
  |
  v
REPOSITORY
  |
  v
ENTITY
  |
  | conversão
  v
RESPONSE DTO
  |
  v
CONTROLLER
  |
  | HTTP + JSON
  v
CLIENTE
```

Segurança envolve todo o caminho HTTP:

```text
REQUISIÇÃO
    |
    v
SPRING SECURITY
    |
    | valida token / permissão
    v
CONTROLLER
```

A ideia central é **separação de responsabilidades**.

Cada camada tem uma função.

- **Entity** representa dados persistidos.
- **DTO** representa dados que entram ou saem da API.
- **Repository** acessa o banco.
- **Service** implementa regras de negócio.
- **Controller** recebe e responde HTTP.
- **Security** controla acesso.
- **JWT** transporta informações de autenticação.
- **Swagger/OpenAPI** documenta e permite testar a API.
- **Maven** gerencia dependências e o processo de build.

Uma resposta excelente para muitas perguntas teóricas começa por essa separação.

---

<a id="sec-02"></a>
# 2. JAVA: CONCEITOS ESSENCIAIS PARA A PROVA

## 2.1 Classe

Classe é um molde para criar objetos.

```java
public class Usuario {

    private Long id;
    private String nome;
    private String email;

}
```

`Usuario` é a classe.

Um objeto seria uma instância:

```java
Usuario usuario = new Usuario();
```

## 2.2 Objeto

Objeto é uma instância concreta de uma classe.

```java
Usuario usuario = new Usuario();

usuario.setNome("Nicolas");
```

A classe define a estrutura; o objeto contém valores em execução.

---

## 2.3 Atributo

É uma variável pertencente à classe.

```java
private String nome;
```

Em uma Entity, atributos frequentemente correspondem a colunas do banco.

---

## 2.4 Método

Representa um comportamento.

```java
public String getNome() {
    return nome;
}
```

ou:

```java
public void alterarNome(String novoNome) {
    this.nome = novoNome;
}
```

---

## 2.5 Construtor

Construtor é executado ao criar objeto com `new`.

```java
public Usuario() {
}
```

```java
public Usuario(String nome, String email) {
    this.nome = nome;
    this.email = email;
}
```

No JPA, Entities normalmente precisam possuir um construtor sem argumentos acessível ao framework.

---

## 2.6 Encapsulamento

Encapsulamento significa esconder detalhes internos e controlar acesso.

Por isso atributos normalmente são:

```java
private
```

e acessados por métodos:

```java
getNome()
setNome(...)
```

Vantagens:

- reduz acesso descontrolado;
- permite adicionar validações;
- torna a classe mais previsível;
- reduz acoplamento.

---

## 2.7 `private`, `public` e modificadores de acesso

### `private`

Só a própria classe acessa diretamente.

```java
private String senha;
```

### `public`

Pode ser acessado externamente.

```java
public String getNome() {
    return nome;
}
```

Há ainda `protected` e acesso de pacote, mas para sua prova os dois anteriores são os mais presentes.

---

## 2.8 Interface

Uma interface define um contrato.

Exemplo:

```java
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
}
```

`JpaRepository` é uma interface.

Seu `UsuarioRepository` herda o contrato e funcionalidades disponibilizadas pelo Spring Data.

---

## 2.9 Herança

Herança significa que uma classe ou interface recebe características de outra.

Classe:

```java
class Cachorro extends Animal {
}
```

Interface:

```java
interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
}
```

---

## 2.10 Polimorfismo

É a capacidade de trabalhar com um tipo abstrato/interface enquanto a implementação concreta pode variar.

Exemplo conceitual:

```java
PasswordEncoder encoder;
```

A variável usa a abstração `PasswordEncoder`.

A implementação pode ser:

```java
new BCryptPasswordEncoder();
```

Isso reduz acoplamento.

---

## 2.11 Tipos primitivos x wrappers

Primitivos:

```java
int
long
double
float
boolean
```

Wrappers:

```java
Integer
Long
Double
Float
Boolean
```

Diferença importante:

```text
int     nunca é null
Integer pode ser null
```

Em DTOs e Entities, wrappers são comuns porque `null` pode representar ausência de valor.

---

## 2.12 `==` x `.equals()`

Para objetos, normalmente use `.equals()` para comparar conteúdo.

```java
id1.equals(id2)
```

`==` compara referências para objetos.

Para primitivos:

```java
int a = 1;
int b = 1;

a == b
```

é adequado.

String:

```java
email.equals(outroEmail)
```

Evite:

```java
email == outroEmail
```

---

## 2.13 `null`

`null` significa ausência de referência/valor.

Pode causar:

```text
NullPointerException
```

Exemplo perigoso:

```java
usuario.getNome().trim();
```

Se `getNome()` retornar `null`, ocorre erro.

Bean Validation e regras de negócio ajudam a controlar isso.

---

<a id="sec-03"></a>
# 3. SPRING FRAMEWORK X SPRING BOOT

Essa diferença é pergunta clássica.

## Spring Framework

É um ecossistema/framework para Java que fornece recursos como:

- Injeção de Dependência;
- IoC;
- Spring MVC;
- acesso a dados;
- transações;
- segurança;
- integração entre componentes.

## Spring Boot

Spring Boot é construído sobre o Spring e busca facilitar configuração e inicialização.

Ele oferece principalmente:

- auto-configuração;
- starters de dependências;
- servidor embutido;
- convenções;
- configuração externa;
- inicialização simplificada.

Resposta curta:

> **Spring é o framework/ecossistema. Spring Boot simplifica a configuração e execução de aplicações Spring.**

Não são concorrentes.

Spring Boot usa Spring.

---

## 3.1 O que faz `@SpringBootApplication`?

```java
@SpringBootApplication
public class ProvaApplication {
}
```

É uma anotação composta que reúne ideias importantes do Spring Boot, incluindo:

- configuração;
- auto-configuração;
- component scanning.

Na prática, ela marca a classe principal da aplicação.

---

## 3.2 Auto-configuração

Spring Boot observa:

- dependências presentes;
- propriedades configuradas;
- classes disponíveis;

e configura diversos componentes automaticamente.

Exemplo:

se há dependências Web, ele configura infraestrutura Web.

Se há JPA + DataSource, configura infraestrutura de persistência.

---

## 3.3 Starter

Starter é uma dependência agregadora/conveniente do Spring Boot.

Em vez de adicionar manualmente dezenas de bibliotecas relacionadas, utiliza-se um starter.

Exemplo:

```xml
<artifactId>spring-boot-starter-data-jpa</artifactId>
```

Ele reúne dependências necessárias para trabalhar com JPA no padrão do Spring Boot.

---

<a id="sec-04"></a>
# 4. IOC, INJEÇÃO DE DEPENDÊNCIA, BEANS E ANOTAÇÕES SPRING

## 4.1 IoC — Inversion of Control

Sem framework:

```java
UsuarioRepository repository =
        new UsuarioRepositoryImpl();

UsuarioService service =
        new UsuarioService(repository);
```

Você cria e conecta manualmente objetos.

Com Spring:

```java
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(
            UsuarioRepository repository) {

        this.repository = repository;
    }
}
```

O Spring cria e fornece as dependências.

Isso é parte da **Inversão de Controle**.

Em vez de sua classe controlar a criação de tudo, o container assume essa responsabilidade.

---

## 4.2 Dependency Injection

Injeção de Dependência é uma forma de implementar IoC.

A classe declara do que precisa:

```java
private final UsuarioRepository repository;
```

e recebe pelo construtor:

```java
public UsuarioService(
        UsuarioRepository repository) {

    this.repository = repository;
}
```

O Spring injeta o objeto adequado.

---

## 4.3 Por que injeção por construtor?

Vantagens:

- dependências ficam explícitas;
- facilita testes;
- permite campos `final`;
- objeto nasce completo;
- evita dependências escondidas.

Por isso é preferível ao padrão:

```java
@Autowired
private UsuarioRepository repository;
```

embora ambos possam funcionar.

---

## 4.4 O que é Bean?

Bean é um objeto gerenciado pelo container do Spring.

Exemplos:

```java
@Service
public class UsuarioService {
}
```

O Spring registra uma instância como Bean.

Também:

```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

O objeto retornado passa a ser um Bean.

---

## 4.5 Principais anotações estereótipo

### `@Component`

Anotação genérica de componente Spring.

```java
@Component
public class JwtUtil {
}
```

### `@Service`

Especialização semântica de Component para camada de serviço.

```java
@Service
public class UsuarioService {
}
```

### `@Repository`

Indica camada de persistência.

```java
@Repository
public interface UsuarioRepository ...
```

Spring Data normalmente já identifica interfaces de Repository automaticamente.

### `@Controller`

Controller MVC tradicional, frequentemente usado quando há views.

### `@RestController`

Usado em APIs REST.

Equivale conceitualmente a:

```text
@Controller + resposta serializada no corpo
```

### `@Configuration`

Classe de configuração.

```java
@Configuration
public class SecurityConfig {
}
```

### `@Bean`

Registra manualmente um objeto no container.

---

## 4.6 Component Scan

O Spring procura componentes a partir do pacote da classe principal.

Exemplo:

```text
com.senai.infoa.prova
    ProvaApplication

com.senai.infoa.prova.service
com.senai.infoa.prova.controller
```

Esses pacotes estão abaixo da raiz e são encontrados.

Se a classe principal estiver em um subpacote incorreto, componentes irmãos podem ficar fora da busca.

---

<a id="sec-05"></a>
# 5. MAVEN, `pom.xml`, DEPENDÊNCIAS E BUILD

## 5.1 O que é Maven?

Maven é uma ferramenta de:

- gerenciamento de dependências;
- compilação;
- testes;
- empacotamento;
- organização do ciclo de build.

Não é o compilador Java.

Ele **orquestra** ferramentas e plugins, incluindo compilação.

---

## 5.2 `pom.xml`

POM significa **Project Object Model**.

É o arquivo central de configuração Maven.

Contém:

- identificação do projeto;
- versão do Java;
- parent;
- dependências;
- plugins;
- configurações de build.

---

## 5.3 Coordenadas Maven

Uma dependência costuma ser identificada por:

```text
groupId
artifactId
version
```

Exemplo conceitual:

```xml
<groupId>io.jsonwebtoken</groupId>
<artifactId>jjwt-api</artifactId>
<version>0.12.6</version>
```

---

## 5.4 `groupId`

Representa organização/grupo.

Exemplo:

```text
com.senai.infoa
```

---

## 5.5 `artifactId`

Nome do artefato/projeto.

Exemplo:

```text
rental-eventos
```

---

## 5.6 Dependência transitiva

Se A depende de B e B depende de C, o Maven pode trazer C transitivamente.

Isso explica por que nem toda biblioteca utilizada aparece explicitamente no `pom.xml`.

---

## 5.7 Scope

Exemplos:

### `runtime`

Necessário em execução, mas não necessariamente para escrever código contra sua API.

PostgreSQL Driver frequentemente aparece assim.

### `test`

Usado somente em testes.

### `provided`

Disponível para compilação, mas esperado externamente em runtime em certos cenários.

---

## 5.8 Lifecycle

Comandos importantes:

```text
clean
compile
test
package
install
```

### `clean`

Remove arquivos gerados anteriores, normalmente `target/`.

### `compile`

Compila código principal.

### `test`

Executa testes.

### `package`

Gera o artefato, normalmente `.jar`.

### `install`

Coloca o artefato no repositório Maven local.

---

## 5.9 `BUILD SUCCESS` x `BUILD FAILURE`

`BUILD SUCCESS` significa que o Maven concluiu o objetivo solicitado.

Não significa automaticamente que todas as regras de negócio estão corretas.

Pode compilar e ainda haver:

- bug lógico;
- endpoint errado;
- segurança errada;
- regra ausente.

---

<a id="sec-06"></a>
# 6. CLIENTE, SERVIDOR, API, HTTP, REST E JSON

## 6.1 Cliente

É quem faz a requisição.

Pode ser:

- navegador;
- frontend;
- aplicativo;
- Swagger UI;
- Postman;
- outro sistema.

---

## 6.2 Servidor

É quem recebe requisições e devolve respostas.

Sua aplicação Spring Boot atua como servidor HTTP.

---

## 6.3 API

API é uma interface pela qual sistemas se comunicam.

Em uma API HTTP, isso ocorre por endpoints.

Exemplo:

```text
POST /usuarios
GET /equipamentos
```

---

## 6.4 Endpoint

É uma combinação relevante de:

- caminho/URL;
- método HTTP.

Estes são endpoints diferentes:

```text
GET /usuarios
POST /usuarios
```

Mesmo caminho, métodos diferentes.

---

## 6.5 HTTP

HTTP é o protocolo usado para comunicação Web.

Uma requisição contém, entre outras coisas:

- método;
- caminho;
- headers;
- possivelmente body.

Uma resposta contém:

- status;
- headers;
- possivelmente body.

---

## 6.6 Header

Metadados da requisição/resposta.

Exemplo de autenticação:

```text
Authorization: Bearer TOKEN
```

Tipo do corpo:

```text
Content-Type: application/json
```

---

## 6.7 Body

É o corpo da requisição.

Exemplo:

```json
{
  "nome": "Nicolas",
  "email": "nicolas@email.com"
}
```

---

## 6.8 JSON

JSON é um formato textual de representação de dados.

Tipos comuns:

```json
{
  "texto": "abc",
  "numero": 10,
  "decimal": 10.5,
  "booleano": true,
  "nulo": null,
  "lista": [1, 2, 3],
  "objeto": {
    "id": 1
  }
}
```

---

## 6.9 REST

REST é um estilo arquitetural.

Em APIs REST, recursos são identificados por URLs e manipulados utilizando semântica HTTP.

Exemplo:

```text
/usuarios
/equipamentos
/reservas
```

Em vez de:

```text
/criarUsuario
/listarUsuarios
/apagarUsuario
```

é comum preferir:

```text
POST   /usuarios
GET    /usuarios
DELETE /usuarios/{id}
```

---

## 6.10 Stateless

Uma API stateless evita depender de estado de sessão armazenado no servidor entre requisições.

Cada requisição deve trazer o necessário para ser processada.

JWT é frequentemente usado nesse modelo.

---

<a id="sec-07"></a>
# 7. ARQUITETURA EM CAMADAS: ENTITY, DTO, REPOSITORY, SERVICE E CONTROLLER

Essa é provavelmente a parte teórica mais importante.

## 7.1 Entity

Representa o modelo persistido.

```java
@Entity
public class Usuario {

    @Id
    private Long id;

    private String email;

    private String senha;
}
```

Responsabilidade:

```text
estrutura persistente / mapeamento com banco
```

---

## 7.2 DTO

DTO significa **Data Transfer Object**.

Serve para transportar dados entre fronteiras da aplicação.

Exemplo:

```java
public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email
) {
}
```

A senha pode existir na Entity e não no ResponseDTO.

---

## 7.3 Repository

Responsável por acesso/persistência.

```java
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
}
```

É a camada que conversa conceitualmente com o banco através da infraestrutura JPA.

---

## 7.4 Service

Implementa casos de uso e regras de negócio.

Exemplo:

```text
verificar e-mail duplicado
criptografar senha
validar estoque
calcular valor
buscar entidades relacionadas
```

---

## 7.5 Controller

É a fronteira HTTP.

Recebe:

```text
HTTP
```

converte/encaminha dados e devolve:

```text
HTTP
```

Não deveria concentrar regras complexas de negócio.

---

## 7.6 Fluxo correto

```text
Controller
    ↓
Service
    ↓
Repository
```

Evite:

```text
Controller
    ↓
Repository
```

quando a arquitetura da prova pede Service.

O segundo funciona tecnicamente em sistemas simples, mas perde separação de responsabilidades.

---

## 7.7 Por que separar?

### Manutenção

Mudanças ficam localizadas.

### Testabilidade

É mais fácil testar regras no Service.

### Segurança

Você controla dados expostos usando DTO.

### Reutilização

Um Service pode ser chamado por diferentes Controllers/casos.

### Clareza

Cada classe possui função previsível.

---

<a id="sec-08"></a>
# 8. DTOS E VALIDAÇÃO

## 8.1 Entity x RequestDTO x ResponseDTO

Pense:

```text
Entity       = como persisto
RequestDTO   = o que aceito
ResponseDTO  = o que devolvo
```

Exemplo:

Entity:

```text
id
nome
email
senhaHash
tipo
dataCriacao
```

Request:

```text
nome
email
senha
tipo
```

Response:

```text
id
nome
email
tipo
```

---

## 8.2 Por que não retornar Entity diretamente?

Porque a Entity pode conter:

- senha;
- campos internos;
- relações enormes;
- campos que cliente não deveria alterar;
- detalhes da estrutura do banco.

DTO desacopla contrato da API da persistência.

---

## 8.3 Bean Validation

Permite declarar restrições.

```java
@NotBlank
String nome
```

```java
@Email
String email
```

```java
@Positive
Integer quantidade
```

---

## 8.4 `@Valid`

O DTO pode possuir anotações, mas o Controller normalmente precisa solicitar validação:

```java
public ResponseEntity<?> salvar(
        @Valid @RequestBody UsuarioRequestDTO dto) {
}
```

---

## 8.5 `@NotNull`

Só proíbe `null`.

```java
@NotNull
Integer quantidade
```

---

## 8.6 `@NotEmpty`

Para tipos suportados como String/coleções, exige que não sejam nulos nem vazios.

---

## 8.7 `@NotBlank`

Voltado a texto.

Rejeita:

```text
null
""
"   "
```

Para nome, geralmente é melhor que apenas `@NotNull`.

---

## 8.8 `@Positive` x `@PositiveOrZero`

```java
@Positive
```

aceita apenas:

```text
> 0
```

```java
@PositiveOrZero
```

aceita:

```text
>= 0
```

---

## 8.9 Validação de formato x regra de negócio

DTO:

```text
email deve ter formato de email
nome não pode estar vazio
quantidade precisa ser positiva
```

Service:

```text
email não pode já existir no banco
estoque precisa ser suficiente
data final não pode contrariar outra informação do sistema
usuário precisa possuir permissão
```

Boa resposta:

> **Bean Validation trata muito bem restrições estruturais de entrada; regras que dependem de estado, banco ou outras entidades pertencem normalmente ao Service.**

---

<a id="sec-09"></a>
# 9. BANCO RELACIONAL, POSTGRESQL, PK, FK E CONSTRAINTS

## 9.1 Banco relacional

Organiza dados em tabelas relacionadas.

Exemplo:

```text
usuarios
eventos
equipamentos
```

---

## 9.2 Tabela

Conjunto de linhas com colunas definidas.

```text
usuarios
---------------------------------
id | nome | email | senha | tipo
```

---

## 9.3 Linha/registro

Uma ocorrência.

```text
1 | Nicolas | n@email.com | ... | ADMIN
```

---

## 9.4 Coluna

Um atributo do registro.

```text
email
nome
tipo
```

---

## 9.5 Primary Key — PK

Identifica unicamente uma linha.

Exemplo:

```text
id
```

JPA:

```java
@Id
private Long id;
```

---

## 9.6 Foreign Key — FK

Referência a uma linha de outra tabela.

Exemplo:

```text
eventos.usuario_id
    ↓
usuarios.id
```

Isso representa relação.

---

## 9.7 `NOT NULL`

Impede valor SQL nulo.

JPA:

```java
@Column(nullable = false)
```

---

## 9.8 `UNIQUE`

Impede duplicidade.

```java
@Column(unique = true)
private String email;
```

Mas também é comum verificar no Service para devolver erro compreensível.

---

## 9.9 Integridade referencial

O banco impede referências inválidas.

Se:

```text
evento.usuario_id = 50
```

mas usuário 50 não existe, a FK deve impedir esse estado.

---

## 9.10 Por que CPF, telefone e CEP costumam ser `String`?

Porque são identificadores, não grandezas matemáticas.

Você não soma telefones.

Além disso podem possuir:

- zeros à esquerda;
- formatação;
- símbolos.

---

## 9.11 Normalização — ideia essencial

Normalização reduz duplicação e inconsistência.

Exemplo ruim:

```text
evento
id
nome
usuario_nome
usuario_email
usuario_senha
```

Se o usuário tiver vários eventos, os dados dele se repetem.

Melhor:

```text
usuarios
id
nome
email

eventos
id
nome
usuario_id
```

Não precisa decorar todas as formas normais para usar a ideia principal:

> **dados de entidades diferentes devem ser modelados separadamente quando representam conceitos próprios e reutilizáveis.**

---

<a id="sec-10"></a>
# 10. JPA, HIBERNATE E ORM

Outra diferença clássica.

## 10.1 ORM

ORM significa **Object-Relational Mapping**.

É a ideia de mapear:

```text
objetos Java
↕
tabelas relacionais
```

Exemplo:

```java
class Usuario
```

mapeado para:

```text
usuarios
```

---

## 10.2 JPA

JPA é uma **especificação/API padrão de persistência em Java**.

Ela define conceitos/anotações como:

```java
@Entity
@Id
@OneToMany
@ManyToOne
```

JPA descreve o contrato.

---

## 10.3 Hibernate

Hibernate é uma implementação ORM muito utilizada e implementa JPA.

Resposta de prova:

> **JPA é a especificação; Hibernate é uma implementação/provedor que executa essa especificação.**

Spring Data JPA ainda é outra camada.

---

## 10.4 Spring Data JPA

Spring Data JPA facilita uso de JPA, principalmente Repositories.

Ele fornece:

```java
JpaRepository
```

e criação de consultas a partir de nomes de métodos.

Portanto:

```text
JPA          = especificação
Hibernate    = implementação ORM/provedor
Spring Data  = abstração/facilidade para acesso a dados usando JPA
```

---

## 10.5 `@Entity`

Marca uma classe como entidade persistente.

```java
@Entity
public class Usuario {
}
```

---

## 10.6 `@Table`

Define/configura tabela.

```java
@Table(name = "usuarios")
```

---

## 10.7 `@Id`

Define chave primária.

```java
@Id
private Long id;
```

---

## 10.8 `@GeneratedValue`

Define geração automática do ID.

```java
@GeneratedValue(
    strategy = GenerationType.IDENTITY
)
```

`IDENTITY` normalmente delega ao mecanismo de identidade/autoincremento do banco.

---

## 10.9 `@Column`

Configura coluna.

```java
@Column(
    nullable = false,
    unique = true
)
private String email;
```

---

## 10.10 Persistence Context — noção útil

O JPA mantém entidades gerenciadas em um contexto de persistência durante determinada operação/transação.

Uma entidade gerenciada pode ter mudanças detectadas pelo Hibernate.

Isso ajuda a entender por que buscar uma Entity, modificar campos e persistir/confirmar transação funciona de maneira diferente de criar objetos soltos.

Não precisa dominar internamente para a prova prática, mas ajuda a explicar erros como:

```text
detached entity
transient instance
LazyInitializationException
```

---

<a id="sec-11"></a>
# 11. RELACIONAMENTOS JPA

Primeiro pense na cardinalidade do mundo real.

---

## 11.1 OneToOne — 1 para 1

Exemplo:

```text
Pessoa 1 ---- 1 Perfil
```

```java
@OneToOne
@JoinColumn(name = "perfil_id")
private Perfil perfil;
```

Use quando uma ocorrência de A se relaciona com no máximo uma ocorrência de B e vice-versa segundo o modelo.

---

## 11.2 ManyToOne — N para 1

Exemplo:

```text
muitos Eventos pertencem a um Usuario
```

No Evento:

```java
@ManyToOne
@JoinColumn(name = "usuario_id")
private Usuario usuario;
```

A FK geralmente fica no lado `Many`.

Tabela:

```text
eventos
id
nome
usuario_id
```

---

## 11.3 OneToMany — 1 para N

Lado inverso:

```java
@OneToMany(mappedBy = "usuario")
private List<Evento> eventos;
```

`mappedBy` indica qual atributo no outro lado é dono da relação.

Se Evento possui:

```java
private Usuario usuario;
```

então:

```java
mappedBy = "usuario"
```

Não é nome da coluna SQL.

---

## 11.4 ManyToMany — N para N

Exemplo:

```text
Evento N ---- N Equipamento
```

Precisa de tabela de junção.

```text
evento_equipamento
evento_id
equipamento_id
```

---

## 11.5 Quando NÃO usar ManyToMany direto

Se a relação possui informações próprias:

```text
quantidade
precoNoMomento
data
status
```

ela se tornou um conceito do domínio.

Exemplo:

```text
EventoEquipamento
id
evento_id
equipamento_id
quantidade
```

Então modelar entidade associativa costuma ser melhor.

---

## 11.6 Unidirecional x bidirecional

### Unidirecional

Só um lado conhece o outro.

```text
Evento -> Usuario
```

### Bidirecional

Os dois lados conhecem:

```text
Evento -> Usuario
Usuario -> List<Evento>
```

Bidirecional é útil quando você precisa navegar nos dois sentidos, mas aumenta complexidade de serialização e manutenção.

---

## 11.7 Qual lado tem a FK?

Regra mental muito útil:

> Em um relacionamento 1:N, a FK normalmente fica na tabela do lado N.

Exemplo:

```text
1 Usuario
N Eventos
```

Logo:

```text
eventos.usuario_id
```

---

<a id="sec-12"></a>
# 12. CASCADE, FETCH, LAZY/EAGER E SERIALIZAÇÃO

## 12.1 Cascade

Cascade define propagação de operações de persistência.

Exemplo conceitual:

```text
persistir pai
→ também persistir filho
```

ou:

```text
remover pai
→ talvez remover filhos
```

`CascadeType.ALL` significa várias operações propagadas.

Não significa:

```text
"faça relacionamento funcionar"
```

Usar sem entender pode apagar dados indevidamente.

---

## 12.2 `LAZY`

Carregamento tardio.

A relação pode não ser carregada imediatamente; é acessada quando necessária.

Vantagem:

- reduz carregamento desnecessário.

Risco:

- acesso fora de contexto adequado pode causar `LazyInitializationException`.

---

## 12.3 `EAGER`

Carregamento imediato.

Pode ser mais simples em casos pequenos, mas pode carregar dados demais e gerar consultas pesadas.

---

## 12.4 Qual é melhor?

Não existe resposta universal.

Em sistemas reais, deve-se carregar apenas o necessário.

Para prova, entenda:

```text
LAZY  = carrega sob demanda
EAGER = carrega imediatamente
```

---

## 12.5 Recursão infinita em JSON

Se Entity A retorna B e B retorna A:

```text
Usuario
 └ eventos
     └ usuario
         └ eventos
             └ usuario
```

Jackson pode tentar serializar indefinidamente.

DTO evita esse acoplamento.

Por isso retornar DTO é uma solução arquitetural melhor que depender de remendos de serialização em muitos casos.

---

<a id="sec-13"></a>
# 13. REPOSITORY E SPRING DATA JPA

## 13.1 `JpaRepository`

```java
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
}
```

Tipos genéricos:

```text
Usuario = Entity
Long    = tipo da chave primária
```

---

## 13.2 Métodos prontos

`JpaRepository` fornece operações como:

```text
save
findAll
findById
delete
deleteById
existsById
count
```

Você não precisa implementá-los manualmente.

---

## 13.3 Query Methods

Spring Data interpreta nomes.

```java
Optional<Usuario> findByEmail(String email);
```

```java
boolean existsByEmailIgnoreCase(String email);
```

```java
List<Equipamento>
findByNomeContainingIgnoreCase(String nome);
```

O nome expressa a consulta.

---

## 13.4 `findBy...` x `existsBy...`

`findBy`:

> Quero obter a entidade.

`existsBy`:

> Só quero saber se existe.

Se você só precisa verificar duplicidade, `existsBy...` pode comunicar melhor a intenção.

---

## 13.5 `findAll`

Retorna todos os registros daquela Entity.

Cuidado em sistemas enormes: listar tudo não escala.

Na prova pequena, é comum e adequado.

---

<a id="sec-14"></a>
# 14. SERVICE E REGRAS DE NEGÓCIO

## 14.1 O que é regra de negócio?

É uma regra que vem do domínio, não da tecnologia.

Exemplos:

```text
e-mail não pode repetir
estoque não pode ficar negativo
reserva inicia PENDENTE
somente administrador pode executar certa ação
data final não pode ser anterior à inicial
```

---

## 14.2 Por que Service?

Porque Controller não deveria conhecer detalhes complexos do domínio.

Service coordena:

- Repository;
- validações;
- relacionamentos;
- transformação;
- cálculos;
- segurança de negócio;
- operações transacionais.

---

## 14.3 Regra de negócio x validação estrutural

```java
@NotBlank
```

é validação da entrada.

```text
email já existe?
```

exige banco e é regra no Service.

---

## 14.4 Service pode chamar outro Service?

Pode.

Mas não crie dependências circulares desnecessárias.

Às vezes um Service precisa apenas consultar outro Repository.

Exemplo:

```text
EventoService precisa buscar Usuario
```

Pode usar:

```text
UsuarioRepository
```

se isso fizer sentido arquitetural no contexto da prova.

---

<a id="sec-15"></a>
# 15. CONTROLLER, ENDPOINTS E PARÂMETROS HTTP

## 15.1 `@RestController`

Marca classe responsável por endpoints REST.

---

## 15.2 `@RequestMapping`

Define prefixo.

```java
@RequestMapping("/usuarios")
```

---

## 15.3 `@GetMapping`

```java
@GetMapping
```

ou:

```java
@GetMapping("/{id}")
```

---

## 15.4 `@PostMapping`

Criação/ação via POST.

```java
@PostMapping
```

---

## 15.5 `@PutMapping`

Atualização completa/semântica de PUT.

```java
@PutMapping("/{id}")
```

---

## 15.6 `@DeleteMapping`

```java
@DeleteMapping("/{id}")
```

---

## 15.7 `@RequestBody`

Lê corpo JSON e converte para objeto Java.

```java
@RequestBody UsuarioRequestDTO dto
```

---

## 15.8 `@PathVariable`

Lê parte do caminho.

URL:

```text
/usuarios/10
```

Código:

```java
@PathVariable Long id
```

---

## 15.9 `@RequestParam`

Lê query parameter.

URL:

```text
/equipamentos?nome=caixa
```

Código:

```java
@RequestParam String nome
```

---

## 15.10 PathVariable x RequestParam

Use `PathVariable` quando valor identifica parte do recurso/caminho:

```text
/usuarios/5
```

Use `RequestParam` para filtros/opções:

```text
/usuarios?nome=nicolas
```

---

<a id="sec-16"></a>
# 16. CRUD E SEMÂNTICA DOS MÉTODOS HTTP

CRUD:

```text
Create
Read
Update
Delete
```

Mapeamento comum:

| CRUD | HTTP |
|---|---|
| Create | POST |
| Read | GET |
| Update | PUT/PATCH |
| Delete | DELETE |

---

## 16.1 GET

Usado para consultar.

Idealmente não altera estado do recurso.

---

## 16.2 POST

Frequentemente cria recurso ou executa operação não idempotente.

---

## 16.3 PUT

Normalmente representa substituição/atualização de um recurso identificado.

---

## 16.4 PATCH

Atualização parcial.

Mesmo que sua prova não use, saiba diferença:

```text
PUT   = representação completa/atualização completa em semântica REST clássica
PATCH = alteração parcial
```

Na prática acadêmica, muitos projetos usam PUT para atualização com DTO completo.

---

## 16.5 DELETE

Remove recurso.

---

## 16.6 Idempotência

Operação idempotente produz o mesmo estado final após repetição da mesma operação.

Em geral:

```text
GET    idempotente
PUT    idempotente
DELETE idempotente em intenção/estado
POST   normalmente não idempotente
```

Exemplo:

enviar duas vezes o mesmo `POST /usuarios` pode tentar criar dois registros.

---

<a id="sec-17"></a>
# 17. CÓDIGOS HTTP

## 200 OK

Operação concluída com resposta.

Exemplo:

```text
GET
PUT
login
```

---

## 201 Created

Recurso criado.

Exemplo:

```text
POST /usuarios
```

---

## 204 No Content

Sucesso sem corpo.

Muito usado no DELETE.

---

## 400 Bad Request

Entrada inválida ou requisição semanticamente inadequada.

Exemplos:

- JSON inválido;
- validação DTO falhou;
- quantidade negativa;
- enum inexistente.

---

## 401 Unauthorized

Apesar do nome histórico, na prática significa:

> autenticação ausente ou inválida.

Exemplos:

- token inexistente;
- token expirado;
- senha inválida em login;
- token inválido.

---

## 403 Forbidden

Usuário foi reconhecido/autenticado, mas não tem permissão.

Exemplo:

```text
USUARIO tenta endpoint exclusivo ADMIN
```

---

## 404 Not Found

Recurso ou rota não encontrado.

Em Service:

```text
Usuário de id 10 não existe
```

Também pode ocorrer porque URL está errada.

---

## 405 Method Not Allowed

Rota existe, mas método HTTP usado não é aceito.

Exemplo:

endpoint só possui POST e cliente envia GET.

---

## 409 Conflict

Conflito com estado existente.

Muito apropriado para:

```text
email duplicado
CPF duplicado
```

---

## 500 Internal Server Error

Erro não tratado no servidor.

Não é status para regra normal de negócio.

Se algo esperado está virando 500, idealmente faltou tratamento adequado.

---

<a id="sec-18"></a>
# 18. EXCEÇÕES E TRATAMENTO DE ERROS

No manual prático aparece:

```java
throw new ResponseStatusException(
    HttpStatus.NOT_FOUND,
    "Usuário não encontrado"
);
```

Isso combina exceção com status HTTP.

---

## 18.1 Checked x unchecked — noção

Java possui exceções verificadas e não verificadas.

Para Spring Web e regras de API, muitas exceções utilizadas são Runtime Exceptions.

Não precisa aprofundar excessivamente se isso não foi conteúdo da disciplina.

---

## 18.2 Erro esperado x erro inesperado

Esperado:

```text
registro não existe
email duplicado
entrada inválida
```

Deve virar status adequado.

Inesperado:

```text
NullPointerException
erro de programação
falha interna inesperada
```

pode resultar em 500.

---

## 18.3 Global Exception Handler

Em projetos maiores, pode-se centralizar respostas usando:

```java
@RestControllerAdvice
```

e:

```java
@ExceptionHandler
```

Isso evita repetir tratamento.

Se não estiver no escopo da prova, `ResponseStatusException` é mais simples.

---

<a id="sec-19"></a>
# 19. AUTENTICAÇÃO, AUTORIZAÇÃO E SPRING SECURITY

## Autenticação

Pergunta:

> **Quem é você?**

Exemplo:

```text
email + senha
```

Depois do login, o token representa a identidade autenticada.

---

## Autorização

Pergunta:

> **O que você pode fazer?**

Exemplo:

```text
ADMIN pode excluir equipamento
USUARIO não pode
```

---

## Diferença para decorar

```text
AUTENTICAÇÃO = identidade
AUTORIZAÇÃO  = permissão
```

---

## Spring Security

É o módulo/ecossistema de segurança do Spring.

Pode controlar:

- autenticação;
- autorização;
- filtros;
- endpoints públicos/privados;
- integração com tokens;
- roles/authorities.

---

<a id="sec-20"></a>
# 20. SENHA, HASH, BCRYPT E PASSWORDENCODER

## 20.1 Senha não deve ser armazenada em texto puro

Errado:

```text
senha = 12345678
```

no banco.

Se banco vazar, credenciais ficam expostas.

---

## 20.2 Hash

Hash transforma entrada em uma representação derivada de maneira unidirecional para finalidade de armazenamento seguro de senha.

Para senhas, usa-se algoritmo apropriado de password hashing.

---

## 20.3 BCrypt

BCrypt é um algoritmo de hashing de senha projetado para ser custoso computacionalmente e incluir salt.

No Spring:

```java
new BCryptPasswordEncoder()
```

---

## 20.4 `encode`

Cadastro:

```java
passwordEncoder.encode(senha)
```

Gera hash.

---

## 20.5 `matches`

Login:

```java
passwordEncoder.matches(
    senhaDigitada,
    hashArmazenado
)
```

Compara de forma apropriada.

---

## 20.6 Por que não fazer `encode` novamente e comparar?

Porque hashes BCrypt usam salt.

A mesma senha pode gerar representações diferentes em chamadas distintas.

Portanto:

```java
encode(senha).equals(hashBanco)
```

não é a maneira correta.

Use:

```java
matches(...)
```

---

## 20.7 Criptografia x hashing

Criptografia:

```text
é reversível com a chave apropriada
```

Hash de senha:

```text
é projetado para não ser revertido
```

Portanto dizer:

> “BCrypt criptografa a senha”

é tecnicamente menos correto.

Melhor:

> **BCrypt gera um hash da senha.**

---

<a id="sec-21"></a>
# 21. JWT POR DENTRO

JWT significa:

```text
JSON Web Token
```

É um formato compacto de token.

---

## 21.1 Estrutura

JWT tradicional tem três partes:

```text
HEADER.PAYLOAD.SIGNATURE
```

Exemplo visual:

```text
xxxxx.yyyyy.zzzzz
```

---

## 21.2 Header

Indica metadados, por exemplo algoritmo.

Conceitualmente:

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

---

## 21.3 Payload

Contém claims.

No seu modelo:

```text
subject = email
tipo    = ADMIN
issuedAt
expiration
```

---

## 21.4 Claim

Claim é uma informação declarada no token.

Exemplo customizado:

```json
{
  "tipo": "ADMIN"
}
```

---

## 21.5 `sub`

`sub` é Subject.

No projeto, representa email do usuário.

---

## 21.6 `iat`

Issued At.

Momento em que token foi emitido.

---

## 21.7 `exp`

Expiration.

Define quando token deixa de ser válido.

---

## 21.8 Assinatura

A assinatura garante integridade/autenticidade segundo a chave e algoritmo usados.

Se alguém altera o payload sem possuir chave adequada, assinatura deixa de validar.

---

## 21.9 JWT é criptografado?

Não necessariamente.

Esse é ponto importante.

JWT assinado normalmente tem payload codificado, não secretamente criptografado.

Portanto:

> **não coloque senha ou dados secretos no payload pensando que JWT “esconde” os dados.**

---

## 21.10 HS256

HS256 é HMAC usando SHA-256.

É simétrico:

```text
mesmo segredo participa da assinatura e verificação
```

No seu projeto, `JwtUtil` assina e `JwtDecoder` valida com segredo compatível.

---

<a id="sec-22"></a>
# 22. JWT X SESSÃO E AUTENTICAÇÃO STATELESS

## Sessão tradicional

Servidor pode manter estado:

```text
sessionId -> usuário autenticado
```

Cliente recebe identificador da sessão.

Servidor consulta sessão a cada requisição.

---

## JWT stateless

Cliente envia token em cada requisição:

```text
Authorization: Bearer TOKEN
```

Servidor valida token.

Não precisa manter uma sessão HTTP tradicional para aquele usuário.

Por isso:

```java
SessionCreationPolicy.STATELESS
```

---

## Vantagens conceituais

- fácil transportar entre clientes;
- reduz necessidade de estado de sessão no servidor;
- comum em APIs.

---

## Cuidados

- token precisa expirar;
- segredo precisa ser protegido;
- revogação pode exigir estratégia adicional;
- payload não deve conter segredo.

---

<a id="sec-23"></a>
# 23. ROLES, AUTHORITIES, `hasRole` E `hasAuthority`

## Authority

É uma permissão reconhecida pelo Spring Security.

Exemplo:

```text
ROLE_ADMIN
```

---

## Role

É uma convenção de authority com prefixo:

```text
ROLE_
```

---

## No projeto

Token:

```text
tipo = ADMIN
```

Converter:

```text
prefixo = ROLE_
```

Resultado:

```text
ROLE_ADMIN
```

---

## `hasRole`

```java
.hasRole("ADMIN")
```

Spring aplica convenção de role.

---

## `hasAuthority`

```java
.hasAuthority("ROLE_ADMIN")
```

Aqui você fornece authority completa.

---

## Diferença

```text
hasRole("ADMIN")
≈ procura ROLE_ADMIN

hasAuthority("ROLE_ADMIN")
= procura exatamente ROLE_ADMIN
```

---

<a id="sec-24"></a>
# 24. OAUTH2 RESOURCE SERVER NO PROJETO

O projeto utiliza infraestrutura do Spring Security Resource Server para processar JWT.

Isso é importante porque explica por que um `JwtAuthenticationFilter` customizado não é obrigatoriamente necessário.

Fluxo:

```text
cliente envia Bearer Token
        ↓
Spring Security
        ↓
Resource Server
        ↓
JwtDecoder
        ↓
validação do JWT
        ↓
Authentication criada
        ↓
authorities/roles
        ↓
Controller
```

`JwtUtil` é usado para **gerar** tokens no login.

`JwtDecoder` é usado pela infraestrutura de segurança para **validar/decodificar** o token recebido.

Essa distinção pode virar pergunta.

---

<a id="sec-25"></a>
# 25. SWAGGER, OPENAPI E DOCUMENTAÇÃO DA API

## OpenAPI

É uma especificação para descrever APIs HTTP.

Ela documenta:

- endpoints;
- parâmetros;
- schemas;
- autenticação;
- respostas.

---

## Swagger

“Swagger” é usado popularmente para ferramentas ligadas à documentação/interação com APIs.

No projeto, Swagger UI exibe documentação OpenAPI em interface Web.

---

## Springdoc

Biblioteca que integra aplicações Spring com OpenAPI/Swagger UI.

---

## Por que declarar Bearer Auth?

Para Swagger saber que endpoints utilizam token.

Exemplo conceitual:

```java
@SecurityScheme(
    name = "bearerAuth",
    scheme = "bearer",
    bearerFormat = "JWT"
)
```

---

## Swagger não é a API

Swagger UI é apenas uma interface/documentação.

Se Swagger quebrar, a API pode ainda estar funcionando.

Se:

```text
/v3/api-docs
```

funciona, a descrição OpenAPI provavelmente está sendo gerada.

---

<a id="sec-26"></a>
# 26. `application.properties` E CONFIGURAÇÃO

Esse arquivo contém configuração externa.

Exemplo:

```properties
server.port=8080
```

Não precisa recompilar lógica Java para mudar determinado valor de configuração.

---

## Banco

```properties
spring.datasource.url=...
spring.datasource.username=...
spring.datasource.password=...
```

---

## JPA

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Swagger

```properties
springdoc.swagger-ui.path=...
```

---

## JWT

```properties
jwt.secret=...
jwt.expiration=...
```

---

## `@Value`

Lê propriedade:

```java
@Value("${jwt.secret}")
private String secret;
```

---

## Configuração x código

Código descreve comportamento.

Properties fornece valores variáveis de ambiente/configuração.

Em sistemas reais, segredos sensíveis não deveriam ser versionados diretamente no Git em texto puro; costumam vir de variáveis de ambiente/secret managers. Para a prova local, siga o padrão solicitado pelo ambiente.

---

<a id="sec-27"></a>
# 27. MAVEN WRAPPER, CACHE `.m2` E FUNCIONAMENTO OFFLINE

## Maven Wrapper

Arquivos:

```text
mvnw
mvnw.cmd
.mvn/wrapper/
```

Permitem executar uma versão esperada do Maven sem depender exclusivamente de instalação global.

---

## Wrapper não significa “100% offline”

Na primeira execução, ele pode precisar obter a distribuição Maven.

Depois, dependências também precisam existir localmente.

---

## `.m2/repository`

É o repositório local Maven.

Guarda dependências baixadas.

Exemplo:

```text
C:\Users\usuario\.m2\repository
```

---

## `-o`

Modo offline:

```powershell
.\mvnw.cmd -o clean package
```

Maven só utiliza recursos disponíveis localmente.

---

## Dependência ausente offline

Se biblioteca nunca foi baixada e não está no cache local, o Maven não consegue inventá-la.

Por isso não mude versões durante a prova offline sem necessidade.

---

<a id="sec-28"></a>
# 28. MODELAGEM DE UM MINIMUNDO

Minimundo é descrição textual do domínio.

Você precisa transformá-lo em modelo.

---

## 28.1 Substantivos

Podem indicar:

- Entity;
- atributo;
- enum.

Exemplo:

> cliente realiza reservas de equipamentos.

Possíveis entidades:

```text
Cliente
Reserva
Equipamento
```

---

## 28.2 Verbos

Podem indicar relações/regras.

```text
cliente realiza reserva
evento possui equipamentos
administrador aprova solicitação
```

---

## 28.3 Quantificadores

Palavras importantes:

```text
um
vários
muitos
cada
exatamente um
pode possuir
```

Ajudam a determinar cardinalidade.

---

## 28.4 Restrições

Frases como:

```text
não pode repetir
é obrigatório
somente administrador
não pode ultrapassar
deve começar com
```

viram:

- constraints;
- validações;
- regras Service;
- Security.

---

## 28.5 Perguntas para fazer ao minimundo

Para cada entidade:

```text
Qual é a chave?
Quais campos possui?
Quais são obrigatórios?
Algum é único?
Existe enum?
Com quem se relaciona?
Qual cardinalidade?
Existe regra de criação?
Existe regra de atualização?
Existe regra de exclusão?
Quem pode acessar?
```

---

## 28.6 Nem todo substantivo é Entity

Exemplo:

> usuário possui endereço.

Pode ser:

```text
campos no Usuario
```

ou uma Entity Endereco.

Depende da importância, reutilização e regras do domínio.

---

<a id="sec-29"></a>
# 29. TIPOS JAVA MAIS IMPORTANTES

## `String`

Texto/identificadores textuais.

```java
String nome;
String cpf;
String telefone;
```

---

## `Long`

IDs são frequentemente Long.

```java
Long id;
```

---

## `Integer`

Quantidades inteiras.

```java
Integer estoque;
```

---

## `BigDecimal`

Valores monetários.

```java
BigDecimal preco;
```

É mais adequado que `float`/`double` para dinheiro por questões de precisão decimal.

---

## `Boolean`

Estados verdadeiro/falso.

```java
Boolean ativo;
```

---

## `LocalDate`

Data sem horário.

```java
LocalDate dataNascimento;
```

---

## `LocalDateTime`

Data e horário.

```java
LocalDateTime dataHora;
```

---

## `List<T>`

Coleção ordenada/lista.

```java
List<Evento> eventos;
```

---

## `Optional<T>`

Representa possibilidade explícita de existência/ausência.

```java
Optional<Usuario>
```

Muito usado em consultas Repository.

---

<a id="sec-30"></a>
# 30. ENUMS

Enum representa conjunto fechado de valores.

```java
public enum StatusReserva {
    PENDENTE,
    APROVADA,
    CANCELADA
}
```

Vantagem sobre String livre:

```text
evita valores arbitrários
documenta opções válidas
facilita lógica e validação
```

---

## `EnumType.STRING`

```java
@Enumerated(EnumType.STRING)
```

Banco armazena:

```text
PENDENTE
APROVADA
```

---

## `EnumType.ORDINAL`

Armazena posição:

```text
0
1
2
```

Problema:

se ordem do enum mudar, significado de dados antigos pode ficar incorreto.

Por isso `STRING` é normalmente mais legível e seguro.

---

<a id="sec-31"></a>
# 31. `record` X CLASSE TRADICIONAL

## Record

Forma compacta de representar dados.

```java
public record UsuarioResponseDTO(
    Long id,
    String nome
) {
}
```

Acesso:

```java
dto.nome()
```

---

## Classe tradicional

```java
public class LoginDTO {

    private String email;

    public String getEmail() {
        return email;
    }
}
```

Acesso:

```java
dto.getEmail()
```

---

## Quando record é útil?

Muito adequado para DTOs simples porque reduz código repetitivo e representa bem dados transportados.

---

## Record é Entity?

Pode haver limitações/requisitos do JPA que tornam classes tradicionais a escolha natural para Entities.

No projeto, use record principalmente em DTO, não Entity.

---

<a id="sec-32"></a>
# 32. `OPTIONAL`

Repository:

```java
Optional<Usuario> findByEmail(String email);
```

Isso expressa:

```text
pode existir um Usuario
ou pode não existir
```

---

## `orElseThrow`

```java
Usuario usuario =
    repository.findById(id)
        .orElseThrow(...);
```

Converte ausência em exceção apropriada.

---

## Por que é melhor que retornar `null` em muitos casos?

`Optional` torna possibilidade de ausência explícita na assinatura.

---

## Não é “uma lista”

`Optional` representa zero ou um valor.

Não representa múltiplos valores.

---

<a id="sec-33"></a>
# 33. TRANSAÇÕES E `@Transactional`

Transação agrupa operações que precisam ser tratadas como unidade.

Exemplo:

```text
criar pedido
reduzir estoque
registrar movimentação
```

Se terceira etapa falha, talvez seja necessário desfazer as anteriores.

---

## ACID — noção útil

Transações em bancos relacionais são frequentemente explicadas por:

### Atomicidade

Tudo ou nada.

### Consistência

Estado respeita regras.

### Isolamento

Transações concorrentes não devem gerar interferências incorretas.

### Durabilidade

Após commit, dados persistem.

---

## `@Transactional`

```java
@Transactional
public void criarReserva(...) {
}
```

Spring gerencia fronteira transacional.

---

## Não use sem pensar

Não é um “conserta banco”.

Use quando o caso de uso exige consistência entre múltiplas operações.

---

<a id="sec-34"></a>
# 34. PERSISTÊNCIA, ESTADO DE ENTIDADE E ERROS COMUNS DO JPA

## Transient

Objeto novo ainda não persistido.

```java
Usuario usuario = new Usuario();
```

---

## Managed

Entidade gerenciada pelo contexto JPA atual.

Frequentemente obtida por Repository dentro de operação/transação.

---

## Detached

Entidade existiu em contexto, mas já não está anexada ao contexto atual.

---

## Removed

Marcada para remoção.

---

## Erro: transient instance

Pode ocorrer quando uma Entity referencia outra nova/não persistida sem cascade apropriado.

Por isso, para relacionar entidade existente:

```java
Usuario usuario =
    usuarioRepository.findById(id)
        .orElseThrow(...);
```

e depois:

```java
evento.setUsuario(usuario);
```

---

## Detached entity

Indica problema com estado/contexto de entidade que já possui identidade mas não está sendo tratada como esperado pela operação.

---

## LazyInitializationException

Acesso tardio a relação LAZY quando contexto necessário já não está disponível.

DTOs, transações bem delimitadas e consultas adequadas ajudam a evitar.

---

<a id="sec-35"></a>
# 35. DDL, `ddl-auto` E MUDANÇAS NO BANCO

DDL significa Data Definition Language.

Comandos SQL de estrutura:

```sql
CREATE TABLE
ALTER TABLE
DROP TABLE
```

---

## `ddl-auto=update`

Hibernate tenta atualizar schema para refletir mapeamento.

Bom para desenvolvimento simples.

Não é uma ferramenta completa de migração de produção.

---

## `create`

Recria estrutura ao iniciar, podendo apagar dados.

---

## `create-drop`

Cria e remove conforme ciclo da aplicação.

Perigoso se você espera persistência entre execuções.

---

## Por que mudar Entity pode quebrar banco existente?

Porque dados antigos podem violar novas restrições.

Exemplo:

adiciona:

```text
cpf NOT NULL
```

mas linhas antigas têm CPF nulo.

Ou adiciona:

```text
UNIQUE email
```

e já existem emails duplicados.

---

<a id="sec-36"></a>
# 36. COMPONENT SCAN E ORGANIZAÇÃO DE PACKAGES

Classe principal:

```text
com.senai.infoa.prova.ProvaApplication
```

Pacotes abaixo:

```text
com.senai.infoa.prova.controller
com.senai.infoa.prova.service
com.senai.infoa.prova.repository
```

são encontrados naturalmente.

---

## Package Java x pasta

Arquivo:

```text
src/main/java/com/senai/infoa/prova/service/UsuarioService.java
```

deve declarar:

```java
package com.senai.infoa.prova.service;
```

---

## `model` x `models`

São packages diferentes.

```text
model
```

não é igual a:

```text
models
```

---

## `enuns`

No projeto-base o package aparece como:

```text
enuns
```

Conceitualmente o termo correto é `enum`/`enums`, mas se sua estrutura existente usa `enuns`, mantenha consistência durante a prova para não quebrar imports.

---

<a id="sec-37"></a>
# 37. DIFERENÇAS QUE VOCÊ PRECISA SABER DE CABEÇA

## Spring x Spring Boot

```text
Spring      = framework/ecossistema
Spring Boot = simplifica configuração e execução do Spring
```

---

## JPA x Hibernate x Spring Data JPA

```text
JPA             = especificação
Hibernate       = implementação ORM
Spring Data JPA = abstração de acesso/repositories sobre JPA
```

---

## Entity x DTO

```text
Entity = persistência
DTO    = transporte de dados
```

---

## RequestDTO x ResponseDTO

```text
RequestDTO  = entrada
ResponseDTO = saída
```

---

## Repository x Service

```text
Repository = persistência/consulta
Service    = regra de negócio/caso de uso
```

---

## Service x Controller

```text
Service    = domínio/regra
Controller = HTTP
```

---

## `@Component` x `@Service` x `@Repository`

Todos participam do gerenciamento de componentes Spring, mas comunicam responsabilidades diferentes.

---

## `@NotNull` x `@NotBlank`

```text
@NotNull  = não pode ser null
@NotBlank = texto não pode ser null, vazio ou apenas espaços
```

---

## `@PathVariable` x `@RequestParam`

```text
PathVariable = parte da rota
RequestParam = parâmetro de consulta
```

---

## `@ManyToOne` x `@OneToMany`

Mesma relação vista de lados diferentes.

```text
muitos eventos -> um usuario
um usuario -> muitos eventos
```

---

## PK x FK

```text
PK = identifica a própria linha
FK = referencia linha de outra tabela
```

---

## `nullable=false` x `@NotNull`

```text
@Column(nullable=false)
= constraint/mapeamento de persistência

@NotNull
= validação do objeto/entrada
```

Podem coexistir porque atuam em camadas diferentes.

---

## `unique=true` x `existsBy...`

```text
unique no banco = garantia de integridade
existsBy no Service = regra preventiva/resposta amigável
```

---

## Autenticação x autorização

```text
autenticação = quem é?
autorização  = pode fazer?
```

---

## 401 x 403

```text
401 = não autenticado corretamente
403 = autenticado, sem permissão
```

---

## Hash x criptografia

```text
hash de senha = não reversível por projeto
criptografia  = reversível com chave apropriada
```

---

## JWT x senha

JWT não substitui hashing da senha.

Senha é usada no login e validada com BCrypt.

JWT é emitido depois para autenticar requisições.

---

## JWT x sessão

```text
sessão = servidor mantém estado de sessão
JWT stateless = cliente carrega token e servidor valida a cada requisição
```

---

## `hasRole` x `hasAuthority`

```text
hasRole("ADMIN")
→ convenção ROLE_ADMIN

hasAuthority("ROLE_ADMIN")
→ valor exato
```

---

## GET x POST

```text
GET  = leitura
POST = criação/ação
```

---

## PUT x PATCH

```text
PUT   = atualização/substituição completa na semântica clássica
PATCH = alteração parcial
```

---

## `record` x classe

```text
record = representação compacta de dados
class  = estrutura geral, mutável ou rica em comportamento
```

---

## `Integer` x `int`

```text
int     = primitivo, não aceita null
Integer = objeto, aceita null
```

---

## `==` x `.equals`

```text
==      = igualdade primitiva ou identidade de referência para objetos
.equals = igualdade lógica/conteúdo definida pelo objeto
```

---

## LAZY x EAGER

```text
LAZY  = sob demanda
EAGER = imediatamente
```

---

## Cascade x relacionamento

Relacionamento diz:

```text
como entidades se relacionam
```

Cascade diz:

```text
quais operações são propagadas
```

São conceitos diferentes.

---

## Swagger x OpenAPI

```text
OpenAPI = especificação
Swagger UI = ferramenta/interface para visualizar/interagir
```

---

## Maven x Maven Wrapper

```text
Maven         = ferramenta
Maven Wrapper = scripts/configuração que ajudam projeto a usar Maven esperado
```

---

## Compilar x executar

```text
compilar = transformar/verificar código
executar = iniciar programa
```

Projeto pode compilar e falhar na execução devido a banco/configuração.

---

<a id="sec-38"></a>
# 38. ARMADILHAS CONCEITUAIS COMUNS

## “Repository contém regra de negócio.”

Não deveria ser a responsabilidade principal.

Repository é persistência.

---

## “DTO é uma tabela.”

Não.

DTO não precisa ser persistido.

---

## “Entity é a mesma coisa que tabela.”

Não exatamente.

Entity é objeto Java mapeado para persistência; normalmente corresponde a tabela, mas a abstração é diferente.

---

## “JWT criptografa tudo.”

Não.

JWT assinado não é necessariamente criptografado.

---

## “Senha BCrypt pode ser descriptografada.”

Não é a ideia de BCrypt.

No login usa-se `matches`, não descriptografia.

---

## “403 significa que token está inválido.”

Não necessariamente.

Token pode estar válido e usuário não possuir permissão.

---

## “`@NotNull` impede String vazia.”

Não.

`""` não é `null`.

---

## “`@ManyToOne` significa que esta classe tem muitos objetos.”

Não exatamente.

Significa que **muitas instâncias desta Entity podem apontar para uma mesma instância da outra Entity**.

---

## “`mappedBy` recebe nome da coluna.”

Não.

Recebe nome do atributo no outro lado da relação.

---

## “CascadeType.ALL deve ser usado em todos os relacionamentos.”

Não.

Isso pode propagar exclusões e persistências indesejadas.

---

## “Swagger cria endpoints.”

Não.

Endpoints são criados por Controllers; Swagger apenas documenta/interage.

---

## “Maven offline funciona só porque tenho o `pom.xml`.”

Não.

Dependências e distribuição necessária precisam estar no cache/local.

---

## “Se VS Code está vermelho, código está obrigatoriamente errado.”

Não.

Pode ser problema do Language Server/importação Maven. O build no terminal ajuda a distinguir.

---

## “Se compilou, sistema funciona.”

Não.

Compilação não valida banco, endpoints, regras, autenticação ou semântica.

---

<a id="sec-39"></a>
# 39. POSSÍVEIS PERGUNTAS DE PROVA — RESPOSTAS CURTAS

## 1. O que é Spring Boot?

Framework/ferramenta baseada no ecossistema Spring que simplifica configuração, dependências, inicialização e execução de aplicações Spring.

---

## 2. Qual a diferença entre Spring e Spring Boot?

Spring é o framework/ecossistema; Spring Boot adiciona convenções e auto-configuração para reduzir configuração manual.

---

## 3. O que é uma API REST?

Uma API HTTP organizada em torno de recursos e semântica HTTP, normalmente usando endpoints, métodos HTTP e representações como JSON.

---

## 4. O que é endpoint?

Combinação de rota e operação HTTP disponibilizada pela API.

---

## 5. O que é Entity?

Classe Java mapeada para persistência pelo JPA.

---

## 6. O que é DTO?

Objeto usado para transportar dados entre camadas/fronteiras, sem obrigatoriamente representar tabela.

---

## 7. Por que usar DTO?

Para controlar entrada/saída, proteger campos internos, reduzir acoplamento e evitar expor diretamente a Entity.

---

## 8. O que é Repository?

Camada/interface responsável pelo acesso e persistência de dados.

---

## 9. O que é Service?

Camada que concentra regras de negócio e coordena operações do caso de uso.

---

## 10. O que é Controller?

Camada que recebe requisições HTTP e devolve respostas HTTP.

---

## 11. O que é Injeção de Dependência?

Fornecimento das dependências de uma classe por um container/elemento externo, em vez da própria classe criá-las diretamente.

---

## 12. O que é um Bean Spring?

Objeto criado/gerenciado pelo container do Spring.

---

## 13. O que faz `@Service`?

Marca semanticamente componente da camada de serviço e permite gerenciamento pelo Spring.

---

## 14. O que faz `@RestController`?

Marca classe como controller REST, com métodos cujas respostas são serializadas para o corpo HTTP.

---

## 15. O que faz `@Entity`?

Marca classe como entidade JPA persistente.

---

## 16. O que faz `@Id`?

Marca atributo como chave primária da Entity.

---

## 17. Para que serve `@GeneratedValue`?

Configura geração automática da chave primária.

---

## 18. Qual diferença entre JPA e Hibernate?

JPA é especificação; Hibernate é uma implementação/provedor ORM.

---

## 19. O que é ORM?

Mapeamento entre objetos da aplicação e estruturas relacionais do banco.

---

## 20. O que é Spring Data JPA?

Camada do Spring que simplifica acesso a dados com JPA, oferecendo Repositories e convenções de consulta.

---

## 21. O que é Primary Key?

Coluna/atributo que identifica unicamente um registro.

---

## 22. O que é Foreign Key?

Chave que referencia registro de outra tabela.

---

## 23. O que significa cardinalidade 1:N?

Uma ocorrência de A pode se relacionar a várias de B; cada B se relaciona conforme a regra com A.

---

## 24. Quando usar `@ManyToOne`?

No lado em que muitas instâncias podem apontar para uma mesma entidade.

---

## 25. Para que serve `mappedBy`?

Indica que o outro lado é dono do relacionamento e informa nome do atributo correspondente.

---

## 26. Quando não usar ManyToMany direto?

Quando relação possui atributos próprios, como quantidade, preço, status ou data; nesse caso é comum criar entidade associativa.

---

## 27. O que é cascade?

Propagação de operações de persistência entre entidades relacionadas.

---

## 28. O que é LAZY?

Estratégia em que relacionamento é carregado quando acessado/necessário.

---

## 29. O que é EAGER?

Relacionamento carregado imediatamente junto com a entidade.

---

## 30. O que é `@Valid`?

Solicita validação Bean Validation do objeto recebido.

---

## 31. Diferença entre `@NotNull` e `@NotBlank`?

`NotNull` apenas proíbe null; `NotBlank` exige texto não nulo, não vazio e não composto apenas por espaços.

---

## 32. O que significa 400?

Requisição inválida segundo entrada/formato/regra de requisição.

---

## 33. O que significa 401?

Autenticação ausente ou inválida.

---

## 34. O que significa 403?

Usuário autenticado sem autorização suficiente.

---

## 35. O que significa 404?

Recurso/rota não encontrado.

---

## 36. O que significa 409?

Conflito com estado atual, como duplicidade de dado único.

---

## 37. O que significa 500?

Erro interno não tratado no servidor.

---

## 38. Por que senha não deve ser armazenada em texto puro?

Porque comprometimento do banco revelaria diretamente credenciais.

---

## 39. O que é BCrypt?

Algoritmo de password hashing usado para armazenar senhas de forma adequada.

---

## 40. Para que serve `PasswordEncoder.matches`?

Verifica se senha digitada corresponde ao hash armazenado.

---

## 41. O que é JWT?

Formato de token composto por header, payload e assinatura, usado frequentemente para transportar claims de autenticação.

---

## 42. JWT é criptografado?

Não obrigatoriamente; JWT assinado normalmente protege integridade, não confidencialidade do payload.

---

## 43. O que é claim?

Informação declarada dentro do payload JWT.

---

## 44. O que é `sub` no JWT?

Subject, o sujeito/identidade principal representada pelo token.

---

## 45. O que é `exp`?

Expiration, momento após o qual token não deve ser aceito.

---

## 46. Qual diferença entre autenticação e autorização?

Autenticação verifica identidade; autorização verifica permissões.

---

## 47. Para que serve `SessionCreationPolicy.STATELESS`?

Indica que aplicação não deve depender de sessão HTTP tradicional para manter autenticação entre requisições.

---

## 48. O que faz `hasRole("ADMIN")`?

Exige role ADMIN, normalmente associada à authority `ROLE_ADMIN`.

---

## 49. `hasRole("ROLE_ADMIN")` é correto no padrão usado?

Normalmente não nesse caso, pois `hasRole` já trabalha com convenção `ROLE_`.

---

## 50. Para que serve Swagger?

Documentar e permitir interação/testes com endpoints descritos pela API OpenAPI.

---

## 51. Para que serve `application.properties`?

Configurar valores externos como porta, banco, JPA, Swagger e JWT.

---

## 52. O que é Maven?

Ferramenta de gerenciamento de dependências e ciclo de build.

---

## 53. O que é `pom.xml`?

Arquivo Project Object Model que descreve projeto Maven, dependências, plugins e configuração.

---

## 54. O que é Maven Wrapper?

Scripts e configuração que facilitam executar Maven compatível com o projeto.

---

## 55. O que significa Maven offline?

Executar usando apenas artefatos disponíveis localmente, sem buscar dependências externas.

---

## 56. O que é `.m2/repository`?

Cache/repositório Maven local de dependências e artefatos.

---

## 57. O que é enum?

Tipo com conjunto fechado de constantes.

---

## 58. Por que usar `EnumType.STRING`?

Armazena nome legível e evita dependência perigosa da posição ordinal.

---

## 59. Por que usar `BigDecimal` para dinheiro?

Para evitar limitações de precisão binária de float/double em cálculos decimais monetários.

---

## 60. Qual diferença entre `int` e `Integer`?

`int` é primitivo e não aceita null; `Integer` é objeto e aceita null.

---

## 61. Qual diferença entre `record` e classe tradicional?

Record fornece forma compacta orientada a dados; classe é estrutura geral para estado/comportamento e pode ser mutável.

---

## 62. Como acessar campo de record?

```java
dto.nome()
```

não:

```java
dto.getNome()
```

---

## 63. O que é Optional?

Contêiner que expressa existência ou ausência de um valor.

---

## 64. Para que serve `orElseThrow`?

Retorna valor do Optional ou lança exceção caso esteja vazio.

---

## 65. O que é transação?

Conjunto de operações tratadas como unidade lógica de trabalho.

---

## 66. O que é atomicidade?

Ou todas as operações da transação são efetivadas, ou nenhuma deve permanecer.

---

## 67. O que significa `ddl-auto=update`?

Hibernate tenta ajustar schema existente ao mapeamento das entidades.

---

## 68. Por que `create-drop` é perigoso?

Pode apagar estrutura/dados ao encerrar/reiniciar a aplicação.

---

## 69. Qual diferença entre `nullable=false` e `@NotNull`?

O primeiro atua no mapeamento/constraint do banco; o segundo na validação do objeto.

---

## 70. Por que retornar Entity diretamente pode causar problema?

Pode expor dados internos, criar acoplamento com banco e causar recursão de relacionamentos.

---

<a id="sec-40"></a>
# 40. PERGUNTAS DE RACIOCÍNIO E CENÁRIOS

## Cenário 1

> Um cliente possui vários pedidos. Onde provavelmente fica a FK?

Resposta:

Na tabela `pedidos`, por exemplo:

```text
cliente_id
```

porque é o lado N.

---

## Cenário 2

> Pedido e Produto são N:N, mas cada produto no pedido possui quantidade. Como modelar?

Criar entidade intermediária, por exemplo:

```text
ItemPedido
id
pedido_id
produto_id
quantidade
```

Não usar ManyToMany puro.

---

## Cenário 3

> O usuário está autenticado, mas endpoint exige ADMIN e token contém USUARIO. Qual status?

```text
403 Forbidden
```

---

## Cenário 4

> Cliente não enviou token para rota privada.

Provável:

```text
401 Unauthorized
```

---

## Cenário 5

> Email já está cadastrado.

Resposta adequada:

```text
409 Conflict
```

e também constraint única no banco.

---

## Cenário 6

> DTO possui `@NotBlank`, mas validação não acontece.

Verifique se Controller utiliza:

```java
@Valid
```

---

## Cenário 7

> `UsuarioResponseDTO` devolve senha.

É problema de segurança/contrato.

Remova senha do ResponseDTO.

---

## Cenário 8

> Login compara `senhaDigitada.equals(hashDoBanco)`.

Está errado.

Use:

```java
passwordEncoder.matches(...)
```

---

## Cenário 9

> Desenvolvedor executa `passwordEncoder.encode(senha)` novamente no login e compara hashes.

Também está errado para BCrypt.

Use `matches`.

---

## Cenário 10

> Token foi alterado manualmente de USUARIO para ADMIN.

Assinatura deixa de ser válida se atacante não puder produzir assinatura correta.

Decoder deve rejeitar.

---

## Cenário 11

> Payload JWT contém senha porque “token é criptografado”.

Conceito incorreto.

JWT assinado não garante confidencialidade do payload.

---

## Cenário 12

> `mappedBy = "usuario_id"` mas atributo no Evento se chama `usuario`.

Deveria ser:

```java
mappedBy = "usuario"
```

`mappedBy` aponta para atributo Java.

---

## Cenário 13

> Uma alteração simples em Entity causou falha de NOT NULL no banco antigo.

Registros existentes podem não possuir valor exigido pela nova constraint.

---

## Cenário 14

> Projeto compila, mas Spring não inicia.

Compilação testa código; runtime pode falhar por banco, Beans, porta, properties, security etc.

---

## Cenário 15

> Swagger não abre, mas `/v3/api-docs` funciona.

A geração OpenAPI funciona; problema pode estar somente na interface/caminho Swagger UI.

---

## Cenário 16

> Tudo está vermelho no VS Code, mas `mvn compile` retorna BUILD SUCCESS.

Provável problema de IDE/Language Server/importação, não compilação real.

---

## Cenário 17

> Repository precisa verificar apenas se email existe.

Prefira:

```java
existsByEmail(...)
```

a carregar entidade inteira sem necessidade.

---

## Cenário 18

> Status sempre começa PENDENTE. Cliente deve enviar status no DTO?

Não necessariamente.

Melhor regra no Service:

```java
reserva.setStatus(StatusReserva.PENDENTE);
```

Assim cliente não burla regra inicial.

---

## Cenário 19

> `cpf` foi modelado como Long.

É uma escolha ruim na maioria dos casos porque CPF é identificador textual, pode ter zeros iniciais/formatação e não participa de cálculo.

---

## Cenário 20

> Por que `ResponseDTO` pode ter menos campos que Entity?

Porque contrato de saída deve expor apenas o necessário.

---

<a id="sec-41"></a>
# 41. PERGUNTAS ORAIS RÁPIDAS

Tente responder cada uma em até 15 segundos.

1. O que é Spring Boot?
2. O que é IoC?
3. O que é Injeção de Dependência?
4. O que é Bean?
5. Para que serve `@Service`?
6. Para que serve `@RestController`?
7. Para que serve `@Repository`?
8. O que é Entity?
9. O que é DTO?
10. Por que separar Request e Response?
11. O que é JPA?
12. O que é Hibernate?
13. O que é ORM?
14. O que é Spring Data JPA?
15. O que é PK?
16. O que é FK?
17. O que é cardinalidade?
18. Onde fica a FK em 1:N?
19. O que faz `@ManyToOne`?
20. O que faz `@OneToMany`?
21. O que significa `mappedBy`?
22. Quando criar entidade associativa?
23. O que é Cascade?
24. O que é LAZY?
25. O que é EAGER?
26. O que é Repository?
27. O que é Service?
28. O que é Controller?
29. O que é `@Valid`?
30. `@NotNull` x `@NotBlank`?
31. O que é REST?
32. O que é JSON?
33. O que é endpoint?
34. GET x POST?
35. PUT x PATCH?
36. O que é 201?
37. O que é 204?
38. 400 x 404?
39. 401 x 403?
40. O que é 409?
41. O que é BCrypt?
42. Hash x criptografia?
43. Para que serve `matches`?
44. O que é JWT?
45. Quais são as 3 partes do JWT?
46. O que é claim?
47. O que é assinatura?
48. JWT é criptografado?
49. O que é stateless?
50. Autenticação x autorização?
51. Role x Authority?
52. `hasRole` x `hasAuthority`?
53. Para que serve `JwtDecoder`?
54. Para que serve `JwtUtil`?
55. Para que serve Swagger?
56. Swagger x OpenAPI?
57. O que é Maven?
58. O que é POM?
59. O que é Maven Wrapper?
60. O que é `.m2`?
61. O que significa modo offline?
62. O que é enum?
63. Por que EnumType.STRING?
64. `record` x classe?
65. O que é Optional?
66. O que é transação?
67. O que é `@Transactional`?
68. O que é `ddl-auto=update`?
69. Por que retornar Entity pode ser ruim?
70. Por que regra de negócio fica no Service?

---

<a id="sec-42"></a>
# 42. CHECKLIST TEÓRICO FINAL

Você deveria conseguir explicar sem consultar:

```text
[ ] Spring x Spring Boot

[ ] IoC

[ ] Injeção de Dependência

[ ] Bean

[ ] @Component / @Service / @Repository / @RestController

[ ] Maven e pom.xml

[ ] Maven Wrapper e .m2

[ ] API / HTTP / REST / JSON

[ ] GET / POST / PUT / PATCH / DELETE

[ ] Entity

[ ] DTO

[ ] RequestDTO x ResponseDTO

[ ] Repository

[ ] Service

[ ] Controller

[ ] JPA x Hibernate x Spring Data JPA

[ ] ORM

[ ] PK x FK

[ ] OneToOne

[ ] OneToMany

[ ] ManyToOne

[ ] ManyToMany

[ ] entidade associativa

[ ] mappedBy

[ ] Cascade

[ ] LAZY x EAGER

[ ] @Valid

[ ] @NotNull x @NotBlank

[ ] 200 / 201 / 204

[ ] 400 / 401 / 403 / 404 / 405 / 409 / 500

[ ] autenticação x autorização

[ ] BCrypt

[ ] encode x matches

[ ] hashing x criptografia

[ ] JWT: header / payload / signature

[ ] claims: sub / exp / tipo

[ ] JWT não é necessariamente criptografado

[ ] stateless

[ ] Role x Authority

[ ] hasRole x hasAuthority

[ ] JwtUtil x JwtDecoder

[ ] Swagger x OpenAPI

[ ] application.properties

[ ] BigDecimal

[ ] LocalDate / LocalDateTime

[ ] enum + EnumType.STRING

[ ] record x classe

[ ] Optional

[ ] transação

[ ] ddl-auto

[ ] component scan
```

Se você consegue explicar cada item em 1–3 frases, já possui uma base teórica muito sólida para interpretar o código durante a prova.

---

<a id="sec-43"></a>
# 43. RESUMO DE UMA PÁGINA

```text
SPRING BOOT
=
Spring + convenções + auto-configuração + facilidade de execução.


IOC / DI
=
Spring cria e injeta objetos/dependências.


BEAN
=
objeto gerenciado pelo Spring.


ENTITY
=
modelo persistente mapeado pelo JPA.


DTO
=
objeto de transporte.

RequestDTO = entrada.
ResponseDTO = saída.


REPOSITORY
=
acesso ao banco.


SERVICE
=
regras de negócio.


CONTROLLER
=
HTTP.


JPA
=
especificação de persistência.


HIBERNATE
=
implementação ORM/JPA.


SPRING DATA JPA
=
facilita repositories e consultas.


ORM
=
objetos Java <-> tabelas.


PK
=
identifica registro.


FK
=
referencia registro de outra tabela.


1:N
=
FK normalmente fica no lado N.


ManyToMany com campos extras
=
criar entidade associativa.


@NotNull
=
não aceita null.


@NotBlank
=
String não nula, não vazia e não só espaços.


@Valid
=
aciona validação no parâmetro.


GET
=
ler.


POST
=
criar/ação.


PUT
=
atualizar/substituir.


PATCH
=
atualizar parcialmente.


DELETE
=
remover.


200
=
OK.


201
=
Created.


204
=
sucesso sem corpo.


400
=
entrada/requisição inválida.


401
=
não autenticado.


403
=
autenticado sem permissão.


404
=
não encontrado.


409
=
conflito/duplicidade.


500
=
erro interno inesperado.


AUTENTICAÇÃO
=
quem é?


AUTORIZAÇÃO
=
o que pode fazer?


BCRYPT
=
hash de senha.


encode()
=
gera hash para armazenar.


matches()
=
confere senha digitada contra hash.


JWT
=
HEADER.PAYLOAD.SIGNATURE


JWT ASSINADO
=
garante integridade/autenticidade,
não necessariamente confidencialidade.


STATELESS
=
servidor não depende de sessão HTTP para lembrar autenticação.


ROLE
=
authority com convenção ROLE_.


hasRole("ADMIN")
=
procura ROLE_ADMIN.


SWAGGER UI
=
interface de documentação/teste.


OPENAPI
=
especificação da API.


MAVEN
=
dependências + build.


POM.XML
=
configuração Maven.


MAVEN WRAPPER
=
scripts para executar Maven esperado.


.M2
=
cache/repositório Maven local.


BigDecimal
=
dinheiro.


LocalDate
=
data.


LocalDateTime
=
data + hora.


ENUM
=
conjunto fechado de valores.


EnumType.STRING
=
salva nome do enum no banco.


RECORD
=
estrutura compacta para dados/DTO.


OPTIONAL
=
valor pode existir ou não.


@Transactional
=
operações como unidade transacional.


ddl-auto=update
=
Hibernate tenta adequar schema durante desenvolvimento.


REGRA MENTAL FINAL:

HTTP
 ↓
CONTROLLER
 ↓
SERVICE
 ↓
REPOSITORY
 ↓
JPA/HIBERNATE
 ↓
POSTGRESQL
```

---

# FIM

Este arquivo deve ser usado junto com o manual prático:

```text
MANUAL PRÁTICO
=
"como escrever e corrigir"

BASE TEÓRICA
=
"o que significa e por que funciona"
```

Se você souber navegar entre os dois, consegue tanto **montar o código** quanto **explicar as decisões** que tomou.
