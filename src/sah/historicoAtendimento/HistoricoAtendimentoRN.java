package sah.historicoAtendimento;

import java.util.Date;
import java.util.List;

import sah.pessoa.Pessoa;
import sah.setor.Setor;
import sah.usuario.Usuario;
import sah.util.DAOFactory;

public class HistoricoAtendimentoRN {
	
	private HistoricoAtendimentoDAO historicoAtendimentoDAO;
	
	public HistoricoAtendimentoRN(){
		this.historicoAtendimentoDAO = DAOFactory.criarHistoricoAtendimentoDAO();
	}
	
	public HistoricoAtendimento carregar(Long id){
		return this.historicoAtendimentoDAO.carregar(id);
	}
	
	public void salvar(HistoricoAtendimento historicoAtendimento){
		historicoAtendimento.setDataAtendimento(new Date());
		this.historicoAtendimentoDAO.salvar(historicoAtendimento);
	}
	
	public void excluir(HistoricoAtendimento historicoAtendimento){
		this.historicoAtendimentoDAO.excluir(historicoAtendimento);
	}
	
	public List<HistoricoAtendimento> listar(Pessoa pessoa){
		return this.historicoAtendimentoDAO.listar(pessoa);
	}
	
	public HistoricoAtendimento buscarPessoa(Pessoa pessoa){
		return this.historicoAtendimentoDAO.buscarPessoa(pessoa);
	}
	
	public List<HistoricoAtendimento> listarSetorEmFila(Setor setor, String estadoAtendimento){
		return this.historicoAtendimentoDAO.listarSetorEmFila(setor, estadoAtendimento);
	}
	
	public List<HistoricoAtendimento> verificarPessoaEmAtendimento(Usuario usuario, String estadoEmAtendimento){
		return this.historicoAtendimentoDAO.verificarPessoaEmAtendimento(usuario, estadoEmAtendimento);
	}

}
