package almoxarifado.sistema.material.excecoes;

@SuppressWarnings("serial")
public class MaterialCodigoInvalidoException extends Exception {
	
	private String codigoInvalido;

	/**
	 * @param codigoInvalido
	 */
	public MaterialCodigoInvalidoException() {
		super("C�digo inv�lido: o c�digo");
		this.setCodigoInvalido(codigoInvalido);
	}

	/**
	 * @return the codigoInvalido
	 */
	public String getCodigoInvalido() {
		return codigoInvalido;
	}

	/**
	 * @param codigoInvalido the codigoInvalido to set
	 */
	private void setCodigoInvalido(String codigoInvalido) {
		this.codigoInvalido = codigoInvalido;
	}
	
	

}
