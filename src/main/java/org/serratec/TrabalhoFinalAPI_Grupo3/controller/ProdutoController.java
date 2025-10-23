package org.serratec.TrabalhoFinalAPI_Grupo3.controller;

import java.util.List;

import org.serratec.TrabalhoFinalAPI_Grupo3.DTO.ProdutoRequestDTO;
import org.serratec.TrabalhoFinalAPI_Grupo3.DTO.ProdutoResponseDTO;
import org.serratec.TrabalhoFinalAPI_Grupo3.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
		List<ProdutoResponseDTO> produtos = produtoService.listarTodos();
		return ResponseEntity.ok(produtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
		try {
			ProdutoResponseDTO produto = produtoService.buscarPorId(id);
			return ResponseEntity.ok(produto);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> criar(@Valid @RequestBody ProdutoRequestDTO produtoRequest) {
		try {
			ProdutoResponseDTO produto = produtoService.criar(produtoRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(produto);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO produtoRequest) {
		try {
			ProdutoResponseDTO produto = produtoService.atualizar(id, produtoRequest);
			return ResponseEntity.ok(produto);
		} catch (RuntimeException e) {
			if (e.getMessage().contains("não encontrado")) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		try {
			produtoService.deletar(id);
			return ResponseEntity.noContent().build();
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/categoria/{categoriaId}")
	public ResponseEntity<List<ProdutoResponseDTO>> buscarPorCategoria(@PathVariable Long categoriaId) {
		try {
			List<ProdutoResponseDTO> produtos = produtoService.buscarPorCategoria(categoriaId);
			return ResponseEntity.ok(produtos);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<ProdutoResponseDTO>> buscarPorNome(@RequestParam String nome) {
		List<ProdutoResponseDTO> produtos = produtoService.buscarPorNome(nome);
		return ResponseEntity.ok(produtos);
	}
}
