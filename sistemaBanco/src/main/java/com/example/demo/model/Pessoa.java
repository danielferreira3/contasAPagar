package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
	
	@Id
	private long cpf_cnpj;
	
	@NotNull
	private String nome;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@NotNull
	private String endereco;
	
	@NotNull
	private String celular;
	
	private String telefone;
	
	@NotNull
	@Enumerated(value = EnumType.STRING)
	private  TipoPessoa tipo;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pessoa")
	private List<Boleto> boleto;
	

	public List<Boleto> getBoleto() {
		return boleto;
	}

	public void setBoleto(List<Boleto> boleto) {
		this.boleto = boleto;
	}

	public long getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(long cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	
	
	
}
