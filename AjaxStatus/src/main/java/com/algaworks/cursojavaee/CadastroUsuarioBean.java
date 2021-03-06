package com.algaworks.cursojavaee;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="cadastroUsuarioBean")
@ViewScoped
public class CadastroUsuarioBean {
	private String login;
	private String nome;
	
	public void cadastrar() {
		System.out.println("Login: " + getLogin());
		System.out.println("Nome: " + getNome());
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro Efetuado!"));
	}
	
	public void verificarDisponibilidadeLogin() {
		
		// simula demora no processamento
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e){ 
			
		}
		
		FacesMessage msg = null;
		System.out.println("Verificando disponibilidade " + getLogin());
		
		if("joão".equalsIgnoreCase(this.login)) {
			msg= new FacesMessage("Login já está em uso");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
		}else {
			msg= new FacesMessage("Login Disponivel");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
