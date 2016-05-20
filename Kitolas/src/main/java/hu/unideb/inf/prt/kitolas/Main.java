package hu.unideb.inf.prt.kitolas;

import java.io.IOException;

import hu.unideb.inf.prt.kitolas.controller.KitolasController;
import hu.unideb.inf.prt.kitolas.model.KitolasData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private KitolasData kitolData;
	
	private Stage primaryStage;
	private BorderPane rootPane;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Kitolas");
		
		createRootPane();
		createKitolasView();
	}

	public Main(){
		kitolData = new KitolasData ("0", "0", "0", "0", "0/36", "0");
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void createRootPane(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/hu/unideb/inf/prt/kitolas/view/RootPaneView.fxml"));
		try {
			rootPane = (BorderPane)loader.load();
			
			Scene scene = new Scene(rootPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void createKitolasView(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/hu/unideb/inf/prt/kitolas/view/KitolasView.fxml"));
		try {
			AnchorPane kitolasView = (AnchorPane)loader.load();
			rootPane.setCenter(kitolasView);
			
			KitolasController controller = loader.getController();
			controller.setMain(this);
			
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
