package com.senai.infoa.rental_eventos.dto;

import com.senai.infoa.rental_eventos.enuns.CategoriaEquipamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record EquipamentoRequestDTO(
        @NotBlank
        String nome,
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotNull
        CategoriaEquipamento categoria,
        String potencia,
        String material,
        @PositiveOrZero
        Float peso,
        String dimensoes,
        String cor,
        @PositiveOrZero
        Integer preco,
        @NotNull
        @PositiveOrZero
        Integer quantidadeMinima
        ) {

}
