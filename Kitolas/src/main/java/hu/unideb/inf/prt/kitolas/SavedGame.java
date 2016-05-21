package hu.unideb.inf.prt.kitolas;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import hu.unideb.inf.prt.kitolas.controller.KitolasController;

public class SavedGame {
	
	public static void XMLRead() {
		File xml = new File("/Users/lac/Desktop/progtech/kitolas_project/Kitolas/src/main/resources/kimentes.xml");
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xml);
			
			doc.getDocumentElement().normalize();
			
			NodeList list = doc.getElementsByTagName("lastGame");
			
			for (int i = 0; i < list.getLength(); i++){
				Node node = list.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) node;
					
					KitolasController.kt.setKorSzam(element.getElementsByTagName("korSzam").item(0).getTextContent());
					KitolasController.kt.setLepesSzam(element.getElementsByTagName("lepesSzam").item(0).getTextContent());
					KitolasController.kt.setTablanB(element.getElementsByTagName("tablanB").item(0).getTextContent());
					KitolasController.kt.setLevettB(element.getElementsByTagName("levettB").item(0).getTextContent());
					KitolasController.kt.setTablanW(element.getElementsByTagName("tablanW").item(0).getTextContent());
					KitolasController.kt.setLevettW(element.getElementsByTagName("levettW").item(0).getTextContent());
					
					for (int sor = 0; sor < 6; sor ++) {
						String sorStr = element.getElementsByTagName("tabla").item(sor).getTextContent();
						char[] cha =  sorStr.toCharArray();
						
						for (int y = 0; y < 6; y++) {
							KitolasController.kt.setElem(sor, y, Integer.parseInt(cha[y] + ""));
						}
					}
					
					System.out.println(element.getElementsByTagName("korSzam").item(0).getTextContent());
					for (int x = 0; x < 6; x++) {
						for (int j = 0; j < 6; j++) {
							System.out.print(KitolasController.kt.getElem(x, j));
						}
						System.out.println();
					}
				}
				
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}
	}
	
	public static void XMLWrite() throws TransformerException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.newDocument();
		
		Element rootElement = doc.createElement("kitolas");
		doc.appendChild(rootElement);
		
		Element element = doc.createElement("lastGame");
		rootElement.appendChild(element);
		
		Element korSzamElement = doc.createElement("korSzam");
		korSzamElement.appendChild(doc.createTextNode(KitolasController.kt.getKorSzam()));
		element.appendChild(korSzamElement);
		
		Element lepesSzamElement = doc.createElement("lepesSzam");
		lepesSzamElement.appendChild(doc.createTextNode(KitolasController.kt.getLepesSzam()));
		element.appendChild(lepesSzamElement);
		
		Element tablanBElement = doc.createElement("tablanB");
		tablanBElement.appendChild(doc.createTextNode(KitolasController.kt.getTablanB()));
		element.appendChild(tablanBElement);
		
		Element levettBElement = doc.createElement("levettB");
		levettBElement.appendChild(doc.createTextNode(KitolasController.kt.getLevettB()));
		element.appendChild(levettBElement);
		
		Element tablanWElement = doc.createElement("tablanW");
		tablanWElement.appendChild(doc.createTextNode(KitolasController.kt.getTablanW()));
		element.appendChild(tablanWElement);
		
		Element levettWElement = doc.createElement("levettW");
		levettWElement.appendChild(doc.createTextNode(KitolasController.kt.getLevettW()));
		element.appendChild(levettWElement);
		
		for(int i = 0; i < 6; i++) {
			StringBuilder sor = new StringBuilder();
			for(int j = 0; j < 6; j++) {
				sor.append(Integer.toString(KitolasController.kt.getElem(i, j)));
			}
			Element tablaElement = doc.createElement("tabla");
			tablaElement.appendChild(doc.createTextNode(sor.toString()));
			element.appendChild(tablaElement);
		}
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("/Users/lac/Desktop/progtech/kitolas_project/Kitolas/src/main/resources/kimentes.xml"));
		t.transform(source,  result);
	}
}
