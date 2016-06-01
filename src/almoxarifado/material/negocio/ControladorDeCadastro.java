package almoxarifado.material.negocio;
import almoxarifado.material.beans.Material;
import almoxarifado.material.excecoes.MatNEncExc;
import almoxarifado.material.repositorio.RepositorioMateriais;
import almoxarifado.usuario.beans.Usuario;

public class ControladorDeCadastro {
	
	private RepositorioMateriais rep;
	private Usuario user;
	private int codAutomatico;
	
	public ControladorDeCadastro(Usuario u){
		setRep(RepositorioMateriais.getInstance());
		this.user = u;
		this.codAutomatico = 1;
	}

	public RepositorioMateriais getRep() {
		return rep;
	}

	private void setRep(RepositorioMateriais rep) {
		this.rep = rep;
	}
	
	public Usuario getUsuario()
	{
		return this.user;
	}
	
	public int getCodAutomatico()
	{
		return this.codAutomatico;
	}
	
	//TODO implementar método de busca de material por nome
	public Material buscaCodMaterial(String cod)
	{
		return rep.buscar(cod);
	}
	
	private void atualizarCodMaterial(){
		this.codAutomatico++;
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
	
	public boolean atualizarMaterial (Material m)
	{
		boolean atualizado = false;
		if ( m != null && rep.buscar(m.getCodigo()) != null){
			rep.alterarMaterial(m);
			atualizado = true;
		}		
		return atualizado;
	}
	
	public boolean removerMaterial (String cod)
		throws MatNEncExc
	{
		boolean removido = false;
		if (cod != null){
			removido = rep.remover(cod);
			if (!removido){
				MatNEncExc mne = new MatNEncExc(cod);
				throw mne; 
			}
				
		}
		return removido;
	}
	
	public void listar()
	{
		rep.listar();
	}
	
}
