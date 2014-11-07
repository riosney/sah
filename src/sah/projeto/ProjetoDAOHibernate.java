package sah.projeto;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ProjetoDAOHibernate implements ProjetoDAO {
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Projeto projeto) {
		this.session.saveOrUpdate(projeto);
	}

	@Override
	public void excluir(Projeto projeto) {
		this.session.delete(projeto);
	}

	@Override
	public Projeto carregar(Long id) {
		return (Projeto) this.session.get(Projeto.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> listar() {
		return this.session.createCriteria(Projeto.class).list();
	}

	@Override
	public Projeto buscarProjeto(String nome) {
		String hql = "SELECT pj FROM Projeto pj WHERE pj.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (Projeto) consulta.uniqueResult();
	}

}
