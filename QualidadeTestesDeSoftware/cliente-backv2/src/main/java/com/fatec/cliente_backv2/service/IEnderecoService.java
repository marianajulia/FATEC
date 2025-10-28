package com.fatec.cliente_backv2.service;

import java.util.Optional;

public interface IEnderecoService {
	 public Optional<String> obtemLogradouroPorCep(String cep);
	 
}