package sah.web;

import javax.faces.bean.*;
import java.util.List;
import sah.tipoGrauEscolaridade.*;

@ManagedBean(name = "tipoGrauEscolaridadeBean")
@RequestScoped
public class TipoGrauEscolaridadeBean {
	
	private TipoGrauEscolaridade selecionada = new TipoGrauEscolaridade();
	private List<TipoGrauEscolaridade> lista;
	
	public void salvar(){
		TipoGrauEscolaridadeRN tipoGrauEscolaridadeRN = new TipoGrauEscolaridadeRN();
		tipoGrauEscolaridadeRN.salvar(this.selecionada);
	}
	
	public void editar(){		
	}
	
	public void excluir(){		
	}

	public TipoGrauEscolaridade getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(TipoGrauEscolaridade selecionada) {
		this.selecionada = selecionada;
	}

	public List<TipoGrauEscolaridade> getLista() {
		if(this.lista == null){
			TipoGrauEscolaridadeRN tipoGrauEscolaridadeRN = new TipoGrauEscolaridadeRN();
			this.lista = tipoGrauEscolaridadeRN.listar();
		}
		return this.lista;
	}

	public void setLista(List<TipoGrauEscolaridade> lista) {
		this.lista = lista;
	}

}
