package almoxarifado.material.excecoes;

public class MatNEncExc extends Exception {
	
	private String codigo;
	
	public MatNEncExc(String s){
		super("Material n�o encontrado!");
		this.codigo = s;
	}
	
	public String getCodigo()
	{
		return this.codigo;
	}
	
}
