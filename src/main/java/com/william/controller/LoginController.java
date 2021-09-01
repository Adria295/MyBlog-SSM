package com.william.controller;

import com.william.pojo.Content;
import com.william.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    @Qualifier("ContentServiceImpl")
    private ContentService contentService;

    @RequestMapping("/admin")
    public String test() {
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request){

        if (username.equals("william") && password.equals("1")){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userLoinIngo","william");
            return "redirect:tag";
        }
        return "login";
    }

    @RequestMapping("/tag")
    public String tag2(Model model) {
        List<Content> contentList = contentService.selectAllContent();
        model.addAttribute("contentList",contentList);
        return "tag";
    }

}
