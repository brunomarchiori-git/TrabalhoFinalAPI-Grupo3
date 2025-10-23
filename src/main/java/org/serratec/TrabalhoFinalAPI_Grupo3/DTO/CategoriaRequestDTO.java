package org.serratec.TrabalhoFinalAPI_Grupo3.DTO;

import jakarta.validation.constraints.NotBlank;

public class CategoriaRequestDTO {

	@NotBlank(message = "Nome da categoria é obrigatório")
	private String nome;

	public CategoriaRequestDTO() {
	}

	public CategoriaRequestDTO(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
