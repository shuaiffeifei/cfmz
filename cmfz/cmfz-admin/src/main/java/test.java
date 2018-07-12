import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.*;
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
       ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminServiceImpl = (AdminService) ctx.getBean("adminServiceImpl");

        adminServiceImpl.adminLoginByShiro("cpf");

        List<SysRole> cpf = adminServiceImpl.queryRolesByUsername("cpf");

        for (SysRole sysRole : cpf) {
            System.out.println(sysRole);
        }
    }
}
