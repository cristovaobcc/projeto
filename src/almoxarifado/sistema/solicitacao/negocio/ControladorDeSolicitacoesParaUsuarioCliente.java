package almoxarifado.sistema.solicitacao.negocio;

import almoxarifado.sistema.solicitacao.beans.SolicitacaoUsuarioCliente;
import almoxarifado.sistema.solicitacao.repositorio.IRepositorioSolicitacoesUsCliente;
import almoxarifado.sistema.material.beans.Material;
import almoxarifado.sistema.material.repositorio.IRepositorioMateriais;
import almoxarifado.sistema.usuario.beans.NivelDeAcesso;
import almoxarifado.sistema.usuario.beans.UsuarioOficial;

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
	 * Devolve uma solicitacao com o numero null e configurada com o 
	 * UsuarioOficial u e data passados.
	 * @param u UsuarioOficial da Solicitacao
	 * @param data Data de geração da solicitação.
	 * @return
	 */
	public SolicitacaoUsuarioCliente gerarSolicitacao(UsuarioOficial u, String data){
		SolicitacaoUsuarioCliente s = new SolicitacaoUsuarioCliente(null, u, data);
		return s;
	}
	
	/**
	 * Altera atributo confirmar para true e insere a 
	 * solicitação s no repositório de solicitações. 
	 * @param s SolicitacaoUsuarioCliente
	 */
	public boolean confirmarSolicitacao(SolicitacaoUsuarioCliente s)
	{
		s.setConfirmar(true);
		return this.inserirSolicitacao(s);
	}
	
	/**
	 *  Insere um material m na solicitação de cliente s.
	 *  Devolve true se:
	 * 	1) o material m não for nulo; e
	 *  2) a solicitação s não for nula; e
	 *  3) o repositorio rep não for nulo; e
	 *  4) o material m constar no repositorio rep e qtde for <= a disponivel no rep; e
	 *  5) o material m não estiver inserido na solicitação.
	 *  6) a solicitacao não foi confirmada;
	 *  Devolve false caso alguma das condições acima for violada.
	 * @param m Material a ser inserido
	 * @param s Solicitacao a receber o material
	 * @param rep Repositorio onde deve constar o material
	 * @return
	 */
	public boolean inserirMaterial (Material m,
			SolicitacaoUsuarioCliente s, IRepositorioMateriais rep)
	{
		boolean inserido = false;
		if ( m != null && s != null && rep != null && 
				this.verificaMatEmRep(m, rep) && 
				!this.verificaMatEmSolicitacao(m, s) &&
				s.getConfirmar() == false){
			s.inserirMaterial(m);
			inserido = true;
		}
		else this.imprimeMensagemDeErro("inserirMaterial");
		return inserido;
	}
	
	/**
	 * Remove o material m da solicitacao s. 
	 * Devolve true se:
	 * 	1) o material m não for null; e
	 *  2) a solicitacao s não for null; e
	 *  3) o material estiver contido na solicitação s.
	 * Devolve false caso alguma das condições acima for violada.
	 * @param m Material a ser removido
	 * @param s Solicitacao ter o material m removido
	 * @return
	 */
	public boolean removerMaterial (Material m, SolicitacaoUsuarioCliente s)
	{
		boolean removido = false;
		if (m != null && s != null &&
				s.getMateriais().contains(m)){
			s.removerMaterial(m);
			removido = true;
		}
		else this.imprimeMensagemDeErro("removerMaterial");
		return removido;
	}
	
	/**
	 * Altera o material m da solicitacao s. 
	 * Devolve true se:
	 * 	1) o material m não for null; e
	 *  2) a solicitacao s não for null; e
	 *  3) o material estiver contido na solicitação s.
	 * Devolve false caso alguma das condições acima for violada.
	 * @param m
	 * @param s
	 * @return
	 */
	public boolean alterarMaterial (Material m, SolicitacaoUsuarioCliente s)
	{
		boolean alterado = false;
		if (m != null && s != null &&
				s.getMateriais().contains(m)){
			s.alterarMaterial(m);
			alterado = true;
		}
		else this.imprimeMensagemDeErro("alteraMaterial");
		return alterado;
	}
	
	/// métodos privados e auxiliares vão abaixo dessa linha
	/**
	 * Insere solicitacao s no repositorio de solicitações se s
	 * atender as seguintes condições:
	 * 	1) Não for nulo
	 * 	2) Não tiver o mesmo número de outra solicitação no repositório
	 * 	3) Tiver pelo menos 1 material
	 *  4) O nivel do usuario solicitante for igual a "S"(SOLICITANTE)
	 *  5) Estive confirmada pelo usuario 
	 * Devolve true se inserida com sucesso, e false se não.
	 * @param s
	 * @return
	 */
	private boolean inserirSolicitacao(SolicitacaoUsuarioCliente s)
	{
		boolean inserido = false;
		SolicitacaoUsuarioCliente sol = this.rep.buscarSolicitacao(s);
		if (s != null && sol == null &&
				s.getSolicitante().getNivelDeAcesso()==this.nivel &&
				s.getMateriais().size() > 0 &&
				s.getConfirmar() == true){
			this.atualizarNumSolicitacao();
			s.setNumero (Integer.toString (this.getCodAutomatico() ) );
			rep.inserirSolicitacao(s);
			inserido = true;
		}
		else this.imprimeMensagemDeErro("inserirSolicitacao");
		return inserido; 
	}
	
	/**
	 * Função que devolve true se:
	 * 	1) o material passado conste no Repositorio DeMaterais; e 
	 * 	2) sua respectiva quantidade seja menor ou igual a qtde disponivel
	 * 	   desse material no Repositorio De Materiais. 
	 * Devolve false em outro caso.
	 * @param m material a ser verificado
	 * @param rep repositorio a ser verificado o material m
	 * @return
	 */
	private boolean verificaMatEmRep(Material m, IRepositorioMateriais rep)
	{
		boolean resultado = false;
		Material verificado = rep.buscarMaterial(m);
		if(verificado != null && m.getQtde() <= verificado.getQtde())
			resultado = true;
		else this.imprimeMensagemDeErro("verificaMatEmRep");
		return resultado;
	}
	
	/**
	 * Função que devolve true se:
	 * 	1) O material m estiver na solicitação s
	 * Devolve false caso contrário.
	 * @param m Material a ser verificado na solicitação
	 * @param s SolicitacaoUsuarioCliente 
	 * @return
	 */
	private boolean verificaMatEmSolicitacao(Material m, SolicitacaoUsuarioCliente s)
	{
		boolean resultado = false;
		if (s.getMateriais().contains(m))
			resultado = true;
		return resultado;
	}
	
	private void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
	
	private void atualizarNumSolicitacao(){
		this.codAutomatico++;
	}
	
	
	

}
