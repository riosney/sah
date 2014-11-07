package sah.projeto;

import java.util.List;

public interface ProjetoDAO {
	
	public void salvar(Projeto projeto);
	
	public void excluir(Projeto projeto);
	
	public Projeto carregar(Long id);
	
	public List<Projeto> listar();
	
	public Projeto buscarProjeto(String nome);

}
