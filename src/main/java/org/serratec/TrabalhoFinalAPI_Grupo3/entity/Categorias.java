package org.serratec.TrabalhoFinalAPI_Grupo3.entity;

public class Categorias {

	private Long Id;
	
	private String nome;

	public Categorias(Long id, String nome) {
		super();
		Id = id;
		this.nome = nome;
	}

	public Categorias() {
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
	
	
	
	
}
