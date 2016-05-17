package hu.unideb.inf.prt.kitolas.view;

import hu.unideb.inf.prt.kitolas.model.KitolasData;

import java.util.Optional;
import java.util.Random;

import hu.unideb.inf.prt.kitolas.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class KitolasController {
	
	Main main;
	
	/*@FXML
	private TableView<KitolasData> kitolasTable;*/
	
	private int lepes = 0;
	private int korSzam = 1;
	private int aktLevett = 0;
	
	@FXML
	private Button top1Button;
	
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
	
	private void startKitolasGame(KitolasData kitolasData){
		Random rand = new Random();
		int row;
		int col;
		int feher = 0;
		int fekete = 0;
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				kitolasData.setElem(i, j, 0);
			}
		}
		
		while(feher != 6){
			row = rand.nextInt(6);
			col = rand.nextInt(6);
			
			if(kitolasData.getElem(row, col) == 0){
				kitolasData.setElem(row, col, 1);
				feher++;
			}
		}
			while(fekete != 6){
				row = rand.nextInt(6);
				col = rand.nextInt(6);
				
				if(kitolasData.getElem(row, col) == 0){
					kitolasData.setElem(row, col, 2);
					fekete++;
				}
			}
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				System.out.print(kitolasData.getElem(i, j));
			}
			System.out.println();
		}
	}
	
	@FXML
	private void startGame(){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Új játék");
		alert.setHeaderText("Biztosan új játékot akarsz kezdeni?");
	
		ButtonType buttonTypeIgen = new ButtonType("Igen");
		ButtonType buttonTypeNem = new ButtonType("Nem");
	
		alert.getButtonTypes().setAll(buttonTypeIgen, buttonTypeNem);
	
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeIgen){
			startKitolasGame(main.getKitolData());
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
	}
	
	private void shiftUp(KitolasData kitolasData, int oIndex){
		for(int i = 0; i < 6; i++){
			int aktElem = kitolasData.getElem(i, oIndex);
			if(i == 0){
				aktLevett = aktElem;
			} else {
				kitolasData.setElem(i-1, oIndex, aktElem);
				kitolasData.setElem(i, oIndex, 0);
			}
		}
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				System.out.print(kitolasData.getElem(i, j));
			}
			System.out.println();
		}
		
		System.out.println(aktLevett);
	}
	
	@FXML
	private void shiftUpCol(){
		shiftUp(main.getKitolData(), Integer.parseInt(top1Button.getId()));
	}
	
	@FXML
	private void incKor(){
		korLabel.setText(++korSzam + "/36");
	}
	
	@FXML
	private void incLevettBTopBotClick(){
		int sz = Integer.parseInt(main.getKitolData().getLevettB()) + 1;
		main.getKitolData().setLevettB(sz + "");
		
		levettBLabel.setText(main.getKitolData().getLevettB());
		
		lepes++;
		if(lepes % 2 == 0){
			incKor();
		}
		
		popupWinnerCheck();
	}
	
	@FXML
	private void incLevettWLeftRightClick(){
		int sz = Integer.parseInt(main.getKitolData().getLevettW()) + 1;
		main.getKitolData().setLevettW(sz + "");
		
		levettWLabel.setText(main.getKitolData().getLevettW());
		
		lepes++;
		if(lepes % 2 == 0){
			incKor();
		}
		
		popupWinnerCheck();
	}
	
	private void popupWinner(String gyoztes){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Győztes");
		alert.setHeaderText(gyoztes + " nyert!");
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
	
	private void popupWinnerCheck(){
		if(main.getKitolData().getLevettB().equals("6")){
			popupWinner("Feher");
		} else if(main.getKitolData().getLevettW().equals("6")){
			popupWinner("Fekete");
		}
	}
	
	@FXML
	private void exitKitolas(){
		System.exit(0);
	}
	
}
