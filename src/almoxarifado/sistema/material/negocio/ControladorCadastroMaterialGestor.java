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
	 * Recebe um IRepositorio Rep e um nivel de acesso de usuário.
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
	 * Insere um material m não-null passado como parâmetro no repositório
	 * se m respeitar os critérios:
	 * 1 - campo Codigo não for nulo e for > 3 caracteres;
	 * 2 - campo nomeBasico não for nulo e for > 3 caracteres;
	 * 3 - campo nomeModificador não for nulo e for > 3 caracteres;
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
			// lança exceção
			;
		return inserido;
	}

	/**
	 * Recebe um material m e devolve um ArrayList<Material> 
	 * para a função chamadora. Caso o material não
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
	 * Recebe um Material m e verifica se há algum
	 * material n com o mesmo código de m.
	 * Se houver tal material n, devolve n.
	 * Se não devolve null;
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
	 * de mesmo código no repositório.
	 * Se a substituição foi feita com sucesso,
	 * devolve true. Caso contrário, devolve
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
	 * de mesmo código constante no repositório.
	 * Devolve true, se foi removido com sucesso.
	 * Caso contrário, devolve false. 
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
	 * repositório rep.
	 */

	public void listar()
	{
		rep.listar();
	}
	
	public ArrayList<Material> listarTodos(){
		return this.rep.listarParaArrayList();
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
	 * Método que é o coração das regras de negócios.
	 * Recebe um material m e um inteiro numCampos:
	 * 1 - examina se o codigo de m é nulo e menor que 4 caracteres;
	 * 2 - examina se nomeBasico de m é nulo e menor que 4 caracteres;
	 * 3 - examina se nomeModificador de m é nulo e menor que 4 caracteres;
	 * retorna false caso a opção selecionada não seja verdadeira;
	 * @param m Material
	 * @param numCampos int
	 * @return boolean
	 * @throws MaterialNuloException 
	 */
	//TODO: quando fizer a classe código fazer aqui a verificação completa da 
	// opção 1.
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
