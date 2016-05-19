package hu.unideb.inf.prt.kitolas.view;

import hu.unideb.inf.prt.kitolas.model.KitolasData;

import java.util.Optional;
import java.util.Random;

import hu.unideb.inf.prt.kitolas.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class KitolasController {

	Main main;

	private int lepes = 0;
	private int korSzam = 1;
	private int aktLevett = 0;

	@FXML
	private Circle circle00B;
	@FXML
	private Circle circle00W;
	@FXML
	private Circle circle01B;
	@FXML
	private Circle circle01W;
	@FXML
	private Circle circle02B;
	@FXML
	private Circle circle02W;
	@FXML
	private Circle circle03B;
	@FXML
	private Circle circle03W;
	@FXML
	private Circle circle04B;
	@FXML
	private Circle circle04W;
	@FXML
	private Circle circle05B;
	@FXML
	private Circle circle05W;
	@FXML
	private Circle circle10B;
	@FXML
	private Circle circle10W;
	@FXML
	private Circle circle11B;
	@FXML
	private Circle circle11W;
	@FXML
	private Circle circle12B;
	@FXML
	private Circle circle12W;
	@FXML
	private Circle circle13B;
	@FXML
	private Circle circle13W;
	@FXML
	private Circle circle14B;
	@FXML
	private Circle circle14W;
	@FXML
	private Circle circle15B;
	@FXML
	private Circle circle15W;
	@FXML
	private Circle circle20B;
	@FXML
	private Circle circle20W;
	@FXML
	private Circle circle21B;
	@FXML
	private Circle circle21W;
	@FXML
	private Circle circle22B;
	@FXML
	private Circle circle22W;
	@FXML
	private Circle circle23B;
	@FXML
	private Circle circle23W;
	@FXML
	private Circle circle24B;
	@FXML
	private Circle circle24W;
	@FXML
	private Circle circle25B;
	@FXML
	private Circle circle25W;
	@FXML
	private Circle circle30B;
	@FXML
	private Circle circle30W;
	@FXML
	private Circle circle31B;
	@FXML
	private Circle circle31W;
	@FXML
	private Circle circle32B;
	@FXML
	private Circle circle32W;
	@FXML
	private Circle circle33B;
	@FXML
	private Circle circle33W;
	@FXML
	private Circle circle34B;
	@FXML
	private Circle circle34W;
	@FXML
	private Circle circle35B;
	@FXML
	private Circle circle35W;
	@FXML
	private Circle circle40B;
	@FXML
	private Circle circle40W;
	@FXML
	private Circle circle41B;
	@FXML
	private Circle circle41W;
	@FXML
	private Circle circle42B;
	@FXML
	private Circle circle42W;
	@FXML
	private Circle circle43B;
	@FXML
	private Circle circle43W;
	@FXML
	private Circle circle44B;
	@FXML
	private Circle circle44W;
	@FXML
	private Circle circle45B;
	@FXML
	private Circle circle45W;
	@FXML
	private Circle circle50B;
	@FXML
	private Circle circle50W;
	@FXML
	private Circle circle51B;
	@FXML
	private Circle circle51W;
	@FXML
	private Circle circle52B;
	@FXML
	private Circle circle52W;
	@FXML
	private Circle circle53B;
	@FXML
	private Circle circle53W;
	@FXML
	private Circle circle54B;
	@FXML
	private Circle circle54W;
	@FXML
	private Circle circle55B;
	@FXML
	private Circle circle55W;
	
	/*@FXML
	private Circle [][] circlesB = {{circle00B, circle01B, circle02B, circle03B, circle04B, circle05B},
									{circle10B, circle11B, circle12B, circle13B, circle14B, circle15B},
									{circle20B, circle21B, circle22B, circle23B, circle24B, circle25B},
									{circle30B, circle31B, circle32B, circle33B, circle34B, circle35B},
									{circle40B, circle41B, circle42B, circle43B, circle44B, circle45B},
									{circle50B, circle51B, circle52B, circle53B, circle54B, circle55B}};*/
	/*@FXML
	private Circle [][] circlesW = {{circle00W, circle01W, circle02W, circle03W, circle04W, circle05W},
									{circle10W, circle11W, circle12W, circle13W, circle14W, circle15W},
									{circle20W, circle21W, circle22W, circle23W, circle24W, circle25W},
									{circle30W, circle31W, circle32W, circle33W, circle34W, circle35W},
									{circle40W, circle41W, circle42W, circle43W, circle44W, circle45W},
									{circle50W, circle51W, circle52W, circle53W, circle54W, circle55W}};*/
	
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
	
	private void setCircleOpacity(int aktElem, Circle aktCircleW, Circle aktCircleB) {
		if (aktElem == 1) {
			aktCircleW.setOpacity(100.0);
			aktCircleB.setOpacity(0.0);
		} else if (aktElem == 2) {
			aktCircleW.setOpacity(0.0);
			aktCircleB.setOpacity(100.0);
		} else if (aktElem == 0) {
			aktCircleW.setOpacity(0.0);
			aktCircleB.setOpacity(0.0);
		}
	}
	
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

		clearTable();

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

	private void paintKitolasTable(KitolasData kitolasData) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int aktElem = kitolasData.getElem(i, j);
				if ((i == 0) && (j == 0)) {
					setCircleOpacity(aktElem, circle00W, circle00B);
				} else if((i == 0) && (j == 1)) {
					setCircleOpacity(aktElem, circle01W, circle01B);
				} else if((i == 0) && (j == 2)) {
					setCircleOpacity(aktElem, circle02W, circle02B);
				} else if((i == 0) && (j == 3)) {
					setCircleOpacity(aktElem, circle03W, circle03B);
				} else if((i == 0) && (j == 4)) {
					setCircleOpacity(aktElem, circle04W, circle04B);
				} else if((i == 0) && (j == 5)) {
					setCircleOpacity(aktElem, circle05W, circle05B);
				} else if((i == 1) && (j == 0)) {
					setCircleOpacity(aktElem, circle10W, circle10B);
				} else if((i == 1) && (j == 1)) {
					setCircleOpacity(aktElem, circle11W, circle11B);
				} else if((i == 1) && (j == 2)) {
					setCircleOpacity(aktElem, circle12W, circle12B);
				} else if((i == 1) && (j == 3)) {
					setCircleOpacity(aktElem, circle13W, circle13B);
				} else if((i == 1) && (j == 4)) {
					setCircleOpacity(aktElem, circle14W, circle14B);
				} else if((i == 1) && (j == 5)) {
					setCircleOpacity(aktElem, circle15W, circle15B);
				} else if((i == 2) && (j == 0)) {
					setCircleOpacity(aktElem, circle20W, circle20B);
				} else if((i == 2) && (j == 1)) {
					setCircleOpacity(aktElem, circle21W, circle21B);
				} else if((i == 2) && (j == 2)) {
					setCircleOpacity(aktElem, circle22W, circle22B);
				} else if((i == 2) && (j == 3)) {
					setCircleOpacity(aktElem, circle23W, circle23B);
				} else if((i == 2) && (j == 4)) {
					setCircleOpacity(aktElem, circle24W, circle24B);
				} else if((i == 2) && (j == 5)) {
					setCircleOpacity(aktElem, circle25W, circle25B);
				} else if((i == 3) && (j == 0)) {
					setCircleOpacity(aktElem, circle30W, circle30B);
				} else if((i == 3) && (j == 1)) {
					setCircleOpacity(aktElem, circle31W, circle31B);
				} else if((i == 3) && (j == 2)) {
					setCircleOpacity(aktElem, circle32W, circle32B);
				} else if((i == 3) && (j == 3)) {
					setCircleOpacity(aktElem, circle33W, circle33B);
				} else if((i == 3) && (j == 4)) {
					setCircleOpacity(aktElem, circle34W, circle34B);
				} else if((i == 3) && (j == 5)) {
					setCircleOpacity(aktElem, circle35W, circle35B);
				} else if((i == 4) && (j == 0)) {
					setCircleOpacity(aktElem, circle40W, circle40B);
				} else if((i == 4) && (j == 1)) {
					setCircleOpacity(aktElem, circle41W, circle41B);
				} else if((i == 4) && (j == 2)) {
					setCircleOpacity(aktElem, circle42W, circle42B);
				} else if((i == 4) && (j == 3)) {
					setCircleOpacity(aktElem, circle43W, circle43B);
				} else if((i == 4) && (j == 4)) {
					setCircleOpacity(aktElem, circle44W, circle44B);
				} else if((i == 4) && (j == 5)) {
					setCircleOpacity(aktElem, circle45W, circle45B);
				} else if((i == 5) && (j == 0)) {
					setCircleOpacity(aktElem, circle50W, circle50B);
				} else if((i == 5) && (j == 1)) {
					setCircleOpacity(aktElem, circle51W, circle51B);
				} else if((i == 5) && (j == 2)) {
					setCircleOpacity(aktElem, circle52W, circle52B);
				} else if((i == 5) && (j == 3)) {
					setCircleOpacity(aktElem, circle53W, circle53B);
				} else if((i == 5) && (j == 4)) {
					setCircleOpacity(aktElem, circle54W, circle54B);
				} else if((i == 5) && (j == 5)) {
					setCircleOpacity(aktElem, circle55W, circle55B);
				}
			}
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
			paintKitolasTable(main.getKitolData());
		} else {
			;
		}
	}
	
	private void levettInc() {
		KitolasData kitolasData = main.getKitolData();
		int sz = 0;
		if (aktLevett == 1) {
			sz = Integer.parseInt(kitolasData.getLevettW());
			kitolasData.setLevettW(Integer.toString(++sz));
			levettWLabel.setText(kitolasData.getLevettW());
		} else if (aktLevett == 2) {
			sz = Integer.parseInt(kitolasData.getLevettB());
			kitolasData.setLevettB(Integer.toString(++sz));
			levettBLabel.setText(kitolasData.getLevettB());
		}
	}
	
	private void tablanDec() {
		KitolasData kitolasData = main.getKitolData();
		int sz = 0;
		if (aktLevett == 1) {
			sz = Integer.parseInt(kitolasData.getTablanW());
			kitolasData.setTablanW(Integer.toString(--sz));
			tablanWLabel.setText(kitolasData.getTablanW());
		} else if (aktLevett == 2) {
			sz = Integer.parseInt(kitolasData.getTablanB());
			kitolasData.setTablanB(Integer.toString(--sz));
			tablanBLabel.setText(kitolasData.getTablanB());
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
		
		levettInc();
		
		tablanDec();
		
		paintKitolasTable(kitolasData);

		incKor();
		
		popupWinnerCheck();
		
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
		
		levettInc();
		
		tablanDec();

		paintKitolasTable(kitolasData);
		
		incKor();
		
		popupWinnerCheck();
		
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
		
		levettInc();
		
		tablanDec();
		
		paintKitolasTable(kitolasData);

		incKor();
		
		popupWinnerCheck();
		
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

		levettInc();
		
		tablanDec();
		
		paintKitolasTable(kitolasData);
		
		incKor();
		
		popupWinnerCheck();
		
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
	
	private void incKor() {
		lepes++;
		if (lepes % 2 == 0) {
			korSzam++;
			main.getKitolData().setKorSzam(korSzam + "/36");
			korLabel.setText(korSzam + "/36");
		}
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
			clearTable();
		}
	}
	
	private void popupDraw() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Eredmény");
		alert.setHeaderText("Döntetlen!");
		alert.setContentText("Új játék?");

		ButtonType buttonTypeIgen = new ButtonType("Igen");
		ButtonType buttonTypeNem = new ButtonType("Nem");

		alert.getButtonTypes().setAll(buttonTypeIgen, buttonTypeNem);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeIgen) {
			startGame();
		} else {
			clearTable();
		}
	}

	private void popupWinnerCheck() {
		KitolasData kitolData = main.getKitolData();
		if (kitolData.getLevettB().equals("6")) {
			popupWinner("Feher");
		} else if (kitolData.getLevettW().equals("6")) {
			popupWinner("Fekete");
		} else if (kitolData.getKorSzam().equals("36/36")) {
			if (kitolData.getLevettW().equals(kitolData.getLevettB())) {
				popupDraw();
			} else {
				if (Integer.parseInt(kitolData.getTablanW()) > Integer.parseInt(kitolData.getTablanB())) {
					popupWinner("Feher");
				} else {
					popupWinner("Fekete");
				}
			}
		} 
	}

	private void clearTable() {
		lepes = 0;
		korSzam = 1;
		
		KitolasData kitolasData = main.getKitolData();
		kitolasData.setKorSzam("1/36");
		korLabel.setText(kitolasData.getKorSzam());
		kitolasData.setTablanB("6");
		tablanBLabel.setText(kitolasData.getTablanB());
		kitolasData.setLevettB("0");
		levettBLabel.setText(kitolasData.getLevettB());
		kitolasData.setTablanW("6");
		tablanWLabel.setText(kitolasData.getTablanW());
		kitolasData.setLevettW("0");
		levettWLabel.setText(kitolasData.getLevettW());
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				kitolasData.setElem(i, j, 0);
			}
		}
		
		paintKitolasTable(kitolasData);
	}
	
	@FXML
	private void szabalyokKitolas() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Szabályok");
		alert.setHeaderText("Játékszabályok");
		alert.setContentText("A 6x6 mezőből álló táblán a játékosoknak 6 fehér, illetve 6 fekete kavics áll "
				+ "rendekezésükre, melyek elhelyezkedése vélelenszerű.\n"
				+ "Az adott játékos a saját körében kiválaszthat egy sort vagy egy oszlopot, melyet "
				+ "függőlegesen vagy vízszintesen eltolhat egy mezővel. Eltoláskor a szélső mezőn lévő kavics "
				+ "lekerül a tábláról.\n"
				+ "A játék célja, hogy 6x6, azaz 36, körön belül az ellenfél minél több kavicsát 'kitoljuk' "
				+ "a tábláról, azaz nekünk maradjon több kavicsunk.\n"
				+ "Ha a 36 kör végén mindkét játékosnak ugyanannyi kavicsa marad a táblán akkor a játék "
				+ "döntetlen.\n"
				+ "Jó szórakozást! :)");

		alert.showAndWait();
	}
	
	@FXML
	private void exitKitolas() {
		System.exit(0);
	}

}
