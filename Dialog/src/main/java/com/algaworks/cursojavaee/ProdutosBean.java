package com.algaworks.cursojavaee;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="produtosBean")
@ViewScoped

public class ProdutosBean {
	private List<String> produtos = new ArrayList<>();
	private String nomeProduto;
	
	public void incluirProduto() {
		produtos.add(nomeProduto);
		nomeProduto = null;
	}
	
	public List<String> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<String> produtos) {
		this.produtos = produtos;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
}
