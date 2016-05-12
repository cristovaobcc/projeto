package almoxarifado.solicitacao.negocio;

import almoxarifado.solicitacao.beans.SolicitacaoUsuarioCliente;
import almoxarifado.solicitacao.repositorio.RepositorioSolicitacoesUsuCliente;
import almoxarifado.usuario.beans.UsuarioCliente;

public class ControladorDeSolicitacoesParaUsuarioCliente {
	
	private int codAutomatico;
	private RepositorioSolicitacoesUsuCliente rep;
	private UsuarioCliente user;
	
	public ControladorDeSolicitacoesParaUsuarioCliente(UsuarioCliente user)
	{
		this.setUsuarioCliente(user);
		this.setRepositorio(RepositorioSolicitacoesUsuCliente.getInstance());
		this.codAutomatico = 0;
	}
	
	public RepositorioSolicitacoesUsuCliente getRep()
	{
		return this.rep;
	}
	
	private void setRepositorio(RepositorioSolicitacoesUsuCliente rep)
	{
		this.rep = rep;
	}
	
	public void setUsuarioCliente(UsuarioCliente u)
	{
		if (u == null)
			imprimeMensagemDeErro("setUsuarioCliente, não pode passar cliente nulo)!");
		else
			this.user = u;
	}
	
	public UsuarioCliente getUsuarioCliente()
	{
		return this.user;
	}
	
	public int getCodAutomatico()
	{
		return this.codAutomatico;
	}
	
	public SolicitacaoUsuarioCliente buscaNumSolicitacaoCliente(String numero)
	{
		return rep.buscar(numero);
	}
	
	public boolean inserirSolicitacao(SolicitacaoUsuarioCliente s)
	{
		boolean inserido = false;
		if ( s != null && s.getConfirmar()){
			if( rep.buscar (s.getNumero() ) == null){
				s.setUsuario(this.user);
				s.setNumero(Integer.toString(this.getCodAutomatico()));
				this.atualizarNumSolicitacao();
				rep.inserirSolicitacao(s);
				inserido = true;
			}
		}
		return inserido;
	}
	
	/**
	 * Altera atributo confirmar para true.
	 * @param s SolicitacaoUsuarioCliente
	 */
	public void confirmarSolicitacao(SolicitacaoUsuarioCliente s)
	{
		s.setConfirmar(true);
	}
	
	/// métodos privados e auxiliares vão abaixo dessa linha
	protected final void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
	
	private void atualizarNumSolicitacao(){
		this.codAutomatico++;
	}
	
	
	

}
