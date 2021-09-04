package com.william.service;

import com.william.pojo.Content;

import java.util.List;

public interface ContentService {
    int insert(Content content);

    List<Content> selectAllContent();

    Content findContentBySlugName(String slugName);

    int queryNumOfContent();

    int updateArticleViewsBySlugName(String slugName);
}
