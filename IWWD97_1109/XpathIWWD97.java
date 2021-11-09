package IWWD97_1109;

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

public class xPathIWWD97 {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        File xmlFile = new File("studentIWWD97.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();
        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression1 = "/class/student[@rollno = '393']/lastname/text()";
        NodeList nodeList = (NodeList) xPath.compile(expression1).evaluate(doc, XPathConstants.NODESET);

        nodeList.item(0).setNodeValue("Zöld");

        String expression2 = "/class/student[@rollno = '393']";
        nodeList = (NodeList) xPath.compile(expression2).evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);

            System.out.println("\nCurrent Element : " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                System.out.println("Student roll no : " + eElement.getAttribute("rollno"));

                System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());

                System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());

                System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());

                System.out.println("Marks : " + eElement.getElementsByTagName("marks").item(0).getTextContent());
            }
        }
    }
}

