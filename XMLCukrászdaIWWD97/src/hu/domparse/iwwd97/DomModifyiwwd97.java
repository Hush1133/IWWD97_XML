package hu.domparse.iwwd97;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomModifyiwwd97 {
    public static void main(String[] args) {
    NodeList list;
		try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // fájl beolvasása
        Document document = builder.parse(new File("xml_bemenet.xml"));
        document.getDocumentElement().normalize();
        // Aktuális elem meghatározása
        list = document.getElementsByTagName("Customer");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            // Aktuális elem Kiírása
            System.out.println("\nCurrent element: " + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                //CustomerID eltárolása egy stringbe
                String customercode=element.getAttribute("CustomerID");
                //első vásárló adatinak kiírása
                System.out.println("Vásárló neve : "
                        + element.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println("Vásárló ID: " + element.getAttribute("CustomerID"));
                System.out.println("Fizetett összeg : "
                        +element.getElementsByTagName("PaidAmount").item(0).getTextContent() );
                System.out.println("Kiszolgálta : "
                        +element.getElementsByTagName("Servedby").item(0).getTextContent() );

                Node cutomernode = list.item(i);
                if (cutomernode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element1 = (Element) node;
                    //customercode vizsgálata és ha megegyezzik 1-el akkor Név módosítása Második Vásárló
                    if (customercode.equals("1")) {
                        element1.getElementsByTagName("Name").item(0).setTextContent("Második Vásárló");

                    }
                    //Új vásárló adatainak kiírása
                    System.out.println("\n Az új vásárló neve: "
                            + element1.getElementsByTagName("Name").item(0).getTextContent());
                    System.out.println("Vásárló ID: " + element1.getAttribute("CustomerID"));
                    System.out.println("Fizetett összeg : "
                            +element.getElementsByTagName("PaidAmount").item(0).getTextContent() );
                    System.out.println("Kiszolgálta : "
                            +element.getElementsByTagName("Servedby").item(0).getTextContent() );

                }
            }
        }
            //Lekérdezi az adatoktak és beleírja egy fájlba
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Source input=new DOMSource(document);
            Result output = new StreamResult(new File("XMLIWWD97Lekérdzett.xml"));
            transformer.transform(input, output);

    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}
