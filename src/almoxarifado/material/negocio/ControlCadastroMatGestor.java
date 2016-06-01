package almoxarifado.material.negocio;

import almoxarifado.material.beans.Material;
import almoxarifado.material.repositorio.IRepositorioMateriais;
import almoxarifado.usuario.beans.NivelDeAcesso;
import almoxarifado.usuario.beans.UsuarioOficial;

public class ControlCadastroMatGestor {
	
	private IRepositorioMateriais rep;
	private int codAutomatico;
	private NivelDeAcesso nivel;
	
	/**
	 * Inicializa controlador de repositorio.
	 * Recebe um IRepositorio Rep e um nivel de acesso de usuário.
	 * @param rep 
	 * @param niv
	 */
	public ControlCadastroMatGestor(IRepositorioMateriais rep, NivelDeAcesso niv)
	{
		this.setNivel(niv);
		this.setRep(rep);
		this.codAutomatico = 1;
	}
	
	public NivelDeAcesso getNivel() {
		return nivel;
	}

	public void setNivel(NivelDeAcesso nivel) {
		this.nivel = nivel;
	}

	public IRepositorioMateriais getRep()
	{
		return this.rep;
	}
	
	private void setRep(IRepositorioMateriais rep)
	{
		this.rep = rep;
	}
			
	public int getCodAutomatico()
	{
		return this.codAutomatico;
	}

	// TODO: trabalhar os critérios de inserção de uma forma melhor!
	public boolean inserirMaterial(Material m, UsuarioOficial user)
	{
		boolean inserido = false;
		Material aInserir = this.buscarMaterial(m);
		if ( aInserir == null ){
			if( rep.buscarMaterial(m) == null){
				m.setIdCadastrador(user.getId());
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
	 * para a função chamadora. Caso o material não
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
	
	public void listar()
	{
		rep.listar();
	}
	
	/**
	 * Método que é o coração das regras de negócios.
	 * Recebe um material m e um inteiro numCampos:
	 * 1 - examina se o codigo de m é nulo e menor que 4 caracteres;
	 * 2 - examina se nomeBasico de m é nulo e menor que 4 caracteres;
	 * 3 - examina se nomeModificador de m é nulo e menor que 4 caracteres;
	 * retorna false caso a opção selecionada não seja verdadeira;
	 * @param m
	 * @param numCampos
	 * @return
	 */
	//TODO: quando fizer a classe código fazer aqui a verificação completa da 
	// opção 1.
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
	
	// controlador é que vai dar msg de erro!
	
	private void printErrorMsg(String msg)
	{
		System.out.println("\n>>> Erro em :" +	msg + "! <<<");
	}

}
