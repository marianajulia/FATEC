package com.fatec.cliente_backv2.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fatec.cliente_backv2.model.Cliente;
import com.fatec.cliente_backv2.service.ClienteRepository;
@DataJpaTest
class Req09CadastrarClienteTests {

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
	public String dataAtual() {
		LocalDate dataAtual = LocalDate.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataAtual.format(pattern);
		
	}
	@Test
	void ct01_quando_dados_validos_cliente_cadastrado_com_sucesso() {
		// Dado - que o cpf do cliente nao esta cadastrado
		setup();
		// Quando - confirmo a operacao de cadastro
		clienteRepository.save(cliente);
		// Entao - as informacoes do cliente ficam disponiveis para consulta
		assertEquals(1, clienteRepository.count());
		assertEquals(dataAtual(), cliente.getDataCadastro());
	}
	@Test
	void ct02_quando_dados_invalidos_retorna_invalido() {
		try {
			// Dado - que o cpf esta vazio
			// Quando - confirmo a operacao de cadastro
			cliente = new Cliente();
			cliente.setCpf("");
		} catch (Exception e) {
			// Entao - retorna cpf invalido
			assertEquals("CPF invalido", e.getMessage());
		}
	}
	@Test
	void ct03_quando_cpf_ja_cadastrado_retorna_invalido() {
		try {
			// Dado - que o cpf ja esta cadastrado
			setup();
			// Quando - confirmo a operacao de cadastro
			clienteRepository.save(cliente);
		} catch (Exception e) {
			// Entao - retorna cpf invalido
			assertEquals("CPF invalido", e.getMessage());
		}
	}

	@Test
    void ct04_quando_cpf_invalido_retorna_erro() {
        try {
            // Dado - que o cpf ja esta cadastrado
            setup();
            cliente.setCpf("8098309800");
            // Quando - confirmo a operacao de cadastro
            clienteRepository.save(cliente);
        } catch (Exception e) {
            // Entao - retorna cpf invalido
            assertEquals("CPF invalido", e.getMessage());
        }
    }

		@Test
    void ct05_quando_cpf_invalido_retorna_erro() {
        try {
            // Dado - que o cpf ja esta cadastrado
            setup();
            cliente.setCpf("809830980000");
            // Quando - confirmo a operacao de cadastro
            clienteRepository.save(cliente);
        } catch (Exception e) {
            // Entao - retorna cpf invalido
            assertEquals("CPF invalido", e.getMessage());
        }
    }

@Test
    void ct06_quando_cpf_possui_apenas_1_caractere_retorna_erro() {
        try {
            // Dado - que o cpf é inválido
            setup();
            cliente.setCpf("8");
            // Quando - confirmo a operacao de cadastro
            clienteRepository.save(cliente);
        } catch (Exception e) {
            // Entao - retorna cpf invalido
            assertEquals("CPF invalido", e.getMessage());
        }
    }

		@Test
    void ct07_quando_cpf_possui_apenas_1_caractere_retorna_erro() {
        try {
            // Dado - que o cpf é inválido
            setup();
            cliente.setCpf("8");
            // Quando - confirmo a operacao de cadastro
            fail("Deveria falhar, não deveria aceitar CPF invalido");
        } catch (Exception e) {
            // Entao - retorna cpf invalido
            assertEquals("CPF invalido", e.getMessage());
        }
    }

		@Test
    void ct08_quando_nome_invalido_retorna_erro() {
        try {
            // Dado - que o cpf é inválido
            setup();
            cliente.setNome(" ");
            // Quando - confirmo a operacao de cadastro
            fail("Deveria falhar, não deveria aceitar nome invalido");
        } catch (Exception e) {
            // Entao - retorna cpf invalido
            assertEquals("O nome não deve estar em branco", e.getMessage());
        }
    }


}


