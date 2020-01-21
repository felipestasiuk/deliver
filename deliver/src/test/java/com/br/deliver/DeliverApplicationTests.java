package com.br.deliver;

import com.br.deliver.model.Conta;
import com.br.deliver.repository.ContaRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
class DeliverApplicationTests {

	@Autowired
	private ContaRepository contaRepository;

	@Test
	void contextLoads() {
		Conta contaTeste = contaRepository
				.save(new Conta("Luz", BigDecimal.valueOf(90.50), BigDecimal.valueOf(90.50), "sem juros", new Date(), new Date()));
		Conta contaEncontrada = contaRepository.findById(contaTeste.getId());

		Assert.assertNotNull(contaEncontrada);
		Assert.assertEquals(contaTeste.getNome(), contaEncontrada.getNome());
	}

}
