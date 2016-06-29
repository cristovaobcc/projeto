package almoxarifado.sistema.material.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Especificacao implements Serializable {
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracteristicasFisicas == null) ? 0 : caracteristicasFisicas.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nomeModificador == null) ? 0 : nomeModificador.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((unidadeDeMedida == null) ? 0 : unidadeDeMedida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Especificacao)) {
			return false;
		}
		Especificacao other = (Especificacao) obj;
		if (caracteristicasFisicas == null) {
			if (other.caracteristicasFisicas != null) {
				return false;
			}
		} else if (!caracteristicasFisicas.equals(other.caracteristicasFisicas)) {
			return false;
		}
		if (marca == null) {
			if (other.marca != null) {
				return false;
			}
		} else if (!marca.equals(other.marca)) {
			return false;
		}
		if (nomeModificador == null) {
			if (other.nomeModificador != null) {
				return false;
			}
		} else if (!nomeModificador.equals(other.nomeModificador)) {
			return false;
		}
		if (observacao == null) {
			if (other.observacao != null) {
				return false;
			}
		} else if (!observacao.equals(other.observacao)) {
			return false;
		}
		if (unidadeDeMedida == null) {
			if (other.unidadeDeMedida != null) {
				return false;
			}
		} else if (!unidadeDeMedida.equals(other.unidadeDeMedida)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Especificacao [nomeModificador=" + nomeModificador + ", caracteristicasFisicas="
				+ caracteristicasFisicas + ", observacao=" + observacao + ", marca=" + marca + ", unidadeDeMedida="
				+ unidadeDeMedida + ", toString()=" + super.toString() + "]";
	}
		
}
