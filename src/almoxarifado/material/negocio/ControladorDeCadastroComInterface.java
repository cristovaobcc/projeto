package almoxarifado.material.negocio;

import almoxarifado.material.beans.Material;
import almoxarifado.material.repositorio.IRepositorioMateriais;
import almoxarifado.usuario.beans.UsuarioGestor;

public class ControladorDeCadastroComInterface {
	
	private IRepositorioMateriais rep;
	private UsuarioGestor user;
	private int codAutomatico;
	
	/**
	 * Inicializa controlador de repositorio.
	 * Recebe o UsuarioGestor user e tipoDeRepositorio que sera configurado 
	 * conforme valor passado:
	 *  1 = � para configurar repositorio de array de materiais
	 *  
	 * @param user
	 * @param tipoDeRepositorio
	 */
	public ControladorDeCadastroComInterface(UsuarioGestor user,
			IRepositorioMateriais rep)
	{
		this.setRep(rep);
		this.user = user;
		this.codAutomatico = 1;
	}
	
	public IRepositorioMateriais getRep()
	{
		return this.rep;
	}
	
	private void setRep(IRepositorioMateriais rep)
	{
		this.rep = rep;
	}
	
	public UsuarioGestor getUsuario()
	{
		return this.user;
	}
	
	public int getCodAutomatico()
	{
		return this.codAutomatico;
	}

	// TODO: trabalhar os crit�rios de inser��o de uma forma melhor!
	public boolean inserirMaterial(Material m)
	{
		boolean inserido = false;
		Material aInserir = this.buscarMaterial(m);
		if ( aInserir == null ){
			if( rep.buscarMaterial(m) == null){
				m.setIdCadastrador(this.user.getId());
				m.setCodigo(Integer.toString(this.getCodAutomatico()));
				this.atualizarCodMaterial();
				rep.inserirMaterial(m);
				inserido = true;
			}
		}
		return inserido;
	}
	
	/**
	 * Recebe um material m e devolve um material
	 * para a fun��o chamadora. Caso o material n�o
	 * tenha pelo menos um dos tres campos preenchidos
	 * (codigo, nomeBasico, nomeModificador) devolve material null
	 * e exibe uma mensagem de erro.
	 * @param m
	 * @return
	 */
	public Material buscarMaterial(Material m)
	{
		Material buscado = null;
		if ( this.verificaCamposDeMaterial(m, 1) ||
			 this.verificaCamposDeMaterial(m,  2) ||
			 this.verificaCamposDeMaterial(m, 3))
			buscado = this.rep.buscarMaterial(m);
		return buscado;
			
	}
	
	public boolean alterarMaterial(Material m)
	{
		boolean alterado = false;
		Material matAlterado = this.buscarMaterial(m);
		if ( matAlterado != null ){
			rep.alterarMaterial(matAlterado);
			alterado = true;
		}		
		return alterado;
	}
	
	public boolean removerMaterial(Material m)
	{
		boolean removido = false;
		Material aRemover = this.buscarMaterial(m);
		if (aRemover != null){
			rep.removerMaterial(m);
		}
		return removido;
	}
	
	/**
	 * M�todo que � o cora��o das regras de neg�cios.
	 * Recebe um material m e um inteiro numCampos:
	 * 1 - examina se o codigo de m � nulo e menor que 4 caracteres;
	 * 2 - examina se nomeBasico de m � nulo e menor que 4 caracteres;
	 * 3 - examina se nomeModificador de m � nulo e menor que 4 caracteres;
	 * retorna false caso a op��o selecionada n�o seja verdadeira;
	 * @param m
	 * @param numCampos
	 * @return
	 */
	//TODO: quando fizer a classe c�digo fazer aqui a verifica��o completa da 
	// op��o 1.
	private boolean verificaCamposDeMaterial(Material m, int numCampos)
	{
		boolean resultado = false;
		if (m != null){
			switch (numCampos){
		case 1:
			if (m.getCodigo() != null)
				resultado = true; break;
		case 2:
			if (m.getNomeBasico() != null && m.getNomeBasico().length() > 3)
				resultado = true; break;
		case 3: 
			if (m.getEsp().getNomeModificador() != null && 
					m.getEsp().getNomeModificador().length() > 3)
				resultado = true; break;
		default:
			printErrorMsg("VerificaCamposDeMaterial");
		}
		}
		return resultado;
	}
	
	private void atualizarCodMaterial(){
		this.codAutomatico++;
	}
	
	// controlador � que vai dar msg de erro!
	
	private void printErrorMsg(String msg)
	{
		System.out.println("\n>>> Erro em :" +	msg + "! <<<");
	}

}
