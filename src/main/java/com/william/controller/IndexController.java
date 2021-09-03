package com.william.controller;

import com.github.pagehelper.PageHelper;
import com.william.pojo.Content;
import com.william.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = {"/","index"})
    public String index1(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
        int postSize = 8;
        PageHelper.startPage(pageNum, postSize);
        List<Content> contentList = contentService.selectAllContent();
        int numOfContent = contentService.queryNumOfContent();

        long numOfPage = (numOfContent % postSize) == 0 ? numOfContent / postSize : numOfContent / postSize + 1;
        model.addAttribute("numOfPage", numOfPage);
        model.addAttribute("contentList", contentList);
        model.addAttribute("numOfContent", numOfContent);
        model.addAttribute("currentPage", pageNum);
        return "index";
    }
}
