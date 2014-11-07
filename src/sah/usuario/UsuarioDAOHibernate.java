package sah.usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAOHibernate implements UsuarioDAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Usuario usuario) {
		this.session.save(usuario);
	}

	// Tratar o problema de edição de usuário
	@Override
	public void atualizar(Usuario usuario) {
		// testar se o usuário tem alguma permissão
		if(usuario.getPermissao() == null || usuario.getPermissao().size() == 0){
			// jogando em uma referência a parte usuarioPermissao
			Usuario usuarioPermissao = this.carregar(usuario.getId());
			// Transferindo permissões originais para o objeto Usuario
			usuario.setPermissao(usuarioPermissao.getPermissao());
			/* com o método session.evict retiramos a persistencia do objeto,
			 * que só foi utilizado para copiar permissões.
			 */ 
			this.session.evict(usuarioPermissao);
		}
		this.session.update(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
	}

	// Carregar todos os dados de usuário
	@Override
	public Usuario carregar(Long id) {
		return (Usuario) this.session.get(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}

}