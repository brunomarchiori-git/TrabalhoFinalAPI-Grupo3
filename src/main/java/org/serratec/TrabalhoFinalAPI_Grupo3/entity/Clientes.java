package org.serratec.TrabalhoFinalAPI_Grupo3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long Id;
	
	@Email
	@Column(name="email")
	private String email;
	
	@NotBlank
	@Size(max=11, message="Telefone deve no máximo 11 Caracteres.")
	@Column(name="cpf", nullable=false, length=11)
	private String CPF;
	
	@NotBlank
	@Size(max=12, message="Telefone deve no máximo 12 Caracteres.")
	@Column(name="telefone", nullable=false, length=12)
	private String telefone;
	
	@NotBlank
	@Size(min=3, max=100, message="Nome deve ter entre: 3 e 100 Caracteres.")
	@Column(name="nome", nullable=false, length=100)
	private String nome;
	
	public Clientes(Long id, @Email String email,
			@NotBlank @Size(max = 11, message = "Telefone deve no máximo 11 Caracteres.") String cPF,
			@NotBlank @Size(max = 12, message = "Telefone deve no máximo 12 Caracteres.") String telefone,
			@NotBlank @Size(min = 3, max = 100, message = "Nome deve ter entre: 3 e 100 Caracteres.") String nome) {
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
