package com.zcq.springbootobservation.Controller;


import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.UserType;
import com.zcq.springbootobservation.Service.DataScanner;
import com.zcq.springbootobservation.Service.ProductService;
import com.zcq.springbootobservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.zcq.springbootobservation.Service.WebSecurityConfig;


@Controller
public class LoginController {

    public final static String SESSION_KEY = "user";
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login( HttpSession session,Model model){
        String currentuser = (String)session.getAttribute(SESSION_KEY);
        System.out.println("当前用户:"+currentuser);
        if(currentuser == null)
            return "login";
        else {
            model.addAttribute("currentUser",currentuser);
            return "/guide/dataApply";
        }
    }

    @RequestMapping("/register")
    public String register(){

        return "register";
    }

    @RequestMapping("/shoppingCart")
    public String shoppingCart( HttpSession session,Model model){
        String currentuser = (String)session.getAttribute(SESSION_KEY);
        model.addAttribute("currentUser",currentuser);

        return "shoppingCart";
    }

    @Autowired
    private UserService userService;
//    @RequestMapping("/userList")
//    public String index(HttpServletRequest httpServletRequest,Model model){
//
//        List<UserType> list=userService.getAll();
//        model.addAttribute("userList", list);
//        return "userList";
//    }

    //登陆验证
    @RequestMapping("/loginVerify")
    public String loginVerify(String username,String password,String identification, HttpSession session,Model model) {

            UserType userType = new UserType();
            userType.setUsername(username);
            userType.setPassword(password);
            boolean verify = userService.verifyLogin(userType);

            if (!verify) {

                return "err";
            }
            // 设置session
            session.setAttribute(SESSION_KEY, username);

            model.addAttribute("currentUser",username);
            return "/guide/dataApply";


    }


    //注册
    @RequestMapping("/registerDB")
    public String  registerToDataBase(UserType userType,Model model){

        if(userType.getUsername() == null||userType.getPassword() == null || userType.getCompany() == null || userType.getCompanyAddress() == null
                || userType.getCompanyProperty() == null || userType.getCompanytelePhone() == null || userType.getPostCode() == null
                || userType.getPosition()==null || userType.getEmail()==null || userType.getRealName() == null || userType.getDepartment() == null
                || userType.getDepartment() == null)
            return "register";
        else{
            userService.register(userType);
            return "login";
        }


    }

    //注销
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(SESSION_KEY);
        return "/login";
    }

    //自动入库
    @Autowired
    private ProductService productService;
    @Scheduled(cron= "0 0 17 * * ?")
    public void LoadData(){
        Date d = new Date();
        List<AllType> allTypeList = new ArrayList<AllType>();
        ArrayList<String> addressList = productService.addressList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        allTypeList = DataScanner.scanner(addressList);
        System.out.println(allTypeList.size());
        for(int i = 0; i < allTypeList.size();i++)
            try {
                productService.insert(allTypeList.get(i));
            }catch (Exception e){
                e.printStackTrace();
            }
        System.out.println("---->>数据入库:"+"当前时间：" + sdf.format(d));
    }

}