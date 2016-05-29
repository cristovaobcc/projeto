package almoxarifado.fachada;

import almoxarifado.material.beans.Material;
import almoxarifado.material.negocio.ControlCadastroMatComInterface;
import almoxarifado.material.repositorio.IRepositorioMateriais;
import almoxarifado.usuario.beans.UsuarioOficial;

public class FachadaUsuarioGestor {
	
	private static FachadaUsuarioGestor instance;
	private ControlCadastroMatComInterface contCadMaterial;
	
	private FachadaUsuarioGestor(UsuarioOficial user, IRepositorioMateriais rep)
	{
		this.contCadMaterial = new ControlCadastroMatComInterface(rep, user.getNivelDeAcesso());
	}
	
	public static FachadaUsuarioGestor getInstance(UsuarioOficial user, IRepositorioMateriais rep)
	{
		if (instance == null)
			instance = new FachadaUsuarioGestor(user, rep);
		return instance;
	}
	
	public boolean inserirMaterial(Material m, UsuarioOficial user)
	{
		return this.contCadMaterial.inserirMaterial(m, user);
	}
	
	public Material buscarMaterial(Material m)
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
	
}
