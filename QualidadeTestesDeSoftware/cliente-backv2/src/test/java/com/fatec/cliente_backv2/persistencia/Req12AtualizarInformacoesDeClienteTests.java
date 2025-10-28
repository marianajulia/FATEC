package com.fatec.cliente_backv2.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fatec.cliente_backv2.model.Cliente;
import com.fatec.cliente_backv2.service.ClienteRepository;
@DataJpaTest
class Req12AtualizarInformacoesDeClienteTests {
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
	void ct01_quando_cliente_modificado_retorna_informacoes_atualizadas() {
		//Dado que as informacoes de cliente estao cadastradas
		setup();
		//Quando atuliazo as informacoes
		cliente.setNome("Carlos Xavier");
		clienteRepository.save(cliente);
		//Entao as informacoes atualizadas ficam disponiveis para consulta
		Optional<Cliente> clienteAtualizado = clienteRepository.findByCpf("80983098000");
		assertEquals ("Carlos Xavier",clienteAtualizado.get().getNome());
	}
}
