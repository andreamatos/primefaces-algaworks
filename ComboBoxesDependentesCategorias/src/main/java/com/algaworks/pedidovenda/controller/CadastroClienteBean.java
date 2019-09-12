package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	private List<Integer> itens;
	
	public CadastroClienteBean() {
		cliente = new Cliente();
		itens=new ArrayList<>();
		itens.add(1);
	}
	
	public void salvar() {
	}
	
	public List<Integer> getItens(){
		return itens;
	}

	public void setItens(List<Integer> itens) {
		this.itens = itens;
	}
	
	public void incluirCliente() {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public boolean isEditando() {
		return this.cliente.getId() != null;
	}
	
}
