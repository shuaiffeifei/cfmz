<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
    <title>datagride_view</title>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
    $(function () {

    });
    </script>

    <form id="cgpic" method="post">
    <table align="center" height="200px" font-family="楷体">
        <tr>
            <td>编号</td>
            <td><input class="easyui-validatebox" name="picture_id" readonly="readonly"/></td>
        </tr>
        <tr>
            <td>轮播图描述</td>
            <td><input class="easyui-validatebox" name="picture_description"/></td>
        </tr>

        <tr>
            <td>轮播图状态</td>
            <td><select id="cc" class="easyui-combobox" name="picture_status"style="width:200px;">
                <option value="未展示">未展示</option>
                <option value="展示中">展示中</option>
                </select></td>
        </tr>

    </table>
    </form>


