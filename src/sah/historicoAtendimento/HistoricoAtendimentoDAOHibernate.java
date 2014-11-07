package sah.historicoAtendimento;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import sah.pessoa.Pessoa;
import sah.setor.Setor;
import sah.usuario.Usuario;

public class HistoricoAtendimentoDAOHibernate implements HistoricoAtendimentoDAO{
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(HistoricoAtendimento historicoAtendimento) {
		this.session.saveOrUpdate(historicoAtendimento);
	}

	@Override
	public void excluir(HistoricoAtendimento historicoAtendimento) {
		this.session.delete(historicoAtendimento);
	}

	@Override
	public HistoricoAtendimento carregar(Long id) {
		return (HistoricoAtendimento) this.session.get(HistoricoAtendimento.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoricoAtendimento> listar(Pessoa pessoa) {
		Criteria cr = this.session.createCriteria(HistoricoAtendimento.class);
		cr.add(Restrictions.eq("pessoaatendimento", pessoa));
		cr.addOrder(Order.desc("dataAtendimento"));
		return cr.list();
	}

	@Override
	public HistoricoAtendimento buscarPessoa(Pessoa pessoa) {
		Criteria criteria = this.session.createCriteria(HistoricoAtendimento.class);
		criteria.add(Restrictions.eq("pessoaatendimento", pessoa));
		return (HistoricoAtendimento) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoricoAtendimento> listarSetorEmFila(Setor setor, String estadoAtendimento) {
		Criteria criteria = this.session.createCriteria(HistoricoAtendimento.class);
		criteria.add(Restrictions.eq("setor", setor));
		criteria.add(Restrictions.eq("estadoAtendimento", estadoAtendimento));
		criteria.addOrder(Order.asc("dataAtendimento"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoricoAtendimento> verificarPessoaEmAtendimento(
			Usuario usuario, String estadoEmAtendimento) {
		Criteria cr = this.session.createCriteria(HistoricoAtendimento.class);
		cr.add(Restrictions.eq("usuario", usuario));
		cr.add(Restrictions.eq("estadoAtendimento", estadoEmAtendimento));
		cr.addOrder(Order.asc("dataAtendimento"));
		return cr.list();
	}
	

}
