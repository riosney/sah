package sah.setor;

import java.util.List;

public interface SetorDAO {
	
	public void salvar(Setor setor);
	
	public void excluir(Setor setor);
	
	public Setor carregar(Long id);
	
	public List<Setor> listar();
	
	public Setor buscarPorSetor(String setor);

}
