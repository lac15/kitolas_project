package hu.unideb.inf.prt.kitolas.view;

import hu.unideb.inf.prt.kitolas.Main;
import hu.unideb.inf.prt.kitolas.model.KitolasData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class KitolasController {

	Main main;
	
	@FXML
	private TableView<KitolasData> kitolasTable;
	
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
	}
	
}
