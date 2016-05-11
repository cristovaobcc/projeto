package almoxarifado.solicitacao.beans;
import almoxarifado.material.beans.Material;
import almoxarifado.usuario.beans.UsuarioGestor;

public class SolicitacaoUsuarioCliente extends Solicitacao {
	
	// Toda solicita��o de UsuarioCliente � atendida por algum UsuarioGestor
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
		//TODO: refinar implementa��o do avaliador.
		if (gestor != null)
		{
			this.avaliador = gestor;
		}
		
	}

}
