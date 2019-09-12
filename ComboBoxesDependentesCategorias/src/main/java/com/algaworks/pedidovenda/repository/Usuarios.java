package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.algaworks.pedidovenda.filter.UsuarioFilter;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.service.NegocioException;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class Usuarios implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Inject
	private Usuario usuario;

	public Usuario porNome(String nome){
		try {
			return manager.createQuery("from Usuario where nome = :nome",Usuario.class)
					.setParameter("nome", nome)
					.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public Usuario guardar(Usuario usuario) {
		try {
			return manager.merge(usuario);
		}catch(PersistenceException e) {
			return null;
		}
	}

	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> filtrar(UsuarioFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);

		//ex: where nome like '%joao%' -> usar MatchMode .ANYWHERE
		if(StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}

	@Transactional
	public void remover(Usuario usuarioSelecionado) {
		try {
			usuario = porId(usuarioSelecionado.getId());
			manager.remove(usuario);
			manager.flush();
		}catch(PersistenceException e) {
			System.out.println("Erro: " + e);
			throw new NegocioException("Usuário não pode ser excluído.");
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
