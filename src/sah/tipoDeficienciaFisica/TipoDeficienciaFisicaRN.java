package sah.tipoDeficienciaFisica;

import java.util.List;

import sah.util.DAOFactory;

public class TipoDeficienciaFisicaRN {
	
	private TipoDeficienciaFisicaDAO tipoDeficienciaFisicaDAO;
	
	public TipoDeficienciaFisicaRN(){
		this.tipoDeficienciaFisicaDAO = DAOFactory.criarTipoDeficienciaFisicaDAO();
	}
	
	public TipoDeficienciaFisica carregar(Long id){
		return this.tipoDeficienciaFisicaDAO.carregar(id);
	}
	
	public TipoDeficienciaFisica buscarPorTipoDeficienciaFisica(String tipoDeficienciaFisica){
		return this.tipoDeficienciaFisicaDAO.buscarTipoDeficienciaFisica(tipoDeficienciaFisica);
	}
	
	public void salvar(TipoDeficienciaFisica tipoDeficienciaFisica){
		this.tipoDeficienciaFisicaDAO.salvar(tipoDeficienciaFisica);
	}
	
	public void excluir(TipoDeficienciaFisica tipoDeficienciaFisica){
		this.tipoDeficienciaFisicaDAO.excluir(tipoDeficienciaFisica);
	}
	
	public List<TipoDeficienciaFisica> listar(){
		return this.tipoDeficienciaFisicaDAO.listar();
	}

}
