package org.serratec.TrabalhoFinalAPI_Grupo3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categorias")
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long Id;

	@NotBlank(message = "O nome da categoria não pode ser vazio.")
	@Size(min = 2, max = 50, message = "Nome da categoria deve ter entre 2 e 50 Caracteres.")
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	public Categorias() {
	}

	public Categorias(Long id, String nome) {
		super();
		Id = id;
		this.nome = nome;
	}

	// Getters e Setters
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}