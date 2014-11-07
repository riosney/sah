package sah.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import sah.setor.Setor;
import sah.setor.SetorRN;

@ManagedBean(name = "setorBean")
@RequestScoped
public class SetorBean {
	
	private Setor selecionada = new Setor();
	private List<Setor> lista;
	
	public void salvar(){
		SetorRN setorRN = new SetorRN();
		// obter depois o objeto contexto atual: ContextoBean contextoBean = ContextoUtil.getContextoBean();
		// obter depois o objeto usuário logado: this.selecionada.setUsuario(contextoBean.getUsuarioLogado());
		
		// Salvar o valor Sigla em maiúsculo
		this.selecionada.setSigla(this.selecionada.getSigla().toUpperCase());
		setorRN.salvar(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso!"));
        
        // Limpar campos no formulário
        this.selecionada = new Setor();
        this.lista = null;
	}
	
	public void excluir(){
		SetorRN setorRN = new SetorRN();
		setorRN.excluir(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Excluído com Sucesso!"));
				
		// Limpar campos no formulário
		this.selecionada = new Setor();
		this.lista = null;
	}
	
	// GET & SET

	public List<Setor> getLista() {
		SetorRN setorRN = new SetorRN();
		if (this.lista == null) {
			this.lista = setorRN.listar();
		}
		return this.lista;
	}

	public void setLista(List<Setor> lista) {
		this.lista = lista;
	}

	public Setor getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Setor selecionada) {
		this.selecionada = selecionada;
	}
	
	

}
