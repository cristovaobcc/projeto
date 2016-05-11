package almoxarifado.material.repositorio;
import almoxarifado.material.beans.Material;

public class RepositorioMateriais {
	
	private static int TAMANHO = 1;
	private Material[] materiais;
	private int qtde;
	private static RepositorioMateriais instance;
	
	private RepositorioMateriais()
	{
		this.materiais = new Material[TAMANHO];
		this.qtde = 0;
	}
	
	public static RepositorioMateriais getInstance()
	{
		if (instance == null)
			instance = new RepositorioMateriais();
		return instance;
	}
	
	public int getQtdeMateriais()
	{
		return this.qtde;
	}
	
	public Material getMaterial(int i)
	{
		return this.materiais[i];
	}
	
	public void inserir(Material m)
	{
		this.materiais[this.qtde++] = m;
		if (this.qtde == this.materiais.length) {
			this.aumentarArrayMateriais();
		}
	}
	
	///TODO implementar um algoritmo de busca mais eficiente aqui
	public Material buscar(String cod)
	{
		Material matBuscado = null;
		for (Material m : this.materiais){
			if (m != null){
				if (m.getCodigo().equals(cod)){
					matBuscado = m;
				}
			} else break;
		}
		return matBuscado;
	}
	
	public boolean remover(String cod)
	{
		boolean removido = false;
		int indice = this.verificaIndiceDeMaterial(cod);
		if ( indice != -1){
			this.materiais[indice] = this.materiais[this.qtde-1];
			this.materiais[this.qtde-1] = null;
			removido = true; qtde--;
		}
		return removido;
	}
	 
	public void alterarMaterial(Material m)
	{
		this.materiais [this.verificaIndiceDeMaterial(m.getCodigo() ) ] = m;
	}
	
	public void listar()
	{
		System.out.println("\n---- Método Listar de Repositorio materiais armazenados ----");
		if (this.qtde == 0)
			System.out.println("\nNão há materais cadastrados!");
		else
			for(Material m: this.materiais){
				if (m != null)
					System.out.println("\n" + m);
			}
		System.out.println("\n-------------------------------------");
	}

/// MÉTODOS AUXILIARES VÃO ABAIXO DESSA LINHA
			
	private int verificaIndiceDeMaterial(String cod) {
		int indice = -1;
		for ( int i = 0; i < this.qtde; i++)
			if (this.materiais[i].getCodigo().equals(cod)){
				indice = i;
				break;
			}	
		return indice;
	}
	
/// Dúvida: vale a pena aumentar o array de 1 em 1?
	private void aumentarArrayMateriais()
	{
		if ( this.materiais.length > 0){
			Material[] arrayAumentado = new Material[this.materiais.length + 1];
			int i = 0;
			for (Material c: this.materiais){
				if ( c != null){
					arrayAumentado[i++] = c;
				}
				else
					break;				
			}
			this.materiais = arrayAumentado;
		}
	}
	
}
