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
    private String valorTotal;

    @Column(name = "data_locacao")
    private String dataLocacao;

    @Column(name = "data_devolucao")
    private String dataDevolucao;

    @Column(name = "forma_pagamento")
    private String formaPagamento;

    @Column(name = "status_locacao")
    private String statusLocacao;

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

    public Locacao(String valorTotal, String dataLocacao, String dataDevolucao, String quantidadeEquipamentos,
            String formaPagamento, String statusLocacao) {
        this.valorTotal = valorTotal;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.formaPagamento = formaPagamento;
        this.statusLocacao = statusLocacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(String statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

}
