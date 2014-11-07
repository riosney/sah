package sah.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import sah.profissao.Profissao;
import sah.profissao.ProfissaoRN;

@ManagedBean(name = "profissaoBean")
@RequestScoped
public class ProfissaoBean {
	
	private Profissao selecionada = new Profissao();
	private List<Profissao> lista;
	ProfissaoRN profissaoRN = new ProfissaoRN();
	
	public void salvar(){
		// obter depois o objeto contexto atual: ContextoBean contextoBean = ContextoUtil.getContextoBean();
		// obter depois o objeto usuário logado: this.selecionada.setUsuario(contextoBean.getUsuarioLogado());
		
		profissaoRN.salvar(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Cadastrado com sucesso!"));
		
		// Limpar campos do formulário
		this.selecionada = new Profissao();
		this.lista = null;
	}
	
	public void excluir(){
		profissaoRN.excluir(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Cadastrado com sucesso!"));
		
		// Limpar campos do formulário
		this.selecionada = new Profissao();
		this.lista = null;
	}
	
	public Profissao getSelecionada(){
		return selecionada;
	}
	
	public void setSelecionada(Profissao selecionada){
		this.selecionada = selecionada;
	}
	
	public List<Profissao> getLista(){
		if (this.lista == null) {
			this.lista = profissaoRN.listar();
		}
		return this.lista;
	}
	
	public void setLista(List<Profissao> lista){
		this.lista = lista;
	}

}
