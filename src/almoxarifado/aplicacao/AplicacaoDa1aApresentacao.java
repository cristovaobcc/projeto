package almoxarifado.aplicacao;
/*
import java.time.LocalDate;
import java.util.Scanner;

import almoxarifado.fachada.FachadaDeMaterial;
import almoxarifado.material.beans.Material;
import almoxarifado.material.excecoes.MatNEncExc;
import almoxarifado.usuario.beans.Usuario;
*/
public class AplicacaoDa1aApresentacao {
/*
	private static Scanner input;
	private static int opcao;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		Usuario user = new Usuario("<idUsuario>", "Tester", "<senha>");
		FachadaDeMaterial fachada = FachadaDeMaterial.getInstance(user);
		selecaoDeMenu(input, fachada);
	}
	
	public static void selecaoDeMenu(Scanner input, FachadaDeMaterial fachadaDeMaterial)
	{
		do{
			menu();
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao){
			case 0:
				System.out.println("<<< Encerrando programa! >>>"); break;
			case 1:
				inserir(fachadaDeMaterial, input); break;
			case 2:
				buscar(fachadaDeMaterial, input); break;
			case 3:
				remover(fachadaDeMaterial, input); break;
			case 4:
				alterar(fachadaDeMaterial, input); break;
			case 5:
				fachadaDeMaterial.listar(); break;
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
	
	public static void inserir(FachadaDeMaterial fachada, Scanner input)
	{
		System.out.println("\n--- Inserir material ---");
		System.out.print("\nCodigo: " + fachada.getCodAutomatico());
		System.out.print("\nNome básico: ");
		String nome = input.nextLine();
		System.out.print("\nData de Aquisicao: ");
		LocalDate data = input.nextLine();
		System.out.println("\nQuantidade: ");
		int qtde = input.nextInt();
		input.nextLine();
		Material aInserir = new Material(nome, null, qtde, null, data, null);
		if ( fachada.inserirMaterial(aInserir))
			System.out.println("\n<<< operação feita com sucesso! >>>");
		else{
			System.out.println("\n>>> ERRO! <<<");
			System.out.println("\n>>> falha na operação <<<");
		} 
	}
	
	public static void buscar(FachadaDeMaterial fachada, Scanner input) 
	{
		Material mat;
		System.out.println("\n--- Buscar material ---");
		System.out.print("\nCodigo: ");
		String cod = input.nextLine();
		System.out.println("\n Resultado de busca: ");
		if ((mat = fachada.buscaCodMaterial(cod)) != null){
			System.out.println(mat.toString());
		}
		else System.out.println(">>> material não localizado <<<");
	}
	
	public static void remover(FachadaDeMaterial fachada, Scanner input){
		System.out.println("\n--- Remover Material ---");
		System.out.print("\nCodigo: ");
		String cod = input.nextLine();
		try{
			if (fachada.removerMaterial(cod))
				System.out.println("\n<<< operação feita com sucesso! >>>");
		}
		catch (MatNEncExc mne){
			mne.getMessage();
			System.out.println("Código [" + mne.getCodigo() + "] inválido!");
		}
		
	}
	
	public static void alterar(FachadaDeMaterial fachada, Scanner input){
		System.out.println("\n--- Alterar Material ---");
		System.out.print("\nCodigo: ");
		String cod = input.nextLine();
		Material mat = fachada.buscaCodMaterial(cod);
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
			if(fachada.atualizarMaterial(mat))
				System.out.println("\n<<< operação feita com sucesso! >>>");
			else{
				System.out.println("\n>>> ERRO! <<<");
				System.out.println("\n>>> falha na operação <<<");
			}
		}
		else System.out.println(">>> material não localizado <<<");
	}
	
	
*/
}
