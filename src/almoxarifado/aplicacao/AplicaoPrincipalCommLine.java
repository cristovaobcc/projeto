package almoxarifado.aplicacao;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import almoxarifado.fachada.FachadaDeMaterial;
import almoxarifado.fachada.FachadaUsuarioGestor;
import almoxarifado.material.beans.Especificacao;
import almoxarifado.material.beans.Material;
import almoxarifado.material.repositorio.IRepositorioMateriais;
import almoxarifado.material.repositorio.RepMateriaisArray;
import almoxarifado.material.repositorio.RepositorioMateriais;
import almoxarifado.usuario.beans.NivelDeAcesso;
import almoxarifado.usuario.beans.UsuarioOficial;

public class AplicaoPrincipalCommLine {
	private static Scanner input;
	private static int opcao;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
	}
	
	public static void testaCadastroComFachada()
	{
		UsuarioOficial uGerente = new UsuarioOficial("IdTeste", "NomeUsuario", 
				"<Senha>", "<Lotacao>", NivelDeAcesso.GESTOR);
		IRepositorioMateriais rep = RepMateriaisArray.getInstance();
		FachadaUsuarioGestor fachada = FachadaUsuarioGestor.getInstance(uGerente, rep);
		selecaoDeMenu(input, fachada);
	}
	
	public static void selecaoDeMenu(Scanner input, FachadaUsuarioGestor fachada)
	{
		do{
			menuMaterial();
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao){
			case 0:
				System.out.println("<<< Encerrando programa! >>>"); break;
			case 1:
				inserir(fachada, input); break;
			case 2:
				buscar(fachada, input); break;
			case 3:
				remover(fachada, input); break;
			case 4:
				alterar(fachada, input); break;
			case 5:
				fachada.listarMaterial(); break;
			default:
					System.out.println(">>> [Opcao invalida!] <<<\n");
			}
		}while (opcao != 0);
	}
	
	private static void menuMaterial()
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
		System.out.println("[0] - Sair do menu");
		System.out.println("\n=============================");
		System.out.println("@ll rights reserved");
		System.out.println("---");
		System.out.println("\nOpcao: ");
	}
	
	private static void inserir(FachadaUsuarioGestor fachada, Scanner input)
	{
		System.out.println("\n--- Inserir material ---");
		System.out.print("\nCodigo: " + fachada.getCodigoAutomatico());
		System.out.print("\nNome básico: ");
		String nome = input.nextLine();
		System.out.print("\nData de Aquisicao: ");
		String data = input.nextLine();
		System.out.println("\nQuantidade: ");
		int qtde = input.nextInt();
		input.nextLine();
		System.out.println("\nAcrescentar especificação? [1] Sim [2] Não");
		int esp = input.nextInt();
		input.nextLine();
		Especificacao e = addEspecificacao(esp);
		Material aInserir = new Material(nome, null, qtde, e, data, null);
		if ( fachada.inserirMaterial(aInserir, fachada.getUser() ) )
			System.out.println("\n<<< operação feita com sucesso! >>>");
		else{
			System.out.println("\n>>> ERRO! <<<");
			System.out.println("\n>>> falha na operação <<<");
		} 
	}
	
	private static Especificacao addEspecificacao(int esp)
	{
		Especificacao e = null;
		if (esp == 1){
			System.out.println("\n--- Acrescentando Especificacao ---");
			System.out.println("\nNome modificador: ");
			String nome = input.nextLine();
			System.out.println("\nMarca:");
			String marca = input.nextLine();
			System.out.println("\nUnidade de Medida:");
			String unid = input.nextLine();
			System.out.println("\nCaracteristicas Fisicas:");
			String caract = input.nextLine();
			System.out.println("\nObservações:");
			String obs = input.nextLine();
			e = new Especificacao(nome, caract, obs, marca, unid);
			
		}
		return e;
	}

	public static void buscar(FachadaUsuarioGestor fachada, Scanner input) 
	{
		System.out.println("\n--- Buscar material ---");
		System.out.println("\nSelecione o criterio:");
		System.out.println("[1] Codigo [2] Nome Basico [3] Nome Modificador [9] Encerrar buscar");
		int criterio = input.nextInt();
		input.nextLine();
		executaBusca(criterio,fachada);
	}
	
	private static void executaBusca(int criterio, FachadaUsuarioGestor f)
	{
		Material m = null;
		String entrada = null;
		switch(criterio){
		case 1: 
			System.out.println("Codigo: ");
			entrada = input.nextLine();
			m = f.buscarMaterial (new Material(null, entrada, 0, null, null, null));
			break;
		case 2:
			System.out.println("Nome Basico: ");
			entrada = input.nextLine();
			m = f.buscarMaterial (new Material(entrada, null, 0, null, null, null));
			break;
		case 3:
			System.out.println("Nome Modificador: ");
			entrada = input.nextLine();
			m = f.buscarMaterial (new Material(null, null, 0, 
					new Especificacao(entrada, null, null, null, null), null, null));
			break;
		case 9:
			break;
		default: 
			System.out.println("Opcao invalida!");
		}
		if (criterio >= 1 && criterio <= 3){
			System.out.println("\n Resultado de busca: ");
			if (m != null){
				System.out.println(m.toString());
			}
			else System.out.println(">>> material não localizado <<<");
		}
	}
	
	private static void remover(FachadaUsuarioGestor fachada, Scanner input)
	{
		System.out.println("\n--- Remover Material ---");
		System.out.println("\n[1] Remover \n[2] Buscar material \n[3] Sair do submenu");
		int selecao = input.nextInt();
		input.nextLine();
		executaRemocao(selecao, fachada);
		
	}
	
	// TODO: Continuar daqui a implementação desse método
	private static void executaRemocao(int selecao, FachadaUsuarioGestor f)
	{
		
		Material m = null;
		String entrada = null;
		switch(selecao){
		case 1: 
			System.out.println("Codigo: ");
			entrada = input.nextLine();
			m = f.buscarMaterial (new Material(null, entrada, 0, null, null, null));
			if(m != null)
			break;
		case 2:
			buscar(f, input);
		case 3:
			break;
		default: 
			System.out.println("Opcao invalida!");
		}
		if (selecao >= 1 && selecao <= 2){
			
			if (m != null){
				;
			}
			else System.out.println(">>> material não localizado <<<");
		}
	}
	
	
}
