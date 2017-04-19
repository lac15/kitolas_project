package hu.unideb.inf.prt.kitolas;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
* A kitolás nevű kétszemélyes táblajáték megvalósítása.
* A projekt programozási technológiák órára készül.
*
* @author  Erdőhegyi László
* @since   2016-05-13
*/
public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane kitolasView;
	
	/**
	 * Felülírja az Application osztály start metódusát.
	 * Betölti a grafikus felületet.
	 * @param primaryStage Az a stage melyre az FXML elemek kerülnek.
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Kitolas");
		
		createKitolasView();
	}
	
	/**
	 * A program indításáért felel.
	 * @param args Parancssori argumentumok tombje.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Betölti a view-t és hozzáadja a primaryStage-hez.
	 */
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
	
}
