package org.serratec.TrabalhoFinalAPI_Grupo3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="produtos")
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long Id;
	
	@NotBlank
	@Size(min=3, max=100, message="Nome deve ter entre: 3 e 100 Caracteres.")
	@Column(name="nome", nullable=false, length=100)
	private String nome;
	
	
	@NotBlank
	@Size(min=3, max=50, message="Categoria deve ter entre: 3 e 50 Caracteres.")
	@Column(name="categoria", nullable=false, length=50)
	private String categoria;
	
	@NotNull
	@Column(name="preco", nullable=false)
	private Double preco;

	public Produtos(Long id, String nome, String categoria, Double preco) {
		super();
		Id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
	}

	public Produtos() {
	}

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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}
