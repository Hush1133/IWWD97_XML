package Dom_IWWD97_1026;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class DomIWWD97 {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        File xmlFile = new File("usersIWWD97.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Gyökér elem: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("user");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String uid = elem.getAttribute("id");

                String ce = elem.getNodeName();

                Node node1 = elem.getElementsByTagName("firstname").item(0);
                String first = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("lastname").item(0);
                String last = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("profession").item(0);
                String profession = node3.getTextContent();

                System.out.println("id: " + uid);
                System.out.println("\tElement current: " + ce);
                System.out.println("\tFirst: " + first);
                System.out.println("\tLast: " + last);
                System.out.println("\tProfession: " + profession);

            }
        }
    }
}