package almoxarifado.sistema.usuario.beans;

public class UsuarioOficial {
	private String id;
	private String nome;
	private String senha;
	private String lotacao;
	private NivelDeAcesso nivAcesso;
	
	public UsuarioOficial(String id, String nome, String senha, String lot, 
			NivelDeAcesso niv)
	{
		this.setId(id);
		this.setNome(nome);
		this.setSenha(senha);
		this.setLotacao(lot);
		this.setNivelDeAcesso(niv);
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
	
	public final void setLotacao(String lot)
	{
		this.lotacao = lot;
	}
	
	public final String getLotacao()
	{
		return this.lotacao;
	}
	
	public final void setNivelDeAcesso(NivelDeAcesso nda)
	{
		this.nivAcesso = nda;
	}
	
	public final NivelDeAcesso getNivelDeAcesso()
	{
		return this.nivAcesso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		// precisa manter as 3 linhas abaixo?
		result = prime * result + ((lotacao == null) ? 0 : lotacao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}
	
	/**
	 * Um usuario é igual a outro se o id for o mesmo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UsuarioOficial)) {
			return false;
		}
		UsuarioOficial other = (UsuarioOficial) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		
		return true;
	}

	protected final void imprimeMensagemDeErro(String msg)
	{
		System.out.println(">>> Erro em " + this.getClass() + ": " + msg +" <<<");
	}
	
	
}
