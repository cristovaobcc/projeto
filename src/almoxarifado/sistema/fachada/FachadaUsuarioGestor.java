package almoxarifado.sistema.fachada;

import java.util.List;

import almoxarifado.sistema.material.beans.Material;
import almoxarifado.sistema.material.excecoes.MaterialCodigoInvalidoException;
import almoxarifado.sistema.material.excecoes.MaterialNomeInvalidoException;
import almoxarifado.sistema.material.excecoes.MaterialNuloException;
import almoxarifado.sistema.material.negocio.ControladorCadastroMaterialGestor;
import almoxarifado.sistema.material.repositorio.IRepositorioMateriais;
import almoxarifado.sistema.material.repositorio.RepositorioMateriaisArquivo;
import almoxarifado.sistema.usuario.beans.NivelDeAcesso;
import almoxarifado.sistema.usuario.beans.UsuarioOficial;

public class FachadaUsuarioGestor {
	
	private static FachadaUsuarioGestor instance;
	private ControladorCadastroMaterialGestor contCadMaterial;
	private UsuarioOficial user;
	
	private FachadaUsuarioGestor(UsuarioOficial user, IRepositorioMateriais rep)
	{
		this.contCadMaterial = new ControladorCadastroMaterialGestor(rep, user.getNivelDeAcesso());
		this.setUser(user);
	}
	
	private FachadaUsuarioGestor()
	{
		this.contCadMaterial = new ControladorCadastroMaterialGestor(RepositorioMateriaisArquivo.getInstance(),
					NivelDeAcesso.GESTOR);
		this.setUser(null);
		
	}
	
	public static FachadaUsuarioGestor getInstance(UsuarioOficial user, IRepositorioMateriais rep)
	{
		if (instance == null)
			instance = new FachadaUsuarioGestor();
		return instance;
	}
	
	public static FachadaUsuarioGestor getInstance(){
		if (instance == null)
			instance = new FachadaUsuarioGestor();
		return instance;
	}
	private void setUser(UsuarioOficial user)
	{
		this.user = user;
	}
	
	public UsuarioOficial getUser()
	{
		return this.user;
	}
	
	public boolean inserirMaterial(Material m, UsuarioOficial user) 
			throws MaterialCodigoInvalidoException,
			MaterialNomeInvalidoException, MaterialNuloException
	{
		return this.contCadMaterial.inserirMaterial(m, user);
	}
	
	public Material buscarMaterial (Material m) 
			throws MaterialCodigoInvalidoException,
			MaterialNomeInvalidoException, MaterialNuloException
	{
		return this.contCadMaterial.buscarMaterial(m);
	}
	
	public boolean alterarMaterial(Material m)
	{
		return this.contCadMaterial.alterarMaterial(m);
	}
	
	public boolean removerMaterial(Material m)
	{
		return this.contCadMaterial.removerMaterial(m);
	}
	
	public int getCodigoAutomatico()
	{
		return this.contCadMaterial.getCodAutomatico();
	}
	
	public void listarMaterial()
	{
		this.contCadMaterial.listar();
	}
	
	public List<Material> listarTodos()
	{
		return this.contCadMaterial.listarTodos();
	}
	
}
