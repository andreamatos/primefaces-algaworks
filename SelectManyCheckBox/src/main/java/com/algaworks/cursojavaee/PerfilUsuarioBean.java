package com.algaworks.cursojavaee;

import java.io.Serializable;
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
	private Interesse interesse;
	public List<String> interesses;
	
	public void atualizar() {
		
		for(String interesse : interesses) {
			System.out.println("Interesse: " + interesse);
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}


	public List<String> getInteresses() {
		return interesses;
	}


	public void setInteresses(List<String> interesses) {
		this.interesses = interesses;
	}
}