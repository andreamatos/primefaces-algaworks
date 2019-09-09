package com.algaworks.cursojavaee;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ExercicioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ExercicioDTO exercicioDTO;
	
	private String itemSelecionado;
	private int index = 0;
	

	public void excluirCadastro() {
		exercicioDTO.exercicioDTOLista.remove(index);
	}

	public void incluirCadastro() {
		exercicioDTO.exercicioDTOLista.add(new ExercicioDTO(exercicioDTO.getIndex(), exercicioDTO.getNome(),exercicioDTO.getTelefone()));
		exercicioDTO.setIndex(index + 1);
	}

	public ExercicioDTO getExercicioDTO() {
		return exercicioDTO;
	}

	public void setExercicioDTO(ExercicioDTO exercicioDTO) {
		this.exercicioDTO = exercicioDTO;
	}

	public String getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(String itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
