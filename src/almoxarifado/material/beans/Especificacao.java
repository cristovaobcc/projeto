package almoxarifado.material.beans;

public class Especificacao {
	private String nomeModificador;
	private String caracteristicasFisicas;
	private String Observacao;
	
	public Especificacao(String nomeModificador, String caracteristicasFisicas, String observacao) {
		this.nomeModificador = nomeModificador;
		this.caracteristicasFisicas = caracteristicasFisicas;
		Observacao = observacao;
	}
	
	public Especificacao() {
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
	 * Duas especificações são iguais quando possuem os mesmos nomes modificadores.
	 * 
	 * @param comparado
	 * @return
	 */
	public boolean equals(Especificacao comparado){
		boolean resultado = false;
		if (comparado != null)
			resultado = this.nomeModificador.equals(comparado.getNomeModificador());
		return resultado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Especificacao [nomeModificador=" + nomeModificador + ", caracteristicasFisicas="
				+ caracteristicasFisicas + ", Observacao=" + Observacao + "]";
	}
	
	
	
}
