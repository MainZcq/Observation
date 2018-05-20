package com.zcq.springbootobservation.Controller;

import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.GF3Type;
import com.zcq.springbootobservation.Service.ProductService;
import com.zcq.springbootobservation.Service.ReaderAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class GF3ReaderAdapter implements ReaderAdapter  {

    @Autowired
    private ProductService productService;
    @Override
    public AllType fileReader(String fileName,String path) {

        AllType allType = new AllType();

        try {
            File fXmlFile = new File(fileName);

            JAXBContext jaxbContext = JAXBContext.newInstance(GF3Type.class);
            Unmarshaller jaxbUnmarshal = jaxbContext.createUnmarshaller();
            GF3Type gf3 = (GF3Type)jaxbUnmarshal.unmarshal(fXmlFile);
            //System.out.println(fileName);
            allType.setProductID(gf3.getProductID());
            allType.setSatelliteID(gf3.getSatellite());
            allType.setSensorID(gf3.getSensorID());
            allType.setSceneID(gf3.getSceneID());
            allType.setLevel(gf3.getProductLevel());
            allType.setNominalResolution(gf3.getNominalResolution());
            allType.setImagingMode(gf3.getImagingMode());
            allType.setProduceTime(gf3.getProductGentime());
            allType.setCloudPercent("0");
            allType.setLeftTopLat(gf3.getTopLeftLat());
            allType.setLeftTopLng(gf3.getTopLeftLng());
            allType.setRightBottomLat(gf3.getBottomRightLat());
            allType.setRightBottomLng(gf3.getBottomRightLng());
            allType.setAddress(path);
            System.out.println("productID: "+allType.getAddress());



        } catch (Exception e) {
            e.printStackTrace();
        }


        return allType;
    }


}
