package com.fatec.cliente_backv2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cliente_backv2.model.Cliente;
import com.fatec.cliente_backv2.model.ClienteDTO;
import com.fatec.cliente_backv2.service.ClienteResponse;
import com.fatec.cliente_backv2.service.IClienteService;

@CrossOrigin("*") // desabilita o cors do spring security
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	Logger logger = LogManager.getLogger(this.getClass());

	IClienteService clienteService;

	//injecao da dependencia automatica pelo metodo construtor
	public ClienteController(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	/*
	 * As informacoes do cliente sao recebidas em um arquivo DTO para o uso do
	 * objeto POJO na assinatura do metodo.
	 */
	@PostMapping
    public ResponseEntity<ApiResponse<Cliente>> saveCliente(@RequestBody ClienteDTO clienteDTO) {
        logger.info(">>>>>> apicontroller cadastro de cliente iniciado...");

        try {
            Cliente novoCliente = clienteService.cadastrar(clienteDTO);
            ApiResponse<Cliente> response = new ApiResponse<>(novoCliente, "Cliente cadastrado com sucesso.");
            logger.info(">>>>>> apicontroller cliente cadastrado");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
            
        } catch (IllegalArgumentException e) {
            // Captura exceção de CEP inválido
            ApiResponse<Cliente> response = new ApiResponse<>(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            
        }  catch (Exception e) {
            // Captura qualquer outro erro inesperado
            ApiResponse<Cliente> response = new ApiResponse<>("Erro inesperado ao cadastrar cliente.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<Cliente>>> getAll() {
		logger.info(">>>>>> api cliente controller consulta todos iniciado...");
		List<Cliente> clientes = clienteService.consultaTodos();
		ApiResponse<List<Cliente>> response = new ApiResponse<>(clientes, "Lista de clientes cadastrados");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	/*
	 * O cpf eh enviado no arquivo json clientedto com os outros atributos em branco
	 * para nao trafegar com o cpf na url
	 */
	@PostMapping("/cpf")
	public ResponseEntity<ApiResponse<Cliente>> getCliente(@RequestBody ClienteDTO cliente) {
		try {
			Optional<Cliente> c = clienteService.consultarPorCpf(cliente.cpf());
			logger.info(">>>>>> apicontroller getCliente consulta servico iniciado");
			if (c.isPresent()) {
				ApiResponse<Cliente> response = new ApiResponse<>(c.get(), "Cliente encontrado com sucesso.");
				return ResponseEntity.status(HttpStatus.OK).body(response);
			} else {
				ApiResponse<Cliente> response = new ApiResponse<>("CPF não encontrado.");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (Exception e) {
			logger.info(">>>>>>apicontroller getCliente erro nao esperado => " + e.getMessage());
			ApiResponse<Cliente> response = new ApiResponse<>(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
}