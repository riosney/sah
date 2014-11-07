package sah.web;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/*
 * Bean responsável por carregar páginas
 * que são chamadas pelo menu_sistema
 */
@ManagedBean(name = "menuBean")
public class MenuBean {
	
	public String cadastrarCidadao() {
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/restrito/pessoa";
	}
	
	public String pesquisarCidadao(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/atendimento/buscar_cidadao";
	}
	
	public String novoAtendimento(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/restrito/atendimento";
	}
	
	public String atendimentoHistorico(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/atendimento/atendimento_historico";
	}
	
	public String setorMCMV(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/mcmv/atendimento";
	}
	
	public String setorDPS(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/dps/atendimento";
	}
	
	public String setorVicePresidencia(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/vicePresidencia/atendimento";
	}
	
	public String setorPresidencia(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/presidencia/atendimento";
	}
	
	public String setorDPH(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/dph/atendimento";
	}
	
	public String setorPROJUR(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/projur/atendimento";
	}
	
	public String setorDPCOM(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/dpcom/atendimento";
	}
	
	public String setorAluguelSocial(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/aluguelSocial/atendimento";
	}
	
	public String setorDAF(){
		// Limpar sessão de pessoaBean ao carregar a página
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaBean");
		return "/setor/daf/atendimento";
	}
	
	
}
