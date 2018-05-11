package com.zcq.springbootobservation.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.java.accessibility.util.AccessibilityListenerList;
import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.OrderType;
import com.zcq.springbootobservation.Entity.ProductType;
import com.zcq.springbootobservation.Service.OrderService;
import com.zcq.springbootobservation.Service.ProductService;
import com.zcq.springbootobservation.Service.UserService;
//import com.zcq.springbootobservation.Service.WebSecurityConfig;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
@RequestMapping(value = "/product")
public class ProductController {

    public final static String SESSION_KEY = "user";
    @RequestMapping("/home")
    public String welcome(ModelMap model)
    {
        model.put("time", new Date());
        model.put("message", "test");
        return "/";
    }


    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/search")
    public void search(AllType allType, HttpServletResponse response) {

        String temp = allType.getSensorID();
        //检查参数
        if(allType.getSatelliteID().trim().isEmpty())
            allType.setSatelliteID(null);
        if(allType.getSensorID().trim().isEmpty())
            allType.setSensorID(null);
        if(allType.getLeftTopLng().trim().isEmpty() || allType.getLeftTopLat().trim().isEmpty() || allType.getRightBottomLng().trim().isEmpty() || allType.getRightBottomLat().trim().isEmpty())
            System.out.println("经纬度不可为空");
        if(allType.getCloudPercent().trim().isEmpty())
            allType.setCloudPercent(null);
        if(allType.getNominalResolution().trim().isEmpty())
            allType.setNominalResolution(null);
        String GF1= null;
        String GF2= null;
        String GF3= null;
        String GF4= null;
       /* String HJ1A= null;
        String HJ1B= null;
        String Terra= null;
        String ZY3= null;
        String Aqua= null;*/
        String regEx="\"(\\w+)\"";
        List<String> SaList =  new ArrayList<String>();
        List<String> SeList =  new ArrayList<String>();
        try{
            JSONObject jsonObject = new JSONObject(temp);

            //GF1传感器解析
            GF1 = jsonObject.getString("GF1");
            String GF1sensorID = GF1.substring(1,GF1.length()-1);
            Pattern p1 = Pattern.compile(regEx);
            Matcher m1 = p1.matcher(GF1sensorID);
            while(m1.find()) {
                SaList.add("GF1");
                SeList.add(m1.group(1));
            }
            //GF2传感器解析
            GF2 = jsonObject.getString("GF2");
            String GF2sensorID = GF2.substring(1,GF2.length()-1);
            Pattern p2 = Pattern.compile(regEx);
            Matcher m2 = p2.matcher(GF2sensorID);

            while(m2.find()) {
                SaList.add("GF2");
                SeList.add(m2.group(1));
            }
            //GF3传感器解析
            GF3 = jsonObject.getString("GF3");
            String GF3sensorID = GF3.substring(1,GF3.length()-1);
            Pattern p3 = Pattern.compile(regEx);
            Matcher m3 = p3.matcher(GF3sensorID);

            while(m3.find()) {
                SaList.add("GF3");
                SeList.add(m3.group(1));
            }
            //GF4传感器解析
            GF4 = jsonObject.getString("GF4");
            String GF4sensorID = GF4.substring(1,GF4.length()-1);
            Pattern p4 = Pattern.compile(regEx);
            Matcher m4 = p4.matcher(GF4sensorID);
            while(m4.find()) {
                SaList.add("GF4");
                SeList.add(m4.group(1));
            }
           /* //HJ1A传感器解析
            HJ1A = jsonObject.getString("HJ1A");
            String HJ1AsensorID = HJ1A.substring(1,HJ1A.length()-1);
            Pattern pHJ1A = Pattern.compile(regEx);
            Matcher mHJ1A= pHJ1A.matcher(HJ1AsensorID);
            while(mHJ1A.find()) {
                SaList.add("HJ1A");
                SeList.add(mHJ1A.group(1));
            }
            //HJ1B传感器解析
            HJ1B = jsonObject.getString("HJ1B");
            String HJ1BsensorID = HJ1B.substring(1,HJ1B.length()-1);
            Pattern pHJ1B = Pattern.compile(regEx);
            Matcher mHJ1B = pHJ1B.matcher(HJ1BsensorID);
            while(mHJ1B.find()) {
                SaList.add("HJ1B");
                SeList.add(mHJ1B.group(1));
            }
            //Terra传感器解析
            Terra = jsonObject.getString("Terra");
            String TerrasensorID = Terra.substring(1,Terra.length()-1);
            Pattern pTerra = Pattern.compile(regEx);
            Matcher mTerra = pTerra.matcher(TerrasensorID);
            while(mTerra.find()) {
                SaList.add("Terra");
                SeList.add(mTerra.group(1));
            }
            //ZY3传感器解析
            ZY3 = jsonObject.getString("ZY3");
            String ZY3sensorID = ZY3.substring(1,ZY3.length()-1);
            Pattern pZY3 = Pattern.compile(regEx);
            Matcher mZY3 = pZY3.matcher(ZY3sensorID);
            while(mZY3.find()) {
                SaList.add("ZY3");
                SeList.add(mZY3.group(1));
            }
            //Aqua传感器解析
            Aqua = jsonObject.getString("Aqua");
            String AquasensorID = Aqua.substring(1,Aqua.length()-1);
            Pattern pAqua = Pattern.compile(regEx);
            Matcher mAqua = pAqua.matcher(AquasensorID);
            while(mAqua.find()) {
                SaList.add("Aqua");
                SeList.add(mAqua.group(1));
            }*/
        } catch (JSONException e) {
            e.printStackTrace();
        }
       /* System.out.println(allType.getProvince());
        if(allType.getProvince().equals("请选择省份"))
            allType.setProvince(null);
        if(allType.getCity().equals("请选择城市"))
            allType.setCity(null);
        if(allType.getCounty().equals("请选择区/县"))
            allType.setCounty(null);*/
        /*System.out.println("LeftTopLng:"+allType.getLeftTopLng()+";\nLeftTopLat:"+allType.getLeftTopLat()+";\nrightBottomLng:"+allType.getRightBottomLng()+";\nrightBottomLat:"+allType.getRightBottomLat()+ ";\nNominalResolution:"+allType.getNominalResolution()+";\nlevel:"+allType.getLevel()+";\ncloudPercent:"+allType.getCloudPercent());
        System.out.println("province: "+allType.getProvince()+";\ncity: "+ allType.getCity()+";\ncounty: "+allType.getCounty());*/
        List<List<AllType>> dataList=new ArrayList<List<AllType>>();
        //把经纬度首尾加上"%" 用于mysql模糊查询
        allType.setLeftTopLat(translate(allType.getLeftTopLat()));
        allType.setLeftTopLng(translate(allType.getLeftTopLng()));
        allType.setRightBottomLat(translate(allType.getRightBottomLat()));
        allType.setRightBottomLng(translate(allType.getRightBottomLng()));

        for(int i=0;i<SaList.size();i++) {
            for (int j = 0; j < SeList.size(); j++) {

                allType.setSatelliteID(SaList.get(i));
                allType.setSensorID(SeList.get(j));
                List<AllType> data = productService.search(allType);

                dataList.add(data);
            }
        }


        AllType test=new AllType();

        test.setCloudPercent(null);
        test.setNominalResolution(null);
        test.setSensorID("SAR");
        test.setSatelliteID("GF3");
        test.setLevel("1");
        test.setLeftTopLng("122.222");
        test.setLeftTopLat("23.333");
        test.setRightBottomLng("32.111");
        test.setRightBottomLat("46.555");


        List<AllType> receive= new ArrayList<AllType>();//productService.search(test);

        if(dataList.isEmpty())
            System.out.println("空");
        else
            for(int i =0;i<dataList.size();i++)
                for(int j = 0; j < dataList.get(i).size();j++) {
                    System.out.println(dataList.get(i).get(j).getProductID());
                    receive.add(dataList.get(i).get(j));
        }

        String str="";
        ObjectMapper x = new ObjectMapper();

        try {
            str = x.writeValueAsString(receive);    //将java类对象转换为json字符串
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            response.setContentType("text/xml;charset=UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping(value="/searchByID")
    public void getOrderList(String productIDList,HttpServletResponse response){

        String regEx="\"(\\w+)\"";
        List<String> productID =  new ArrayList<String>();
        Pattern p1 = Pattern.compile(regEx);
        Matcher m1 = p1.matcher(productIDList);
        while(m1.find()) {

            productID.add(m1.group(1));
        }
        List<AllType> productList = new ArrayList<AllType>();
        for(int i = 0; i < productID.size(); i++)
            productList.add(productService.getRecordById(productID.get(i)));



        String str="";
        ObjectMapper x = new ObjectMapper();

        try {
            str = x.writeValueAsString(productList);    //将java类对象转换为json字符串
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            response.setContentType("text/xml;charset=UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Autowired
    private OrderService orderService;
    @RequestMapping(value="/order")
    public void getorder(String productId, HttpServletResponse response){
        AllType currentRecord = productService.getRecordById(productId);
        //String userName = (String)session.getAttribute(WebSecurityConfig.SESSION_KEY);
       // System.out.println("用户名"+userName);
        String str="";
        ObjectMapper x = new ObjectMapper();

        try {
            str = x.writeValueAsString(currentRecord);    //将java类对象转换为json字符串
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        try {
            response.setContentType("text/xml;charset=UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将数据返回前台ajax

        //return "orderConfirm";
    }
    @RequestMapping(value="/orderConfirm")
    public String getorderConfirm(HttpServletResponse response,HttpSession session,Model model)
    {

        String userName = (String)session.getAttribute(SESSION_KEY);
       // System.out.println("用户名"+userName);
        OrderType temp = orderService.getMaxIdRecord();

        int MaxOrderId = 0;
        try {
            MaxOrderId = Integer.parseInt(temp.getOrderId());
            MaxOrderId++;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //Object userName = session.getAttribute(WebSecurityConfig.SESSION_KEY);
        String CurrentId = String.valueOf(MaxOrderId);
        System.out.println("新订单编号"+CurrentId);
        model.addAttribute("MaxOrderId", CurrentId);
        model.addAttribute("userName", userName);
        return "orderConfirm";
    }

    String translate(String lngAndLat){
        String temp = "";
        temp+="%";
        temp+=lngAndLat;
        temp+="%";
        return temp;
    }

}
