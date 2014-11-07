package sah.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import org.primefaces.model.StreamedContent;

import sah.bairro.Bairro;
import sah.bairro.BairroRN;
import sah.util.UtilException;
import sah.web.util.ContextoUtil;
import sah.web.util.RelatorioUtil;

import java.util.HashMap;
import java.util.List;

@ManagedBean(name = "bairroBean")
@RequestScoped
public class BairroBean {
	
	private Bairro selecionada = new Bairro();
	private List<Bairro> lista;
	
	private StreamedContent arquivoRetorno;
	private int tipoRelatorio;
	
	public void salvar(){
		BairroRN bairroRN = new BairroRN();
		bairroRN.salvar(this.selecionada);
	}
	
	public void editar(){}
	
	public void excluir(){}

	public Bairro getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Bairro selecionada) {
		this.selecionada = selecionada;
	}

	public List<Bairro> getLista() {
		if(this.lista == null){
			BairroRN bairroRN = new BairroRN();
			this.lista = bairroRN.listar();
		}
		return this.lista;
	}

	public void setLista(List<Bairro> lista) {
		this.lista = lista;
	}

	public StreamedContent getArquivoRetorno() {
		FacesContext context = FacesContext.getCurrentInstance();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		String usuario = contextoBean.getUsuarioLogado().getLogin();
		String nomeRelatorioJasper = "bairro"; // nome físico do relatório que será exportado.
		String nomeRelatorioSaida = usuario + "_bairro"; // nome relatório com nome do usuário que fará download
		RelatorioUtil relatorioUtil = new RelatorioUtil();
		HashMap parametrosRelatorio = new HashMap();
		parametrosRelatorio.put("codigoUsuario", contextoBean.getUsuarioLogado().getId());
		try {
			this.arquivoRetorno = relatorioUtil.geraRelatorio(parametrosRelatorio, nomeRelatorioJasper, 
					nomeRelatorioSaida, tipoRelatorio);
		} catch (UtilException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
		return arquivoRetorno;
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
