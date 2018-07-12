<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib  uri="http://shiro.apache.org/tags" prefix="shiro"%>
    <title>datagride_view</title>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
    $(function () {
        <shiro:hasPermission name="user:query">
        $('#Mastab').datagrid({
            title:'上师管理',
            remoteSort:false,
            singleSelect:true,
            rownumbers:false,
            nowrap:false,
            fitColumns:true,
            toolbar:"#tb1",
            pagination : true,
            pageList : [1 ,2, 5, 10],
            pageSize:5,
            url:'${pageContext.request.contextPath}/master/show',
            columns:[[
                {field:'master_id',title:'上师编号',width:120,align:'center'},
                {field:'master_name',title:'上师名',width:100,align:'center',sortable:true},
                {field:'master_photo',title:'上师图片',width:80,align:'center',sortable:true},
                {field:'master_summar',title:'上师简介',width:100,align:'center',sortable:true},
                {field:"operation",title:"操作",formatter:function(value,row,index){ // 格式化展示数据到对应的列
                    return "<a>暂未开发</a>";
                }},
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return "<table><tr><td rowspan=2 style='border:0'><img style='height:300px; width:400px;' src='http://localhost:8899/cmfz-admin/upload/"+ rowData.master_photo +"' /></tr></td></table>";
            }

        });
        </shiro:hasPermission>

        //添加上师
        $('#addMas').linkbutton({
            onClick:function(){
                $("#dialog1").dialog({
                    width:650,
                    height:400,
                    title:"新增上师",
                    toolbar:[{
                        iconCls:"icon-help",
                        text:"帮助",
                        handler:function(){
                            alert("该功能由百知教育出品，用于添加员工,如有疑问请联系管理员");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/addMasForm.jsp",  // 加载表单元素的子页面
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-save",
                        text:"保存",
                        handler:function(){

                            alert("保存成功!");

                            //提交表单
                            $("#addMasform").form("submit",{
                                url:"${pageContext.request.contextPath}/master/add",
                                onSubmit:function(){
                                    return $("#addMasform").form("validate");
                                },
                                success:function (data) {

                                    $("#dialog1").dialog("close");

                                    $("#Mastab").datagrid("reload")
                                }
                            });
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            $("#dialog1").dialog("close");
                        }
                    }]

                })
            }
        });

        //修改上师
        $("#changeMas").linkbutton({

            onClick:function () {

                var rowData=$("#Mastab").datagrid("getSelected");

                $("#newdialog1").dialog({
                    title:"修改上师",
                    resizable:true,
                    width : 600,
                    height : 500,
                    href : "${pageContext.request.contextPath}/updateMasForm.jsp", //包含子页面
                    toolbar:[{
                        iconCls:"icon-help",
                        text:"帮助",
                        handler:function(){
                            alert("该功能由百知教育出品，用于添加员工,如有疑问请联系管理员");
                        }
                    }],
                    onLoad:function() {
                        $("#updateMasform").form("load",rowData);
                    },
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-save",
                        text:"保存",
                        handler:function(){


                            //提交表单
                            $("#updateMasform").form("submit",{
                                url:"${pageContext.request.contextPath}/master/update",
                                onSubmit:function(){
                                    return $("#updateMasform").form("validate");
                                },

                                success:function (data) {

                                    $("#newdialog1").dialog("close");

                                    $("#Mastab").datagrid("reload")

                                }
                            });
                        }

                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            $("#newdialog1").dialog("close");
                        }
                    }]
                })
            }

        });


        //删除上师
        $("#cancelMas").linkbutton({
            onClick: function () {
                var rowData = $("#Mastab").datagrid("getSelected");
                console.log(rowData);
                alert("hi!")
                $("#dialog2").dialog({

                    width: 400,
                    height: 300,
                    title: "删除上师",
                    content: "您确定要删除该上师么？",
                    buttons: [{
                        iconCls: "icon-save",
                        text: "确认",
                        handler: function () {

                            $.post("${pageContext.request.contextPath}/master/drop",{id:rowData.master_id},function (data){

                                    $("#dialog2").dialog("close");
                                    $("#Mastab").datagrid("reload")
                                }
                            );

                        }
                    }, {
                        iconCls: "icon-cancek",
                        text: "取消",
                        handler: function () {
                            $("#dialog2").dialog("close");
                        }
                    }]

                });
            }
        });



        //批量插入
        $("#insertforMore").linkbutton({
            onClick:function(){
                $("#dialog3").dialog({
                    width: 400,
                    height: 300,
                    title: "批量插入",
                    content: "批量插入数据，安全高效！",
                    href : "${pageContext.request.contextPath}/insertFileForm.jsp",
                    buttons: [{
                        iconCls: "icon-save",
                        text: "确认",
                        handler: function () {
                            $("#AddDataform").form("submit",{

                                url:"${pageContext.request.contextPath}/master/import",
                                onSubmit:function(){
                                    return $("#AddDataform").form("validate");
                                },

                                success:function (data) {

                                    $("#dialog3").dialog("close");

                                    $("#Mastab").datagrid("reload")
                                }
                            });
                        }
                    }, {
                        iconCls: "icon-cancek",
                        text: "取消",
                        handler: function () {
                            $("#dialog3").dialog("close");
                        }
                    }]

                });
            }
        })
    });


    function qq(value, name) {

        alert(value + ":" + name);

        // 加载第一页的数据 并且携带额外的请求参数
        $('#Mastab').datagrid('load', {
            value:value,
            name:name
        });
    }


    </script>
<table id="Mastab"></table>


    <div id="tb1" style="display: none">
        <shiro:hasPermission name="user:add">
        <a id="addMas" href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true,text:'新增上师'"></a>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:modify">
        <a id="changeMas" href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-reload',plain:true,text:'修改上师'"></a>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:remove">
        <a id="cancelMas" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel',plain:true,text:'删除上师'"></a>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:add">
        <a id="insertforMore" class="easyui-linkbutton"
           data-options="iconCls:'icon-client',plain:true,text:'批量插入'"></a>
        </shiro:hasPermission>
        <shiro:hasPermission name="user:query">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"/>
        <input class="easyui-searchbox" style="width:300px" data-options="searcher:qq,prompt:'请您输入需要模糊查询的内容',menu:'#mm'" />
        <div id="mm">
            <div data-options="name:'name',iconCls:'icon-client'">姓名</div>
        </div>
        </shiro:hasPermission>
        <div id="dialog1"></div>
        <div id="newdialog1"></div>
        <div id="dialog2"></div>
        <div id="dialog3"></div>
    </div>




