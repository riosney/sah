package sah.web;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/*
 * Bean respons�vel por carregar p�ginas
 * que s�o chamadas pelo menu_sistema
 */
@ManagedBean(name = "menuBean")
public class MenuBean {
	
	public String cadastrarCidadao() {
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/restrito/pessoa";
	}
	
	public String pesquisarCidadao(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/atendimento/buscar_cidadao";
	}
	
	public String novoAtendimento(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/restrito/atendimento";
	}
	
	public String atendimentoHistorico(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/atendimento/atendimento_historico";
	}
	
	public String setorMCMV(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/mcmv/atendimento";
	}
	
	public String setorDPS(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/dps/atendimento";
	}
	
	public String setorVicePresidencia(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/vicePresidencia/atendimento";
	}
	
	public String setorPresidencia(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/presidencia/atendimento";
	}
	
	public String setorDPH(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/dph/atendimento";
	}
	
	public String setorPROJUR(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/projur/atendimento";
	}
	
	public String setorDPCOM(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/dpcom/atendimento";
	}
	
	public String setorAluguelSocial(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/aluguelSocial/atendimento";
	}
	
	public String setorDAF(){
		// Limpar sess�o de pessoaBean ao carregar a p�gina
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/daf/atendimento";
	}
	
	
}
