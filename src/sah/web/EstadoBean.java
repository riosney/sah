package sah.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import sah.estado.Estado;
import sah.estado.EstadoRN;

@ManagedBean(name = "estadoBean")
@RequestScoped
public class EstadoBean {
	
	private Estado selecionada = new Estado();
	private List<Estado> lista;
	EstadoRN estadoRN = new EstadoRN();
	
	public void salvar(){
		// obter depois o objeto contexto atual: ContextoBean contextoBean = ContextoUtil.getContextoBean();
		// obter depois o objeto usuário logado: this.selecionada.setUsuario(contextoBean.getUsuarioLogado());
		
		// Salvar o valor Sigla em maiúsculo
		this.selecionada.setSigla(this.selecionada.getSigla().toUpperCase());
		estadoRN.salvar(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso!"));
        
        // Limpar campos no formulário
        this.selecionada = new Estado();
        this.lista = null;
	}
	
	public void excluir(){		
		estadoRN.excluir(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Excluído com Sucesso!"));
		
		// Limpar campos do formulário
		this.selecionada = new Estado();
		this.lista = null;
	}

	public Estado getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Estado selecionada) {
		this.selecionada = selecionada;
	}

	public List<Estado> getLista() {
		if (this.lista == null) {			
			this.lista = estadoRN.listar();
		}
		return this.lista;
	}

	public void setLista(List<Estado> lista) {
		this.lista = lista;
	}
	
	
	
}
