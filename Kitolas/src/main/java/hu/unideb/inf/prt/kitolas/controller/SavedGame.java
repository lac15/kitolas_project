package hu.unideb.inf.prt.kitolas.controller;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import hu.unideb.inf.prt.kitolas.model.KitolasData;

/** 
* A mentett állás beolvasására és új mentés létrehozására szolgáló osztály.
*
* @author Erdőhegyi László
* @since 2016-05-13
*/
public class SavedGame {
	private static Logger logger = LoggerFactory.getLogger(SavedGame.class);
	
	private String osName = System.getProperty("os.name").toLowerCase();
	
	private String userName = System.getProperty("user.name");
	
	private String windowsFilePath = "C:" + File.separator + "Users" + File.separator + 
    		userName + File.separator + "Documents" + File.separator + "kimentes.xml";
	
	private String linuxFilePath = File.separator + "home" + File.separator + userName + 
			File.separator + "kimentes.xml";
	
	/**
	 * Beolvassa a mentett játékot egy XML állományból.
	 * 
	 * Az XML állományt operációs rendszertől függően máshol keresi.
	 * Windows: {@code C:\Users\}felhasználónév{@code \Documents\kimentes.xml}
	 * Linux: {@code /home/}felhasználónév{@code /kimentes.xml}
	 * 
	 * @return egy állás ({@link KitolasData}), mely tartalmazza a beolvasott állást
	 * @throws ParserConfigurationException parser configuration exception
	 * @throws SAXException sax exception
	 * @throws IOException io exception
	 */
	public KitolasData XMLRead() throws ParserConfigurationException, SAXException, IOException {
		File xml = null;
		
		if (osName.contains("windows")) {
			xml = new File(windowsFilePath);
		}
		else if (osName.contains("linux") || osName.contains("unix")) {
			xml = new File(linuxFilePath);
		}
		else {
			logger.warn("Nem ismert operációs rendszer. Nem lehet betölteni a fájlt.");
		}

		KitolasData kd = new KitolasData();
		
		if (xml != null) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xml);
	
			doc.getDocumentElement().normalize();
	
			NodeList list = doc.getElementsByTagName("lastGame");
	
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
	
					kd.setKorSzam(element.getElementsByTagName("korSzam").item(0).getTextContent());
					kd.setLepesSzam(element.getElementsByTagName("lepesSzam").item(0).getTextContent());
					kd.setTablanB(element.getElementsByTagName("tablanB").item(0).getTextContent());
					kd.setLevettB(element.getElementsByTagName("levettB").item(0).getTextContent());
					kd.setTablanW(element.getElementsByTagName("tablanW").item(0).getTextContent());
					kd.setLevettW(element.getElementsByTagName("levettW").item(0).getTextContent());
	
					for (int sor = 0; sor < 6; sor++) {
						String sorStr = element.getElementsByTagName("tabla").item(sor).getTextContent();
						char[] cha = sorStr.toCharArray();
	
						for (int y = 0; y < 6; y++) {
							kd.setElem(sor, y, Integer.parseInt(cha[y] + ""));
						}
					}
				}
			}
			
			logger.info("A mentett állás betöltődött.");
		}
		
		return kd;
	}

	/**
	 * Egy adott állás ({@link KitolasData}) mentését valósítja meg egy XML állományba.
	 * 
	 * Az XML állományt operációs rendszertől függően máshova helyezi.
	 * Windows: {@code C:\Users\}felhasználónév{@code \Documents\kimentes.xml}
	 * Linux: {@code /home/}felhasználónév{@code /kimentes.xml}
	 * 
	 * @param kd az az állás ({@link KitolasData}) amelyet menteni akarunk
	 * @throws TransformerException transformer exception
	 * @throws ParserConfigurationException parser configuration exception
	 */
	public void XMLWrite(KitolasData kd) throws TransformerException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.newDocument();

		Element rootElement = doc.createElement("kitolas");
		doc.appendChild(rootElement);

		Element element = doc.createElement("lastGame");
		rootElement.appendChild(element);

		Element korSzamElement = doc.createElement("korSzam");
		korSzamElement.appendChild(doc.createTextNode(kd.getKorSzam()));
		element.appendChild(korSzamElement);

		Element lepesSzamElement = doc.createElement("lepesSzam");
		lepesSzamElement.appendChild(doc.createTextNode(kd.getLepesSzam()));
		element.appendChild(lepesSzamElement);

		Element tablanBElement = doc.createElement("tablanB");
		tablanBElement.appendChild(doc.createTextNode(kd.getTablanB()));
		element.appendChild(tablanBElement);

		Element levettBElement = doc.createElement("levettB");
		levettBElement.appendChild(doc.createTextNode(kd.getLevettB()));
		element.appendChild(levettBElement);

		Element tablanWElement = doc.createElement("tablanW");
		tablanWElement.appendChild(doc.createTextNode(kd.getTablanW()));
		element.appendChild(tablanWElement);

		Element levettWElement = doc.createElement("levettW");
		levettWElement.appendChild(doc.createTextNode(kd.getLevettW()));
		element.appendChild(levettWElement);

		for (int i = 0; i < 6; i++) {
			StringBuilder sor = new StringBuilder();
			for (int j = 0; j < 6; j++) {
				sor.append(Integer.toString(kd.getElem(i, j)));
			}
			Element tablaElement = doc.createElement("tabla");
			tablaElement.appendChild(doc.createTextNode(sor.toString()));
			element.appendChild(tablaElement);
		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		
		DOMSource source = new DOMSource(doc);
		
		File xml = null;
		
		if (osName.contains("windows")) {
			xml = new File(windowsFilePath);
		}
		else if (osName.contains("linux") || osName.contains("unix")) {
			xml = new File(linuxFilePath);
		}
		else {
			logger.warn("Nem ismert operációs rendszer. Nem lehet menteni a fájlt.");	
		}
		
		if (xml != null && !xml.exists()) {
			try {
				xml.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		StreamResult result = new StreamResult(xml);
		t.transform(source, result);
		
		logger.info("Az állás mentésre került.");
	}
}
