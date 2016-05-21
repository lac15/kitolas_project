package hu.unideb.inf.prt.kitolas.model;

public class KitolasData {

	private String tablanB;
	private String levettB;
	private String tablanW;
	private String levettW;
	private String korSzam;
	private String lepesSzam;
	
	private int [][] tabla = new int [6][6];
		
	public KitolasData() {
		this(null,null,null,null,null,null);
	}

	public KitolasData(String tablanB, String levettB, String tablanW, String levettW, String korSzam, String lepesSzam) {
		this.tablanB = tablanB;
		this.levettB = levettB;
		this.tablanW = tablanW;
		this.levettW = levettW;
		this.korSzam = korSzam;
		this.lepesSzam = lepesSzam;
	}

	public String getTablanB() {
		return tablanB;
	}

	public void setTablanB(String tablanB) {
		this.tablanB = tablanB;
	}

	public String getLevettB() {
		return levettB;
	}

	public void setLevettB(String levettB) {
		this.levettB = levettB;
	}

	public String getTablanW() {
		return tablanW;
	}

	public void setTablanW(String tablanW) {
		this.tablanW = tablanW;
	}

	public String getLevettW() {
		return levettW;
	}

	public void setLevettW(String levettW) {
		this.levettW = levettW;
	}

	public String getKorSzam() {
		return korSzam;
	}

	public void setKorSzam(String korSzam) {
		this.korSzam = korSzam;
	}

	public String getLepesSzam() {
		return lepesSzam;
	}

	public void setLepesSzam(String lepesSzam) {
		this.lepesSzam = lepesSzam;
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
