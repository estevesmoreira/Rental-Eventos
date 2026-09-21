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

import com.senai.infoa.rental_eventos.dto.LocadorRequestDTO;
import com.senai.infoa.rental_eventos.dto.LocadorResponseDTO;
import com.senai.infoa.rental_eventos.dto.LoginDTO;
import com.senai.infoa.rental_eventos.dto.LoginResponseDTO;
import com.senai.infoa.rental_eventos.models.Locador;
import com.senai.infoa.rental_eventos.security.JwtUtil;
import com.senai.infoa.rental_eventos.services.LocadorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/locador")
public class LocadorController {

    @Autowired
    private LocadorService locadorService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/contar-locadores")
    public long contarLocadores() {
        return locadorService.contarLocador();
    }

    @GetMapping("/buscar-locador/{id}")
    public LocadorResponseDTO buscarLocador(@PathVariable Long id) {
        return locadorService.buscarLocadorDTO(id);
    }

    @GetMapping("/listar-locadores")
    public List<LocadorResponseDTO> listarLocadores() {
        return locadorService.listarLocador();
    }

    @DeleteMapping("/deletar-locador/{id}")
    public String deletarLocador(@PathVariable Long id) {
        if (locadorService.deletarLocador(id)) {
            return "Locador removido com sucesso.";
        }
        return "Falha ao remover locador.";
    }

    @PostMapping("/salvar-locador")
    public ResponseEntity<LocadorResponseDTO> salvarLocador(
            @Valid @RequestBody LocadorRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locadorService.cadastrarLocador(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginDTO dto) {

        Locador locador = locadorService.login(
                dto.getEmail(),
                dto.getSenha()
        );

        String token = jwtUtil.gerarToken(
                locador.getEmail(),
                "LOCADOR"
        );

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
