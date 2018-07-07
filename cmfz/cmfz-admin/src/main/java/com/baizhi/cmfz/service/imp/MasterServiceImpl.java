package com.baizhi.cmfz.service.imp;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-07.
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDao md;

    @Override
    public Map<String, Object> queryAllMasterByPage(Integer nowPage, Integer pageSize) {

        List<Master> masters = md.selectAllMasterByPage((nowPage - 1) * pageSize,  pageSize);

        Integer count=md.count();

        //初始化map集合
        Map<String,Object>map=new HashMap<>();
        map.put("total",count);
        map.put("rows",masters);
        return map;
    }


    public Map<String,Object> queryAllMasterByLike(Integer nowPage, Integer pageSize,String value){

        String newvalue="%"+value+"%";
        List<Master> masters = md.selectAllMasterByLike((nowPage - 1) * pageSize, nowPage * pageSize, newvalue);
        Integer countByLike = md.countByLike(newvalue);
        Map<String,Object>map=new HashMap<>();
        map.put("total",countByLike);
        map.put("rows",masters);
        return map;
    }

    @Override
    public Integer addMaster(Master ms) {
        return md.insertMaster(ms);
    }

    @Override
    public Integer modifyMaster(Master ms) {
        return md.modifyMaster(ms);
    }

    @Override
    public Integer dropMaster(Integer id) {
        return md.deleteMaster(id);
    }
}
