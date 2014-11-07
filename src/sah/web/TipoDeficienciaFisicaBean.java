package sah.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import sah.tipoDeficienciaFisica.TipoDeficienciaFisica;
import sah.tipoDeficienciaFisica.TipoDeficienciaFisicaRN;

@ManagedBean(name = "tipoDeficienciaFisicaBean")
@RequestScoped
public class TipoDeficienciaFisicaBean {
	
	private TipoDeficienciaFisica selecionada = new TipoDeficienciaFisica();
	private List<TipoDeficienciaFisica> lista;
	
	public String criarNovo(){
		selecionada = new TipoDeficienciaFisica(); // reset form
		return null;
	}
	
	public void salvar(){
		TipoDeficienciaFisicaRN tipoDeficienciaFisicaRN = new TipoDeficienciaFisicaRN();
		tipoDeficienciaFisicaRN.salvar(this.selecionada);
	}
	
	public void editar(){}
	
	public void excluir(){}

	public TipoDeficienciaFisica getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(TipoDeficienciaFisica selecionada) {
		this.selecionada = selecionada;
	}

	public List<TipoDeficienciaFisica> getLista() {
		if (this.lista == null) {
			TipoDeficienciaFisicaRN tipoDeficienciaFisicaRN = new TipoDeficienciaFisicaRN();
			this.lista = tipoDeficienciaFisicaRN.listar();
		}
		return lista;
	}

	public void setLista(List<TipoDeficienciaFisica> lista) {
		this.lista = lista;
	}
	
	

}
