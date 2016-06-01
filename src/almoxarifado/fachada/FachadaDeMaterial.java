package almoxarifado.fachada;

import almoxarifado.material.beans.Material;
import almoxarifado.material.excecoes.MatNEncExc;
import almoxarifado.material.negocio.ControladorDeCadastro;
import almoxarifado.usuario.beans.Usuario;

public class FachadaDeMaterial {
	
	private static FachadaDeMaterial instancia;
	private ControladorDeCadastro controlCadastro;
	
	private FachadaDeMaterial(Usuario u){
		this.controlCadastro = new ControladorDeCadastro(u);
	}
	
	public static FachadaDeMaterial getInstance(Usuario u){
		if (instancia == null)
			instancia = new FachadaDeMaterial(u);
		return instancia;
	}
	
	/**
	 * @param cod
	 * @return
	 * @see almoxarifado.material.negocio.ControladorDeCadastro#buscaCodMaterial(java.lang.String)
	 */
	public Material buscaCodMaterial(String cod) {
		return controlCadastro.buscaCodMaterial(cod);
	}
	
	/**
	 * @param m
	 * @return
	 * @see almoxarifado.material.negocio.ControladorDeCadastro#inserirMaterial(almoxarifado.material.beans.Material)
	 */
	public boolean inserirMaterial(Material m) {
		return controlCadastro.inserirMaterial(m);
		/// TODO: implementar retorno de exceções aqui
	}
	
	/**
	 * @param m
	 * @return
	 * @see almoxarifado.material.negocio.ControladorDeCadastro#atualizarMaterial(almoxarifado.material.beans.Material)
	 */
	public boolean atualizarMaterial(Material m) {
		return controlCadastro.atualizarMaterial(m);
	}
	
	/**
	 * @param cod
	 * @return
	 * @see almoxarifado.material.negocio.ControladorDeCadastro#removerMaterial(java.lang.String)
	 */
	public boolean removerMaterial(String cod) throws MatNEncExc {
			return controlCadastro.removerMaterial(cod);
	}
	
	/**
	 * 
	 * @see almoxarifado.material.negocio.ControladorDeCadastro#listar()
	 */
	public void listar() {
		controlCadastro.listar();
	}

	/**
	 * @return
	 * @see almoxarifado.material.negocio.ControladorDeCadastro#getCodAutomatico()
	 */
	public int getCodAutomatico() {
		return controlCadastro.getCodAutomatico();
	}
	

}
