package sah.cidade;

import java.util.List;

public interface CidadeDAO {
	
	public void salvar(Cidade cidade);
	
	public void excluir(Cidade cidade);
	
	public Cidade carregar(Long id);
	
	public List<Cidade> listar();
	
	public Cidade buscarCidade(String cidade);

}
