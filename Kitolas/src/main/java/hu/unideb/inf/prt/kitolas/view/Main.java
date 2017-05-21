package hu.unideb.inf.prt.kitolas.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
* A kitolás nevű kétszemélyes táblajáték felületének megjelenítéséért felelős osztály.
*
* @author  Erdőhegyi László
* @since   2016-05-13
*/
public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane kitolasView;
	
	/**
	 * Betölti a grafikus felületet.
	 * 
	 * Felülírja az {@link javafx.application.Application#start(Stage)} metódust.
	 * 
	 * @param ps az a stage melyre az FXML elemek kerülnek
	 */
	@Override
	public void start(Stage ps) {
		this.primaryStage = ps;
		this.primaryStage.setTitle("Kitolas");
		
		createKitolasView();
	}
	
	/**
	 * A program indításáért felel.
	 * 
	 * @param args a parancssori argumentumok tömbje
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Betölti a View-t és hozzáadja a primaryStage-hez.
	 */
	private void createKitolasView() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/KitolasView.fxml"));
		try {
			kitolasView = (BorderPane) loader.load();
			Scene scene = new Scene(kitolasView);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
