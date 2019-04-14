package com.algaworks.cursojavaee;

public class Interesse {

	public Interesse() {
		
	}
	
	public Interesse(String descricao, String nomeIcone) {
		super();
		this.descricao = descricao;
		this.nomeIcone = nomeIcone;
	}

	private String descricao;
	private String nomeIcone;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNomeIcone() {
		return nomeIcone;
	}
	public void setNomeIcone(String nomeIcone) {
		this.nomeIcone = nomeIcone;
	}
}
