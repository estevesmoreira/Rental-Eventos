package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental_eventos.models.Equipamento;
import com.senai.infoa.rental_eventos.repositories.EquipamentoRepository;


@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Long contarEquipamento(){
        return equipamentoRepository.count();
    }
    public Equipamento buscarEquipamento(Long id){
        return equipamentoRepository.findById(id).get();
    }
    public List<Equipamento> listarEquipamento() {
        return equipamentoRepository.findAll();
    }

    public Boolean deletarEquipamento (Long id){
        if (equipamentoRepository.existsById(id)) {
            equipamentoRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Equipamento cadastrarEquipamento( Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento atualizarEquipamento(Long id, Equipamento equipamento) {
    Equipamento equipamentoRecuperado = buscarEquipamento(id);

        if(equipamentoRecuperado != null) {
        equipamentoRecuperado.setId(id);

        if (equipamento.getNome() != null) {
            equipamentoRecuperado.setNome(equipamento.getNome());
        }

        if (equipamento.getPreco() != null) {
            equipamentoRecuperado.setPreco(equipamento.getPreco());
        }

        if (equipamento.getCategoria() != null) {
            equipamentoRecuperado.setCategoria(equipamento.getCategoria());
        }
        
        if (equipamento.getPeso() != null) {
            equipamentoRecuperado.setPeso(equipamento.getPeso());
        }
        return equipamentoRepository.save(equipamentoRecuperado);
            } 
        return null; 
        } 
    }

