package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Grupos;
import com.algaworks.pedidovenda.service.CadastroUsuarioService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	@Inject
	private Grupos grupos;
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	
	
	private Grupo grupo;
	
	private List<Grupo> grupoList;
	
	public CadastroUsuarioBean() {
		usuario = new Usuario();
		grupo = new Grupo();
		grupoList = new ArrayList<>();
	}
	
	public void inicializar() {
		if(FacesUtil.isNotPostback()) {
			grupoList = grupos.grupo();
		}
	}
	
	public void salvar() {
		cadastroUsuarioService.salvar(usuario);
		limpar();
		FacesUtil.addInfoMessage("Usuário salvo com sucesso!");
	}

	public void limpar(){
		usuario = new Usuario();
		grupo = new Grupo();
	}
	
	public void adicionarGrupo() {
		this.usuario.getGrupos().add(this.grupo);
	}

	public void excluir() {
		this.usuario.getGrupos().remove(this.grupo);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Grupo> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<Grupo> grupoList) {
		this.grupoList = grupoList;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public boolean isEditando() {
		return this.usuario.getId() != null;
	}

}
