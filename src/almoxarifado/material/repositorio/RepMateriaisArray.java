package almoxarifado.material.repositorio;
import almoxarifado.material.beans.Material;

public class RepMateriaisArray implements IRepositorioMateriais{
	
	private static RepMateriaisArray instance;
	private int tamanho;
	private Material[] materiais;
	private int qtde;
	
	
	private RepMateriaisArray()
	{
		this.tamanho = 100;
		this.materiais = new Material[tamanho];
		this.qtde = 0;
	}
	
	public static RepMateriaisArray getInstance()
	{
		if (instance == null)
			instance = new RepMateriaisArray();
		return instance;
	}
	
	/**
	 * Devolve a qtde de materais inseridos no repositorio.
	 * @return
	 */
	public int getQtde()
	{
		return this.qtde;
	}
	
	/**
	 * Devolve um Material da i-esima posicao do array.
	 * @param i
	 * @return
	 */
	public Material getMaterial(int i)
	{
		return this.materiais[i];
	}
	
	
	public boolean inserirMaterial(Material m)
	{
		boolean resultado = false;
		if (!this.buscarMaterial(m)){
			if (this.qtde + 1 != tamanho){
				this.materiais[this.qtde] = m;
			}
			else{
				this.tamanho += 100;
				this.aumentarArrayMateriais(this.tamanho);
				this.materiais[qtde] = m;
			}
		}
		return resultado;
	}
	
	public boolean buscarMaterial(Material m)
	{
		boolean resultado = false;
		heapSortMateriaisCodigo.heapSort(tamanho, this.materiais);
		// TODO: implementar um alg de busca binaria aqui.
		for( Material mat: this.materiais)
		{
			if (m.getNomeBasico().equals(mat.getNomeBasico())){
				resultado = true;
				break;
			}
				
		}
		return resultado;
	}
	
	/**
	 * Aumentar o tamanho do array do atributo materiais no tamanho
	 * passado.
	 * @param tamanho
	 */
	private void aumentarArrayMateriais(int tamanho)
	{
		Material[] novoArray = new Material[tamanho];
		int i = 0;
		for(Material m: this.materiais){
			novoArray[i++] = m;
		}
		this.materiais = novoArray;
	}
					
	/**
	 * Imprime msg inserida na tela.
	 * @param msg
	 */
	private void ImprimeMsgDeErro(String msg)
	{
		System.out.println(">>> Erro em: " + msg  +"!!!<<<");
	}
	
	
	public static void main(String[] args){
		
	}
	
}

