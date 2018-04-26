package com.zcq.springbootobservation.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class GuideController {
    public final static String SESSION_KEY = "user";
    @RequestMapping(value = "/GF_program")
    public String index(){
        return "/guide/GF_program";
    }

    @RequestMapping("/centerIntro")
    public String login(){
        return "/guide/centerIntro";
    }

    @RequestMapping("/news")
    public String news(){
        return "/guide/news";
    }

    @RequestMapping("/news2")
    public String news2(){
        return "/guide/news2";
    }

    @RequestMapping("/newsDetail")
    public String newsDetail(){
        return "/guide/newsDetail";
    }

    @RequestMapping("/notice")
    public String notice(){
        return "/guide/notice";
    }

    @RequestMapping("/policy")
    public String policy(){
        return "/guide/policy";
    }

    @RequestMapping("/work")
    public String work(){
        return "/guide/work";
    }

    @RequestMapping("/userGuide")
    public String userGuide(){
        return "/guide/userGuide";
    }

    @RequestMapping("/sateIntro")
    public String sateIntro(){
        return "/guide/sateIntro";
    }

    @RequestMapping("/successCase")
    public String successCase(){
        return "/guide/successCase";
    }

    @RequestMapping("/caseDetail")
    public String caseDetail(){
        return "/guide/caseDetail";
    }

    @RequestMapping("/dataApply")
    public String dataApply(HttpSession session, Model model){
        String currentuser = (String)session.getAttribute(SESSION_KEY);
        model.addAttribute("currentUser",currentuser);
        return "/guide/dataApply";
    }

    @RequestMapping("/noticeDetail")
    public String noticeDetail(){
        return "/guide/noticeDetail";
    }

    @RequestMapping("/policyDetail")
    public String policyDetail(){
        return "/guide/policyDetail";
    }

    @RequestMapping("/workDetail")
    public String workDetail(){
        return "/guide/workDetail";
    }



}
