package sah.bairro;

import java.util.List;
import sah.util.DAOFactory;

public class BairroRN {
	
	private BairroDAO bairroDAO;
	
	public BairroRN(){
		this.bairroDAO = DAOFactory.criarBairroDAO();
	}
	
	public Bairro carregar(Long id){
		return this.bairroDAO.carregar(id);
	}
	
	public Bairro buscarPorBairro(String bairro){
		return this.bairroDAO.buscarBairro(bairro);
	}
	
	public void salvar(Bairro bairro){
		this.bairroDAO.salvar(bairro);
	}
	
	public void excluir(Bairro bairro){
		this.bairroDAO.excluir(bairro);
	}
	
	public List<Bairro> listar(){
		return this.bairroDAO.listar();
	}

}
