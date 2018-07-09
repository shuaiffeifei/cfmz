<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/china.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/vintage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
	function addTab(menuName,menuURL,icon) {
	    //创建选项卡面板
		var b=$("#tt").tabs("exists",menuName);
		if(b){
		    $("#tt").tabs("select",menuName);
		}else{
            $("#tt").tabs("add",{
                title:menuName,
                closable:true,
				href:"${pageContext.request.contextPath}"+menuURL,
				iconCls:icon,
            });

		}
    }

	$(function () {
	 $.ajax({
	 url:"http://localhost:8899/cmfz-admin/getSons",
	 dataType:"json",
	 success:function (res) {
	     console.log(res);
	     //遍历响应集合
		 //参数res:代表当前遍历的集合
		 //index:当前遍历的下表
		 //obj 遍历过程中的临时遍历
		 $.each(res,function(index,obj){
		     console.log(obj);
		     var content="";
		     $.each(obj.lists,function (index1,obj1) {
				  content +="<p style=\"text-align: center\"><a class=\"easyui-linkbutton\" data-options=\"iconCls:'"+obj1.menu_icon+"',plain:true\" onclick=\"addTab('"+obj1.menu_name+"','"+obj1.menu_url+"','"+obj1.menu_icon+"')\">"+obj1.menu_name+"</a></p>"
             });

		     $("#aa").accordion("add",{
		        title:obj.menu_name,
				iconCls:obj.menu_icon,
				 content:content,
			 });
         });

	   }
	 });

		$('#btn1').linkbutton({

            onClick:function () {
                alert("Hello！");
                $("#dialog").dialog({
                    width:400,
                    height:300,
                    title:"修改信息",
                    toolbar:[{
                        iconCls:"icon-help",
                        text:"帮助",
                        handler:function(){
                            alert("该功能由百知教育出品，用于修改管理员密码,如有疑问请联系后台运营人员");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/ChangePwd.jsp",
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-save",
                        text:"保存",
                        handler:function(){

                            alert("保存成功!");

                            //提交表单
                            $("#PwdChange").form("submit",{
                                url:"${pageContext.request.contextPath}/admin/change",
                                onSubmit:function(){
                                    return $("#PwdChange").form("validate");
                                },
                                success:function (data) {
                                    $("#dialog").dialog("close");
                                }
                            });
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            // 出现消息窗口 并关闭对话框
                            $.messager.show({
                                title:"我的消息",
                                msg:"对话框将在3秒后关闭",
                                timeout:3000,
                                showType:"slider",
                            });

                            $("#dialog").dialog("close");
                        }
                    }]


                })

            }

        });



		$('#btn2').linkbutton({
			onClick:function () {
                $.messager.confirm('确认对话框', '您想要退出该系统吗？', function(r){
                    if (r){
                        location.href="${pageContext.request.contextPath}/admin/exit"
                    }
                });
            }
		})

    });
	
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color: mediumaquamarine">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.mgr_name} &nbsp;<a id="btn1" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" id="btn2" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: mediumaquamarine">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">

		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood'," style="background-image:url(${pageContext.request.contextPath}/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
	<div id="dialog"></div>
</body> 
</html>