package almoxarifado.material.beans;

public class Especificacao {
	private String nomeModificador;
	private String caracteristicasFisicas;
	private String observacao;
	private String marca;
	private String unidadeDeMedida;
	
	public Especificacao(String nomeModificador, String caracteristicasFisicas, String obs, 
			String marca, String unidMed) {
		this.setNomeModificador(nomeModificador);
		this.setCaracteristicasFisicas(caracteristicasFisicas);
		this.setObservacao(obs);
		this.setMarca(marca);
		this.setUnidadeDeMedida(unidMed);
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
		return observacao;
	}

	public void setObservacao(String obs) {
		observacao = obs;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
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
				+ caracteristicasFisicas + ", Observacao=" + observacao + "]";
	}
	
	
	
}
