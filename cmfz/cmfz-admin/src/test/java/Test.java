import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018-07-04.
 */
public class Test {

   /* @org.junit.Test
    public void m1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
        AdminDao adminDao =(AdminDao) ctx.getBean("adminDao");
        Admin a=adminDao.selectAdmin("hr");
        System.out.println(a);
    }*/

    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao =(AdminDao) ctx.getBean("adminDao");
        System.out.println(adminDao);
        Admin a=adminDao.selectAdmin("hr");
        System.out.println(a);
    }

}
