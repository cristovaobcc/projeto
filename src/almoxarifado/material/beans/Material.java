package almoxarifado.material.beans;

public class Material {
	private String nomeBasico;
	private String codigo;
	private int qtde;
	private Especificacao esp;
	private String dataDeAquisicao;
	
	public Material(String nomeBasico, String codigo, int qtde, Especificacao esp, String dataDeAquisicao) 
	{
		this.nomeBasico = nomeBasico;
		this.codigo = codigo;
		this.qtde = qtde;
		this.esp = esp;
		this.dataDeAquisicao = dataDeAquisicao;
	}
	// construtor default
	public Material(){
	}
	/**
	 * @return the nomeBasico
	 */
	public String getNomeBasico() {
		return nomeBasico;
	}

	/**
	 * @param nomeBasico the nomeBasico to set
	 */
	public void setNomeBasico(String nomeBasico) {
		this.nomeBasico = nomeBasico;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the qtde
	 */
	public int getQtde() {
		return qtde;
	}

	/**
	 * @param qtde the qtde to set
	 */
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	/**
	 * @return the esp
	 */
	public Especificacao getEsp() {
		return esp;
	}

	/**
	 * @param esp the esp to set
	 */
	public void setEsp(Especificacao esp) {
		this.esp = esp;
	}

	/**
	 * @return the dataDeAquisicao
	 */
	public String getDataDeAquisicao() {
		return dataDeAquisicao;
	}

	/**
	 * @param dataDeAquisicao the dataDeAquisicao to set
	 */
	public void setDataDeAquisicao(String dataDeAquisicao) {
		this.dataDeAquisicao = dataDeAquisicao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Material [nomeBasico=" + nomeBasico + ", codigo=" + codigo + ", qtde=" + qtde + ", esp=" + esp
				+ ", dataDeAquisicao=" + dataDeAquisicao + "]";
	}

	/* 
	 * Dois materiais s�o iguais se tiverem o mesmo c�digo e especifica��o.
	 * Devolve false se s�o diferentes e true se s�o iguais.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (codigo == null) {
			if (other.getCodigo() != null)
				return false;
		} else if (!codigo.equals(other.getCodigo() ) && !this.esp.equals(other.getEsp() ) )
			return false;
		return true;
	}
		
	
}
