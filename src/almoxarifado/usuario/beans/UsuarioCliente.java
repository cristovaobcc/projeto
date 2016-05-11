package almoxarifado.usuario.beans;

public class UsuarioCliente extends UsuarioAbstract {
	
	private String lotacao;
	
	public UsuarioCliente(String id, String nome, String senha, String lotacao)
	{
		super (id, nome, senha);
		this.setLotacao(lotacao);
	}
	
	public void setLotacao(String lotacao)
	{
		if (lotacao == null || lotacao.equals(""))
			imprimeMensagemDeErro("Não pode passar 'lotacao' nula ou vazia!");
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

}
