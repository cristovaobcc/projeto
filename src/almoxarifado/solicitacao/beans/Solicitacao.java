package almoxarifado.solicitacao.beans;
import almoxarifado.material.beans.Material;
import almoxarifado.usuario.beans.Usuario;

public abstract class Solicitacao {
	
	private String numero;
	private Material[] materiais;
	private Usuario solicitante;
	private String data;
	
	public Solicitacao(String numero, Material[] materiais, 
			Usuario solicitante, String data)
	{
		this.setNumero(numero);
		this.setMateriais(materiais);
		this.setUsuario(solicitante);
		this.setData(data);
	}
	
	public final String getNumero()
	{
		return this.numero;
	}
	
	public final void setNumero(String numero)
	{
		if (numero == null || numero.equals(""))
			imprimeMensagemDeErro("Não pode passar 'numero' nulo ou vazio");
		else
			this.numero = numero;
	}
	
	public final Material[] getMateriais()
	{
		return this.materiais;
	}
	
	public final void setMateriais(Material[] materiais)
	{
		if (materiais == null)
			imprimeMensagemDeErro("Não pode passar array nulo!");
		else
			this.materiais = materiais;
	}
	
	public final Usuario getUsuario()
	{
		return this.solicitante;
	}
			
	public final String getData()
	{
		return this.data;
	}
	
	public final void setData(String data)
	{
		if (data == null)
			imprimeMensagemDeErro("Não pode passar data nula!");
		else
			this.data = data;
	}
	
	/*
	 * implementar conforme o tipo de solicitação.
	 */
	public abstract void setUsuario(Usuario usuarioSolicitante);
	
	/*
	 * implementar conforme classe concreta
	 */
	public abstract String toString();
	
	/*
	 * implementar conforme classe concreta
	 */
	public abstract boolean equals();
		
	/// Métodos privados ficam abaixo dessa linha
	private final void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
}
