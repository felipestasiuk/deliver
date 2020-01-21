package com.br.deliver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="conta")
@Data
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="nome", length=50, nullable=false)
    private String nome;

    @Column(name="valor",nullable=false)
    private BigDecimal valor;

    @Column(name="juros_dia")
    private BigDecimal jurosDia;

    @Column(name="calculo", length=20)
    private String calculo;

    @Column(name="vencimento", nullable=false)
    private Date dataVencimento;

    @Column(name="pagamento")
    private Date dataPagamento;

    public Conta(String nome, BigDecimal valor, Date dataVencimento, Date dataPagamento) {
        this.nome = nome;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Conta(String nome, BigDecimal valor, BigDecimal jurosDia, String calculo, Date dataVencimento, Date dataPagamento) {
        this.nome = nome;
        this.valor = valor;
        this.jurosDia = jurosDia;
        this.calculo = calculo;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
