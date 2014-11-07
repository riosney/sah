package sah.setor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SetorDAOHibernate implements SetorDAO{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Setor setor) {
		this.session.saveOrUpdate(setor);
	}

	@Override
	public void excluir(Setor setor) {
		this.session.delete(setor);
	}

	@Override
	public Setor carregar(Long id) {
		return (Setor) this.session.get(Setor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Setor> listar() {
		return this.session.createCriteria(Setor.class).list();
	}

	@Override
	public Setor buscarPorSetor(String sigla) {
		String hql = "SELECT st FROM Setor st WHERE st.sigla = :sigla";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("sigla", sigla);
		return (Setor) consulta.uniqueResult();
	}
	
	

}
