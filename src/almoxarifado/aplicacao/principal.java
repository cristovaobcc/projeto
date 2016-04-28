package almoxarifado.aplicacao;
import java.util.Scanner;
import almoxarifado.fachada.FachadaDeMaterial;
import almoxarifado.material.negocio.ControladorDeCadastro;
import almoxarifado.usuario.beans.Usuario;

public class principal {
	
		private static Scanner input;

		public static void main(String[] args) {
			input = new Scanner (System.in);
			Usuario tester = new Usuario("<idUsuario>", "Tester", "<senha>" );
			ControladorDeCadastro controlCadastro = new ControladorDeCadastro(tester);
			FachadaDeMaterial.selecaoDeMenu(input, controlCadastro);
		}
		
}
