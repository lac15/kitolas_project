package hu.unideb.inf.prt.kitolas;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * A kitolás nevű kétszemélyes táblajáték megvalósítása. A projekt programozási
 * technológiák órára készül.
 *
 * @author Erdőhegyi László
 * @since 2016-05-13
 */
public class Main extends Application {
    /**
     * Ez egy Stage.
     */
    private Stage primaryStage;
    /**
     * Ez egy BorderPane.
     */
    private BorderPane kitolasView;

    /**
     * Betölti a grafikus felületet. Felülírja az Application osztály start
     * metódusát.
     *
     * @param ps
     *            Az a stage melyre az FXML elemek kerülnek.
     */
    public final void start(final Stage ps) {
        this.primaryStage = ps;
        this.primaryStage.setTitle("Kitolas");

        createKitolasView();
    }

    /**
     * A program indításáért felel.
     *
     * @param args
     *            Parancssori argumentumok tömbje.
     */
    public static void main(final String[] args) {
        launch(args);
    }

    /**
     * Betölti a view-t és hozzáadja a primaryStage-hez.
     */
    private void createKitolasView() {
        String path = "/hu/unideb/inf/prt/kitolas/view/";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(path + "KitolasView.fxml"));
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
