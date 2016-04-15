package almoxarifado.beans;

public class Especificacao {
	private String nomeModificador;
	private String caracteristicasFisicas;
	private String Observacao;
	
	public Especificacao(String nomeModificador, String caracteristicasFisicas, String observacao) {
		this.nomeModificador = nomeModificador;
		this.caracteristicasFisicas = caracteristicasFisicas;
		Observacao = observacao;
	}

	public String getNomeModificador() {
		return nomeModificador;
	}

	public void setNomeModificador(String nomeModificador) {
		this.nomeModificador = nomeModificador;
	}

	public String getCaracteristicasFisicas() {
		return caracteristicasFisicas;
	}

	public void setCaracteristicasFisicas(String caracteristicasFisicas) {
		this.caracteristicasFisicas = caracteristicasFisicas;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	/**
	 * Duas especifica��es s�o iguais quando possuem os mesmos nomes modificador.
	 * 
	 * @param comparado
	 * @return
	 */
	public boolean equals(Especificacao comparado){
		boolean resultado = false;
		
		if (comparado != null)
			resultado = this.nomeModificador.equals(comparado.getNomeModificador()) ? 
					true : false ;
		
		return resultado;
	}
	
}
