package com.algaworks.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CadastroClienteBean {
	private List<Integer> itens;
	
	public CadastroClienteBean() {
		itens=new ArrayList<>();
		itens.add(1);
	}
	
	public List<Integer> getItens(){
		return itens;
	}

	public void setItens(List<Integer> itens) {
		this.itens = itens;
	}
	
	public void incluirCliente() {

	}
}
