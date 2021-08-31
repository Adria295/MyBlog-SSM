package com.william.controller;

import com.william.pojo.Content;
import com.william.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("ContentServiceImpl")
    private ContentService contentService;

    @RequestMapping("/admin")
    public String test() {
        return "login";
    }

    @RequestMapping("/index")
    public String test2(Model model) {
        List<Content> contentList = contentService.selectAllContent();
        model.addAttribute("contentList",contentList);
        return "index";
    }

    @RequestMapping("/")
    public String test3(Model model) {
        List<Content> contentList = contentService.selectAllContent();
        model.addAttribute("contentList",contentList);
        return "index";
    }


}
