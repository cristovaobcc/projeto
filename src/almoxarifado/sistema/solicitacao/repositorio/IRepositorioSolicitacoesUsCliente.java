package almoxarifado.sistema.solicitacao.repositorio;

import almoxarifado.sistema.solicitacao.beans.SolicitacaoUsuarioCliente;

public interface IRepositorioSolicitacoesUsCliente {
	
	/**
	 * Deve inserir uma SolicitacaoUsuarioCliente.
	 *  
	 * @param s SolicitacaoUsuarioCliente a ser inserida
	 */
	public void inserirSolicitacao(SolicitacaoUsuarioCliente s);
	
	/**
	 * Deve buscar uma SolicitacaoUsuarioCliente e devolver a solicitacao
	 * buscada se for encontrada, caso contrario, devolve null.
	 * 
	 * @param s SolicitacaoUsuarioCliente a ser buscada
	 */
	public SolicitacaoUsuarioCliente  buscarSolicitacao(SolicitacaoUsuarioCliente s);
	
	/**
	 * Deve alterar uma SolicitacaoUsuarioCliente s que existe no repositorio.
	 * 
	 * @param s SolicitacaoUsuarioCliente a ser alterada 
	 */
	public void alterarSolicitacao(SolicitacaoUsuarioCliente s);
	
	/**
	 * Deve remover uma SolicitacaoUsuarioCliente s que existe no repositorio.
	 * 
	 * @param m
	 */
	public void removerSolicitacao(SolicitacaoUsuarioCliente s);
}
