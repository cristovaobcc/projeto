package almoxarifado.sistema.material.excecoes;

@SuppressWarnings("serial")
public class MaterialNaoEncontradoException extends Exception {
	
	private String codigo;
	
	public MaterialNaoEncontradoException(String s){
		super("Material n�o encontrado!");
		this.codigo = s;
	}
	
	public String getCodigo()
	{
		return this.codigo;
	}
	
}
