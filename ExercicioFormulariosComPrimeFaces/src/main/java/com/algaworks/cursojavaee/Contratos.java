package com.algaworks.cursojavaee;

public class Contratos {
	private String razaoSocial;
	private String dataDoContrato;
	private String cursos;

	public Contratos(String razaoSocial, String dataDoContrato, String cursos) {
		super();
		this.razaoSocial = razaoSocial;
		this.dataDoContrato = dataDoContrato;
		this.cursos = cursos;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getDataDoContrato() {
		return dataDoContrato;
	}
	public void setDataDoContrato(String dataDoContrato) {
		this.dataDoContrato = dataDoContrato;
	}
	public String getCursos() {
		return cursos;
	}
	public void setCursos(String cursos) {
		this.cursos = cursos;
	}
}
