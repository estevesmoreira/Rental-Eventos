package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental_eventos.models.Locatario;
import com.senai.infoa.rental_eventos.repositories.LocatarioRepository;


@Service
public class LocatarioService {
    @Autowired
    private LocatarioRepository locatarioRepository;

    public Long contarLocatario(){
        return locatarioRepository.count();
    }
    public Locatario buscarLocatario(Integer id){
        return locatarioRepository.findById(id).get();
    }
    public List<Locatario> listarLocatario() {
        return locatarioRepository.findAll();
    }

    public Boolean deletarLocatario (Integer id){
        if (locatarioRepository.existsById(id)) {
            locatarioRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Locatario cadastrarLocatario( Locatario locatario) {
        return locatarioRepository.save(locatario);
    }

    public Locatario atualizarLocatario(Locatario locatario) {
    if (locatarioRepository.existsById(locatario.getId())) {
        return locatarioRepository.save(locatario);
    }

    return null;
    }

}

