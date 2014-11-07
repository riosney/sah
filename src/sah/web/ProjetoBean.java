package sah.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import sah.projeto.Projeto;
import sah.projeto.ProjetoRN;

@ManagedBean(name = "projetoBean")
@RequestScoped
public class ProjetoBean {
	
	private Projeto selecionada = new Projeto();
	private List<Projeto> lista;
	ProjetoRN projetoRN = new ProjetoRN();
	
	public void salvar(){
		// obter depois o objeto contexto atual: ContextoBean contextoBean = ContextoUtil.getContextoBean();
		// obter depois o objeto usuário logado: this.selecionada.setUsuario(contextoBean.getUsuarioLogado());
		
		// Salvar o valor Sigla em maiúsculo
		this.selecionada.setSigla(this.selecionada.getSigla().toUpperCase());
		this.selecionada.setNome(this.selecionada.getNome().trim());
		projetoRN.salvar(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Cadastrado com Sucesso!"));
		
		// Limpar campos no formulário
		this.selecionada = new Projeto();
		this.lista = null;
	}
	
	public void excluir(){
		projetoRN.excluir(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Excluído com Sucesso!"));
		
		// Limpar campos no formulário
		this.selecionada = new Projeto();
		this.lista = null;
	}
	
	public Projeto getSelecionada(){
		return selecionada;
	}
	
	public void setSelecionada(Projeto selecionada){
		this.selecionada = selecionada;
	}
	
	public List<Projeto> getLista(){
		if (this.lista == null) {
			this.lista = projetoRN.listar();
		}
		return this.lista;
	}
	
	public void setLista(List<Projeto> lista){
		this.lista = lista;
	}

}
