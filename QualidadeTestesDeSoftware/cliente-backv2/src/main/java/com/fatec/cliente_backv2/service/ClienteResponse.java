package com.fatec.cliente_backv2.service;

import com.fatec.cliente_backv2.model.Cliente;

public class ClienteResponse {
    private boolean sucesso;
    private String mensagem;
    private Cliente cliente;

    public ClienteResponse(boolean sucesso, String mensagem, Cliente cliente) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.cliente = cliente;
    }

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
   
}