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
    <%--<script type="text/javascript" src="plugins/jquery-1.8.3.js"></script>--%>
    <%--<script type="text/javascript">--%>
        <%--function login(){--%>
            <%--var uname=document.getElementById("uname").value;--%>
            <%--var upwd=document.getElementById("upwd").value;--%>
            <%--var type=document.getElementById("type").value;--%>
            <%--$.ajax({--%>
                <%--url:'user.do?login',--%>
                <%--data:'uname='+uname+'&upwd='+upwd+'&type='+type,--%>
                <%--dataType:'json',--%>
                <%--type:'post',--%>
                <%--success:function(result){--%>
                    <%--alert(result.type);--%>
                    <%--alert("success");--%>
                <%--}--%>
            <%--});--%>
        <%--}--%>
    <%--</script>--%>

</head>

<body>
<form action="user.do?login" method="post">
    <p>用户名:<input type="text" name="uname" id="uname"></p>
    <p>密码:<input type="text" name="upwd" id="upwd"></p>
    <p>类型:<input type="text" name="type" id="type"></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>