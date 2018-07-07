<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-06
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

        $(function () {

            $.extend($.fn.validatebox.defaults.rules, {
                equals: {
                    validator: function(value,param){
                        return value == $(param[0]).val();
                    },
                    message: 'Field do not match.'
                }
            });


        })

    </script>
</head>
<body>
<form id="PwdChange">

    <table align="center">
        <tr>
            <td>请输入密码</td>
            <td><input id="pwd" name="pwd" type="password" class="easyui-validatebox" data-options="required:true" /></td>
        <tr>
        <tr>
            <td>请重复输入密码</td>
            <td><input id="rpwd" name="rpwd" type="password" class="easyui-validatebox"
                       required="required" validType="equals['#pwd']" />
        <tr>
    </table>

</form>
</body>
</html>
