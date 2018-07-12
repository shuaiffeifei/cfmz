import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.service.LogbookService;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.service.imp.MasterServiceImpl;
import com.baizhi.cmfz.utils.UUIDUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.awt.image.PixelConverter;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-04.
 */
public class test {
    public static void main(String[] args) {
       /* ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
       LogbookService logbookServiceImpl = (LogbookService) ctx.getBean("logbookServiceImpl");
        Map<String, Object> allLogsByPage = logbookServiceImpl.findAllLogsByPage(1, 2);
        for (Map.Entry<String, Object> stringObjectEntry : allLogsByPage.entrySet()) {
            System.out.println(stringObjectEntry);
        }*/

        Md5Hash md5Hash = new Md5Hash("123456", "E2CB6C", 1024);
        System.out.println(md5Hash);
    }
}
