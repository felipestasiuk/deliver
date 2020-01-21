package com.br.deliver.service;

import com.br.deliver.DAO.ContaDAO;
import com.br.deliver.model.Conta;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class DeliverService {

    @Autowired
    private ContaDAO dao;

    public List<Conta> findContas() {
        Iterable<Conta> contaIterable = dao.findAll();
        return IterableUtils.toList(contaIterable);
    }

    public void addConta(String nome, BigDecimal valor, Date vencimento, Date pagamento) {
        Conta conta = new Conta(nome, valor, vencimento, pagamento);
        populaJurosDia(conta);
        conta = dao.insert(conta);
    }

    private void populaJurosDia(Conta conta) {
        Long dias = ChronoUnit.DAYS.between(conta.getDataVencimento().toInstant(), conta.getDataPagamento().toInstant());

        BigDecimal valorJuros = BigDecimal.ZERO;
        String formaCalculo = "Sem juros";

        if(dias>1L && dias<=3L) {
            valorJuros = calculaJuros(conta.getValor(), 2, 0.1, dias);
            formaCalculo = "até 3 dias";
        } else if(dias>3L && dias <= 5L) {
            valorJuros = calculaJuros(conta.getValor(), 3, 0.2, dias);
            formaCalculo = "superior a 3 dias";
        } else if (dias>5L) {
            valorJuros = calculaJuros(conta.getValor(), 5, 0.3, dias);
            formaCalculo = "superior a 5 dias";
        }
        conta.setJurosDia(valorJuros);
        conta.setCalculo(formaCalculo);
    }

    private BigDecimal calculaJuros(BigDecimal valor, Integer porcentagem, Double juros, Long dias) {
        BigDecimal valorPorcentagem = (valor.multiply(BigDecimal.valueOf(porcentagem.longValue()))).divide(BigDecimal.valueOf(100L));
        BigDecimal valorMulta = (valor.multiply(BigDecimal.valueOf(juros))).divide(BigDecimal.valueOf(100L));
        return valor.add(valorPorcentagem).add(valorMulta.multiply(BigDecimal.valueOf(dias)));
    }

}
