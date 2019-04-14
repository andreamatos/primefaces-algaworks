package com.algaworks.cursojavaee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "perfilUsuarioBean")
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String profissao;
	private Interesse interesse;
	public static List<Interesse> INTERESSES = new ArrayList<>();

	static {
		INTERESSES.add(new Interesse("Esportes", "esportes"));
		INTERESSES.add(new Interesse("Computação", "computacao"));
		INTERESSES.add(new Interesse("Cinema", "cinema"));
		INTERESSES.add(new Interesse("Leitura", "leitura"));
	}
	
	public void atualizar() {
		System.out.println("Profissão: " + this.profissao);
		System.out.println("Interesse: " + interesse.getDescricao());

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}

	public List<Interesse> getInteresses(){
		return INTERESSES;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

	public static List<Interesse> getINTERESSES() {
		return INTERESSES;
	}

	public static void setINTERESSES(List<Interesse> iNTERESSES) {
		INTERESSES = iNTERESSES;
	}
}