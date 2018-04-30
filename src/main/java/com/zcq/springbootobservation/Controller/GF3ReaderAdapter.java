package com.zcq.springbootobservation.Controller;

import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.ReaderAdapter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static org.springframework.util.xml.DomUtils.getTextValue;

public class GF3ReaderAdapter implements ReaderAdapter  {

    @Override
    public AllType fileReader(String fileName) {

        AllType t = new AllType();

        try {
            File fXmlFile = new File(fileName);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//            doc.getDocumentElement().getChildNodes().item(0).getFirstChild().getChildNodes().item(0).getAttributes().getNamedItem("data").getNodeValue());

            Element rProduct = (Element) doc.getDocumentElement();

            Node segmentID = doc.getDocumentElement().getElementsByTagName("segmentID").item(0); //.getChildNodes();
            Node satellite = doc.getDocumentElement().getElementsByTagName("satellite").item(0); //.getChildNodes();
            Node sensor = doc.getDocumentElement().getElementsByTagName("sensor").item(0); //.getChildNodes();
            Node productID = doc.getDocumentElement().getElementsByTagName("productID").item(0); //.getChildNodes();
            Node sceneID = doc.getDocumentElement().getElementsByTagName("sceneID").item(0); //.getChildNodes();
            System.out.println("segmentID: " + segmentID.getFirstChild().getNodeValue());
            System.out.println("satellite: " + satellite.getFirstChild().getNodeValue());
            System.out.println("productId: " + productID.getFirstChild().getNodeValue());
            System.out.println("sceneId: " + sceneID.getFirstChild().getNodeValue());

            System.out.println("sensorId: " + sensor.getFirstChild().getNextSibling().getNodeValue());


        } catch (Exception e) {
            e.printStackTrace();
        }



        return t;
    }


}
