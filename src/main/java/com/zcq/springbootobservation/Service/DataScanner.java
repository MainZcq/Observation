package com.zcq.springbootobservation.Service;

//import org.springframework.context.annotation.Bean;

import com.zcq.springbootobservation.Controller.GF124ReaderAdapter;
import com.zcq.springbootobservation.Controller.GF3ReaderAdapter;
import com.zcq.springbootobservation.Entity.AllType;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataScanner{
    private static final String GF3 = "GF3";
    private static final String GF2 = "GF2";
    private static final String GF1 = "GF1";
    private static final String GF4 = "GF4";

    public static List<AllType>  scanner(ArrayList<String> addressList){
        File f = new File("e:\\realease");

        //扫描解压tar.gz
        ArrayList<File> tarGzList = new ArrayList();
        ArrayList<File> al = new ArrayList();
        showTarList(f,tarGzList);
        List<AllType> allTypeList = new ArrayList<AllType>();
        System.out.println("数据个数为："+ tarGzList.size());

        ArrayList<String> tarGzPathList = new ArrayList<>();
        String path;
        for (File tar : tarGzList) {
            circle:
            try {
                String Gzpath = tar.getAbsolutePath();
                tarGzPathList.add(tar.getAbsolutePath());
                for(String address:addressList)
                    if(address.equals(Gzpath)) {
                        System.out.println("当前文件"+Gzpath+"已入库");
                        break circle;
                    }
                path = tar.getAbsolutePath();
                path = path.replaceAll("\\\\", "/");
                System.out.println("正在解压并入库： "+path);
                unCompressArchiveGz(Gzpath);
                //扫描.xml
                showList(f,al);

                try {
                    for (File xml : al) {
                        InputStreamReader read = new InputStreamReader(
                                new FileInputStream(xml), "GBK");//考虑到编码格式
                        BufferedReader bufferedReader = new BufferedReader(read);
                        String lineTxt = null;

                        String XmlPath = xml.getAbsolutePath();
                        ReaderAdapter readerAdapter = new GF3ReaderAdapter();

                        Pattern patternGF3 = Pattern.compile(GF3);
                        Matcher matcherGF3 = patternGF3.matcher(XmlPath);
                        if (matcherGF3.find()) {
                            AllType allType = new AllType();
                            while ((lineTxt = bufferedReader.readLine()) != null) {
                                Pattern satellite = Pattern.compile("<product>");
                                Matcher ms = satellite.matcher(lineTxt);
                                if (ms.find()) {
                                    System.out.println("GF3已找到");
                                    try {
                                        allType = readerAdapter.fileReader
                                                (xml.getAbsolutePath(),path);
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
                        Matcher matcherGF2 = patternGF2.matcher(XmlPath);
                        Pattern patternGF1 = Pattern.compile(GF1);
                        Matcher matcherGF1 = patternGF1.matcher(XmlPath);
                        Pattern patternGF4 = Pattern.compile(GF4);
                        Matcher matcherGF4 = patternGF4.matcher(XmlPath);
                        if (matcherGF2.find() || matcherGF1.find() || matcherGF4.find()) {
                            AllType allType = new AllType();
                            try {
                                allType=readerAdapter1.fileReader
                                        (xml.getAbsolutePath(),path);
                                allTypeList.add(allType);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if(read!=null)
                            read.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException("发生错误！");
                }

                for(File delXml:al){
                    if((delXml.getName()).endsWith(".xml")){
                        delXml.delete();
                    }

                }
                //System.out.println("清空前al的size为： "+al.size());
                al.clear();
                //System.out.println("清空前al的size为： "+al.size());
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        System.out.println("解压完成");

        return allTypeList;
    }

    /**
     * 采用递归方式遍历指定文件夹，扫描java类型文件,删除非.xml文件
     * @param f
     * @param al
     */
    public static void showList(File f, ArrayList<File> al){
        File []fArr = f.listFiles();
        //if(fArr != null)
        for(File p : fArr){
            if(p.isDirectory()){
                showList(p, al);
            }
            else{
                if((p.getName()).endsWith(".xml")){
                    al.add(p);
                }
                else{
                    if(!(p.getName()).endsWith(".tar.gz") && p.exists())
                        p.delete();
                }

            }
        }
    }

    public static void showTarList(File f, ArrayList<File> al){
        File []fArr = f.listFiles();

        for(File p : fArr){
            if(p.isDirectory()){
                showList(p, al);
            }
            else{
                if((p.getName()).endsWith(".tar.gz"))
                    al.add(p);
            }
        }
    }

    /**
     * 解压
     * @param archive
     * @throws IOException
     */
    public static void unCompressArchiveGz(String archive) throws IOException {

        File file = new File(archive);

        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(file));

        String fileName =
                file.getName().substring(0, file.getName().lastIndexOf("."));

        String finalName = file.getParent() + File.separator + fileName;

        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(finalName));

        GzipCompressorInputStream gcis =
                new GzipCompressorInputStream(bis);

        byte[] buffer = new byte[1024];
        int read = -1;
        while((read = gcis.read(buffer)) != -1){
            bos.write(buffer, 0, read);
        }
        gcis.close();
        bos.close();

        unCompressTar(finalName);
    }

    /**
     * 解压tar
     * @param finalName
     * @throws IOException
     *
     */
    private static void unCompressTar(String finalName) throws IOException {

        File file = new File(finalName);
        String parentPath = file.getParent();
        TarArchiveInputStream tais =
                new TarArchiveInputStream(new FileInputStream(file));

        TarArchiveEntry tarArchiveEntry = null;

        while((tarArchiveEntry = tais.getNextTarEntry()) != null){
            String name = tarArchiveEntry.getName();
            File tarFile = new File(parentPath, name);
            if(!tarFile.getParentFile().exists()){
                tarFile.getParentFile().mkdirs();
            }

            BufferedOutputStream bos =
                    new BufferedOutputStream(new FileOutputStream(tarFile));

            int read = -1;
            byte[] buffer = new byte[1024];
            while((read = tais.read(buffer)) != -1){
                bos.write(buffer, 0, read);
            }
            bos.close();
        }
        tais.close();
        file.delete();//删除tar文件
    }

}

