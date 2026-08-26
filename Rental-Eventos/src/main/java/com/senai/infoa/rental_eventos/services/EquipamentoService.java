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
    public Equipamento buscarEquipamento(Integer id){
        return equipamentoRepository.findById(id).get();
    }
    public List<Equipamento> listarEquipamento() {
        return equipamentoRepository.findAll();
    }

    public Boolean deletarEquipamento (Integer id){
        if (equipamentoRepository.existsById(id)) {
            equipamentoRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Equipamento cadastrarEquipamento( Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }
}

