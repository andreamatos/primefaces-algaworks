package com.algaworks.cursojavaee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="exercicioBean")
@ViewScoped
public class ExercicioBean {
	private ExercicioDTO exercicioDTO = new ExercicioDTO();
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
}
