<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
    <title>datagride_view</title>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
    $(function () {

    });
    </script>

    <form id="updateMasform" method="post" enctype="multipart/form-data">

    <table  align="center" height="200px" font-family="楷体">
        <tr>
            <td>上师id</td>
            <td><input class="easyui-validatebox" name="master_id" readonly="readonly"/></td>
        </tr>

        <tr>
            <td>上师姓名</td>
            <td><input class="easyui-validatebox" name="master_name" /></td>
        </tr>

        <tr>
            <td>上师简介</td>
            <td><input class="easyui-validatebox"name="master_summar" ></td>
        </tr>

    </table>
    </form>


