package sah.telefone;

import java.util.List;

import sah.util.DAOFactory;

public class TelefoneRN {
	
	private TelefoneDAO telefoneDAO;
	
	public TelefoneRN(){
		this.telefoneDAO = DAOFactory.criarTelefoneDAO();
	}
	
	public Telefone carregar(Long id){
		return this.telefoneDAO.carregar(id);
	}
	
	public Telefone buscarPorTelefone(String telefone){
		return this.telefoneDAO.buscarTelefone(telefone);
	}
	
	public void excluir(Telefone telefone){
		this.telefoneDAO.excluir(telefone);
	}
	
	public List<Telefone> listar(){
		return this.telefoneDAO.listar();
	}

	public void salvar(Telefone telefone) {
		this.telefoneDAO.salvar(telefone);		
	}
	

}
