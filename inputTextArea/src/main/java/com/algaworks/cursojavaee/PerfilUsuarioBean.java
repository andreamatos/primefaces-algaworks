package com.algaworks.cursojavaee;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="perfilUsuarioBean")
@ViewScoped

public class PerfilUsuarioBean {

	private String nome;
	private String sobre;
	
	public void atualizar() {
		System.out.println("Sobre: " + this.sobre);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}
	
	public List<String> completarTexto(String consulta) {
		List<String> resultados = new ArrayList<String>();
		if(consulta.startsWith("Thi")) {
			resultados.add("Thiago");
			resultados.add("Thiago Faria");
			resultados.add("Thiago Faria de Andrade");
			resultados.add("Thiago da Algaworks");
		}
		
		return resultados;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobre() {
		return sobre;
	}
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
}
