package almoxarifado.fachada;

import java.util.Scanner;
import almoxarifado.material.beans.Material;
import almoxarifado.material.negocio.ControladorDeCadastro;

public class FachadaDeMaterial {
	
	private static int opcao;
	private static Material mat = null;
		
	public static void selecaoDeMenu(Scanner input, ControladorDeCadastro controlCadastro)
	{
		do{
			FachadaDeMaterial.menu();
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao){
			case 0:
				System.out.println("<<< Encerrando programa! >>>"); break;
			case 1:
				FachadaDeMaterial.inserir( controlCadastro, input); break;
			case 2:
				FachadaDeMaterial.buscar(mat, controlCadastro, input); break;
			case 3:
				FachadaDeMaterial.remover(controlCadastro, input); break;
			case 4:
				FachadaDeMaterial.alterar(controlCadastro, input); break;
			case 5:
				controlCadastro.listar(); break;
			default:
					System.out.println(">>> [Opcao invalida!] <<<\n");
			}
		}while (opcao != 0);
	}
	
	
	public static void menu()
	{
		System.out.println("\n=============================");
		System.out.println(" al-Shariff Menu Material    ");
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
	
	public static void inserir(ControladorDeCadastro controlador, Scanner input)
	{
		System.out.println("\n--- Inserir material ---");
		System.out.print("\nCodigo: " + controlador.getCodAutomatico());
		System.out.print("\nNome básico: ");
		String nome = input.nextLine();
		System.out.print("\nData de Aquisicao: ");
		String data = input.nextLine();
		System.out.println("\nQuantidade: ");
		int qtde = input.nextInt();
		input.nextLine();
		Material aInserir = new Material(nome, null, qtde, null, data, null);
		if ( controlador.inserirMaterial(aInserir))
			System.out.println("\n<<< operação feita com sucesso! >>>");
		else{
			System.out.println("\n>>> ERRO! <<<");
			System.out.println("\n>>> falha na operação <<<");
		} 
	}
	
	public static void buscar(Material mat, ControladorDeCadastro controlador, Scanner input) 
	{
		System.out.println("\n--- Buscar material ---");
		System.out.print("\nCodigo: ");
		String cod = input.nextLine();
		System.out.println("\n Resultado de busca: ");
		if ((mat = controlador.buscaCodMaterial(cod)) != null){
			System.out.println(mat.toString());
		}
		else System.out.println("material não localizado");
	}
	
	public static void remover(ControladorDeCadastro controlador, Scanner input){
		System.out.println("\n--- Remover Material ---");
		System.out.print("\nCodigo: ");
		String cod = input.nextLine();
		if (controlador.removerMaterial(cod))
			System.out.println("\n<<< operação feita com sucesso! >>>");
		else System.out.println("livro não localizado");
	}
	
	public static void alterar(ControladorDeCadastro controlador, Scanner input){
		System.out.println("\n--- Alterar Material ---");
		System.out.print("\nCodigo: ");
		String cod = input.nextLine();
		Material mat = controlador.buscaCodMaterial(cod);
		if (mat != null){
			System.out.println("Material a ser alterado: ");
			System.out.println(mat.toString());
			System.out.print("\nNovo nome basico: ");
			mat.setNomeBasico(input.nextLine());
			System.out.print("\nNovo data de aquisicao: ");
			mat.setDataDeAquisicao(input.nextLine());
			System.out.println("\nNova quantidade: ");
			mat.setQtde(input.nextInt());
			input.nextLine();
			if(controlador.atualizarMaterial(mat))
				System.out.println("\n<<< operação feita com sucesso! >>>");
			else{
				System.out.println("\n>>> ERRO! <<<");
				System.out.println("\n>>> falha na operação <<<");
			}
		}
		else System.out.println("material não localizado");
	}

}
