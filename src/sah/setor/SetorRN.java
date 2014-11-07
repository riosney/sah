package sah.setor;

import java.util.List;
import sah.util.DAOFactory;

public class SetorRN {

	private SetorDAO setorDAO;
	
	public SetorRN(){
		this.setorDAO = DAOFactory.criarSetorDAO();
	}
	
	public Setor carregar(Long id){
		return this.setorDAO.carregar(id);
	}
	
	public Setor buscarPorSetor(String setor){
		return this.setorDAO.buscarPorSetor(setor);
	}
	
	public void salvar(Setor setor){
		this.setorDAO.salvar(setor);
	}
	
	public void excluir(Setor setor){
		this.setorDAO.excluir(setor);
	}
	
	public List<Setor> listar(){
		return this.setorDAO.listar();
	}
	
}
