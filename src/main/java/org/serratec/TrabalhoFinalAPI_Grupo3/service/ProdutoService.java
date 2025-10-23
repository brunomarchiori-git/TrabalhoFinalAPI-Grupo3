package org.serratec.TrabalhoFinalAPI_Grupo3.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.TrabalhoFinalAPI_Grupo3.DTO.ProdutoRequestDTO;
import org.serratec.TrabalhoFinalAPI_Grupo3.DTO.ProdutoResponseDTO;
import org.serratec.TrabalhoFinalAPI_Grupo3.entity.Categorias;
import org.serratec.TrabalhoFinalAPI_Grupo3.entity.Produtos;
import org.serratec.TrabalhoFinalAPI_Grupo3.repository.CategoriaRepository;
import org.serratec.TrabalhoFinalAPI_Grupo3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<ProdutoResponseDTO> listarTodos() {
		return produtoRepository.findAll().stream()
				.map(this::converterParaDTO)
				.collect(Collectors.toList());
	}

	public ProdutoResponseDTO buscarPorId(Long id) {
		Optional<Produtos> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return converterParaDTO(produto.get());
		}
		throw new RuntimeException("Produto não encontrado com ID: " + id);
	}

	public ProdutoResponseDTO criar(ProdutoRequestDTO produtoRequest) {
		// Verificar se a categoria existe
		Optional<Categorias> categoria = categoriaRepository.findById(produtoRequest.getCategoriaId());
		if (!categoria.isPresent()) {
			throw new RuntimeException("Categoria não encontrada com ID: " + produtoRequest.getCategoriaId());
		}

		Produtos produto = new Produtos();
		produto.setNome(produtoRequest.getNome());
		produto.setCategoria(categoria.get());
		produto.setPreco(produtoRequest.getPreco());
		produto.setDescricao(produtoRequest.getDescricao());
		produto.setQuantidadeEstoque(produtoRequest.getQuantidadeEstoque());

		Produtos produtoSalvo = produtoRepository.save(produto);
		return converterParaDTO(produtoSalvo);
	}

	public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO produtoRequest) {
		Optional<Produtos> produtoExistente = produtoRepository.findById(id);
		if (!produtoExistente.isPresent()) {
			throw new RuntimeException("Produto não encontrado com ID: " + id);
		}

		// Verificar se a categoria existe
		Optional<Categorias> categoria = categoriaRepository.findById(produtoRequest.getCategoriaId());
		if (!categoria.isPresent()) {
			throw new RuntimeException("Categoria não encontrada com ID: " + produtoRequest.getCategoriaId());
		}

		Produtos produto = produtoExistente.get();
		produto.setNome(produtoRequest.getNome());
		produto.setCategoria(categoria.get());
		produto.setPreco(produtoRequest.getPreco());
		produto.setDescricao(produtoRequest.getDescricao());
		produto.setQuantidadeEstoque(produtoRequest.getQuantidadeEstoque());

		Produtos produtoAtualizado = produtoRepository.save(produto);
		return converterParaDTO(produtoAtualizado);
	}

	public void deletar(Long id) {
		if (!produtoRepository.existsById(id)) {
			throw new RuntimeException("Produto não encontrado com ID: " + id);
		}
		produtoRepository.deleteById(id);
	}

	public List<ProdutoResponseDTO> buscarPorCategoria(Long categoriaId) {
		Optional<Categorias> categoria = categoriaRepository.findById(categoriaId);
		if (!categoria.isPresent()) {
			throw new RuntimeException("Categoria não encontrada com ID: " + categoriaId);
		}

		return produtoRepository.findByCategoria(categoria.get()).stream()
				.map(this::converterParaDTO)
				.collect(Collectors.toList());
	}

	public List<ProdutoResponseDTO> buscarPorNome(String nome) {
		return produtoRepository.findByNomeContainingIgnoreCase(nome).stream()
				.map(this::converterParaDTO)
				.collect(Collectors.toList());
	}

	private ProdutoResponseDTO converterParaDTO(Produtos produto) {
		return new ProdutoResponseDTO(
				produto.getId(),
				produto.getNome(),
				produto.getCategoria().getNome(),
				produto.getCategoria().getId(),
				produto.getPreco(),
				produto.getDescricao(),
				produto.getQuantidadeEstoque()
		);
	}
}
