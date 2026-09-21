ERROS AO RODAR O SPRING BOOT — COMO LER "CAUSED BY", STACK TRACE E DESCOBRIR O ERRO REAL

«Este guia é para aquele momento em que você clica em Run, o terminal fica cheio de texto vermelho e aparecem vários:

Caused by:

um embaixo do outro.

O objetivo não é entender cada linha do terminal.
O objetivo é descobrir qual é a causa real do problema o mais rápido possível.»

---

SUMÁRIO

1. "Primeira diferença: erro de compilação x erro de execução" (#1-primeira-diferença-erro-de-compilação-x-erro-de-execução)
2. "O que é Stack Trace" (#2-o-que-é-stack-trace)
3. "O que significa "Caused by"" (#3-o-que-significa-caused-by)
4. "Qual "Caused by" devo ler" (#4-qual-caused-by-devo-ler)
5. "Método rápido para ler o terminal" (#5-método-rápido-para-ler-o-terminal)
6. ""APPLICATION FAILED TO START"" (#6-application-failed-to-start)
7. ""BeanCreationException"" (#7-beancreationexception)
8. ""UnsatisfiedDependencyException"" (#8-unsatisfieddependencyexception)
9. ""NoSuchBeanDefinitionException"" (#9-nosuchbeandefinitionexception)
10. ""Not a managed type"" (#10-not-a-managed-type)
11. ""Entity requires an Id"" (#11-entity-requires-an-id)
12. "Erro no Repository" (#12-erro-no-repository)
13. "Erro em Query Method" (#13-erro-em-query-method)
14. "Erro de banco / "Connection refused"" (#14-erro-de-banco--connection-refused)
15. ""password authentication failed"" (#15-password-authentication-failed)
16. ""database does not exist"" (#16-database-does-not-exist)
17. "Erro de tabela" (#17-erro-de-tabela)
18. "Erro de coluna" (#18-erro-de-coluna)
19. ""ConstraintViolationException"" (#19-constraintviolationexception)
20. ""DataIntegrityViolationException"" (#20-dataintegrityviolationexception)
21. ""TransientPropertyValueException"" (#21-transientpropertyvalueexception)
22. ""detached entity passed to persist"" (#22-detached-entity-passed-to-persist)
23. ""LazyInitializationException"" (#23-lazyinitializationexception)
24. ""StackOverflowError"" (#24-stackoverflowerror)
25. "Erro de relacionamento / "mappedBy"" (#25-erro-de-relacionamento--mappedby)
26. ""Could not determine recommended JdbcType"" (#26-could-not-determine-recommended-jdbctype)
27. ""Failed to configure a DataSource"" (#27-failed-to-configure-a-datasource)
28. "Porta 8080 ocupada" (#28-porta-8080-ocupada)
29. "Erro no JWT / chave" (#29-erro-no-jwt--chave)
30. "Erro no "SecurityConfig"" (#30-erro-no-securityconfig)
31. "Circular dependency" (#31-circular-dependency)
32. "Erro de construtor" (#32-erro-de-construtor)
33. ""NullPointerException"" (#33-nullpointerexception)
34. "Erro de JSON" (#34-erro-de-json)
35. "Erro de enum" (#35-erro-de-enum)
36. "Erro de data" (#36-erro-de-data)
37. "Erro verdadeiro de compilação" (#37-erro-verdadeiro-de-compilação)
38. ""cannot find symbol"" (#38-cannot-find-symbol)
39. ""package ... does not exist"" (#39-package--does-not-exist)
40. ""incompatible types"" (#40-incompatible-types)
41. ""method cannot be applied"" (#41-method-cannot-be-applied)
42. ""constructor ... cannot be applied"" (#42-constructor--cannot-be-applied)
43. "Como encontrar o arquivo e a linha" (#43-como-encontrar-o-arquivo-e-a-linha)
44. "Como saber se o erro é seu ou do framework" (#44-como-saber-se-o-erro-é-seu-ou-do-framework)
45. "Como usar "System.out.println"" (#45-como-usar-systemoutprintln)
46. "Fluxo de diagnóstico de emergência" (#46-fluxo-de-diagnóstico-de-emergência)
47. "Tabela "Caused by" → significado" (#47-tabela-caused-by--significado)
48. "Exemplos completos de leitura" (#48-exemplos-completos-de-leitura)
49. "O que NÃO fazer" (#49-o-que-não-fazer)
50. "Cola final" (#50-cola-final)

---

1. PRIMEIRA DIFERENÇA: ERRO DE COMPILAÇÃO X ERRO DE EXECUÇÃO

Essa diferença é fundamental.

ERRO DE COMPILAÇÃO

Acontece antes da aplicação conseguir iniciar.

Exemplos:

cannot find symbol

package ... does not exist

incompatible types

method ... cannot be applied

Normalmente Maven termina com:

COMPILATION ERROR

e:

BUILD FAILURE

---

ERRO DE EXECUÇÃO / INICIALIZAÇÃO

O Java conseguiu compilar, mas Spring tentou subir e alguma coisa deu errado.

É aqui que geralmente aparecem vários:

Caused by:

Exemplos:

banco não conecta
Bean não existe
Entity está errada
Repository está errado
SecurityConfig está errado
porta ocupada
JWT inválido
relacionamento JPA incorreto

---

REGRA PARA DECORAR

cannot find symbol
=
compilação

Caused by:
=
normalmente execução/inicialização

---

2. O QUE É STACK TRACE

Stack Trace é o histórico de chamadas que levou ao erro.

Exemplo:

org.springframework.beans.factory.BeanCreationException
    at ...
    at ...
    at ...

Caused by:
org.hibernate.MappingException
    at ...
    at ...

Caused by:
java.lang.IllegalArgumentException
    ...

Não significa que existem necessariamente três problemas diferentes.

Pode ser:

PROBLEMA REAL
↓
causou problema no Hibernate
↓
que causou problema ao criar Bean
↓
que fez Spring não iniciar

---

3. O QUE SIGNIFICA "Caused by"

Literalmente:

Causado por

Exemplo:

BeanCreationException

foi causada por:

MappingException

que foi causada por:

Unknown mappedBy

A sequência pode ser:

APPLICATION FAILED
        ↓
Bean não foi criado
        ↓
Repository não foi criado
        ↓
Entity está errada
        ↓
mappedBy não existe

O erro mais útil geralmente está mais embaixo.

---

4. QUAL "Caused by" DEVO LER

Quando aparecem:

Caused by:
...
Caused by:
...
Caused by:
...
Caused by:
...

comece pelo último "Caused by" mais específico.

Exemplo:

Caused by: BeanCreationException

depois:

Caused by: JdbcConnectionException

depois:

Caused by: org.postgresql.util.PSQLException

depois:

Caused by: java.net.ConnectException: Connection refused

O problema real é:

Connection refused

Ou seja:

PostgreSQL não está acessível

Não é necessário estudar "BeanCreationException".

---

5. MÉTODO RÁPIDO PARA LER O TERMINAL

Quando o terminal explodir em vermelho:

PASSO 1

Procure:

APPLICATION FAILED TO START

ou:

BUILD FAILURE

---

PASSO 2

Se for runtime, vá descendo e procure:

Caused by:

---

PASSO 3

Continue descendo até o último "Caused by" importante.

---

PASSO 4

Procure palavras reconhecíveis.

Exemplo:

PostgreSQL

password

Connection refused

Not a managed type

mappedBy

Bean

JWT

Port 8080

column

table

---

PASSO 5

Só então altere código.

---

6. "APPLICATION FAILED TO START"

Mensagem:

***************************
APPLICATION FAILED TO START
***************************

Isso apenas diz:

Spring não conseguiu iniciar

Não é a causa.

Continue procurando mais abaixo/acima pela causa específica.

---

7. "BeanCreationException"

Exemplo:

BeanCreationException:
Error creating bean with name 'usuarioRepository'

Significa:

Spring tentou criar um componente
e falhou.

A causa pode ser:

Entity errada
Repository errado
Query Method errado
banco
SecurityConfig

Não pare nessa linha.

Continue até outro:

Caused by:

---

8. "UnsatisfiedDependencyException"

Exemplo:

UnsatisfiedDependencyException:
Error creating bean with name 'usuarioController'

Isso normalmente significa:

Controller precisa do Service
↓
Service não conseguiu ser criado

ou:

Service precisa do Repository
↓
Repository não conseguiu ser criado

Leia a cadeia.

Exemplo:

UsuarioController
↓
UsuarioService
↓
UsuarioRepository
↓
Entity Usuario com problema

Não significa necessariamente que o Controller está errado.

---

9. "NoSuchBeanDefinitionException"

Exemplo:

No qualifying bean of type
'PasswordEncoder' available

Significa:

Spring precisava de um Bean
PasswordEncoder
mas não encontrou.

Cheque:

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

---

10. "Not a managed type"

Exemplo:

Not a managed type:
class com.senai.infoa.prova.model.Usuario

Cheque:

@Entity

na classe.

Exemplo correto:

@Entity
@Table(name = "usuarios")
public class Usuario {
}

Cheque também:

package
Component Scan
classe main

---

11. "Entity requires an Id"

Algo parecido com:

Entity 'Usuario' has no identifier

Significa que Entity não tem:

@Id

Faça:

@Id
@GeneratedValue(
    strategy = GenerationType.IDENTITY
)
private Long id;

---

12. ERRO NO REPOSITORY

Exemplo:

public interface UsuarioRepository
    extends JpaRepository<Usuario, String>

Mas Entity:

@Id
private Long id;

Está inconsistente.

Correto:

JpaRepository<Usuario, Long>

---

13. ERRO EM QUERY METHOD

Você escreve:

findByNomeCompleto(...)

mas Entity não tem:

nomeCompleto

Pode aparecer:

No property 'nomeCompleto' found for type 'Usuario'

ou:

Could not create query for method...

Então compare o método Repository com nomes reais da Entity.

---

14. ERRO DE BANCO / "Connection refused"

Final da cadeia:

Caused by:
java.net.ConnectException:
Connection refused

ou:

Connection to localhost:5433 refused

Significa:

PostgreSQL não está escutando nessa porta

Cheque:

spring.datasource.url

e:

netstat -ano | findstr 5433

Também teste:

netstat -ano | findstr 5432

---

15. "password authentication failed"

Exemplo:

Caused by:
org.postgresql.util.PSQLException:
FATAL: password authentication failed for user "postgres"

O banco foi encontrado.

O problema é:

usuário/senha

Cheque:

spring.datasource.username=postgres
spring.datasource.password=aluno

---

16. "database does not exist"

Exemplo:

FATAL: database "prova" does not exist

URL:

jdbc:postgresql://localhost:5432/prova

mas banco "prova" não existe.

Crie o banco ou altere a URL.

---

17. ERRO DE TABELA

Exemplo:

relation "usuarios" does not exist

Significa:

tabela não existe

Cheque:

@Entity

@Table(name = "usuarios")

e:

spring.jpa.hibernate.ddl-auto=update

---

18. ERRO DE COLUNA

Exemplo:

column usuario0_.nome_completo does not exist

Entity espera uma coluna que banco não possui.

Pode acontecer depois de renomear campo.

Se banco de prova for descartável:

DROP TABLE usuarios CASCADE;

reinicie Spring.

---

19. "ConstraintViolationException"

Pode significar violação de regra do banco.

Exemplo:

null value in column "nome"
violates not-null constraint

Você tentou salvar:

nome = null

Cheque DTO e Entity.

---

20. "DataIntegrityViolationException"

É uma exceção mais geral de integridade.

Pode envolver:

UNIQUE
NOT NULL
FOREIGN KEY

Continue lendo "Caused by".

Exemplo:

duplicate key value violates unique constraint

Problema:

valor duplicado

---

21. "TransientPropertyValueException"

Exemplo:

object references an unsaved transient instance

Você relacionou uma Entity salva com objeto ainda não persistido.

Exemplo ruim:

Usuario usuario = new Usuario();
usuario.setId(1L);

evento.setUsuario(usuario);

Melhor:

Usuario usuario =
    usuarioRepository
        .findById(1L)
        .orElseThrow();

evento.setUsuario(usuario);

---

22. "detached entity passed to persist"

Exemplo:

detached entity passed to persist: Usuario

Pode acontecer porque você criou/reutilizou uma Entity com ID de maneira incorreta.

Novamente:

se relacionamento aponta para registro existente,
busque esse registro pelo Repository.

---

23. "LazyInitializationException"

Exemplo:

failed to lazily initialize a collection

ou:

could not initialize proxy - no Session

Uma relação LAZY foi acessada depois que contexto de persistência terminou.

Durante prova:

prefira ResponseDTO

e monte o DTO no Service enquanto possui acesso adequado aos dados.

---

24. "StackOverflowError"

Exemplo:

java.lang.StackOverflowError

Se envolve Entities relacionadas, suspeite:

Usuario
→ eventos
→ usuario
→ eventos
→ usuario...

Solução:

não retornar Entity bidirecional diretamente

Use DTO.

---

25. ERRO DE RELACIONAMENTO / "mappedBy"

Exemplo:

Collection 'Usuario.eventos'
is 'mappedBy' a property named 'usuario_id'
which does not exist

Se Evento possui:

private Usuario usuario;

use:

@OneToMany(mappedBy = "usuario")

Não:

mappedBy = "usuario_id"

---

26. "Could not determine recommended JdbcType"

Pode acontecer quando JPA encontra atributo que não sabe mapear diretamente.

Exemplo:

private OutraClasse coisa;

sem relacionamento.

Talvez deveria ser:

@ManyToOne
private OutraClasse coisa;

ou tipo simples/embeddable adequado.

---

27. "Failed to configure a DataSource"

Exemplo:

Failed to configure a DataSource

Pode indicar:

URL ausente
driver ausente
configuração incompleta

Cheque:

spring.datasource.url
spring.datasource.username
spring.datasource.password
spring.datasource.driver-class-name

e PostgreSQL no "pom.xml".

---

28. PORTA 8080 OCUPADA

Mensagem:

Web server failed to start.
Port 8080 was already in use.

Cheque:

netstat -ano | findstr :8080

Depois:

taskkill /PID NUMERO /F

---

29. ERRO NO JWT / CHAVE

Pode aparecer algo como:

WeakKeyException

ou mensagem falando que chave é curta para:

HS256

Use secret suficientemente grande.

Se aparece:

signature does not match

pode ser:

token gerado com um segredo
e validado com outro

---

30. ERRO NO "SecurityConfig"

Se Spring falha criando:

securityFilterChain

continue lendo a causa.

Pode ser:

JwtDecoder não existe
PasswordEncoder não existe
configuração inválida
Bean duplicado

---

31. CIRCULAR DEPENDENCY

Exemplo:

UsuarioService
↓
EventoService
↓
UsuarioService

Spring pode indicar ciclo.

Arquitetura problemática:

class UsuarioService {
    EventoService eventoService;
}

e:

class EventoService {
    UsuarioService usuarioService;
}

Tente quebrar dependência.

Às vezes Service precisa apenas do Repository correspondente.

---

32. ERRO DE CONSTRUTOR

Exemplo:

No default constructor for entity

Entity precisa de construtor sem argumentos.

public Usuario() {
}

---

33. "NullPointerException"

Exemplo:

java.lang.NullPointerException:
Cannot invoke "Usuario.getNome()"
because "usuario" is null

Leia a própria mensagem.

Ela frequentemente informa:

qual variável estava null

Exemplo:

Usuario usuario = null;

usuario.getNome();

---

34. ERRO DE JSON

Pode aparecer:

HttpMessageNotReadableException

ou:

JSON parse error

Problemas comuns:

vírgula errada
campo com tipo errado
enum errado
data errada
JSON mal formado

---

35. ERRO DE ENUM

Exemplo:

Cannot deserialize value of type TipoUsuario
from String "admin"

Enum:

ADMIN
USUARIO

Mande:

{
  "tipo": "ADMIN"
}

---

36. ERRO DE DATA

Exemplo:

Cannot deserialize value of type LocalDate

Para:

LocalDate

use:

2026-09-21

Para:

LocalDateTime

use:

2026-09-21T14:30:00

---

37. ERRO VERDADEIRO DE COMPILAÇÃO

Se terminal mostra:

COMPILATION ERROR

e:

BUILD FAILURE

não procure banco ou Postman.

O problema está antes da aplicação iniciar.

Procure linhas como:

[ERROR] arquivo.java:[linha,coluna]

---

38. "cannot find symbol"

Exemplo:

[ERROR] UsuarioService.java:[35,28]
cannot find symbol
symbol: method getNome()

Vá para:

UsuarioService.java
linha 35

Cheque se:

método existe
nome está certo
objeto é record
import está certo

---

39. "package ... does not exist"

Exemplo:

package com.senai.infoa.prova.models does not exist

Mas package verdadeiro:

model

Corrija import.

---

40. "incompatible types"

Exemplo:

incompatible types:
java.lang.Integer cannot be converted to java.lang.Long

Você está passando tipo errado.

Exemplo:

Long id

mas variável:

Integer id

---

41. "method cannot be applied"

Exemplo:

method gerarToken cannot be applied to given types

Método espera:

gerarToken(String email, String tipo)

mas você chamou:

gerarToken(email)

Falta argumento.

---

42. "constructor ... cannot be applied"

Exemplo:

DTO:

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email
) {}

Você faz:

new UsuarioResponseDTO(
    usuario.getId(),
    usuario.getNome()
);

Falta:

email

---

43. COMO ENCONTRAR O ARQUIVO E A LINHA

Erro Maven:

UsuarioService.java:[42,17]

Significa:

arquivo:
UsuarioService.java

linha:
42

coluna:
17

No VS Code:

CTRL + G

Digite:

42

Enter.

Vai direto para a linha.

---

44. COMO SABER SE O ERRO É SEU OU DO FRAMEWORK

Stack trace contém centenas de linhas como:

org.springframework...
org.hibernate...
java.base...

Não significa que Spring está quebrado.

Procure referências às suas classes:

com.senai.infoa.prova.service.UsuarioService

com.senai.infoa.prova.controller.UsuarioController

com.senai.infoa.prova.model.Usuario

Essas linhas são especialmente importantes.

---

45. COMO USAR "System.out.println"

Se aplicação sobe, mas endpoint quebra:

Controller:

System.out.println(
    ">>> ENTROU NO CONTROLLER"
);

Service:

System.out.println(
    ">>> ENTROU NO SERVICE"
);

Antes do Repository:

System.out.println(
    ">>> ANTES DO SAVE"
);

Depois:

System.out.println(
    ">>> DEPOIS DO SAVE"
);

Se terminal mostra:

>>> CONTROLLER
>>> SERVICE
>>> ANTES DO SAVE

mas não:

>>> DEPOIS DO SAVE

o erro está provavelmente durante:

repository.save(...)

---

46. FLUXO DE DIAGNÓSTICO DE EMERGÊNCIA

Quando clicar Run:

RODOU?
|
├── NÃO COMPILOU
|      ↓
|   primeiro [ERROR]
|      ↓
|   arquivo + linha
|
└── COMPILOU
       ↓
   SPRING SUBIU?
       |
       ├── NÃO
       |    ↓
       | APPLICATION FAILED TO START
       |    ↓
       | último Caused by
       |
       └── SIM
            ↓
        testar Postman
            ↓
        ver status HTTP

---

47. TABELA "CAUSED BY" → SIGNIFICADO

Mensagem| Suspeite de
"Connection refused"| PostgreSQL/porta
"password authentication failed"| senha do banco
"database ... does not exist"| banco
"Not a managed type"| "@Entity"/scan
"No identifier specified"| falta "@Id"
"No property ... found"| Repository query
"mappedBy ... does not exist"| relacionamento
"transient instance"| Entity relacionada não salva
"detached entity"| estado JPA
"LazyInitializationException"| LAZY/contexto
"duplicate key"| UNIQUE
"not-null constraint"| valor null
"foreign key constraint"| relacionamento/delete
"NoSuchBeanDefinition"| Bean ausente
"UnsatisfiedDependencyException"| dependência de Bean falhou
"BeanCreationException"| Bean não pôde ser criado
"Port 8080 already in use"| porta
"WeakKeyException"| chave JWT
"StackOverflowError"| recursão
"NullPointerException"| objeto null
"JSON parse error"| JSON/tipo
"Cannot deserialize... enum"| enum
"Cannot deserialize... LocalDate"| data

---

48. EXEMPLOS COMPLETOS DE LEITURA

EXEMPLO 1 — BANCO

Terminal:

APPLICATION FAILED TO START

BeanCreationException:
Error creating bean 'entityManagerFactory'

Caused by:
JDBCConnectionException

Caused by:
PSQLException:
Connection to localhost:5433 refused

Caused by:
ConnectException:
Connection refused

Não mexa em:

EntityManager
Bean
Repository

Problema real:

Connection refused

Cheque PostgreSQL e porta.

---

EXEMPLO 2 — REPOSITORY

Terminal:

UnsatisfiedDependencyException:
Error creating bean 'usuarioService'

Caused by:
BeanCreationException:
Error creating bean 'usuarioRepository'

Caused by:
QueryCreationException

Caused by:
PropertyReferenceException:
No property 'nomeCompleto' found for type 'Usuario'

Problema real:

Repository possui algo como:

findByNomeCompleto(...)

mas Entity não possui:

nomeCompleto

---

EXEMPLO 3 — RELACIONAMENTO

Terminal:

BeanCreationException:
Error creating bean 'entityManagerFactory'

Caused by:
AnnotationException:

Collection 'Usuario.eventos'
is 'mappedBy' a property named
'usuario_id' which does not exist

Problema real:

mappedBy = "usuario_id"

Deveria ser:

mappedBy = "usuario"

se atributo se chama "usuario".

---

EXEMPLO 4 — BEAN

Terminal:

UnsatisfiedDependencyException:
Error creating bean 'authService'

Caused by:
NoSuchBeanDefinitionException:
No qualifying bean of type
'PasswordEncoder'

Problema:

não existe Bean:

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

---

EXEMPLO 5 — COMPILAÇÃO

Terminal:

COMPILATION ERROR

UsuarioService.java:[52,24]
cannot find symbol

symbol:
method getEmail()

location:
variable dto of type UsuarioRequestDTO

BUILD FAILURE

Se DTO é "record":

errado:

dto.getEmail()

correto:

dto.email()

---

49. O QUE NÃO FAZER

Quando aparece stack trace:

NÃO faça:

trocar versão do Spring
trocar versão do Java
apagar pom inteiro
mudar Security
mudar banco
mudar DTO
mudar Controller
mudar Entity
tudo ao mesmo tempo

Faça:

ler causa
↓
identificar camada
↓
corrigir uma coisa
↓
rodar de novo

---

50. COLA FINAL

Quando aparecer um monte de vermelho:

1. É BUILD FAILURE?
   ↓
   erro de compilação.

2. Tem APPLICATION FAILED TO START?
   ↓
   erro de inicialização.

3. Procure Caused by.

4. Vá para o último Caused by específico.

5. Procure palavras conhecidas.

Connection refused
= banco/porta

password authentication failed
= senha banco

Not a managed type
= Entity

No identifier
= @Id

No property found
= Repository

mappedBy
= relacionamento

NoSuchBeanDefinition
= Bean

Port 8080
= porta

WeakKey
= JWT

duplicate key
= UNIQUE

not-null
= campo obrigatório

foreign key
= relacionamento

StackOverflow
= recursão

NullPointer
= objeto null

JSON parse
= JSON

Cannot deserialize enum
= enum

Cannot deserialize LocalDate
= data

E a regra mais importante:

NÃO TENTE ENTENDER TODAS AS LINHAS DO STACK TRACE.

PROCURE A CAUSA MAIS ESPECÍFICA.

Se vir:

Caused by:

várias vezes:

vá descendo
↓
vá descendo
↓
vá descendo
↓
até chegar na mensagem que explica algo concreto.

Esse costuma ser o ponto onde você realmente começa a resolver o problema.