package com.baizhi.cmfz.service.imp;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-06.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pd;

    @Override
    public Map<String, Object> queryAllPicsByPage(Integer nowPage, Integer pageSize) {

        List<Picture> pictures = pd.selectAllPicByPage((nowPage - 1) * pageSize,pageSize);

        Integer count=pd.count();

        //初始化map集合
        Map<String,Object>map=new HashMap<>();
        map.put("total",count);
        map.put("rows",pictures);
        return map;
    }

    @Override
    public Integer addPicture(Picture pic) {
        return pd.insertPic(pic);
    }

    @Override
    public Integer modifyPicture(Picture pic) {
        return pd.modifyPic(pic);
    }

    @Override
    public Integer dropPicture(String id) {
        return pd.deletePic(id);
    }
}
