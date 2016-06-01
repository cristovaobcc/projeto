package almoxarifado.material.repositorio;
import java.util.ArrayList;
import almoxarifado.material.beans.Material;
/**
 * Classe que trabalha com materiais organizados em 
 * um array. Implementa interface IRepositorioMaterais.
 * @author cristovao
 *
 */
public class RepMateriaisArray implements IRepositorioMateriais{
	
	private static RepMateriaisArray instance;
	private ArrayList<Material> materiais;

	
	private RepMateriaisArray()
	{
		this.materiais = new ArrayList<Material>();
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
		return this.materiais.size();
	}
	
	/**
	 * Devolve um Material da i-esima posicao do array.
	 * @param i
	 * @return
	 */
	public Material getMaterial(int i)
	{
		return this.materiais.get(i);
	}
	
	public boolean inserirMaterial(Material m)
	{
		boolean resultado = false;
		this.materiais.add(m);
		return resultado;
	}
	
	public Material buscarMaterial(Material m)
	{
		Material mat = null;
		for (Material b : this.materiais)
			if (b.getCodigo ().equals (m.getCodigo() ) )
				mat = b;
		return mat;
	}
	
	public ArrayList<Material> buscarMateriais(Material m)
	{
		ArrayList<Material> busca = new ArrayList<Material>();
		if (m.getCodigo() != null){
			for(Material mat: this.materiais){
				if (mat.getCodigo().equals(m.getCodigo() ) ){
					busca.add(mat); break;
				}
			}	
		} 
		if (m.getNomeBasico() != null){
			for(Material mat: this.materiais){
				if(mat.getNomeBasico().contains(m.getNomeBasico() ) ){
					busca.add(mat);
				}
			}
		}
		if (m.getEsp() != null && m.getEsp().getNomeModificador() != null){
			for(Material mat: this.materiais){
				if(m.getEsp().getNomeModificador().
						contains(m.getEsp().getNomeModificador())){
					busca.add(mat);
				}
			}
		}
		return busca;
	}
	
	public boolean removerMaterial(Material m)
	{
		boolean resultado = false;
		if (this.indiceDeMaterial(m) < materiais.size()){
			materiais.remove(this.indiceDeMaterial(m) );
			resultado = true;
		}
		return resultado;
	}
	
	public boolean alterarMaterial(Material m)
	{
		boolean resultado = false;
		if (this.indiceDeMaterial(m) < materiais.size()){
			materiais.set(this.indiceDeMaterial(m),m);
			resultado = true;
		}
		return resultado;
	}
	
	public void listar()
	{
		for(Material m: this.materiais)
			System.out.println(m.toString());
	}
	
	/**
	 * Devolve o índice do material m no campo materiais
	 * com base no código do mesmo material.
	 * Caso o material não seja localizado devolve
	 * o tamanho do campo materiais.
	 * @param m Material
	 * @return int
	 */
	//TODO: inserir algoritmo de busca no lugar do for aqui.
	private int indiceDeMaterial(Material m) {
		int i;
		for ( i = 0; i < this.materiais.size(); i++){
			if (this.materiais.get(i).getCodigo().equals(m.getCodigo())){
				break;
			}
		}
		return i;
	}
	
}

