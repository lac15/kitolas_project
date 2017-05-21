package hu.unideb.inf.prt.kitolas.model;

/**
 * A játékmenethez szükséges adatok modellje.
 * 
 * @author Erdőhegyi László
 * @since 2016-05-13
 */
public class KitolasData {

    private String tablanB;
    private String levettB;
    private String tablanW;
    private String levettW;
    private String korSzam;
    private String lepesSzam;

    private int[][] tabla = new int[6][6];

    /**
     * Konstruktor a paraméter nélküli példányosításokhoz.
     */
    public KitolasData() {
        super();
    }

    /**
     * Konstruktor a paraméterekkel történő példányosításokhoz.
     *
     * @param tablanB az adott játékmenetben még a táblán lévő fekete kavicsok száma
     * @param levettB az adott játékmenetben már levett fekete kavicsok száma
     * @param tablanW az adott játékmenetben még a táblán lévő fehér kavicsok száma
     * @param levettW az adott játékmenetben már levett feher kavicsok száma
     * @param korSzam az adott játékmenetben eltelt körök száma
     * @param lepesSzam az adott játékmenetben megtett lépések száma
     */
    public KitolasData(String tablanB, String levettB, String tablanW, String levettW, String korSzam,
            String lepesSzam) {
        this.tablanB = tablanB;
        this.levettB = levettB;
        this.tablanW = tablanW;
        this.levettW = levettW;
        this.korSzam = korSzam;
        this.lepesSzam = lepesSzam;
    }

    /**
     * Visszaadja a táblán lévő fekete kavicsok számát.
     * 
     * @return a táblán lévő fekete kavicsok száma
     */
    public String getTablanB() {
        return tablanB;
    }

    /**
     * Beállítja a paraméterként kapott értékre a táblán lévő fekete kavicsok számát.
     * 
     * @param tablanB mennyi legyen a táblán lévő fekete kavicsok száma
     */
    public void setTablanB(String tablanB) {
        this.tablanB = tablanB;
    }

    /**
     * Visszaadja a levett fekete kavicsok számát.
     * 
     * @return a levett fekete kavicsok száma
     */
    public String getLevettB() {
        return levettB;
    }

    /**
     * Beállítja a paraméterként kapott értékre a levett fekete kavicsok számát.
     * 
     * @param levettB mennyi legyen a levett fekete kavicsok száma
     */
    public void setLevettB(String levettB) {
        this.levettB = levettB;
    }

    /**
     * Visszaadja a táblán lévő fehér kavicsok számát.
     * 
     * @return a táblán lévő fehér kavicsok száma
     */
    public String getTablanW() {
        return tablanW;
    }

    /**
     * Beállítja a paraméterként kapott értékre a táblán lévő fehér kavicsok számát.
     * 
     * @param tablanW mennyi legyen a táblán lévő fehér kavicsok száma
     */
    public void setTablanW(String tablanW) {
        this.tablanW = tablanW;
    }

    /**
     * Visszaadja a levett fehér kavicsok számát.
     * 
     * @return a levett fehér kavicsok száma
     */
    public String getLevettW() {
        return levettW;
    }

    /**
     * Beállítja a paraméterként kapott értékre a levett fehér kavicsok számát.
     * 
     * @param levettW mennyi legyen a levett fehér kavicsok száma
     */
    public void setLevettW(String levettW) {
        this.levettW = levettW;
    }

    /**
     * Visszaadja az eltelt körök számát.
     * 
     * @return az eltelt körök száma
     */
    public String getKorSzam() {
        return korSzam;
    }

    /**
     * Beállítja a paraméterként kapott értékre az eltelt körök számát.
     * 
     * @param korSzam mennyi legyen az eltelt körök száma
     */
    public void setKorSzam(String korSzam) {
        this.korSzam = korSzam;
    }

    /**
     * Visszaadja a megtett lépések számát.
     * 
     * @return a megtett lépések száma
     */
    public String getLepesSzam() {
        return lepesSzam;
    }

    /**
     * Beállítja a paraméterként kapott értékre a megtett lépések számát.
     * 
     * @param lepesSzam mennyi legyen a megtett lépések száma
     */
    public void setLepesSzam(String lepesSzam) {
        this.lepesSzam = lepesSzam;
    }

    /**
     * Konstruktor a táblán lévő elemek mátrixával való példányosításhoz.
     *
     * @param tabla a táblán lévő elemek 6x6-os mátrixa
     */
    public KitolasData(int[][] tabla) {
        super();
        this.tabla = tabla;
    }

    /**
     * Visszaad egy 6x6-os mátrixok, melyben a táblán lévő elemek vannak.
     * 
     * @return a táblán lévő elemek egy 6x6-os mátrixban
     */
    public int[][] getTabla() {
        return tabla;
    }

    /**
     * Beállítja a paraméterként kapott mátrixra a táblán lévő elemek mátrixát.
     *
     * @param tabla ez legyen a táblán lévő elemek 6x6-os mátrixa
     */
    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }

    /**
     * A táblán lévő elemek mátrixának {@code [x, y]} helyén található elemet adja vissza.
     * 
     * @param x a táblán lévő elemek mátrixának sor indexe
     * @param y a táblán lévő elemek mátrixának oszlop indexe
     * @return a mátrix {@code [x, y]} helyén találhato elem
     */
    public int getElem(int x, int y) {
        return this.tabla[x][y];
    }

    /**
     * Beállitja a táblán lévő elemek mátrixának {@code [x, y]} helyén lévő elemét a
     * paraméterként kapott {@code value} értékre.
     *
     * @param x a táblán lévő elemek mátrixának sor indexe
     * @param y a táblán lévő elemek mátrixának oszlop indexe
     * @param value a mátrix {@code [x, y]} helyére kerülő új elem
     */
    public void setElem(int x, int y, int value) {
        this.tabla[x][y] = value;
    }

}
