package org.serratec.TrabalhoFinalAPI_Grupo3.entity;

public class Produtos {

	private Long Id;
	
	private String nome;
	
	private String categoria;
	
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
