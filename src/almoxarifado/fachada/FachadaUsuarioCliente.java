package almoxarifado.fachada;

import almoxarifado.material.beans.Material;
import almoxarifado.material.repositorio.IRepositorioMateriais;
import almoxarifado.solicitacao.beans.SolicitacaoUsuarioCliente;
import almoxarifado.solicitacao.negocio.ControladorDeSolicitacoesParaUsuarioCliente;
import almoxarifado.solicitacao.repositorio.IRepositorioSolicitacoesUsCliente;
import almoxarifado.usuario.beans.NivelDeAcesso;
import almoxarifado.usuario.beans.UsuarioOficial;

public class FachadaUsuarioCliente {
	
	private static FachadaUsuarioCliente instance;
	private ControladorDeSolicitacoesParaUsuarioCliente controlSolUsCliente;
	
	private FachadaUsuarioCliente(IRepositorioSolicitacoesUsCliente rep)
	{
		this.controlSolUsCliente = new ControladorDeSolicitacoesParaUsuarioCliente(rep);
	}
	
	/**
	 * Devolve uma única instância de FachadaUsuarioCliente se o nível do usuário
	 * passado como parâmetro for igual a "SOLICITANTE".
	 * Caso o nível não seja o requerido, devolve null.
	 * @param user
	 * @param rep
	 * @return
	 */
	public static FachadaUsuarioCliente getInstance(UsuarioOficial user, 
			IRepositorioSolicitacoesUsCliente rep)
	{
		if (user.getNivelDeAcesso() == NivelDeAcesso.SOLICITANTE &&
				instance == null)
			instance = new FachadaUsuarioCliente(rep);
		return instance;
	}
	
	public SolicitacaoUsuarioCliente gerarSolicitacao (UsuarioOficial user, String data)
	{
		return controlSolUsCliente.gerarSolicitacao(user, data);
	}
	
	public boolean confirmaSolicitacao (SolicitacaoUsuarioCliente s)
	{
		return this.confirmaSolicitacao(s);
	}
	
	public boolean inserirMaterial (Material m, 
			SolicitacaoUsuarioCliente s, IRepositorioMateriais rep)
	{
		return this.controlSolUsCliente.inserirMaterial(m, s, rep);
	}
	
	public boolean removerMaterial (Material m, SolicitacaoUsuarioCliente s)
	{
		return this.controlSolUsCliente.removerMaterial(m, s);
	}
	
	public boolean alterarMaterial (Material m, SolicitacaoUsuarioCliente s)
	{
		return this.controlSolUsCliente.alterarMaterial(m, s);
	}
}
