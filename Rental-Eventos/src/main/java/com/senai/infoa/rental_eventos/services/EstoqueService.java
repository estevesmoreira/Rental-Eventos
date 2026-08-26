package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental_eventos.models.Estoque;
import com.senai.infoa.rental_eventos.repositories.EstoqueRepository;


@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Long contarEstoque(){
        return estoqueRepository.count();
    }
    public Estoque buscarEstoque(Integer id){
        return estoqueRepository.findById(id).get();
    }
    public List<Estoque> listarEstoque() {
        return estoqueRepository.findAll();
    }

    public Boolean deletarEstoque (Integer id){
        if (estoqueRepository.existsById(id)) {
            estoqueRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Estoque cadastrarEstoque( Estoque estoque) {
        return estoqueRepository.save(estoque);
    }
}


