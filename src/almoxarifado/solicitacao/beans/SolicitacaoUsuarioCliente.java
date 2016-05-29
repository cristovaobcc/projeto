package almoxarifado.solicitacao.beans;
import almoxarifado.usuario.beans.UsuarioOficial;


public class SolicitacaoUsuarioCliente extends Solicitacao {
	
	// Toda solicitação de UsuarioCliente é atendida por algum UsuarioOficial
	private UsuarioOficial atendente;
	private UsuarioOficial avaliador;
	private boolean atendida;
	private boolean confirmar;
	// private UsuarioCliente solicitante;
	
	public SolicitacaoUsuarioCliente(String numero,
			UsuarioOficial solicitante, String data)
	{
		super(numero, solicitante, data);
		this.setAtendida(false);
		this.setConfirmar(false);
	}
	
	public void setAvaliador(UsuarioOficial avaliador)
	{
		//TODO: refinar implementação do avaliador.
		if (avaliador != null){
			this.avaliador = avaliador;
		}
		else
			super.imprimeMensagemDeErro("setAvaliador: nao pode passar avaliador nulo!");
	}
	
	public UsuarioOficial getAvaliador()
	{
		return this.avaliador;
	}
	
	public void setAtendente(UsuarioOficial atendente){
		if (atendente != null){
			this.atendente = atendente;
		}
		else
			super.imprimeMensagemDeErro("setAtendente: não pode passar atendente nulo!");
	}
	
	public UsuarioOficial getAtendente()
	{
		return this.atendente;
	}
			
	/* só quem muda a configuração de atendida é o UsuárioGestor
	 * implementar no controlador de 
	 */
	public void setAtendida(boolean s)
	{
		this.atendida = s;
	}
	
	public boolean getAtendida()
	{
		return this.atendida;
	}
	
	public void setConfirmar(boolean s)
	{
		this.confirmar = s;
	}
	
	// só que
	public boolean getConfirmar()
	{
		return this.confirmar;
	}
	
	public String toString()
	{
		return "[numero = " + this.getNumero() + "] [data = " + this.getData() +
				"[materiais = " + this.getMateriais().toString() + "] [solicitante = " +
				this.getUsuario().toString() + "]";
	}
	
	
	public boolean equals(Object obj)
	{
		boolean resultado;
		if (obj == null)
			resultado = false;
		else if (obj == this)
			resultado = true;
		else if (this.getClass() != obj.getClass())
			resultado = false;
		else {
			SolicitacaoUsuarioCliente other = (SolicitacaoUsuarioCliente) obj;
			if (this.getNumero().equals(other.getNumero()))
				resultado = true;
			else
				resultado = false;
		}
		return resultado;
	}
	
}
