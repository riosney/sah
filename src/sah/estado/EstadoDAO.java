package sah.estado;

import java.util.List;

public interface EstadoDAO {
	
	public void salvar(Estado estado);
	
	public void excluir(Estado estado);
	
	public Estado carregar(Long id);
	
	public List<Estado> listar();
	
	public Estado buscarEstado(String estado);

}
