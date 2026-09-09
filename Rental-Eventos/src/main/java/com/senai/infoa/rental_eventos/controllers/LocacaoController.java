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

import com.senai.infoa.rental_eventos.models.Locacao;
import com.senai.infoa.rental_eventos.services.LocacaoService;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @GetMapping("/contar-locacoes")
    public long contarLocacoes() {
        return locacaoService.contarLocacao();
    }

    @GetMapping("/buscar-locacao/{id}")
    public Locacao buscarLocacao(@PathVariable Long id) {
        return locacaoService.buscarLocacao(id);
    }

    @GetMapping("/listar-locacoes")
    public List<Locacao> listarLocacoes() {
        return locacaoService.listarLocacao();
    }

    @DeleteMapping("/deletar-locacao/{id}")
    public String deletarLocacao(@PathVariable Long id) {
        if (locacaoService.deletarLocacao(id)) {
            return "Locação removida com sucesso.";
        }
        return "Falha ao remover locação.";
    }

    @PostMapping("/salvar-locacao")
    public Locacao salvarLocacao(@RequestBody Locacao locacao) {
        return locacaoService.cadastrarLocacao(locacao);
    }

    @PutMapping("/atualizar-locacao/{id}")
    public String atualizarLocacao(
            @PathVariable Long id,
            @RequestBody Locacao locacao) {

        if (locacaoService.atualizarLocacao(id, locacao) != null) {
            return "Locação atualizada com sucesso.";
        }

        return "Falha ao atualizar locação.";
    }
}