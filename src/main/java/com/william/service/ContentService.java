package com.william.service;

import com.william.pojo.Content;

import java.util.List;

public interface ContentService {
    int insert(Content content);

    List<Content> selectAllContent();
}