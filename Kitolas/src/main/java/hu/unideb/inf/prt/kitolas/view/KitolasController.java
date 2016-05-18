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

	/*@FXML private TableView<KitolasData> kitolasTable;*/

	private int lepes = 0;
	private int korSzam = 1;
	private int aktLevett = 0;

	@FXML
	private Button top0Button;
	@FXML
	private Button top1Button;
	@FXML
	private Button top2Button;
	@FXML
	private Button top3Button;
	@FXML
	private Button top4Button;
	@FXML
	private Button top5Button;

	@FXML
	private Button bot0Button;
	@FXML
	private Button bot1Button;
	@FXML
	private Button bot2Button;
	@FXML
	private Button bot3Button;
	@FXML
	private Button bot4Button;
	@FXML
	private Button bot5Button;

	@FXML
	private Button left0Button;
	@FXML
	private Button left1Button;
	@FXML
	private Button left2Button;
	@FXML
	private Button left3Button;
	@FXML
	private Button left4Button;
	@FXML
	private Button left5Button;

	@FXML
	private Button right0Button;
	@FXML
	private Button right1Button;
	@FXML
	private Button right2Button;
	@FXML
	private Button right3Button;
	@FXML
	private Button right4Button;
	@FXML
	private Button right5Button;

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

	/*
	 * @FXML private void initialize() { showKitolasData(null); }
	 */

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

	private void startKitolasGame(KitolasData kitolasData) {
		Random rand = new Random();
		int row = 0;
		int col = 0;
		int feher = 0;
		int fekete = 0;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				kitolasData.setElem(i, j, 0);
			}
		}

		while (feher != 6) {
			row = rand.nextInt(6);
			col = rand.nextInt(6);

			if (kitolasData.getElem(row, col) == 0) {
				kitolasData.setElem(row, col, 1);
				feher++;
			}
		}
		while (fekete != 6) {
			row = rand.nextInt(6);
			col = rand.nextInt(6);

			if (kitolasData.getElem(row, col) == 0) {
				kitolasData.setElem(row, col, 2);
				fekete++;
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(kitolasData.getElem(i, j));
			}
			System.out.println();
		}
	}

	@FXML
	private void startGame() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Új játék");
		alert.setHeaderText("Biztosan új játékot akarsz kezdeni?");

		ButtonType buttonTypeIgen = new ButtonType("Igen");
		ButtonType buttonTypeNem = new ButtonType("Nem");

		alert.getButtonTypes().setAll(buttonTypeIgen, buttonTypeNem);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeIgen) {
			startKitolasGame(main.getKitolData());
		} else {
			// ... user chose CANCEL or closed the dialog
		}
	}

	private void shiftUp(KitolasData kitolasData, int oIndex) {
		for (int i = 0; i < 6; i++) {
			int aktElem = kitolasData.getElem(i, oIndex);
			if (i == 0) {
				aktLevett = aktElem;
			} else {
				kitolasData.setElem(i - 1, oIndex, aktElem);
				kitolasData.setElem(i, oIndex, 0);
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(kitolasData.getElem(i, j));
			}
			System.out.println();
		}

		System.out.println("Levett elem: " + aktLevett);
	}

	private void shiftDown(KitolasData kitolasData, int oIndex) {
		for (int i = 5; i >= 0; i--) {
			int aktElem = kitolasData.getElem(i, oIndex);
			if (i == 5) {
				aktLevett = aktElem;
			} else {
				kitolasData.setElem(i + 1, oIndex, aktElem);
				kitolasData.setElem(i, oIndex, 0);
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(kitolasData.getElem(i, j));
			}
			System.out.println();
		}

		System.out.println("Levett elem: " + aktLevett);
	}

	private void shiftLeft(KitolasData kitolasData, int sIndex) {
		for (int j = 0; j < 6; j++) {
			int aktElem = kitolasData.getElem(sIndex, j);
			if (j == 0) {
				aktLevett = aktElem;
			} else {
				kitolasData.setElem(sIndex, j - 1, aktElem);
				kitolasData.setElem(sIndex, j, 0);
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(kitolasData.getElem(i, j));
			}
			System.out.println();
		}

		System.out.println("Levett elem: " + aktLevett);
	}

	private void shiftRight(KitolasData kitolasData, int sIndex) {
		for (int j = 5; j >= 0; j--) {
			int aktElem = kitolasData.getElem(sIndex, j);
			if (j == 5) {
				aktLevett = aktElem;
			} else {
				kitolasData.setElem(sIndex, j + 1, aktElem);
				kitolasData.setElem(sIndex, j, 0);
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(kitolasData.getElem(i, j));
			}
			System.out.println();
		}

		System.out.println("Levett elem: " + aktLevett);
	}

	@FXML
	private void shiftUpCol0() {
		shiftUp(main.getKitolData(), Integer.parseInt(top0Button.getId()));
	}
	@FXML
	private void shiftUpCol1() {
		shiftUp(main.getKitolData(), Integer.parseInt(top1Button.getId()));
	}
	@FXML
	private void shiftUpCol2() {
		shiftUp(main.getKitolData(), Integer.parseInt(top2Button.getId()));
	}
	@FXML
	private void shiftUpCol3() {
		shiftUp(main.getKitolData(), Integer.parseInt(top3Button.getId()));
	}
	@FXML
	private void shiftUpCol4() {
		shiftUp(main.getKitolData(), Integer.parseInt(top4Button.getId()));
	}
	@FXML
	private void shiftUpCol5() {
		shiftUp(main.getKitolData(), Integer.parseInt(top5Button.getId()));
	}

	@FXML
	private void shiftDownCol0() {
		shiftDown(main.getKitolData(), Integer.parseInt(bot0Button.getId()));
	}
	@FXML
	private void shiftDownCol1() {
		shiftDown(main.getKitolData(), Integer.parseInt(bot1Button.getId()));
	}
	@FXML
	private void shiftDownCol2() {
		shiftDown(main.getKitolData(), Integer.parseInt(bot2Button.getId()));
	}
	@FXML
	private void shiftDownCol3() {
		shiftDown(main.getKitolData(), Integer.parseInt(bot3Button.getId()));
	}
	@FXML
	private void shiftDownCol4() {
		shiftDown(main.getKitolData(), Integer.parseInt(bot4Button.getId()));
	}
	@FXML
	private void shiftDownCol5() {
		shiftDown(main.getKitolData(), Integer.parseInt(bot5Button.getId()));
	}
	
	@FXML
	private void shiftLeftRow0() {
		shiftLeft(main.getKitolData(), Integer.parseInt(left0Button.getId()));
	}
	@FXML
	private void shiftLeftRow1() {
		shiftLeft(main.getKitolData(), Integer.parseInt(left1Button.getId()));
	}
	@FXML
	private void shiftLeftRow2() {
		shiftLeft(main.getKitolData(), Integer.parseInt(left2Button.getId()));
	}
	@FXML
	private void shiftLeftRow3() {
		shiftLeft(main.getKitolData(), Integer.parseInt(left3Button.getId()));
	}
	@FXML
	private void shiftLeftRow4() {
		shiftLeft(main.getKitolData(), Integer.parseInt(left4Button.getId()));
	}
	@FXML
	private void shiftLeftRow5() {
		shiftLeft(main.getKitolData(), Integer.parseInt(left5Button.getId()));
	}
	
	@FXML
	private void shiftRightRow0() {
		shiftRight(main.getKitolData(), Integer.parseInt(right0Button.getId()));
	}
	@FXML
	private void shiftRightRow1() {
		shiftRight(main.getKitolData(), Integer.parseInt(right1Button.getId()));
	}
	@FXML
	private void shiftRightRow2() {
		shiftRight(main.getKitolData(), Integer.parseInt(right2Button.getId()));
	}
	@FXML
	private void shiftRightRow3() {
		shiftRight(main.getKitolData(), Integer.parseInt(right3Button.getId()));
	}
	@FXML
	private void shiftRightRow4() {
		shiftRight(main.getKitolData(), Integer.parseInt(right4Button.getId()));
	}
	@FXML
	private void shiftRightRow5() {
		shiftRight(main.getKitolData(), Integer.parseInt(right5Button.getId()));
	}
	
	@FXML
	private void incKor() {
		korLabel.setText(++korSzam + "/36");
	}

	@FXML
	private void incLevettBTopBotClick() {
		int sz = Integer.parseInt(main.getKitolData().getLevettB()) + 1;
		main.getKitolData().setLevettB(sz + "");

		levettBLabel.setText(main.getKitolData().getLevettB());

		lepes++;
		if (lepes % 2 == 0) {
			incKor();
		}

		popupWinnerCheck();
	}

	@FXML
	private void incLevettWLeftRightClick() {
		int sz = Integer.parseInt(main.getKitolData().getLevettW()) + 1;
		main.getKitolData().setLevettW(sz + "");

		levettWLabel.setText(main.getKitolData().getLevettW());

		lepes++;
		if (lepes % 2 == 0) {
			incKor();
		}

		popupWinnerCheck();
	}

	private void popupWinner(String gyoztes) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Győztes");
		alert.setHeaderText(gyoztes + " nyert!");
		alert.setContentText("Új játék?");

		ButtonType buttonTypeIgen = new ButtonType("Igen");
		ButtonType buttonTypeNem = new ButtonType("Nem");

		alert.getButtonTypes().setAll(buttonTypeIgen, buttonTypeNem);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeIgen) {
			startGame();
		} else {
			// ... user chose CANCEL or closed the dialog
		}
	}

	private void popupWinnerCheck() {
		if (main.getKitolData().getLevettB().equals("6")) {
			popupWinner("Feher");
		} else if (main.getKitolData().getLevettW().equals("6")) {
			popupWinner("Fekete");
		}
	}

	@FXML
	private void exitKitolas() {
		System.exit(0);
	}

}
