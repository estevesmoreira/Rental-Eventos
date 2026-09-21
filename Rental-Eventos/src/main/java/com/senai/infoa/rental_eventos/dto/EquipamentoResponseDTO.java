package com.senai.infoa.rental_eventos.dto;

import com.senai.infoa.rental_eventos.enuns.CategoriaEquipamento;

public record EquipamentoResponseDTO(
        Long id,
        String nome,
        String marca,
        String modelo,
        CategoriaEquipamento categoria,
        String potencia,
        String material,
        Float peso,
        String dimensoes,
        String cor,
        Integer preco,
        Integer quantidadeMinima
) {
}