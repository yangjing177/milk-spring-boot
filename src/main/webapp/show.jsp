<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
  </head>
  
  <body>
    <table>
    	<tr>
    		<td>编号</td>
    		<td>书名</td>
    		<td>作者</td>
    		<td>性别</td>
    		<td>赠品</td>
    		<td>时间</td>
    		<td>图片</td>
    	</tr>
    	<c:forEach items="${list}" var="b">
    	<tr>
    		<td>${b.id}</td>
    		<td>${b.bname}</td>
    		<td>${b.author}</td>
			<td>${b.sex}</td>
			<td>${b.gift}</td>
    		<td><f:formatDate value="${b.time}" pattern="yyyy-MM-dd"/></td>
    		<td>${b.pic}</td>
    		<td><a href="book.do?delete&id=${b.id}">删除</a></td>
    		<td><a href="book.do?findOne&id=${b.id}">修改</a></td>
    	</tr>
    	</c:forEach>
    </table>
    
  </body>
</html>
