package com.zcq.springbootobservation.Controller;


import com.zcq.springbootobservation.Entity.UserType;
import com.zcq.springbootobservation.Service.DataScanner;
import com.zcq.springbootobservation.Service.UserService;
//import com.zcq.springbootobservation.Service.WebSecurityConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


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
    public String shoppingCart(){
        return "shoppingCart";
    }

    @Autowired
    private UserService userService;
    @RequestMapping("/userList")
    public String index(HttpServletRequest httpServletRequest,Model model){

        List<UserType> list=userService.getAll();
        model.addAttribute("userList", list);
        return "userList";
    }

    @RequestMapping("/loginVerify")
    public String loginVerify(String username,String password,String identification, HttpSession session,Model model) {

            UserType userType = new UserType();
            userType.setUsername(username);
            userType.setPassword(password);
            boolean verify = userService.verifyLogin(userType);
            Map<String, Object> map = new HashMap<>();
            if (!verify) {

                return "err";
            }
            // 设置session
            session.setAttribute(SESSION_KEY, username);

            List<UserType> userList = userService.getAll();
            model.addAttribute("userList", userList);
            return "index";


    }


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

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(SESSION_KEY);
        return "/login";
    }

    @Scheduled(cron= "0 0 19 * * ?")
    public void deleteAllTempClob(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DataScanner.scanner();
        System.out.println("---->>数据入库:"+"当前时间：" + sdf.format(d));
    }

}