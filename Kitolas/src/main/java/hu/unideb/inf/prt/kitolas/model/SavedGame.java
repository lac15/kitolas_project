package hu.unideb.inf.prt.kitolas.model;

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

import hu.unideb.inf.prt.kitolas.controller.KitolasViewController;

/**
* A kitolás nevű kétszemélyes táblajáték megvalósítása.
* A mentett állás beolvasására és új mentés létrehozására
* szolgáló osztály.
*
* @author  Erdőhegyi László
* @since   2016-05-13
*/
public class SavedGame {
	private static Logger logger = LoggerFactory.getLogger(SavedGame.class);
	
	/**
	 * Beolvassa a mentett játékot.
	 * @return Egy KitolasData mely tartalmazza a beolvasott adatokat.
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public KitolasData XMLRead() throws ParserConfigurationException, SAXException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File xml = new File(classLoader.getResource("kimentes.xml").getFile());

		KitolasData kd = new KitolasData();
		
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
		
		return kd;
	}

	/**
	 * Egy adott állás (KitolasData) mentését valósítja meg.
	 * @param kd Az a KitolasData melyet menteni fog.
	 * @throws TransformerException
	 * @throws ParserConfigurationException
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

		ClassLoader classLoader = getClass().getClassLoader();
		
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(classLoader.getResource("kimentes.xml").getFile()));
		t.transform(source, result);
		
		logger.info("Az állás mentésre került.");
	}
}
