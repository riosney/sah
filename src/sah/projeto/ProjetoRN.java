package sah.projeto;

import java.util.List;
import sah.util.DAOFactory;

public class ProjetoRN {
	
	private ProjetoDAO projetoDAO;
	
	public ProjetoRN(){
		this.projetoDAO = DAOFactory.criarProjetoDAO();
	}
	
	public Projeto carregar(Long id){
		return this.projetoDAO.carregar(id);
	}
	
	public Projeto buscarProjeto(String nome){
		return this.projetoDAO.buscarProjeto(nome);
	}
	
	public void salvar(Projeto projeto){
		this.projetoDAO.salvar(projeto);
	}
	
	public void excluir(Projeto projeto){
		this.projetoDAO.excluir(projeto);
	}
	
	public List<Projeto> listar(){
		return this.projetoDAO.listar();
	}

}
