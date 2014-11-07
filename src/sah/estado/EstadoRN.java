package sah.estado;

import java.util.List;
import sah.util.DAOFactory;

public class EstadoRN {
	
	private EstadoDAO estadoDAO;
	
	public EstadoRN(){
		this.estadoDAO = DAOFactory.criarEstadoDAO();
	}
	
	public Estado carregar(Long id){
		return this.estadoDAO.carregar(id);
	}
	
	public Estado buscarPorBairro(String estado){
		return this.estadoDAO.buscarEstado(estado);
	}
	
	public void salvar(Estado estado){
		this.estadoDAO.salvar(estado);
	}
	
	public void excluir(Estado estado){
		this.estadoDAO.excluir(estado);
	}
	
	public List<Estado> listar(){
		return this.estadoDAO.listar();
	}

}
