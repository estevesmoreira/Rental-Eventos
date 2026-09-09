package com.senai.infoa.rental_eventos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

    @Column(name = "forma_pagamento")
    private Integer formaPagamento;

    @Column(name = "status_locacao")
    private Integer statusLocacao;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    /*
     * 
     * @ManyToMany
     * 
     * @JoinTable(name = "agendamento_tratamento",
     * joinColumns = @JoinColumn(name = "agendamento_id", referencedColumnName =
     * "id"),
     * inverseJoinColumns = @JoinColumn(name = "tratamento_id", referencedColumnName
     * = "id"))
     * public Set<Tratamentos> Tratamentos;
     * 
     * 
     * @ManyToOne
     * 
     * @JoinColumn(name = "paciente_id")
     * 
     * @OneToMany(mappedBy = "locacao")
     * private List<Locacao> locacoes;
     * 
     */
    public Locacao() {
    }

    public Locacao(Integer valorTotal, Integer dataLocacao, Integer dataDevolucao, Integer quantidadeEquipamentos,
            Integer formaPagamento, Integer statusLocacao, Equipamento equipamento) {
        this.valorTotal = valorTotal;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.formaPagamento = formaPagamento;
        this.statusLocacao = statusLocacao;
        this.equipamento = equipamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

}
