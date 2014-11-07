package sah.historicoAtendimento;

import java.util.List;

import sah.pessoa.Pessoa;
import sah.setor.Setor;
import sah.usuario.Usuario;

public interface HistoricoAtendimentoDAO {
	
	public void salvar(HistoricoAtendimento historicoAtendimento);
	
	public void excluir(HistoricoAtendimento historicoAtendimento);
	
	public HistoricoAtendimento carregar(Long id);
	
	public List<HistoricoAtendimento> listar(Pessoa pessoa);

	public HistoricoAtendimento buscarPessoa(Pessoa pessoa);
	
	public List<HistoricoAtendimento> listarSetorEmFila(Setor setor, String estadoAtendimento);
	
	public List<HistoricoAtendimento> verificarPessoaEmAtendimento(Usuario usuario, String estadoEmAtendimento);

}
