package com.algaworks.cursojavaee;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class MessagesBean {
	
	public void adicionarMensagemErro() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Resumo da Mensagem de erro", "Mensagem de erro completa");
		context.addMessage("destinoErro", msg);
	}
	
	public void adicionarAvisoFlutuante() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Resumo do aviso flutuante", "Mensagem do aviso flutuante");
		context.addMessage("destinoAviso", msg);
	}
	
}
