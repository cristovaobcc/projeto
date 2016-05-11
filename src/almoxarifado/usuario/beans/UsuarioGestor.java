package almoxarifado.usuario.beans;

import almoxarifado.solicitacao.beans.SolicitacaoUsuarioCliente;

public class UsuarioGestor extends UsuarioAbstract{
	
	// Todo UsuarioGestor deve ser lotado no almoxarifado
	public UsuarioGestor (String id, String nome, String senha)
	{
		super (id, nome, senha);
		this.setLotacao("almoxarifado");
	}
	
	public void setLotacao(String lotacao){
		if (lotacao == null || lotacao.equals("") || !lotacao.equals("almoxarifado"))
			imprimeMensagemDeErro("Não pode passar 'lotacao' nula, vazia ou "
					+ "diferente de 'almoxarifado'!");
		else
			this.lotacao = lotacao;	
	}
	
	public String getLotacao()
	{
		return this.lotacao;
	}
	
	public String toString()
	{
		return "[Id =" + super.getId() + "] [nome =" + super.getNome() +
				"] [lotação =" + this.getLotacao() + "]";
	}
	
	public void AlterarSolicitacao(SolicitacaoUsuarioCliente solicitacao)
	{
		//TODO: implementar 
	}
	
}
