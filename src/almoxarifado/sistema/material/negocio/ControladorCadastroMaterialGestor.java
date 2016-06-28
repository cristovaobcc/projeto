package almoxarifado.sistema.material.negocio;
import java.util.ArrayList;
import almoxarifado.sistema.material.beans.Material;
import almoxarifado.sistema.material.excecoes.MaterialCodigoInvalidoException;
import almoxarifado.sistema.material.excecoes.MaterialNomeInvalidoException;
import almoxarifado.sistema.material.excecoes.MaterialNuloException;
import almoxarifado.sistema.material.repositorio.IRepositorioMateriais;
import almoxarifado.sistema.usuario.beans.NivelDeAcesso;
import almoxarifado.sistema.usuario.beans.UsuarioOficial;

public final class ControladorCadastroMaterialGestor {

	private IRepositorioMateriais rep;
	private int codAutomatico;
	private NivelDeAcesso nivel;

	/**
	 * Inicializa um controlador de IRepositorioMateriais.
	 * Recebe um IRepositorio Rep e um nivel de acesso de usu�rio.
	 * @param rep 
	 * @param niv
	 */
	public ControladorCadastroMaterialGestor(IRepositorioMateriais rep, NivelDeAcesso niv)
	{
		this.setNivel(niv);
		this.setRep(rep);
		this.codAutomatico = 1;
	}

	/**
	 * Devolve NivelDeAcesso configurado no campo nivel.
	 * @return NivelDeAcesso
	 */
	public NivelDeAcesso getNivel() {
		return nivel;
	}

	/**
	 * Configura o campo nivel.
	 * @param nivel NivelDeAcesso
	 */
	public void setNivel (NivelDeAcesso nivel) {
		this.nivel = nivel;
	}

	/**
	 * Devolve o campo rep.
	 * @return IRepositorioMateriais
	 */
	public IRepositorioMateriais getRep()
	{
		return this.rep;
	}

	/**
	 * Devolve campo codAutomatico.
	 * @return int
	 */
	public int getCodAutomatico()
	{
		return this.codAutomatico;
	}

	/**
	 * Insere um material m n�o-null passado como par�metro no reposit�rio
	 * se m respeitar os crit�rios:
	 * 1 - campo Codigo n�o for nulo e for > 3 caracteres;
	 * 2 - campo nomeBasico n�o for nulo e for > 3 caracteres;
	 * 3 - campo nomeModificador n�o for nulo e for > 3 caracteres;
	 * 
	 * @param m Material
	 * @param user UsuarioOficial
	 * @return boolean
	 * @throws MaterialNuloException 
	 */
	public boolean inserirMaterial(Material m, UsuarioOficial user)
		throws MaterialCodigoInvalidoException,
		MaterialNomeInvalidoException, MaterialNuloException
	{
		boolean inserido = false;
		boolean camposValidados = false;

		if (m != null && this.verificaCamposDeMaterial(m, 1) &&
				this.verificaCamposDeMaterial(m, 2) &&
				this.verificaCamposDeMaterial(m, 3))
			camposValidados = true;
		if (camposValidados) {
			Material aInserir = rep.buscarMaterial(m);
			if ( aInserir == null ){
				if( rep.buscarMaterial(m) == null){
					m.setIdCadastrador(user.getId());
					m.setCodigo(Integer.toString(this.getCodAutomatico()));
					this.atualizarCodMaterial();
					rep.inserirMaterial(m);
					inserido = true;
				}
			}
		}
		else
			// lan�a exce��o
			;
		return inserido;
	}

	/**
	 * Recebe um material m e devolve um ArrayList<Material> 
	 * para a fun��o chamadora. Caso o material n�o
	 * tenha pelo menos um dos tres campos preenchidos
	 * (codigo, nomeBasico, nomeModificador) devolve ArrayList<Material>
	 * com tamanho 0 e exibe uma mensagem de erro.
	 * @param m
	 * @return
	 * @throws MaterialNuloException 
	 */
	public ArrayList<Material> buscarMateriais(Material m) throws 
		MaterialCodigoInvalidoException,
		MaterialNomeInvalidoException, MaterialNuloException
	{
		ArrayList<Material> buscado = new ArrayList<Material>();
		if ( this.verificaCamposDeMaterial(m, 1) ||
				this.verificaCamposDeMaterial(m,  2) ||
				this.verificaCamposDeMaterial(m, 3))
			buscado = this.rep.buscarMateriais(m);
		return buscado;
	}

	/**
	 * Recebe um Material m e verifica se h� algum
	 * material n com o mesmo c�digo de m.
	 * Se houver tal material n, devolve n.
	 * Se n�o devolve null;
	 * @param m Material
	 * @return Material
	 * @throws MaterialNuloException 
	 */
	public Material buscarMaterial(Material m)
		throws MaterialCodigoInvalidoException,
			MaterialNomeInvalidoException, MaterialNuloException
	{
		Material buscado = null;
		if (m != null && this.verificaCamposDeMaterial(m, 1))
			buscado = this.buscarMaterial(m);
		return buscado;
	}

	/**
	 * Recebe um Material m e substitui o material n
	 * de mesmo c�digo no reposit�rio.
	 * Se a substitui��o foi feita com sucesso,
	 * devolve true. Caso contr�rio, devolve
	 * false.
	 * @param m Material
	 * @return boolean
	 */
	public boolean alterarMaterial(Material m)
	{
		boolean alterado = false;
		if ( m != null && m.getCodigo() != null
				&& rep.buscarMaterial(m) != null){
			rep.alterarMaterial(m);
			alterado = true;
		}		
		return alterado;
	}

	/**
	 * Recebe o Material m e remove o material n
	 * de mesmo c�digo constante no reposit�rio.
	 * Devolve true, se foi removido com sucesso.
	 * Caso contr�rio, devolve false. 
	 * @param m
	 * @return
	 */
	public boolean removerMaterial(Material m)
	{
		boolean removido = false;
		if ( m != null && m.getCodigo() != null && 
				this.rep.buscarMaterial(m) != null){
			this.rep.removerMaterial(m);
			removido = true;
		}		
		return removido;
	}

	/**
	 * Lista todos os materiais cadastrados no 
	 * reposit�rio rep.
	 */

	public void listar()
	{
		rep.listar();
	}

	/**
	 * Configura o campo rep.
	 * @param rep IRepositorioMateriais
	 */
	private void setRep(IRepositorioMateriais rep)
	{
		this.rep = rep;
	}

	/**
	 * M�todo que � o cora��o das regras de neg�cios.
	 * Recebe um material m e um inteiro numCampos:
	 * 1 - examina se o codigo de m � nulo e menor que 4 caracteres;
	 * 2 - examina se nomeBasico de m � nulo e menor que 4 caracteres;
	 * 3 - examina se nomeModificador de m � nulo e menor que 4 caracteres;
	 * retorna false caso a op��o selecionada n�o seja verdadeira;
	 * @param m Material
	 * @param numCampos int
	 * @return boolean
	 * @throws MaterialNuloException 
	 */
	//TODO: quando fizer a classe c�digo fazer aqui a verifica��o completa da 
	// op��o 1.
	private boolean verificaCamposDeMaterial (Material m, int numCampos)
			throws MaterialCodigoInvalidoException, 
					MaterialNomeInvalidoException, MaterialNuloException
	{
		boolean resultado = false;
		if (m != null){
			switch (numCampos){
			case 1:
				if (m.getCodigo() != null)
					resultado = true;
				else
					throw new MaterialCodigoInvalidoException();
				break;
			case 2:
				if (m.getNomeBasico() != null && m.getNomeBasico().length() > 3)
					resultado = true; 
				else
					throw new MaterialNomeInvalidoException(m.getNomeBasico());
				break;
			case 3: 
				if (m.getEsp().getNomeModificador() != null && 
				m.getEsp().getNomeModificador().length() > 3)
					resultado = true;
				else
					throw new MaterialNomeInvalidoException(m.getNomeBasico());
			}
		}
		else
			throw new MaterialNuloException();
		return resultado;
	}

	/**
	 * Atualiza o campo codAutomatico.
	 * Incrementa esse campo em uma unidade. 
	 */
	private void atualizarCodMaterial(){
		this.codAutomatico++;
	}

}
