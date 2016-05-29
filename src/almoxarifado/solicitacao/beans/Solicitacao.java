package almoxarifado.solicitacao.beans;
import almoxarifado.material.beans.Material;
import almoxarifado.usuario.beans.UsuarioAbstract;;

public abstract class Solicitacao {
	
	private String numero;
	private Material[] materiais;
	private UsuarioAbstract solicitante;
	private String data;
	
	public Solicitacao(String numero, UsuarioAbstract solicitante, String data)
	{
		this.setNumero(numero);
		this.setMateriais();
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
	
	private void setMateriais()
	{
		if (materiais == null)
			imprimeMensagemDeErro("Não pode passar array nulo!");
		else
			this.materiais = new Material[1];
	}
	
	public final UsuarioAbstract getUsuario()
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
	
	// TODO: terminar implementação
	public void inserirMaterial(Material m){
		
	}
	
	public boolean removerMaterial(Material m){
		boolean removido = false;
		
		return removido;
	}
	
	/*
	 * implementar conforme o tipo de solicitação.
	 */
	public void setUsuario(UsuarioAbstract usuarioSolicitante)
	{
		this.solicitante = usuarioSolicitante;
	}
	
	/*
	 * implementar conforme classe concreta
	 */
	public abstract String toString();
	
	/*
	 * implementar conforme classe concreta
	 */
	public abstract boolean equals(Object obj);
	
	
	
	/// Métodos privados ficam abaixo dessa linha
	protected final void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
	
	
}
