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


import com.senai.infoa.rental_eventos.models.Endereco;
import com.senai.infoa.rental_eventos.models.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
        @Autowired
        private EnderecoService enderecoService;


@GetMapping("/contar-enderecos")
public long contarEnderecos() {
    return enderecoService.contarEnderecos();
}

@GetMapping("/buscar-endereco/{id}")
public Endereco buscarEndereco(@PathVariable Integer id) {
    return enderecoService.buscarEndereco(id);
}

@GetMapping("/listar-enderecos")
public List<Endereco> listarEnderecos() {
    return enderecoService.listarEnderecos();
}

@DeleteMapping("/deletar-endereco/{id}")
public String deletarEndereco(@PathVariable Integer id) {
    if (enderecoService.deletarEndereco(id)) {
        return "Endereço removido com sucesso.";
    }
    return "Falha ao remover endereço.";
}

@PostMapping("/salvar-endereco")
public Usuario salvarEndereco(@RequestBody Usuario endereco) {
    return enderecoService.cadastrarEndereco(endereco);
}

@PutMapping("/atualizar-endereco/{id}")
public String atualizarEndereco(@PathVariable Integer id, @RequestBody Usuario endereco) {
    if (enderecoService.atualizarEndereco(id, endereco) != null) {
        return "Endereço atualizado com sucesso.";
    }
    return "Falha ao atualizar endereço.";
}

}