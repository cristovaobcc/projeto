package almoxarifado.sistema.solicitacao.repositorio;
import java.util.ArrayList;
import almoxarifado.sistema.solicitacao.beans.SolicitacaoUsuarioCliente;

public class RepSolicitacoesUsuClienteArray implements IRepositorioSolicitacoesUsCliente {
	
	private ArrayList<SolicitacaoUsuarioCliente> solicitacoes;
	private static RepSolicitacoesUsuClienteArray instance;
	
	/**
	 * Construtor privado que configura o campo de solicitacoes.
	 */
	private RepSolicitacoesUsuClienteArray(ArrayList<SolicitacaoUsuarioCliente> list)
	{
		this.solicitacoes = list;
	}
	
	/**
	 * Configura o repositório com uma ArrayList<SolicitacaoUsuarioCliente> list.
	 * @param list ArrayList<SolicitacaoUsuarioCliente> passada pelo usuário.
	 * @return
	 */
	public static RepSolicitacoesUsuClienteArray 
					getInstance(ArrayList<SolicitacaoUsuarioCliente> list)
	{
		if (instance == null)
			instance = new RepSolicitacoesUsuClienteArray(list);
		return instance;
			
	}
	/**
	 * Devolve a quantidade de SolicitacaoUsuarioCliente contidas no repositorio.
	 * @return
	 */
	public int getQtde()
	{
		return this.solicitacoes.size();
	}
	
	public void inserirSolicitacao(SolicitacaoUsuarioCliente s)
	{
		this.solicitacoes.add(s);
	}
	
	public SolicitacaoUsuarioCliente buscarSolicitacao(SolicitacaoUsuarioCliente s)
	{
		SolicitacaoUsuarioCliente buscada = null;
		for(SolicitacaoUsuarioCliente sol: this.solicitacoes)
			if (sol.equals(s))
				buscada = sol;
		return buscada;
	}
	
	public void alterarSolicitacao(SolicitacaoUsuarioCliente s)
	{
		this.solicitacoes.set(this.verificaIndiceDeSolicitacao(s), s);
	}
	
	public void removerSolicitacao(SolicitacaoUsuarioCliente s)
	{
		this.solicitacoes.remove(this.verificaIndiceDeSolicitacao(s));
	}
	
	public void listar()
	{
		System.out.println("\n---- Método Listar de Repositorio Solicitacoes De Usuario Cliente ----");
		if (this.solicitacoes.size() == 0)
			System.out.println("\nNão há solicitacoes cadastradas!");
		else
			for(SolicitacaoUsuarioCliente s: this.solicitacoes){
				System.out.println("\n" + s);
			}
		System.out.println("\n-------------------------------------");
	}
		
	/// => métodos auxiliares vão abaixo dessa linha
	/**	
	 * Devolve o índice da SolicitacaoUsuarioCliente s no repositorio.
	 * @param s solicitacao buscada.
	 * @return
	 */
	private int verificaIndiceDeSolicitacao(SolicitacaoUsuarioCliente s)
	{
		int i;
		for (i = 0; i < this.solicitacoes.size(); i++)
			if (solicitacoes.get(i).equals(s))
				break;
		return i;
	}

}
