package hu.unideb.inf.prt.kitolas;

import java.io.IOException;

import hu.unideb.inf.prt.kitolas.model.KitolasData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private KitolasData kitolData;
	
	private Stage primaryStage;
	private BorderPane kitolasView;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Kitolas");
		
		createKitolasView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void createKitolasView(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/hu/unideb/inf/prt/kitolas/view/KitolasView.fxml"));
		try {
			kitolasView = (BorderPane)loader.load();
			Scene scene = new Scene(kitolasView);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			/*KitolasController controller = loader.getController();
			controller.setMain(this);*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public KitolasData getKitolData() {
		return kitolData;
	}

	public void setKitolData(KitolasData kitolData) {
		this.kitolData = kitolData;
	}
	
}
