import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ObjectIWWD97 {
    public static void main(String[] args) {
        NodeList list;
        try {
            DocumentBuilderFactory documentBuilderFactoryfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactoryfactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("CRC7FC_11.30/JSONCRC7FC.xml"));
            document.getDocumentElement().normalize();
            list = document.getElementsByTagName("students");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                System.out.println("Jelenlegi elem: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("{'Név':"
                            + element.getElementsByTagName("nev").item(0).getTextContent()+
                    ",'Fizetes': "
                            + element.getElementsByTagName("fizetes").item(0).getTextContent()
                    + ",'Kor': "
                            + element.getElementsByTagName("kor").item(0).getTextContent() + "}");

                }

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}