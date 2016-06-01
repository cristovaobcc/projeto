package almoxarifado.fachada;

import almoxarifado.material.beans.Material;
import almoxarifado.material.negocio.ControlCadastroMatGestor;
import almoxarifado.material.repositorio.IRepositorioMateriais;
import almoxarifado.usuario.beans.UsuarioOficial;

public class FachadaUsuarioGestor {
	
	private static FachadaUsuarioGestor instance;
	private ControlCadastroMatGestor contCadMaterial;
	private UsuarioOficial user;
	
	private FachadaUsuarioGestor(UsuarioOficial user, IRepositorioMateriais rep)
	{
		this.contCadMaterial = new ControlCadastroMatGestor(rep, user.getNivelDeAcesso());
		this.setUser(user);
	}
	
	public static FachadaUsuarioGestor getInstance(UsuarioOficial user, IRepositorioMateriais rep)
	{
		if (instance == null)
			instance = new FachadaUsuarioGestor(user, rep);
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
	
	public int getCodigoAutomatico()
	{
		return this.contCadMaterial.getCodAutomatico();
	}
	
	public void listarMaterial()
	{
		this.contCadMaterial.listar();
	}
	
}
