/*
 * Este foi meu primeiro main para testar o repositório antes da implementação de regras
 * de negócios do ramo material. 
 */

package projetoIP2;/*
import java.util.Scanner;
import almoxarifado.material.beans.Material;
import almoxarifado.material.repositorio.RepositorioMateriais;
*/
public class Rascunho01 {
	/* DESCOMENTE COM 2 BARRAS NO INICIO DESTA LINHA E...
	/// CÓDIGO PARA TESTAR REPOSITÓRIO
	
		private static Scanner input;

		public static void main(String[] args) {
			input = new Scanner (System.in);
			int opcao = 0;
			RepositorioMateriais repositorio =  RepositorioMateriais.getInstance();
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
			if (rep.inserir(new Material(nome, cod, qtde, null, data, null)))
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
		
		//...E COM 2 BARRAS NO COMEÇO DESTA*/
}
