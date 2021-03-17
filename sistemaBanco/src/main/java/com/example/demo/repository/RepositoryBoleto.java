package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Boleto;

public interface RepositoryBoleto extends JpaRepository <Boleto, Long> {
	
	public List <Boleto> findAllByNomeContainingIgnoreCase(String nome);
	
}
