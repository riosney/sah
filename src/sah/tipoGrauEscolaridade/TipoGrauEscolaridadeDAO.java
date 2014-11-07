package sah.tipoGrauEscolaridade;

import java.util.List;

public interface TipoGrauEscolaridadeDAO {
	
	public void salvar(TipoGrauEscolaridade tipoGrauEscolaridade);
	
	public void excluir(TipoGrauEscolaridade tipoGrauEscolaridade);
	
	public TipoGrauEscolaridade carregar(Long id);
	
	public List<TipoGrauEscolaridade> listar();
	
	public TipoGrauEscolaridade buscarTipoGrauEscolaridade(String tipoGrauEscolaridade);

}
