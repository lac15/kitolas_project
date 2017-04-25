package hu.unideb.inf.prt.kitolas.controller;

import hu.unideb.inf.prt.kitolas.model.KitolasData;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

/**
 * A kitolás nevű kétszemélyes táblajáték megvalósítása. A játék felületén
 * megjelenő gombok, mezők és alakzatok, illetve a velük történő események
 * kezelését valósítja meg.
 *
 * @author Erdőhegyi László
 * @since 2016-05-13
 */
public class KitolasViewController implements Initializable {
    private static Logger logger = LoggerFactory.getLogger(KitolasViewController.class);

    private KitolasDataController kdc = new KitolasDataController();

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

    /**
     * Inicializálja a kezdőállapotot.
     * 
     * @param location hely
     * @param resources forrás
     */
    public void initialize(URL location, ResourceBundle resources) {
        showKitolasData(kdc.getKt());
    }

    private void setVisibility(boolean bool) {
        top0Button.setVisible(bool);
        top1Button.setVisible(bool);
        top2Button.setVisible(bool);
        top3Button.setVisible(bool);
        top4Button.setVisible(bool);
        top5Button.setVisible(bool);
        bot0Button.setVisible(bool);
        bot1Button.setVisible(bool);
        bot2Button.setVisible(bool);
        bot3Button.setVisible(bool);
        bot4Button.setVisible(bool);
        bot5Button.setVisible(bool);
        left0Button.setVisible(bool);
        left1Button.setVisible(bool);
        left2Button.setVisible(bool);
        left3Button.setVisible(bool);
        left4Button.setVisible(bool);
        left5Button.setVisible(bool);
        right0Button.setVisible(bool);
        right1Button.setVisible(bool);
        right2Button.setVisible(bool);
        right3Button.setVisible(bool);
        right4Button.setVisible(bool);
        right5Button.setVisible(bool);
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

    private void startKitolasGame() {
        kdc.startKitolasGameData();

        setVisibility(true);
    }

    private void paintKitolasTable() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int aktElem = kdc.getKt().getElem(i, j);
                if ((i == 0) && (j == 0)) {
                    setCircleOpacity(aktElem, circle00W, circle00B);
                } else if ((i == 0) && (j == 1)) {
                    setCircleOpacity(aktElem, circle01W, circle01B);
                } else if ((i == 0) && (j == 2)) {
                    setCircleOpacity(aktElem, circle02W, circle02B);
                } else if ((i == 0) && (j == 3)) {
                    setCircleOpacity(aktElem, circle03W, circle03B);
                } else if ((i == 0) && (j == 4)) {
                    setCircleOpacity(aktElem, circle04W, circle04B);
                } else if ((i == 0) && (j == 5)) {
                    setCircleOpacity(aktElem, circle05W, circle05B);
                } else if ((i == 1) && (j == 0)) {
                    setCircleOpacity(aktElem, circle10W, circle10B);
                } else if ((i == 1) && (j == 1)) {
                    setCircleOpacity(aktElem, circle11W, circle11B);
                } else if ((i == 1) && (j == 2)) {
                    setCircleOpacity(aktElem, circle12W, circle12B);
                } else if ((i == 1) && (j == 3)) {
                    setCircleOpacity(aktElem, circle13W, circle13B);
                } else if ((i == 1) && (j == 4)) {
                    setCircleOpacity(aktElem, circle14W, circle14B);
                } else if ((i == 1) && (j == 5)) {
                    setCircleOpacity(aktElem, circle15W, circle15B);
                } else if ((i == 2) && (j == 0)) {
                    setCircleOpacity(aktElem, circle20W, circle20B);
                } else if ((i == 2) && (j == 1)) {
                    setCircleOpacity(aktElem, circle21W, circle21B);
                } else if ((i == 2) && (j == 2)) {
                    setCircleOpacity(aktElem, circle22W, circle22B);
                } else if ((i == 2) && (j == 3)) {
                    setCircleOpacity(aktElem, circle23W, circle23B);
                } else if ((i == 2) && (j == 4)) {
                    setCircleOpacity(aktElem, circle24W, circle24B);
                } else if ((i == 2) && (j == 5)) {
                    setCircleOpacity(aktElem, circle25W, circle25B);
                } else if ((i == 3) && (j == 0)) {
                    setCircleOpacity(aktElem, circle30W, circle30B);
                } else if ((i == 3) && (j == 1)) {
                    setCircleOpacity(aktElem, circle31W, circle31B);
                } else if ((i == 3) && (j == 2)) {
                    setCircleOpacity(aktElem, circle32W, circle32B);
                } else if ((i == 3) && (j == 3)) {
                    setCircleOpacity(aktElem, circle33W, circle33B);
                } else if ((i == 3) && (j == 4)) {
                    setCircleOpacity(aktElem, circle34W, circle34B);
                } else if ((i == 3) && (j == 5)) {
                    setCircleOpacity(aktElem, circle35W, circle35B);
                } else if ((i == 4) && (j == 0)) {
                    setCircleOpacity(aktElem, circle40W, circle40B);
                } else if ((i == 4) && (j == 1)) {
                    setCircleOpacity(aktElem, circle41W, circle41B);
                } else if ((i == 4) && (j == 2)) {
                    setCircleOpacity(aktElem, circle42W, circle42B);
                } else if ((i == 4) && (j == 3)) {
                    setCircleOpacity(aktElem, circle43W, circle43B);
                } else if ((i == 4) && (j == 4)) {
                    setCircleOpacity(aktElem, circle44W, circle44B);
                } else if ((i == 4) && (j == 5)) {
                    setCircleOpacity(aktElem, circle45W, circle45B);
                } else if ((i == 5) && (j == 0)) {
                    setCircleOpacity(aktElem, circle50W, circle50B);
                } else if ((i == 5) && (j == 1)) {
                    setCircleOpacity(aktElem, circle51W, circle51B);
                } else if ((i == 5) && (j == 2)) {
                    setCircleOpacity(aktElem, circle52W, circle52B);
                } else if ((i == 5) && (j == 3)) {
                    setCircleOpacity(aktElem, circle53W, circle53B);
                } else if ((i == 5) && (j == 4)) {
                    setCircleOpacity(aktElem, circle54W, circle54B);
                } else if ((i == 5) && (j == 5)) {
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
            startKitolasGame();
            paintKitolasTable();
        } else {

        }
    }

    private void levettInc() {
        kdc.levettIncData();
        if (kdc.getAktLevett() == 1) {
            levettWLabel.setText(kdc.getKt().getLevettW());
        } else if (kdc.getAktLevett() == 2) {
            levettBLabel.setText(kdc.getKt().getLevettB());
        }
    }

    private void tablanDec() {
        kdc.tablanDecData();
        if (kdc.getAktLevett() == 1) {
            tablanWLabel.setText(kdc.getKt().getTablanW());
        } else if (kdc.getAktLevett() == 2) {
            tablanBLabel.setText(kdc.getKt().getTablanB());
        }
    }

    @FXML
    private void shiftUpCol0() {
        kdc.shiftUpData(Integer.parseInt(top0Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftUpCol1() {
        kdc.shiftUpData(Integer.parseInt(top1Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftUpCol2() {
        kdc.shiftUpData(Integer.parseInt(top2Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftUpCol3() {
        kdc.shiftUpData(Integer.parseInt(top3Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftUpCol4() {
        kdc.shiftUpData(Integer.parseInt(top4Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftUpCol5() {
        kdc.shiftUpData(Integer.parseInt(top5Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftDownCol0() {
        kdc.shiftDownData(Integer.parseInt(bot0Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftDownCol1() {
        kdc.shiftDownData(Integer.parseInt(bot1Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftDownCol2() {
        kdc.shiftDownData(Integer.parseInt(bot2Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftDownCol3() {
        kdc.shiftDownData(Integer.parseInt(bot3Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftDownCol4() {
        kdc.shiftDownData(Integer.parseInt(bot4Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftDownCol5() {
        kdc.shiftDownData(Integer.parseInt(bot5Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftLeftRow0() {
        kdc.shiftLeftData(Integer.parseInt(left0Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftLeftRow1() {
        kdc.shiftLeftData(Integer.parseInt(left1Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftLeftRow2() {
        kdc.shiftLeftData(Integer.parseInt(left2Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftLeftRow3() {
        kdc.shiftLeftData(Integer.parseInt(left3Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftLeftRow4() {
        kdc.shiftLeftData(Integer.parseInt(left4Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftLeftRow5() {
        kdc.shiftLeftData(Integer.parseInt(left5Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftRightRow0() {
        kdc.shiftRightData(Integer.parseInt(right0Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftRightRow1() {
        kdc.shiftRightData(Integer.parseInt(right1Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftRightRow2() {
        kdc.shiftRightData(Integer.parseInt(right2Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftRightRow3() {
        kdc.shiftRightData(Integer.parseInt(right3Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftRightRow4() {
        kdc.shiftRightData(Integer.parseInt(right4Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    @FXML
    private void shiftRightRow5() {
        kdc.shiftRightData(Integer.parseInt(right5Button.getId()));

        levettInc();
        tablanDec();
        paintKitolasTable();
        incKor();
        popupWinnerCheck();
    }

    private void incKor() {
        kdc.incKorData();
        if (Integer.parseInt(kdc.getKt().getLepesSzam()) % 2 == 0) {
            korLabel.setText(kdc.getKt().getKorSzam());
        }
    }

    private void popupWinner(String gyoztes) {
        logger.info("A " + gyoztes + " nyert!");

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
            setVisibility(false);
        }
    }

    private void popupDraw() {
        logger.info("Döntetlen!");

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
            setVisibility(false);
        }
    }

    private void popupWinnerCheck() {
        if (kdc.getKt().getLevettB().equals("6")) {
            popupWinner("Feher");
        } else if (kdc.getKt().getLevettW().equals("6")) {
            popupWinner("Fekete");
        } else if (kdc.getKt().getKorSzam().equals("36/36")) {
            if (kdc.getKt().getLevettW().equals(kdc.getKt().getLevettB())) {
                popupDraw();
            } else {
                if (Integer.parseInt(kdc.getKt().getTablanW()) > Integer.parseInt(kdc.getKt().getTablanB())) {
                    popupWinner("Feher");
                } else {
                    popupWinner("Fekete");
                }
            }
        }
    }

    private void clearTable() {
        kdc.clearTableData();

        korLabel.setText(kdc.getKt().getKorSzam());
        tablanBLabel.setText(kdc.getKt().getTablanB());
        levettBLabel.setText(kdc.getKt().getLevettB());
        tablanWLabel.setText(kdc.getKt().getTablanW());
        levettWLabel.setText(kdc.getKt().getLevettW());

        paintKitolasTable();
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
                + "döntetlen.\n" + "Jó szórakozást! :)");

        alert.showAndWait();
    }

    @FXML
    private void exitKitolas() {
        System.exit(0);
    }

}
