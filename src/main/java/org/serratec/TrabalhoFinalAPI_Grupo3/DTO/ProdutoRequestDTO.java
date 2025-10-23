package org.serratec.TrabalhoFinalAPI_Grupo3.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoRequestDTO {

	@NotBlank(message = "Nome do produto é obrigatório")
	private String nome;
	
	@NotNull(message = "ID da categoria é obrigatório")
	private Long categoriaId;
	
	@NotNull(message = "Preço é obrigatório")
	@Positive(message = "Preço deve ser maior que zero")
	private Double preco;
	
	private String descricao;
	
	private Integer quantidadeEstoque;

	public ProdutoRequestDTO() {
	}

	public ProdutoRequestDTO(String nome, Long categoriaId, Double preco, String descricao, Integer quantidadeEstoque) {
		this.nome = nome;
		this.categoriaId = categoriaId;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
}
