package sah.cidade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class CidadeDAOHibernate implements CidadeDAO{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Cidade cidade) {
		this.session.saveOrUpdate(cidade);
	}

	@Override
	public void excluir(Cidade cidade) {
		this.session.delete(cidade);
	}

	@Override
	public Cidade carregar(Long id) {
		return (Cidade) this.session.get(Cidade.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> listar() {
		return this.session.createCriteria(Cidade.class).list();
	}

	@Override
	public Cidade buscarCidade(String nome) {
		String hql = "SELECT cid FROM Cidade cid WHERE cid.nome = :nome";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("nome", nome);
		return (Cidade) consulta.uniqueResult();
	}
	
	

}
