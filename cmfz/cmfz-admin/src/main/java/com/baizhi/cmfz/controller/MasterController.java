package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.utils.UUIDUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.ldap.PagedResultsControl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-07.
 */
@Controller
@RequestMapping("/master")
public class MasterController {
    @Autowired
    private MasterService ms;

    @RequestMapping("/show")
    @ResponseBody
    public Map<String,Object> showall(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize,HttpServletRequest request){

        String sort = request.getParameter("name");  //模糊查询的条件
        String value=request.getParameter("value");  //传过来的查询字符


        System.out.println(nowPage);
        System.out.println(pageSize);

        if(sort!=null){
            return ms.queryAllMasterByLike(nowPage,pageSize,value);
        }else {
            return   ms.queryAllMasterByPage(nowPage,pageSize);
        }

    }

    @RequestMapping("/add")
    @ResponseBody
    public Integer add(MultipartFile myfile_mas, HttpSession session, String master_name, String master_summar, HttpServletRequest request)throws IOException{

        String realPath = request.getRealPath("");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String substring = realPath.substring(0, lastIndexOf);
        String uploadPath = substring+"\\upload";
        //生成UUID的唯一文件名
        String uuidName= UUIDUtils.getUUID();

        //截取文件本身的后缀名
        String oldName=myfile_mas.getOriginalFilename();

        String suffix=oldName.substring(oldName.lastIndexOf("."));

        myfile_mas.transferTo(new File(uploadPath+"/"+uuidName+suffix));

        Master master=new Master();
        master.setMaster_photo(uuidName+suffix);
        master.setMaster_name(master_name);
        master.setMaster_summar(master_summar);
        return ms.addMaster(master);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Integer update(Master master){

        System.out.println(master+"--------in controller");

        return ms.modifyMaster(master);
    }

    @RequestMapping("/drop")
    @ResponseBody
    public Integer drop(Integer id){
        return ms.dropMaster(id);
    }


    @RequestMapping(value = "/import",method =RequestMethod.POST)
    @ResponseBody
    public Integer importExcel(MultipartFile Thefile,HttpServletRequest request) throws IOException {
        ImportParams params=new ImportParams();

        //表格标题函数 默认为0
        params.setTitleRows(1);

        //表头函数
        params.setHeadRows(1);

        //是否保存上传到的EXcel
        params.setNeedSave(true);

        String path=request.getSession().getServletContext().getRealPath("");
        System.out.println(path);
        File f=new File(path+"/excel"+Thefile.getOriginalFilename());
        if(!f.exists()){
            File dir=new File(path+"/excel");
            dir.mkdir();
            if(f.createNewFile()){
                System.out.println("创建文件成功");
            }else{
                System.out.println("创建文件失败");
            }
        }
        Thefile.transferTo(f);
        List<Master>masters= ExcelImportUtil.importExcel(f,Master.class,params);
        System.out.println(JSON.toJSONString(masters));
        for (Master master : masters) {
            ms.addMaster(master);
        }
        return 6666;
    }
}
