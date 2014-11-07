package sah.pessoa;

import java.util.List;

public interface PessoaDAO {
	
	public void salvar(Pessoa pessoa);

	public void excluir(Pessoa pessoa);

	public Pessoa carregar(Long id);
	
	public List<Pessoa> listar();
	
	public Pessoa buscarPorPessoa(String pessoa);
	
	public Pessoa buscarPorCPF(String cpf);

}
