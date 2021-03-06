package com.william.service;

import com.github.pagehelper.PageHelper;
import com.william.pojo.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-dao.xml","classpath:spring-service.xml"})
public class ContentServiceImplTest {

    @Resource
    private ContentService contentService;

    @Test
    public void setContentMapper() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void selectAllContent() {
        List<Content> contentList = contentService.selectAllContent();
        for (Content content :contentList
        ) {
            System.out.println(content.toString());
        }
    }

    @Test
    public void selectBySlugName(){
        Content content = contentService.findContentBySlugName("ioc");
        System.out.println(content.toString());
    }

    @Test
    public void queryNumOfContent(){
        int num = contentService.queryNumOfContent();
        System.out.println(num);
    }

    @Test
    public void pageHelperTest(){
        int postsListSize = 1;
        int pageNum = 1;
        PageHelper.startPage(pageNum, postsListSize);
        List<Content> contents = contentService.selectAllContent();
        long totalPages = PageHelper.count(()->contentService.selectAllContent());
        totalPages = (totalPages % postsListSize) == 0 ? totalPages/postsListSize : (totalPages/postsListSize) + 1;
    }

    @Test
    public void updateArticleViewsBySlugName(){
        contentService.updateArticleViewsBySlugName("mybatis");
    }

}