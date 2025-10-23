package org.serratec.TrabalhoFinalAPI_Grupo3.DTO;

public class ProdutoResponseDTO {

	private Long id;
	private String nome;
	private String categoriaNome;
	private Long categoriaId;
	private Double preco;
	private String descricao;
	private Integer quantidadeEstoque;

	public ProdutoResponseDTO() {
	}

	public ProdutoResponseDTO(Long id, String nome, String categoriaNome, Long categoriaId, Double preco, String descricao, Integer quantidadeEstoque) {
		this.id = id;
		this.nome = nome;
		this.categoriaNome = categoriaNome;
		this.categoriaId = categoriaId;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoriaNome() {
		return categoriaNome;
	}

	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
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
