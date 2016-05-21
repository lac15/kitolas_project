package hu.unideb.inf.prt.kitolas.controller;

import java.util.Random;

import hu.unideb.inf.prt.kitolas.model.KitolasData;

public class KitolasDataController {
	private KitolasData kt = new KitolasData ("6", "0", "6", "0", "1/36", "0");
	
	private int aktLevett = 0;
	
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
	}
	
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
	
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(kt.getElem(i, j));
			}
			System.out.println();
		}
	}

	
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
	
	public void incKor() {
		int lepes = Integer.parseInt(kt.getLepesSzam());
		lepes++;
		kt.setLepesSzam(Integer.toString(lepes));
		if (lepes % 2 == 0) {
			int korSzam = Integer.parseInt(kt.getKorSzam().split("/")[0]);
			korSzam++;
			kt.setKorSzam(korSzam + "/36");
		}
	}
	
	public KitolasData getKt() {
		return kt;
	}
	

	public void setKt(KitolasData kt) {
		this.kt = kt;
	}

	public int getAktLevett() {
		return aktLevett;
	}
	
}
