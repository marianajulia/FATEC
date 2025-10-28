package com.fatec.cliente_backv2.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.cliente_backv2.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
	Optional<Cliente> findByCpf(String cpf);
	
    @Modifying
    @Transactional
    @Query("delete from Cliente c where c.cpf = :cpf")
	void deleteByCpf(String cpf);

}