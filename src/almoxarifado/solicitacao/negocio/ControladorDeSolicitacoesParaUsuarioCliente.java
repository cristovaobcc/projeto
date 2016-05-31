package almoxarifado.solicitacao.negocio;

import almoxarifado.solicitacao.beans.SolicitacaoUsuarioCliente;
import almoxarifado.solicitacao.repositorio.IRepositorioSolicitacoesUsCliente;
import almoxarifado.material.beans.Material;
import almoxarifado.material.repositorio.IRepositorioMateriais;
import almoxarifado.usuario.beans.NivelDeAcesso;
import almoxarifado.usuario.beans.UsuarioOficial;

public final class ControladorDeSolicitacoesParaUsuarioCliente {
	
	private IRepositorioSolicitacoesUsCliente rep;
	private int codAutomatico;
	private NivelDeAcesso nivel;
	
	public ControladorDeSolicitacoesParaUsuarioCliente
				(IRepositorioSolicitacoesUsCliente rep)
	{
		this.setNivel(NivelDeAcesso.SOLICITANTE);
		this.setRep(rep);
		this.codAutomatico = 0;
	}
	
	public int getCodAutomatico()
	{
		return this.codAutomatico;
	}
	
	public IRepositorioSolicitacoesUsCliente getRep()
	{
		return this.rep;
	}
	
	private void setRep(IRepositorioSolicitacoesUsCliente rep)
	{
		this.rep = rep;
	}
	
	private void setNivel(NivelDeAcesso n)
	{
		this.nivel = n;
	}
	
	/**
	 * Insere solicitacao s no repositorio de solicitações
	 * atender as seguintes condições:
	 * 	1) Não for nulo
	 * 	2) Não tiver o mesmo número de outra solicitação no repositório
	 * 	3) Tiver pelo menos 1 material
	 *  4) O nivel do usuario solicitante for igual a "S"(SOLICITANTE) 
	 * Devolve true se inserida com sucesso, e false se não.
	 * @param s
	 * @return
	 */
	public boolean inserirSolicitacao(SolicitacaoUsuarioCliente s)
	{
		boolean inserido = false;
		SolicitacaoUsuarioCliente sol = this.rep.buscarSolicitacao(s);
		if (s != null && sol == null &&
				s.getSolicitante().getNivelDeAcesso()==this.nivel &&
				s.getMateriais().size() > 0){
			this.atualizarNumSolicitacao();
			s.setNumero (Integer.toString (this.getCodAutomatico() ) );
			rep.inserirSolicitacao(s);
			inserido = true;
		}
		return inserido; 
	}
	
	/**
	 *
	 * @param data
	 * @return
	 */
	public SolicitacaoUsuarioCliente gerarSolicitacao(UsuarioOficial u, String data){
		SolicitacaoUsuarioCliente s = new SolicitacaoUsuarioCliente(null, u, data);
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
	 * Insere um material m na solicitação de cliente s.
	 * @param m
	 * @param qtde
	 * @param s
	 * @param rep
	 * @return
	 */
	public boolean inserirMaterial (Material m, int qtde,
			SolicitacaoUsuarioCliente s, IRepositorioMateriais rep)
	{
		boolean inserido = false;
		
		return inserido;
	}
	
	/**
	 * remove o material m da solicitacao s.
	 * Devolve true se removeu e false se não.
	 * @param m
	 * @param s
	 * @return
	 */
	public boolean removerMaterial (Material m, SolicitacaoUsuarioCliente s){
		boolean removido = false;
		
		return removido;
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
