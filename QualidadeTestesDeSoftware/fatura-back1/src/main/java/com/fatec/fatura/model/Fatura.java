package com.fatec.fatura.model;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 11)
	private String cpf;

	@Column(nullable = false)
	private LocalDate dataEmissao;

	@Column(nullable = false)
	private LocalDate dataVencimento;

	@Column(nullable = false, length = 100)
	private String servicoContratado;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;

	@Column(nullable = false)
	private boolean cancelada;

	@Column(nullable = false)
	private boolean paga;
	
	public Fatura() {
	}

	public Fatura(String cpf, LocalDate dataVencimento, String servicoContratado, String valor) {
		setCpf(cpf);
		setDataVencimento(dataVencimento);
		setServicoContratado(servicoContratado);
		setValor(valor);
		this.dataEmissao = LocalDate.now();
		setCancelada(false);
		setPaga(false);
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (isValido(cpf)) {
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("CPF invalido");
		}
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		if (dataVencimento != null && (!isDomingo(dataVencimento)) && (!isAnteriorDataAtual(dataVencimento))) {
			this.dataVencimento = dataVencimento;
			System.out.println(">>>>>> data vencimento valida => " + dataVencimento);

		} else {
			throw new IllegalArgumentException(
					"Data de vencimento: formato invalido ou domingo ou menor que data atual");
		}

	}

	public String getServicoContratado() {
		return servicoContratado;
	}

	public void setServicoContratado(String servico) {
		if (servico.isEmpty()) {
			throw new IllegalArgumentException("Descricao do servico invalido");
		} else {
			this.servicoContratado = servico;
		}
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(String v) {

		try {
			BigDecimal temp = new BigDecimal(v);

			// BigDecimal val = new BigDecimal(v.replace(",", "."));
			this.valor = temp;
			if (valor.compareTo(BigDecimal.ZERO) <= 0) {
				throw new IllegalArgumentException("O valor da fatura deve ser maior que zero.");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Valor da fatura invalido");
		}
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean c) {
		this.cancelada = c;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean p) {
		this.paga = p;
	}

	public boolean isDomingo(LocalDate date) {
		return date.getDayOfWeek() == DayOfWeek.SUNDAY;
	}

	public boolean isAnteriorDataAtual(LocalDate date) {
		return date.isBefore(LocalDate.now());
	}

	private boolean isValido(String cpf) {
		if (cpf == null) return false;
		// Remover caracteres não numéricos
		cpf = cpf.replace(".", "").replace("-", "");

		// Verifica se o CPF tem 11 dígitos
		if (cpf.length() != 11) {
			return false;
		}

		// Verifica se todos os dígitos são iguais (ex: 111.111.111-11)
		if (cpf.matches("(\\d)\\1{10}")) {
			return false;
		}

		// 1º dígito verificador
		try {
			int soma = 0;
			for (int i = 0; i < 9; i++) {
				soma += (cpf.charAt(i) - '0') * (10 - i);
			}
			int digito1 = 11 - (soma % 11);
			if (digito1 > 9) {
				digito1 = 0;
			}
			if (digito1 != (cpf.charAt(9) - '0')) {
				return false;
			}

			// 2º dígito verificador
			soma = 0;
			for (int i = 0; i < 10; i++) {
				soma += (cpf.charAt(i) - '0') * (11 - i);
			}
			int digito2 = 11 - (soma % 11);
			if (digito2 > 9) {
				digito2 = 0;
			}
			if (digito2 != (cpf.charAt(10) - '0')) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}