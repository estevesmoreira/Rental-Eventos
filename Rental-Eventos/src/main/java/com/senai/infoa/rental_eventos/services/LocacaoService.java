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
    public Locacao buscarLocacao(Long id){
        return locacaoRepository.findById(id).get();
    }
    public List<Locacao> listarLocacao() {
        return locacaoRepository.findAll();
    }

    public Boolean deletarLocacao (Long id){
        if (locacaoRepository.existsById(id)) {
            locacaoRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Locacao cadastrarLocacao( Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    public Locacao atualizarLocacao(Long id, Locacao locacao) {
    Locacao locacaoRecuperada = buscarLocacao(id);

        if(locacaoRecuperada != null) {
        locacaoRecuperada.setId(id);
        
        if (locacao.getValorTotal() != null) {
            locacaoRecuperada.setValorTotal(locacao.getValorTotal());
        }

        if (locacao.getDataLocacao() != null) {
            locacaoRecuperada.setDataLocacao(locacao.getDataLocacao());
        }

         if (locacao.getDataDevolucao() != null) {
            locacaoRecuperada.setDataDevolucao(locacao.getDataDevolucao());
        }

        if (locacao.getFormaPagamento() != null) {
            locacaoRecuperada.setFormaPagamento(locacao.getFormaPagamento());
        }

        if (locacao.getStatusLocacao() != null) {
            locacaoRecuperada.setStatusLocacao(locacao.getStatusLocacao());
        }

        if (locacao.getEquipamento() != null) {
            locacaoRecuperada.setEquipamento(locacao.getEquipamento());
        }
        
        return locacaoRepository.save(locacaoRecuperada);
            } 
        return null;
        }
} 


