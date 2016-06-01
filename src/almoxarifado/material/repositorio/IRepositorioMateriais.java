package almoxarifado.material.repositorio;
import almoxarifado.material.beans.Material;

public interface IRepositorioMateriais{
	// Dúvida: como fica a implementação do padrão singleton
	//  com o uso de interface?
	// pelo o que percebi até então, continua da mesma forma.
	// Devo manter o método  linha abaixo?
	// public IRepositorioMateriais getInstance();

	// métodos CRUD
	/**
	 * Deve inserir um Material m e devolver true se
	 * foi inserido, false caso contrario (o material já
	 * existe no repositorio). 
	 * @param m
	 * @return
	 */
	public boolean inserirMaterial(Material m);
	
	/**
	 * Deve buscar um Material m e devolver o Material buscado
	 * se for encontrado, caso contrario, devolve null.
	 * @param m
	 * @return
	 */
	public Material buscarMaterial(Material m);
	
	/**
	 * Deve alterar um Material m que existe no
	 * repositorio, devolve true se foi alterado
	 * e false caso contrario.
	 * @param m
	 * @return
	 */
	public boolean alterarMaterial(Material m);
	
	/**
	 * Deve remover um Material m que existe no
	 * Repositorio, devolve true se foi removido,
	 * false caso contrario.
	 * @param m
	 * @return
	 */
	public boolean removerMaterial(Material m);
	
	/**
	 * Deve listar todos os materiais cadastrados no
	 * repositório.
	 */
	public void listar();
}
