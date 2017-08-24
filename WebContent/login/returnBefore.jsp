<%@page import="java.awt.Event"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/shopping/css/Table.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div style="align=center"> 
   <h2>账号与密码不匹配,请重新确认<br>
	两秒后即将跳回登录界面</h2>
   <br>      
   </div> 


	<%
		response.setHeader("refresh","2;URL=chatLogin.jsp");
	%>
</body>
</html>