package almoxarifado.material.negocio;

import almoxarifado.material.beans.Material;
import almoxarifado.material.repositorio.IRepositorioMateriais;
import almoxarifado.usuario.beans.UsuarioGestor;

public class ControladorDeCadastroComInterface {
	
	private IRepositorioMateriais rep;
	private UsuarioGestor user;
	private int codAutomatico;
	private int verifica; // usado no método private verifica()
	
	/**
	 * Inicializa controlador de repositorio.
	 * Recebe o UsuarioGestor user e tipoDeRepositorio que sera configurado 
	 * conforme valor passado:
	 *  1 = é para configurar repositorio de array de materiais
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
	
	//TODO: iniciar a implementação de negócios aqui!
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
		if (this.verificaCamposDeMaterial(m, 3)){
			buscado = this.rep.buscarMaterial(m);
		} else this.printErrorMsg("buscaMaterial");
		return buscado;
	}
	
	public boolean inserirMaterial(Material m)
	{
		boolean inserido = false;
		if ( m != null){
			if( rep.buscar (m.getCodigo() ) == null){
				m.setIdCadastrador(this.user.getId());
				m.setCodigo(Integer.toString(this.getCodAutomatico()));
				this.atualizarCodMaterial();
				rep.inserir(m);
				inserido = true;
			}
		}
		return inserido;
	}
	
	private boolean verificaCamposDeMaterial(Material m, int numCampos)
	{
		boolean resultado = false;
		this.verifica = numCampos;
		if (m != null){
			switch (numCampos){
		case 3: 
			if (m.getCodigo() != null)
				this.verifica--;
		case 2:
			if (m.getNomeBasico() != null)
				this.verifica--;
		case 1:
			if (m.getEsp().getNomeModificador() != null)
				this.verifica--;
		}
		}
		if (this.verifica == 0)
			resultado = true;
		return resultado;
	}
	
	private void atualizarCodMaterial(){
		this.codAutomatico++;
	}
	
	// controlador é que vai dar msg de erro!
	private void printErrorMsg(String msg)
	{
		System.out.println("\n>>> Erro em :" +
						msg + "! <<<");
	}

}
