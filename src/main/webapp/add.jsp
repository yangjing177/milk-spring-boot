<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'MyJsp.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css/wui.min.css">
    <script type="text/javascript" src="js/angular.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/wui-date.js" charset="utf-8"></script>
    <script type="text/javascript">
        var app = angular.module('app',["wui.date"]);

    </script>

    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        .wai{
            width: 800px;
            height: 500px;
            /*border: 1px black solid;*/
        }
        .nei{
            width: 730px;
            height: 460px;
            /*border: 1px #e9e9e9 solid;*/
            margin-top: 20px;
        }
        .d1{
            width: 730px;
            height: 50px;
            /*border: 1px black solid;*/
        }
        .zuo{
            width: 100px;
            height: 50px;
            border-top: 1px #e9e9e9 solid;
            border-right: 1px #e9e9e9 solid;
            border-bottom: 1px #e9e9e9 solid;
            float: left;
            background-color: #f5f5f5;
            line-height: 35px;
        }
        .you{
            width: 628px;
            height: 50px;
            border-top: 1px #e9e9e9 solid;
            border-right: 1px #e9e9e9 solid;
            border-bottom: 1px #e9e9e9 solid;
            float: left;
            line-height: 35px;
        }
        span{
            margin-left: 8px;
        }
    </style>

</head>

<body>
<div class="wai">
    <div class="nei">
<form action="book.do?add" method="post">
    <%--<p>编号:<input type="text" name="id"></p>--%>
        <div class="d1">
            <div class="zuo"><span>书名:</span></div>
            <div class="you">
    <input type="text" name="bname" style="margin-left: 10px">
            </div>
        </div>
        <div class="d1">
            <div class="zuo"><span>作者:</span></div>
            <div class="you">
            <input type="text" name="author" style="margin-left: 10px">
            </div>
        </div>

        <div class="d1">
            <div class="zuo"><span>性别:</span></div>
            <div class="you">
    <input type="radio" name="sex" value="boy" checked="checked" style="margin-left: 10px">男
        <input type="radio" name="sex" value="girl" style="margin-left: 10px">女
            </div>
        </div>

        <div class="d1">
            <div class="zuo"><span>赠品:</span></div>
            <div class="you">
            <input type="checkbox" name="gift" value="钢笔">钢笔
            <input type="checkbox" name="gift" value="毛笔">毛笔
            <input type="checkbox" name="gift" value="铅字笔">铅字笔
            </div>
        </div>

        <div class="d1">
            <div class="zuo"><span>日期：</span></div>
            <div class="you">
            <input type="text" name="time" style="margin-left: 10px">
            </div>
        </div>

        <div class="d1">
            <div class="zuo"><span>图片:</span></div>
            <div class="you">
             <input type="file" name="pic" style="margin-left: 10px">
            </div>
        </div>
        <div class="d1">
            <div class="zuo"></div>
            <div class="you">
                <input type="submit" value="提交" style="margin-left: 10px">
            </div>
        </div>

</form>
    </div>

</div>
</body>
</html>
