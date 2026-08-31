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

import com.senai.infoa.rental_eventos.models.Estoque;
import com.senai.infoa.rental_eventos.models.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/contar-estoques")
    public long contarEstoques() {
        return estoqueService.contarEstoques();
    }

    @GetMapping("/buscar-estoque/{id}")
    public Estoque buscarEstoque(@PathVariable Integer id) {
        return estoqueService.buscarEstoque(id);
    }

    @GetMapping("/listar-estoques")
    public List<Estoque> listarEstoques() {
        return estoqueService.listarEstoques();
    }

    @DeleteMapping("/deletar-estoque/{id}")
    public String deletarEstoque(@PathVariable Integer id) {
        if (estoqueService.deletarEstoque(id)) {
            return "Estoque removido com sucesso.";
        }
        return "Falha ao remover estoque.";
    }

    @PostMapping("/salvar-estoque")
    public Estoque salvarEstoque(@RequestBody Estoque estoque) {
        return estoqueService.cadastrarEstoque(estoque);
    }

    @PutMapping("/atualizar-estoque/{id}")
    public String atualizarEstoque(
            @PathVariable Integer id,
            @RequestBody Estoque estoque) {

        if (estoqueService.atualizarEstoque(id, estoque) != null) {
            return "Estoque atualizado com sucesso.";
        }

        return "Falha ao atualizar estoque.";
    }
}
