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

import com.example.demo.model.Boleto;
import com.example.demo.repository.RepositoryBoleto;


@RestController
@RequestMapping("/boleto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControllerBoleto {
	
	@Autowired
	private RepositoryBoleto repository;
	
	@PostMapping("/cadastrar")
	public Boleto post (@RequestBody Boleto objetinho) {
		repository.save(objetinho);
		return objetinho;
	}
	
	
	@GetMapping
	public ResponseEntity <List <Boleto>> GetAll(){
		return ResponseEntity.ok (repository.findAll());
	}
	
	
	@GetMapping("/{id_boleto}")
	public ResponseEntity <Boleto> GetById (@PathVariable Long id_boleto){
		return repository.findById(id_boleto)
		.map(resp -> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());
				
	}
	
	@PutMapping
	public ResponseEntity<Boleto> put(@RequestBody Boleto boleto){
		return ResponseEntity.ok(repository.save(boleto));
	}
	
	@DeleteMapping("/{id_boleto}")
	public void delete (@PathVariable Long id_boleto) {
		repository.deleteById(id_boleto);
	}

}
