package com.william.service;

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
}