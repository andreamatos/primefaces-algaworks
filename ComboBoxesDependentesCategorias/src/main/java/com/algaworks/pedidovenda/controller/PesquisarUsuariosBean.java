package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.filter.UsuarioFilter;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Usuarios;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarUsuariosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	private Usuario usuarioSelecionado;

	private UsuarioFilter filtro;	

	private List<Usuario> usuariosFiltrados;
	
	public PesquisarUsuariosBean() {
		usuariosFiltrados = new ArrayList<>();
		usuarios = new Usuarios();
		filtro = new UsuarioFilter();
		usuarioSelecionado = new Usuario();
	}
	
	public List<Usuario> pesquisar() {
		return usuariosFiltrados = usuarios.filtrar(filtro);
	}
	
	public void excluir() {
		usuarios.remover(usuarioSelecionado);
		usuariosFiltrados.remove(usuarioSelecionado);
		FacesUtil.addInfoMessage("Produto " + usuarioSelecionado.getNome() 
			+ " excluído com sucesso.");
	}
	

	public UsuarioFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(UsuarioFilter filtro) {
		this.filtro = filtro;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

	public void setUsuariosFiltrados(List<Usuario> usuariosFiltrados) {
		this.usuariosFiltrados = usuariosFiltrados;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
}
