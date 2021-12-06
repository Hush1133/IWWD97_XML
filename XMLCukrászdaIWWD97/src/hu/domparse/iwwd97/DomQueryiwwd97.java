package hu.domparse.iwwd97;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class DomQueryiwwd97 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //fájl bolvasása
            Document document = builder.parse(new File("xml_bemenet.xml"));
            document.getDocumentElement().normalize();
            XPath xPath= XPathFactory.newInstance().newXPath();
            //Csak a cukrász sütemények lekérése (ID>=11)
            String expression="root/Products/Product[@ProductID>=11]";

            //lista készítés
            NodeList nodeList=(NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
            //for ciklus nodlist csomópontjainak végig itrálása
            for (int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                //aktuális elem kiírása
                System.out.println ("\nAktuális elem: " + node.getNodeName());

                //Péksütemény termékek listázása
                if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("Product")){
                    Element element=(Element) node;
                    System.out.println("Termék id : " + element.getAttribute("ProductID"));
                    System.out.println("Cukrász id : " + element.getAttribute("PastryCookKey2"));
                    System.out.println("Termék neve : " + element.getElementsByTagName("ProductName").item(0).getTextContent());
                    System.out.println("Elkészítési idő : " + element.getElementsByTagName("Timetobake").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException e){
            e.printStackTrace();
        }
    }

}
