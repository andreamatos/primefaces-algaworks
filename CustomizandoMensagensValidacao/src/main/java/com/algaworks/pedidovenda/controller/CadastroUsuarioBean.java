package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Usuario;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	private List<Integer> itens;
	
	public CadastroUsuarioBean() {
		usuario = new Usuario();
		itens=new ArrayList<>();
		itens.add(1);
	}
	
	public void salvar() {
	}
	
	public List<Integer> getItens(){
		return itens;
	}

	public void setItens(List<Integer> itens) {
		this.itens = itens;
	}
	
	public void incluirCliente() {

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
