package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-05.
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService ms;

    @RequestMapping("/getParent")
    @ResponseBody
    public List<Menu> m1(){
        return ms.showAllParent();
    }

    @RequestMapping("/getSons")
    @ResponseBody
    public List<Menu> m2(){
        return ms.showAllSons();
    }


}
