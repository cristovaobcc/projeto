package almoxarifado.solicitacao.repositorio;
import almoxarifado.solicitacao.beans.SolicitacaoUsuarioCliente;

public class RepositorioSolicitacoesUsuCliente {
	
	private static int TAMANHO = 1;
	private SolicitacaoUsuarioCliente[] solicitacoes;
	private int qtde;
	private static RepositorioSolicitacoesUsuCliente instance;
	
	private RepositorioSolicitacoesUsuCliente()
	{
		this.solicitacoes = new SolicitacaoUsuarioCliente[TAMANHO];
		this.qtde = 0;
	}
	
	public static RepositorioSolicitacoesUsuCliente getInstance()
	{
		if (instance == null)
			instance = new RepositorioSolicitacoesUsuCliente();
		return instance;
			
	}
	
	public int getQtde()
	{
		return this.qtde;
	}
	
	public void inserirSolicitacao(SolicitacaoUsuarioCliente s)
	{
		this.solicitacoes[this.qtde++] = s;
		if (this.qtde == this.solicitacoes.length)
			this.aumentarArraySolicitacoes();
	}
	
	public SolicitacaoUsuarioCliente buscar(String numero){
		SolicitacaoUsuarioCliente solBuscada = null;
		for (SolicitacaoUsuarioCliente s: this.solicitacoes){
			if ( s != null){
				if ( s.getNumero().equals(numero))
					solBuscada = s;
			} else break;
		}
		return solBuscada;
	}
	
	public boolean remover(String numero)
	{
		boolean removido = false;
		int indice = this.verificaIndiceDeSolicitacao(numero);
		if ( indice != -1){
			this.solicitacoes[indice] = this.solicitacoes[this.qtde-1];
			this.solicitacoes[this.qtde-1] = null;
			removido = true; this.qtde--;			
		}
		return removido;
	}
	
	public void alterarSolicitacao(SolicitacaoUsuarioCliente s)
	{
		this.solicitacoes[this.verificaIndiceDeSolicitacao(s.getNumero() ) ] = s;
	}
	
	public void listar()
	{
		System.out.println("\n---- Método Listar de Repositorio Solicitacoes De Usuario Cliente ----");
		if (this.qtde == 0)
			System.out.println("\nNão há solicitacoes cadastradas!");
		else
			for(SolicitacaoUsuarioCliente s: this.solicitacoes){
				if (s != null)
					System.out.println("\n" + s);
			}
		System.out.println("\n-------------------------------------");
	}
		
	/// => métodos auxiliares vão abaixo dessa linha
	
	private void aumentarArraySolicitacoes(){
		if (this.solicitacoes.length > 0){
			SolicitacaoUsuarioCliente[] arrayAumentado = new SolicitacaoUsuarioCliente[this.solicitacoes.length + 1];
			int i = 0;
			for (SolicitacaoUsuarioCliente s: this.solicitacoes){
				if ( s != null)
					arrayAumentado[i++] = s;
				else break;
			}
			this.solicitacoes = arrayAumentado;
		}
	}
	
	private int verificaIndiceDeSolicitacao(String numero)
	{
		int indice = -1;
		for(SolicitacaoUsuarioCliente s : this.solicitacoes){
			if (s == null){
				indice = -1;
				break;
			}
			else if (s.getNumero().equals(numero)){
				++indice;
				break;
			}
			else 
				++indice;
		}
		return indice;
	}

}
