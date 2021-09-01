package com.william.controller;

import com.william.pojo.Content;
import com.william.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContentController {

    @Autowired
    @Qualifier("ContentServiceImpl")
    private ContentService contentService;

    @RequestMapping("/editContent")
    public String editContent(Content content){
        contentService.insert(content);
        return "redirect:index";
    }

    @RequestMapping("/tag")
    public String tag(Model model) {
        List<Content> contentList = contentService.selectAllContent();
        model.addAttribute("contentList",contentList);
        return "tag";
    }

    @RequestMapping("/goToEditPage")
    public String goToEditPage() {
        return "edit";
    }


    @RequestMapping("/articles/{slugName}")
    public String showContent(Model model, @PathVariable String slugName) {
        Content content =  contentService.findContentBySlugName(slugName);
        model.addAttribute("content",content);
        return "detail";
    }

}
