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

import com.senai.infoa.rental_eventos.models.Locatario;
import com.senai.infoa.rental_eventos.services.LocatarioService;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    @Autowired
    private LocatarioService locatarioService;

    @GetMapping("/contar-locatarios")
    public long contarLocatarios() {
        return locatarioService.contarLocatario();
    }

    @GetMapping("/buscar-locatario/{id}")
    public Locatario buscarLocatario(@PathVariable Long id) {
        return locatarioService.buscarLocatario(id);
    }

    @GetMapping("/listar-locatarios")
    public List<Locatario> listarLocatarios() {
        return locatarioService.listarLocatario();
    }

    @DeleteMapping("/deletar-locatario/{id}")
    public String deletarLocatario(@PathVariable Long id) {
        if (locatarioService.deletarLocatario(id)) {
            return "Locatário removido com sucesso.";
        }
        return "Falha ao remover locatário.";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Locatario locatario) {

        Locatario usuario = locatarioService.login(
            locatario.getEmail(),
            locatario.getSenha()
        );

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("E-mail ou senha incorretos.");
    }
}
