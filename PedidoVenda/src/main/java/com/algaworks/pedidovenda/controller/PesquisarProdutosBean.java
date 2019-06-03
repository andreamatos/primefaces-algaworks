package com.algaworks.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisarProdutosBean {
	private List<Integer> produtosFiltrados;
	
	public PesquisarProdutosBean() {
		produtosFiltrados = new ArrayList<>();
		for(int i = 0; i < 50; i++) {
			produtosFiltrados.add(i);
		}
	}

	public List<Integer> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Integer> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}
}
