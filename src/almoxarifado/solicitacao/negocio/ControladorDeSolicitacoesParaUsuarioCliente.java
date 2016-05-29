package almoxarifado.solicitacao.negocio;

import almoxarifado.solicitacao.beans.SolicitacaoUsuarioCliente;
import almoxarifado.solicitacao.repositorio.RepositorioSolicitacoesUsuCliente;
import almoxarifado.material.beans.Material;
import almoxarifado.material.repositorio.RepositorioMateriais;
import almoxarifado.usuario.beans.UsuarioOficial;;

public class ControladorDeSolicitacoesParaUsuarioCliente {
	
	private final String TEMP = "99999999999"; // usado no m�todo gerarSolicitacao!
	private int codAutomatico;
	private RepositorioSolicitacoesUsuCliente rep;
	private UsuarioOficial user;
	
	
	public ControladorDeSolicitacoesParaUsuarioCliente(UsuarioOficial user)
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
	
	public void setUsuarioCliente(UsuarioOficial u)
	{
		if (u == null)
			imprimeMensagemDeErro("setUsuarioCliente, n�o pode passar cliente nulo)!");
		else
			this.user = u;
	}
	
	public UsuarioOficial getUsuarioCliente()
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
	
	/**
	 * Insere solicitacao s no repositorio de solicita��es.
	 * Devolve true se inserida com sucesso, e false se n�o.
	 * @param s
	 * @return
	 */
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
	 * Recebe uma data e devolve uma SolicitacaoUsuarioCliente 
	 * com o seu numero igual TEMP. Esta � uma solicita��o tempor�ria.
	 * @param data
	 * @return
	 */
	public SolicitacaoUsuarioCliente gerarSolicitacao(String data){
		SolicitacaoUsuarioCliente s = new SolicitacaoUsuarioCliente(this.TEMP, this.user, data);
		return s;
	}
	
	/**
	 * Altera atributo confirmar para true.
	 * @param s SolicitacaoUsuarioCliente
	 */
	public void confirmarSolicitacao(SolicitacaoUsuarioCliente s)
	{
		s.setConfirmar(true);
	}
	
	/**
	 * Insere um material m na solicita��o de cliente s.
	 * @param m
	 * @param qtde
	 * @param s
	 * @param rep
	 * @return
	 */
	public boolean inserirMaterial (Material m, int qtde,
			SolicitacaoUsuarioCliente s, RepositorioMateriais rep)
	{
		boolean inserido = false;
		if (m != null && rep.verificaMaterial(m, qtde))
			s.inserirMaterial(m);
		return inserido;
	}
	
	/**
	 * remove o material m da solicitacao s.
	 * Devolve true se removeu e false se n�o.
	 * @param m
	 * @param s
	 * @return
	 */
	public boolean removerMaterial (Material m, SolicitacaoUsuarioCliente s){
		boolean removido = false;
		
		return removido;
	}
	
	/// m�todos privados e auxiliares v�o abaixo dessa linha
	protected final void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
	
	private void atualizarNumSolicitacao(){
		this.codAutomatico++;
	}
	
	
	

}
