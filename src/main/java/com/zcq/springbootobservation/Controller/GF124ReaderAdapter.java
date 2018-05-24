package com.zcq.springbootobservation.Controller;

import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.GF124Type;
import com.zcq.springbootobservation.Service.ProductService;
import com.zcq.springbootobservation.Service.ReaderAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class GF124ReaderAdapter implements ReaderAdapter  {

    @Autowired
    ProductService productService = new ProductService();

    @Override
    public AllType fileReader(String fileName,String path) {

        AllType allType = new AllType();

        try {
            File fXmlFile = new File(fileName);

            JAXBContext jaxbContext = JAXBContext.newInstance(GF124Type.class);
            Unmarshaller jaxbUnmarshal = jaxbContext.createUnmarshaller();
            GF124Type gf2 = (GF124Type)jaxbUnmarshal.unmarshal(fXmlFile);
            allType.setProductID(gf2.getProductID());
            allType.setSatelliteID(gf2.getSatellite());
            allType.setSensorID(gf2.getSensorID());
            allType.setSceneID(gf2.getSceneID());
            String temp = gf2.getProductLevel();

            String s = temp.substring(5,temp.length()-1);

            allType.setLevel(s);
            allType.setNominalResolution("");
            allType.setImagingMode(null);

            String time = gf2.getProduceTime();
            String t = time.substring(0,10);
            //System.out.println(t);
            allType.setProduceTime(t);

            allType.setCloudPercent(gf2.getCloudPercent());
            allType.setLeftTopLat(gf2.getTopLeftLatitude());
            allType.setLeftTopLng(gf2.getTopLeftLongitude());
            allType.setRightBottomLat(gf2.getBottomRightLatitude());
            allType.setRightBottomLng(gf2.getBottomRightLongitude());

            allType.setAddress(path);
            //System.out.println("数据地址: "+allType.getAddress());



        } catch (Exception e) {
            e.printStackTrace();
        }



        return allType;
    }


}
