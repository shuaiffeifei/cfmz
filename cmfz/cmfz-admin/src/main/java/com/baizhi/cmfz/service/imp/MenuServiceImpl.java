package com.baizhi.cmfz.service.imp;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-05.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao md;

    //查所有的父类标签
    public List<Menu> showAllParent() {
        List<Menu>lists=md.selectAllParent();
        return lists;
    }

    @Override
    public List<Menu> showAllSons() {

        return md.selectSons();
    }




}
