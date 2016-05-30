package almoxarifado.solicitacao.beans;
import java.util.ArrayList;
import almoxarifado.material.beans.Material;
import almoxarifado.usuario.beans.UsuarioOficial;;
/**
 * Classe abstrata Solicitação que engloba o que é necessário para 
 * todas solicitações.
 * @author cristovao
 *
 */
public abstract class Solicitacao {
	
	private String numero;
	private ArrayList<Material> materiais;
	private UsuarioOficial solicitante;
	private String data;
	
	/**
	 * Construtor do objeto Solicitação. Também configura um ArrayList<Materiais>.
	 * @param numero o número da solicitação
	 * @param solicitante	objeto do tipo UsuarioOficial
	 * @param data data da solicitação
	 */
	public Solicitacao(String numero, UsuarioOficial solicitante, String data)
	{
		this.setNumero(numero);
		this.setUsuario(solicitante);
		this.setData(data);
		this.materiais = new ArrayList<Material>();
	}
	/**
	 * Obtém o número da solicitação.
	 * @return 
	 */
	public final String getNumero()
	{
		return this.numero;
	}
	
	/**
	 * Configura o numero da solicitação.
	 * @param numero
	 */
	public final void setNumero(String numero)
	{
		if (numero == null || numero.equals(""))
			imprimeMensagemDeErro("Não pode passar 'numero' nulo ou vazio");
		else
			this.numero = numero;
	}
	
	/**
	 * Devolve o ArrayList<Material> da Solicitação.
	 * @return
	 */
	public final ArrayList<Material> getMateriais()
	{
		return this.materiais;
	}
	
	/**
	 * Devolve o UsuarioOficial da Solicitação.
	 * @return
	 */
	public final UsuarioOficial getUsuario()
	{
		return this.solicitante;
	}
	/**
	 * Devolve a Data da Solicitação.		
	 * @return
	 */
	public final String getData()
	{
		return this.data;
	}
	
	/**
	 * Configura a data da solicitação.
	 * @param data
	 */
	public final void setData(String data)
	{
		this.data = data;
	}
	
	/**
	 * Insere Material na solicitação
	 * @param m material a ser inserido.
	 */
	public final void inserirMaterial(Material m){
		this.materiais.add(m);
	}
	
	/**
	 * Devolve um material inserido na Solicitação. Se não
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
	 * Devolve o índice ocupado pelo material passado na Solicitação.
	 * O material deve constar na lista para que ele devolva o índice
	 * correto.
	 * @param mat material contido na Solicitação.
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
	 * Altera um material já inserido na Solicitação.
	 * O material anterior é sobrescrito.  
	 * @param m material novo.
	 */
	public final void alterarMaterial(Material m)
	{
		this.materiais.set(this.buscaIndiceMaterialEmArray(m), m);
	}
	
	/**
	 * Remove um material já inserido na Solicitação.
	 * 
	 * @param m material a ser removido.
	 */
	public final void removerMaterial(Material m){		
		this.materiais.remove(this.buscaIndiceMaterialEmArray(m));
	}
		
	/**
	 * Configura um UsuarioOficial para a Solicitação.
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
		if (solicitante == null) {
			if (other.solicitante != null) {
				return false;
			}
		} else if (!solicitante.equals(other.solicitante)) {
			return false;
		}
		return true;
	}
		
	@Override
	public String toString() {
		return "Solicitacao [numero=" + numero + ", materiais=" + materiais + ", solicitante=" + solicitante + ", data="
				+ data + "]";
	}
	
	/// Métodos privados ficam abaixo dessa linha
	public final void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
	
	
}
