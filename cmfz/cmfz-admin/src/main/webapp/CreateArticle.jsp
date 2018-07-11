<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-08
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
        var editor = new E('#editor')
        // 或者 var editor = new E( document.getElementById('editor') )
        editor.customConfig.uploadImgServer ='${pageContext.request.contextPath}/rt/upload';  // 上传图片到服务器
        editor.customConfig.uploadFileName = 'Myfiles'; //上传图片的名称
        var $text1 = $('#text1')
        editor.customConfig.onchange = function (html) {
            // 监控变化，同步更新到 textarea
            $text1.val(html)
    }


    editor.create()
    // 初始化 textarea 的值

    $text1.val(editor.txt.html())

    editor.customConfig.onblur = function (html) {
        // html 即编辑器中的内容
        console.log('onblur', html)
    }


           $(function () {
            $("#authorbox").combobox({
                url:'${pageContext.request.contextPath}/master/allMasters',
                valueField:"master_id",
                textField:"master_name",
                limitToList:true
            });


        $("#submitbtn").linkbutton({

            onClick:function () {
                        $("#articlefrom").form('submit',{
                            url:"${pageContext.request.contextPath}/article/add",
                            onSubmit:function () {
                                /*return $("#articlefrom").validate();*/
                                return true;
                            },
                            success:function (data) {
                                alert("提交成功");
                                location.href="${pageContext.request.contextPath}/main/Main.jsp"
                            }
                        });
            }
        });


       //清空输入内容
        $("#resetbtn").linkbutton({
            onClick:function () {
                $("#editor").text("");
                var E = window.wangEditor
                var editor = new E('#editor')
                editor.create()
            }
        })
    });

    function test() {
        alert(editor.txt.html());
    }

</script>
<div id="contain" style="background-color: #9cc8f7">
<h1 align="center"><font style="color: #333333;font-family:'楷体'">文章编写模块</font></h1>
<form id="articlefrom" method="post" style="margin-top: 50px;">
    
    文章标题:<input class="easyui-validatebox" name="article_name" /><br><br><br><br>
    文章作者:<input id="authorbox" name="guru_id"/><br><br><br><br>
    文章状态:<input class="easyui-switchbutton" name="status" data-options="onText:'上架',offText:'未上架'"/><br><br><br><br>

<div id="editor">
    <p>请在此处输入文章内容...</p>
</div>
    <input id="text1" name="introduction" hidden="hidden"/>
</form>
    <a id="submitbtn" href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-add',plain:true,text:'提交文章'"></a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a id="resetbtn" href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true,text:'重置文章'"></a>
    <button id="btn" onclick="test()">点击获取富文本编辑器中的内容</button>
</div>

<div id="dialog1"></div>

