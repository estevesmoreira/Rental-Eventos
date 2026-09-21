package com.senai.infoa.rental_eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.rental_eventos.dto.LocatarioRequestDTO;
import com.senai.infoa.rental_eventos.dto.LocatarioResponseDTO;
import com.senai.infoa.rental_eventos.dto.LoginDTO;
import com.senai.infoa.rental_eventos.dto.LoginResponseDTO;
import com.senai.infoa.rental_eventos.models.Locatario;
import com.senai.infoa.rental_eventos.security.JwtUtil;
import com.senai.infoa.rental_eventos.services.LocatarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    @Autowired
    private LocatarioService locatarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/contar-locatarios")
    public long contarLocatarios() {
        return locatarioService.contarLocatario();
    }

    @GetMapping("/buscar-locatario/{id}")
    public LocatarioResponseDTO buscarLocatario(@PathVariable Long id) {
        return locatarioService.buscarLocatarioDTO(id);
    }

    @GetMapping("/listar-locatarios")
    public List<LocatarioResponseDTO> listarLocatarios() {
        return locatarioService.listarLocatario();
    }

    @DeleteMapping("/deletar-locatario/{id}")
    public String deletarLocatario(@PathVariable Long id) {
        if (locatarioService.deletarLocatario(id)) {
            return "Locatário removido com sucesso.";
        }
        return "Falha ao remover locatário.";
    }

    @PostMapping("/salvar-locatario")
    public ResponseEntity<LocatarioResponseDTO> salvarLocatario(
            @Valid @RequestBody LocatarioRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locatarioService.cadastrarLocatario(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginDTO dto) {

        Locatario locatario = locatarioService.login(
                dto.getEmail(),
                dto.getSenha()
        );

        String token = jwtUtil.gerarToken(
                locatario.getEmail(),
                "LOCATARIO"
        );

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
