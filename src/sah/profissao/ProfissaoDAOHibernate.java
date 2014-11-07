package sah.profissao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ProfissaoDAOHibernate implements ProfissaoDAO {
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Profissao profissao) {
		this.session.saveOrUpdate(profissao);
	}

	@Override
	public void excluir(Profissao profissao) {
		this.session.delete(profissao);
	}

	@Override
	public Profissao carregar(Long id) {		
		return (Profissao) this.session.get(Profissao.class, id);
	}

	@Override
	public Profissao buscarProfissao(String nomeProfissao) {
		String hql = "SELECT pf FROM Profissao pf WHERE pf.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nomeProfissao);
		return (Profissao) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profissao> listar() {
		return this.session.createCriteria(Profissao.class).list();
	}

}
