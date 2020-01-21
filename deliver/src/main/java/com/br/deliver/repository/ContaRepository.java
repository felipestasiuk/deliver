package com.br.deliver.repository;

import com.br.deliver.model.Conta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository<Conta, Long> {
    Conta findById(long id);
}
