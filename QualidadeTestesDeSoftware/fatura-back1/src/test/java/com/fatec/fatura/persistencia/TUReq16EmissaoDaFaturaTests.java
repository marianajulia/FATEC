package com.fatec.fatura.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.fatec.fatura.model.Fatura;

class TUReq16EmissaoDaFaturaTests {
	Logger logger = LogManager.getLogger(this.getClass());
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Fatura fatura;

	@Test
	void ct01_quando_dados_validos_fatura_nao_eh_nulo() {
		try {
			// dado que as informacoes de fatura sao validas
			// quando confirmo a fatura
			LocalDate dataVencimento = LocalDate.parse("02/10/2026", formatter);
			fatura = new Fatura("39086360009", dataVencimento, "moveis planejados", "1000.50");
			// entao fatura é registrada com data de emisssao igual a data de hoje
			assertNotNull(fatura);
			assertFalse(fatura.isCancelada());
			assertFalse(fatura.isPaga());
		} catch (Exception e) {
			logger.info(">>>>>> ct01 - nao deveria falhar => " + e.getMessage());
			fail("nao deveria falhar fatura valida");

		}

	}
	@Test
	void ct02_uando_cpf_invalido_retorna_mensagem_de_erro() {
		try {
			// dado que as informacoes de fatura sao validas
			// quando confirmo a fatura
			LocalDate dataVencimento = LocalDate.parse("02/10/2026", formatter);
			fatura = new Fatura(null, dataVencimento, "moveis planejados", "1000.50");
			// entao fatura é registrada com data de emisssao igual a data de hoje
			
		} catch (Exception e) {
			logger.info(">>>>>> ct01 - nao deveria falhar => " + e.getMessage());
			assertEquals("CPF invalido", e.getMessage());

		}

	}

	@Test
	void ct03_quando_cpf_invalido_branco_retorna_mensagem_de_erro() {
		try {
			// dado que as informacoes de fatura sao validas
			// quando confirmo a fatura
			LocalDate dataVencimento = LocalDate.parse("02/10/2026", formatter);
			fatura = new Fatura(" ", dataVencimento, "moveis planejados", "1000.50");
			// entao fatura é registrada com data de emisssao igual a data de hoje
			fail("deveria falhar fatura invalida");
		} catch (Exception e) {
			logger.info(">>>>>> ct03 - fatura invalida => " + e.getMessage());
			assertEquals("CPF invalido", e.getMessage());

		}

	}

	@Test
	void ct04_quando_dados_validos_fatura_nao_eh_nulo() {
		try {
			// dado que as informacoes de fatura sao validas
			// quando confirmo a fatura
			LocalDate dataVencimento = LocalDate.parse("02/10/2026", formatter);
			fatura = new Fatura(null, dataVencimento, "moveis planejados", "1000.50");
			// entao fatura é registrada com data de emisssao igual a data de hoje
			
		} catch (Exception e) {
			logger.info(">>>>>> ct01 - nao deveria falhar => " + e.getMessage());
			assertEquals("CPF invalido", e.getMessage());

		}

	}

	@Test
    void ct05_quando_cpf_formatado_fatura_nao_e_nulo() {
        try {
            // dado que as informacoes de fatura sao validas
            // quando confirmo a fatura
            LocalDate dataVencimento = LocalDate.parse("02/10/2026", formatter);
            fatura = new Fatura("390.863.600-09", dataVencimento, "moveis planejados", "1000.50");
 
            assertNotNull(fatura);
        } catch (Exception e) {
            logger.info(">>>>>> ct02 - fatura invalida => " + e.getMessage());
 
            fail("deveria falhar fatura invalida");
        }
  }

	@Test
    void ct06_quando_cpf_formatado_fatura_nao_e_nulo() {
        try {
            // dado que as informacoes de fatura sao validas
            // quando confirmo a fatura
            LocalDate dataVencimento = LocalDate.parse("02/10/2026", formatter);
            fatura = new Fatura("39.0863.600-09", dataVencimento, "moveis planejados", "1000.50");
 
            assertNotNull(fatura);
        } catch (Exception e) {
            logger.info(">>>>>> ct02 - fatura invalida => " + e.getMessage());
 
            fail("deveria falhar fatura invalida");
        }
  }

	@Test
    void ct07_quando_cpf_formatado_fatura_nao_e_nulo() {
        try {
            // dado que as informacoes de fatura sao validas
            // quando confirmo a fatura
            LocalDate dataVencimento = LocalDate.parse("02/10/2026", formatter);
            fatura = new Fatura("111.111.111-11", dataVencimento, "moveis planejados", "1000.50");
             fail("deveria falhar fatura invalida");
 
 
        } catch (Exception e) {
 
            logger.info(">>>>>> ct07 - fatura invalida => " + e.getMessage());
            assertEquals("CPF invalido", e.getMessage());
					}	
	}

}
