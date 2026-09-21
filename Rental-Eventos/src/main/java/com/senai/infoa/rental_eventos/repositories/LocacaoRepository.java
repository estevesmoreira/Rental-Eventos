package com.senai.infoa.rental_eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infoa.rental_eventos.models.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    
}
