package almoxarifado.sistema.usuario.beans;

public enum NivelDeAcesso {
	MASTER("M"), GESTOR("G"), SOLICITANTE("S");
	private String abbreviation;
	
	private NivelDeAcesso(String abbreviation)
	{
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation()
	{
		return this.abbreviation;
	}
}
