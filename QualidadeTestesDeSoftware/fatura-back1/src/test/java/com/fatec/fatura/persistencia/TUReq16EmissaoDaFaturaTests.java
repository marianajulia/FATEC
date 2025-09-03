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

	@Test
    void ct07_quando_data_invalida_mensagem_de_erro() {
        try {
            // dado que as informacoes de fatura sao inválidas - Data Inválida
            // quando confirmo a fatura
            LocalDate dataVencimento = LocalDate.parse("04/09/2025", formatter);
            fatura = new Fatura("39086360009", dataVencimento, "moveis planejados", "1000.50");
            assertEquals("2025-09-04", fatura.getDataVencimento().toString());
 
 
        } catch (Exception e) {
 
            logger.info(">>>>>> ct07 - fatura invalida => " + e.getMessage());
            fail("Não deveria falhar");
            //assertEquals("Data de vencimento: formato invalido ou domingo ou menor que data atual", e.getMessage());
        }
    }

	@Test
    void ct02_quando_data_invalida_mensagem_erro() {
        try {
            // dado que as informacoes de fatura sao invalidas - Data Invalida
            // quando confirmo a fatura
            LocalDate dataVencimento = LocalDate.parse("04/09/2025", formatter);
           
            fatura = new Fatura("39086360009", dataVencimento, "moveis planejados", "1000.50");
 
            assertEquals("04/09/2025", fatura.getDataVencimento().format(formatter));
 
 
        } catch (Exception e) {
            logger.info(">>>>>> ct02 - fatura invalida => " + e.getMessage());
            fail("não deveria falhar");
           
           
 
           
        }
    }

	@Test
    void ct08_quando_data_valida_fatura_emitida_com_sucesso() {
        try {
            // dado que as informacoes de fatura sao válidas
            // quando confirmo a fatura
            LocalDate dataVencimento = LocalDate.parse("04/09/2025", formatter);
            fatura = new Fatura("39086360009", dataVencimento, "moveis planejados", "1000.50");
            //Então retorna data formatada
            assertEquals("2025-09-04", fatura.getDataVencimento().toString());
 
 
        } catch (Exception e) {
 
            logger.info(">>>>>> ct08 - mensagem de erro => " + e.getMessage());
            fail("Não deveria falhar");
        }
    }
 
    @Test
    void ct09_quando_data_valida_fatura_emitida_com_sucesso() {
        try {
            // dado que as informacoes de fatura sao validas
            LocalDate dataVencimento = LocalDate.parse("04/09/2025", formatter);
           
            // quando confirmo a fatura
            fatura = new Fatura("39086360009", dataVencimento, "moveis planejados", "1000.50");
 
            // então validação de formato retornado com sucesso
            assertEquals("04/09/2025", fatura.getDataVencimento().format(formatter));
 
 
        } catch (Exception e) {
            logger.info(">>>>>> ct09 - mensagem de erro => " + e.getMessage());
            fail("não deveria falhar");
        }
    }

	@Test
	void ct10_quando_data_valida_fatura_emtida_com_sucesso() {
		try {
		// dado que as informacoes de fatura sao inválidas - Data válida
		LocalDate dataVencimento = LocalDate.parse("31/02/2026", formatter);
		// quando confirmo a fatura
		fatura = new Fatura("39086360009", dataVencimento, "moveis planejados", "1000.50");
		// Então retorna data formatada
		assertEquals("28/02/2026", fatura.getDataVencimento().format(formatter));
		} catch (Exception e) {
		logger.info(">>>>>> ct10 - mensagem de erro => " + e.getMessage());
		fail("Não deveria falhar");
		}
}

@Test
    void ct11_quando_data_invalida_menssagem_erro() {
        try {
            // dado que as informacoes de fatura sao inválidas - Data válida
            LocalDate dataVencimento = LocalDate.parse("/02/2026", formatter);
            // quando confirmo a fatura
            fatura = new Fatura("39086360009", dataVencimento, "moveis planejados", "1000.50");
            // Então retorna data formatada
            fail("Deveria falhar");
        } catch (Exception e) {
            logger.info(">>>>>> ct11 - mensagem de erro => " + e.getMessage());
            assertEquals("Text '/02/2026' could not be parsed at index 0", e.getMessage());
        }
    }

    @Test

    void ct12_quando_data_invalida_mensagem_de_erro() {

        try {
            // dado que as informacoes de data sao válidas
            LocalDate dataVencimento = LocalDate.parse("", formatter);
            // quando confirmo a fatura
            fatura = new Fatura("39086360009", dataVencimento, "moveis planejados", "1000.50");
            //então validação de formato retornado com sucesso
            fail("Deveria falhar");
        } catch (Exception e) {
            logger.info(">>>>>> ct12 - mensaegem de erro => " + e.getMessage());
            assertEquals("Text '' could not be parsed at index 0", e.getMessage());
        }
    }

    @Test
    void ct13_quando_data_invalida_mensagem_de_erro() {
    try {
    // dado que as informacoes de data sao inválidas
    LocalDate dataVencimento = LocalDate.parse(" ", formatter);
    // quando confirmo a fatura
    fatura = new Fatura("39086360009", dataVencimento, "moveis planejados", "1000.50");
    // então validação de formato retornado com sucesso
    fail("Deveria falhar");
    } catch (Exception e) {
        logger.info(">>>>>> ct12 - mensaegem de erro => " + e.getMessage());
        assertEquals("Text ' ' could not be parsed at index 0", e.getMessage());
    }}

}


