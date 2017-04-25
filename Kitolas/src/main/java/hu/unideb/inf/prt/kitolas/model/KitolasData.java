package hu.unideb.inf.prt.kitolas.model;

/**
 * A kitolás nevű kétszemélyes táblajáték megvalósítása. A játékmenethez
 * szükséges adatok modellje.
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
     * @param tablanB
     *            Az adott játékmenetben még a táblán lévő fekete kavicsok
     *            száma.
     * @param levettB
     *            Az adott játékmenetben már levett fekete kavicsok száma.
     * @param tablanW
     *            Az adott játékmenetben még a táblán lévő fehér kavicsok száma.
     * @param levettW
     *            Az adott játékmenetben már levett feher kavicsok száma.
     * @param korSzam
     *            Az adott játékmenetben eltelt körök száma.
     * @param lepesSzam
     *            Az adott játékmenetben megtett lépések száma.
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
     * @return Visszaadja a táblán lévő fekete kavicsok számát.
     */
    public String getTablanB() {
        return tablanB;
    }

    /**
     * @param tablanB
     *            Beállítja a paraméterként kapott értékre a táblán lévő fekete
     *            kavicsok számát.
     */
    public void setTablanB(String tablanB) {
        this.tablanB = tablanB;
    }

    /**
     * @return Visszaadja a levett fekete kavicsok számát.
     */
    public String getLevettB() {
        return levettB;
    }

    /**
     * @param levettB
     *            Beállítja a paraméterként kapott értékre a levett fekete
     *            kavicsok számát.
     */
    public void setLevettB(String levettB) {
        this.levettB = levettB;
    }

    /**
     * @return Visszaadja a táblán lévő feher kavicsok számát.
     */
    public String getTablanW() {
        return tablanW;
    }

    /**
     * @param tablanW
     *            Beállítja a paraméterként kapott értékre a táblán lévő fehér
     *            kavicsok számát a táblán.
     */
    public void setTablanW(String tablanW) {
        this.tablanW = tablanW;
    }

    /**
     * @return Visszaadja a levett fehér kavicsok számát.
     */
    public String getLevettW() {
        return levettW;
    }

    /**
     * @param levettW
     *            Beállítja a paraméterként kapott értékre a levett fehér
     *            kavicsok számát.
     */
    public void setLevettW(String levettW) {
        this.levettW = levettW;
    }

    /**
     * @return Visszaadja az eltelt körök számát.
     */
    public String getKorSzam() {
        return korSzam;
    }

    /**
     * @param korSzam
     *            Baállítja a paraméterként kapott értékre az eltelt körök
     *            számát.
     */
    public void setKorSzam(String korSzam) {
        this.korSzam = korSzam;
    }

    /**
     * @return Visszaadja a megtett lépések számát.
     */
    public String getLepesSzam() {
        return lepesSzam;
    }

    /**
     * @param lepesSzam
     *            Baállítja a paraméterként kapott értékre a megtett lépések
     *            számát számát.
     */
    public void setLepesSzam(String lepesSzam) {
        this.lepesSzam = lepesSzam;
    }

    /**
     * A táblán lévő elemek mátrixának konstruktora.
     *
     * @param tabla
     *            Egy 6x6 dimenziós mátrix.
     */
    public KitolasData(int[][] tabla) {
        super();
        this.tabla = tabla;
    }

    /**
     * @return Visszaad egy 6x6-os mátrixok melyben a táblán lévő elemek vannak.
     */
    public int[][] getTabla() {
        return tabla;
    }

    /**
     * Beállítja a paraméterként kapott mátrixra a táblán lévő elemek mátrixát.
     *
     * @param tabla
     *            Egy 6x6 dimenziós mátrix.
     */
    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }

    /**
     * @param x
     *            A táblán lévő elemek mátrixának sor indexe.
     * @param y
     *            A táblán lévő elemek mátrixának oszlop indexe.
     * @return A táblán lévő elemek mátrixának (x,y) helyén található elemet
     *         adja vissza.
     */
    public int getElem(int x, int y) {
        return this.tabla[x][y];
    }

    /**
     * Beállitja a táblán lévő elemek mátrixának (x,y) helyén lévő elemét a
     * paraméterként kapott value értékre.
     *
     * @param x
     *            A táblán lévő elemek mátrixának sor indexe.
     * @param y
     *            A táblán lévő elemek mátrixának oszlop indexe.
     * @param value
     *            A táblán lévő elemek mátrixának (x,y) helyére kerülő új elem.
     */
    public void setElem(int x, int y, int value) {
        this.tabla[x][y] = value;
    }

}
