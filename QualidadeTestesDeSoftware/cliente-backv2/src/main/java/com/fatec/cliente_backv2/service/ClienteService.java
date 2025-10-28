package com.fatec.cliente_backv2.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fatec.cliente_backv2.model.Cliente;
import com.fatec.cliente_backv2.model.ClienteDTO;

import jakarta.transaction.Transactional;

@Service
public class ClienteService implements IClienteService {
	Logger logger = LogManager.getLogger(this.getClass());
	final ClienteRepository clienteRepository;

	private IEnderecoService enderecoService;

	// Injeção de dependências pelo construtor
	public ClienteService(ClienteRepository clienteRepository, IEnderecoService enderecoService) {
		this.clienteRepository = clienteRepository;

		this.enderecoService = enderecoService;
	}

	@Override
	public List<Cliente> consultaTodos() {
		logger.info(">>>>>> clienteservico - consulta todos iniciado");
		return clienteRepository.findAll();
	}

	@Transactional
	public Cliente cadastrar(ClienteDTO clienteDTO) {
		// 1. Verifica se o cliente já existe com base no CPF
		if (clienteRepository.findByCpf(clienteDTO.cpf()).isPresent()) {
			logger.info(">>>>>> clienteservico - cliente já cadastrado: " + clienteDTO.cpf());
			// Lança uma exceção personalizada para CPF duplicado
			throw new IllegalArgumentException("Cliente com este CPF já cadastrado.");
		}

		// 2. Busca o endereço pelo CEP. Se não encontrar, lança exceção.
		Optional<String> endereco = enderecoService.obtemLogradouroPorCep(clienteDTO.cep());
		if (endereco.isEmpty()) {
			logger.info(">>>>>> Endereço não encontrado para o CEP: " + clienteDTO.cep());
			throw new IllegalArgumentException("Endereço não encontrado para o CEP informado.");
		}

		// 3. Converte DTO para entidade e persiste
		Cliente novoCliente = new Cliente();
		novoCliente.setCpf(clienteDTO.cpf());
		novoCliente.setNome(clienteDTO.nome());
		novoCliente.setCep(clienteDTO.cep());
		novoCliente.setComplemento(clienteDTO.complemento());
		novoCliente.setEmail(clienteDTO.email());
		novoCliente.setDataCadastro();
		novoCliente.setEndereco(endereco.get());

		logger.info(">>>>>> clienteservico - cliente salvo com sucesso no repositório.");
		return clienteRepository.save(novoCliente);
	}

	@Override
	public Optional<Cliente> consultarPorCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}

	@Override
	public Optional<Cliente> atualizar(String cpf, Cliente cliente) {
		return Optional.empty();
	}

	@Override
	public void excluir(String cpf) {
		Optional<Cliente> c = clienteRepository.findByCpf(cpf);
		if (c.isEmpty()) {
			throw new IllegalArgumentException("Cliente não encontrado.");
		} else {
			clienteRepository.deleteByCpf(cpf);

		}
	}

	@Override
	public Double estoqueImobilizado() {
		// TODO Auto-generated method stub
		return null;
	}

}
