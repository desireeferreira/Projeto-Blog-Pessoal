package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="tb_postagens")
public class Postagem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@NotBlank(message = "O Título é obrigatório")
	@Size(min=5, max=100, message="O Título deve ter entre 5 e 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "O Texto é obrigatório")
	@Size(min=5, max=100, message="O Texto deve ter entre 5 e 1000 caracteres")
	private  String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;

	@ManyToOne// classe postagem muitos: classe tema um
	@JsonIgnoreProperties("postagem") //
	private Tema tema;// adicionando o objeto tema (id, descrição)
	
	@ManyToOne
	@JsonIgnoreProperties("postagem") //
	private Usuario usuario;
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
}