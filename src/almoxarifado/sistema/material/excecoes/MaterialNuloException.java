package almoxarifado.sistema.material.excecoes;

@SuppressWarnings("serial")
public class MaterialNuloException extends Exception {
	
	public MaterialNuloException(){
		super("Erro: Material Nulo");
	}

}
