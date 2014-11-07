package sah.usuario;

import java.util.List;

public interface UsuarioDAO {

	public void salvar(Usuario usuario);

	public void atualizar(Usuario usuario);

	public void excluir(Usuario usuario);

	public Usuario carregar(Long id);
	
	public List<Usuario> listar();

	public Usuario buscarPorLogin(String login);

}
