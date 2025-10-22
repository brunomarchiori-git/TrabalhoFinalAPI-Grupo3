package org.serratec.TrabalhoFinalAPI_Grupo3.entity;

public class Clientes {

	
	private Long Id;
	
	private String email;
	
	private String CPF;
	
	private String telefone;
	
	private String nome;

	public Clientes(Long id, String email, String cPF, String telefone, String nome) {
		super();
		Id = id;
		this.email = email;
		CPF = cPF;
		this.telefone = telefone;
		this.nome = nome;
	}

	public Clientes() {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
