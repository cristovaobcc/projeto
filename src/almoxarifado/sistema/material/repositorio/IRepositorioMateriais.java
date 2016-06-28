package almoxarifado.sistema.material.repositorio;
import java.util.ArrayList;
import almoxarifado.sistema.material.beans.Material;

public interface IRepositorioMateriais {
	// D�vida: como fica a implementa��o do padr�o singleton
	//  com o uso de interface?
	// pelo o que percebi at� ent�o, continua da mesma forma.
	// Devo manter o m�todo  linha abaixo?
	// public IRepositorioMateriais getInstance();

	// m�todos CRUD
	/**
	 * Deve inserir um Material m
	 * @param m Material
	 * 
	 */
	public void inserirMaterial(Material m);
	
	/**
	 * Deve buscar um Material m com algum dos campos abaixo preenchidos:
	 * 	1) C�digo
	 *  2) Nome B�sico
	 *  3) Nome Modificador
	 * e devolver um ArrayList<Material>  
	 * contendo o(s) material(is) buscados.
	 * O tamanho do ArrayList deve ser conferido para saber
	 * se foi encontrado algum material segundo os campos preenchidos.
	 * @param m material a ser buscado
	 * @return ArrayList<Material>
	 */
	public ArrayList<Material> buscarMateriais(Material m);
	
	/**
	 * Deve encontrar um Material que existe no
	 * Repositorio igual ao c�digo do Material m
	 * passado.
	 * Devolve o material encontrado.
	 * Se n�o for encontrado devolve null.
	 * @param m
	 * @return
	 */
	public Material buscarMaterial(Material m);
	
	/**
	 * Deve alterar um Material que existe no
	 * Repositorio igual ao c�digo do Material m
	 * passado.
	 * @param m Material
	 */
	public void alterarMaterial(Material m);
	
	/**
	 * Deve remover um Material m que existe no
	 * Repositorio baseado no c�digo.
	 * @param m Material
	 */
	public void removerMaterial(Material m);
	
	/**
	 * Deve listar todos os materiais cadastrados no
	 * reposit�rio.
	 */
	public void listar();
	
	/**
	 * Deve devolver todos o materiais cadastrados no 
	 * reposit�rio como ArrayList<Material>
	 * @return ArrayList<Material>
	 */
	public ArrayList<Material> listarParaArrayList();
}
