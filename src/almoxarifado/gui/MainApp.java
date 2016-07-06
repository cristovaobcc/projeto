package almoxarifado.gui;

import java.io.IOException;

import almoxarifado.gui.view.MaterialEditDialogController;
import almoxarifado.gui.view.MaterialPaneController;
import almoxarifado.sistema.fachada.FachadaUsuarioGestor;
import almoxarifado.sistema.material.beans.Material;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Sample's Sample of Al-Shariff App");

		initRootLayout();
		carregarMaterialPane();
	}

	
	/**
	 * Inicializa o root layout (layout base).
	 */
	public void initRootLayout() {
		try {
			// Carrega o root layout do arquivo fxml.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			this.rootLayout = (BorderPane) loader.load();

			// Mostra a scene (cena) contendo o nó rootlayout.
			Scene scene = new Scene(rootLayout);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mostra o MaterialPane dentro do root layout.
	 */
	public void carregarMaterialPane() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MaterialPane.fxml"));
			AnchorPane materialPane = (AnchorPane) loader.load();

			this.rootLayout.setCenter(materialPane);

			MaterialPaneController materialPaneController = loader.getController();
			materialPaneController.setMainApp(this);

			ObservableList<Material> dados = FXCollections.observableArrayList();
			FachadaUsuarioGestor.getInstance().listarTodos().stream().forEach(c -> dados.add(c));
			materialPaneController.setDados(dados);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna o palco principal.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}


	public boolean abrirMaterialEditDialog(Material materialSelecionado) {
		try{
			
			// carrega conteúdo da caixa de diálogo
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MaterialEditDialog.fxml"));
			BorderPane conteudoDialog = (BorderPane) loader.load();
			
			// Cria o palco de diálogo
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Alterar material");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(this.primaryStage);
			Scene scene = new Scene(conteudoDialog);
			dialogStage.setScene(scene);
			
			// configura o material no controlador.
			MaterialEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMaterial(materialSelecionado);
			
			dialogStage.showAndWait();
			
			return controller.confirmarClicado();
		} catch (IOException e){
			e.printStackTrace();
			return false;
		}
	}
}
