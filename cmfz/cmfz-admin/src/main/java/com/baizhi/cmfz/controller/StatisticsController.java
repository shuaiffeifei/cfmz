package com.baizhi.cmfz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-09.
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    @RequestMapping("/activeUser")
    @ResponseBody
    public Map<String,Object> m1(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("intervals",new String[]{"7天","15天","30天","半年","一年"});
        map.put("counts",new int[]{5,10,15,20,25});
        return map;
    }
}
