package com.algaworks.cursojavaee;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="perfilUsuarioBean")
@ViewScoped
public class PerfilUsuarioBean {
	private String login;
	private String senha;
	
	public void atualizar() {
		System.out.println("Login: " + getLogin());
		System.out.println("Nome: " + getSenha());
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil Atualizado!"));
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
