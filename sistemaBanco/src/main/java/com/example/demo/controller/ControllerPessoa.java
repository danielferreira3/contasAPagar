package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.RepositoryPessoa;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControllerPessoa {
	
	@Autowired
	private RepositoryPessoa repository;
	
	
	@PostMapping("/cadastrar")
	public Pessoa post (@RequestBody Pessoa objetinho) {
		repository.save(objetinho);
		return objetinho;
	}
	
	@GetMapping
	public ResponseEntity <List <Pessoa>> GetAll(){
		return ResponseEntity.ok (repository.findAll());
	}
	
	
	@GetMapping("/{cpf_cnpj}")
	public ResponseEntity <Pessoa> GetById (@PathVariable Long cpf_cnpj){
		return repository.findById(cpf_cnpj)
		.map(resp -> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> put(@RequestBody Pessoa pessoa){
		return ResponseEntity.ok(repository.save(pessoa));
	}
	
	@DeleteMapping("/{cpf_cnpj}")
	public void delete (@PathVariable Long cpf_cnpj) {
		repository.deleteById(cpf_cnpj);
	}
	
}
