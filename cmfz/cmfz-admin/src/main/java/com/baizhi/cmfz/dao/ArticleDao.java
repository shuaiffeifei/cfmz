package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-07-08.
 */
public interface ArticleDao {

    //查询所有文章（分页）
    public List<Article> selectAllArticleByPage(@Param("begin") Integer begin, @Param("end") Integer end);

    //插入文章
    public Integer addArticle(Article article);

    //查询单个文章
    public Article selectOne(String id);

    //查询总条数
    public Integer count();

    //删除文章
    public Integer delete(@Param("article_id") String id);


}
