package hu.unideb.inf.prt.kitolas.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.unideb.inf.prt.kitolas.controller.KitolasDataController;

public class TestKitolasDataController {

    private static KitolasDataController kdc;

    static {
        kdc = new KitolasDataController();
    }

    @Test
    public void shiftRightDataTest() {
        kdc.getKt().setTabla(new int[][] { { 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0 } });

        int[][] test = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0 } };

        kdc.shiftRightData(0);
        assertArrayEquals(test, kdc.getKt().getTabla());
        assertEquals(2, kdc.getAktLevett());
    }

    @Test
    public void shiftUpDataTest() {
        kdc.getKt().setTabla(new int[][] { { 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0 } });

        int[][] test = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0 } };

        kdc.shiftUpData(5);
        assertArrayEquals(test, kdc.getKt().getTabla());
        assertEquals(2, kdc.getAktLevett());
    }

    @Test
    public void shiftLeftDataTest() {
        kdc.getKt().setTabla(new int[][] { { 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0 } });

        int[][] test = new int[][] { { 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

        kdc.shiftLeftData(5);
        assertArrayEquals(test, kdc.getKt().getTabla());
        assertEquals(1, kdc.getAktLevett());
    }

    @Test
    public void shiftDownDataTest() {
        kdc.getKt().setTabla(new int[][] { { 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0 } });

        int[][] test = new int[][] { { 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

        kdc.shiftDownData(0);
        assertArrayEquals(test, kdc.getKt().getTabla());
        assertEquals(1, kdc.getAktLevett());
    }

    @Test
    public void incKorDataTest() {
        kdc.getKt().setLepesSzam("1");
        kdc.incKorData();
        assertEquals("2/36", kdc.getKt().getKorSzam());
    }

    @Test
    public void clearTableDataTest() {
        kdc.getKt().setTabla(new int[][] { { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } });

        int[][] test = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

        kdc.clearTableData();
        assertArrayEquals(test, kdc.getKt().getTabla());
    }

    @Test
    public void startKitolasGameDataTest() {
        int count1 = 0;
        int count2 = 0;

        kdc.startKitolasGameData();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (kdc.getKt().getElem(i, j) == 1) {
                    count1++;
                } else if (kdc.getKt().getElem(i, j) == 2) {
                    count2++;
                }
            }
        }

        assertEquals(6, count1);
        assertEquals(6, count2);
    }

    @Test
    public void levettIncDataTest() {
        kdc.setAktLevett(2);
        kdc.getKt().setLevettB("2");

        kdc.levettIncData();

        assertEquals("3", kdc.getKt().getLevettB());

        kdc.setAktLevett(1);
        kdc.getKt().setLevettW("5");

        kdc.levettIncData();

        assertEquals("6", kdc.getKt().getLevettW());
    }

    @Test
    public void tablanDecDataTest() {
        kdc.setAktLevett(2);
        kdc.getKt().setTablanB("2");

        kdc.tablanDecData();

        assertEquals("1", kdc.getKt().getTablanB());

        kdc.setAktLevett(1);
        kdc.getKt().setTablanW("5");

        kdc.tablanDecData();

        assertEquals("4", kdc.getKt().getTablanW());
    }

}
