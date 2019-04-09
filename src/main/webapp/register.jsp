<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>
    <script type="text/javascript" src="plugins/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        //文档自动加载函数
        $(function(){
            //文本框绑定焦点失去事件
            $("#uname").blur( function(){
                var unameVal = $(this).val();
                $("#unameshow").text("");
                if(unameVal==null||""==unameVal) {
                    $("#unameshow").text("用户不能为空");
                    $("#unameshow").css("background-color","red");
                }else{
                    $.ajax({
                        url: 'user.do?register',
                        data: 'uname=' + unameVal + '&upwd=' + upwd + '&type=' + type,
                        dataType: 'json',
                        type: 'post',
                        success:function (data) {
                            // alert("ajax引擎成功")
                            if(data!=null&&data==true){
                                $("#unameshow").text("用户名已注册");
                                $("#unameshow").css("background-color","red");
                            }else{
                                $("#unameshow").text("用户名可以使用");
                                $("#unameshow").css("background-color","white");
                            }
                        },
                        error:function () {
                            alert("ajax引擎对象加载失败")
                        }
                    });
                }

            });
        });
    </script>

</head>

<body>
<form action="user.do?" method="post">
    <p>编号:<input type="text" name="id" id="id"></p>
    <p>用户名:<input type="text" name="uname" id="uname"><span id="unameshow"></span></p>
    <p>密码:<input type="text" name="upwd" id="upwd"></p>
    <p>类型:<input type="text" name="type" id="type"></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
