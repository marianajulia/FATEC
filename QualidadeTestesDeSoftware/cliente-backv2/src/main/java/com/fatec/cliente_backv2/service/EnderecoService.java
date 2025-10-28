package com.fatec.cliente_backv2.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fatec.cliente_backv2.model.Endereco;

@Service
public class EnderecoService implements IEnderecoService {

    private static final String API_URL = "https://viacep.com.br/ws/{cep}/json/";
    private static final Logger logger = LogManager.getLogger(EnderecoService.class);

    private final RestTemplate restTemplate;

    public EnderecoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    /**
     * consulta - comunicação sincrona com a api viacep
     */
    public Optional<String> obtemLogradouroPorCep(String cep) {
        logger.info(">>>>>> obtemLogradouroPorCep chamado para o CEP: ");
        try {
            ResponseEntity<Endereco> response = restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                null,
                Endereco.class,
                cep
            );

            HttpStatusCode statusCode = response.getStatusCode();
            logger.info(">>>>>> Código de status HTTP retornado: " + statusCode.value());

            Endereco endereco = response.getBody();
            if (endereco != null && endereco.getLogradouro() != null) {
                logger.info(">>>>>> Logradouro encontrado");
                return Optional.of(endereco.getLogradouro());
            } else {
                logger.warn(">>>>>> Logradouro não encontrado para o CEP ");
                return Optional.empty();
            }
        } catch (HttpClientErrorException e) {
            logger.warn(">>>>>> Erro retornado pela API ao buscar CEP ");
            return Optional.empty();
        }
    }
}
