package com.br.deliver.DAO;

import com.br.deliver.model.Conta;
import com.br.deliver.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaDAO {

    @Autowired
    private ContaRepository repository;

    public Iterable<Conta> findAll() {
        return repository.findAll();
    }

    public Conta insert(Conta conta) {
        return repository.save(conta);
    }

}
