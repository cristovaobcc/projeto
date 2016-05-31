package almoxarifado.solicitacao.beans;
import java.util.ArrayList;
import almoxarifado.material.beans.Material;
import almoxarifado.usuario.beans.UsuarioOficial;;
/**
 * Classe abstrata Solicita��o que engloba o que � necess�rio para 
 * todas solicita��es.
 * @author cristovao
 *
 */
public abstract class Solicitacao {
	
	private String numero;
	private ArrayList<Material> materiais;
	private UsuarioOficial solicitante;
	private String data;
	
	/**
	 * Construtor do objeto Solicita��o. Tamb�m configura um ArrayList<Materiais>.
	 * @param numero o n�mero da solicita��o
	 * @param solicitante	objeto do tipo UsuarioOficial
	 * @param data data da solicita��o
	 */
	public Solicitacao(String numero, UsuarioOficial solicitante, String data)
	{
		this.setNumero(numero);
		this.setUsuario(solicitante);
		this.setData(data);
		this.materiais = new ArrayList<Material>();
	}
	/**
	 * Obt�m o n�mero da solicita��o.
	 * @return 
	 */
	public final String getNumero()
	{
		return this.numero;
	}
	
	/**
	 * Configura o numero da solicita��o.
	 * @param numero
	 */
	public final void setNumero(String numero)
	{
		if (numero == null || numero.equals(""))
			imprimeMensagemDeErro("N�o pode passar 'numero' nulo ou vazio");
		else
			this.numero = numero;
	}
	
	/**
	 * Devolve o ArrayList<Material> da Solicita��o.
	 * @return
	 */
	public final ArrayList<Material> getMateriais()
	{
		return this.materiais;
	}
	
	/**
	 * Devolve o UsuarioOficial da Solicita��o.
	 * @return
	 */
	public final UsuarioOficial getSolicitante()
	{
		return this.solicitante;
	}
	/**
	 * Devolve a Data da Solicita��o.		
	 * @return
	 */
	public final String getData()
	{
		return this.data;
	}
	
	/**
	 * Configura a data da solicita��o.
	 * @param data
	 */
	public final void setData(String data)
	{
		this.data = data;
	}
	
	/**
	 * Insere Material na solicita��o
	 * @param m material a ser inserido.
	 */
	public final void inserirMaterial(Material m){
		this.materiais.add(m);
	}
	
	/**
	 * Devolve um material inserido na Solicita��o. Se n�o
	 * existir devolve null;
	 * @param mat material a ser buscado.
	 * @return
	 */
	public final Material buscaMaterialEmArray(Material mat)
	{
		Material m = null;
		for (Material p: this.materiais){
			if (p.equals(mat))
				m = p;
		}		
		return m;
	}
	
	/**
	 * Devolve o �ndice ocupado pelo material passado na Solicita��o.
	 * O material deve constar na lista para que ele devolva o �ndice
	 * correto.
	 * @param mat material contido na Solicita��o.
	 * @return
	 */
	public final int buscaIndiceMaterialEmArray(Material mat)
	{
		int i;
		for ( i = 0; i < this.materiais.size(); i++){
			if(materiais.get(i).equals(mat)) break;
		}	
		return i;
	}
	
	/**
	 * Altera um material j� inserido na Solicita��o.
	 * O material anterior � sobrescrito.  
	 * @param m material novo.
	 */
	public final void alterarMaterial(Material m)
	{
		this.materiais.set(this.buscaIndiceMaterialEmArray(m), m);
	}
	
	/**
	 * Remove um material j� inserido na Solicita��o.
	 * 
	 * @param m material a ser removido.
	 */
	public final void removerMaterial(Material m){		
		this.materiais.remove(this.buscaIndiceMaterialEmArray(m));
	}
		
	/**
	 * Configura um UsuarioOficial para a Solicita��o.
	 * @param usuarioSolicitante
	 */
	public final void setUsuario(UsuarioOficial usuarioSolicitante)
	{
		this.solicitante = usuarioSolicitante;
	}
	
			
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((materiais == null) ? 0 : materiais.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((solicitante == null) ? 0 : solicitante.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Solicitacao)) {
			return false;
		}
		Solicitacao other = (Solicitacao) obj;
		if (numero == null) {
			if (other.numero != null) {
				return false;
			}
		} else if (!numero.equals(other.numero)) {
			return false;
		}
		return true;
	}
		
	@Override
	public String toString() {
		return "Solicitacao [numero=" + numero + ", materiais=" + materiais + ", solicitante=" + solicitante + ", data="
				+ data + "]";
	}
	
	/// M�todos privados ficam abaixo dessa linha
	public final void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
	
	
}
