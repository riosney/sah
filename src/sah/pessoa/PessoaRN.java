package sah.pessoa;

import java.util.Date;
import java.util.List;

import br.com.caelum.stella.format.CPFFormatter;
import sah.util.DAOFactory;

public class PessoaRN {
	
	private PessoaDAO pessoaDAO;
	
	public PessoaRN(){
		this.pessoaDAO = DAOFactory.criarPessoaDAO();
	}
	
	public Pessoa carregar(Long id){
		return this.pessoaDAO.carregar(id);
	}	
	
	public Pessoa buscarPorPessoa(String pessoa){
		return this.pessoaDAO.buscarPorPessoa(pessoa);
	}
	
	public Pessoa buscarPorCPF(String cpf){
		return this.pessoaDAO.buscarPorCPF(cpf);
	}
	
	/**
	 * M�todo salvar
	 * <p>O m�todo salvar PessoaRN, recebe os campos do formul�rio
	 * pessoa e trata algumas informa��es: Remove a formata��o do CPF;
	 * faz compara��o do CPF no banco de dados.</p>
	 * @return this.pessoaDAO retorna pessoa, caso v�lido, se n�o, retorna
	 * uma mensagem de 'CPF j� cadastrado!'.
	 * @param pessoa: recebe os campos de cadastro pessoa
	 * @author Riosney Santos
	 */
	public void salvar(Pessoa pessoa){
		/*FacesContext context = FacesContext.getCurrentInstance();
		
		//Compara CPF no banco de dados
		Pessoa pessoaExistente =  buscarPorCPF(unformatedValueCPF);
		if (pessoaExistente != null this.selecionada.getId() == null) {
			FacesMessage facesMessage = new FacesMessage("CPF j� cadastrado!");
			context.addMessage(null, facesMessage);
		}else{
			
		}*/

		//Removendo formata��o CPF
		CPFFormatter formatter = new CPFFormatter();
		String fotmatedValue = pessoa.getCpf();
		String unformatedValueCPF = formatter.unformat(fotmatedValue);
		
		pessoa.setCpf(unformatedValueCPF);
		pessoa.setDataCadastro(new Date());
		this.pessoaDAO.salvar(pessoa);
		
	}
	
	public void excluir(Pessoa pessoa){
		this.pessoaDAO.excluir(pessoa);
	}
	
	public List<Pessoa> listar(){
		return this.pessoaDAO.listar();
	}
	

}
