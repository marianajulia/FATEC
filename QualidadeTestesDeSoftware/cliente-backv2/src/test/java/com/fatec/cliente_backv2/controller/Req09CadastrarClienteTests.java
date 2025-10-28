package com.fatec.cliente_backv2.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fatec.cliente_backv2.controller.ApiResponse;
import com.fatec.cliente_backv2.model.Cliente;
import com.fatec.cliente_backv2.model.ClienteDTO;
import com.google.gson.Gson;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Req09CadastrarClienteTests {

	// 1. Constante para a URL Base
	private static final String URL_BASE = "/api/v1/clientes";
	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * Método para criar o HttpEntity com o corpo JSON.
	 */
	private HttpEntity<String> createPostRequest(ClienteDTO clienteDTO) {
		// Uso de Gson para converter o DTO em JSON
		String clienteJson = new Gson().toJson(clienteDTO);

		// Configuração dos cabeçalhos
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Cria a entidade HTTP
		return new HttpEntity<>(clienteJson, headers);
	}

	@Test
	void ct02_cadastroComDadosValidos_retornaStatus201ECadastroComSucesso() {
		// ********************************************************************
		// Given - dado que as informacoes de cliente sao validas
		// ********************************************************************

		// Caminho feliz
		ClienteDTO clienteNovo = new ClienteDTO("80983098000", "Jose da Silva", "01310-100", "123", "jose@gmail.com");

		// Empacota a requisicao HTTP
		HttpEntity<String> request = createPostRequest(clienteNovo);

		// Tipo de resposta esperado (para tipos genéricos)
		ParameterizedTypeReference<ApiResponse<Cliente>> responseType = new ParameterizedTypeReference<ApiResponse<Cliente>>() {
		};

		// ********************************************************************
		// When - quando confirmo o cadastro do cliente
		// ********************************************************************

		ResponseEntity<ApiResponse<Cliente>> response = restTemplate.exchange(URL_BASE, HttpMethod.POST, request,
				responseType);

		// ********************************************************************
		// Then - entao retorna os detalhes do cliente cadastrado
		// ********************************************************************

		// 1. Verifica o código de status HTTP
		assertEquals(HttpStatus.CREATED, response.getStatusCode(), "O status code deve ser 201 CREATED.");

		// Extrai o corpo da resposta
		ApiResponse<Cliente> apiResponse = response.getBody();

		// Verifica se o corpo não é nulo e se o dado está presente
		if (apiResponse == null || apiResponse.getData() == null) {
			throw new AssertionError("O corpo da resposta ou o objeto Cliente é nulo.");
		}

		Cliente clienteCadastrado = apiResponse.getData();

		// 2. Verifica os dados principais do Cliente
		assertEquals(clienteNovo.nome(), clienteCadastrado.getNome(), "O nome do cliente cadastrado deve ser o mesmo do DTO.");

		// 3. Verifica o campo preenchido pela API (vem de um serviço externo)
		assertEquals("Avenida Paulista", clienteCadastrado.getEndereco(), "O endereço deve ser preenchido corretamente via consulta de CEP.");

	}
}
