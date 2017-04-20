package hu.unideb.inf.prt.kitolas.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.prt.kitolas.model.KitolasData;

/**
* A kitolás nevű kétszemélyes táblajáték megvalósítása.
* A játék során történő adatmozgatásokat,
* adatmanipulációkat valósítja meg.
*
* @author  Erdőhegyi László
* @since   2016-05-13
*/
public class KitolasDataController {
	private static Logger logger = LoggerFactory.getLogger(KitolasDataController.class);
	
	private KitolasData kt = new KitolasData ("6", "0", "6", "0", "1/36", "0");
	
	private int aktLevett = 0;
	
	/**
	 * Mindent visszaállít a kezdő állapotra.
	 */
	public void clearTableData() {
		kt.setLepesSzam("0");
		kt.setKorSzam("1/36");
		kt.setTablanB("6");
		kt.setLevettB("0");
		kt.setTablanW("6");
		kt.setLevettW("0");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				kt.setElem(i, j, 0);
			}
		}
		
		logger.info("A tábla letisztult.");
	}
	
	/**
	 * Véletlenszerűen feltölti a táblát 6 fekete
	 * és 6 fehér kaviccsal.
	 */
	public void startKitolasGameData() {
		Random rand = new Random();
		int row = 0;
		int col = 0;
		int feher = 0;
		int fekete = 0;
	
		clearTableData();
	
		while (feher != 6) {
			row = rand.nextInt(6);
			col = rand.nextInt(6);
	
			if (kt.getElem(row, col) == 0) {
				kt.setElem(row, col, 1);
				feher++;
			}
		}
		while (fekete != 6) {
			row = rand.nextInt(6);
			col = rand.nextInt(6);
	
			if (kt.getElem(row, col) == 0) {
				kt.setElem(row, col, 2);
				fekete++;
			}
		}
		
		logger.info("Új játék kezdődött.");
	}

	/**
	 * Ha az egyik játékos kitol egy kavicsot a pályáról
	 * akkor megnöveli eggyel a levettB vagy levettW mezőt
	 * attól függően, hogy a levett kavics fekete vagy 
	 * fehér volt.
	 */
	public void levettIncData() {
		int sz = 0;
		if (aktLevett == 1) {
			sz = Integer.parseInt(kt.getLevettW());
			kt.setLevettW(Integer.toString(++sz));
		} else if (aktLevett == 2) {
			sz = Integer.parseInt(kt.getLevettB());
			kt.setLevettB(Integer.toString(++sz));
		}
	}
	
	/**
	 * Ha az egyik játékos kitol egy kavicsot a pályáról
	 * akkor lecsökkenti eggyel a tablanB vagy tablanW mezőt
	 * attól függően, hogy a levett kavics fekete vagy 
	 * fehér volt.
	 */
	public void tablanDecData() {
		int sz = 0;
		if (aktLevett == 1) {
			sz = Integer.parseInt(kt.getTablanW());
			kt.setTablanW(Integer.toString(--sz));
		} else if (aktLevett == 2) {
			sz = Integer.parseInt(kt.getTablanB());
			kt.setTablanB(Integer.toString(--sz));
		}
	}
	
	/**
	 * A paraméterként kapott oszlopot eltolja eggyel
	 * felfele.
	 * @param oIndex Az eltolni kívánt oszlop indexe.
	 */
	public void shiftUpData(int oIndex) {
		for (int i = 0; i < 6; i++) {
			int aktElem = kt.getElem(i, oIndex);
			if (i == 0) {
				aktLevett = aktElem;
			} else {
				kt.setElem(i - 1, oIndex, aktElem);
				kt.setElem(i, oIndex, 0);
			}
		}
	}
	
	/**
	 * A paraméterként kapott oszlopot eltolja eggyel
	 * lefele.
	 * @param oIndex Az eltolni kívánt oszlop indexe.
	 */
	public void shiftDownData(int oIndex) {
		for (int i = 5; i >= 0; i--) {
			int aktElem = kt.getElem(i, oIndex);
			if (i == 5) {
				aktLevett = aktElem;
			} else {
				kt.setElem(i + 1, oIndex, aktElem);
				kt.setElem(i, oIndex, 0);
			}
		}
	}
	
	/**
	 * A paraméterként kapott sort eltolja eggyel
	 * balra.
	 * @param oIndex Az eltolni kívánt sor indexe.
	 */
	public void shiftLeftData(int sIndex) {
		for (int j = 0; j < 6; j++) {
			int aktElem = kt.getElem(sIndex, j);
			if (j == 0) {
				aktLevett = aktElem;
			} else {
				kt.setElem(sIndex, j - 1, aktElem);
				kt.setElem(sIndex, j, 0);
			}
		}
	}

	/**
	 * A paraméterként kapott sort eltolja eggyel
	 * balra.
	 * @param oIndex Az eltolni kívánt sor indexe.
	 */
	public void shiftRightData(int sIndex) {
		for (int j = 5; j >= 0; j--) {
			int aktElem = kt.getElem(sIndex, j);
			if (j == 5) {
				aktLevett = aktElem;
			} else {
				kt.setElem(sIndex, j + 1, aktElem);
				kt.setElem(sIndex, j, 0);
			}
		}
	}
	
	/**
	 * Megnöveli a körök számát eggyel minden második
	 * lépés után.
	 */
	public void incKorData() {
		int lepes = Integer.parseInt(kt.getLepesSzam());
		lepes++;
		kt.setLepesSzam(Integer.toString(lepes));
		if (lepes % 2 == 0) {
			int korSzam = Integer.parseInt(kt.getKorSzam().split("/")[0]);
			korSzam++;
			kt.setKorSzam(korSzam + "/36");
		}
	}
	
	/**
	 * @return Visszaadja a kt nevű KitolasData-t.
	 */
	public KitolasData getKt() {
		return kt;
	}
	
	/**
	 * @param kt Beállítja a paraméterként kapott KitolasData-ra
	 * az aktuális állást (KitolásData-t).
	 */
	public void setKt(KitolasData kt) {
		this.kt = kt;
	}

	/**
	 * @return Visszaadja az aktuálisan utoljára levett kavics
	 * színét (0 == nem vett le, 1 == fehér, 2 == fekete).
	 */
	public int getAktLevett() {
		return aktLevett;
	}

	/**
	 * Beállítja az aktuálisan utoljára levett kavics színát.
	 * @param Milyen színű legyen a kavics.
	 */
	public void setAktLevett(int aktLevett) {
		this.aktLevett = aktLevett;
	}
	
}
