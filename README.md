Entendi. Você precisa de **um roteiro de consulta para a prova, com código completo para copiar, colar e adaptar ao minimundo**, incluindo a ordem de implementação, testes e soluções para os erros mais comuns.

**Não alterei nenhum arquivo do Rental Eventos.** Examinei o projeto para usar uma estrutura próxima da que você já conhece.

Vamos começar por uma base completa de **usuário e autenticação**. Os nomes de arquivos abaixo indicam onde você deverá criar cada classe **no projeto novo da prova**.

**1. O que esta base vai entregar**

| Funcionalidade | Quem pode acessar |
|---|---|
| Cadastrar usuário | Qualquer pessoa |
| Fazer login e receber JWT | Qualquer pessoa |
| Consultar o próprio cadastro | Usuário autenticado |
| Atualizar o próprio cadastro | Usuário autenticado |
| Alterar a própria senha | Usuário autenticado |
| Excluir o próprio cadastro | Usuário autenticado |
| Listar e contar usuários | Administrador |
| Consultar, atualizar e excluir outro usuário | Administrador |

Essa é uma **regra assumida para o exemplo**. Na prova, você adapta as permissões ao enunciado.

O cadastro público sempre cria um usuário comum. Ele não permite que alguém envie `"perfil": "ADMIN"` para se tornar administrador.

O fluxo será:

```text
CADASTRO

JSON → Controller → DTO validado → Service
     → senha protegida com BCrypt → Repository → PostgreSQL


LOGIN

E-mail e senha → Service verifica credenciais
              → gera JWT → devolve token


REQUISIÇÃO PROTEGIDA

Authorization: Bearer TOKEN
              → Spring Security valida JWT
              → verifica permissão → Controller → Service
```

JWT é o token que comprova a autenticação nas próximas requisições. **Ele é assinado, mas seu conteúdo não é secreto**. Não coloque senha nele.

---

**2. Como interpretar o minimundo antes de programar**

Antes de criar arquivos, extraia estas informações:

| Informação do enunciado | Consequência no código |
|---|---|
| “O usuário possui nome, e-mail e senha” | Atributos da entidade |
| “O e-mail não pode se repetir” | Verificação no service e restrição única no banco |
| “Somente administradores podem listar usuários” | Regra de autorização |
| “Um usuário realiza várias reservas” | Relacionamento entre usuário e reserva |
| “A reserva precisa de uma data futura” | Validação de entrada ou regra no service |
| “Não pode excluir usuário com reservas ativas” | Regra no service antes de excluir |

A divisão das camadas é:

| Camada | Responsabilidade |
|---|---|
| `models` | Representar entidades e relacionamentos do banco |
| `repositories` | Consultar e persistir dados |
| `dto` | Definir os dados recebidos e devolvidos pela API |
| `services` | Executar regras de negócio |
| `controllers` | Receber requisições HTTP e devolver respostas |
| `security` | Configurar autenticação, tokens e permissões |
| `exceptions` | Padronizar respostas de erro |

**Regra prática:** controller recebe, service decide, repository acessa o banco.

---

**3. Preparação do projeto**

No Rental que examinei, o `pom.xml` declara:

- Spring Boot `4.1.1`;
- Java `25`;
- PostgreSQL;
- Spring Security;
- JJWT `0.12.6`;
- Spring MVC;
- Bean Validation.

Essas são as versões **declaradas no seu projeto**, não uma afirmação de que foram compiladas nesta resposta.

Para a prova, use a versão de Java e Spring Boot disponibilizada pelo professor. **Não altere versões sem necessidade durante a prova.**

Os exemplos abaixo seguem a estrutura moderna do seu Rental, com imports `jakarta.*` e configuração de segurança por `SecurityFilterChain`.

No `pom.xml` do projeto novo, dentro de `<dependencies>`, você precisará destas dependências. Se já existirem, não duplique:

```xml
<!-- API HTTP: esta dependência segue o Spring Boot 4 do Rental -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>

<!-- Persistência -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Validação dos DTOs -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- Segurança e BCrypt -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- Validação das requisições que enviam JWT -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>

<!-- PostgreSQL -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Geração do JWT -->
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
```

Se o projeto fornecido usar **Spring Boot 3**, o starter web usual é `spring-boot-starter-web`. Não copie o starter do Boot 4 para um projeto Boot 3 indiscriminadamente.

Nesta implementação, o Spring Security valida o JWT automaticamente pelo suporte a Resource Server. Esse suporte aceita tokens JWT próprios, como os emitidos pela aplicação. Portanto, **não precisamos escrever filtros JWT manuais**. [Documentação oficial do Spring Security](https://docs.spring.io/spring-security/reference/servlet/oauth2/)

---

**4. Organização dos arquivos**

Usarei o pacote fictício:

```java
com.exemplo.prova
```

**Antes de copiar, substitua esse pacote pelo pacote real da aplicação da prova, em todos os arquivos.**

```text
src/main/java/com/exemplo/prova/
│
├── ProvaApplication.java
│
├── models/
│   └── Usuario.java
│
├── enums/
│   └── Perfil.java
│
├── repositories/
│   └── UsuarioRepository.java
│
├── dto/
│   ├── UsuarioRequestDTO.java
│   ├── UsuarioUpdateDTO.java
│   ├── UsuarioResponseDTO.java
│   ├── AlterarSenhaDTO.java
│   ├── LoginDTO.java
│   └── LoginResponseDTO.java
│
├── services/
│   └── UsuarioService.java
│
├── controllers/
│   ├── AuthController.java
│   └── UsuarioController.java
│
├── security/
│   ├── JwtUtil.java
│   └── SecurityConfig.java
│
└── exceptions/
    └── ApiExceptionHandler.java
```

A classe principal precisa ficar no pacote acima dos demais:

```java
package com.exemplo.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProvaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvaApplication.class, args);
    }
}
```

Se o projeto já tiver uma classe principal gerada, use a existente.

---

**5. Configurar o banco e o JWT**

No projeto novo, configure `src/main/resources/application.properties`:

```properties
spring.application.name=prova

server.port=8080

# Ajuste porta, nome do banco, usuário e senha.
spring.datasource.url=jdbc:postgresql://localhost:5432/prova
spring.datasource.username=${DB_USER:postgres}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false

# Chave recebida por variável de ambiente.
jwt.secret=${JWT_SECRET}

# Duração do token em milissegundos: 1 hora.
jwt.expiration=3600000
```

No Rental, a porta configurada é `5433`. Neste exemplo, usei `5432`. **Confira a porta real da máquina da prova.**

O Hibernate pode criar tabelas, mas **não cria o banco PostgreSQL que aparece na URL**. Crie o banco no pgAdmin ou execute:

```sql
CREATE DATABASE prova;
```

No PowerShell, antes de iniciar a aplicação no mesmo terminal:

```powershell
$env:DB_PASSWORD = "sua-senha-do-postgres"

$jwtBytes = New-Object byte[] 32
[System.Security.Cryptography.RandomNumberGenerator]::Fill($jwtBytes)
$env:JWT_SECRET = [Convert]::ToBase64String($jwtBytes)
```

Essa chave será interpretada como texto UTF-8 no código abaixo. A geração em Base64 serve para representar os bytes aleatórios como texto.

**Mantenha a mesma chave enquanto quiser que os tokens existentes continuem válidos.** Se executar a geração novamente, os tokens anteriores deixarão de passar na validação.

Se iniciar pela IDE, configure as variáveis de ambiente na configuração de execução dela. Variáveis definidas em um terminal não são automaticamente aplicadas a uma IDE que já estava aberta.

O algoritmo HS256 exige uma chave de pelo menos 256 bits; a biblioteca rejeita chaves insuficientes. [Documentação do JJWT](https://github.com/jwtk/jjwt)

---

**6. Criar o perfil de acesso**

Arquivo: `enums/Perfil.java`

```java
package com.exemplo.prova.enums;

public enum Perfil {
    USUARIO,
    ADMIN
}
```

Na prova, outros exemplos seriam:

```text
CLIENTE / FUNCIONARIO / ADMIN
ALUNO / PROFESSOR / ADMIN
LOCADOR / LOCATARIO / ADMIN
```

**Não confunda perfil de acesso com entidade.** Um perfil define permissões; uma entidade pode precisar de atributos e relacionamentos próprios.

---

**7. Criar a entidade Usuario**

Arquivo: `models/Usuario.java`

```java
package com.exemplo.prova.models;

import com.exemplo.prova.enums.Perfil;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, unique = true, length = 180)
    private String email;

    @Column(nullable = false, length = 100)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Perfil perfil = Perfil.USUARIO;

    public Usuario() {
    }

    public Long getId() {
        return id;
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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
```

Pontos para memorizar:

- `@Entity`: classe persistida no banco.
- `@Table`: nome da tabela.
- `@Id`: chave primária.
- `@GeneratedValue`: o banco gera o identificador.
- `nullable = false`: coluna obrigatória.
- `unique = true`: impede repetição.
- `EnumType.STRING`: grava `USUARIO` ou `ADMIN`, em vez da posição numérica.
- Construtor vazio: necessário para o JPA instanciar a entidade.

O campo `senha` guardará **o hash BCrypt**, e não a senha original.

---

**8. Criar os DTOs**

DTO é o objeto que define quais dados entram ou saem da API.

**Crie cada bloco em seu próprio arquivo.**

Arquivo: `dto/UsuarioRequestDTO.java`

```java
package com.exemplo.prova.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(

        @NotBlank(message = "Nome é obrigatório.")
        @Size(max = 120, message = "Nome deve ter até 120 caracteres.")
        String nome,

        @NotBlank(message = "E-mail é obrigatório.")
        @Email(message = "E-mail inválido.")
        @Size(max = 180, message = "E-mail deve ter até 180 caracteres.")
        String email,

        @NotBlank(message = "Senha é obrigatória.")
        @Size(min = 8, max = 72,
              message = "Senha deve ter entre 8 e 72 caracteres.")
        String senha
) {
}
```

Arquivo: `dto/UsuarioUpdateDTO.java`

```java
package com.exemplo.prova.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateDTO(

        @NotBlank(message = "Nome é obrigatório.")
        @Size(max = 120, message = "Nome deve ter até 120 caracteres.")
        String nome,

        @NotBlank(message = "E-mail é obrigatório.")
        @Email(message = "E-mail inválido.")
        @Size(max = 180, message = "E-mail deve ter até 180 caracteres.")
        String email
) {
}
```

Arquivo: `dto/UsuarioResponseDTO.java`

```java
package com.exemplo.prova.dto;

import com.exemplo.prova.enums.Perfil;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        Perfil perfil
) {
}
```

**A senha não aparece no DTO de resposta. Nem mesmo o hash deve ser devolvido.**

Arquivo: `dto/AlterarSenhaDTO.java`

```java
package com.exemplo.prova.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AlterarSenhaDTO(

        @NotBlank(message = "Senha atual é obrigatória.")
        @Size(max = 72, message = "Senha atual deve ter até 72 caracteres.")
        String senhaAtual,

        @NotBlank(message = "Nova senha é obrigatória.")
        @Size(min = 8, max = 72,
              message = "Nova senha deve ter entre 8 e 72 caracteres.")
        String novaSenha
) {
}
```

Arquivo: `dto/LoginDTO.java`

```java
package com.exemplo.prova.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO(

        @NotBlank(message = "E-mail é obrigatório.")
        @Email(message = "E-mail inválido.")
        @Size(max = 180, message = "E-mail deve ter até 180 caracteres.")
        String email,

        @NotBlank(message = "Senha é obrigatória.")
        @Size(max = 72, message = "Senha deve ter até 72 caracteres.")
        String senha
) {
}
```

Arquivo: `dto/LoginResponseDTO.java`

```java
package com.exemplo.prova.dto;

public record LoginResponseDTO(
        String token,
        String tipo,
        long expiraEmSegundos
) {
}
```

**Atenção aos records:** seus métodos são `dto.email()` e `dto.senha()`, não `dto.getEmail()` e `dto.getSenha()`.

O seu Rental mistura DTOs implementados como classes e como records. Ao adaptar, confira qual formato está usando.

---

**9. Criar o repository**

Arquivo: `repositories/UsuarioRepository.java`

```java
package com.exemplo.prova.repositories;

import com.exemplo.prova.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);
}
```

O `JpaRepository` já fornece:

```java
findAll();
findById(id);
save(usuario);
delete(usuario);
existsById(id);
count();
```

Os métodos adicionais significam:

```text
findByEmail
→ Buscar usuário pelo e-mail.

existsByEmail
→ Verificar se o e-mail já existe.

existsByEmailAndIdNot
→ Verificar se outro usuário possui esse e-mail.
```

O último método resolve um problema comum: na atualização, manter o próprio e-mail não deve gerar conflito.

**Os nomes após `By` precisam corresponder aos atributos Java da entidade.**

---

**10. Criar a geração de JWT**

Arquivo: `security/JwtUtil.java`

```java
package com.exemplo.prova.security;

import com.exemplo.prova.models.Usuario;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey chave;
    private final long expiracaoMs;

    public JwtUtil(
            SecretKey chave,
            @Value("${jwt.expiration}") long expiracaoMs
    ) {
        if (expiracaoMs <= 0) {
            throw new IllegalArgumentException(
                    "jwt.expiration deve ser maior que zero."
            );
        }

        this.chave = chave;
        this.expiracaoMs = expiracaoMs;
    }

    public String gerarToken(Usuario usuario) {
        Instant agora = Instant.now();

        return Jwts.builder()
                .subject(usuario.getId().toString())
                .claim("perfil", usuario.getPerfil().name())
                .issuedAt(Date.from(agora))
                .expiration(Date.from(agora.plusMillis(expiracaoMs)))
                .signWith(chave, Jwts.SIG.HS256)
                .compact();
    }

    public long getExpiracaoSegundos() {
        return expiracaoMs / 1000;
    }
}
```

O token contém:

```text
sub     → ID do usuário
perfil  → USUARIO ou ADMIN
iat     → instante da emissão
exp     → instante da expiração
```

Usei o ID como identificação principal porque **ele permanece igual quando o usuário altera o e-mail**.

A chave será fornecida pela configuração a seguir. Assim, geração e validação usam a mesma chave.

---

**11. Configurar autenticação e permissões**

Arquivo: `security/SecurityConfig.java`

```java
package com.exemplo.prova.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecretKey jwtSigningKey(
            @Value("${jwt.secret}") String segredo
    ) {
        return Keys.hmacShaKeyFor(
                segredo.getBytes(StandardCharsets.UTF_8)
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtDecoder jwtDecoder(SecretKey chave) {
        return NimbusJwtDecoder
                .withSecretKey(chave)
                .macAlgorithm(MacAlgorithm.HS256)
                .build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter authorities =
                new JwtGrantedAuthoritiesConverter();

        authorities.setAuthoritiesClaimName("perfil");
        authorities.setAuthorityPrefix("ROLE_");

        JwtAuthenticationConverter converter =
                new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(authorities);

        return converter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            JwtAuthenticationConverter converter
    ) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .formLogin(form -> form.disable())

                .httpBasic(basic -> basic.disable())

                .sessionManagement(session -> session
                        .sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/error",
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()

                        .requestMatchers(
                                HttpMethod.POST,
                                "/auth/cadastro",
                                "/auth/login"
                        ).permitAll()

                        .anyRequest().authenticated()
                )

                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(converter)
                        )
                );

        return http.build();
    }
}
```

O que essa configuração faz:

- Libera cadastro e login.
- Exige token nas demais rotas.
- Valida assinatura e validade temporal do token.
- Converte o perfil `ADMIN` em uma autoridade chamada `ROLE_ADMIN`.
- Habilita `@PreAuthorize`, usado nos controllers.
- Configura a aplicação sem sessão HTTP de autenticação.

O CSRF foi desabilitado considerando **uma API que recebe o token no cabeçalho `Authorization` e não autentica por cookies**. Se mudar esse modelo, reavalie essa configuração.

**Não é necessário implementar `UserDetailsService` nesta abordagem.** O service confere e-mail e senha no login; nas próximas requisições, o Resource Server autentica pelo JWT.

---

**12. Criar o service completo**

Arquivo: `services/UsuarioService.java`

```java
package com.exemplo.prova.services;

import com.exemplo.prova.dto.*;
import com.exemplo.prova.enums.Perfil;
import com.exemplo.prova.models.Usuario;
import com.exemplo.prova.repositories.UsuarioRepository;
import com.exemplo.prova.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

@Service
@Transactional(readOnly = true)
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UsuarioService(
            UsuarioRepository repository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Transactional
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        String email = normalizarEmail(dto.email());

        if (repository.existsByEmail(email)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "E-mail já cadastrado."
            );
        }

        validarTamanhoSenha(dto.senha());

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome().trim());
        usuario.setEmail(email);
        usuario.setSenha(passwordEncoder.encode(dto.senha()));

        // O cadastro público sempre cria um usuário comum.
        usuario.setPerfil(Perfil.USUARIO);

        Usuario salvo = repository.saveAndFlush(usuario);

        return toDTO(salvo);
    }

    public LoginResponseDTO login(LoginDTO dto) {
        String email = normalizarEmail(dto.email());

        validarTamanhoSenha(dto.senha());

        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "E-mail ou senha incorretos."
                ));

        if (!passwordEncoder.matches(
                dto.senha(),
                usuario.getSenha()
        )) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "E-mail ou senha incorretos."
            );
        }

        String token = jwtUtil.gerarToken(usuario);

        return new LoginResponseDTO(
                token,
                "Bearer",
                jwtUtil.getExpiracaoSegundos()
        );
    }

    public List<UsuarioResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public long contar() {
        return repository.count();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        return toDTO(buscarEntidade(id));
    }

    @Transactional
    public UsuarioResponseDTO atualizar(
            Long id,
            UsuarioUpdateDTO dto
    ) {
        Usuario usuario = buscarEntidade(id);
        String email = normalizarEmail(dto.email());

        if (repository.existsByEmailAndIdNot(email, id)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "E-mail já utilizado por outro usuário."
            );
        }

        usuario.setNome(dto.nome().trim());
        usuario.setEmail(email);

        Usuario atualizado = repository.saveAndFlush(usuario);

        return toDTO(atualizado);
    }

    @Transactional
    public void alterarSenha(Long id, AlterarSenhaDTO dto) {
        Usuario usuario = buscarEntidade(id);

        validarTamanhoSenha(dto.senhaAtual());
        validarTamanhoSenha(dto.novaSenha());

        if (!passwordEncoder.matches(
                dto.senhaAtual(),
                usuario.getSenha()
        )) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Senha atual incorreta."
            );
        }

        usuario.setSenha(
                passwordEncoder.encode(dto.novaSenha())
        );

        repository.saveAndFlush(usuario);
    }

    @Transactional
    public void excluir(Long id) {
        Usuario usuario = buscarEntidade(id);

        repository.delete(usuario);
        repository.flush();
    }

    private Usuario buscarEntidade(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado."
                ));
    }

    private UsuarioResponseDTO toDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPerfil()
        );
    }

    private String normalizarEmail(String email) {
        return email.trim().toLowerCase(Locale.ROOT);
    }

    private void validarTamanhoSenha(String senha) {
        if (senha.getBytes(StandardCharsets.UTF_8).length > 72) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Senha deve ter no máximo 72 bytes em UTF-8."
            );
        }
    }
}
```

As decisões mais importantes:

**Senha:** no cadastro, use:

```java
passwordEncoder.encode(senha);
```

No login, use:

```java
passwordEncoder.matches(senhaDigitada, hashDoBanco);
```

**Não faça isto:**

```java
passwordEncoder.encode(senhaDigitada).equals(hashDoBanco);
```

O BCrypt utiliza um componente aleatório chamado *salt*. Por isso, duas codificações da mesma senha podem gerar hashes diferentes.

A validação adicional em bytes existe porque caracteres acentuados e emojis podem ocupar mais de um byte. Apenas `@Size(max = 72)` não representa exatamente o limite do BCrypt.

**E-mail:** cadastro, atualização e login usam a mesma normalização. Isso evita que `NICOLAS@EMAIL.COM` e `nicolas@email.com` sejam tratados de maneira diferente nesta aplicação.

**Transação:** `@Transactional` agrupa as operações de alteração. Os métodos de consulta ficam com `readOnly = true`.

**Duplicidade:** a verificação no service melhora a mensagem, e a restrição no banco continua sendo necessária para impedir duplicidades em requisições simultâneas.

---

**13. Criar o controller de autenticação**

Arquivo: `controllers/AuthController.java`

```java
package com.exemplo.prova.controllers;

import com.exemplo.prova.dto.LoginDTO;
import com.exemplo.prova.dto.LoginResponseDTO;
import com.exemplo.prova.dto.UsuarioRequestDTO;
import com.exemplo.prova.dto.UsuarioResponseDTO;
import com.exemplo.prova.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService service;

    public AuthController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioResponseDTO> cadastrar(
            @Valid @RequestBody UsuarioRequestDTO dto
    ) {
        UsuarioResponseDTO criado = service.cadastrar(dto);

        return ResponseEntity
                .created(URI.create("/usuarios/" + criado.id()))
                .body(criado);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginDTO dto
    ) {
        return ResponseEntity.ok(service.login(dto));
    }
}
```

- `@RequestBody`: converte o JSON recebido em DTO.
- `@Valid`: executa as validações declaradas no DTO.
- `201 Created`: informa que o cadastro foi criado.
- `Location`: cabeçalho com o endereço do recurso criado.
- `200 OK`: informa sucesso no login.

---

**14. Criar o controller de usuários**

Arquivo: `controllers/UsuarioController.java`

```java
package com.exemplo.prova.controllers;

import com.exemplo.prova.dto.AlterarSenhaDTO;
import com.exemplo.prova.dto.UsuarioResponseDTO;
import com.exemplo.prova.dto.UsuarioUpdateDTO;
import com.exemplo.prova.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/me")
    public UsuarioResponseDTO meuCadastro(
            @AuthenticationPrincipal Jwt jwt
    ) {
        Long id = Long.valueOf(jwt.getSubject());

        return service.buscarPorId(id);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UsuarioResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/quantidade")
    @PreAuthorize("hasRole('ADMIN')")
    public long contar() {
        return service.contar();
    }

    @GetMapping("/{id}")
    @PreAuthorize(
            "hasRole('ADMIN') or #id.toString() == authentication.name"
    )
    public UsuarioResponseDTO buscarPorId(
            @P("id") @PathVariable("id") Long id
    ) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize(
            "hasRole('ADMIN') or #id.toString() == authentication.name"
    )
    public UsuarioResponseDTO atualizar(
            @P("id") @PathVariable("id") Long id,
            @Valid @RequestBody UsuarioUpdateDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @PatchMapping("/me/senha")
    public ResponseEntity<Void> alterarMinhaSenha(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody AlterarSenhaDTO dto
    ) {
        Long id = Long.valueOf(jwt.getSubject());

        service.alterarSenha(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(
            "hasRole('ADMIN') or #id.toString() == authentication.name"
    )
    public ResponseEntity<Void> excluir(
            @P("id") @PathVariable("id") Long id
    ) {
        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
```

A expressão:

```java
hasRole('ADMIN') or #id.toString() == authentication.name
```

significa:

```text
Permitir se:
- o usuário for administrador; OU
- o ID solicitado for igual ao ID do usuário autenticado.
```

Neste exemplo, `authentication.name` corresponde ao `sub` do token, que contém o ID.

A anotação `@P("id")` identifica explicitamente o parâmetro usado na expressão de autorização.

**Autenticação e autorização são diferentes:**

- Autenticação: verificar quem fez a requisição.
- Autorização: verificar se essa pessoa pode executar a operação.

Exigir apenas `.authenticated()` não impediria, por si só, um usuário de tentar alterar o cadastro de outro.

---

**15. Padronizar os erros**

Arquivo: `exceptions/ApiExceptionHandler.java`

```java
package com.exemplo.prova.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    public record ErroDTO(
            Instant instante,
            int status,
            String mensagem,
            Map<String, String> campos
    ) {
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErroDTO> tratarRegra(
            ResponseStatusException ex
    ) {
        String mensagem = ex.getReason() != null
                ? ex.getReason()
                : "Não foi possível concluir a operação.";

        return ResponseEntity
                .status(ex.getStatusCode())
                .body(new ErroDTO(
                        Instant.now(),
                        ex.getStatusCode().value(),
                        mensagem,
                        Map.of()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDTO> tratarValidacao(
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> campos = new LinkedHashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(erro -> campos.putIfAbsent(
                        erro.getField(),
                        erro.getDefaultMessage() != null
                                ? erro.getDefaultMessage()
                                : "Valor inválido."
                ));

        return ResponseEntity.badRequest()
                .body(new ErroDTO(
                        Instant.now(),
                        400,
                        "Dados inválidos.",
                        campos
                ));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroDTO> tratarIntegridade(
            DataIntegrityViolationException ex
    ) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErroDTO(
                        Instant.now(),
                        409,
                        "Operação viola uma restrição do banco: "
                                + "verifique duplicidade ou registros vinculados.",
                        Map.of()
                ));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroDTO> tratarJson(
            HttpMessageNotReadableException ex
    ) {
        return ResponseEntity.badRequest()
                .body(new ErroDTO(
                        Instant.now(),
                        400,
                        "JSON inválido ou corpo da requisição ausente.",
                        Map.of()
                ));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErroDTO> tratarTipo(
            MethodArgumentTypeMismatchException ex
    ) {
        return ResponseEntity.badRequest()
                .body(new ErroDTO(
                        Instant.now(),
                        400,
                        "Parâmetro inválido: " + ex.getName(),
                        Map.of()
                ));
    }
}
```

Exemplo de erro de validação:

```json
{
  "instante": "2026-09-21T12:00:00Z",
  "status": 400,
  "mensagem": "Dados inválidos.",
  "campos": {
    "nome": "Nome é obrigatório.",
    "email": "E-mail inválido."
  }
}
```

**Observação:** erros de token rejeitados na cadeia de segurança não passam necessariamente por esse advice. Eles podem retornar `401` ou `403` sem esse mesmo corpo JSON.

---

**16. Executar o projeto**

Na pasta que contém o `pom.xml`, confira:

```powershell
java -version
```

Se o projeto contém o Maven Wrapper, execute:

```powershell
.\mvnw.cmd clean compile
```

Depois:

```powershell
.\mvnw.cmd spring-boot:run
```

Se não houver wrapper, mas o Maven estiver instalado:

```powershell
mvn clean compile
```

```powershell
mvn spring-boot:run
```

**Não execute o comando de inicialização antes de configurar o banco e as variáveis de ambiente.**

Para esta resposta, revisei os arquivos do Rental e as APIs utilizadas, mas **não compilei nem executei este projeto de exemplo**. A sequência abaixo é a verificação que você deve fazer antes de considerar a base pronta para a prova.

---

**17. Testar na ordem correta**

Você pode executar pelo Postman, Insomnia ou extensão equivalente.

Em requisições com JSON:

```http
Content-Type: application/json
```

**Teste 1 — Cadastrar**

```http
POST http://localhost:8080/auth/cadastro
```

Corpo:

```json
{
  "nome": "Nicolas",
  "email": "nicolas@email.com",
  "senha": "Senha123!"
}
```

Esperado: `201 Created`.

```json
{
  "id": 1,
  "nome": "Nicolas",
  "email": "nicolas@email.com",
  "perfil": "USUARIO"
}
```

O ID pode ser diferente de `1`. Use o valor retornado.

**Teste 2 — Repetir o cadastro**

Envie novamente o mesmo e-mail.

Esperado: `409 Conflict`.

**Teste 3 — Login**

```http
POST http://localhost:8080/auth/login
```

```json
{
  "email": "nicolas@email.com",
  "senha": "Senha123!"
}
```

Esperado: `200 OK`.

```json
{
  "token": "eyJ...",
  "tipo": "Bearer",
  "expiraEmSegundos": 3600
}
```

Copie apenas o conteúdo de `token`.

**Teste 4 — Consultar o próprio cadastro**

```http
GET http://localhost:8080/usuarios/me
Authorization: Bearer SEU_TOKEN
```

Esperado: `200 OK`.

Se usar a opção **Bearer Token** do Postman, cole apenas o token. O Postman adiciona `Bearer` automaticamente.

**Teste 5 — Consultar sem token**

Repita a consulta sem o cabeçalho.

Esperado: `401 Unauthorized`.

**Teste 6 — Atualizar**

Substitua `1` pelo ID retornado no cadastro.

```http
PUT http://localhost:8080/usuarios/1
Authorization: Bearer SEU_TOKEN
Content-Type: application/json
```

```json
{
  "nome": "Nicolas Atualizado",
  "email": "nicolas.novo@email.com"
}
```

Esperado: `200 OK`.

A atualização exige os dois campos. Essa rota não altera senha nem perfil.

**Teste 7 — Alterar senha**

```http
PATCH http://localhost:8080/usuarios/me/senha
Authorization: Bearer SEU_TOKEN
Content-Type: application/json
```

```json
{
  "senhaAtual": "Senha123!",
  "novaSenha": "OutraSenha123!"
}
```

Esperado: `204 No Content`, sem corpo de resposta.

Depois, faça login com o e-mail atualizado e a nova senha.

**Teste 8 — Verificar a permissão de administrador**

```http
GET http://localhost:8080/usuarios
Authorization: Bearer TOKEN_DO_USUARIO_COMUM
```

Esperado: `403 Forbidden`.

**Teste 9 — Preparar um administrador local**

Para testar a base, cadastre normalmente um segundo usuário:

```json
{
  "nome": "Administrador",
  "email": "admin@email.com",
  "senha": "Admin123!"
}
```

Depois, no banco de teste:

```sql
UPDATE usuarios
SET perfil = 'ADMIN'
WHERE email = 'admin@email.com';
```

Faça login com esse usuário **depois da alteração** e obtenha um novo token.

Esse procedimento é apenas a preparação local do teste. Na prova, siga a regra de criação de administradores exigida pelo minimundo.

Agora:

```http
GET http://localhost:8080/usuarios
Authorization: Bearer TOKEN_DO_ADMIN
```

Esperado: `200 OK`.

**Teste 10 — Excluir**

```http
DELETE http://localhost:8080/usuarios/1
Authorization: Bearer TOKEN_AUTORIZADO
```

Esperado: `204 No Content`.

Consultar depois esse cadastro com o administrador deve retornar `404 Not Found`.

---

**18. Limitação importante desta base de JWT**

O token é validado pela assinatura e pela expiração. **A aplicação não consulta o banco a cada requisição para verificar se o usuário foi excluído ou teve o perfil alterado.**

Consequências práticas:

- Alterar a senha não invalida automaticamente tokens já emitidos.
- Alterar o perfil no banco não altera tokens existentes.
- Excluir a conta não revoga automaticamente o token.
- Um token antigo de administrador pode continuar permitindo operações administrativas até expirar.

A consulta `/usuarios/me` procura o cadastro no banco e retornará `404` se ele tiver sido excluído, mas isso **não equivale a revogar o token em todas as rotas**.

Esta base usa tokens com duração de uma hora. Se o minimundo exigir bloqueio imediato, logout com revogação ou invalidação após alteração de senha, será necessário acrescentar uma estratégia de revogação ou uma verificação do usuário a cada requisição.

---

**19. Principais erros e como resolver**

| Erro ou sintoma | Causa provável | Como resolver |
|---|---|---|
| `release version 25 not supported` | Maven executando com JDK inferior ao configurado | Confira `java -version`, `mvn -version` ou `.\mvnw.cmd -version`; alinhe o JDK e o `pom.xml` |
| `package javax.persistence does not exist` | Import antigo em projeto moderno | Use `jakarta.persistence.*` |
| `package jakarta.validation does not exist` | Dependência de validação ausente | Adicione `spring-boot-starter-validation` e recarregue o Maven |
| `Could not resolve placeholder 'JWT_SECRET'` | Variável ausente | Defina a variável no ambiente que inicia a aplicação |
| `WeakKeyException` | Chave JWT insuficiente | Use a geração de chave apresentada anteriormente |
| `Connection refused` | PostgreSQL parado ou porta incorreta | Confira serviço, host e porta; seu Rental usa `5433` |
| `password authentication failed` | Credenciais do PostgreSQL incorretas | Ajuste usuário e senha |
| `database "prova" does not exist` | Banco não foi criado | Execute `CREATE DATABASE prova;` |
| `Port 8080 was already in use` | Outra aplicação ocupa a porta | Pare a outra execução ou altere `server.port` |
| Cadastro retorna `401` | Rota não liberada ou token inválido enviado | Confira o matcher de `POST /auth/cadastro`; remova token antigo dessa requisição |
| Login retorna `401` | E-mail ou senha incorretos | Verifique dados, e-mail atualizado e uso de `matches` |
| Rota protegida retorna `401` | Token ausente, vencido ou inválido | Faça novo login e envie `Authorization: Bearer TOKEN` |
| Token deixou de funcionar após reiniciar | A chave JWT mudou | Use a mesma chave ou faça novo login |
| Rota retorna `403` | Token válido, mas sem permissão | Confira perfil e regra `@PreAuthorize` |
| Administrador continua com `403` | Token emitido antes da promoção | Faça login novamente |
| `No property ... found for type Usuario` | Nome incorreto de método no repository | Use nomes correspondentes aos atributos da entidade |
| `Not a managed type` | Falta `@Entity` ou pacote fora da descoberta | Confira a anotação e a posição da classe principal |
| `Required a bean ... that could not be found` | Falta `@Service`, `@Component` ou configuração | Confira as anotações e os pacotes |
| DTO aceita campo vazio | Falta `@Valid` no controller | Use `@Valid @RequestBody` |
| `getEmail()` não existe no DTO | DTO é um record | Use `dto.email()` |
| Duplicidade gera erro no banco | Restrição única foi violada | Retorne `409`; não remova a restrição para esconder o problema |
| Exclusão falha com registros vinculados | Chave estrangeira impede exclusão | Implemente a regra do minimundo; não aplique exclusão em cascata sem avaliar |
| Erro `415 Unsupported Media Type` | Corpo não está sendo enviado como JSON | Configure `Content-Type: application/json` |
| `/usuarios/abc` retorna `400` | O parâmetro deveria ser `Long` | Envie um ID numérico |
| API funciona no Postman e falha no navegador | Possível CORS | Configure a origem exata do frontend e permita os cabeçalhos necessários |
| Swagger não abre | Dependência ausente ou caminho diferente | Esta base não instala Swagger; liberar a rota na segurança não cria a interface |

**Detalhe útil:** uma rota pública com `permitAll()` ainda pode rejeitar uma requisição que envie um Bearer token inválido. Para cadastro e login, remova o token vencido do cliente HTTP.

---

**20. Como adaptar este código ao minimundo**

Se o enunciado acrescentar `telefone`, faça a alteração em todos os lugares relevantes:

```text
1. Usuario
   → adicionar atributo e acesso.

2. UsuarioRequestDTO
   → receber no cadastro.

3. UsuarioUpdateDTO
   → receber na atualização, se permitido.

4. UsuarioResponseDTO
   → devolver, se fizer parte da resposta.

5. UsuarioService.cadastrar()
   → copiar DTO para entidade.

6. UsuarioService.atualizar()
   → atualizar atributo.

7. UsuarioService.toDTO()
   → copiar entidade para resposta.

8. JSONs de teste
   → incluir telefone.
```

Se houver uma entidade relacionada, como `Reserva`, não basta renomear `Usuario`. Você precisará definir:

- Quem possui a chave estrangeira.
- Se a relação é um-para-um, um-para-muitos ou muitos-para-muitos.
- Se o vínculo é obrigatório.
- Quem pode consultar ou alterar o registro.
- O que acontece quando um registro relacionado é excluído.

**Para usuário, a recomendação é preservar esta separação:** cadastro e atualização com DTOs próprios, resposta sem senha, BCrypt no service, JWT identificado pelo ID e autorização nas operações.

**Ordem de consulta durante a prova:** banco e dependências → entidade e enum → DTOs → repository → JWT e segurança → service → controllers → tratamento de erros → testes de cadastro, login e permissões.
