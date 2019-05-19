package com.algaworks.cursojavaee;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class FuncionariosBean {
	
	private static final String[] nomes= {"João", "Maria", "José", "Eduardo", "Sebastião", 
											"Mariana", "Francisco", "Manoel", "Fernanda", "Gabriela",
												"Mário", "Marcos"};
	
	private static final String[] sobremesas= {"Souza", "Silva", "Andrade", "Machado", 
												"Júnior", "Albuquerque", "Alencar", "Assis", 
													"Batista", "Camargo", "Coelho", "Costa", 
														"Dias", "Rosa", "Leal", "Lima", "Leite"};
	
	private List<Funcionario> funcionarios;
	
	public FuncionariosBean() throws ParseException{
		funcionarios = new ArrayList<>();
		for(int i=0; i< 50; i++) {
			adicionarFuncionario();
		}
	}
	
	private void adicionarFuncionario() {
		String nomeCompleto = getNomeAleatorio() + " " + getSobremesaAleatoria() + " " + getSobremesaAleatoria();
		
		funcionarios.add(new Funcionario(getMatriculaAleatoria(), nomeCompleto, getDataAleatoria(), getSalarioAleatorio()));
	}


	private BigDecimal getSalarioAleatorio() {
		return new BigDecimal(1000 + (Math.random() * 29000));
	}
	
	private Long getMatriculaAleatoria() {
		return (long) (Math.random() * 10000);
	}
	
	private Date getDataAleatoria() {
		long dezAnosEmMillis = 24 * 60 * 60 * 1000;
		long periodoSorteadoEmMillis = ((long) (Math.random() * 10 * 365)) * dezAnosEmMillis;
		return new Date(System.currentTimeMillis() - periodoSorteadoEmMillis);
	}
	
	private String getSobremesaAleatoria() {
		int posicao = (int) Math.round(Math.random()*(sobremesas.length -1));
		return sobremesas[posicao];
	}
	
	private String getNomeAleatorio() {
		int posicao = (int)Math.round(Math.random() * (nomes.length - 1));
		return nomes[posicao];
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public static String[] getNomes() {
		return nomes;
	}

	public static String[] getSobremesas() {
		return sobremesas;
	}
	
}
