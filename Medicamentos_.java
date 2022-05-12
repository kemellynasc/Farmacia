package com.farmacia.farmacia.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_medicamentos")
public class Medicamentos_ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O titulo é obrigatório!")
	@Size(min = 5, max = 100)
	private String Nome;
	
	@NotBlank(message = "O titulo é obrigatório!")
	private String Preço;
	
	@NotBlank(message = "O titulo é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo titulo deve conter no minimo 5 e no máximo 100 caracteres")
	private String Descricao;
	
	@UpdateTimestamp
	private LocalDateTime data;
	@ManyToOne
	@JsonIgnoreProperties
	private Categoria Categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getPreço() {
		return Preço;
	}

	public void setPreço(String preço) {
		Preço = preço;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
	
	
}
