package sah.bairro;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class BairroDAOHibernate implements BairroDAO{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Bairro bairro) {
		this.session.saveOrUpdate(bairro);		
	}

	@Override
	public void excluir(Bairro bairro) {
		this.session.delete(bairro);		
	}

	@Override
	public Bairro carregar(Long bairro) {
		return (Bairro) this.session.get(Bairro.class, bairro);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bairro> listar() {
		return this.session.createCriteria(Bairro.class).list();
	}

	@Override
	public Bairro buscarBairro(String nome) {
		String hql = "SELECT ba FROM Bairro ba WHERE ba.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (Bairro) consulta.uniqueResult();
	}
	
	

}
