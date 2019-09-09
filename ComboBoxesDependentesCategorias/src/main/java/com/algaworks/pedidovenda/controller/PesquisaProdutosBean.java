package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.filter.ProdutoFilter;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.Produtos;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;

	public PesquisaProdutosBean() {
		this.filtro = new ProdutoFilter();
	}
	
	public void pesquisar() {
		produtosFiltrados  = produtos.filtrados(filtro);
	}
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFilter() {
		return getFilter();
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(ProdutoFilter filtro) {
		this.filtro = filtro;
	}

}