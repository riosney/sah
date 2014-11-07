package sah.web;

import javax.faces.bean.*;

import java.util.List;

import sah.telefone.*;

@ManagedBean(name = "telefoneBean")
@SessionScoped
public class TelefoneBean {
	
	private Telefone selecionada = new Telefone();
	private List<Telefone> lista = null;
	
	public String criarNovo(){
		selecionada = new Telefone(); // reset form
		return null;
	}
	
	public void salvar(){
		TelefoneRN telefoneRN = new TelefoneRN();
		telefoneRN.salvar(this.selecionada);
	}
	
	public void editar(){}	
	
	public void excluir(){}

	public Telefone getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Telefone selecionada) {
		this.selecionada = selecionada;
	}

	public List<Telefone> getLista() {		
		if(this.lista == null){
			TelefoneRN telefoneRN = new TelefoneRN();
			this.lista = telefoneRN.listar();
		} 
		return lista;
	}

	public void setLista(List<Telefone> lista) {
		this.lista = lista;
	}
	
	

}
