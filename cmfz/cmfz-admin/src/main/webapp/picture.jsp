<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
    <title>datagride_view</title>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
    $(function () {
        $('#picmgr').datagrid({
            title:'轮播图管理页',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            toolbar:"#tb2",
            pagination : true,
            pageList : [ 1, 3, 5, 7, 10 ],
            pageSize:5,
            url:'${pageContext.request.contextPath}/picture/showAll',
            columns:[[
                {field:'picture_id',title:'标识编号',width:120,align:'center'},
                {field:'picture_path',title:'文件名',width:100,align:'center',sortable:true},
                {field:'picture_date',title:'存储日期',width:80,align:'center',sortable:true},
                {field:'picture_description',title:'详细描述',width:100,align:'center',sortable:true},
                {field:'picture_status',title:'上线状态',width:60,align:'center'},
                {field:"operation",title:"操作",formatter:function(value,row,index){ // 格式化展示数据到对应的列
                    return "<a>暂未开发</a>";
                }},
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return "<table><tr><td rowspan=2 style='border:0'><img style='height:300px; width:400px;' src='${pageContext.request.contextPath}/upload/"+ rowData.picture_path +"' /></td></tr>" +
                    "<td>图片描述:"+ rowData.picture_description +"</td>" +
                    "<td>上线状态:"+ rowData.picture_status+"</td></table>";
            }
        });
        $('#dg').datagrid({
            toolbar: '#tb'
        });

        $('#adda').linkbutton({
            onClick:function(){
                $("#dialog").dialog({
                    width:650,
                    height:400,
                    title:"新增图片",
                    toolbar:[{
                        iconCls:"icon-help",
                        text:"帮助",
                        handler:function(){
                            alert("该功能由百知教育出品，用于添加员工,如有疑问请联系管理员");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/addpicture.jsp",  // 加载表单元素的子页面
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-save",
                        text:"保存",
                        handler:function(){

                            alert("保存成功!");

                            //提交表单
                            $("#addpic").form("submit",{
                                url:"${pageContext.request.contextPath}/picture/add",
                                onSubmit:function(){
                                    return $("#addpic").form("validate");
                                },
                                success:function (data) {

                                    $("#dialog").dialog("close");

                                    $("#picmgr").datagrid("reload")
                                }
                            });
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            $("#dialog").dialog("close");
                        }
                    }]

                })
            }
        });


        //修改轮播图
        $("#change").linkbutton({

            onClick:function () {

                var rowData=$("#picmgr").datagrid("getSelected");

                $("#newdialog").dialog({
                    title:"修改员工",
                    resizable:true,
                    width : 600,
                    height : 500,
                    href : "${pageContext.request.contextPath}/changepicture.jsp", //包含子页面
                    toolbar:[{
                        iconCls:"icon-help",
                        text:"帮助",
                        handler:function(){
                            alert("该功能由百知教育出品，用于添加员工,如有疑问请联系管理员");
                        }
                    }],
                    onLoad:function() {
                        $("#cgpic").form("load",rowData);
                    },
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-save",
                        text:"保存",
                        handler:function(){


                            //提交表单
                            $("#cgpic").form("submit",{
                                url:"${pageContext.request.contextPath}/picture/update",
                                onSubmit:function(){
                                    return $("#cgpic").form("validate");
                                },

                                success:function (data) {

                                    $("#newdialog").dialog("close");

                                    $("#picmgr").datagrid("reload")

                                }
                            });
                        }

                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            $("#newdialog").dialog("close");
                        }
                    }]
                })
            }

        })




    });


    </script>
<table id="picmgr"></table>


    <div id="tb2" style="display: none">

        <a id="adda" href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'"></a>
        <a id="change" href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-reload',plain:true,text:'修改轮播图'"></a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"/>
        <div id="dialog"></div>
        <div id="newdialog"></div>
    </div>




