package com.algaworks.cursojavaee.service;

import javax.annotation.PostConstruct;

public class CalculadoraPreco {
	
	@PostConstruct
	public void inic() {
		System.out.println("Init CalculadoraPreco");
	}
	
	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}
}
