package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018-07-10.
 */
@Controller
@RequestMapping("/log")
public class LogController {


    @Autowired
    private LogbookService logbookService;

    @RequestMapping("/showall")
    @ResponseBody
    public Map<String ,Object> showalllogs(@RequestParam("page") Integer nowPage,@RequestParam("rows") Integer pageSize){
        return logbookService.findAllLogsByPage(nowPage,pageSize);
    }


    @RequestMapping("/drop")
    @ResponseBody
    public Integer dropOneLog(String id){
        return logbookService.deleteLog(id);
    }

}
