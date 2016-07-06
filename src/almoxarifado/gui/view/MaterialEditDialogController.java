package almoxarifado.gui.view;

import almoxarifado.sistema.material.beans.Material;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class MaterialEditDialogController {

	private Stage dialogStage;
	private Material material;
	private boolean confirmarClicado = false;
	
	
	@FXML 
	private TextField textFieldNomeBasico;
	@FXML 
	private TextField textFieldQuantidade;
	@FXML 
	private Label codigoLabel;
	
	@FXML
	private void initialize() 
	{
		
	}
	
	public void setDialogStage (Stage dialogStage)
	{
		this.dialogStage = dialogStage;
	}
	
	public void setMaterial(Material m)
	{
		this.material = m;
		this.codigoLabel.setText(m.getCodigo());
		this.textFieldNomeBasico.setText(m.getNomeBasico());
		this.textFieldQuantidade.setText(Integer.toString(m.getQtde()));
	}
	
	public boolean confirmarClicado()
	{
		return this.confirmarClicado;
	}
	
	@FXML 
	private void handleConfirmar() 
	{
		if (isMaterialValido()){
			this.material.setNomeBasico(this.textFieldNomeBasico.getText());
			this.material.setQtde(Integer.parseInt(this.textFieldQuantidade.getText()));
			this.confirmarClicado = true;
			this.dialogStage.close();
		}
	}

	@FXML public void cancelar() 
	{
		this.dialogStage.close();
	}
	
	private boolean isMaterialValido(){
		String errorMsg = "";
		
		if (this.textFieldNomeBasico.getText() == null || this.textFieldNomeBasico.getText().length() == 0){
			errorMsg += "Nome inválido!\n";
		}
		if (this.textFieldQuantidade.getText() == null || this.textFieldQuantidade.getText().length() == 0){
			errorMsg += "Quantidade inválida\n";
		}
		
		try {
			if (Integer.parseInt(this.textFieldQuantidade.getText()) < 0){
				errorMsg += "Quantidade inválida!\n";
			}
			
		} catch (NumberFormatException nfe){
			errorMsg += "Quantidade precisa ser um número válido!\n";
		}
		
		if (errorMsg.length() == 0){
			return true;
		} else {
			// Msg de erro em um alerta
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(this.dialogStage);
			alert.setTitle("Campos inválidos");
			alert.setHeaderText("Por favor, corrija os valores informados.");
			alert.setContentText(errorMsg);
			
			alert.showAndWait();
			
			return false;
		}
	}
}
