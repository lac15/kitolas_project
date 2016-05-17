package hu.unideb.inf.prt.kitolas.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KitolasData {

	private StringProperty tablanB;
	private StringProperty levettB;
	private StringProperty tablanW;
	private StringProperty levettW;
	private StringProperty korSzam;
	
	private int [][] tabla = new int [6][6];
		
	public KitolasData() {
		this(null,null,null,null,null);
	}

	public KitolasData(String tablanB, String levettB, String tablanW, String levettW, String korSzam) {
		this.tablanB = new SimpleStringProperty(tablanB);
		this.levettB = new SimpleStringProperty(levettB);
		this.tablanW = new SimpleStringProperty(tablanW);
		this.levettW = new SimpleStringProperty(levettW);
		this.korSzam = new SimpleStringProperty(korSzam);
	}

	public StringProperty getTablanBProperty() {
		return tablanB;
	}
	public void setTablanBProperty(StringProperty tablanB) {
		this.tablanB = tablanB;
	}
	public StringProperty getLevettBProperty() {
		return levettB;
	}
	public void setLevettBProperty(StringProperty levettB) {
		this.levettB = levettB;
	}
	public StringProperty getTablanWProperty() {
		return tablanW;
	}
	public void setTablanWProperty(StringProperty tablanW) {
		this.tablanW = tablanW;
	}
	public StringProperty getLevettWProperty() {
		return levettW;
	}
	public void setLevettWProperty(StringProperty levettW) {
		this.levettW = levettW;
	}
	public StringProperty getKorSzamProperty() {
		return korSzam;
	}
	public void setKorSzamProperty(StringProperty korSzam) {
		this.korSzam = korSzam;
	}


	public String getTablanB() {
		return tablanB.get();
	}
	public void setTablanB(String tablanB) {
		this.tablanB.set(tablanB);
	}
	public String getLevettB() {
		return levettB.get();
	}
	public void setLevettB(String levettB) {
		this.levettB.set(levettB);
	}
	public String getTablanW() {
		return tablanW.get();
	}
	public void setTablanW(String tablanW) {
		this.tablanW.set(tablanW);
	}
	public String getLevettW() {
		return levettW.get();
	}
	public void setLevettW(String levettW) {
		this.levettW.set(levettW);
	}
	public String getKorSzam() {
		return korSzam.get();
	}
	public void setKorSzam(String korSzam) {
		this.korSzam.set(korSzam);
	}

	public KitolasData(int[][] tabla) {
		super();
		this.tabla = tabla;
	}
	public int[][] getTabla() {
		return tabla;
	}
	public void setTabla(int[][] tabla) {
		this.tabla = tabla;
	}
	public int getElem(int x,int y) {
		return this.tabla[x][y];
	}
	public void setElem(int x,int y,int value) {
		this.tabla[x][y] = value;
	}
	
}
