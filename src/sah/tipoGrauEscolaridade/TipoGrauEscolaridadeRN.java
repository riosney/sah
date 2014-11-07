package sah.tipoGrauEscolaridade;

import java.util.List;
import sah.util.DAOFactory;

public class TipoGrauEscolaridadeRN {
	
	private TipoGrauEscolaridadeDAO tipoGrauEscolaridadeDAO;
	
	public TipoGrauEscolaridadeRN(){
		this.tipoGrauEscolaridadeDAO = DAOFactory.criarTipoGrauEscolaridadeDAO();
	}
	
	public TipoGrauEscolaridade carregar(Long id){
		return this.tipoGrauEscolaridadeDAO.carregar(id);
	}
	
	public TipoGrauEscolaridade buscarPorTipoGrauEscolaridade(String tipoGrauEscolaridade){
		return this.tipoGrauEscolaridadeDAO.buscarTipoGrauEscolaridade(tipoGrauEscolaridade);
	}
	
	public void salvar(TipoGrauEscolaridade tipoGrauEscolaridade){
		this.tipoGrauEscolaridadeDAO.salvar(tipoGrauEscolaridade);
	}
	
	public void excluir(TipoGrauEscolaridade tipoGrauEscolaridade){
		this.tipoGrauEscolaridadeDAO.excluir(tipoGrauEscolaridade);
	}
	
	public List<TipoGrauEscolaridade> listar(){
		return this.tipoGrauEscolaridadeDAO.listar();
	}

}
