package sah.profissao;

import java.util.List;

import sah.util.DAOFactory;

public class ProfissaoRN {
	
	private ProfissaoDAO profissaoDAO;
	
	public ProfissaoRN(){
		this.profissaoDAO = DAOFactory.criarProfissaoDAO();
	}
	
	public void salvar(Profissao profissao){
		this.profissaoDAO.salvar(profissao);
	}
	
	public void excluir(Profissao profissao){
		this.profissaoDAO.excluir(profissao);
	}
	
	public Profissao carregar(Long id){
		return this.profissaoDAO.carregar(id);
	}
	
	public Profissao buscarProfissao(String nomeProfissao){
		return this.profissaoDAO.buscarProfissao(nomeProfissao);
	}
	
	public List<Profissao> listar(){
		return this.profissaoDAO.listar();
	}

}
