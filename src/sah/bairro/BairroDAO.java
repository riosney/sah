package sah.bairro;

import java.util.List;

public interface BairroDAO {
	
	public void salvar(Bairro bairro);
	
	public void excluir(Bairro bairro);
	
	public Bairro carregar(Long id);
	
	public List<Bairro> listar();
	
	public Bairro buscarBairro(String bairro);

}
