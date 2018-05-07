package com.zcq.springbootobservation.Service;

//import org.springframework.context.annotation.Bean;

import com.zcq.springbootobservation.Controller.GF124ReaderAdapter;
import com.zcq.springbootobservation.Controller.GF3ReaderAdapter;
import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataScanner{
    private static final String GF3 = "GF3";
    private static final String GF2 = "GF2";
    private static final String GF1 = "GF1";
    private static final String GF4 = "GF4";

    public static List<AllType>  scanner(){
        File f = new File("e:\\test");
        ArrayList<File> al = new ArrayList();
        showList(f,al);
        System.out.println(al.size());

        List<AllType> allTypeList = new ArrayList<AllType>();
        try {
            ProductType productType = new ProductType();
            for (File ff : al) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(ff), "GBK");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int c = 0;
                System.out.println(ff.getAbsolutePath());
                String path = ff.getAbsolutePath();
                ReaderAdapter readerAdapter = new GF3ReaderAdapter();

                Pattern patternGF3 = Pattern.compile(GF3);
                Matcher matcherGF3 = patternGF3.matcher(path);
                if (matcherGF3.find()) {
                    AllType allType = new AllType();
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        Pattern satellite = Pattern.compile("<product>");
                        Matcher ms = satellite.matcher(lineTxt);
                        if (ms.find()) {
                            System.out.println("GF3已找到");
                            try {
                                allType = readerAdapter.fileReader
                                        (ff.getAbsolutePath());
                                allTypeList.add(allType);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }

                //GF124数据入库
                ReaderAdapter readerAdapter1 = new GF124ReaderAdapter();
                Pattern patternGF2 = Pattern.compile(GF2);
                Matcher matcherGF2 = patternGF2.matcher(path);
                Pattern patternGF1 = Pattern.compile(GF1);
                Matcher matcherGF1 = patternGF1.matcher(path);
                Pattern patternGF4 = Pattern.compile(GF4);
                Matcher matcherGF4 = patternGF4.matcher(path);
                if (matcherGF2.find() || matcherGF1.find() || matcherGF4.find()) {
                    AllType allType = new AllType();
                    try {
                        allType=readerAdapter1.fileReader
                                (ff.getAbsolutePath());
                        allTypeList.add(allType);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        } catch (IOException e) {
            throw new RuntimeException("发生错误！");
        }

        return allTypeList;
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

