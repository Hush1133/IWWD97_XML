package hu.domparse.iwwd97;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReadiwwd97 {
    public static void main(String[] args) {
    NodeList list;
        try {
        DocumentBuilderFactory documentBuilderFactoryfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactoryfactory.newDocumentBuilder();

        // beolvassuk a fájlt
        Document document = documentBuilder.parse(new File("xml_bemenet.xml"));
        document.getDocumentElement().normalize();
        //meghatározzuk az aktuális elemet
        list = document.getElementsByTagName("Customer");
        for(int i = 0; i<list.getLength(); i++) {
            Node node = list.item(i);
            //aktuális elem kiírása
            System.out.println("Jelenlegi elem: " + node.getNodeName());

            //Vásárló adatainak kiírása
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Vásárló ID: " + element.getAttribute("CustomerID"));
                System.out.println("Vásárló neve: "
                        + element.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println("Kiszolgálta : "
                        + element.getElementsByTagName("Servedby").item(0).getTextContent());
                System.out.println("Fizetett összeg : "
                        + element.getElementsByTagName("PaidAmount").item(0).getTextContent());

            }

        }
        list = document.getElementsByTagName("Product");
        for(int j = 0; j<list.getLength(); j++) {
            //Termékek kiírása
            Node arunode = list.item(j);
            //aktuális elem kiírása
            System.out.println("\nJelenlegi elem: " + arunode.getNodeName());
            if (arunode.getNodeType() == Node.ELEMENT_NODE) {
                Element elementproduct = (Element) arunode;
                //cukrászda termékei
                System.out.println("Termék ID : " + elementproduct.getAttribute("ProductID"));
                System.out.println("Termék neve: " + elementproduct.getElementsByTagName("ProductName").item(0).getTextContent());
                System.out.println("Tejkaramella alapú, vagy sütemény : " + elementproduct.getElementsByTagName("PastriesButterscotch").item(0).getTextContent());
                System.out.println("Elkészítési idő : " + elementproduct.getElementsByTagName("Timetobake").item(0).getTextContent());

            }

        }
        list =document.getElementsByTagName("Sweetshops");
        Node sweetshopknode = list.item(0);
            //aktuális elem kiírása
        System.out.println("\nJelenlegi elem: " + sweetshopknode.getNodeName());
        if (sweetshopknode.getNodeType() == Node.ELEMENT_NODE) {
            Element dokelement = (Element) sweetshopknode;
            for(int k = 0; k<list.getLength(); k++) {
                list = document.getElementsByTagName("Sweetshop");
                Node donode = list.item(k);
                //aktuális elem kiírása
                System.out.println("\nJelenlegi elem: " + donode.getNodeName());
                if (donode.getNodeType() == Node.ELEMENT_NODE) {
                    Element doelement = (Element) donode;
                    //Cukrászdák adatainak kiiratása
                    String TimeOpen = doelement.getAttribute("TimeOpen");
                    System.out.println("Cukrászda ID : " + doelement.getAttribute("TimeOpen"));
                    System.out.println("Cukrászda neve: "
                            + doelement.getElementsByTagName("ShopName").item(0).getTextContent());
                    if (donode.getNodeType() == Node.ELEMENT_NODE) {
                        Element elementcim = (Element) donode;
                        System.out.println("Lakcím : ");
                        System.out.println("Város : " + elementcim.getElementsByTagName("City").item(0).getTextContent());
                        System.out.println("Utca, házszám : " + elementcim.getElementsByTagName("StreetSTnumber").item(0).getTextContent());


                    }
                }
            }
        }
        //cukrászok adatainak kiírása
        list =document.getElementsByTagName("PastryCooks");
        Node Cnode = list.item(0);
            //aktuális elem kiírása
        System.out.println("\nJelenlegi elem: " + Cnode.getNodeName());
        list = document.getElementsByTagName("PastryCook");
        for(int k = 0; k<list.getLength(); k++) {
            Node Cukrasznode = list.item(k);
            //aktuális elem kiírása
            System.out.println("\nJelenlegi elem: " + Cukrasznode.getNodeName());
            if (Cukrasznode.getNodeType() == Node.ELEMENT_NODE) {
                Element Dolgelement = (Element) Cukrasznode;
                //Vásárlók adatainak kiírása
                System.out.println("Cukrász neve: " + Dolgelement.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println("Munkahely ID: " + Dolgelement.getAttribute("SweetshopID"));
                System.out.println("Szemely ig. szám : " + Dolgelement.getAttribute("IDnumber"));
                System.out.println("Beosztása " + Dolgelement.getElementsByTagName("Post").item(0).getTextContent());

                if (Cukrasznode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementdolgcim = (Element) Cukrasznode;
                    System.out.println("Lakcíme : ");
                    System.out.println("Város : " + elementdolgcim.getElementsByTagName("City").item(0).getTextContent());
                    System.out.println("Utca : " + elementdolgcim.getElementsByTagName("Street").item(0).getTextContent());
                    System.out.println("Házszám : " + elementdolgcim.getElementsByTagName("StreetNumber").item(0).getTextContent());

                }

            }
        }  // dolgozók végzettségének kiírása
            list =document.getElementsByTagName("Qualifications");
                    Node Knode = list.item(0);
            //aktuális elem kiírása
            System.out.println("\nJelenlegi elem: " + Knode.getNodeName());
            list = document.getElementsByTagName("Qualification");
            for(int j = 0; j<list.getLength(); j++) {
                Node arunode = list.item(j);
                //aktuális elem kiírása
                System.out.println("\nJelenlegi elem: " + arunode.getNodeName());
                if (arunode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementvegzettseg = (Element) arunode;
                    //cukrászda termékei
                    System.out.println("Végzettség ID : " + elementvegzettseg.getAttribute("ID"));
                    System.out.println("Végzettség neve: " + elementvegzettseg.getElementsByTagName("EducationLevel").item(0).getTextContent());
                }

            }
            //felszerelések listázása
            list =document.getElementsByTagName("Equipments");
            Node felszernode = list.item(0);
            //aktuális elem kiírása
            System.out.println("\nJelenlegi elem : " + felszernode.getNodeName());
            list = document.getElementsByTagName("Equipment");
            for(int k = 0; k<list.getLength(); k++) {
                Node enode = list.item(k);
                //aktuális elem kiírása
                System.out.println("\nJelenlegi elem : " + enode.getNodeName());
                if (enode.getNodeType() == Node.ELEMENT_NODE) {
                    Element Telement = (Element) enode;
                    //Termékek adatainak kiírása
                    System.out.println("Felszerelés id : " + Telement.getAttribute("ID"));
                    System.out.println("Felszerelés neve : " + Telement.getElementsByTagName("EquipmentName").item(0).getTextContent());
                    System.out.println("Felszerelés állapota : " + Telement.getElementsByTagName("State").item(0).getTextContent());
                }
            }


        } catch (
    ParserConfigurationException e) {
        e.printStackTrace();
    } catch (
    IOException e) {
        e.printStackTrace();
    } catch (
    SAXException e) {
        e.printStackTrace();
    }
}
}
