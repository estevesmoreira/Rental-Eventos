# Rental-Eventos 

### Link do Swagger: http://localhost:8080/rental-eventos/swagger-ui/index.html
## SUMÁRIO

> **Como usar:** no GitHub, clique no título para ir direto à seção. Em um editor/visualizador de texto, use o número da **linha** indicado. Estes números consideram este sumário inserido imediatamente após a linha 3 do arquivo.

### 1. Enunciado e estratégia de prova

* [CONTEXTUALIZAÇÃO](#contextualização) — linha **191**
* [DESAFIO](#desafio) — linha **213**
* [OBJETIVO DESTE ARQUIVO](#objetivo-deste-arquivo) — linha **231**
* [\(ORDEM\) PARTE 1 — O QUE FAZER NOS PRIMEIROS 10 MINUTOS](#ordem-parte-1--o-que-fazer-nos-primeiros-10-minutos) — linha **260**
* [DIVISÃO DAS 3 HORAS](#divisão-das-3-horas) — linha **350**
* [REGRA DE OURO DA PROVA](#regra-de-ouro-da-prova) — linha **448**
* [\(ESTRUTURA\) ESTRUTURA DE PACOTES](#estrutura-estrutura-de-pacotes) — linha **464**
* [CLASSE MAIN](#classe-main) — linha **556**
* [\(PROPERTIES\) application.properties](#properties-applicationproperties) — linha **597**

### 2. Usuário, autenticação, JWT e Security

* [\(USUARIO\) PARTE 2 — USUÁRIO COMPLETO](#usuario-parte-2--usuário-completo) — linha **666**
* [TipoUsuario.java](#tipousuariojava) — linha **689**
* [Usuario.java](#usuariojava) — linha **744**
* [UsuarioRequestDTO.java](#usuariorequestdtojava) — linha **877**
* [UsuarioUpdateDTO.java](#usuarioupdatedtojava) — linha **922**
* [UsuarioResponseDTO.java](#usuarioresponsedtojava) — linha **970**
* [LoginDTO.java](#logindtojava) — linha **1009**
* [LoginResponseDTO.java](#loginresponsedtojava) — linha **1067**
* [UsuarioRepository.java](#usuariorepositoryjava) — linha **1092**
* [\(SERVICE\) UsuarioService.java](#service-usuarioservicejava) — linha **1130**
* [\(JWT\) JwtUtil.java](#jwt-jwtutiljava) — linha **1326**
* [AuthService.java](#authservicejava) — linha **1432**
* [AuthController.java](#authcontrollerjava) — linha **1506**
* [UsuarioController.java](#usuariocontrollerjava) — linha **1573**
* [\(SECURITY\) SecurityConfig.java](#security-securityconfigjava) — linha **1690**
* [ENTENDA A PARTE DA ROLE](#entenda-a-parte-da-role) — linha **1846**
* [EXEMPLO DE SECURITY MAIS COMPLETO](#exemplo-de-security-mais-completo) — linha **1907**
* [\(JWT FILTER\) PRECISO DO JwtAuthenticationFilter?](#jwt-filter-preciso-do-jwtauthenticationfilter) — linha **1966**
* [\(SWAGGER\) Swagger.java](#swagger-swaggerjava) — linha **2020**

### 3. Criar/abrir o projeto e trabalhar offline

* [ANEXO — CRIANDO E SALVANDO O PROJETO NA PROVA](#anexo--criando-e-salvando-o-projeto-na-prova) — linha **2086**
* [\(VSCODE\) CRIANDO UM PROJETO SPRING PELO VS CODE](#vscode-criando-um-projeto-spring-pelo-vs-code) — linha **2110**
* [DEPENDÊNCIAS](#dependências) — linha **2205**
* [\(OFFLINE\) MÉTODO MAIS SEGURO NA PROVA](#offline-método-mais-seguro-na-prova) — linha **2241**
* [O QUE COPIAR DO PROJETO BASE](#o-que-copiar-do-projeto-base) — linha **2280**
* [\(NOVO\) CRIANDO PROJETO MANUALMENTE SEM INITIALIZR](#novo-criando-projeto-manualmente-sem-initializr) — linha **2318**
* [ESTRUTURA FINAL](#estrutura-final) — linha **2393**
* [\(POM\) POM.XML BASE](#pom-pomxml-base) — linha **2434**
* [\(PROPERTIES\) APPLICATION.PROPERTIES BASE](#properties-applicationproperties-base) — linha **2675**
* [\(VSCODE\) ABRINDO CORRETAMENTE NO VS CODE](#vscode-abrindo-corretamente-no-vs-code) — linha **2745**
* [\(JAVA\) CONFERINDO O JAVA](#java-conferindo-o-java) — linha **2807**
* [VS CODE — CONFIGURAR JDK](#vs-code--configurar-jdk) — linha **2859**
* [\(MAVEN\) COMANDOS ESSENCIAIS](#maven-comandos-essenciais) — linha **2919**
* [OFFLINE](#offline) — linha **2953**
* [\(MAVEN\) COMO SABER SE O PROBLEMA É MAVEN OU SEU CÓDIGO](#maven-como-saber-se-o-problema-é-maven-ou-seu-código) — linha **3029**
* [\(RED\) TODAS AS CLASSES FICARAM VERMELHAS NO VS CODE](#red-todas-as-classes-ficaram-vermelhas-no-vs-code) — linha **3063**
* [\(POM RED\) DEPENDÊNCIAS VERMELHAS NO POM](#pom-red-dependências-vermelhas-no-pom) — linha **3135**
* [CACHE DO MAVEN](#cache-do-maven) — linha **3173**
* [\(WRAPPER\) ERRO DO MAVEN WRAPPER OFFLINE](#wrapper-erro-do-maven-wrapper-offline) — linha **3194**

### 4. Outras IDEs, packages, banco e Swagger

* [\(IDE\) SE NÃO FOR VS CODE](#ide-se-não-for-vs-code) — linha **3226**
* [\(INTELLIJ\) INTELLIJ IDEA](#intellij-intellij-idea) — linha **3249**
* [\(ECLIPSE / STS\)](#eclipse--sts) — linha **3291**
* [\(NETBEANS\)](#netbeans) — linha **3339**
* [\(IDE DESCONHECIDA\) SE A PROVA USAR UMA IDE PRÓPRIA](#ide-desconhecida-se-a-prova-usar-uma-ide-própria) — linha **3377**
* [\(PACKAGE\) ERRO MAIS COMUM AO COPIAR PROJETO](#package-erro-mais-comum-ao-copiar-projeto) — linha **3411**
* [A CLASSE MAIN PRECISA ESTAR NO PACOTE RAIZ](#a-classe-main-precisa-estar-no-pacote-raiz) — linha **3455**
* [\(IMPORT\) ERRO DE IMPORT](#import-erro-de-import) — linha **3493**
* [\(IMPORT\) IMPORT ERRADO ENTRE JAVAX E JAKARTA](#import-import-errado-entre-javax-e-jakarta) — linha **3525**
* [\(BANCO\) BANCO NÃO CONECTA](#banco-banco-não-conecta) — linha **3551**
* [\(BANCO\) PASSWORD AUTHENTICATION FAILED](#banco-password-authentication-failed) — linha **3615**
* [\(BANCO\) DATABASE DOES NOT EXIST](#banco-database-does-not-exist) — linha **3642**
* [\(RESET\) ALTEREI ENTIDADE E BANCO FICOU ESTRANHO](#reset-alterei-entidade-e-banco-ficou-estranho) — linha **3666**
* [RESET MAIS SEGURO: APAGAR APENAS AS TABELAS DO PROJETO](#reset-mais-seguro-apagar-apenas-as-tabelas-do-projeto) — linha **3704**
* [RESET TOTAL DO SCHEMA — SOMENTE EM BANCO DESCARTÁVEL](#reset-total-do-schema--somente-em-banco-descartável) — linha **3730**
* [\(SQL\) VER SE TABELAS FORAM CRIADAS](#sql-ver-se-tabelas-foram-criadas) — linha **3808**
* [\(JPA\) MOSTRAR SQL](#jpa-mostrar-sql) — linha **3826**
* [\(SWAGGER\) SWAGGER NÃO ABRE](#swagger-swagger-não-abre) — linha **3848**
* [\(TESTE\) ENDPOINT DE TESTE](#teste-endpoint-de-teste) — linha **3981**
* [\(404\) 404 NOT FOUND](#404-404-not-found) — linha **4023**
* [\(405\) METHOD NOT ALLOWED](#405-method-not-allowed) — linha **4057**
* [\(400\) BAD REQUEST](#400-bad-request) — linha **4085**
* [\(500\) INTERNAL SERVER ERROR](#500-internal-server-error) — linha **4126**
* [\(POM\) ERRO DE XML](#pom-erro-de-xml) — linha **4146**
* [\(TARGET\) PROJETO PARECE USAR CÓDIGO ANTIGO](#target-projeto-parece-usar-código-antigo) — linha **4216**
* [\(PORT\) PORTA 8080 OCUPADA](#port-porta-8080-ocupada) — linha **4262**

### 5. Tipos, anotações e arquitetura por pacote

* [\(DATA TYPES\) TIPOS DE DADOS MAIS IMPORTANTES](#data-types-tipos-de-dados-mais-importantes) — linha **4311**
* [CPF NÃO DEVE SER LONG](#cpf-não-deve-ser-long) — linha **4333**
* [\(BIGDECIMAL\) DINHEIRO](#bigdecimal-dinheiro) — linha **4366**
* [\(BOOLEAN\)](#boolean) — linha **4390**
* [\(LOCALDATE\)](#localdate) — linha **4419**
* [\(LOCALDATETIME\)](#localdatetime) — linha **4458**
* [\(ENTITY\) ANOTAÇÕES PRINCIPAIS DE MODEL/ENTITY](#entity-anotações-principais-de-modelentity) — linha **4474**
* [\(DTO\) ANOTAÇÕES PRINCIPAIS DE DTO](#dto-anotações-principais-de-dto) — linha **4528**
* [DIFERENÇA ENTRE NOTNULL, NOTEMPTY E NOTBLANK](#diferença-entre-notnull-notempty-e-notblank) — linha **4609**
* [\(REPOSITORY\) PACOTE REPOSITORY](#repository-pacote-repository) — linha **4651**
* [MÉTODOS DERIVADOS](#métodos-derivados) — linha **4676**
* [\(SERVICE\) PACOTE SERVICE](#service-pacote-service) — linha **4707**
* [\(TRANSACTIONAL\)](#transactional) — linha **4752**
* [\(CONTROLLER\) PACOTE CONTROLLER](#controller-pacote-controller) — linha **4782**
* [\(CONFIG\) PACOTE CONFIGS](#config-pacote-configs) — linha **4888**
* [\(SECURITY\) ANOTAÇÕES/CLASSES PRINCIPAIS](#security-anotaçõesclasses-principais) — linha **4916**
* [\(RELATIONSHIPS\) ANOTAÇÕES DE RELACIONAMENTO](#relationships-anotações-de-relacionamento) — linha **4953**
*


## CONTEXTUALIZAÇÃO

Uma empresa especializada na locação de equipamentos para eventos (cadeiras, mesas, caixas de som, projetores, microfones, tendas e painéis de LED) vem enfrentando diversos problemas no controle dos equipamentos disponíveis.

Hoje todo o controle é realizado em planilhas eletrônicas. Frequentemente equipamentos são alugados para dois clientes na mesma data, itens retornam danificados sem registro e muitas vezes não é possível identificar quem realizou determinada movimentação.

Além disso, cada equipamento possui características próprias.

Exemplos:

- Projetor Epson PowerLite X49 – 3600 Lumens
- Caixa de Som JBL PartyBox 710 – 800W
- Microfone Shure SM58 – Dinâmico
- Mesa Dobrável 1,80m
- Cadeira Tiffany Branca

Cada equipamento possui informações específicas como: Marca, Modelo, Categoria, Potência, Material, Peso, Dimensões, Cor e Quantidade disponível.

Também é necessário configurar uma quantidade mínima para cada equipamento, permitindo que o sistema gere alertas quando o estoque disponível atingir um nível crítico.

Toda movimentação (entrada de novos equipamentos ou saída para locações) deverá registrar: usuário responsável, data da movimentação, tipo da movimentação e quantidade para permitir rastreabilidade completa.

## DESAFIO

Desenvolver um sistema Web ou Desktop para gerenciamento de equipamentos de locação.

O sistema deverá permitir:

- cadastro de equipamentos;
- consulta dos equipamentos cadastrados;
- atualização das informações;
- exclusão;
- gerenciamento das entradas e saídas;
- alerta automático de estoque mínimo;
- histórico das movimentações.

#Documentacao Reserva:

# MANUAL DE PROVA — SPRING BOOT + JPA + DTO + SERVICE + SECURITY + JWT

## OBJETIVO DESTE ARQUIVO

Na prova, NÃO tente lembrar tudo.

Use este documento como uma biblioteca.

Pesquise com `CTRL + F` por:

* `[ORDEM]`
* `[USUARIO]`
* `[JWT]`
* `[CRUD]`
* `[RELACIONAMENTO]`
* `[MANYTOONE]`
* `[MANYTOMANY]`
* `[VALIDACAO]`
* `[ERROS]`
* `[401]`
* `[403]`
* `[BANCO]`
* `[SWAGGER]`
* `[CHECKLIST]`

A lógica da prova deve ser:

**MINIMUNDO → ENTIDADES → RELACIONAMENTOS → DTO → REPOSITORY → SERVICE → CONTROLLER → SECURITY → TESTE.**

---

# [ORDEM] PARTE 1 — O QUE FAZER NOS PRIMEIROS 10 MINUTOS

Antes de escrever código, leia o minimundo inteiro.

Faça uma tabela rápida no papel.

Exemplo de minimundo:

> Um sistema possui usuários. Cada usuário pode cadastrar vários eventos.
> Cada evento possui nome, data, local e status.
> Um evento pode possuir diversos equipamentos.
> Apenas administradores podem excluir equipamentos.

Extraia:

```text
ENTIDADES:
Usuario
Evento
Equipamento

USUARIO:
id
nome
email
senha
tipo

EVENTO:
id
nome
data
local
status
usuario

EQUIPAMENTO:
id
nome
preco
quantidade

RELACIONAMENTOS:
Usuario 1 ---- N Evento

Evento N ---- N Equipamento

REGRA:
Somente ADMIN pode excluir equipamento.
```

Depois marque cada frase do minimundo mentalmente como um destes tipos:

```text
SUBSTANTIVO IMPORTANTE
    -> provavelmente Entity

"possui"
    -> campo ou relacionamento

"um ... possui vários..."
    -> @OneToMany / @ManyToOne

"muitos ... podem..."
    -> possível @ManyToMany

"é obrigatório"
    -> validação DTO

"não pode repetir"
    -> unique + verificação Service

"somente administrador"
    -> Security

"deve calcular"
    -> Service

"ao cadastrar..."
    -> Service

"status"
    -> provavelmente enum

"tipo"
    -> provavelmente enum
```

---

# DIVISÃO DAS 3 HORAS

## 00:00–00:15

Entender minimundo.

Não programe antes de saber:

```text
quais entidades existem
quais campos existem
quais relacionamentos existem
quais regras de negócio existem
quem pode acessar o quê
```

## 00:15–00:30

Criar/copy base do projeto.

Confirmar:

```text
pom.xml
application.properties
classe main
banco funcionando
```

Rodar uma primeira vez.

## 00:30–01:10

Fazer:

```text
enums
models/entities
repositories
```

## 01:10–01:50

Fazer:

```text
DTOs
services
controllers
```

## 01:50–02:15

Fazer:

```text
Usuario
Login
BCrypt
JWT
SecurityConfig
```

Se usuário já foi feito primeiro, use esse tempo para relacionamentos.

## 02:15–02:40

Testar tudo pelo Swagger.

Principalmente:

```text
POST
GET
PUT
DELETE
LOGIN
rota autenticada
```

## 02:40–03:00

NÃO invente funcionalidade nova.

Corrija:

```text
erros de compilação
401
403
relacionamentos
JSON
validações
nomes das rotas
```

---

# REGRA DE OURO DA PROVA

Se faltarem 25 minutos:

**PARE DE CRIAR COISAS NOVAS.**

Um CRUD simples funcionando vale mais que:

```text
10 endpoints quebrados
JWT pela metade
relacionamento sofisticado quebrando JSON
```

---

# [ESTRUTURA] ESTRUTURA DE PACOTES

Use uma estrutura assim:

```text
src/main/java/com/senai/infoa/rental_eventos/

RentalEventosApplication.java

configs/
    Swagger.java

controller/
    UsuarioController.java
    AuthController.java
    EquipamentoController.java

dto/
    UsuarioRequestDTO.java
    UsuarioUpdateDTO.java
    UsuarioResponseDTO.java
    LoginDTO.java
    LoginResponseDTO.java
    EquipamentoRequestDTO.java
    EquipamentoResponseDTO.java

enuns/
    TipoUsuario.java
    CategoriaEquipamento.java

model/
    Usuario.java
    Equipamento.java

repository/
    UsuarioRepository.java
    EquipamentoRepository.java

service/
    UsuarioService.java
    AuthService.java
    EquipamentoService.java

security/
    JwtUtil.java
    SecurityConfig.java
```

IMPORTANTE:

Se seu projeto utiliza:

```java
models
```

em vez de:

```java
model
```

não misture.

Se utiliza:

```java
repositories
```

não escreva:

```java
repository
```

O nome da pasta precisa acompanhar o `package`.

Por exemplo:

```java
package com.senai.infoa.rental_eventos.service;
```

deve estar logicamente em:

```text
.../service/
```

---

# CLASSE MAIN

Se precisar criar do zero:

```java
package com.senai.infoa.rental_eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentalEventosApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalEventosApplication.class, args);
    }
}
```

MUITO IMPORTANTE:

A classe com `@SpringBootApplication` deve ficar no pacote raiz.

CERTO:

```text
com.senai.infoa.rental_eventos
```

E os outros:

```text
com.senai.infoa.rental_eventos.model
com.senai.infoa.rental_eventos.repository
com.senai.infoa.rental_eventos.service
```

Assim o Spring encontra automaticamente os componentes.

---

# [PROPERTIES] application.properties

Base já compatível com seu Rental Eventos:

```properties
spring.application.name=rental-eventos

server.port=8080


# =========================
# BANCO DE DADOS
# =========================

spring.datasource.url=jdbc:postgresql://localhost:5433/postgres
spring.datasource.username=postgres
spring.datasource.password=aluno

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true


# =========================
# SWAGGER
# =========================

springdoc.swagger-ui.path=/rental-eventos/swagger-ui.html
springdoc.api-docs.path=/v3/api-docs

springdoc.swagger-ui.enabled=true
springdoc.api-docs.enabled=true


# =========================
# JWT
# =========================

jwt.secret=rental-eventos-chave-secreta-2026-seguranca
jwt.expiration=86400000
```

Se o banco da prova estiver em outra porta:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/NOME_DO_BANCO
```

Se for:

```text
porta 5432
banco prova
usuario postgres
senha aluno
```

fica:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/prova
spring.datasource.username=postgres
spring.datasource.password=aluno
```

---

# [USUARIO] PARTE 2 — USUÁRIO COMPLETO

Este é o bloco mais importante deste documento.

Se aparecer qualquer coisa semelhante a:

```text
Usuário
Cliente
Aluno
Professor
Funcionário
Administrador
Paciente
Médico
Locador
Locatário
```

você poderá adaptar esta estrutura.

---

# TipoUsuario.java

```java
package com.senai.infoa.rental_eventos.enuns;

public enum TipoUsuario {

    ADMIN,
    USUARIO

}
```

Se o minimundo disser:

```text
administrador
cliente
funcionario
```

troque por:

```java
package com.senai.infoa.rental_eventos.enuns;

public enum TipoUsuario {

    ADMIN,
    CLIENTE,
    FUNCIONARIO

}
```

Se disser:

```text
médico
paciente
```

pode ser:

```java
public enum TipoUsuario {

    MEDICO,
    PACIENTE

}
```

---

# Usuario.java

```java
package com.senai.infoa.rental_eventos.model;

import com.senai.infoa.rental_eventos.enuns.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;

    public Usuario() {
    }

    public Usuario(
            Long id,
            String nome,
            String email,
            String senha,
            TipoUsuario tipo) {

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
```

---

# IMPORTANTE SOBRE ENUM

Faça:

```java
@Enumerated(EnumType.STRING)
private TipoUsuario tipo;
```

NÃO prefira:

```java
@Enumerated(EnumType.ORDINAL)
```

Porque `ORDINAL` grava algo como:

```text
0
1
2
```

Enquanto `STRING` grava:

```text
ADMIN
CLIENTE
FUNCIONARIO
```

Muito mais fácil de entender e testar.

---

# UsuarioRequestDTO.java

```java
package com.senai.infoa.rental_eventos.dto;

import com.senai.infoa.rental_eventos.enuns.TipoUsuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 8)
        String senha,

        @NotNull
        TipoUsuario tipo

) {
}
```

JSON correspondente:

```json
{
  "nome": "Nicolas",
  "email": "nicolas@email.com",
  "senha": "12345678",
  "tipo": "ADMIN"
}
```

---

# UsuarioUpdateDTO.java

Para atualização, é útil permitir não alterar a senha:

```java
package com.senai.infoa.rental_eventos.dto;

import com.senai.infoa.rental_eventos.enuns.TipoUsuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateDTO(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @Size(min = 8)
        String senha,

        @NotNull
        TipoUsuario tipo

) {
}
```

Assim você pode receber:

```json
{
  "nome": "Nicolas Atualizado",
  "email": "nicolas@email.com",
  "senha": null,
  "tipo": "ADMIN"
}
```

Se `senha == null`, mantém a antiga.

---

# UsuarioResponseDTO.java

NUNCA retorne senha.

```java
package com.senai.infoa.rental_eventos.dto;

import com.senai.infoa.rental_eventos.enuns.TipoUsuario;

public record UsuarioResponseDTO(

        Long id,
        String nome,
        String email,
        TipoUsuario tipo

) {
}
```

A resposta fica:

```json
{
  "id": 1,
  "nome": "Nicolas",
  "email": "nicolas@email.com",
  "tipo": "ADMIN"
}
```

Sem:

```json
"senha": "$2a$10$..."
```

---

# LoginDTO.java

Você já tem uma versão dessa classe.

Pode manter esta estrutura:

```java
package com.senai.infoa.rental_eventos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

    public LoginDTO() {
    }

    public LoginDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
```

JSON:

```json
{
  "email": "nicolas@email.com",
  "senha": "12345678"
}
```

---

# LoginResponseDTO.java

```java
package com.senai.infoa.rental_eventos.dto;

public class LoginResponseDTO {

    private String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
```

---

# UsuarioRepository.java

```java
package com.senai.infoa.rental_eventos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infoa.rental_eventos.model.Usuario;

@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCase(String email);

}
```

Só isso.

Você NÃO implementa:

```java
save()
findAll()
findById()
delete()
```

O `JpaRepository` já fornece.

---

# [SERVICE] UsuarioService.java

```java
package com.senai.infoa.rental_eventos.service;

import java.util.List;
import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senai.infoa.rental_eventos.dto.UsuarioRequestDTO;
import com.senai.infoa.rental_eventos.dto.UsuarioResponseDTO;
import com.senai.infoa.rental_eventos.dto.UsuarioUpdateDTO;
import com.senai.infoa.rental_eventos.model.Usuario;
import com.senai.infoa.rental_eventos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {

        String email = normalizarEmail(dto.email());

        if (usuarioRepository.existsByEmailIgnoreCase(email)) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Já existe um usuário cadastrado com este e-mail"
            );
        }

        Usuario usuario = new Usuario();

        usuario.setNome(dto.nome());
        usuario.setEmail(email);

        usuario.setSenha(
                passwordEncoder.encode(dto.senha())
        );

        usuario.setTipo(dto.tipo());

        Usuario salvo =
                usuarioRepository.save(usuario);

        return toResponseDTO(salvo);
    }

    public List<UsuarioResponseDTO> listarTodos() {

        return usuarioRepository
                .findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {

        Usuario usuario = buscarEntidadePorId(id);

        return toResponseDTO(usuario);
    }

    public UsuarioResponseDTO atualizar(
            Long id,
            UsuarioUpdateDTO dto) {

        Usuario usuario = buscarEntidadePorId(id);

        String novoEmail =
                normalizarEmail(dto.email());

        usuarioRepository
                .findByEmailIgnoreCase(novoEmail)
                .ifPresent(outroUsuario -> {

                    if (!outroUsuario.getId().equals(id)) {

                        throw new ResponseStatusException(
                                HttpStatus.CONFLICT,
                                "Já existe outro usuário com este e-mail"
                        );
                    }
                });

        usuario.setNome(dto.nome());
        usuario.setEmail(novoEmail);
        usuario.setTipo(dto.tipo());

        if (dto.senha() != null) {

            usuario.setSenha(
                    passwordEncoder.encode(dto.senha())
            );
        }

        Usuario atualizado =
                usuarioRepository.save(usuario);

        return toResponseDTO(atualizado);
    }

    public void excluir(Long id) {

        Usuario usuario =
                buscarEntidadePorId(id);

        usuarioRepository.delete(usuario);
    }

    public Usuario buscarEntidadePorId(Long id) {

        return usuarioRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Usuário não encontrado"
                        )
                );
    }

    private UsuarioResponseDTO toResponseDTO(
            Usuario usuario) {

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipo()
        );
    }

    private String normalizarEmail(String email) {

        return email
                .trim()
                .toLowerCase(Locale.ROOT);
    }
}
```

---

# O QUE É MAIS IMPORTANTE NESSE SERVICE

Cadastro:

```java
passwordEncoder.encode(dto.senha())
```

Login posteriormente:

```java
passwordEncoder.matches(
    senhaDigitada,
    senhaCriptografada
)
```

NUNCA faça:

```java
usuario.getSenha().equals(dto.getSenha())
```

porque o banco contém:

```text
$2a$10$Xj...
```

e não:

```text
12345678
```

---

# [JWT] JwtUtil.java

Este padrão é compatível com a estrutura do Rental Eventos:

```java
package com.senai.infoa.rental_eventos.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }

    public String gerarToken(
            String email,
            String tipoUsuario) {

        Date agora = new Date();

        Date expiracao =
                new Date(
                        agora.getTime() + expiration
                );

        return Jwts.builder()
                .subject(email)
                .claim("tipo", tipoUsuario)
                .issuedAt(agora)
                .expiration(expiracao)
                .signWith(
                        getSigningKey(),
                        Jwts.SIG.HS256
                )
                .compact();
    }

    public String extrairEmail(String token) {

        Claims claims =
                Jwts.parser()
                        .verifyWith(getSigningKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

        return claims.getSubject();
    }

    public String extrairTipoUsuario(String token) {

        Claims claims =
                Jwts.parser()
                        .verifyWith(getSigningKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

        return claims.get(
                "tipo",
                String.class
        );
    }

    public boolean validarToken(String token) {

        try {

            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}
```

---

# AuthService.java

```java
package com.senai.infoa.rental_eventos.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senai.infoa.rental_eventos.dto.LoginDTO;
import com.senai.infoa.rental_eventos.dto.LoginResponseDTO;
import com.senai.infoa.rental_eventos.model.Usuario;
import com.senai.infoa.rental_eventos.repository.UsuarioRepository;
import com.senai.infoa.rental_eventos.security.JwtUtil;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponseDTO login(LoginDTO dto) {

        Usuario usuario =
                usuarioRepository
                        .findByEmailIgnoreCase(dto.getEmail())
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.UNAUTHORIZED,
                                        "E-mail ou senha inválidos"
                                )
                        );

        boolean senhaCorreta =
                passwordEncoder.matches(
                        dto.getSenha(),
                        usuario.getSenha()
                );

        if (!senhaCorreta) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "E-mail ou senha inválidos"
            );
        }

        String token =
                jwtUtil.gerarToken(
                        usuario.getEmail(),
                        usuario.getTipo().name()
                );

        return new LoginResponseDTO(token);
    }
}
```

---

# AuthController.java

```java
package com.senai.infoa.rental_eventos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.rental_eventos.dto.LoginDTO;
import com.senai.infoa.rental_eventos.dto.LoginResponseDTO;
import com.senai.infoa.rental_eventos.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService) {

        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid
            @RequestBody
            LoginDTO dto) {

        return ResponseEntity.ok(
                authService.login(dto)
        );
    }
}
```

Endpoint:

```text
POST /auth/login
```

Body:

```json
{
  "email": "admin@email.com",
  "senha": "12345678"
}
```

Resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

# UsuarioController.java

```java
package com.senai.infoa.rental_eventos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.rental_eventos.dto.UsuarioRequestDTO;
import com.senai.infoa.rental_eventos.dto.UsuarioResponseDTO;
import com.senai.infoa.rental_eventos.dto.UsuarioUpdateDTO;
import com.senai.infoa.rental_eventos.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(
            UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvar(
            @Valid
            @RequestBody
            UsuarioRequestDTO dto) {

        UsuarioResponseDTO usuario =
                usuarioService.salvar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>>
            listarTodos() {

        return ResponseEntity.ok(
                usuarioService.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO>
            buscarPorId(
                    @PathVariable
                    Long id) {

        return ResponseEntity.ok(
                usuarioService.buscarPorId(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO>
            atualizar(
                    @PathVariable
                    Long id,

                    @Valid
                    @RequestBody
                    UsuarioUpdateDTO dto) {

        return ResponseEntity.ok(
                usuarioService.atualizar(
                        id,
                        dto
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable
            Long id) {

        usuarioService.excluir(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
```

Você acaba de criar:

```text
POST   /usuarios
GET    /usuarios
GET    /usuarios/{id}
PUT    /usuarios/{id}
DELETE /usuarios/{id}

POST   /auth/login
```

---

# [SECURITY] SecurityConfig.java

Essa é uma das partes mais importantes.

Use:

```java
package com.senai.infoa.rental_eventos.security;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import io.jsonwebtoken.security.Keys;

@Configuration
public class SecurityConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            JwtAuthenticationConverter converter)
            throws Exception {

        http

                .csrf(csrf ->
                        csrf.disable()
                )

                .formLogin(form ->
                        form.disable()
                )

                .httpBasic(basic ->
                        basic.disable()
                )

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .authorizeHttpRequests(auth -> auth

                        // SWAGGER

                        .requestMatchers(
                                "/rental-eventos/swagger-ui.html",
                                "/rental-eventos/swagger-ui/**",
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        )
                        .permitAll()

                        // CADASTRO E LOGIN

                        .requestMatchers(
                                HttpMethod.POST,
                                "/usuarios",
                                "/auth/login"
                        )
                        .permitAll()

                        // TODO:
                        // coloque aqui regras específicas
                        // se o minimundo exigir.

                        .anyRequest()
                        .authenticated()
                )

                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt ->
                                jwt.jwtAuthenticationConverter(
                                        converter
                                )
                        )
                );

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {

        SecretKey key =
                Keys.hmacShaKeyFor(
                        secret.getBytes(
                                StandardCharsets.UTF_8
                        )
                );

        return NimbusJwtDecoder
                .withSecretKey(key)
                .macAlgorithm(
                        MacAlgorithm.HS256
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationConverter
            jwtAuthenticationConverter() {

        JwtGrantedAuthoritiesConverter authorities =
                new JwtGrantedAuthoritiesConverter();

        authorities.setAuthoritiesClaimName(
                "tipo"
        );

        authorities.setAuthorityPrefix(
                "ROLE_"
        );

        JwtAuthenticationConverter converter =
                new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(
                authorities
        );

        return converter;
    }
}
```

---

# ENTENDA A PARTE DA ROLE

Token:

```json
{
  "sub": "admin@email.com",
  "tipo": "ADMIN"
}
```

Seu converter adiciona:

```text
ROLE_
```

Portanto a authority vira:

```text
ROLE_ADMIN
```

Se quiser restringir rota:

```java
.requestMatchers(
        HttpMethod.DELETE,
        "/usuarios/**"
)
.hasRole("ADMIN")
```

CORRETO:

```java
.hasRole("ADMIN")
```

EVITE:

```java
.hasRole("ROLE_ADMIN")
```

porque `hasRole` já trata o prefixo `ROLE_`.

Se utilizar:

```java
.hasAuthority(...)
```

aí sim seria:

```java
.hasAuthority("ROLE_ADMIN")
```

---

# EXEMPLO DE SECURITY MAIS COMPLETO

Suponha:

```text
qualquer pessoa pode se cadastrar
qualquer pessoa pode fazer login
usuário autenticado pode consultar equipamentos
somente ADMIN pode criar equipamento
somente ADMIN pode excluir equipamento
```

Faça:

```java
.authorizeHttpRequests(auth -> auth

    .requestMatchers(
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/rental-eventos/swagger-ui/**",
        "/rental-eventos/swagger-ui.html",
        "/v3/api-docs/**"
    ).permitAll()

    .requestMatchers(
        HttpMethod.POST,
        "/usuarios",
        "/auth/login"
    ).permitAll()

    .requestMatchers(
        HttpMethod.POST,
        "/equipamentos/**"
    ).hasRole("ADMIN")

    .requestMatchers(
        HttpMethod.DELETE,
        "/equipamentos/**"
    ).hasRole("ADMIN")

    .anyRequest().authenticated()
)
```

A ORDEM IMPORTA.

Não faça:

```java
.anyRequest().authenticated()

.requestMatchers("/auth/login").permitAll()
```

A regra geral deve ficar no final.

---

# [JWT FILTER] PRECISO DO JwtAuthenticationFilter?

No seu modelo atual:

```java
.oauth2ResourceServer(
    oauth2 -> oauth2.jwt(...)
)
```

já existe infraestrutura do Spring Security para ler:

```text
Authorization: Bearer TOKEN
```

e validar usando:

```java
JwtDecoder
```

Portanto não precisa perder tempo criando manualmente:

```java
OncePerRequestFilter
```

se a prova não exigir.

Seu fluxo fica:

```text
LOGIN
   ↓
JwtUtil gera token
   ↓
cliente recebe token
   ↓
Authorization: Bearer token
   ↓
Spring Security Resource Server
   ↓
JwtDecoder valida assinatura
   ↓
claim "tipo"
   ↓
ROLE_ADMIN / ROLE_USUARIO
```

Muito mais simples.

---

# [SWAGGER] Swagger.java

```java
package com.senai.infoa.rental_eventos.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(

        info = @Info(
                title = "SISTEMA",
                version = "1.0",
                description = "API do sistema"
        ),

        security =
                @SecurityRequirement(
                        name = "bearerAuth"
                )
)

@SecurityScheme(

        name = "bearerAuth",

        type =
                SecuritySchemeType.HTTP,

        scheme = "bearer",

        bearerFormat = "JWT"
)

public class Swagger {
}
```

No Swagger aparecerá:

```text
Authorize
```

Faça login.

Copie apenas:

```text
eyJhbGciOi...
```

Normalmente não precisa escrever manualmente:

```text
Bearer eyJ...
```

no cam

# ANEXO — CRIANDO E SALVANDO O PROJETO NA PROVA

Este anexo serve para a situação mais perigosa da prova:

> “Eu sei fazer as classes, mas não consigo nem colocar o projeto para rodar.”

A prioridade é sempre chegar o mais rápido possível a este estado:

```text
Projeto Maven reconhecido
        ↓
Java reconhecido
        ↓
Spring Boot inicia
        ↓
Banco conecta
        ↓
Swagger abre
        ↓
A partir daí começo as entidades
```

---

# [VSCODE] CRIANDO UM PROJETO SPRING PELO VS CODE

Considerando que já estão instalados:

```text
Extension Pack for Java
Spring Boot Extension Pack
```

o VS Code deverá oferecer suporte a Java, Maven e Spring.

## MÉTODO 1 — SPRING INITIALIZR PELO VS CODE

Este é o caminho normal quando existe acesso ao Spring Initializr.

Pressione:

```text
CTRL + SHIFT + P
```

Procure:

```text
Spring Initializr: Create a Maven Project
```

Selecione Maven.

Depois escolha a versão do Spring Boot disponível.

Se estiver reproduzindo exatamente sua base atual, a referência é:

```text
Spring Boot 4.1.1
```

Selecione:

```text
Java
```

Group Id:

```text
com.senai.infoa
```

Artifact Id, exemplo:

```text
prova
```

Packaging:

```text
Jar
```

Java:

```text
25
```

Package sugerido:

```text
com.senai.infoa.prova
```

ATENÇÃO:

Artifact pode ter hífen:

```text
rental-eventos
```

Package Java NÃO deve ter hífen:

```text
com.senai.infoa.rental_eventos
```

e não:

```text
com.senai.infoa.rental-eventos
```

---

# DEPENDÊNCIAS

Se estiver criando pelo Initializr, procure algo equivalente a:

```text
Spring Web
Spring Data JPA
Validation
PostgreSQL Driver
Spring Security
OAuth2 Resource Server
Spring Boot DevTools
```

Depois será necessário adicionar ao `pom.xml` as dependências que o Initializr não oferecer diretamente, como JJWT e Springdoc.

PORÉM:

## NA PROVA SEM INTERNET, NÃO CONFIE NO SPRING INITIALIZR.

O comando do VS Code normalmente precisa consultar o serviço do Spring Initializr.

Portanto, se estiver completamente offline, existe uma possibilidade real de:

```text
Spring Initializr: Create a Maven Project
```

não funcionar.

Nesse caso, não perca 20 minutos tentando.

Use o procedimento offline abaixo.

---

# [OFFLINE] MÉTODO MAIS SEGURO NA PROVA

Se você possuir localmente o repositório do Rental Eventos, ele é sua base.

Você pode criar uma nova pasta e utilizar a estrutura Maven conhecida.

Por exemplo:

```text
C:\prova\
```

e:

```text
C:\repos\rental-eventos\
```

Você pode copiar a base do projeto para:

```text
C:\prova\sistema-prova\
```

Depois adaptar:

```text
artifactId
name
description
application.properties
package Java
classes
```

NÃO fique recriando um `pom.xml` inteiro de memória se você já possui um funcionando no repositório.

---

# O QUE COPIAR DO PROJETO BASE

Principalmente:

```text
pom.xml

mvnw

mvnw.cmd

.mvn/

src/main/resources/application.properties

estrutura src/main/java/
```

Também são úteis como documentação:

```text
SecurityConfig.java

JwtUtil.java

Swagger.java

DTOs existentes

Services existentes

Controllers existentes

Repositories existentes
```

---

# [NOVO] CRIANDO PROJETO MANUALMENTE SEM INITIALIZR

Suponha que você crie:

```text
C:\prova\sistema
```

Abra o terminal PowerShell.

```powershell
mkdir C:\prova\sistema

cd C:\prova\sistema
```

Crie a estrutura:

```powershell
mkdir src
mkdir src\main
mkdir src\main\java
mkdir src\main\resources
```

Depois:

```powershell
mkdir src\main\java\com
mkdir src\main\java\com\senai
mkdir src\main\java\com\senai\infoa
mkdir src\main\java\com\senai\infoa\prova
```

Ou diretamente, se funcionar no seu terminal:

```powershell
mkdir src\main\java\com\senai\infoa\prova
```

Dentro:

```text
src/main/java/com/senai/infoa/prova/
```

crie:

```text
ProvaApplication.java
```

Conteúdo:

```java
package com.senai.infoa.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProvaApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                ProvaApplication.class,
                args
        );
    }
}
```

---

# ESTRUTURA FINAL

Seu projeto deveria parecer com:

```text
sistema/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
│
├── .mvn/
│
│   └── wrapper/
│       └── maven-wrapper.properties
│
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── senai/
        │           └── infoa/
        │               └── prova/
        │                   │
        │                   ├── ProvaApplication.java
        │                   │
        │                   ├── configs/
        │                   ├── controller/
        │                   ├── dto/
        │                   ├── enuns/
        │                   ├── model/
        │                   ├── repository/
        │                   ├── security/
        │                   └── service/
        │
        └── resources/
            └── application.properties
```

---

# [POM] POM.XML BASE

Como a prova será offline, o ideal é utilizar as mesmas dependências que você já sabe que existem no projeto da aula.

Uma base compatível com seu Rental Eventos é:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

         xsi:schemaLocation="
         http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>


    <parent>

        <groupId>org.springframework.boot</groupId>

        <artifactId>
            spring-boot-starter-parent
        </artifactId>

        <version>4.1.1</version>

        <relativePath/>

    </parent>


    <groupId>com.senai.infoa</groupId>

    <artifactId>sistema-prova</artifactId>

    <version>0.0.1-SNAPSHOT</version>

    <name>sistema-prova</name>

    <description>
        Sistema desenvolvido durante a prova
    </description>


    <properties>

        <java.version>25</java.version>

    </properties>


    <dependencies>


        <!-- JPA -->

        <dependency>

            <groupId>org.springframework.boot</groupId>

            <artifactId>
                spring-boot-starter-data-jpa
            </artifactId>

        </dependency>


        <!-- WEB -->

        <dependency>

            <groupId>org.springframework.boot</groupId>

            <artifactId>
                spring-boot-starter-webmvc
            </artifactId>

        </dependency>


        <!-- VALIDATION -->

        <dependency>

            <groupId>org.springframework.boot</groupId>

            <artifactId>
                spring-boot-starter-validation
            </artifactId>

        </dependency>


        <!-- POSTGRESQL -->

        <dependency>

            <groupId>org.postgresql</groupId>

            <artifactId>postgresql</artifactId>

            <scope>runtime</scope>

        </dependency>


        <!-- SECURITY -->

        <dependency>

            <groupId>org.springframework.boot</groupId>

            <artifactId>
                spring-boot-starter-security
            </artifactId>

        </dependency>


        <!-- RESOURCE SERVER / JWT -->

        <dependency>

            <groupId>org.springframework.boot</groupId>

            <artifactId>
                spring-boot-starter-oauth2-resource-server
            </artifactId>

        </dependency>


        <!-- JJWT -->

        <dependency>

            <groupId>io.jsonwebtoken</groupId>

            <artifactId>jjwt-api</artifactId>

            <version>0.12.6</version>

        </dependency>


        <dependency>

            <groupId>io.jsonwebtoken</groupId>

            <artifactId>jjwt-impl</artifactId>

            <version>0.12.6</version>

            <scope>runtime</scope>

        </dependency>


        <dependency>

            <groupId>io.jsonwebtoken</groupId>

            <artifactId>jjwt-jackson</artifactId>

            <version>0.12.6</version>

            <scope>runtime</scope>

        </dependency>


        <!-- SWAGGER -->

        <dependency>

            <groupId>org.springdoc</groupId>

            <artifactId>
                springdoc-openapi-starter-webmvc-ui
            </artifactId>

            <version>3.1.1</version>

        </dependency>


        <!-- DEVTOOLS -->

        <dependency>

            <groupId>org.springframework.boot</groupId>

            <artifactId>
                spring-boot-devtools
            </artifactId>

            <scope>runtime</scope>

            <optional>true</optional>

        </dependency>


    </dependencies>


    <build>

        <plugins>

            <plugin>

                <groupId>org.springframework.boot</groupId>

                <artifactId>
                    spring-boot-maven-plugin
                </artifactId>

            </plugin>

        </plugins>

    </build>


</project>
```

ATENÇÃO:

Se o `pom.xml` original da documentação já está funcionando na máquina da prova:

**prefira copiar o original.**

Não há benefício em trocar dependências funcionando por dependências “mais bonitas”.

---

# [PROPERTIES] APPLICATION.PROPERTIES BASE

```properties
spring.application.name=sistema-prova

server.port=8080


# ===============================
# BANCO DE DADOS
# ===============================

spring.datasource.url=jdbc:postgresql://localhost:5433/postgres

spring.datasource.username=postgres

spring.datasource.password=aluno

spring.datasource.driver-class-name=org.postgresql.Driver


# ===============================
# JPA / HIBERNATE
# ===============================

spring.jpa.hibernate.ddl-auto=update

spring.jpa.defer-datasource-initialization=true

spring.jpa.show-sql=true


# ===============================
# SWAGGER
# ===============================

springdoc.swagger-ui.path=/swagger-ui.html

springdoc.api-docs.path=/v3/api-docs

springdoc.swagger-ui.enabled=true

springdoc.api-docs.enabled=true


# ===============================
# JWT
# ===============================

jwt.secret=rental-eventos-chave-secreta-2026-seguranca

jwt.expiration=86400000
```

Se quiser preservar exatamente o endereço usado no Rental Eventos:

```properties
springdoc.swagger-ui.path=/rental-eventos/swagger-ui.html
```

Para uma prova genérica, eu simplificaria para:

```properties
springdoc.swagger-ui.path=/swagger-ui.html
```

desde que isso não conflite com algum requisito do professor.

---

# [VSCODE] ABRINDO CORRETAMENTE NO VS CODE

No VS Code:

```text
File
↓
Open Folder
↓
selecione a pasta que CONTÉM o pom.xml
```

MUITO IMPORTANTE.

Não abra:

```text
src/
```

Não abra:

```text
src/main/java/
```

Abra:

```text
sistema-prova/
```

onde estão:

```text
pom.xml
src/
mvnw.cmd
```

---

# SE O VS CODE PERGUNTAR SOBRE IMPORTAR O PROJETO JAVA

Aceite.

Se aparecer algo como:

```text
Import Java Projects
```

ou:

```text
Maven project detected
```

permita a importação.

---

# [JAVA] CONFERINDO O JAVA

No terminal:

```powershell
java -version
```

Depois:

```powershell
javac -version
```

Idealmente, para o seu projeto atual:

```text
25
```

Exemplo:

```text
java version "25..."
```

e:

```text
javac 25...
```

Se:

```powershell
java -version
```

funciona, mas:

```powershell
javac -version
```

não funciona:

você pode ter somente runtime ou PATH incorreto.

Spring/Maven precisam do JDK.

---

# VS CODE — CONFIGURAR JDK

Pressione:

```text
CTRL + SHIFT + P
```

Procure:

```text
Java: Configure Java Runtime
```

Veja qual JDK está selecionado.

Se existe JDK 25, use o JDK 25 para este projeto.

---

# ERRO:

```text
release version 25 not supported
```

Isso geralmente significa:

```text
pom.xml pede Java 25
```

mas o Maven está rodando com Java inferior.

Verifique:

```powershell
java -version
```

e:

```powershell
.\mvnw.cmd -version
```

O segundo comando é especialmente importante.

Pode acontecer de:

```text
java -version
```

mostrar uma versão,

mas Maven utilizar outra.

---

# [MAVEN] COMANDOS ESSENCIAIS

Windows:

```powershell
.\mvnw.cmd clean
```

Compilar:

```powershell
.\mvnw.cmd compile
```

Empacotar:

```powershell
.\mvnw.cmd clean package
```

Ignorando testes:

```powershell
.\mvnw.cmd clean package -DskipTests
```

Rodar Spring:

```powershell
.\mvnw.cmd spring-boot:run
```

---

# OFFLINE

Use:

```powershell
.\mvnw.cmd -o clean package -DskipTests
```

Depois:

```powershell
.\mvnw.cmd -o spring-boot:run
```

`-o` significa:

```text
offline
```

Se Maven tentar baixar alguma coisa com `-o`, ele deverá falhar imediatamente em vez de ficar aguardando acesso externo.

Isso é excelente para testar a máquina ANTES da prova.

---

# SE A MÁQUINA TIVER MAVEN INSTALADO

Você também pode usar:

```powershell
mvn clean package -DskipTests
```

e:

```powershell
mvn spring-boot:run
```

Offline:

```powershell
mvn -o clean package -DskipTests
```

---

# LINUX OU MAC

Wrapper:

```bash
./mvnw clean package -DskipTests
```

Executar:

```bash
./mvnw spring-boot:run
```

Offline:

```bash
./mvnw -o spring-boot:run
```

Se não houver permissão:

```bash
chmod +x mvnw
```

---

# [MAVEN] COMO SABER SE O PROBLEMA É MAVEN OU SEU CÓDIGO

Primeiro:

```powershell
.\mvnw.cmd -o clean compile
```

Se aparece:

```text
BUILD SUCCESS
```

o código compila.

Se aparece:

```text
BUILD FAILURE
```

procure:

```text
[ERROR]
```

Não fique corrigindo baseado somente nas linhas vermelhas do VS Code.

O Maven é a referência mais importante.

---

# [RED] TODAS AS CLASSES FICARAM VERMELHAS NO VS CODE

Antes de alterar código, tente nesta ordem.

Salve tudo:

```text
CTRL + SHIFT + S
```

ou:

```text
File → Save All
```

Depois:

```text
CTRL + SHIFT + P
```

Procure:

```text
Maven: Reload Projects
```

Se ainda estiver vermelho:

```text
CTRL + SHIFT + P
```

Procure:

```text
Java: Clean Java Language Server Workspace
```

Confirme.

O VS Code reiniciará o servidor Java.

Se ainda estiver errado:

```text
CTRL + SHIFT + P
```

```text
Developer: Reload Window
```

Depois rode:

```powershell
.\mvnw.cmd -o clean compile
```

Se o Maven diz:

```text
BUILD SUCCESS
```

mas VS Code permanece vermelho:

provavelmente o problema está no Language Server/IDE e não no código.

---

# [POM RED] DEPENDÊNCIAS VERMELHAS NO POM

Exemplo:

```text
Missing artifact ...
```

ou:

```text
Could not resolve dependency ...
```

Possibilidades:

```text
dependência não está no cache
versão errada
pom.xml inválido
Maven não recarregou
máquina está offline e nunca baixou a dependência
```

Na prova sem internet, a pior delas é:

```text
dependência não existe em .m2
```

Nesse caso, não existe mágica.

Você precisa utilizar dependências que já estejam disponíveis localmente.

Por isso não altere versões por curiosidade.

---

# CACHE DO MAVEN

No Windows geralmente fica em:

```text
C:\Users\SEU_USUARIO\.m2\repository
```

Lá ficam dependências como:

```text
org\springframework\boot\
org\postgresql\
io\jsonwebtoken\
org\springdoc\
```

Se as versões necessárias já estiverem lá, Maven consegue trabalhar offline.

---

# [WRAPPER] ERRO DO MAVEN WRAPPER OFFLINE

Se você roda:

```powershell
.\mvnw.cmd
```

e ele tenta acessar:

```text
repo.maven.apache.org
```

isso significa que o Maven Wrapper quer baixar sua distribuição.

A solução para a prova NÃO é mudar código.

É garantir antes da prova que o wrapper já tenha sido utilizado naquela máquina ou que exista Maven instalado localmente.

Teste hoje:

```powershell
.\mvnw.cmd -version
```

com internet.

Depois desligue internet e teste novamente.

---

# [IDE] SE NÃO FOR VS CODE

O princípio é o mesmo.

Você precisa de:

```text
JDK
Maven
pom.xml
src/main/java
src/main/resources
PostgreSQL
```

Spring não depende do VS Code.

VS Code é apenas um editor/IDE.

Você pode desenvolver e executar o projeto somente pelo terminal se precisar.

---

# [INTELLIJ] INTELLIJ IDEA

Se tiver a pasta do projeto:

```text
File
↓
Open
↓
selecione a pasta ou pom.xml
```

A IDE deverá reconhecer Maven.

Configure:

```text
File
↓
Project Structure
↓
Project SDK
```

Escolha o JDK correto.

Se Maven estiver estranho:

abra a janela Maven e mande:

```text
Reload All Maven Projects
```

Se o Spring Initializr interno da IDE não funcionar offline:

não dependa dele.

Abra a base Maven local.

---

# [ECLIPSE / STS]

Use:

```text
File
↓
Import
↓
Maven
↓
Existing Maven Projects
```

Escolha a pasta onde está:

```text
pom.xml
```

Se houver problemas:

```text
botão direito no projeto
↓
Maven
↓
Update Project
```

Confira também:

```text
Project
↓
Properties
↓
Java Build Path
```

e:

```text
Installed JREs
```

---

# [NETBEANS]

Normalmente um projeto Maven contendo:

```text
pom.xml
```

é reconhecido diretamente.

Use:

```text
File
↓
Open Project
```

ou abra o projeto Maven existente.

Novamente:

a IDE é secundária.

O teste definitivo continua sendo:

```text
mvn clean package
```

ou:

```text
mvnw clean package
```

---

# [IDE DESCONHECIDA] SE A PROVA USAR UMA IDE PRÓPRIA

Não entre em pânico.

Procure saber onde está o terminal.

Se você possui uma pasta Maven completa, tente executar:

```powershell
.\mvnw.cmd -o clean package -DskipTests
```

Se compilar:

o projeto existe independentemente da IDE.

Depois:

```powershell
.\mvnw.cmd -o spring-boot:run
```

Você pode escrever arquivos até em editor simples.

O Spring não exige botão:

```text
Run Spring Boot
```

da IDE.

---

# [PACKAGE] ERRO MAIS COMUM AO COPIAR PROJETO

Você muda:

```text
rental_eventos
```

para:

```text
prova
```

mas esquece classes com:

```java
package com.senai.infoa.rental_eventos.dto;
```

enquanto sua estrutura agora é:

```text
com/senai/infoa/prova/dto
```

Resultado:

linhas vermelhas e imports quebrados.

O correto:

```java
package com.senai.infoa.prova.dto;
```

Imports também:

```java
import com.senai.infoa.prova.model.Usuario;
```

---

# A CLASSE MAIN PRECISA ESTAR NO PACOTE RAIZ

CERTO:

```text
com.senai.infoa.prova
    ProvaApplication.java

com.senai.infoa.prova.controller

com.senai.infoa.prova.service

com.senai.infoa.prova.repository

com.senai.infoa.prova.model
```

ERRADO:

```text
com.senai.infoa.prova.app
    ProvaApplication

com.senai.infoa.prova.controller
```

Nesse caso, o Spring pode não encontrar automaticamente:

```text
controller
service
repository
```

porque eles estão fora da árvore abaixo da classe principal.

---

# [IMPORT] ERRO DE IMPORT

Você vê:

```text
Usuario cannot be resolved to a type
```

Antes de criar classe nova, veja se o import está errado.

Exemplo:

```java
import com.senai.infoa.prova.models.Usuario;
```

mas sua pasta é:

```text
model
```

Logo:

```java
import com.senai.infoa.prova.model.Usuario;
```

Uma única letra diferente quebra.

---

# [IMPORT] IMPORT ERRADO ENTRE JAVAX E JAKARTA

Com Spring moderno/JPA moderno, use:

```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
```

Não copie tutorial antigo com:

```java
javax.persistence.Entity;
```

O `javax.crypto.SecretKey` é outra história e continua correto para:

```java
SecretKey
```

Não faça troca automática de todo `javax` por `jakarta`.

---

# [BANCO] BANCO NÃO CONECTA

Mensagem comum:

```text
Connection refused
```

ou:

```text
Could not open JDBC Connection
```

Confira:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/postgres
spring.datasource.username=postgres
spring.datasource.password=aluno
```

Pergunte ao terminal:

```text
PostgreSQL está iniciado?
```

Veja especialmente a porta.

PostgreSQL costuma usar:

```text
5432
```

mas seu Rental Eventos utiliza:

```text
5433
```

Então não presuma.

---

# TESTANDO PORTA NO WINDOWS

PowerShell:

```powershell
netstat -ano | findstr 5433
```

Se não aparecer nada, talvez não exista serviço ouvindo nessa porta.

Teste também:

```powershell
netstat -ano | findstr 5432
```

---

# [BANCO] PASSWORD AUTHENTICATION FAILED

Erro parecido:

```text
password authentication failed for user "postgres"
```

Significa que conseguiu encontrar PostgreSQL.

O problema provavelmente é:

```text
usuário
ou
senha
```

Confira:

```properties
spring.datasource.username=postgres
spring.datasource.password=aluno
```

---

# [BANCO] DATABASE DOES NOT EXIST

Exemplo:

```text
database "prova" does not exist
```

Se properties contém:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/prova
```

então precisa existir banco:

```text
prova
```

Se não existir, crie no PostgreSQL ou use um banco existente autorizado pela prova.

---

# [RESET] ALTEREI ENTIDADE E BANCO FICOU ESTRANHO

Isto acontece muito.

Exemplo.

Antes:

```java
private String nomeCompleto;
```

Depois:

```java
private String nome;
```

Com:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Hibernate tenta adaptar o schema, mas `update` não é um mecanismo perfeito de migração.

Pode sobrar:

```text
nome_completo
```

ou ocorrer conflito de constraints.

Se os dados da prova ainda são descartáveis, resetar o banco pode ser mais rápido.

---

# RESET MAIS SEGURO: APAGAR APENAS AS TABELAS DO PROJETO

No PostgreSQL:

```sql
DROP TABLE IF EXISTS evento_equipamentos CASCADE;

DROP TABLE IF EXISTS eventos CASCADE;

DROP TABLE IF EXISTS equipamentos CASCADE;

DROP TABLE IF EXISTS usuarios CASCADE;
```

Depois reinicie Spring.

Com:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Hibernate criará novamente as tabelas inexistentes.

---

# RESET TOTAL DO SCHEMA — SOMENTE EM BANCO DESCARTÁVEL

ATENÇÃO:

NÃO faça isso em banco compartilhado ou com dados importantes.

Em banco criado exclusivamente para a prova:

```sql
DROP SCHEMA public CASCADE;

CREATE SCHEMA public;
```

Isso apaga praticamente tudo dentro do schema `public`.

Depois reinicie Spring.

---

# ALTERNATIVA TEMPORÁRIA

Se os dados podem ser apagados, você pode temporariamente mudar:

```properties
spring.jpa.hibernate.ddl-auto=update
```

para:

```properties
spring.jpa.hibernate.ddl-auto=create
```

Inicie a aplicação UMA VEZ.

Isso recria a estrutura.

Depois pare e volte imediatamente para:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Não deixe:

```text
create
```

sem perceber.

Cada inicialização pode destruir os dados anteriores.

---

# EVITE CREATE-DROP NA PROVA

```properties
spring.jpa.hibernate.ddl-auto=create-drop
```

pode criar ao iniciar e apagar ao encerrar.

Isso pode gerar a situação:

> “Professor, estava funcionando, mas todos os registros desapareceram.”

Prefira:

```text
update
```

e resete conscientemente quando necessário.

---

# [SQL] VER SE TABELAS FORAM CRIADAS

No PostgreSQL:

```sql
SELECT table_name
FROM information_schema.tables
WHERE table_schema = 'public';
```

Se usar `psql`, também pode utilizar:

```text
\dt
```

---

# [JPA] MOSTRAR SQL

Durante a prova:

```properties
spring.jpa.show-sql=true
```

é útil.

Você verá no console coisas como:

```sql
select ...
insert into ...
update ...
```

Isso ajuda a saber se sua requisição realmente chegou ao banco.

---

# [SWAGGER] SWAGGER NÃO ABRE

Primeiro verifique se Spring realmente iniciou.

No final do console deve existir algo semelhante a:

```text
Started ProvaApplication
```

Se existe:

```text
APPLICATION FAILED TO START
```

Swagger não vai abrir porque sua aplicação não está rodando.

---

# ENDEREÇOS A TESTAR

Com configuração simples:

```text
http://localhost:8080/swagger-ui.html
```

O Springdoc pode redirecionar para algo semelhante a:

```text
http://localhost:8080/swagger-ui/index.html
```

Documentação JSON:

```text
http://localhost:8080/v3/api-docs
```

No Rental Eventos original:

```text
http://localhost:8080/rental-eventos/swagger-ui.html
```

---

# SE /v3/api-docs FUNCIONA E SWAGGER NÃO

Isso indica que OpenAPI está funcionando e provavelmente o problema é somente caminho/interface.

Teste:

```text
/swagger-ui.html
```

e:

```text
/swagger-ui/index.html
```

---

# SE /v3/api-docs DÁ 401

Security está bloqueando Swagger.

No `SecurityConfig`, deixe público:

```java
.requestMatchers(

        "/swagger-ui.html",

        "/swagger-ui/**",

        "/v3/api-docs/**"

)
.permitAll()
```

Se tiver caminho customizado:

```java
.requestMatchers(

        "/rental-eventos/swagger-ui.html",

        "/rental-eventos/swagger-ui/**",

        "/swagger-ui.html",

        "/swagger-ui/**",

        "/v3/api-docs/**"

)
.permitAll()
```

---

# SWAGGER ABRE, MAS NÃO MOSTRA ENDPOINTS

Possibilidades importantes.

Seu Controller não possui:

```java
@RestController
```

ou está fora do pacote escaneado.

Ou a aplicação principal está em pacote errado.

Ou existe erro de compilação e aquela classe não foi carregada.

Controller básico:

```java
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
}
```

---

# [TESTE] ENDPOINT DE TESTE

Se não sabe se Web/Spring estão funcionando, crie temporariamente:

```java
package com.senai.infoa.prova.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/teste")
    public String teste() {

        return "API FUNCIONANDO";
    }
}
```

Abra:

```text
http://localhost:8080/teste
```

Se Security estiver protegendo tudo, adicione temporariamente `/teste` ao `permitAll`.

Se isso funcionar:

```text
Spring
Web
Controller
porta
```

estão funcionando.

---

# [404] 404 NOT FOUND

404 geralmente significa:

```text
rota incorreta
```

Exemplo:

```java
@RequestMapping("/usuarios")
```

e:

```java
@GetMapping("/{id}")
```

Rota final:

```text
GET /usuarios/1
```

Não é:

```text
GET /1
```

---

# [405] METHOD NOT ALLOWED

Exemplo:

Controller:

```java
@PostMapping
```

mas você tenta:

```text
GET /usuarios
```

e só existe POST.

Pode retornar:

```text
405 Method Not Allowed
```

Use o verbo HTTP correto.

---

# [400] BAD REQUEST

Pode ser:

```text
JSON inválido
validação falhou
enum inválido
tipo errado
campo obrigatório ausente
data em formato errado
```

Exemplo DTO:

```java
public record UsuarioRequestDTO(

    @NotBlank
    String nome,

    @Email
    String email

) {
}
```

Este JSON:

```json
{
  "nome": "",
  "email": "abc"
}
```

deverá falhar.

---

# [500] INTERNAL SERVER ERROR

Não tente adivinhar.

Vá ao terminal.

Procure a última exceção.

Especialmente:

```text
Caused by:
```

Leia DE BAIXO PARA CIMA.

A última causa costuma ser mais útil.

---

# [POM] ERRO DE XML

Se colocou dependência e tudo que vem depois ficou vermelho:

provavelmente você quebrou XML.

Cada:

```xml
<dependency>
```

precisa de:

```xml
</dependency>
```

Cada:

```xml
<dependencies>
```

precisa:

```xml
</dependencies>
```

Cada:

```xml
<project>
```

precisa:

```xml
</project>
```

---

# DEPENDÊNCIA PRECISA FICAR DENTRO DE DEPENDENCIES

CERTO:

```xml
<dependencies>

    <dependency>
        ...
    </dependency>

</dependencies>
```

ERRADO:

```xml
</dependencies>

<dependency>
    ...
</dependency>
```

---

# [TARGET] PROJETO PARECE USAR CÓDIGO ANTIGO

Limpe:

```powershell
.\mvnw.cmd clean
```

Isso remove:

```text
target/
```

Depois:

```powershell
.\mvnw.cmd -o clean package -DskipTests
```

---

# PODE APAGAR TARGET?

Sim.

`target/` contém arquivos gerados pela compilação.

Você pode apagar:

```text
target/
```

e Maven recria.

NÃO apague:

```text
src/
pom.xml
.mvn/
```

---

# [PORT] PORTA 8080 OCUPADA

Erro:

```text
Web server failed to start.
Port 8080 was already in use.
```

Você provavelmente tem outro Spring executando.

No VS Code, pare a execução anterior.

Ou terminal:

```powershell
netstat -ano | findstr :8080
```

Aparecerá PID.

Se precisar matar:

```powershell
taskkill /PID NUMERO /F
```

Exemplo:

```powershell
taskkill /PID 12345 /F
```

Alternativamente:

```properties
server.port=8081
```

Mas lembre:

Swagger passa a usar:

```text
http://localhost:8081/
```

---

# [DATA TYPES] TIPOS DE DADOS MAIS IMPORTANTES

| Situação         | Tipo Java recomendado | Exemplo                |
| ---------------- | --------------------- | ---------------------- |
| ID               | `Long`                | `Long id`              |
| Nome/texto       | `String`              | `String nome`          |
| Número inteiro   | `Integer`             | `Integer quantidade`   |
| Inteiro grande   | `Long`                | `Long numero`          |
| Decimal simples  | `Double` / `Float`    | peso, medida           |
| Dinheiro         | `BigDecimal`          | preço, valor           |
| Verdadeiro/falso | `Boolean`             | `Boolean ativo`        |
| Somente data     | `LocalDate`           | nascimento, dataEvento |
| Data e hora      | `LocalDateTime`       | horário de reserva     |
| Lista            | `List<T>`             | eventos, produtos      |
| Categoria/status | `enum`                | `StatusReserva`        |
| E-mail           | `String` + `@Email`   | email                  |
| Senha            | `String`              | senha                  |
| CPF/telefone/CEP | `String`              | não use número         |
| Relacionamento   | Tipo da entidade      | `Usuario usuario`      |

---

# CPF NÃO DEVE SER LONG

Use:

```java
private String cpf;
```

e não:

```java
private Long cpf;
```

Porque CPF pode:

```text
ter zero no início
possuir formatação
não participa de cálculos
```

A mesma lógica vale para:

```text
telefone
CEP
CNPJ
matrícula que pode conter zeros
```

---

# [BIGDECIMAL] DINHEIRO

Prefira:

```java
private BigDecimal preco;
```

Import:

```java
import java.math.BigDecimal;
```

DTO:

```java
@NotNull
@PositiveOrZero
BigDecimal preco
```

---

# [BOOLEAN]

Entity:

```java
@Column(nullable = false)
private Boolean ativo;
```

Ou:

```java
private boolean ativo;
```

Diferença:

```text
boolean:
sempre true ou false

Boolean:
pode também ser null
```

Para DTO onde ausência do valor tem significado, `Boolean` pode ser mais útil.

---

# [LOCALDATE]

```java
private LocalDate dataNascimento;
```

Import:

```java
import java.time.LocalDate;
```

JSON:

```json
{
  "dataNascimento": "2005-10-15"
}
```

Validações possíveis:

```java
@Past
LocalDate dataNascimento
```

```java
@Future
LocalDate dataEvento
```

```java
@FutureOrPresent
LocalDate dataReserva
```

---

# [LOCALDATETIME]

```java
private LocalDateTime dataHora;
```

JSON:

```json
{
  "dataHora": "2026-09-20T19:30:00"
}
```

---

# [ENTITY] ANOTAÇÕES PRINCIPAIS DE MODEL/ENTITY

Classe:

```java
@Entity
@Table(name = "usuarios")
public class Usuario {
}
```

ID:

```java
@Id
@GeneratedValue(
    strategy = GenerationType.IDENTITY
)
private Long id;
```

Obrigatório:

```java
@Column(nullable = false)
private String nome;
```

Único:

```java
@Column(
    nullable = false,
    unique = true
)
private String email;
```

Enum:

```java
@Enumerated(EnumType.STRING)
private TipoUsuario tipo;
```

Texto grande, se necessário:

```java
@Column(columnDefinition = "TEXT")
private String descricao;
```

---

# [DTO] ANOTAÇÕES PRINCIPAIS DE DTO

Obrigatório para String:

```java
@NotBlank
String nome
```

Obrigatório para qualquer objeto:

```java
@NotNull
Integer quantidade
```

Email:

```java
@Email
String email
```

Tamanho:

```java
@Size(min = 8)
String senha
```

Positivo:

```java
@Positive
Integer quantidade
```

Zero permitido:

```java
@PositiveOrZero
Integer estoque
```

Mínimo:

```java
@Min(1)
Integer quantidade
```

Máximo:

```java
@Max(100)
Integer porcentagem
```

Data passada:

```java
@Past
LocalDate nascimento
```

Data futura:

```java
@Future
LocalDate evento
```

Pattern:

```java
@Pattern(regexp = "\\d{11}")
String cpf
```

---

# DIFERENÇA ENTRE NOTNULL, NOTEMPTY E NOTBLANK

`@NotNull`:

```text
não pode ser null
```

mas uma String poderia ser:

```text
""
```

`@NotEmpty`:

```text
não pode ser null
não pode ser vazia
```

mas poderia teoricamente conter somente espaços.

`@NotBlank`:

```text
não pode ser null
não pode ser vazia
não pode possuir apenas espaços
```

Para nomes:

```java
@NotBlank
String nome
```

é normalmente o mais conveniente.

---

# [REPOSITORY] PACOTE REPOSITORY

Estrutura básica:

```java
@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

}
```

Import:

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
```

`@Repository` é aceitável, embora interfaces que estendem `JpaRepository` normalmente já sejam reconhecidas pelo Spring Data.

Na prova, deixar explícito pode ajudar na leitura.

---

# MÉTODOS DERIVADOS

```java
Optional<Usuario>
findByEmail(String email);
```

```java
Optional<Usuario>
findByEmailIgnoreCase(String email);
```

```java
boolean
existsByEmail(String email);
```

```java
List<Produto>
findByNomeContainingIgnoreCase(
    String nome
);
```

```java
List<Reserva>
findByStatus(StatusReserva status);
```

---

# [SERVICE] PACOTE SERVICE

Anotação:

```java
@Service
public class UsuarioService {
}
```

Service deve concentrar:

```text
regras de negócio
consultas ao Repository
conversão Entity -> DTO
validações que dependem do banco
orquestração de relacionamentos
```

Injeção recomendada:

```java
private final UsuarioRepository repository;

public UsuarioService(
        UsuarioRepository repository) {

    this.repository = repository;
}
```

Evite depender de:

```java
@Autowired
private UsuarioRepository repository;
```

se você já domina construtor.

Construtor é simples, explícito e fácil de testar.

---

# [TRANSACTIONAL]

Se um método realiza várias operações de banco que precisam acontecer juntas, pode usar:

```java
@Transactional
public void criarReserva(...) {
}
```

Import:

```java
import org.springframework.transaction.annotation.Transactional;
```

Exemplo:

```text
cria pedido
reduz estoque
cria itens
```

Se uma etapa falhar, transação ajuda a desfazer o conjunto.

Para CRUD simples de prova, não precisa colocar `@Transactional` em absolutamente tudo.

---

# [CONTROLLER] PACOTE CONTROLLER

Classe:

```java
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
}
```

GET:

```java
@GetMapping
```

GET ID:

```java
@GetMapping("/{id}")
```

POST:

```java
@PostMapping
```

PUT:

```java
@PutMapping("/{id}")
```

DELETE:

```java
@DeleteMapping("/{id}")
```

Body:

```java
@RequestBody
```

Validar:

```java
@Valid
```

ID na URL:

```java
@PathVariable
```

Query:

```java
@RequestParam
```

---

# EXEMPLO PATHVARIABLE

```java
@GetMapping("/{id}")
public ResponseEntity<UsuarioResponseDTO>
buscar(
        @PathVariable Long id) {

    ...
}
```

URL:

```text
/usuarios/5
```

---

# EXEMPLO REQUESTPARAM

```java
@GetMapping("/buscar")
public ResponseEntity<?> buscar(
        @RequestParam String nome) {

    ...
}
```

URL:

```text
/usuarios/buscar?nome=nicolas
```

---

# [CONFIG] PACOTE CONFIGS

Swagger:

```java
@Configuration
public class Swagger {
}
```

Outras configurações podem utilizar:

```java
@Configuration
```

Beans:

```java
@Bean
public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
}
```

---

# [SECURITY] ANOTAÇÕES/CLASSES PRINCIPAIS

Config:

```java
@Configuration
public class SecurityConfig {
}
```

Valor do properties:

```java
@Value("${jwt.secret}")
private String secret;
```

Componente JWT:

```java
@Component
public class JwtUtil {
}
```

Password encoder:

```java
@Bean
public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
}
```

---

# [RELATIONSHIPS] ANOTAÇÕES DE RELACIONAMENTO

Muitos para um:

```java
@ManyToOne
@JoinColumn(name = "usuario_id")
private Usuario usuario;
```

Um para muitos:

```java
@OneToMany(mappedBy = "usuario")
private List<Evento> eventos;
```

Um para um:

```java
@OneToOne
@JoinColumn(name = "perfil_id")
private Perfil perfil;
```

Muitos para muitos:

```java
@ManyToMany

@JoinTable(

    name = "evento_equipamento",

    joinColumns =
        @JoinColumn(name = "evento_id"),

    inverseJoinColumns =
        @JoinColumn(name = "equipamento_id")
)
private List<Equipamento> equipamentos;
```

---

# [CASCADE] CUIDADO COM CASCADE

Não coloque automaticamente:

```java
cascade = CascadeType.ALL
```

em todo relacionamento.

Isso pode fazer:

```text
deletar pai
↓
deletar filhos
```

ou propagar operações que você não queria.

Se o minimundo não exige cascade e você está com pouco tempo:

não invente.

---

# [LAZY] FETCH

Em `ManyToOne`, pode utilizar:

```java
@ManyToOne(fetch = FetchType.LAZY)
```

Mas em prova simples isso pode causar dificuldade ao acessar entidade fora de contexto transacional.

Se você ainda não domina completamente `LAZY`, DTO e transação:

mantenha a arquitetura que você já testou previamente.

Não tente otimização avançada durante a prova.

---

# [ENUM] ENUMS

Pacote:

```text
enuns
```

No seu projeto está escrito assim.

Embora muitos projetos usem:

```text
enums
```

NÃO misture os dois.

Se a base usa:

```java
package com.senai.infoa.rental_eventos.enuns;
```

continue usando `enuns`, ou renomeie tudo de maneira consistente antes da prova.

Enum:

```java
public enum StatusReserva {

    PENDENTE,
    APROVADA,
    CANCELADA

}
```

Entity:

```java
@Enumerated(EnumType.STRING)
private StatusReserva status;
```

---

# [RECORD] DTO RECORD

```java
public record UsuarioResponseDTO(

    Long id,
    String nome,
    String email

) {
}
```

Acesso:

```java
dto.nome()
```

e NÃO:

```java
dto.getNome()
```

---

# [CLASS DTO] DTO CLASSE NORMAL

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

Não confunda.

---

# [COMPILATION] CANNOT FIND SYMBOL

Erro:

```text
cannot find symbol
```

Normalmente significa:

```text
nome errado
método não existe
import faltando
classe não existe
getter/setter faltando
record usado como classe normal
```

Exemplo:

```java
dto.getNome()
```

mas DTO é record.

Troque por:

```java
dto.nome()
```

---

# [GETTER] GETTER NÃO EXISTE

Você criou:

```java
private String nome;
```

mas esqueceu:

```java
public String getNome() {
    return nome;
}
```

Se não usa Lombok, precisa escrever getters/setters.

---

# [CONSTRUCTOR] CONSTRUTOR

JPA precisa conseguir instanciar Entity.

Crie:

```java
public Usuario() {
}
```

Não dependa somente de construtor com parâmetros.

---

# [DUPLICATE] DUPLICATE CLASS

Pode acontecer se você copiou:

```text
Usuario.java
```

para outro lugar mas manteve:

```java
public class Usuario
```

no mesmo package.

Procure duplicados.

---

# [BEAN] BEAN NÃO ENCONTRADO

Erro semelhante:

```text
Parameter 0 of constructor ... required a bean of type ...
```

Cheque anotação.

Service:

```java
@Service
```

Controller:

```java
@RestController
```

Component:

```java
@Component
```

Config:

```java
@Configuration
```

Repository:

```java
extends JpaRepository
```

Cheque também se as classes estão dentro da árvore de packages da classe principal.

---

# [CIRCULAR] CIRCULAR DEPENDENCY

Evite:

```text
UsuarioService depende EventoService
EventoService depende UsuarioService
```

Se Evento precisa buscar usuário, muitas vezes ele pode depender diretamente de:

```java
UsuarioRepository
```

em vez de gerar dependência circular entre Services.

---

# [SECURITY] LOGIN RETORNA 401 ANTES DO CONTROLLER

Confira:

```java
.requestMatchers(
    HttpMethod.POST,
    "/usuarios",
    "/auth/login"
)
.permitAll()
```

A rota precisa ser EXATAMENTE igual.

Se Controller:

```java
@RequestMapping("/autenticacao")
```

e:

```java
@PostMapping("/login")
```

rota é:

```text
/autenticacao/login
```

Logo Security precisa liberar:

```java
"/autenticacao/login"
```

---

# [SECURITY] TOKEN FUNCIONA MAS ROLE DÁ 403

Seu padrão:

```java
authorities.setAuthoritiesClaimName("tipo");

authorities.setAuthorityPrefix("ROLE_");
```

Token:

```text
tipo = ADMIN
```

vira:

```text
ROLE_ADMIN
```

Regra:

```java
.hasRole("ADMIN")
```

Se fizer:

```java
.hasRole("ROLE_ADMIN")
```

pode acabar procurando:

```text
ROLE_ROLE_ADMIN
```

Use:

```java
.hasRole("ADMIN")
```

---

# [SECURITY] SENHA

Cadastro:

```java
usuario.setSenha(
    passwordEncoder.encode(
        dto.senha()
    )
);
```

Login:

```java
passwordEncoder.matches(
    dto.getSenha(),
    usuario.getSenha()
);
```

Nunca:

```java
usuario.getSenha()
    .equals(dto.getSenha())
```

---

# [JWT] ERRO DE CHAVE

Sua propriedade:

```properties
jwt.secret=rental-eventos-chave-secreta-2026-seguranca
```

é deliberadamente longa.

Não substitua por:

```properties
jwt.secret=123
```

Uma chave HS256 curta pode provocar erro de segurança relacionado ao tamanho da chave.

---

# [JWT] JWTAuthenticationFilter VAZIO

Na arquitetura do seu Rental Eventos isso não é necessariamente erro.

Você está usando:

```java
.oauth2ResourceServer(
    oauth2 ->
        oauth2.jwt(...)
)
```

junto com:

```java
JwtDecoder
```

Então o Spring Security pode fazer a leitura e validação do Bearer Token.

Não gaste tempo implementando filtro customizado sem necessidade.

---

# [ERROR] ORDEM CORRETA PARA INVESTIGAR UM ERRO

Quando algo quebra, siga esta sequência:

```text
1. Leia o STATUS HTTP

2. Leia o terminal

3. Procure a exceção final

4. Veja se Controller recebeu a requisição

5. Veja se Service foi chamado

6. Veja se Repository executou SQL

7. Só então altere código
```

Não altere aleatoriamente:

```text
pom
security
controller
entity
application.properties
```

ao mesmo tempo.

Você perde a capacidade de saber o que corrigiu ou quebrou.

---

# [DEBUG] DEBUG ULTRARRÁPIDO

Tem dúvida se entrou no método?

Temporariamente:

```java
System.out.println(
    ">>> ENTROU NO CONTROLLER"
);
```

Depois:

```java
System.out.println(
    ">>> ENTROU NO SERVICE"
);
```

Depois:

```java
System.out.println(
    ">>> ANTES DO SAVE"
);
```

Não é elegante.

Mas numa prova de três horas pode ajudar muito.

Depois, se quiser, remova.

---

# [START] PRIMEIRO START DO PROJETO

ANTES de criar 15 entidades:

crie apenas:

```text
Main
application.properties
pom.xml
```

Execute:

```powershell
.\mvnw.cmd -o spring-boot:run
```

Se falhar:

corrija agora.

Só depois comece o sistema.

Porque é muito pior escrever:

```text
8 entidades
6 repositories
6 services
6 controllers
JWT
```

e descobrir uma hora depois que Maven nem está funcionando.

---

# [PROGRESS] ESTRATÉGIA DE CONSTRUÇÃO

Estado 1:

```text
Spring inicia.
```

Estado 2:

```text
Banco conecta.
```

Estado 3:

```text
Swagger abre.
```

Estado 4:

```text
Uma entidade simples funciona.
```

Estado 5:

```text
Usuário + login funcionam.
```

Estado 6:

```text
Demais CRUDs.
```

Estado 7:

```text
Relacionamentos.
```

Estado 8:

```text
Regras específicas.
```

Estado 9:

```text
Roles/security avançada.
```

Esse método reduz drasticamente o número de variáveis quebradas simultaneamente.

---

# [COMMIT] SE GIT ESTIVER DISPONÍVEL LOCALMENTE

Mesmo sem internet, Git funciona.

No início:

```powershell
git status
```

Depois de chegar a um ponto funcionando:

```powershell
git add .
```

```powershell
git commit -m "base funcionando"
```

Depois:

```powershell
git commit -am "crud usuario funcionando"
```

Se você destruir alguma coisa depois, poderá comparar ou restaurar localmente.

Internet não é necessária para:

```text
git status
git add
git commit
git diff
git log
```

Só seria necessária para `push` remoto.

---

# [GIT] NÃO FAÇA GIT CLEAN SEM SABER

Evite comandos destrutivos como:

```text
git clean -fd
git reset --hard
```

durante prova se não domina.

Eles podem apagar trabalho.

---

# [NAMING] PADRÃO DE NOMES

Mantenha consistência.

Entity:

```text
Usuario
```

Repository:

```text
UsuarioRepository
```

Service:

```text
UsuarioService
```

Controller:

```text
UsuarioController
```

Request:

```text
UsuarioRequestDTO
```

Response:

```text
UsuarioResponseDTO
```

Tabela:

```text
usuarios
```

Rota:

```text
/usuarios
```

Isso reduz erros mentais.

---

# [RENAME] CTRL+H COM MUITO CUIDADO

Duplicou CRUD de Equipamento para criar Produto?

Você pode trocar:

```text
Equipamento
→
Produto
```

e depois:

```text
equipamento
→
produto
```

Mas NÃO faça substituição global no projeto inteiro sem verificar.

Pode alterar:

```text
imports
rotas
outras entidades
comentários importantes
```

Melhor restringir substituição aos arquivos copiados.

---

# [ACCENTS] EVITE ACENTOS EM IDENTIFICADORES

Use:

```java
descricao
preco
endereco
```

em vez de:

```java
descrição
preço
endereço
```

Texto de mensagens pode ter acento:

```java
"Usuário não encontrado"
```

Nome de classe, variável, package e arquivo:

prefira ASCII simples.

---

# [CASE] MAIÚSCULA/MINÚSCULA

Java diferencia:

```text
Usuario
usuario
USUARIO
```

Classe:

```text
Usuario
```

Variável:

```text
usuario
```

Enum:

```text
ADMIN
```

Package:

```text
usuario
```

normalmente minúsculo.

---

# [FILES] ARQUIVO PRECISA TER NOME DA CLASSE PUBLIC

Se:

```java
public class UsuarioService
```

arquivo precisa:

```text
UsuarioService.java
```

Não:

```text
usuarioService.java
```

ou:

```text
Service.java
```

---

# [IMPORT AUTO] IMPORT AUTOMÁTICO

No VS Code:

```text
CTRL + .
```

sobre um tipo vermelho pode oferecer:

```text
Import ...
```

Mas CONFIRA o import escolhido.

Às vezes existem duas classes com mesmo nome.

Por exemplo:

```text
java.util.Date
java.sql.Date
```

Para aplicações atuais, geralmente prefira:

```text
LocalDate
LocalDateTime
```

quando adequado.

---

# [RESTART] QUANDO PRECISA REINICIAR SPRING

Se alterou:

```text
application.properties
SecurityConfig
dependência Maven
estrutura importante
```

e algo parece não aplicar:

pare e inicie novamente.

Não confie sempre no DevTools.

---

# [MAVEN RELOAD] ALTEROU POM.XML

Se adicionou ou removeu dependência:

```text
Maven: Reload Projects
```

Depois:

```powershell
.\mvnw.cmd -o clean compile
```

Se a dependência não existe no cache:

vai falhar.

Isso é melhor descobrir imediatamente.

---

# [APPLICATION] ALTEROU APPLICATION.PROPERTIES

Pare e inicie novamente.

Especialmente se mudou:

```text
porta
banco
usuário
senha
JWT secret
```

---

# [DB CHANGE] ALTEROU ENTITY

Se alterou apenas:

```text
método Java
service
controller
```

normalmente banco não precisa reset.

Se alterou:

```text
nome de coluna
tipo da coluna
relacionamento
nullable
unique
nome da tabela
```

pode ser necessário verificar ou resetar schema.

---

# [UNIQUE] ADICIONEI UNIQUE MAS EXISTEM DUPLICADOS

Imagine tabela possui:

```text
a@email.com
a@email.com
```

e você muda:

```java
@Column(unique = true)
```

Hibernate pode falhar ao criar constraint porque dados antigos violam regra.

Solução em ambiente descartável:

corrigir/apagar duplicados ou resetar tabela.

---

# [NULLABLE] ADICIONEI CAMPO OBRIGATÓRIO

Tabela já tem 20 registros.

Você adiciona:

```java
@Column(nullable = false)
private String cpf;
```

Registros antigos possuem:

```text
cpf = null
```

Banco pode não conseguir aplicar `NOT NULL`.

Durante prova, se dados são descartáveis:

resetar tabela pode ser mais rápido.

---

# [FOREIGN KEY] ADICIONEI RELACIONAMENTO

Você mudou:

```java
private Long usuarioId;
```

para:

```java
@ManyToOne
@JoinColumn(name = "usuario_id")
private Usuario usuario;
```

Schema antigo pode ficar inconsistente.

Se ainda está no começo:

apagar/recriar tabela costuma ser menos arriscado que tentar migrar manualmente.

---

# [JSON] EXEMPLO DE RELACIONAMENTO

Request:

```java
public record EventoRequestDTO(

    @NotBlank
    String nome,

    @NotNull
    Long usuarioId

) {
}
```

JSON:

```json
{
  "nome": "Formatura",
  "usuarioId": 1
}
```

Service:

```java
Usuario usuario =
        usuarioRepository
                .findById(
                    dto.usuarioId()
                )
                .orElseThrow();

Evento evento =
        new Evento();

evento.setNome(
    dto.nome()
);

evento.setUsuario(
    usuario
);
```

---

# [ERROR] TRANSIENT OBJECT

Erro semelhante:

```text
object references an unsaved transient instance
```

Geralmente você vinculou uma entidade nova que nunca foi salva.

Exemplo problemático:

```java
Usuario usuario = new Usuario();

usuario.setId(
    dto.usuarioId()
);

evento.setUsuario(usuario);
```

Prefira:

```java
Usuario usuario =
        usuarioRepository
            .findById(
                dto.usuarioId()
            )
            .orElseThrow(...);
```

---

# [ERROR] STACKOVERFLOW

Se possui:

```text
Usuario
  ↓
eventos

Evento
  ↓
usuario
```

e retorna Entity diretamente, Jackson pode fazer:

```text
usuario
eventos
usuario
eventos
usuario
eventos...
```

Use DTO.

É a solução mais previsível em prova.

---

# [ERROR] LAZYINITIALIZATIONEXCEPTION

Pode ocorrer ao acessar relacionamento `LAZY` depois que sessão/transação acabou.

Em CRUD de prova, normalmente dá para evitar complicação retornando DTO dentro do Service e buscando somente os dados necessários.

Se usar relacionamento e DTO:

```java
return new EventoResponseDTO(

    evento.getId(),

    evento.getNome(),

    evento.getUsuario().getId()

);
```

faça conversão enquanto está em contexto adequado.

---

# [ERROR] COLUMN DOES NOT EXIST

Provavelmente Entity e banco estão diferentes.

Exemplo:

Entity pede:

```text
quantidade_minima
```

mas banco antigo possui:

```text
qtd_min
```

Se banco é descartável:

reset.

Se não é descartável:

faça alteração SQL conscientemente.

---

# [ERROR] TABLE DOES NOT EXIST

Cheque:

```text
@Entity
@Table(...)
```

Cheque:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Cheque conexão correta.

Talvez Hibernate esteja conectado em outro banco.

Exemplo:

você olha banco:

```text
prova
```

mas aplicação conecta em:

```text
postgres
```

---

# [ERROR] ID NÃO É GERADO

Confira:

```java
@Id

@GeneratedValue(
    strategy = GenerationType.IDENTITY
)

private Long id;
```

Não envie ID manualmente no POST, salvo se minimundo/professor exigir.

---

# [ERROR] ID NULL NA RESPOSTA

Você pode estar convertendo para DTO ANTES de salvar.

ERRADO:

```java
Produto produto =
    new Produto();

ProdutoResponseDTO response =
    toDTO(produto);

repository.save(produto);

return response;
```

CERTO:

```java
Produto salvo =
    repository.save(produto);

return toDTO(salvo);
```

---

# [ERROR] UPDATE CRIA NOVO REGISTRO

No update:

busque primeiro:

```java
Produto produto =
    repository
        .findById(id)
        .orElseThrow(...);
```

Depois altere:

```java
produto.setNome(dto.nome());
```

Depois:

```java
repository.save(produto);
```

Não crie um novo objeto sem controlar ID.

---

# [ERROR] DELETE RETORNA 500

Pode haver Foreign Key.

Exemplo:

```text
Usuario
↓
Evento
```

Você tenta apagar Usuario que ainda possui Eventos.

O banco impede para proteger integridade.

Leia o minimundo.

Talvez a regra correta seja:

```text
não permitir exclusão
```

ou:

```text
apagar dependências
```

Não coloque cascade aleatoriamente somente para “fazer passar”.

---

# [LOG] SHOW SQL

Com:

```properties
spring.jpa.show-sql=true
```

POST esperado deve mostrar algo parecido:

```sql
insert into usuarios (...)
values (...)
```

PUT:

```sql
update usuarios
set ...
where id=?
```

DELETE:

```sql
delete from usuarios
where id=?
```

Isso é ótimo para confirmar o fluxo.

---

# [SWAGGER] TESTE DE AUTENTICAÇÃO COMPLETO

Primeiro:

```text
POST /usuarios
```

Body:

```json
{
  "nome": "Administrador",
  "email": "admin@email.com",
  "senha": "12345678",
  "tipo": "ADMIN"
}
```

Depois:

```text
POST /auth/login
```

Body:

```json
{
  "email": "admin@email.com",
  "senha": "12345678"
}
```

Resposta:

```json
{
  "token": "eyJ..."
}
```

Clique:

```text
Authorize
```

Cole token.

Depois teste rota protegida.

---

# [401 VS 403]

Memorize:

```text
401
=
você não está autenticado corretamente
```

Exemplos:

```text
token ausente
token inválido
token expirado
login bloqueado pelo Security
```

Enquanto:

```text
403
=
Spring sabe quem você é,
mas sua role não possui permissão
```

Exemplo:

```text
USUARIO tentando rota ADMIN
```

---

# [TYPES QUICK REFERENCE] MODELO DE ENTITY GENÉRICA

```java
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(
        strategy =
            GenerationType.IDENTITY
    )
    private Long id;

    @Column(
        nullable = false
    )
    private String nome;

    @Column(
        nullable = false,
        unique = true
    )
    private String codigo;

    @Column(
        nullable = false
    )
    private BigDecimal preco;

    @Column(
        nullable = false
    )
    private Integer estoque;

    @Column(
        nullable = false
    )
    private Boolean ativo;

    @Enumerated(
        EnumType.STRING
    )
    private CategoriaProduto categoria;

    private LocalDate dataCadastro;

    public Produto() {
    }

    // getters e setters
}
```

---

# REQUEST GENÉRICO

```java
public record ProdutoRequestDTO(

    @NotBlank
    String nome,

    @NotBlank
    String codigo,

    @NotNull
    @PositiveOrZero
    BigDecimal preco,

    @NotNull
    @PositiveOrZero
    Integer estoque,

    @NotNull
    Boolean ativo,

    @NotNull
    CategoriaProduto categoria

) {
}
```

---

# RESPONSE GENÉRICO

```java
public record ProdutoResponseDTO(

    Long id,

    String nome,

    String codigo,

    BigDecimal preco,

    Integer estoque,

    Boolean ativo,

    CategoriaProduto categoria,

    LocalDate dataCadastro

) {
}
```

---

# [CHECK] QUANDO UM ARQUIVO FICA VERMELHO

Não reescreva imediatamente.

Faça mentalmente:

```text
Package está certo?

Import está certo?

Classe existe?

Nome do arquivo está certo?

Getter existe?

DTO é record ou classe?

Maven reconheceu dependências?

Java correto está selecionado?

Arquivo foi salvo?

Outro arquivo possui erro que causa efeito cascata?
```

Muitas vezes 50 linhas vermelhas vêm de UM import quebrado.

---

# [CASCADE ERRORS] UM ERRO PODE GERAR 30 ERROS

Exemplo:

Você apaga:

```java
public class Usuario {
```

sem querer.

Agora:

```text
UsuarioRepository vermelho
UsuarioService vermelho
UsuarioController vermelho
Evento vermelho
Reserva vermelho
```

Não existem cinco problemas.

Existe um:

```text
Usuario.java não compila.
```

Por isso comece corrigindo a primeira classe-base indicada pelo compilador.

---

# [MAVEN ERRORS] LEIA O PRIMEIRO ERRO REAL

Maven pode mostrar:

```text
50 compilation errors
```

Mas frequentemente erro número 1 causa os outros 49.

Procure o primeiro:

```text
[ERROR] ... Usuario.java:[linha,coluna]
```

Corrija.

Rode novamente.

---

# [BUILD] COMANDO DE VERIFICAÇÃO DURANTE A PROVA

Depois de cada bloco grande:

```powershell
.\mvnw.cmd -o clean compile
```

ou, se clean estiver demorando:

```powershell
.\mvnw.cmd -o compile
```

Antes de finalizar:

```powershell
.\mvnw.cmd -o clean package -DskipTests
```

Se aparecer:

```text
BUILD SUCCESS
```

é um excelente sinal.

---

# [PROVA] NÃO FAÇA UPGRADE

Durante a prova:

não troque:

```text
Spring Boot 4.1.1
→
outra versão
```

Não troque:

```text
JJWT 0.12.6
```

Não troque:

```text
Springdoc 3.1.1
```

Não atualize Java sem necessidade.

Não tente “corrigir” dependência que já funciona.

Ambiente offline favorece estabilidade, não atualização.

---

# [PROVA] NÃO USE CÓDIGO QUE VOCÊ NÃO CONSEGUE DEPURAR

Exemplo:

Você encontra na documentação um:

```java
GenericAbstractService<
    T,
    ID,
    REQUEST,
    RESPONSE
>
```

super sofisticado.

Mas você não entende.

Não use.

Um CRUD repetitivo de 80 linhas que você entende é melhor numa prova que abstração de 20 linhas impossível de corrigir.

---

# [PROVA] NÃO SE PREOCUPE COM REPETIÇÃO

Em projeto empresarial:

duplicação pode ser problema.

Em uma prova de três horas:

```text
funcionando > elegante
```

Desde que a arquitetura pedida esteja presente.

---

# [PROVA] FAÇA O SIMPLES PRIMEIRO

Se existe:

```text
Usuario
Produto
Pedido
ItemPedido
```

não comece pelo:

```text
ItemPedido
```

Comece:

```text
Usuario
```

Depois:

```text
Produto
```

Só então:

```text
Pedido
```

e finalmente:

```text
ItemPedido
```

Relacionamentos dependem das entidades simples.

---

# [PROVA] NÃO IMPLEMENTE TUDO ANTES DE TESTAR

Faça:

```text
Usuario Entity
Usuario Repository
Usuario Service
Usuario Controller
```

Teste.

Depois próxima entidade.

Melhor do que escrever 25 arquivos antes do primeiro start.

---

# [PROVA] DEIXE AS REGRAS DIFÍCEIS POR ÚLTIMO

Primeiro consiga:

```text
salvar
listar
buscar
editar
excluir
```

Depois:

```text
cálculo
filtro complexo
role
regra de datas
regra de estoque
```

A menos que alguma regra seja essencial para modelar o banco.

---

# [PROVA] SE FALTAM 20 MINUTOS

PARE.

Não crie nova entidade complexa.

Faça:

```text
compilação
Swagger
POST
GET
login
token
principais relacionamentos
```

Corrija erros.

Uma funcionalidade parcialmente construída pode quebrar aplicação inteira.

---

# [FINAL] CHECKLIST OPERACIONAL

Antes da prova:

```text
[ ] java -version funciona

[ ] javac -version funciona

[ ] Maven funciona offline

[ ] Wrapper funciona offline

[ ] dependências estão no cache

[ ] PostgreSQL está funcionando

[ ] você sabe a porta do PostgreSQL

[ ] sabe usuário/senha

[ ] projeto Rental Eventos abre

[ ] projeto Rental Eventos compila offline

[ ] Spring inicia offline

[ ] Swagger abre

[ ] login funciona

[ ] JWT funciona
```

Na prova, antes de programar:

```text
[ ] abrir pasta raiz do projeto

[ ] conferir pom.xml

[ ] conferir Java

[ ] conferir application.properties

[ ] iniciar aplicação uma vez

[ ] confirmar conexão com banco

[ ] confirmar Swagger

[ ] só depois modelar minimundo
```

Durante:

```text
[ ] construir uma entidade de cada vez

[ ] compilar frequentemente

[ ] testar frequentemente

[ ] não trocar dependências funcionando

[ ] não usar cascade sem entender

[ ] DTO não devolve senha

[ ] enum usa STRING

[ ] relacionamentos usam IDs no RequestDTO

[ ] regra de negócio fica no Service

[ ] Repository cuida do banco

[ ] Controller cuida do HTTP
```

Antes de entregar:

```text
[ ] mvnw -o clean package -DskipTests

[ ] BUILD SUCCESS

[ ] Spring inicia

[ ] Swagger abre

[ ] POST principal funciona

[ ] GET principal funciona

[ ] atualização funciona

[ ] relacionamento funciona

[ ] login funciona

[ ] token funciona

[ ] nenhuma senha aparece no response

[ ] nenhum endpoint principal retorna 500
```

---

# [EMERGÊNCIA] SE VOCÊ TRAVAR COMPLETAMENTE

Volte ao mínimo.

Deixe somente:

```text
pom.xml
application.properties
Application.java
uma Entity
um Repository
um Service
um Controller
```

Compile.

Faça funcionar.

Depois reintroduza as outras coisas uma por uma.

Nunca tente corrigir um projeto inteiro quebrado modificando 15 arquivos simultaneamente.

---

# [EMERGÊNCIA] PROJETO NÃO COMPILA E TEM POUCO TEMPO

Execute:

```powershell
.\mvnw.cmd -o clean compile
```

Leia o PRIMEIRO erro real.

Corrija.

Repita.

```powershell
.\mvnw.cmd -o compile
```

Corrija.

Repita.

É quase sempre mais eficiente que olhar centenas de sublinhados vermelhos no editor.

---

# [EMERGÊNCIA] SPRING COMPILA MAS NÃO SOBE

Então o problema provavelmente é runtime/configuração.

Procure:

```text
APPLICATION FAILED TO START
```

Depois a última:

```text
Caused by:
```

Se menciona:

```text
DataSource
PostgreSQL
Connection
```

banco.

Se menciona:

```text
Bean
```

injeção/configuração.

Se menciona:

```text
Port 8080
```

porta.

Se menciona:

```text
JwtDecoder
secret key
```

JWT.

Se menciona:

```text
Repository
Not a managed type
```

Entity/JPA.

---

# [EMERGÊNCIA] TUDO FUNCIONAVA E PAROU APÓS SUA ÚLTIMA ALTERAÇÃO

NÃO procure 30 hipóteses.

Pergunte:

```text
"O que eu alterei desde a última vez que funcionou?"
```

Se alterou relacionamento:

investigue relacionamento.

Se alterou Security:

investigue Security.

Se alterou `pom.xml`:

investigue Maven.

Se alterou Entity:

investigue banco/schema.

Isso parece óbvio, mas durante prova com pressão evita muito desperdício de tempo.

---

# FRASES PARA DECORAR

```text
Linha vermelha não significa automaticamente dependência faltando.

BUILD SUCCESS vale mais que a cor do VS Code.

401 = autenticação.

403 = autorização.

404 = rota/recurso.

400 = entrada inválida.

500 = olhar terminal.

Entity = banco.

DTO = entrada/saída.

Repository = persistência.

Service = regra.

Controller = HTTP.

Security = acesso.

@ManyToOne normalmente fica no lado que possui a FK.

Record usa nome() e não getNome().

Senha salva com encode.

Senha conferida com matches.

Enum no banco: EnumType.STRING.

Alterei Entity e banco ficou estranho:
ver schema/resetar tabela.

Alterei pom:
reload Maven.

Alterei application.properties:
reiniciar Spring.

Tudo vermelho:
compilar no terminal antes de entrar em pânico.
```

---

# COMANDO MAIS IMPORTANTE PARA TESTAR SUA PREPARAÇÃO

Com a internet realmente desligada:

```powershell
.\mvnw.cmd -o clean package -DskipTests
```

Se isso funciona e termina com:

```text
BUILD SUCCESS
```

depois rode:

```powershell
.\mvnw.cmd -o spring-boot:run
```

Se Spring inicia, PostgreSQL conecta e Swagger abre, você eliminou antecipadamente uma das maiores fontes de desastre possível numa prova offline.
