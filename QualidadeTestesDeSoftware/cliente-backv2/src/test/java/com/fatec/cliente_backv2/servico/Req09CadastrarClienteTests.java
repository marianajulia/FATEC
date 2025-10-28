package com.fatec.cliente_backv2.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.cliente_backv2.model.Cliente;
import com.fatec.cliente_backv2.model.ClienteDTO;
import com.fatec.cliente_backv2.service.IClienteService;
@SpringBootTest
class Req09CadastrarClienteTests {
	@Autowired
	IClienteService servico;
	ClienteDTO cliente;
	Cliente c = null;
	public void setup() {
		cliente = new ClienteDTO("80983098000", "Jose da Silva", "01310-100", "123","jose@gmail.com");
	}
	@Test
	void ct01_quando_dados_validos_cliente_cadastrado_com_sucesso() {
		// Dado - que o cpf do cliente nao esta cadastrado
		setup();
		//Quando confirmo o cadastro
		c = servico.cadastrar(cliente);
		// Entao - as informacoes do cliente ficam disponiveis para consulta
		assertNotNull(c);
		assertEquals ("Avenida Paulista", c.getEndereco() );
	}
}
