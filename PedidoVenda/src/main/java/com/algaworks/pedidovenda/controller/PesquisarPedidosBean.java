package com.algaworks.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisarPedidosBean {
	private List<Integer> pedidosFiltrados;
	
	public PesquisarPedidosBean() {
		pedidosFiltrados = new ArrayList<>();
		for(int i = 0; i < 50; i++) {
			pedidosFiltrados.add(i);
		}
	}

	public List<Integer> getpedidosFiltrados() {
		return pedidosFiltrados;
	}

	public void setpedidosFiltrados(List<Integer> pedidosFiltrados) {
		this.pedidosFiltrados = pedidosFiltrados;
	}
}
