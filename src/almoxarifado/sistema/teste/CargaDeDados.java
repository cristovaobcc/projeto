package almoxarifado.sistema.teste;

import java.time.LocalDate;

import almoxarifado.sistema.fachada.FachadaUsuarioGestor;
import almoxarifado.sistema.material.beans.Especificacao;
import almoxarifado.sistema.material.beans.Material;
import almoxarifado.sistema.material.excecoes.MaterialCodigoInvalidoException;
import almoxarifado.sistema.material.excecoes.MaterialNomeInvalidoException;
import almoxarifado.sistema.material.excecoes.MaterialNuloException;
import almoxarifado.sistema.usuario.beans.NivelDeAcesso;
import almoxarifado.sistema.usuario.beans.UsuarioOficial;

public class CargaDeDados {

	public static void main(String[] args) {
		// cadastro de materiais

		Material materiais[] = {
				new Material("Lapis", "0000", 10, 
						new Especificacao("Lapis cera", "não se aplica", "", "Pentel", "unidade"),
						LocalDate.now(), "123"),
				new Material("Caneta esferográfica", "0000", 15, 
						new Especificacao("Caneta Bic", "caneta transparente azul", "", "Bic", "unidade"),
						LocalDate.now(), "123"),
				new Material("Caneta esferográfica", "0000", 15, 
						new Especificacao("Caneta Bic", "caneta transparente vermelha", "", "Bic", "unidade"),
						LocalDate.now(), "123"),
				new Material("Marcador quadro branco", "0000", 20, 
						new Especificacao("Marcador quadro branco", "marcador para quadro branco vermelho", "", "Pappermate", "unidade"),
						LocalDate.now(), "123"),
				new Material("Cartucho impressora", "0000", 10, 
						new Especificacao("Cartucho impressora HP-230C", "cartucho impressora preto", "", "HP", "unidade"),
						LocalDate.now(), "123"),
		};
		
		UsuarioOficial tester = new UsuarioOficial("777", "Meg Maggie", "123", "", NivelDeAcesso.GESTOR);
		FachadaUsuarioGestor fachada = FachadaUsuarioGestor.getInstance();

		for (int i = 0; i < materiais.length; i++) {
			try {
				fachada.inserirMaterial(materiais[i], tester);
			} catch (MaterialCodigoInvalidoException | MaterialNomeInvalidoException | MaterialNuloException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		System.out.println("Arquivei!");
	}
}