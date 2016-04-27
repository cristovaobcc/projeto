package almoxarifado.usuario.beans;

public class Usuario {
	
	private String id;
	private String nome;
	private String senha;
	
	public Usuario(String id, String nome, String senha)
	{
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		if ( this == obj) /// verifica se ambos os objetos apontam para a mesma referência
			return true;
		if ( obj == null)
			return false;
		if (!(obj instanceof Usuario)) /// verifica se o objeto obj é uma instancia Usuario
			return false;
		/// somente após a verificação acima é que veremos os campos de cada objeto para
		/// ver se ambos são iguais ou não.
		Usuario other = (Usuario) obj;
		/// verifica campo id.
		if (this.id == null){
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId() ) ){
			return false;			
		}
		/// verifica campo nome
		if (this.nome == null){
			if (other.getNome() != null)
				return false;
		} else if (!this.nome.equals(other.getNome() ) ){
			return false;
		}
		
		return true;
	}
	
	
}
