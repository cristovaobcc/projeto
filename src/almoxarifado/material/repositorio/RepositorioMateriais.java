package almoxarifado.material.repositorio;
import java.util.Scanner;
import almoxarifado.material.beans.Material;

public class RepositorioMateriais {
	
	private static final int TAMANHO = 100;
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
	
	public boolean inserir(Material m)
	{
		boolean inserido = false;
		if( m != null && this.qtde != 100 &&
				!this.verificaMaterial(m) ){
			this.materiais[this.qtde++] = m;
			inserido = true;
		}
		return inserido;
	}
	
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
	 
	public boolean alterarMaterial(Material m)
	{
		boolean alterado = false;
		if (m != null && this.verificaMaterial(m) ){
			this.materiais [this.verificaIndiceDeMaterial(m.getCodigo() ) ] = m;
			alterado = true;
		}
		return alterado;
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
	
	/**
	 * Verifica se o material "mat" já está cadastrado  no repositório,
	 * de acordo com código do mesmo material.
	 * Devolve true se estive, e false caso contrário.
	 * @param m
	 * @return
	 */
	
	private boolean verificaMaterial(Material m)
	{
		boolean busca = false;
		for ( int i = 0; i < this.qtde; i++)
			if (this.materiais[i].getCodigo() == m.getCodigo())
				busca = true;
		return busca;
	}
	
	private int verificaIndiceDeMaterial(String cod) {
		int indice = -1;
		for ( int i = 0; i < this.qtde; i++)
			if (this.materiais[i].getCodigo().equals(cod)){
				indice = i;
				break;
			}	
		return indice;
	}
	
/// CÓDIGO PARA TESTAR REPOSITÓRIO
	
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner (System.in);
		int opcao = 0;
		RepositorioMateriais repositorio =  new RepositorioMateriais();
		Material mat = null;
		
		do{
			menu();
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao){
			case 0:
				System.out.println("<<< Encerrando programa! >>>"); break;
			case 1:
				inserir( repositorio, input); break;
			case 2:
				buscar(mat, repositorio, input); break;
			case 3:
				remover(repositorio, input); break;
			case 4:
				alterar(mat, repositorio, input); break;
			case 5:
				repositorio.listar(); break;
			default:
					System.out.println(">>> [Opcao invalida!] <<<\n");
			}
		}while (opcao != 0);
	}

	public static void menu()
	{
		System.out.println("\n=============================");
		System.out.println(" al-Shariff Repository's test");
		System.out.println("=============================");
		System.out.println("\nSelecione a opcao desejada:");
		System.out.println("[1] - Inserir material");
		System.out.println("[2] - Buscar material");
		System.out.println("[3] - Remover material");
		System.out.println("[4] - Alterar material");
		System.out.println("[5] - Listar material");
		System.out.println("[0] - Encerrar programa");
		System.out.println("\n=============================");
		System.out.println("@ll rights reserved");
		System.out.println("---");
		System.out.println("\nOpcao: ");
	}
	
	public static void inserir(RepositorioMateriais rep, Scanner input)
	{
		System.out.println("\n--- Inserir material ---");
		System.out.print("\nCodigo: ");
		String cod = input.next();
		input.nextLine();
		System.out.print("\nNome básico: ");
		String nome = input.nextLine();
		System.out.print("\nData de Aquisicao: ");
		String data = input.nextLine();
		System.out.println("\nQuantidade: ");
		int qtde = input.nextInt();
		input.nextLine();
		if (rep.inserir(new Material(nome, cod, qtde, null, data)))
			System.out.println("\n<<< operação feita com sucesso! >>>");
		else{
			System.out.println("\n>>> ERRO! <<<");
			System.out.println("\n>>> falha na operação <<<");
		}
	}
	
	public static void buscar(Material mat, RepositorioMateriais rep, Scanner input) {

		System.out.println("\n--- Buscar material ---");
		System.out.print("\nCodigo: ");
		String cod = input.nextLine();
		System.out.println("\n Resultado de busca: ");
		if ((mat = rep.buscar(cod)) != null){
			System.out.println(mat.toString());
		}
		else System.out.println("material não localizado");
	}
	
	public static void remover(RepositorioMateriais rep, Scanner input){
		System.out.println("\n--- Remover Material ---");
		System.out.print("\nCodigo: ");
		String cod = input.nextLine();
		if (rep.remover(cod))
			System.out.println("\n<<< operação feita com sucesso! >>>");
		else System.out.println("livro não localizado");
	}
	
	public static void alterar(Material mat, RepositorioMateriais rep, Scanner input){
		System.out.println("\n--- Alterar Material ---");
		System.out.print("\nCodigo: ");
		String cod = input.nextLine();
		if ((mat = rep.buscar(cod)) != null){
			System.out.println("Material a ser alterado: ");
			System.out.println(mat.toString());
			System.out.print("\nNovo nome basico: ");
			mat.setNomeBasico(input.nextLine());
			System.out.print("\nNovo data de aquisicao: ");
			mat.setDataDeAquisicao(input.nextLine());
			System.out.println("\nNova quantidade: ");
			mat.setQtde(input.nextInt());
			input.nextLine();
			if(rep.alterarMaterial(mat))
				System.out.println("\n<<< operação feita com sucesso! >>>");
			else{
				System.out.println("\n>>> ERRO! <<<");
				System.out.println("\n>>> falha na operação <<<");
			}
		}
		else System.out.println("material não localizado");
	}
	
}
