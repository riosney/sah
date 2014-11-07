package sah.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.bean.*;

import br.com.caelum.stella.format.CPFFormatter;
import sah.historicoAtendimento.HistoricoAtendimento;
import sah.pessoa.Pessoa;
import sah.pessoa.PessoaRN;
import sah.telefone.Telefone;
import sah.telefone.TelefoneRN;
import sah.tipoDeficienciaFisica.TipoDeficienciaFisica;

@ManagedBean(name = "pessoaBean")
@SessionScoped
public class PessoaBean {

	// Pessoa
	private Pessoa selecionada = new Pessoa();	
	private List<HistoricoAtendimento> listaConsulta = null;
	private List<Pessoa> lista;
	private UIInput uiCPF;
	
	String valorComFormato;
	
	// Telefone
	private TelefoneBean telefoneBean = new TelefoneBean();	
	private List<Telefone> listaPessoaTel = new ArrayList<Telefone>();
	
	// TipoDeficienciaFisicaBean
	private TipoDeficienciaFisicaBean tipoDeficienciaFisicaBean = new TipoDeficienciaFisicaBean();
	private List<TipoDeficienciaFisica> listaDef = new ArrayList<TipoDeficienciaFisica>();
	
	/**
	 * Método salvar
	 * <p>Esse método executa ação de salvar Pessoa(), o seu contato
	 * e Deficiência</p>
	 * @return this.selecionada lista que retorna os valores de Pessoa
	 * @return this.listaDef lista que retorna os valores de TipoDeficienciaFisica
	 * @return this.listaPessoaTel lista que retorna os valores de Telefone
	 * @author Riosney Santos
	 */
	public void salvar(){
		PessoaRN pessoaRN = new PessoaRN();
		FacesContext context = FacesContext.getCurrentInstance();
		
		// Confere se o campo telefone tem ao menos um número registrado
		if(this.listaPessoaTel.isEmpty()){
			context.addMessage("txt_numero", new FacesMessage("Opa! Falta o telefone"));
		}else{
			
			if (this.selecionada.getId() == null) {
				pessoaRN.salvar(this.selecionada);       
		        // Mensagem de cadastrado com sucesso
		        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso!"));
			}else{
				// Limpar atributo TipoDeficienciaFisicas para receber novos valores
				Set<TipoDeficienciaFisica> limparListaDeficiente = this.selecionada.getTipoDeficienciaFisicas();
				for (int i = 0; i < limparListaDeficiente.size(); i++) {
					if (!this.listaDef.contains(limparListaDeficiente)) {
						this.selecionada.getTipoDeficienciaFisicas().clear();
					}
				}
				
				pessoaRN.salvar(this.selecionada);	
				
		        // Mensagem de cadastrado com sucesso				
				context.addMessage(null, new FacesMessage("Alterado com Sucesso!"));
			}						
	        
	        // Salva lista de deficientes			
			for (int i = 0; i < this.listaDef.size(); i++) {				
				this.selecionada.getTipoDeficienciaFisicas().add(this.listaDef.get(i));
			}
			
			Telefone telefone = new Telefone();
			TelefoneRN telefoneRN = new TelefoneRN();
			
			// Salva lista de telefones
			for (int i = 0; i < this.listaPessoaTel.size(); i++) {			
				telefone = this.listaPessoaTel.get(i);
				telefone.setIdpessoa(pessoaRN.carregar(this.selecionada.getId()));
				telefoneRN.salvar(telefone);
			}
			
			// Limpar campos no formulário
			this.selecionada = new Pessoa();
			this.listaPessoaTel = new ArrayList<Telefone>();
			this.listaDef = new ArrayList<TipoDeficienciaFisica>();
		}
	}
	
	/**
	 * Método confereCampoTelefone
	 * <p>Esse método confere se o campo telefone tem ao menos
	 * um número registrado</p>
	 * @return retorna mensagem e valor nulo caso o campo não esteja preenchido
	 * @author Riosney Santos
	 */
	public String confereCampoTelefone(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(this.listaPessoaTel.isEmpty()){
			context.addMessage("txt_numero", new FacesMessage("Opa! Falta o telefone"));
			return null;
		}
		return null;
	}
	
	/**
	 * Método confereCPF
	 * <p>Método no qual remove a formatação do CPF e confere no
	 * banco de dados se já existe</p>
	 * @return retorna uma mensagem de 'CPF já cadastrado!' ou 'CPF disponível!'.
	 * @author Riosney Santos
	 */
	public String confereCPF(){
		FacesContext context = FacesContext.getCurrentInstance();

		//Removendo formatação CPF
		CPFFormatter formatter = new CPFFormatter();
		String valorFormatado = this.selecionada.getCpf();
		String valorSemFormato = formatter.unformat(valorFormatado);		
		
		//Compara CPF no banco de dados
		PessoaRN pessoaRN = new PessoaRN();
		Pessoa valorCPF = pessoaRN.buscarPorCPF(valorSemFormato);		
		//this.selecionada.getId() == null
		if (valorCPF != null) {
			context.addMessage("cpf", new FacesMessage("CPF já cadastrado!"));
			this.selecionada.setCpf("");
			return null;
		}else{
			context.addMessage("cpf", new FacesMessage("CPF disponível!"));
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String confereCadastro(){
		FacesContext context = FacesContext.getCurrentInstance();

		//Removendo formatação CPF
		CPFFormatter formatter = new CPFFormatter();
		String valorFormatado = this.selecionada.getCpf();
		String valorSemFormato = formatter.unformat(valorFormatado);		
		
		//Compara CPF no banco de dados
		PessoaRN pessoaRN = new PessoaRN();
		Pessoa valorCPF = pessoaRN.buscarPorCPF(valorSemFormato);
		
		String buscaCpf = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("buscaCpf");
		String historico = "buscarHistoricoAtendimento";
		String cidadao = "buscarCidadao";
		String notoAtendimento = "novoAtendimento";
		//getUiCPF().setSubmittedValue(""); // limpar campo CPF
		//this.selecionada.setCpf("");
		
		if (valorCPF != null) {
			if (notoAtendimento.equals(buscaCpf)) {
				this.valorComFormato = formatter.format(valorSemFormato);
				this.selecionada = valorCPF;
				return null;
			}else if (valorCPF != null && historico.equals(buscaCpf)) {
				this.valorComFormato = formatter.format(valorSemFormato);
				this.listaConsulta = valorCPF.getAtendimentos();
				return null;
			}else if(valorCPF != null && cidadao.equals(buscaCpf)){			
				this.valorComFormato = formatter.format(valorSemFormato);
				this.selecionada = valorCPF;
				this.listaPessoaTel = valorCPF.getTelefones();
				//this.listaDeficiente = valorCPF.getTipoDeficienciaFisicas();
				this.listaDef = new ArrayList(valorCPF.getTipoDeficienciaFisicas());
				return null;
			}
		}else{
			context.addMessage("cpf", new FacesMessage("CPF disponível!"));
			
			// Limpar campos no formulário
			this.valorComFormato = null;
			this.lista = null;
			this.selecionada = new Pessoa();
			this.listaPessoaTel = new ArrayList<Telefone>();
		}
		return null;		
	}
	
	/**
	 * Método editar Pessoa()
	 * <p>Método criado para editar as informações de Pessoa(), onde é coletado
	 * os dados através de suas instâncias e podendo os dados ser alterados
	 * ao ser retornado a página "/restrito/pessoa"</p>		
	 * @return "/restrito/pessoa"
	 */
	public String editar(){
		return "/restrito/pessoa";
	}
	
	public void excluir(){		
	}

	/** Getters and Setters **/
	
	public Pessoa getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Pessoa selecionada) {
		this.selecionada = selecionada;
	}

	public TelefoneBean getTelefoneBean() {
		return telefoneBean;
	}

	public void setTelefoneBean(TelefoneBean telefoneBean) {
		this.telefoneBean = telefoneBean;
	}

	public List<Telefone> getListaPessoaTel() {
		return listaPessoaTel;
	}

	public void setListaPessoaTel(List<Telefone> listaPessoaTel) {
		this.listaPessoaTel = listaPessoaTel;
	}

	public List<TipoDeficienciaFisica> getListaDef() {
		return listaDef;
	}

	public void setListaDef(List<TipoDeficienciaFisica> listaDef) {
		this.listaDef = listaDef;
	}

	public TipoDeficienciaFisicaBean getTipoDeficienciaFisicaBean() {
		return tipoDeficienciaFisicaBean;
	}

	public void setTipoDeficienciaFisicaBean(
			TipoDeficienciaFisicaBean tipoDeficienciaFisicaBean) {
		this.tipoDeficienciaFisicaBean = tipoDeficienciaFisicaBean;
	}

	public String getValorComFormato() {
		return valorComFormato;
	}

	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}

	public List<HistoricoAtendimento> getListaConsulta() {
		return listaConsulta;
	}

	public void setListaConsulta(List<HistoricoAtendimento> listaConsulta) {
		this.listaConsulta = listaConsulta;
	}

	public UIInput getUiCPF() {
		return uiCPF;
	}

	public void setUiCPF(UIInput uiCPF) {
		this.uiCPF = uiCPF;
	}	
	
		
	
}
