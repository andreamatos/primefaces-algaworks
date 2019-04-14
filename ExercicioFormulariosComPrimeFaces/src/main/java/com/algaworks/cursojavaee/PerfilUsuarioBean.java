package com.algaworks.cursojavaee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean(name="perfilUsuarioBean")
@ViewScoped

public class PerfilUsuarioBean {

	private String razaoSocial;
	private String cnpj;
	private String cidade;
	private String sexo;
	private String modalidade;
	private Date dataContrato;
	private Long valorContrato;
	private Integer metodo;
	private List<String> cidades = new ArrayList<>();

	private MetodoDTO metodoDTO;
	private static List<MetodoDTO> METODOS = new ArrayList<>();

	private PagamentoDTO pagamentoDTO;
	private static List<PagamentoDTO> PAGAMENTOS = new ArrayList<>();
	
    private List<SelectItem> cursos  = new ArrayList<SelectItem>();
    
    private List<String> selecaoCursos;
	
	public PerfilUsuarioBean() {
		carregarCidades();
		carregarMetodos();
		carregarCursos();
		inicializaPagamento();
	}
	
	public List<String> carregarCidades(){
		cidades.add("Amapa");
		cidades.add("Bahia");
		cidades.add("Belo Horizonte");
		cidades.add("Maranhão");
		cidades.add("Rio de Janeiro");
		cidades.add("Santa Catarina");
		cidades.add("São Paulo");
		return cidades;
	}
	
	public List<MetodoDTO> carregarMetodos() {
		List<MetodoDTO> METODOS = new ArrayList<>();
		METODOS.add(new MetodoDTO(0, "Selecione"));
		METODOS.add(new MetodoDTO(1, "Cartao de Crédito"));
		METODOS.add(new MetodoDTO(2, "Cheque"));		
		METODOS.add(new MetodoDTO(3, "Boleto"));		
		this.METODOS=METODOS;
		return this.METODOS;
	}
	
	public List<PagamentoDTO> carregarCartao() {
		List<PagamentoDTO> PAGAMENTOS = new ArrayList<>();
		PAGAMENTOS.add(new PagamentoDTO(0, "Selecione"));
		PAGAMENTOS.add(new PagamentoDTO(1, "À vista"));
		PAGAMENTOS.add(new PagamentoDTO(2, "1x"));
		PAGAMENTOS.add(new PagamentoDTO(3, "2x"));
		PAGAMENTOS.add(new PagamentoDTO(4, "3x"));
		this.PAGAMENTOS=PAGAMENTOS;
		return this.PAGAMENTOS;
	}

	public List<PagamentoDTO> carregarCheque() {
		List<PagamentoDTO> PAGAMENTOS = new ArrayList<>();
		PAGAMENTOS.add(new PagamentoDTO(0, "Selecione"));
		PAGAMENTOS.add(new PagamentoDTO(1, "À vista"));
		PAGAMENTOS.add(new PagamentoDTO(2, "Entrada + 30 dias"));
		this.PAGAMENTOS=PAGAMENTOS;
		return this.PAGAMENTOS;
	}
	
	public List<PagamentoDTO> carregarBoleto() {
		List<PagamentoDTO> PAGAMENTOS = new ArrayList<>();
		PAGAMENTOS.add(new PagamentoDTO(0, "Selecione"));
		PAGAMENTOS.add(new PagamentoDTO(1, "À vista"));
		this.PAGAMENTOS=PAGAMENTOS;
		return this.PAGAMENTOS;
	}
	
	public List<PagamentoDTO>  inicializaPagamento() {
		List<PagamentoDTO> PAGAMENTOS = new ArrayList<>();
		PAGAMENTOS.add(new PagamentoDTO(0, "Selecione"));
		this.PAGAMENTOS=PAGAMENTOS;
		return this.PAGAMENTOS;
	}
	
	public List<SelectItem> carregarCursos() {
	    List<SelectItem> cursos  = new ArrayList<SelectItem>();
		cursos.add(new SelectItem(1, "Fundamentos Java e Orientação a Objetos"));
		cursos.add(new SelectItem(2, "Desenvolvimento Web com JSF2"));
		cursos.add(new SelectItem(3, "Persistência de Dados com JPA 2 e Hibernate"));
		cursos.add(new SelectItem(4, "Gerenciamento Agil de Projetos com Scrum"));
		this.cursos = cursos;
		return cursos;
	}
	
	public List<PagamentoDTO> verificarMetodo(){
		if (metodoDTO.getCodigo() == 1){
			carregarCartao();
		}
		if (metodoDTO.getCodigo() == 2){
			carregarCheque();
		}
		if (metodoDTO.getCodigo() == 3){
			carregarBoleto();
		}
		
		return PAGAMENTOS;
	}
	
	public void cadastrar() {
		System.out.println("Razao Social: " + this.razaoSocial);
		System.out.println("CNPJ: " + this.cnpj);
		System.out.println("Cidade: " + this.cidade);
		System.out.println("Modalidade: " + this.modalidade);
		System.out.println("Data do Contrato: " + this.dataContrato);
		System.out.println("Valor do Contrato: " + this.valorContrato);
		System.out.println("Metodo de Pagamento: " + this.metodoDTO.getDescricao());
		System.out.println("Formas de Pagamento: " + this.pagamentoDTO.getDescricao());

		for(String curso: selecaoCursos) {
				Integer index = Integer.parseInt(curso);
				System.out.println("Cursos: " + cursos.get(index-1).getLabel());
			}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro realizado!"));
	}
	
	public List<String> sugerirCidades(String consulta){
		List<String> cidadesSugeridas = new ArrayList<>();
		for (String cidade : this.cidades) {
			if(cidade.toLowerCase().startsWith(consulta.toLowerCase())) {
				cidadesSugeridas.add(cidade);
			}
		}
		return cidadesSugeridas;
	}
	
	public List<MetodoDTO> getMetodos(){
		return METODOS;
	}
	
	public List<PagamentoDTO> getPagamentos(){
		return PAGAMENTOS;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}

	public Long getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(Long valorContrato) {
		this.valorContrato = valorContrato;
	}

	public Integer getMetodo() {
		return metodo;
	}

	public void setMetodo(Integer metodo) {
		this.metodo = metodo;
	}

	public List<String> getCidades() {
		return cidades;
	}

	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}

	public MetodoDTO getMetodoDTO() {
		return metodoDTO;
	}

	public void setMetodoDTO(MetodoDTO metodoDTO) {
		this.metodoDTO = metodoDTO;
	}

	public static List<MetodoDTO> getMETODOS() {
		return METODOS;
	}

	public static void setMETODOS(List<MetodoDTO> mETODOS) {
		METODOS = mETODOS;
	}

	public PagamentoDTO getPagamentoDTO() {
		return pagamentoDTO;
	}

	public void setPagamentoDTO(PagamentoDTO pagamentoDTO) {
		this.pagamentoDTO = pagamentoDTO;
	}

	public static List<PagamentoDTO> getPAGAMENTOS() {
		return PAGAMENTOS;
	}

	public static void setPAGAMENTOS(List<PagamentoDTO> pAGAMENTOS) {
		PAGAMENTOS = pAGAMENTOS;
	}


	public List<String> getSelecaoCursos() {
		return selecaoCursos;
	}

	public void setSelecaoCursos(List<String> selecaoCursos) {
		this.selecaoCursos = selecaoCursos;
	}

	public List<SelectItem> getCursos() {
		return cursos;
	}

	public void setCursos(List<SelectItem> cursos) {
		this.cursos = cursos;
	}


}