package com.senai.infoa.rental_eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /*
     * @PostMapping("/salvar-locatario")
     * public Locatario salvarLocatario(@RequestBody Locatario locatario) {
     * return locatarioService.cadastrarLocatario(locatario);
     * }
     * 
     * @PutMapping("/atualizar-locatario/{id}")
     * public String atualizarLocatario(
     * 
     * @PathVariable Long id,
     * 
     * @RequestBody Locatario locatario) {
     * 
     * if (locatarioService.atualizarLocatario(id, locatario) != null) {
     * return "Locatário atualizado com sucesso.";
     * }
     * 
     * return "Falha ao atualizar locatário.";
     * }
     */
}
