package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental_eventos.models.Locacao;
import com.senai.infoa.rental_eventos.repositories.LocacaoRepository;


@Service
public class LocacaoService {
    @Autowired
    private LocacaoRepository locacaoRepository;

    public Long contarLocacao(){
        return locacaoRepository.count();
    }
    public Locacao buscarLocacao(Integer id){
        return locacaoRepository.findById(id).get();
    }
    public List<Locacao> listarLocacao() {
        return locacaoRepository.findAll();
    }

    public Boolean deletarLocacao (Integer id){
        if (locacaoRepository.existsById(id)) {
            locacaoRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Locacao cadastrarLocacao( Locacao locacao) {
        return locacaoRepository.save(locacao);
    }
}
