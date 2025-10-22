package org.serratec.TrabalhoFinalAPI_Grupo3.entity;

import org.serratec.TrabalhoFinalAPI_Grupo3.enums.Status;

public class Pedidos {

	private Long Id;
	
	private Clientes cliente;
	
	private Status status;
	
	private Produtos produto;

	public Pedidos(Long id, Clientes cliente, Status status, Produtos produto) {
		super();
		Id = id;
		this.cliente = cliente;
		this.status = status;
		this.produto = produto;
	}

	public Pedidos() {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	
	
	
}
