package sah.profissao;

import java.util.List;

public interface ProfissaoDAO {
	
	public void salvar(Profissao profissao);
	
	public void excluir(Profissao profissao);
	
	public Profissao carregar(Long id);
	
	public Profissao buscarProfissao(String nomeProfissao);
	
	public List<Profissao> listar();

}
