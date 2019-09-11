package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.model.Usuario;

public class Grupos implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Grupo> grupo(){
		return manager.createQuery("from Grupo",Grupo.class).getResultList();
	}

	public Grupo porId(Long id) {
		return manager.find(Grupo.class, id);
	}

	public Grupo guardar(Grupo grupo) {
		return manager.merge(grupo);
	}

	public Grupo porNome(String nome) {
		return manager.createQuery("from Grupo where nome = :nome",Grupo.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

}