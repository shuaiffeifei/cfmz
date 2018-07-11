<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-09
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<title>datagride_view</title>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript">
    $(function () {
        $('#atcmgr').datagrid({
            title:'文章管理页',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            toolbar:"#tb3",
            pagination : true,
            pageList : [ 1, 3, 5, 7, 10 ],
            pageSize:5,
            url:'${pageContext.request.contextPath}/article/show',
            columns:[[
                {field:'article_id',title:'编号',width:120,align:'center'},
                {field:'article_name',title:'标题',width:100,align:'center',sortable:true},
                {field:'main_pic',title:'链接',width:80,align:'center',sortable:true},
                {field:'status',title:'状态',width:100,align:'center',sortable:true},
                {field:'date',title:'创建时间',width:60,align:'center'},
                {field:'master_name',title:'所属大师',width:60,align:'center'},
                {field:"operation",title:"操作",formatter:function(value,row,index){ // 格式化展示数据到对应的列
                    return "<a>暂未开发</a>";
                }},
            ]],
           /* view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return "<table><tr><td rowspan=2 style='border:0'><img style='height:300px; width:400px;' src='${pageContext.request.contextPath}/upload/"+ rowData.picture_path +"' /></td></tr>" +
                    "<td>图片描述:"+ rowData.picture_description +"</td>" +
                    "<td>上线状态:"+ rowData.picture_status+"</td></table>";
            }*/
        });
        $('#dg').datagrid({
            toolbar: '#tb'
        });

        $("#drop").linkbutton({
            onClick: function () {
                var rowData = $("#atcmgr").datagrid("getSelected");
                console.log(rowData);
                alert("hi!")
                $("#Dropdialog").dialog({

                    width: 400,
                    height: 300,
                    title: "删除员工",
                    content: "您确定要删除该文章么？",
                    buttons: [{
                        iconCls: "icon-ok",
                        text: "确认",
                        handler: function () {
                            $.post("${pageContext.request.contextPath}/article/drop",{id:rowData.article_id},function (data){

                                    $("#Dropdialog").dialog("close");
                                    $("#atcmgr").datagrid("reload")
                                }
                            );
                        }
                    }, {
                        iconCls: "icon-cancek",
                        text: "取消",
                        handler: function () {
                            $("#Dropdialog").dialog("close");
                        }
                    }]

                });
            }
        });


        //文章详情
        $("#detail").linkbutton({
            onClick:function () {
                var rowData = $("#atcmgr").datagrid("getSelected");
                console.log(rowData);
                alert("文章详情");
                $('#win').window({
                    width:600,
                    height:400,
                    title:'文章详情',
                    modal:true,
                    iconCls:'icon-save',

                });

                /*$("#dt").html(rowData.introduction);*/
            }
        })

    });

</script>
<table id="atcmgr"></table>


<div id="tb3" style="display: none">

    <a id="detail" href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-reload',plain:true,text:'文章详情'"></a>
    <a id="change" href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-update',plain:true,text:'文章编写'"></a>
    <a id="drop" href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-update',plain:true,text:'文章删除'"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"/>
    <div id="win"></div>
    <div id="dialog"></div>
    <div id="Dropdialog"></div>
</div>





