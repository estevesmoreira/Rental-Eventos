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

import com.senai.infoa.rental_eventos.models.Equipamento;
import com.senai.infoa.rental_eventos.services.EquipamentoService;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping("/contar-equipamentos")
    public long contarEquipamentos() {
        return equipamentoService.contarEquipamento();
    }

    @GetMapping("/buscar-equipamento/{id}")
    public Equipamento buscarEquipamento(@PathVariable Long id) {
        return equipamentoService.buscarEquipamento(id);
    }

    @GetMapping("/listar-equipamentos")
    public List<Equipamento> listarEquipamentos() {
        return equipamentoService.listarEquipamento();
    }

    @DeleteMapping("/deletar-equipamento/{id}")
    public String deletarEquipamento(@PathVariable Long id) {
        if (equipamentoService.deletarEquipamento(id)) {
            return "Equipamento removido com sucesso.";
        }
        return "Falha ao remover equipamento.";
    }

    @PostMapping("/salvar-equipamento")
    public Equipamento salvarEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoService.cadastrarEquipamento(equipamento);
    }

    @PutMapping("/atualizar-equipamento/{id}")
    public String atualizarEquipamento(
            @PathVariable Long id,
            @RequestBody Equipamento equipamento) {

        if (equipamentoService.atualizarEquipamento(id, equipamento) != null) {
            return "Equipamento atualizado com sucesso.";
        }

        return "Falha ao atualizar equipamento.";
    }
}
