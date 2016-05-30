package almoxarifado.solicitacao.beans;
import almoxarifado.usuario.beans.UsuarioOficial;

/**
 * Classe que representa uma solicitação de materiais
 * feita por usuários do Almoxarifado. Deve ser usuada por 
 * Usuario com nivel de Acesso
 * Gestor e Solicitante.
 * @author cristovao
 *
 */
public final class SolicitacaoUsuarioCliente extends Solicitacao {
	
	private UsuarioOficial atendente; // Usuario que atende a solicitação
	private UsuarioOficial avaliador; // Usuario que avalia a quantidade de materais solicitados.
	private boolean atendida;
	private boolean confirmar;
	/**
	 * Contrutor do objeto SolicitacaoUsuarioCliente. Também configura os
	 * campos 'atendida' e 'confirmar' como false. O usuário
	 * deste objeto tb deve configurar os campos 'atendente' e 'avaliador'
	 * separadamente.
	 * @param numero
	 * @param solicitante
	 * @param data
	 */
	public SolicitacaoUsuarioCliente(String numero,
			UsuarioOficial solicitante, String data)
	{
		super(numero, solicitante, data);
		this.setAtendida(false);
		this.setConfirmar(false);
	}
	
	/**
	 * Configura o campo 'avaliador' com um UsuarioOficial passado.
	 * @param avaliador UsuarioOficial a ser configurado.
	 */
	public void setAvaliador(UsuarioOficial avaliador)
	{
		this.avaliador = avaliador;
	}
	/**
	 * Devolve um UsuarioOficial configurado para o campo 'avaliador' 
	 * da SolicitacaoUsuarioCliente.
	 * Caso não tenha sido configurado devolve null.
	 * @return
	 */
	public UsuarioOficial getAvaliador()
	{
		return this.avaliador;
	}
	
	
	/**
	 * Configura o campo 'atendente' com um UsuarioOficial passado.
	 * @param atendente UsuarioOficial a ser configurado.
	 */
	public void setAtendente(UsuarioOficial atendente){
		this.atendente = atendente;
	}
	
	/**
	 * Devolve um UsuarioOficial configurado para o campo 'atendente'
	 * da SolicitacaoUsuarioCliente.
	 * Caso não tenha sido configurado devolve null.
	 * @return
	 */
	public UsuarioOficial getAtendente()
	{
		return this.atendente;
	}
	
	/**
	 * Configura o campo 'atendida' com o boolean 's' passado.
	 * @param s
	 */
	public void setAtendida(boolean s)
	{
		this.atendida = s;
	}
	
	/**
	 * Devolve o valor configurado para o campo 'atendida'.
	 * @return
	 */
	public boolean getAtendida()
	{
		return this.atendida;
	}
	
	/**
	 * Configura o campo 'confirmar' com o boolean 's' passado.
	 * @param s
	 */
	public void setConfirmar(boolean s)
	{
		this.confirmar = s;
	}
	
	/**
	 * Devolve o valor configurado para o campo 'confirmar'.		
	 * @return
	 */
	public boolean getConfirmar()
	{
		return this.confirmar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SolicitacaoUsuarioCliente [atendente=" + atendente + ", avaliador=" + avaliador + ", atendida="
				+ atendida + ", confirmar=" + confirmar + ", toString()=" + super.toString() + "]";
	}

}
