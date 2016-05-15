package hu.unideb.inf.prt.kitolas.view;

import hu.unideb.inf.prt.kitolas.model.KitolasData;
import hu.unideb.inf.prt.kitolas.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class KitolasController {
	
	Main main;
	
	/*@FXML
	private TableView<KitolasData> kitolasTable;*/
	
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
	private void exitKitolas(){
		System.exit(0);
	}
	
}
