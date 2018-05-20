package com.zcq.springbootobservation.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.OrderType;
import com.zcq.springbootobservation.Service.OrderService;
import com.zcq.springbootobservation.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller

public class OrderController {

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

    @Autowired
    private OrderService orderService;
    @RequestMapping(value="/orderList")
    public void getOrderList(HttpSession session,HttpServletResponse response, Model model,String test){
        String userName = (String)session.getAttribute(SESSION_KEY);
        List<OrderType> tempList = orderService.getListByUserId(userName);
        System.out.println(test);
        model.addAttribute("orderList", tempList);
        String str = "";
        ObjectMapper x = new ObjectMapper();

        try {
            str = x.writeValueAsString(tempList);    //将java类对象转换为json字符串
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

    @RequestMapping("/order")
    public String order(HttpSession session,Model model){


        String userName = (String)session.getAttribute(SESSION_KEY);
        List<OrderType> tempList = orderService.getListByUserId(userName);

        model.addAttribute("currentUser",userName);
        model.addAttribute("CurrentUserOrderList", tempList);
        return "order";
    }

    @RequestMapping("/orderInfo")
    public String orderInfo(HttpSession session,Model model){

        String userName = (String)session.getAttribute(SESSION_KEY);
        //List<OrderType> tempList = orderService.getListByUserId(userName);

        model.addAttribute("currentUser",userName);
        //model.addAttribute("CurrentUserOrderList", tempList);
        return "orderInfo";
    }

    @RequestMapping(value="/orders")
    public void getorder(HttpSession session,String productID, HttpServletResponse response){
        AllType currentRecord = productService.getRecordById(productID);

        String userName = (String)session.getAttribute(SESSION_KEY);
       System.out.println("用户名"+userName);
       if(userName == null){
           try {
               response.getWriter().print("NoLogin");
           } catch (IOException e) {
               e.printStackTrace();
           }
       }else {
           String str = "";
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
       }
        //将数据返回前台ajax

        //return "orderConfirm";
    }
    //订单入数据库
    @RequestMapping(value="/orderConfirm")
    public void getorderConfirm(String productIDList,String orderName, String orderIntro,HttpSession session, HttpServletResponse response)
    {

        String userName = (String)session.getAttribute(SESSION_KEY);
        List<String> orderIdList = new ArrayList<>();
        //如果当前没有用户登陆则拒绝入库
        if(userName == null) {
            System.out.println("没有用户登陆");
            try {
                response.setContentType("text/xml;charset=UTF-8");
                response.setHeader("Cache-Control", "no-cache");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print("noUser");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {

            String regEx="\"(\\w+)\"";
            List<String> productID =  new ArrayList<String>();
            Pattern p1 = Pattern.compile(regEx);
            Matcher m1 = p1.matcher(productIDList);
            while(m1.find()) {
                productID.add(m1.group(1));
            }

            for(int i = 0; i < productID.size(); i++) {

                int MaxOrderId = 0;
                try {
                    OrderType temp = orderService.getMaxIdRecord();
                    MaxOrderId = Integer.parseInt(temp.getOrderId());
                    MaxOrderId++;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                //Object userName = session.getAttribute(WebSecurityConfig.SESSION_KEY);
                String CurrentId = String.valueOf(MaxOrderId);
                System.out.println("新订单编号" + CurrentId);

                orderIdList.add(CurrentId);

                OrderType orderType = new OrderType();
                orderType.setOrderId(CurrentId);
                orderType.setProductID(productID.get(i));
                orderType.setUsername(userName);
                orderType.setOrderName(orderName);
                orderType.setOrderIntro(orderIntro);
                orderService.orderToDataBases(orderType);
            }

            String str = "";
            ObjectMapper x = new ObjectMapper();

            try {
                str = x.writeValueAsString(orderIdList);    //将java类对象转换为json字符串
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
    }

//    @Autowired
//    private UserService userService;
//    @RequestMapping(value="/orderToDataBases")
//    public void setOrderToDataBases(String orderId,String productId,String username,HttpServletResponse response)
//    {
//        System.out.println(orderId+ " " + productId+" "+username);
//        OrderType orderType=new OrderType();
//        orderType.setOrderId(orderId);
//        orderType.setProductID(productId);
//        orderType.setUsername(username);
//        orderService.orderToDataBases(orderType);
//
//    }

//    @RequestMapping(value="/currentOrderList")
//    public String getCurrentUserOrderList(HttpSession session, Model model){
//        String userName = (String)session.getAttribute(SESSION_KEY);
//        List<OrderType> tempList = orderService.getListByUserId(userName);
//
//        model.addAttribute("CurrentUserOrderList", tempList);
//        return "currentOrderList";
//    }
}
