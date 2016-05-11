package almoxarifado.usuario.beans;

public abstract class UsuarioAbstract {
	private String id;
	private String nome;
	private String senha;
	
	public UsuarioAbstract(String id, String nome, String senha)
	{
		this.setId(id);
		this.setNome(nome);
		this.setSenha(senha);
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}

	public final String getSenha() {
		return senha;
	}
	
	public final void setSenha(String senha) {
		this.senha = senha;
	}
	
	public abstract String getLotacao();
	
	public abstract void setLotacao(String lotacao);
	
	public abstract String toString();
	
	// Dois UsuarioGestor são iguais quando possui a mesma id.
	public final boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioGestor other = (UsuarioGestor) obj;
		if (this.getId() == null){
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId() ) )
			return false;
	
		return true;
	}
	
	protected final void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
}
