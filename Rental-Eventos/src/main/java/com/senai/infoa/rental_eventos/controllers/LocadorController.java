package com.senai.infoa.rental_eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.rental_eventos.models.Locador;
import com.senai.infoa.rental_eventos.models.LocadorService;

@RestController
@RequestMapping("/locador")
public class LocadorController {

    @Autowired
    private LocadorService locadorService;

    @GetMapping("/contar-locadores")
    public long contarLocadores() {
        return locadorService.contarLocadores();
    }

    @GetMapping("/buscar-locador/{id}")
    public Locador buscarLocador(@PathVariable Integer id) {
        return locadorService.buscarLocador(id);
    }

    @GetMapping("/listar-locadores")
    public List<Locador> listarLocadores() {
        return locadorService.listarLocadores();
    }

    @DeleteMapping("/deletar-locador/{id}")
    public String deletarLocador(@PathVariable Integer id) {
        if (locadorService.deletarLocador(id)) {
            return "Locador removido com sucesso.";
        }
        return "Falha ao remover locador.";
    }

    @PostMapping("/salvar-locador")
    public Locador salvarLocador(@RequestBody Locador locador) {
        return locadorService.cadastrarLocador(locador);
    }

    @PutMapping("/atualizar-locador/{id}")
    public String atualizarLocador(
            @PathVariable Integer id,
            @RequestBody Locador locador) {

        if (locadorService.atualizarLocador(id, locador) != null) {
            return "Locador atualizado com sucesso.";
        }

        return "Falha ao atualizar locador.";
    }
}
