package hu.unideb.inf.prt.kitolas;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import hu.unideb.inf.prt.kitolas.model.KitolasData;
 
 
public class XMLHandler extends DefaultHandler {
 
    //List to hold Employees object
    private List<KitolasData> kitolList = null;
    private KitolasData kitol = null;
 
 
    //getter method for employee list
    public List<KitolasData> getEmpList() {
        return kitolList;
    }
 
 
    boolean bKorSzam = false;
    boolean bLepesSzam = false;
    boolean bTablanW = false;
    boolean bLevettW = false;
    boolean bTablanB = false;
    boolean bLevettB = false;
    boolean bTabla00 = false;
    boolean bTabla01 = false;
    boolean bTabla02 = false;
    boolean bTabla03 = false;
    boolean bTabla04 = false;
    boolean bTabla05 = false;
    boolean bTabla10 = false;
    boolean bTabla11 = false;
    boolean bTabla12 = false;
    boolean bTabla13 = false;
    boolean bTabla14 = false;
    boolean bTabla15 = false;
    boolean bTabla20 = false;
    boolean bTabla21 = false;
    boolean bTabla22 = false;
    boolean bTabla23 = false;
    boolean bTabla24 = false;
    boolean bTabla25 = false;
    boolean bTabla30 = false;
    boolean bTabla31 = false;
    boolean bTabla32 = false;
    boolean bTabla33 = false;
    boolean bTabla34 = false;
    boolean bTabla35 = false;
    boolean bTabla40 = false;
    boolean bTabla41 = false;
    boolean bTabla42 = false;
    boolean bTabla43 = false;
    boolean bTabla44 = false;
    boolean bTabla45 = false;
    boolean bTabla50 = false;
    boolean bTabla51 = false;
    boolean bTabla52 = false;
    boolean bTabla53 = false;
    boolean bTabla54 = false;
    boolean bTabla55 = false;
    
 
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
 
        if (qName.equalsIgnoreCase("lastGame")) {
            if (kitolList == null)
                kitolList = new ArrayList<KitolasData>();
        } else if (qName.equalsIgnoreCase("korSzam")) {
            //set boolean values for fields, will be used in setting Employee variables
            bKorSzam = true;
        } else if (qName.equalsIgnoreCase("lepesSzam")) {
            bLepesSzam = true;
        } else if (qName.equalsIgnoreCase("tablanW")) {
            bTablanW = true;
        } else if (qName.equalsIgnoreCase("levettW")) {
        	bLevettW = true;
        } else if (qName.equalsIgnoreCase("tablanB")) {
            bTablanB = true;
        } else if (qName.equalsIgnoreCase("levettB")) {
            bLevettB = true;
        } else if (qName.equalsIgnoreCase("tabla00")) {
            bTabla00 = true;
        } else if (qName.equalsIgnoreCase("tabla01")) {
        	bTabla01 = true;
        } else if (qName.equalsIgnoreCase("tabla02")) {
        	bTabla02 = true;
        } else if (qName.equalsIgnoreCase("tabla03")) {
        	bTabla03 = true;
        } else if (qName.equalsIgnoreCase("tabla04")) {
        	bTabla04 = true;
        } else if (qName.equalsIgnoreCase("tabla05")) {
        	bTabla05 = true;
        } else if (qName.equalsIgnoreCase("tabla10")) {
            bTabla10 = true;
        } else if (qName.equalsIgnoreCase("tabla11")) {
        	bTabla11 = true;
        } else if (qName.equalsIgnoreCase("tabla12")) {
        	bTabla12 = true;
        } else if (qName.equalsIgnoreCase("tabla13")) {
        	bTabla13 = true;
        } else if (qName.equalsIgnoreCase("tabla14")) {
        	bTabla14 = true;
        } else if (qName.equalsIgnoreCase("tabla15")) {
        	bTabla15 = true;
        } else if (qName.equalsIgnoreCase("tabla20")) {
            bTabla20 = true;
        } else if (qName.equalsIgnoreCase("tabla21")) {
        	bTabla21 = true;
        } else if (qName.equalsIgnoreCase("tabla22")) {
        	bTabla22 = true;
        } else if (qName.equalsIgnoreCase("tabla23")) {
        	bTabla23 = true;
        } else if (qName.equalsIgnoreCase("tabla24")) {
        	bTabla24 = true;
        } else if (qName.equalsIgnoreCase("tabla25")) {
        	bTabla25 = true;
        } else if (qName.equalsIgnoreCase("tabla30")) {
            bTabla30 = true;
        } else if (qName.equalsIgnoreCase("tabla31")) {
        	bTabla31 = true;
        } else if (qName.equalsIgnoreCase("tabla32")) {
        	bTabla32 = true;
        } else if (qName.equalsIgnoreCase("tabla33")) {
        	bTabla33 = true;
        } else if (qName.equalsIgnoreCase("tabla34")) {
        	bTabla34 = true;
        } else if (qName.equalsIgnoreCase("tabla35")) {
        	bTabla35 = true;
        } else if (qName.equalsIgnoreCase("tabla40")) {
            bTabla40 = true;
        } else if (qName.equalsIgnoreCase("tabla41")) {
        	bTabla41 = true;
        } else if (qName.equalsIgnoreCase("tabla42")) {
        	bTabla42 = true;
        } else if (qName.equalsIgnoreCase("tabla43")) {
        	bTabla43 = true;
        } else if (qName.equalsIgnoreCase("tabla44")) {
        	bTabla44 = true;
        } else if (qName.equalsIgnoreCase("tabla45")) {
        	bTabla45 = true;
        } else if (qName.equalsIgnoreCase("tabla50")) {
            bTabla50 = true;
        } else if (qName.equalsIgnoreCase("tabla51")) {
        	bTabla51 = true;
        } else if (qName.equalsIgnoreCase("tabla52")) {
        	bTabla52 = true;
        } else if (qName.equalsIgnoreCase("tabla53")) {
        	bTabla53 = true;
        } else if (qName.equalsIgnoreCase("tabla54")) {
        	bTabla54 = true;
        } else if (qName.equalsIgnoreCase("tabla55")) {
        	bTabla55 = true;
        }
    }
 
 
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("lastGame")) {
            //add Employee object to list
            kitolList.add(kitol);
        }
    }
 
 
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
 
        if (bKorSzam) {
            //age element, set Employee age
            kitol.setKorSzam(new String(ch, start, length));
            bKorSzam = false;
        } else if (bLepesSzam) {
            kitol.setLepesSzam(new String(ch, start, length));
            bLepesSzam = false;
        } else if (bTablanW) {
            kitol.setTablanW(new String(ch, start, length));
            bTablanW = false;
        } else if (bLevettW) {
            kitol.setLevettW(new String(ch, start, length));
            bLevettW = false;
        } else if (bTablanB) {
            kitol.setTablanB(new String(ch, start, length));
            bTablanB = false;
        } else if (bLevettB) {
            kitol.setLevettB(new String(ch, start, length));
            bLevettB = false;
        } else if (bTabla00) {
            kitol.setElem(0, 0, Integer.parseInt(new String(ch, start, length)));
            bTabla00 = false;
        } else if (bTabla01) {
        	kitol.setElem(0, 1, Integer.parseInt(new String(ch, start, length)));
            bTabla01 = false;
        } else if (bTabla02) {
            kitol.setElem(0, 2, Integer.parseInt(new String(ch, start, length)));
            bTabla02 = false;
        } else if (bTabla03) {
        	kitol.setElem(0, 3, Integer.parseInt(new String(ch, start, length)));
            bTabla03 = false;
        } else if (bTabla04) {
            kitol.setElem(0, 4, Integer.parseInt(new String(ch, start, length)));
            bTabla04 = false;
        } else if (bTabla05) {
        	kitol.setElem(0, 5, Integer.parseInt(new String(ch, start, length)));
            bTabla05 = false;
        } else if (bTabla10) {
            kitol.setElem(1, 0, Integer.parseInt(new String(ch, start, length)));
            bTabla10 = false;
        } else if (bTabla11) {
        	kitol.setElem(1, 1, Integer.parseInt(new String(ch, start, length)));
            bTabla11 = false;
        } else if (bTabla12) {
            kitol.setElem(1, 2, Integer.parseInt(new String(ch, start, length)));
            bTabla12 = false;
        } else if (bTabla13) {
        	kitol.setElem(1, 3, Integer.parseInt(new String(ch, start, length)));
            bTabla13 = false;
        } else if (bTabla14) {
            kitol.setElem(1, 4, Integer.parseInt(new String(ch, start, length)));
            bTabla14 = false;
        } else if (bTabla15) {
        	kitol.setElem(1, 5, Integer.parseInt(new String(ch, start, length)));
            bTabla15 = false;
        } else if (bTabla20) {
            kitol.setElem(2, 0, Integer.parseInt(new String(ch, start, length)));
            bTabla20 = false;
        } else if (bTabla21) {
        	kitol.setElem(2, 1, Integer.parseInt(new String(ch, start, length)));
            bTabla21 = false;
        } else if (bTabla22) {
            kitol.setElem(2, 2, Integer.parseInt(new String(ch, start, length)));
            bTabla22 = false;
        } else if (bTabla23) {
        	kitol.setElem(2, 3, Integer.parseInt(new String(ch, start, length)));
            bTabla23 = false;
        } else if (bTabla24) {
            kitol.setElem(2, 4, Integer.parseInt(new String(ch, start, length)));
            bTabla24 = false;
        } else if (bTabla25) {
        	kitol.setElem(2, 5, Integer.parseInt(new String(ch, start, length)));
            bTabla25 = false;
        } else if (bTabla30) {
            kitol.setElem(3, 0, Integer.parseInt(new String(ch, start, length)));
            bTabla30 = false;
        } else if (bTabla31) {
        	kitol.setElem(3, 1, Integer.parseInt(new String(ch, start, length)));
            bTabla31 = false;
        } else if (bTabla32) {
            kitol.setElem(3, 2, Integer.parseInt(new String(ch, start, length)));
            bTabla32 = false;
        } else if (bTabla33) {
        	kitol.setElem(3, 3, Integer.parseInt(new String(ch, start, length)));
            bTabla33 = false;
        } else if (bTabla34) {
            kitol.setElem(3, 4, Integer.parseInt(new String(ch, start, length)));
            bTabla34 = false;
        } else if (bTabla35) {
        	kitol.setElem(3, 5, Integer.parseInt(new String(ch, start, length)));
            bTabla35 = false;
        } else if (bTabla40) {
            kitol.setElem(4, 0, Integer.parseInt(new String(ch, start, length)));
            bTabla40 = false;
        } else if (bTabla41) {
        	kitol.setElem(4, 1, Integer.parseInt(new String(ch, start, length)));
            bTabla41 = false;
        } else if (bTabla42) {
            kitol.setElem(4, 2, Integer.parseInt(new String(ch, start, length)));
            bTabla42 = false;
        } else if (bTabla43) {
        	kitol.setElem(4, 3, Integer.parseInt(new String(ch, start, length)));
            bTabla43 = false;
        } else if (bTabla44) {
            kitol.setElem(4, 4, Integer.parseInt(new String(ch, start, length)));
            bTabla44 = false;
        } else if (bTabla45) {
        	kitol.setElem(4, 5, Integer.parseInt(new String(ch, start, length)));
            bTabla45 = false;
        } else if (bTabla50) {
            kitol.setElem(5, 0, Integer.parseInt(new String(ch, start, length)));
            bTabla50 = false;
        } else if (bTabla51) {
        	kitol.setElem(5, 1, Integer.parseInt(new String(ch, start, length)));
            bTabla51 = false;
        } else if (bTabla52) {
            kitol.setElem(5, 2, Integer.parseInt(new String(ch, start, length)));
            bTabla52 = false;
        } else if (bTabla53) {
        	kitol.setElem(5, 3, Integer.parseInt(new String(ch, start, length)));
            bTabla53 = false;
        } else if (bTabla54) {
            kitol.setElem(5, 4, Integer.parseInt(new String(ch, start, length)));
            bTabla54 = false;
        } else if (bTabla55) {
        	kitol.setElem(5, 5, Integer.parseInt(new String(ch, start, length)));
            bTabla55 = false;
        }
    }
}