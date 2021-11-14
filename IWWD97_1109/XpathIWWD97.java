package IWWD97_1109;

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
import java.io.IOException;

public class xPathIWWD97 {
    public static void main(String[] args) {
        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("student.xml");
            document.getDocumentElement().normalize();
            XPath xPath= XPathFactory.newInstance().newXPath();
            //feladat1
            //String expression = "class/student";
            //feladat2
            //String expression = "class/student[@id=01]";
            //feladat3
            //String expression = "class/student";
            //feladat4
            //String expression = "class/student[2]";
            //feladat5
            //String expression = "class/student[last()]";
            //feladat6
            //String expression = "class/student[last()-1]";
            //feladat7
            //String expression = "class/student[position()<3]";
            //feladat8
            //String expression = "class/student";
            //feladat9
            //String expression = "class/student[@id]";
            //feladat10
            //String expression = "class/student";
            //feladat11
            //String expression = "class/student[kor>20]";
            //feladat12
            //String expression = "class/student"
            //NodeList nodelist = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
            //  for(int i = 0; i< nodelist.getLength();i++){
            //            Node node = nodelist.item(i);
            //                    System.out.println("\n Aktuális elem:" + node.getNodeName());
            //            if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")){
            //                Element element = (Element) node;
            //                System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnév").item(0).getTextContent());
            //                System.out.println("Vezetéknév: " + element.getElementsByTagName("vezetéknév").item(0).getTextContent());
            // }
        String expression = "class/student";
        NodeList nodelist = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        for(int i = 0; i< nodelist.getLength();i++){
            Node node = nodelist.item(i);
                    System.out.println("\n Aktuális elem:" + node.getNodeName());
            if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")){
                Element element = (Element) node;
                System.out.println("Halgató ID:"+ element.getAttribute("id"));
                System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnév").item(0).getTextContent());
                System.out.println("Vezetéknév: " + element.getElementsByTagName("vezetéknév").item(0).getTextContent());
                System.out.println("Becenév: " + element.getElementsByTagName("becenév").item(0).getTextContent());
                System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
            }

            }
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        catch (SAXException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (XPathExpressionException e){
            e.printStackTrace();
        }
    }
}
