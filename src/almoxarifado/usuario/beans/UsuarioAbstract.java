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
	
	public abstract String toString();
	
	public abstract boolean Equals();
	
	protected final void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
}
