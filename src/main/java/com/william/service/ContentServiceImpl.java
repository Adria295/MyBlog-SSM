package com.william.service;

import com.william.mapper.ContentMapper;
import com.william.pojo.Content;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class ContentServiceImpl implements ContentService{

    private ContentMapper contentMapper;

    public void setContentMapper(ContentMapper contentMapper) {
        this.contentMapper = contentMapper;
    }

    @Override
    public int insert(Content content) {

        return contentMapper.insert(content);
    }

    @Override
    public List<Content> selectAllContent() {
        return contentMapper.selectAllContent();
    }
}

