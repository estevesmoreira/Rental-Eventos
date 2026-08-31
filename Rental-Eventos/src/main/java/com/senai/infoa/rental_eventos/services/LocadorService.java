package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental_eventos.models.Locador;
import com.senai.infoa.rental_eventos.repositories.LocadorRepository;


@Service
public class LocadorService {
    @Autowired
    private LocadorRepository locadorRepository;

    public Long contarLocador(){
        return locadorRepository.count();
    }
    public Locador buscarLocador(Integer id){
        return locadorRepository.findById(id).get();
    }
    public List<Locador> listarLocador() {
        return locadorRepository.findAll();
    }

    public Boolean deletarLocador (Integer id){
        if (locadorRepository.existsById(id)) {
            locadorRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Locador cadastrarLocador( Locador locador) {
        return locadorRepository.save(locador);
    }

    public Locador atualizarLocador(Locador locador) {
    if (locadorRepository.existsById(locador.getId())) {
        return locadorRepository.save(locador);
    }

    return null;
    }
}
