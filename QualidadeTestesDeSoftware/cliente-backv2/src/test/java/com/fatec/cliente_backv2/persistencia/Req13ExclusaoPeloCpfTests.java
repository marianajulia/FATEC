package com.fatec.cliente_backv2.persistencia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fatec.cliente_backv2.model.Cliente;
import com.fatec.cliente_backv2.service.ClienteRepository;
@DataJpaTest
class Req13ExclusaoPeloCpfTests {
	private Cliente cliente;
	@Autowired
	private ClienteRepository clienteRepository;
	public void setup() {
		cliente = new Cliente();
		cliente.setCpf("80983098000");
		cliente.setNome("Jose da Silva");
		cliente.setCep("01310-100");
		cliente.setEndereco("Av. Paulista");
		cliente.setComplemento("123");
		cliente.setEmail("jose@gmail.com");
		cliente.setDataCadastro();
		clienteRepository.save(cliente);
	}
	@Test
	void ct01_quando_cpf_cadastrado_exclui_cliente_com_sucesso() {
		//Dado que as informacoes de cliente estao cadastradas
		setup();
		Optional<Cliente> c = clienteRepository.findByCpf("80983098000");
		assertTrue (c.isPresent());
		//Quando confirma e exclusão
		clienteRepository.deleteByCpf("80983098000");
		c = clienteRepository.findByCpf("80983098000");
		//Entao - retorna vazio
		assertTrue (c.isEmpty());
	}

}
