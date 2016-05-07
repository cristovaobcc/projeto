package almoxarifado.solicitacao.beans;
import almoxarifado.material.beans.Material;


public class SolicitacaoUsuarioCliente extends Solicitacao {
	
	private UsuarioGestor atendente;
	
	public SolicitacaoUsuarioCliente(String numero, Material[] materiais, 
			UsuarioCliente solicitante, String data  )
	{
		super(numero, materiais, solicitante, data);
	}

}
