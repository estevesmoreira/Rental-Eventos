package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental_eventos.models.Endereco;
import com.senai.infoa.rental_eventos.repositories.EnderecoRepository;


@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Long contarEndereco(){
        return enderecoRepository.count();
    }
    public Endereco buscarEndereco(Integer id){
        return enderecoRepository.findById(id).get();
    }
    public List<Endereco> listarEndereco() {
        return enderecoRepository.findAll();
    }

    public Boolean deletarEndereco (Integer id){
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Endereco cadastrarEndereco( Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(Endereco endereco) {
    if (enderecoRepository.existsById(endereco.getId())) {
        return enderecoRepository.save(endereco);
    }

    return null;
    }
}
