package com.br.deliver.controller;

import com.br.deliver.model.Conta;
import com.br.deliver.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/deliver")
public class DeliverController {

    @Autowired
    private DeliverService service;

    @GetMapping(path="/contas")
    public List<Conta> findContas() {
        return service.findContas();
    }

    @PostMapping(path="/insert/{nome}/{valor}/{vencimento}/{pagamento}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable("nome") String nome, @PathVariable("valor") BigDecimal valor,
                       @PathVariable("vencimento") @DateTimeFormat(pattern = "yyyy-MM-dd") Date vencimento,
                       @PathVariable("pagamento") @DateTimeFormat(pattern = "yyyy-MM-dd") Date pagamento) {
        service.addConta(nome, valor, vencimento, pagamento);
    }

}
