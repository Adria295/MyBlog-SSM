package com.william.controller;

import com.william.pojo.Content;
import com.william.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ArchiveController {

    @Autowired
    @Qualifier("ContentServiceImpl")
    private ContentService contentService;


    @RequestMapping("/archive")
    public String archive(Model model){
        List<Content> contentList = contentService.selectAllContent();
        model.addAttribute("contentList",contentList);
        return "archive";
    }
}
