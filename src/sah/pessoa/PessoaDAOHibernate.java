package sah.pessoa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class PessoaDAOHibernate implements PessoaDAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Pessoa pessoa) {
		this.session.saveOrUpdate(pessoa);
	}

	@Override
	public void excluir(Pessoa pessoa) {
		this.session.delete(pessoa);

	}

	// Carregar todos os dados de pessoa
	@Override
	public Pessoa carregar(Long id) {
		return (Pessoa) this.session.get(Pessoa.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> listar() {
		return this.session.createCriteria(Pessoa.class).list();
	}

	@Override
	public Pessoa buscarPorPessoa(String nome) {
		String hql = "select p from Pessoa p WHERE p.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (Pessoa) consulta.uniqueResult();
	}

	@Override
	public Pessoa buscarPorCPF(String cpf) {
		String hql = "select p from Pessoa p WHERE p.cpf = :cpf";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("cpf", cpf);
		return (Pessoa) consulta.uniqueResult();
	}
	

}
