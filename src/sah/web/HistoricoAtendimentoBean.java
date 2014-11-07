package sah.web;

import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.StreamedContent;

import sah.historicoAtendimento.HistoricoAtendimento;
import sah.historicoAtendimento.HistoricoAtendimentoRN;
import sah.pessoa.Pessoa;
import sah.pessoa.PessoaRN;
import sah.setor.Setor;
import sah.setor.SetorRN;
import sah.util.UtilException;
import sah.web.util.ContextoUtil;
import sah.web.util.RelatorioUtil;

@ManagedBean(name = "historicoAtendimentoBean")
@SessionScoped
public class HistoricoAtendimentoBean {
	
	private HistoricoAtendimento selecionada = new HistoricoAtendimento();
	private List<HistoricoAtendimento> lista;
	private List<HistoricoAtendimento> listarSetorEmAtendimento;
	private HistoricoAtendimento listaPessoaAtual;
	
	private String cpf;
	private String idpess;
	private Long idPessoaLong;
	private String situacaoAtendimento; // Resgata o valor para saber a situa��o do atendimento
	private String displayCSS;
	private String valorComFormato;
	
	// Recupera o valor do estadoDoAtendimento ao fazer atendimento
	private String estadoDoAtendimento;
	
	// Relat�rio
	private StreamedContent arquivoRetorno;
	private int tipoRelatorio;
	
	/**
	 *  M�todo novo() de HistoricoAtendimentoBean
	 *  <p>Esse m�todo � chamado na p�gina /restrito/atendimento, para resgatar
	 *  o id de Pessoa(), converte de em Long, o qual � populado no atributo
	 *  idPessoaLong e vai � p�gina /atendimento/fazer_atendimento.</p>
	 *  @return retorna a p�gina /atendimento/fazer_atendimento
	 *  @author Riosney Santos
	 */
	public String novo(){
		this.idpess = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idpessoa");
		if (!this.idpess.equals("null")) {
			this.setIdPessoaLong(Long.parseLong(idpess));
			PessoaRN pessoaRN = new PessoaRN();
			this.selecionada.setPessoaatendimento(pessoaRN.carregar(this.getIdPessoaLong()));
			return "/atendimento/fazer_atendimento";
		}else{			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("msgs", new FacesMessage("Opa! Pesquise pelo CPF"));
			return null;
		}
		
	}	
	
	/**
	 * M�todo salvar() atendimento
	 * <p>Esse m�todo executa a��o de salvar o atendimento referente a Pessoa().
	 * Requer o idpessoa, populando o atributo idpess, faz a convers�o para Long
	 * e popula em setPessoaatendimento</p>
	 * @param idpessoa
	 * @return pessoaRN.carregar(this.getIdPessoaLong()) recuperar o valor idpessoa
	 * @author Riosney Santos
	 */
	public void salvar(){
		// Obter o objeto contexto atual
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		// Obter o objeto usu�rio logado
		this.selecionada.setUsuario(contextoBean.getUsuarioLogado());
		
		HistoricoAtendimentoRN historicoAtendimentoRN = new HistoricoAtendimentoRN();
		PessoaRN pessoaRN = new PessoaRN();
		
		// Capitura o campo idpessoa e estadoDoAtendimento
		this.idpess = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idpessoa");
		this.estadoDoAtendimento = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("estadoDoAtendimento");
		
		if (this.idpess != null) {
			this.setIdPessoaLong(Long.parseLong(idpess));
			this.selecionada.setPessoaatendimento(pessoaRN.carregar(this.getIdPessoaLong()));
		}
		
		// Verifica se � um atendimento continuo que foi direcionado a outro setor
		if (this.listaPessoaAtual != null) {
			this.selecionada.setPessoaatendimento(this.listaPessoaAtual.getPessoaatendimento());
			this.selecionada.setEstadoAtendimento(this.estadoDoAtendimento);			
			this.selecionada.setSetor(this.listaPessoaAtual.getSetor());
			historicoAtendimentoRN.salvar(this.selecionada);
			
			this.listaPessoaAtual.setEstadoAtendimento(this.estadoDoAtendimento);
			historicoAtendimentoRN.salvar(this.listaPessoaAtual);
			
			this.displayCSS = "none";
		}else{
			this.selecionada.setEstadoAtendimento(this.estadoDoAtendimento);
			historicoAtendimentoRN.salvar(this.selecionada);
		}		
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Atendimento registrado!"));
		
		// Limpar campos no formul�rio
        this.selecionada = new HistoricoAtendimento();
        this.listaPessoaAtual = new HistoricoAtendimento();
        this.lista = null;
	}
	
	public void excluir(){
		HistoricoAtendimentoRN historicoAtendimentoRN = new HistoricoAtendimentoRN();
		historicoAtendimentoRN.excluir(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Exclu�do com Sucesso!"));
		
		// Limpar campos no formul�rio
        this.selecionada = new HistoricoAtendimento();
        this.lista = null;
	}
	
	/**
	 * M�todo listarSituacaoAtendimento
	 * <p>Esse m�todo � respons�vel por gerar uma lista dos atendimentos de acordo com seu estado,
	 *  no setor espec�fico. Ao ser chamado na tela do 'setor', preencha com dois par�metros, um �
	 *  a sigla do setor e a outra o estado de atendimento, que pode ser: emEspera, emAtendimento, 
	 *  Finalizado ou Cancelado. Retornando os valores desejados.</p>
	 * @param siglaSetor
	 * @param situacaoAtendimento
	 * @return listarSetorEmAtendimento
	 */
	public List<HistoricoAtendimento> listarSituacaoEmFila(String siglaSetor, String situacaoAtendimento) {
		SetorRN setorRN = new SetorRN();
		HistoricoAtendimentoRN historicoAtendimentoRN = new HistoricoAtendimentoRN();
		Setor setor = setorRN.buscarPorSetor(siglaSetor);
		
		if (!historicoAtendimentoRN.listarSetorEmFila(setor, situacaoAtendimento).isEmpty()) {
			return this.listarSetorEmAtendimento =  historicoAtendimentoRN.listarSetorEmFila(setor, situacaoAtendimento);
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("msgs", new FacesMessage("Sem atendimento"));
			return null;
		}
		
		/*this.listarSetorEmAtendimento =  historicoAtendimentoRN.listarSetorEmFila(setor, situacaoAtendimento);
		
		if (this.listarSetorEmAtendimento != null) {
			return this.listarSetorEmAtendimento;
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("msgs", new FacesMessage("Sem atendimento"));
			return null;
		}*/	
	}
	
	/**
	 * M�todo fazerAtendimento
	 * <p> M�todo respons�vel por recurar dois par�metros, para informar quem ser� atendido e em
	 * qual setor. Caso retorne um atendimento ser� redirecionado a p�gina telaEmAtendimento.xhtml,
	 * do contr�rio a p�gina atendimentoMCMV.xhtml.
	 * Tamb�m carrega a lista de �ltimos atendimentos da pessoa.</p>
	 * @return
	 */
	public String fazerAtendimento(String paginaSetor){
		// Limpar campos
		//this.listarSetorEmAtendimento = null;
				
		ContextoBean contextoBean = ContextoUtil.getContextoBean(); // Obter o objeto contexto atual
		this.selecionada.setUsuario(contextoBean.getUsuarioLogado()); // Obter o objeto usu�rio logado
		
		SetorRN setorRN = new SetorRN();
		HistoricoAtendimentoRN historicoAtendimentoRN = new HistoricoAtendimentoRN();
		
		// Valores espec�fico do setor nos atributos
		this.situacaoAtendimento = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("situacaoAtendimento");
		Setor setor = setorRN.buscarPorSetor(paginaSetor);
		
		if (!historicoAtendimentoRN.verificarPessoaEmAtendimento(this.selecionada.getUsuario(), "emAtendimento").isEmpty()) {
			// Busca no banco de dados atendimento com valor: emAtendimento
			this.listaPessoaAtual = historicoAtendimentoRN.verificarPessoaEmAtendimento(this.selecionada.getUsuario(), "emAtendimento").get(0);
			// Busca o hist�rico de atendimento da pessoa
			this.lista = historicoAtendimentoRN.listar(this.listaPessoaAtual.getPessoaatendimento());
			this.displayCSS = "block";
			
			return menuSetor(paginaSetor);
		}else if(!historicoAtendimentoRN.listarSetorEmFila(setor, this.situacaoAtendimento).isEmpty()){
				// Busca o primeiro da lista no banco de dados
				this.listaPessoaAtual = historicoAtendimentoRN.listarSetorEmFila(setor, this.situacaoAtendimento).get(0);
				// Busca o hist�rico de atendimento da pessoa
				this.lista = historicoAtendimentoRN.listar(this.listaPessoaAtual.getPessoaatendimento());
				// Muda o estado de atendimento ao ser direcionado
				this.listaPessoaAtual.setEstadoAtendimento("emAtendimento");
				this.displayCSS = "block";
				
				return menuSetor(paginaSetor);
			}else{
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("msgs", new FacesMessage("Foi atendido"));
				return null;
		}				
	}
	
	/**
	 * M�todo criado para definir o escopo do Menu de Setores, 
	 * retornando a p�gina de acordo com o setor desejado. 
	 * Futuramente fazer com switch do mesmo.
	 * @param paginaSetor
	 * @return
	 */
	public String menuSetor(String paginaSetor){
		if (paginaSetor.equals("MCMV")) {
			return "/setor/mcmv/telaEmAtendimento";
		}else if(paginaSetor.equals("AS")){
			return "/setor/aluguelSocial/telaEmAtendimento";
		}else if(paginaSetor.equals("DAF")){
			return "/setor/daf/telaEmAtendimento";
		}else if(paginaSetor.equals("DPCOM")){
			return "/setor/dpcom/telaEmAtendimento";
		}else if(paginaSetor.equals("DPH")){
			return "/setor/dph/telaEmAtendimento";
		}else if(paginaSetor.equals("DPS")){
			return "/setor/dps/telaEmAtendimento";
		}else if(paginaSetor.equals("PRESIDENCIA")){
			return "/setor/presidencia/telaEmAtendimento";
		}else if(paginaSetor.equals("PROJUR")){
			return "/setor/projur/telaEmAtendimento";
		}else if(paginaSetor.equals("VICE-P")){
			return "/setor/vicePresidencia/telaEmAtendimento";
		}else{
			return null;
		}
	}
		
	// GET & SET
	
	public HistoricoAtendimento getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(HistoricoAtendimento selecionada) {
		this.selecionada = selecionada;
	}

	public List<HistoricoAtendimento> getLista() {		
		return lista;
	}

	public void setLista(List<HistoricoAtendimento> lista) {
		this.lista = lista;
	}

	public Long getIdPessoaLong() {
		return idPessoaLong;
	}

	public void setIdPessoaLong(Long idPessoaLong) {
		this.idPessoaLong = idPessoaLong;
	}

	public String getValorComFormato() {
		return valorComFormato;
	}

	public void setValorComFormato(String valorComFormato) {
		this.valorComFormato = valorComFormato;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<HistoricoAtendimento> getListarSetorEmAtendimento() {
		return listarSetorEmAtendimento;
	}
	
	public void setListarSetorEmAtendimento(
			List<HistoricoAtendimento> listarSetorEmAtendimento) {
		this.listarSetorEmAtendimento = listarSetorEmAtendimento;
	}
	
	public HistoricoAtendimento getListaPessoaAtual() {
		return listaPessoaAtual;
	}
	
	public void setListaPessoaAtual(HistoricoAtendimento listaPessoaAtual) {
		this.listaPessoaAtual = listaPessoaAtual;
	}
	
	public String getDisplayCSS() {
		return displayCSS;
	}
	
	public void setDisplayCSS(String displayCSS) {
		this.displayCSS = displayCSS;
	}
	
	public StreamedContent getArquivoRetorno() {
		FacesContext context = FacesContext.getCurrentInstance();
		//ContextoBean contextoBean = ContextoUtil.getContextoBean();
		//String usuario = contextoBean.getUsuarioLogado().getLogin();		
		this.idpess = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idpessoa");		
		String nomeRelatorioJasper = "historico_atendimento";
		//String nomeRelatorioSaida = usuario + "_historico_atendimento";
		String nomeRelatorioSaida = "historico_atendimento";
		RelatorioUtil relatorioUtil = new RelatorioUtil();
		HashMap parametrosRelatorio = new HashMap();
		//parametrosRelatorio.put("idPessoa", contextoBean.getUsuarioLogado().getId());
		int idP = Integer.parseInt(idpess);
		parametrosRelatorio.put("idPessoa", idP);
		try {
			this.arquivoRetorno = relatorioUtil.geraRelatorio(parametrosRelatorio, nomeRelatorioJasper, nomeRelatorioSaida, this.tipoRelatorio);
		} catch (UtilException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
		return this.arquivoRetorno;
	}
	
	public void setArquivoRetorno(StreamedContent arquivoRetorno) {
		this.arquivoRetorno = arquivoRetorno;
	}
	
	public int getTipoRelatorio() {
		return tipoRelatorio;
	}
	
	public void setTipoRelatorio(int tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}
	

}
