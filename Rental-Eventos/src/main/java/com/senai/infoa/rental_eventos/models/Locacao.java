package com.senai.infoa.rental_eventos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
    
@Entity
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "valor_total")
    private Integer valorTotal;

    @Column(name = "data_locacao")
    private Integer dataLocacao;

    @Column(name = "data_devolucao")
    private Integer dataDevolucao;

    @Column(name = "quantidade_equipamentos")
    private Integer quantidadeEquipamentos;

    @Column(name = "forma_pagamento")
    private Integer formaPagamento;

    @Column(name = "status_locacao")
    private Integer statusLocacao;
    
    /*
    @OneToMany
    @JoinColumn(name = "agendamento_medico")
    public Set<Medicos> medico; //se status = true e não tiver outro médico

    @OneToMany
    @JoinColumn(name = "agendamento_medico")
    public Set<Pacientes> pacientes;

    @ManyToMany
    @JoinTable(name = "agendamento_tratamento",
        joinColumns = @JoinColumn(name = "agendamento_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "tratamento_id", referencedColumnName = "id"))
    public Set<Tratamentos> Tratamentos;
    */

    public Locacao() {
    }

    public Locacao(Integer valorTotal, Integer dataLocacao, Integer dataDevolucao, Integer quantidadeEquipamentos,
            Integer formaPagamento, Integer statusLocacao) {
        this.valorTotal = valorTotal;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.quantidadeEquipamentos = quantidadeEquipamentos;
        this.formaPagamento = formaPagamento;
        this.statusLocacao = statusLocacao;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Integer dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Integer getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Integer dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getQuantidadeEquipamentos() {
        return quantidadeEquipamentos;
    }

    public void setQuantidadeEquipamentos(Integer quantidadeEquipamentos) {
        this.quantidadeEquipamentos = quantidadeEquipamentos;
    }

    public Integer getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getStatusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(Integer statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    



    
}
