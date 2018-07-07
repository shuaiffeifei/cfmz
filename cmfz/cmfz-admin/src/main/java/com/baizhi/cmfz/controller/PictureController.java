package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;

/**
 * Created by Administrator on 2018-07-06.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService ps;

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String ,Object>  findByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize){
        return ps.queryAllPicsByPage(nowPage,pageSize);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Integer m2(MultipartFile myfile, HttpSession session, String picture_status, String picture_description, HttpServletRequest request)throws IOException{

        String realPath = request.getRealPath("");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String substring = realPath.substring(0, lastIndexOf);
        String uploadPath = substring+"\\upload";
        //生成UUID的唯一文件名
        String uuidName= UUIDUtils.getUUID();

        //截取文件本身的后缀名
        String oldName=myfile.getOriginalFilename();

        String suffix=oldName.substring(oldName.lastIndexOf("."));

        myfile.transferTo(new File(uploadPath+"/"+uuidName+suffix));

        Picture picture=new Picture();
        picture.setPicture_id(uuidName);
        picture.setPicture_path(uuidName+"."+suffix);
        picture.setPicture_status(picture_status);
        picture.setPicture_description(picture_description);

        System.out.println(picture+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ps.addPicture(picture);
        return 6666;
    }


    @RequestMapping("/update")
    @ResponseBody
    public Integer m3(Picture pic){

        return ps.modifyPicture(pic);

    }

    @RequestMapping("/drop")
    @ResponseBody
    public String  dropEmployee(String id){
        ps.dropPicture(id);
        return"drop";
    }
}
