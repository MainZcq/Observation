package com.zcq.springbootobservation.Service;

//import org.springframework.context.annotation.Bean;

import com.zcq.springbootobservation.Entity.ProductType;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataScanner{
    private static final String GF3 = "GF3";
    private static final String GF2 = "GF2";
    public static void  scanner(){
        File f = new File("e:\\test");
        ArrayList<File> al = new ArrayList();
        showList(f,al);
        System.out.println(al.size());

        //将集合数据写入到文件
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter("E:\\test.txt"));
            ProductType productType = new ProductType();
            for (File ff : al) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(ff), "GBK");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                bw.write(ff.getAbsolutePath());
                String lineTxt = null;
                int c = 0;
                System.out.println(ff.getAbsolutePath());
                String path = ff.getAbsolutePath();

                Pattern patternGF3 = Pattern.compile(GF3);
                Matcher matcherGF3 = patternGF3.matcher(path);
                if (matcherGF3.find()) {

                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        c++;
                        //GF3相关数据入库
                        Pattern satellite = Pattern.compile("<satellite>(\\w+)</satellite>");
                        Pattern productId = Pattern.compile("<productID>(\\w+)</productID>");
                        Pattern imagingMode = Pattern.compile("<imagingMode>(\\w+)</imagingMode>");
                        Pattern sensorID = Pattern.compile("<sensorID>(\\w+)</sensorID>");
                        Pattern centerTime = Pattern.compile("<CenterTime>([\\w|\\-|\\:|\\.|\\s]+)</CenterTime>");
                        Pattern nominalResolution = Pattern.compile("<NominalResolution>([\\w|\\.]+)</NominalResolution>");
                        Pattern productLevel = Pattern.compile("<productLevel>(\\w+)</productLevel>");
                        Pattern topleft = Pattern.compile("<topLeft>([\\w|\\.|\\<|\\>]+)</topLeft>");

                        Matcher ms = satellite.matcher(lineTxt);
                        Matcher mp = productId.matcher(lineTxt);
                        Matcher mImg = imagingMode.matcher(lineTxt);
                        Matcher msen = sensorID.matcher(lineTxt);
                        Matcher mc = centerTime.matcher(lineTxt);
                        Matcher mn = nominalResolution.matcher(lineTxt);
                        Matcher ml = productLevel.matcher(lineTxt);
                        Matcher mtl = topleft.matcher(lineTxt);
                        if (ms.find()) {
                            System.out.println(" 卫星satelliteID:" + ms.group(1));
                            bw.newLine();
                            bw.write(" satelliteID:" + ms.group(1));
                            productType.setSatelliteID(ms.group(1));
                        }
                        if (mp.find()) {
                            System.out.println(" 产品ProductID:" + mp.group(1));
                            bw.newLine();
                            bw.write(" ProductID:" + mp.group(1));
                            productType.setProductID(mp.group(1));
                        }
                        if (mImg.find()) {
                            System.out.println(" 图像模式imagingMode:" + mImg.group(1));
                            bw.newLine();
                            bw.write(" imagingMode:" + mImg.group(1));
                            productType.setImagingMode(mImg.group(1));
                        }
                        if (msen.find()) {
                            System.out.println(" 传感器sensorID:" + msen.group(1));
                            bw.newLine();
                            bw.write(" sensorID:" + msen.group(1));
                            productType.setSensorID(msen.group(1));
                        }
                        if (mc.find()) {
                            String t = mc.group(1);
                            String temp = t.substring(0, 10);
                            System.out.println(" 采集时间CenterTime:" + temp);
                            bw.newLine();
                            bw.write(" CenterTime:" + temp);
                            productType.setProduceTime(temp);
                        }
                        if (mn.find()) {
                            System.out.println(" 分辨率NominalResolution:" + mn.group(1));
                            bw.newLine();
                            bw.write(" NominalResolution:" + c);
                            productType.setNominalResolution(mn.group(1));
                        }
                        if (ml.find()) {
                            System.out.println(" 传感器productLevel:" + ml.group(1));
                            bw.newLine();
                            bw.write(" productLevel:" + ml.group(1));
                            productType.setLevel(ml.group(1));
                        }
                        if (mtl.find()) {
                            System.out.println(" 左上:" + mtl.group(1) + "当前："+lineTxt);

                        }
                    }
                }
                //GF2数据入库
                Pattern patternGF2 = Pattern.compile(GF2);
                Matcher matcherGF2 = patternGF2.matcher(path);
                if (matcherGF2.find()) {

                    System.out.println("GF2已找到");
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        Pattern satellite = Pattern.compile("<SatelliteID>(\\w+)</SatelliteID>");
                        Pattern productId = Pattern.compile("<ProductID>(\\w+)</ProductID>");
                        Pattern imagingMode = Pattern.compile("<imagingMode>(\\w+)</imagingMode>");
                        Pattern sensorID = Pattern.compile("<SensorID>(\\w+)</SensorID>");
                        Pattern centerTime = Pattern.compile("<ProduceTime>(\\w+)</ProduceTime>");
                        Pattern nominalResolution = Pattern.compile("<NominalResolution>(\\w+)</NominalResolution>");
                        Pattern productLevel = Pattern.compile("<productLevel>(\\w+)</productLevel>");

                        Matcher ms = satellite.matcher(lineTxt);
                        Matcher mp = productId.matcher(lineTxt);
                        Matcher mImg = imagingMode.matcher(lineTxt);
                        Matcher msen = sensorID.matcher(lineTxt);
                        Matcher mc = centerTime.matcher(lineTxt);
                        Matcher mn = nominalResolution.matcher(lineTxt);
                        Matcher ml = productLevel.matcher(lineTxt);

                        if (ms.find()) {
                            System.out.println(" 卫星satelliteID:" + ms.group(1));
                            bw.newLine();
                            bw.write(" satelliteID:" + ms.group(1));
                            productType.setSatelliteID(ms.group(1));
                        }
                        if (mp.find()) {
                            System.out.println(" 产品ProductID:" + mp.group(1));
                            bw.newLine();
                            bw.write(" ProductID:" + mp.group(1));
                            productType.setProductID(mp.group(1));
                        }
                        if (mImg.find()) {
                            System.out.println(" 图像模式imagingMode:" + mImg.group(1));
                            bw.newLine();
                            bw.write(" imagingMode:" + mImg.group(1));
                            productType.setImagingMode(mImg.group(1));
                        }
                        if (msen.find()) {
                            System.out.println(" 传感器sensorID:" + msen.group(1));
                            bw.newLine();
                            bw.write(" sensorID:" + msen.group(1));
                            productType.setSensorID(msen.group(1));
                        }
                        if (mc.find()) {
                            String temp = lineTxt.substring(mc.start() + 12, 30);
                            System.out.println(" 采集时间CenterTime:" + temp);
                            bw.newLine();
                            bw.write(" CenterTime:" + temp);
                            productType.setProduceTime(temp);
                        }
                        if (mn.find()) {
                            System.out.println(" 分辨率NominalResolution:" + c);
                            bw.newLine();
                            bw.write(" NominalResolution:" + c);

                        }
                        if (ml.find()) {
                            System.out.println(" 传感器productLevel:" + ml.group(1));
                            bw.newLine();
                            bw.write(" productLevel:" + ml.group(1));
                            productType.setLevel(ml.group(1));
                        }

                    }
                }

                read.close();
                bw.newLine();
                bw.flush();


            }
        }catch(IOException e){
            throw new RuntimeException("发生错误！");
        }
        finally{
            try{
                if(bw!=null)
                    bw.close();
            }catch(IOException e){e.printStackTrace();}
        }
    }

    //采用递归方式遍历指定文件夹，扫描java类型文件
    public static void showList(File f, ArrayList<File> al){
        File []fArr = f.listFiles();
        //if(fArr != null)
        for(File p : fArr){
            if(p.isDirectory()){
                showList(p, al);
            }
            else{
                if((p.getName()).endsWith(".xml"))
                    al.add(p);
            }
        }
    }

}

