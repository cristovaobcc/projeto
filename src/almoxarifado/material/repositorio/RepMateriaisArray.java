package almoxarifado.material.repositorio;
import almoxarifado.material.beans.Material;
/**
 * Classe que trabalha com materiais organizados em 
 * um array. Implementa interface IRepositorioMaterais.
 * @author cristovao
 *
 */
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
		if (this.buscarMaterial(m) == null){
			if (this.qtde + 1 != tamanho){
				this.materiais[this.qtde++] = m;
			}
			else{
				this.tamanho += 100;
				this.aumentarArrayMateriais(this.tamanho);
				this.materiais[qtde] = m;
			}
		}
		return resultado;
	}
	
	public Material buscarMaterial(Material m)
	{
		Material buscado = null;
		HeapSortMateriaisCodigo.heapSort(tamanho, this.materiais);
		// TODO: implementar um alg de busca binaria para ser usado 
		// no lugar do cod abaixo.
		for( Material mat: this.materiais){
			if (mat != null && m.getNomeBasico().equals(mat.getNomeBasico())){
				buscado = mat;
				break;
			}		
		}
		return buscado;
	}
	
	public boolean removerMaterial(Material m)
	{
		boolean resultado = false;
		// se o material m existir no repositorio remove.
		if (this.buscarMaterial(m) != null){
			int indice = this.verificaIndiceDeMaterial(m);
			this.materiais[indice] = this.materiais[this.qtde - 1];
			this.materiais[this.qtde - 1] = null;
			this.qtde--;
			resultado = true;
		}
		
		return resultado;
	}
	
	public boolean alterarMaterial(Material m)
	{
		boolean resultado = false;
		if (this.buscarMaterial(m) != null){
			this.materiais [this.verificaIndiceDeMaterial(m)] = m;
		}
		return resultado;
	}
	
	public void listar()
	{
		for(Material m: this.materiais)
			System.out.println(m.toString());
	}
	/**
	 * Recebe um material e devolve o índice do material
	 * verificado no array. Caso não haja o material no
	 * array devolve -1.
	 * @param m
	 * @return
	 */
	//TODO: inserir algoritmo de busca no lugar do for aqui.
	private int verificaIndiceDeMaterial(Material m) {
		int indice = -1;
		if (this.buscarMaterial(m) != null){
			for ( int i = 0; i < this.qtde; i++)
				if (this.materiais[i].getCodigo().equals(m.getCodigo())){
					indice = i;
					break;
				}	
		}
		return indice;
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
						
	public static void main(String[] args){
		
	}
	
}

