package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental_eventos.models.Locacao;
import com.senai.infoa.rental_eventos.models.Locador;
import com.senai.infoa.rental_eventos.repositories.LocadorRepository;


@Service
public class LocadorService {
    @Autowired
    private LocadorRepository locadorRepository;

    public Long contarLocador(){
        return locadorRepository.count();
    }
    public Locador buscarLocador(Long id){
        return locadorRepository.findById(id).get();
    }
    public List<Locador> listarLocador() {
        return locadorRepository.findAll();
    }

    public Boolean deletarLocador (Long id){
        if (locadorRepository.existsById(id)) {
            locadorRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Locador cadastrarLocador( Locador locador) {
        return locadorRepository.save(locador);
    }

    public Locador atualizarLocador(Long id, Locador locador) {
    Locador locadorRecuperado = buscarLocador(id);

        if(locadorRecuperado != null) {
        locadorRecuperado.setId(id);
        
        if (locador.getNome() != null) {
            locadorRecuperado.setNome(locador.getNome());
        }

        if (locador.getCpf() != null) {
            locadorRecuperado.setCpf(locador.getCpf());
        }

         if (locador.getEmail() != null) {
            locadorRecuperado.setEmail(locador.getEmail());
        }

        if (locador.getTelefone() != null) {
            locadorRecuperado.setTelefone(locador.getTelefone());
        }

        if (locador.getEnderecos() != null) {
            locadorRecuperado.setEnderecos(locador.getEnderecos());
        }
        
        return locadorRepository.save(locadorRecuperado);
            } 
        return null;
        }
}
