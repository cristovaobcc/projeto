package almoxarifado.solicitacao.beans;

import almoxarifado.material.beans.Material;

// TODO: classe auxiliar de Solicitacao. 
// Deve funcionar como uma listagem de materiais.
// Onde tiver array de materiais devo substituir por ListaDeMaterial

public class ListaDeMaterial {
	
	private Material[] listaDeMateriais;
	private int qtde;
	
	public ListaDeMaterial(){
		this.listaDeMateriais = new Material[0];
		this.qtde = 0;
	}
	
	/**
	 * Retorna um array de Material;
	 * @return
	 */
	public Material[] getLista()
	{
		return this.listaDeMateriais;
	}
	
	/**
	 * Recebe um Material m e insere na listaDeMateriais. 
	 * Devolve true caso tenha inserido, false caso contrário.
	 * @param m
	 * @return
	 */
	public boolean inserir(Material m)
	{
		boolean inserido = false;
		if (m != null && !this.buscar(m)){
			this.aumentarLista();
			this.listaDeMateriais[this.qtde++] = m;
			// TODO: implementar um algoritmo de ordenação quando inserir?
			inserido = true;
		}
		return inserido;
	}
	
	
	/**
	 * Remove o material m da lista de Materiais.
	 * Devolve true se foi removido, false caso contrário.
	 * @param m
	 * @return
	 */
	public boolean remover(Material m)
	{
		boolean removido = false;
		int indice = this.verificaIndiceDeMaterial(m);
		if (m != null && indice != -1){
			this.listaDeMateriais[indice] = this.listaDeMateriais[qtde];
			this.listaDeMateriais[qtde] = null;
			qtde--;
			removido = true;
		}
		return removido;
	}
	
	/**
	 * Busca se o material m está dentro da lista de Materiais.
	 * Devolve true caso o material esteja na lista e false 
	 * caso contrário.
	 * @param m
	 * @return
	 */
	public boolean buscar(Material m)
	{
		boolean busca = false;
		for( Material procurado: this.listaDeMateriais)
			if(procurado.getCodigo().equals(m.getCodigo()))
				busca = true;
		return busca;
	}
	
	public boolean atualizarQtde(Material m, int qtde)
	{
		
		return true;
	}
	
	public void listar()
	{
		
	}
	
	/**
	 * Este método aumentar o atributo listaDeMateriais em 1 unidade;
	 */
	private void aumentarLista()
	{
		Material[] array = new Material[this.qtde + 1];
		int i = 0; 
		for (Material m: this.listaDeMateriais)
			array[i++] = m;
		this.listaDeMateriais = array;
	}
	
	/**
	 * Verifica em que indice do atributo listaDeMateriais o 
	 * Material m se encontra.
	 * @param m
	 * @return
	 */
	private int verificaIndiceDeMaterial(Material m) {
		int indice = -1;
		for ( int i = 0; i < this.qtde; i++)
			if (this.listaDeMateriais[i].getCodigo().equals(m.getCodigo())){
				indice = i;
				break;
			}	
		return indice;
	}
}
