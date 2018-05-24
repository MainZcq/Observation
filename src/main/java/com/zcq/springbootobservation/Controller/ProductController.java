package com.zcq.springbootobservation.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.OrderType;
import com.zcq.springbootobservation.Entity.ShoppingCartType;
import com.zcq.springbootobservation.Service.OrderService;
import com.zcq.springbootobservation.Service.ProductService;
import com.zcq.springbootobservation.Service.ShoppingCartService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.zcq.springbootobservation.Service.WebSecurityConfig;


@Controller
@RequestMapping(value = "/product")
public class ProductController {

    public final static String SESSION_KEY = "user";

    @Autowired
    private ProductService productService;


    //查询
    @RequestMapping(value = "/search")
    public void search(AllType allType, HttpServletResponse response) {

        String temp = allType.getSensorID();
        //检查参数
        if(allType.getSatelliteID()!= null &&allType.getSatelliteID().trim().isEmpty())
            return;
        if(allType.getSensorID()!= null &&allType.getSensorID().trim().isEmpty())
            return;
        if(allType.getLeftTopLng().trim().isEmpty() || allType.getLeftTopLat().trim().isEmpty() || allType.getRightBottomLng().trim().isEmpty() || allType.getRightBottomLat().trim().isEmpty()) {

            System.out.println("经纬度不可为空");
            return;
        }
        if(allType.getCloudPercent()!= null &&allType.getCloudPercent().trim().isEmpty())
            allType.setCloudPercent(null);
        if(allType.getNominalResolution()!= null &&allType.getNominalResolution().trim().isEmpty())
            allType.setNominalResolution(null);
        if(allType.getProduceTime().length() > 1) {
            String array[] = allType.getProduceTime().split(";");

            allType.setProduceTime(array[0]);
            allType.setProduceTime1(array[1]);
        }else{
            allType.setProduceTime("2017-01-01");
            allType.setProduceTime1("2100-01-01");
        }

        String GF1= null;
        String GF2= null;
        String GF3= null;
        String GF4= null;

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

        } catch (JSONException e) {
            e.printStackTrace();
        }

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



        List<AllType> receive= new ArrayList<AllType>();//productService.search(test);

        if(dataList.isEmpty())
            System.out.println("未查询到相关数据");
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


    //根据产品ID查询数据
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

    @Autowired
    private ShoppingCartService shoppingCartService;
    //加入购物车
    @RequestMapping(value="/insertIntoShoppingCart")
    public void insertIntoShoppingCart(HttpSession session, String productIDList,HttpServletResponse response){
        ShoppingCartType shoppingCartType = new ShoppingCartType();
        String userName = (String)session.getAttribute(SESSION_KEY);
        List<ShoppingCartType> shoppingCartTypes = shoppingCartService.getListByUsername(userName);
        if(userName == null)
            return;
        String regEx="\"(\\w+)\"";
        Pattern p1 = Pattern.compile(regEx);
        Matcher m1 = p1.matcher(productIDList);
        while(m1.find()) {

            //如果当前订单已经在表中则跳过
            boolean flag = false;
            if(!shoppingCartTypes.isEmpty()) {
                for (int i = 0; i < shoppingCartTypes.size(); i++)
                    if (shoppingCartTypes.get(i).getProductID().equals(m1.group(1)))
                        flag = true;
            }
            if(shoppingCartTypes.isEmpty() || flag == false) {
                shoppingCartType.setProductID(m1.group(1));
                shoppingCartType.setUserName(userName);
                shoppingCartService.insertIntoShoppingCart(shoppingCartType);
            }
        }
        String str="";
        ObjectMapper x = new ObjectMapper();

        try {
            str = x.writeValueAsString("success");    //将java类对象转换为json字符串
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

    @RequestMapping(value="/getShoppingOrderList")
    public void getShoppingOrderList(HttpSession session,HttpServletResponse response) {
        String userName = (String)session.getAttribute(SESSION_KEY);

        List<AllType> productList = shoppingCartService.getProductsList(userName);

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

    @RequestMapping(value="/deleteRecords")
    public void deleteRecords(String productIDList,HttpSession session,HttpServletResponse response) {
        String userName = (String)session.getAttribute(SESSION_KEY);

        String regEx="\"(\\w+)\"";
        ShoppingCartType shoppingCartType = new ShoppingCartType();
        Pattern p1 = Pattern.compile(regEx);
        Matcher m1 = p1.matcher(productIDList);
        while(m1.find()) {
            shoppingCartType.setProductID(m1.group(1));
            shoppingCartType.setUserName(userName);
            shoppingCartService.deleteRocords(shoppingCartType);
        }

        String str="";
        ObjectMapper x = new ObjectMapper();

        try {
            str = x.writeValueAsString("success");    //将java类对象转换为json字符串
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
    String translate(String lngAndLat){
        String temp = "";
        temp+="%";
        temp+=lngAndLat;
        temp+="%";
        return temp;
    }

}
