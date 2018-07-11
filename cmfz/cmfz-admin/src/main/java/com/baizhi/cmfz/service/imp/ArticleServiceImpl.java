package com.baizhi.cmfz.service.imp;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-08.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao ad;
    @Override
    public Map<String, Object> queryAllPicsByPage(Integer nowPage, Integer pageSize) {
        List<Article> articles = ad.selectAllArticleByPage((nowPage - 1) * pageSize, pageSize);
        Integer count = ad.count();
        Map<String,Object>map=new HashMap<>();
        map.put("total",count);
        map.put("rows",articles);
        return map;
    }

    @Override
    public Article selectOne(String id) {
        return ad.selectOne(id);
    }


    @Override
    public Integer addArticle(Article article) {
        return ad.addArticle(article);
    }

    @Override
    public Integer dropArticle(String id) {
        return ad.delete(id);
    }
}
