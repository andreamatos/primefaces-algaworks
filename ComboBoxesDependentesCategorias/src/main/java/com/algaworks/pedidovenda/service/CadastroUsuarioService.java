package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Usuarios;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	Usuario usuarioExistente;
	
	@Inject
	private Usuarios usuarios;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		usuarioExistente = usuarios.porNome(usuario.getNome());
		
		if(usuarioExistente != null && !usuarioExistente.equals(usuario)) {
			throw new NegocioException("Já existe este usuario");
		}
		
		return usuarios.guardar(usuario);

	}

}
