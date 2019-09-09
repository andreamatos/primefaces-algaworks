package com.algaworks.cursojavaee.service;

import javax.enterprise.inject.Default;

@Default
public class MensageiroCorreio implements Mensageiro{

	@Override
	public void enviarMensagem(String mensagem) {
		System.out.println("Enviado mensagem por correio" + mensagem);
	}
}
