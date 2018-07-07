import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.service.imp.MasterServiceImpl;
import com.baizhi.cmfz.utils.UUIDUtils;
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
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        MasterService masterServiceImpl = (MasterService) ctx.getBean("masterServiceImpl");
        Map<String, Object> map = masterServiceImpl.queryAllMasterByLike(1, 2, "师");
        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            System.out.println(stringObjectEntry);
        }
    }
}