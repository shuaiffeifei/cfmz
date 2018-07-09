package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018-07-08.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService as;



    @RequestMapping("/show")
    @ResponseBody
    public Map<String,Object> showall(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize){
        return as.queryAllPicsByPage(nowPage,pageSize);
    }


    @RequestMapping("/showone")
    @ResponseBody
    public Article findone(String article_id){

        return as.selectOne(article_id);
    }


    @RequestMapping("/add")
    @ResponseBody
    public Integer addArticle(String article_name,String guru_id,String status,String introduction){

        Article article=new Article();

        if(status==null){
            article.setStatus("off");
            article.setArticle_id(UUIDUtils.getUUID());
            article.setArticle_name(article_name);
            article.setGuru_id(Integer.valueOf(guru_id));
            article.setMain_pic(null);
            article.setIntroduction(introduction);
        }else{
            article.setArticle_id(UUIDUtils.getUUID());
            article.setArticle_name(article_name);
            article.setGuru_id(Integer.valueOf(guru_id));
            article.setMain_pic(null);
            article.setIntroduction(introduction);
            article.setStatus("on");
        }
        return as.addOneArticle(article);
    }



    @RequestMapping("/drop")
    @ResponseBody
    public Integer drop(String id){
        return as.dropArticle(id);
    }
}
