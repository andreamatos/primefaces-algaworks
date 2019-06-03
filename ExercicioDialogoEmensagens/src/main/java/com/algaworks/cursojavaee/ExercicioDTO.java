package com.algaworks.cursojavaee;

import java.util.ArrayList;
import java.util.List;

public class ExercicioDTO {

	public int index;
	public String nome;
	public Integer telefone;

	public List<ExercicioDTO> exercicioDTOLista = new ArrayList<>();

	public ExercicioDTO(int index, String nome, Integer telefone) {
		super();
		this.index = index;
		this.nome = nome;
		this.telefone = telefone;
	}

	public ExercicioDTO() {
		super();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public List<ExercicioDTO> getExercicioDTOLista() {
		return exercicioDTOLista;
	}

	public void setExercicioDTOLista(List<ExercicioDTO> exercicioDTOLista) {
		this.exercicioDTOLista = exercicioDTOLista;
	}

}
