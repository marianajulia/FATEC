package com.fatec.cliente_backv2.service;

import java.util.List;
import java.util.Optional;

import com.fatec.cliente_backv2.model.Cliente;
import com.fatec.cliente_backv2.model.ClienteDTO;

public interface IClienteService {
	public List<Cliente> consultaTodos();
	public Cliente cadastrar(ClienteDTO cliente);
	public Optional<Cliente> consultarPorCpf(String cpf);
	public Optional<Cliente> atualizar(String cpf, Cliente cliente);
	public void excluir(String cpf);
	public Double estoqueImobilizado();
}
