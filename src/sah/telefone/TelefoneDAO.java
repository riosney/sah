package sah.telefone;

import java.util.List;

public interface TelefoneDAO {
	
	public void salvar(Telefone telefone);
	
	public void excluir(Telefone telefone);
	
	public Telefone carregar(Long id);
	
	public List<Telefone> listar();
	
	public Telefone buscarTelefone(String telefone);

}
