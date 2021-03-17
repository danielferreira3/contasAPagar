package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_boleto")
public class Boleto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_boleto;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String codigoDeBarra;
	

	@NotNull
	private double valor;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataVencimento;
	
	
	
	@Enumerated(value = EnumType.STRING)
	private TipoBoleto tipoBoleto;
	
	@ManyToOne
	@JsonIgnoreProperties ("boleto")
	private Pessoa pessoa;
	
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}


	public long getId_boleto() {
		return id_boleto;
	}

	public void setId_boleto(long id_boleto) {
		this.id_boleto = id_boleto;
	}

	public String getCodigoDeBarra() {
		return codigoDeBarra;
	}

	public void setCodigoDeBarra(String codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public TipoBoleto getTipoBoleto() {
		return tipoBoleto;
	}

	public void setTipoBoleto(TipoBoleto tipoBoleto) {
		this.tipoBoleto = tipoBoleto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	

	
}
