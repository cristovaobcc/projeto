package almoxarifado.material.beans;

public class Material {
	private String nomeBasico;
	private String codigo;
	private int qtde;
	private Especificacao esp;
	private String dataDeAquisicao;
	private String idCadastrador;
	
	public Material(String nomeBasico, String codigo, int qtde, Especificacao esp, 
			String dataDeAquisicao, String idCadastrador) 
	{
		this.setNomeBasico(nomeBasico);
		this.setCodigo(codigo);
		this.setQtde(qtde);
		this.setEsp(esp);
		this.setDataDeAquisicao(dataDeAquisicao);
		this.setIdCadastrador(idCadastrador);
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
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String getIdCadastrador(String id){
		return this.idCadastrador;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setIdCadastrador(String id){
		this.idCadastrador = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((esp == null) ? 0 : esp.hashCode());
		return result;
	}

	/* 
	 * Dois materiais são iguais se tiverem o mesmo código e especificação.
	 * Devolve false se são diferentes e true se são iguais.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Material)) {
			return false;
		}
		Material other = (Material) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		if (esp == null) {
			if (other.esp != null) {
				return false;
			}
		} else if (!esp.equals(other.esp)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Material [nomeBasico=" + nomeBasico + ", codigo=" + codigo + ", qtde=" + qtde + ", esp=" + esp
				+ ", dataDeAquisicao=" + dataDeAquisicao + ", idCadastrador=" + idCadastrador +"]";
	}
		
}
