package almoxarifado.usuario.beans;

public class UsuarioGestor extends UsuarioAbstract{
	
	String lotacao;
	
	public UsuarioGestor (String id, String nome, String senha, String lotacao)
	{
		super (id, nome, senha);
		this.setLotacao(lotacao);
	}
	
	public String getLotacao()
	{
		return this.lotacao;
	}
	
	public void setLotacao(String lotacao)
	{
		if (lotacao == null || lotacao.equals(""))
			imprimeMensagemDeErro("Não pode passar 'lotacao' nula ou vazia!");
		else
			this.lotacao = lotacao;
	}


}
