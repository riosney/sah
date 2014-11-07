package sah.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import sah.cidade.Cidade;
import sah.cidade.CidadeRN;

@ManagedBean(name = "cidadeBean")
@RequestScoped
public class CidadeBean {
	
	//private EstadoBean estadoBean = new EstadoBean();
	
	private Cidade selecionada = new Cidade();
	private List<Cidade> lista;
	
	private EstadoBean estadoBean = new EstadoBean();
	
	public void salvar(){
		// obter depois o objeto contexto atual: ContextoBean contextoBean = ContextoUtil.getContextoBean();
		// obter depois o objeto usuário logado: this.selecionada.setUsuario(contextoBean.getUsuarioLogado());
		
		CidadeRN cidadeRN = new CidadeRN();
		cidadeRN.salvar(this.selecionada);
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso!"));
        
        // Limpar campos no formulário
        this.selecionada = new Cidade();
        this.lista = null;
	}
	
	public void excluir(){
		CidadeRN cidadeRN = new CidadeRN();
		cidadeRN.excluir(this.selecionada);
		
		// Limpar campos no formulário
		this.selecionada = new Cidade();
		this.lista = null;
		
		// Mensagem com sucesso
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Excluído com Sucesso!"));
	}

	public Cidade getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Cidade selecionada) {
		this.selecionada = selecionada;
	}

	public List<Cidade> getLista() {		
		if (this.lista == null) {
			CidadeRN cidadeRN = new CidadeRN();
			this.lista = cidadeRN.listar();
		}
		return lista;
	}

	public void setLista(List<Cidade> lista) {
		this.lista = lista;
	}

	public EstadoBean getEstadoBean() {
		return estadoBean;
	}

	public void setEstadoBean(EstadoBean estadoBean) {
		this.estadoBean = estadoBean;
	}


	

}
