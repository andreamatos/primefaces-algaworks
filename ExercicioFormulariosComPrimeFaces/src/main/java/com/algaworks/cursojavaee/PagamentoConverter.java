package com.algaworks.cursojavaee;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("pagamento")

public class PagamentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value!= null) {
			for(PagamentoDTO pagamento: PerfilUsuarioBean.getPAGAMENTOS()) {
				if (value.equals(pagamento.getDescricao())) {
					return pagamento;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!= null) {
			PagamentoDTO pagamento = (PagamentoDTO) value;
			return pagamento.getDescricao();
		}
		return null;
	}
}
