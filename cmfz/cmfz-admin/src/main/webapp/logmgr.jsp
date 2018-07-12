<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib  uri="http://shiro.apache.org/tags" prefix="shiro"%>
    <title>日志管理</title>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
    $(function () {
        <shiro:hasPermission name="user:query">
        $('#logmgr').datagrid({
            title:'日志管理页',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            toolbar:"#tr",
            pagination : true,
            pageList : [ 1, 2, 4, 10 ],
            pageSize:2,
            url:'${pageContext.request.contextPath}/log/showall',
            columns:[[
                {field:'id',title:'日志编号',width:120,align:'center'},
                {field:'user',title:'用户名',width:100,align:'center',sortable:true},
                {field:'time',title:'时间',width:80,align:'center',sortable:true},
                {field:'resource',title:'操作资源',width:100,align:'center',sortable:true},
                {field:'action',title:'动作',width:60,align:'center'},
                {field:'message',title:'详细信息',width:60,align:'center'},
                {field:'result',title:'处理结果',width:60,align:'center'},
            ]],
        });
        </shiro:hasPermission>
        $('#dg').datagrid({
            toolbar: '#tb'
        });

        $("#droplog").linkbutton({
            onClick: function () {
                var rowData = $("#logmgr").datagrid("getSelected");
                console.log(rowData);
                alert("hi!");
                $("#dropdialog").dialog({

                    width: 400,
                    height: 300,
                    title: "删除日志",
                    content: "您确定要删除该条日志么？",
                    buttons: [{
                        iconCls: "icon-save",
                        text: "确认",
                        handler: function () {

                            $.post("${pageContext.request.contextPath}/log/drop",{id:rowData.id},function (data){

                                    $("#dropdialog").dialog("close");
                                    $("#logmgr").datagrid("reload")
                                }
                            );

                        }
                    }, {
                        iconCls: "icon-cancek",
                        text: "取消",
                        handler: function () {
                            $("#dropdialog").dialog("close");
                        }
                    }]

                });
            }
        })

    });

    </script>

<table id="logmgr"></table>
<div id="tr" style="display: none">
    <shiro:hasPermission name="user:remove">
    <a id="droplog" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true,text:'删除日志'"></a>
    </shiro:hasPermission>
    <div id="dropdialog"></div>
</div>




