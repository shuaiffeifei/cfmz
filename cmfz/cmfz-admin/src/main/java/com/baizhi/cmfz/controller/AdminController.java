package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.utils.CreateValidateCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018-07-04.
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"admin"})
public class AdminController {

    @Autowired
    private AdminService as;

    //管理员登录
    @RequestMapping("/login")
    public String login(HttpSession session, ModelMap map,HttpServletResponse req,String name, String password,String enCode,String cbx)throws IOException{

        Admin d=as.adminLogin(name,password);

        String code=(String)session.getAttribute("code");

        if(cbx!=null){

            Cookie cookie1=new Cookie("username", URLEncoder.encode(name,"utf-8"));

            cookie1.setPath("/");

            req.addCookie(cookie1);
        }else{

            Cookie cookie2=new Cookie("username", URLEncoder.encode(name,"utf-8"));

            cookie2.setPath("/");

            req.addCookie(cookie2);

            if(d!=null&&code.equals(enCode)){

                map.addAttribute("admin",d);

                return "forward:/main/Main.jsp";
            }

        }

        return "redirect:/login.jsp";
    }

    @RequestMapping("/login2")     //mad方式加密登录
    public String login(String name,String password,boolean rememberMe,String enCode,HttpSession session){

        Admin admin=null;

        String code= (String) session.getAttribute("code");

        Admin admin1 = as.adminLoginByShiro(name);

        session.setAttribute("","");

        if(admin1!=null){

            session.setAttribute("admin",admin1);

            if(enCode!=null&&code.equals(enCode)){
                // 在web环境中安全管理器会自动进行初始化
                Subject subject = SecurityUtils.getSubject();
                try {
                    subject.login(new UsernamePasswordToken(name,password,rememberMe));

                    // 编程式授权
                    System.out.println(subject.hasRole("root") ? "有root角色":"无root角色");
                    return "redirect:/main/Main.jsp";
                } catch (UnknownAccountException e) {
                    e.printStackTrace();
                    return "redirect:/login.jsp";
                } catch (IncorrectCredentialsException ice){
                    ice.printStackTrace();
                    return "redirect:/login.jsp";
                } catch (AuthenticationException ae){
                    ae.printStackTrace();
                    return "redirect:/login.jsp";
                }

            }else{
                return "redirect:/login.jsp";
            }

        }
        return "redirect:/login.jsp";

    }


    //管理员注册
    @RequestMapping("/regist")
    @ResponseBody
    public String regist(Admin admin){


        return "login";
    }

    //管理员退出
    @RequestMapping("/exit")
    public String exit(HttpSession session){


        session.setAttribute("admin",null);

        return "redirect:/login.jsp";
    }

    //管理员修改密码
    @RequestMapping("/change")
    @ResponseBody
    public Integer regist(HttpSession session,String pwd){

        Admin nowadmin= (Admin) session.getAttribute("admin");
        nowadmin.setMgr_pwd(pwd);
        Integer result=as.adminModify(nowadmin);
        if(result==1){
            return result;
        }
        return null;
    }


    //获取验证码
    @RequestMapping("/getVcode")
    @ResponseBody
    public void create(HttpSession session, HttpServletResponse response) throws IOException{

        CreateValidateCode vCode=new CreateValidateCode(100,30,4,10);

        session.setAttribute("code", vCode.getCode());

        System.out.println(vCode.getCode());

        vCode.write(response.getOutputStream());

    }


}
