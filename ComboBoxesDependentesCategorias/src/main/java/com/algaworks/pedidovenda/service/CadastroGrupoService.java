package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Grupos;
import com.algaworks.pedidovenda.repository.Usuarios;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class CadastroGrupoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	Grupo grupoExistente;
	@Inject
	Grupos grupos;
	
	@Transactional
	public Grupo salvar(Grupo grupo) {
		grupoExistente = grupos.porNome(grupo.getNome());
		
		if(grupoExistente != null && !grupoExistente.equals(grupo)) {
			throw new NegocioException("Já existe este usuario");
		}
		
		return grupos.guardar(grupo);
		
	}
}
