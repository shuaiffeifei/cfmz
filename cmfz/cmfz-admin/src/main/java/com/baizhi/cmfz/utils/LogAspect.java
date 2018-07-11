package com.baizhi.cmfz.utils;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by Administrator on 2018-07-09.
 */

@Aspect
public class LogAspect {


    @Autowired
    private LogbookService logbookService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private MasterService masterService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private ArticleService articleService;

    /**
     * 管理员登录方法的切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.imp.AdminServiceImpl.adminLogin(..))")
    public void loginCell(){}

    /**
     * 添加业务逻辑方法切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.imp.MasterServiceImpl.addMaster(..)) ||  execution(* com.baizhi.cmfz.service.imp.ArticleServiceImpl.addArticle(..)) || execution(* com.baizhi.cmfz.service.imp.PictureServiceImpl.addPicture(..))")
    public void insertCell() {}

    /**
     * 修改业务逻辑方法切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.imp.*.modify*(..))")
    public void updateCell() {}

    /**
     * 删除业务逻辑方法切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.imp.*.drop*(..)) ")
    public void deleteCell() {}

   /* *//**
     * 导入业务逻辑方法切入点
     *//*
    @Pointcut("execution(* com.jixi.service.impl.*.import*(..))")
    public void importCell() {}

    *//**
     * 导出业务逻辑方法切入点
     *//*
    @Pointcut("execution(* com.jixi.service.impl.*.export*(..))")
    public void exportCell() {}*/

    /**
     * 登录操作(后置通知)
     * @param joinPoint
     * @param object
     * @Param Throwable
     */
    @AfterReturning(value = "loginCell()", argNames = "joinPoint,object", returning = "object")
    public void loginLog(JoinPoint joinPoint, Object object) throws Throwable {
        Admin user=(Admin)object;
        if (user==null) {
            return;
        }

        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取操作内容
        Object[] args = joinPoint.getArgs();
        Log log=new Log();
        log.setId(UUIDUtils.getUUID());
        log.setUser(user.getMgr_name());
        log.setAction("管理员登录");
        log.setResource(methodName.substring(5));
        log.setMessage(args[0].toString());
        log.setResult("登陆成功");
        logbookService.addLog(log);
    }

    /**
     * * 添加操作日志(环绕通知)
     *
     **/


     /** 添加操作日志（后置通知）
     * @Param joinPoint
     */

    @Around("insertCell()")
    public Object insertLog(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        //获取方法名
        String methodName = joinPoint.getSignature().getName();

        //获取参数
        Object[] args = joinPoint.getArgs();
        Log logbook=new Log();
        logbook.setId(UUIDUtils.getUUID());
        logbook.setMessage(args[0].toString());
        Admin admin = (Admin) session.getAttribute("admin");

        if (admin!=null){
            logbook.setUser(admin.getMgr_name());
        }
        logbook.setAction("添加");
        logbook.setResult("success");
        logbook.setResource(methodName.substring(3));
        System.out.println(logbook.toString());
        logbookService.addLog(logbook);

        return  joinPoint.proceed();
    }

    /**
     * 删除操作
     *
     * @param joinPoint
     */
   @Around("deleteCell()")
    public Object deleteLog(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();


        // 获取方法名
        String methodName = joinPoint.getSignature().getName();


       Object[] args = joinPoint.getArgs();


       // 创建日志对象
        Log log = new Log();
        log.setMessage(args[0].toString());

        Admin admin= (Admin) session.getAttribute("admin");
        if (admin!=null){
           log.setUser(admin.getMgr_name());
        }

        log.setResult("成功");
        log.setAction("删除");// 操作
        log.setId(UUIDUtils.getUUID());
        log.setResource(methodName.substring(4));
        logbookService.addLog(log);

        return joinPoint.proceed();
    }


    @Around("updateCell()")
    public Object updatetLog(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        //获取方法名
        String methodName = joinPoint.getSignature().getName();

        //获取参数
        Object[] args = joinPoint.getArgs();
        Log logbook=new Log();
        logbook.setId(UUIDUtils.getUUID());
        logbook.setMessage(args[0].toString());
        Admin admin = (Admin) session.getAttribute("admin");

        if (admin!=null){
            logbook.setUser(admin.getMgr_name());
        }
        logbook.setAction("修改");
        logbook.setResult("success");
        logbook.setResource(methodName.substring(6));
        System.out.println(logbook.toString());
        logbookService.addLog(logbook);

        return  joinPoint.proceed();
    }
}


