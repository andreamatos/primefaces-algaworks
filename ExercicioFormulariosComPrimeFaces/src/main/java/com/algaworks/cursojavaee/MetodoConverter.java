package com.algaworks.cursojavaee;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("metodo")

public class MetodoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value!= null) {
			for(MetodoDTO metodo : PerfilUsuarioBean.getMETODOS()) {
				if (value.equals(metodo.getDescricao())) {
					return metodo;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!= null) {
			MetodoDTO metodo = (MetodoDTO) value;
			return metodo.getDescricao();
		}
		return null;
	}
}
