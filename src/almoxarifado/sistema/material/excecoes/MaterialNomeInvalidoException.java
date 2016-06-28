package almoxarifado.sistema.material.excecoes;

@SuppressWarnings("serial")
public class MaterialNomeInvalidoException extends Exception{
	
	private String nomeInvalido;

	/**
	 * @param nomeInvalido
	 */
	public MaterialNomeInvalidoException(String nomeInvalido) {
		super("Nome invalido: deve ter mais de 3 caracteres!");
		this.setNomeInvalido(nomeInvalido);
	}

	/**
	 * @return the nomeInvalido
	 */
	public String getNomeInvalido() {
		return nomeInvalido;
	}

	/**
	 * @param nomeInvalido the nomeInvalido to set
	 */
	private void setNomeInvalido(String nomeInvalido) {
		this.nomeInvalido = nomeInvalido;
	} 

}
