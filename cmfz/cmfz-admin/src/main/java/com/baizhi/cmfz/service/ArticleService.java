package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.Map;

/**
 * Created by Administrator on 2018-07-08.
 */
public interface ArticleService {

    //分页展示所有的文章
    public Map<String,Object> queryAllPicsByPage(Integer nowPage, Integer pageSize);

    //单篇文章详情
    public Article selectOne(String id);

    //添加文章
    public Integer addOneArticle(Article article);

    //删除文章
    public Integer dropArticle(String id);

}
