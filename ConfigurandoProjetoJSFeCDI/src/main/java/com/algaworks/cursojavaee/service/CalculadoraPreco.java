package com.algaworks.cursojavaee.service;

import javax.inject.Named;

public class CalculadoraPreco {
	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}
}
