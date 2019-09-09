package com.algaworks.cursojavaee.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.cursojavaee.service.Brasil;

@Named
@RequestScoped
public class FormatacaoBean {

		@Inject @Brasil
		private DateFormat formatadorData;
		private Date dataInformada;
		private String dataFormatada;
		
		public void enviar() {
			dataFormatada = formatadorData.format(dataInformada);
		}

		public DateFormat getFormatadorData() {
			return formatadorData;
		}

		public void setFormatadorData(DateFormat formatadorData) {
			this.formatadorData = formatadorData;
		}

		public Date getDataInformada() {
			return dataInformada;
		}

		public void setDataInformada(Date dataInformada) {
			this.dataInformada = dataInformada;
		}

		public String getDataFormatada() {
			return dataFormatada;
		}

		public void setDataFormatada(String dataFormatada) {
			this.dataFormatada = dataFormatada;
		}
	
}
