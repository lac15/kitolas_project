package hu.unideb.inf.prt.kitolas.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.xml.sax.SAXException;

import hu.unideb.inf.prt.kitolas.model.KitolasData;
import hu.unideb.inf.prt.kitolas.controller.SavedGame;

public class TestSavedGame {

    private static KitolasData kd;
    private static SavedGame sg;

    static {
    	kd = new KitolasData("0", "0", "0", "0", "0", "0");
    	kd.setTabla(new int[][] { {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1},
    		{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1} });
    	sg = new SavedGame();
    }

    @Test
    public void XMLWriteAndReadTest() throws TransformerException,
    	ParserConfigurationException, SAXException, IOException {
    	sg.XMLWrite(kd);
    	
    	KitolasData kdRead = sg.XMLRead();
    	
        assertEquals(kd.getKorSzam(), kdRead.getKorSzam());
        assertEquals(kd.getLepesSzam(), kdRead.getLepesSzam());
        assertEquals(kd.getLevettB(), kdRead.getLevettB());
        assertEquals(kd.getLevettW(), kdRead.getLevettW());
        assertEquals(kd.getTablanB(), kdRead.getTablanW());
        assertArrayEquals(kd.getTabla(), kdRead.getTabla());
    }

}
