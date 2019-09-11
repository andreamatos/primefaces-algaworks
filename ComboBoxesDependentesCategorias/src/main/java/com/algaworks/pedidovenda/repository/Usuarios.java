package com.algaworks.pedidovenda.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.model.Usuario;

public class Usuarios implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

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

//	public Produto porSku(String sku) {
//		try {
//			return manager.createQuery("from Produto where upper(sku) = :sku", Produto.class)
//					.setParameter("sku", sku.toUpperCase())
//					.getSingleResult();
//		}catch(NoResultException e) {
//			return null;
//		}
//	}
//	
//	@Transactional
//	public void remover(Produto produto) {
//		try {
//			produto = porId(produto.getId());
//			manager.remove(produto);
//			manager.flush();
//		}catch(PersistenceException e) {
//			throw new NegocioException("Produto não pode ser excluído.");
//		}
//	}
//	@SuppressWarnings("unchecked")
//	public List<Produto> filtrados(ProdutoFilter filtro){
//		Session session = manager.unwrap(Session.class);
//		Criteria criteria = session.createCriteria(Produto.class);
//
//		if(StringUtils.isNotBlank(filtro.getSku())) {
//			criteria.add(Restrictions.eq("sku", filtro.getSku()));
//		}
//		
//		//where nome like '%joao%' -> usar MatchMode .ANYWHERE
//		if(StringUtils.isNotBlank(filtro.getNome())) {
//			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
//		}
//
//		return criteria.addOrder(Order.asc("nome")).list();
//	}
//

}
