package hu.unideb.inf.prt.kitolas.view;

import hu.unideb.inf.prt.kitolas.model.KitolasData;

import java.util.Optional;

import hu.unideb.inf.prt.kitolas.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class KitolasController {
	
	Main main;
	
	/*@FXML
	private TableView<KitolasData> kitolasTable;*/
	
	private int lepes = 0;
	private int korSzam = 1;
	
	@FXML
	private Label tablanBLabel;

	@FXML
	private Label levettBLabel;

	@FXML
	private Label tablanWLabel;
	
	@FXML
	private Label levettWLabel;
	
	@FXML
	private Label korLabel;
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
		showKitolasData(main.getKitolData());
	}
	
	/*@FXML
	private void initialize() {
		showKitolasData(null);
	}*/
	
	private void showKitolasData(KitolasData kitolasData) {
		if (kitolasData == null) {
			tablanBLabel.setText("");
			levettBLabel.setText("");
			tablanWLabel.setText("");
			levettWLabel.setText("");
			korLabel.setText("");
		} else {
			tablanBLabel.setText(kitolasData.getTablanB());
			levettBLabel.setText(kitolasData.getLevettB());
			tablanWLabel.setText(kitolasData.getTablanW());
			levettWLabel.setText(kitolasData.getLevettW());
			korLabel.setText(kitolasData.getKorSzam());
		}
	}
	
	@FXML
	private void startKitolasGame(){
		
	}
	
	@FXML
	private void incKor(){
		korLabel.setText(++korSzam + "/36");
	}
	
	@FXML
	private void incLevettBClick(){
		int sz = Integer.parseInt(main.getKitolData().getLevettB()) + 1;
		main.getKitolData().setLevettB(sz + "");
		
		levettBLabel.setText(main.getKitolData().getLevettB());
		
		lepes++;
		if(lepes % 2 == 0){
			incKor();
		}
		
		popupWinner();
	}
	
	@FXML
	private void incLevettWClick(){
		int sz = Integer.parseInt(main.getKitolData().getLevettW()) + 1;
		main.getKitolData().setLevettW(sz + "");
		
		levettWLabel.setText(main.getKitolData().getLevettW());
		
		lepes++;
		if(lepes % 2 == 0){
			incKor();
		}
		
		popupWinner();
	}
	
	private void popupWinner(){
		if(main.getKitolData().getLevettB().equals("6")){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Győztes");
			alert.setHeaderText("Fekete nyert!");
			alert.setContentText("Új játék?");
		
			ButtonType buttonTypeOne = new ButtonType("One");
			ButtonType buttonTypeTwo = new ButtonType("Two");
			ButtonType buttonTypeThree = new ButtonType("Three");
			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		
			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);
		
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne){
			    // ... user chose "One"
			} else if (result.get() == buttonTypeTwo) {
			    // ... user chose "Two"
			} else if (result.get() == buttonTypeThree) {
			    // ... user chose "Three"
			} else {
			    // ... user chose CANCEL or closed the dialog
			}
		} else if(main.getKitolData().getLevettW().equals("6")){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Győztes");
			alert.setHeaderText("Feher nyert!");
			alert.setContentText("Új játék?");
		
			ButtonType buttonTypeOne = new ButtonType("One");
			ButtonType buttonTypeTwo = new ButtonType("Two");
			ButtonType buttonTypeThree = new ButtonType("Three");
			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		
			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);
		
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne){
			    // ... user chose "One"
			} else if (result.get() == buttonTypeTwo) {
			    // ... user chose "Two"
			} else if (result.get() == buttonTypeThree) {
			    // ... user chose "Three"
			} else {
			    // ... user chose CANCEL or closed the dialog
			}
		}
	}
	
	@FXML
	private void exitKitolas(){
		System.exit(0);
	}
	
}
