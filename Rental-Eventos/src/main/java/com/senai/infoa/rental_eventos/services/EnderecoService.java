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
    public Endereco buscarEndereco(Long id){
        return enderecoRepository.findById(id).get();
    }
    public List<Endereco> listarEndereco() {
        return enderecoRepository.findAll();
    }

    public Boolean deletarEndereco (Long id){
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return true;
        }
            return false;
        }
    
    public Endereco cadastrarEndereco( Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

  public Endereco atualizarEndereco(Long id, Endereco endereco) {
    Endereco enderecoRecuperado = buscarEndereco(id);

    if (enderecoRecuperado != null) {
        enderecoRecuperado.setId(id);

        if (endereco.getLogradouro() != null) {
            enderecoRecuperado.setLogradouro(endereco.getLogradouro());
        }

        if (endereco.getBairro() != null) {
            enderecoRecuperado.setBairro(endereco.getBairro());
        }

        if (endereco.getCidade() != null) {
            enderecoRecuperado.setCidade(endereco.getCidade());
        }

         if (endereco.getEstado() != null) {
            enderecoRecuperado.setEstado(endereco.getEstado());
        }

        if (endereco.getCep() != null) {
            enderecoRecuperado.setCep(endereco.getCep());
        }

        if (endereco.getNumero() != null) {
            enderecoRecuperado.setNumero(endereco.getNumero());
        }
        
    
        return enderecoRepository.save(enderecoRecuperado);
    }

    return null;
}

}
