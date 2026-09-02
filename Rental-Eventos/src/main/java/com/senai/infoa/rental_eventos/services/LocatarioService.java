package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental_eventos.models.Locacao;
import com.senai.infoa.rental_eventos.models.Locatario;
import com.senai.infoa.rental_eventos.repositories.LocatarioRepository;


@Service
public class LocatarioService {
    @Autowired
    private LocatarioRepository locatarioRepository;

    public Long contarLocatario(){
        return locatarioRepository.count();
    }
    public Locatario buscarLocatario(Long id){
        return locatarioRepository.findById(id).get();
    }
    public List<Locatario> listarLocatario() {
        return locatarioRepository.findAll();
    }

    public Boolean deletarLocatario (Long id){
        if (locatarioRepository.existsById(id)) {
            locatarioRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Locatario cadastrarLocatario( Locatario locatario) {
        return locatarioRepository.save(locatario);
    }

    public Locatario atualizarLocatario(Long id, Locatario locatario) {
    Locatario locatarioRecuperado = buscarLocatario(id);

        if(locatarioRecuperado != null) {
        locatarioRecuperado.setId(id);
        
        if (locatario.getNome() != null) {
            locatarioRecuperado.setNome(locatario.getNome());
        }

        if (locatario.getCpf() != null) {
            locatarioRecuperado.setCpf(locatario.getCpf());
        }

         if (locatario.getEmail() != null) {
            locatarioRecuperado.setEmail(locatario.getEmail());
        }

        if (locatario.getTelefone() != null) {
            locatarioRecuperado.setTelefone(locatario.getTelefone());
        }

        if (locatario.getEnderecos() != null) {
            locatarioRecuperado.setEnderecos(locatario.getEnderecos());
        }
        
        return locatarioRepository.save(locatarioRecuperado);
            } 
        return null;
        }

}

