package com.algaworks.cursojavaee.controller;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.cursojavaee.service.CalculadoraPreco;

@Named("meuBean")
public class PrecoProdutoBean {

	@Inject
	public CalculadoraPreco calculadora;
	
	@PostConstruct
	public void inic() {
		System.out.println("Init PrecoProdutoBean");
	}
	
	public double getPreco() {
		return calculadora.calcularPreco(12, 44.55);
	}
}