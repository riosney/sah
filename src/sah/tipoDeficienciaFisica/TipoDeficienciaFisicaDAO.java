package sah.tipoDeficienciaFisica;

import java.util.List;

public interface TipoDeficienciaFisicaDAO {
	
	public void salvar(TipoDeficienciaFisica tipoDeficienciaFisica);
	
	public void excluir(TipoDeficienciaFisica tipoDeficienciaFisica);
	
	public TipoDeficienciaFisica carregar(Long id);
	
	public List<TipoDeficienciaFisica> listar();
	
	public TipoDeficienciaFisica buscarTipoDeficienciaFisica(String tipoDeficienciaFisica);

}
