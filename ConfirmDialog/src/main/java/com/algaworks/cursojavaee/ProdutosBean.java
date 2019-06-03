package com.algaworks.cursojavaee;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="produtosBean")
@ViewScoped
public class ProdutosBean {
	private List<String> produtos = new ArrayList<>();
	private String produtoSelecionado;
	
	public ProdutosBean() {
		produtos.add("Arroz");
		produtos.add("Feijão");
		produtos.add("Queijo");
		produtos.add("Notebook");
	}
	
	public void excluirProduto() {
		produtos.remove(produtoSelecionado);
	}

	public List<String> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<String> produtos) {
		this.produtos = produtos;
	}

	public String getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(String produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}
