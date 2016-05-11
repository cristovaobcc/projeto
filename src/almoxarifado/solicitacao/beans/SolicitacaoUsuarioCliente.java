package almoxarifado.solicitacao.beans;
import almoxarifado.material.beans.Material;
import almoxarifado.usuario.beans.UsuarioGestor;

public class SolicitacaoUsuarioCliente extends Solicitacao {
	
	// Toda solicitação de UsuarioCliente é atendida por algum UsuarioGestor
	private UsuarioGestor atendente;
	private UsuarioGestor avaliador;
	// private UsuarioCliente solicitante;
	
	public SolicitacaoUsuarioCliente(String numero, Material[] materiais, 
			UsuarioCliente solicitante, String data  )
	{
		super(numero, materiais, solicitante, data);
	}
	
	public void setAvaliador(UsuarioGestor gestor)
	{
		//TODO: refinar implementação do avaliador.
		if (gestor != null)
		{
			this.avaliador = gestor;
		}
		
	}

}
