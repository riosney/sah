package sah.cidade;

import java.util.List;
import sah.util.DAOFactory;

public class CidadeRN {
	
	private CidadeDAO cidadeDAO;
	
	public CidadeRN(){
		this.cidadeDAO = DAOFactory.criarCidadeDAO();
	}
	
	public Cidade carregar(Long id){
		return this.cidadeDAO.carregar(id);
	}
	
	public Cidade buscarPorBairro(String cidade){
		return this.cidadeDAO.buscarCidade(cidade);
	}
	
	public void salvar(Cidade cidade){
		this.cidadeDAO.salvar(cidade);
	}
	
	public void excluir(Cidade cidade){
		this.cidadeDAO.excluir(cidade);
	}
	
	public List<Cidade> listar(){
		return this.cidadeDAO.listar();
	}

}
