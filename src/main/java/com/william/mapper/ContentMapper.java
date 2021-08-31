package com.william.mapper;

import com.william.pojo.Content;

import java.util.List;

public interface ContentMapper {

    int insert(Content content);

    List<Content> selectAllContent();

}
