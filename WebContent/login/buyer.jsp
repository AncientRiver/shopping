<%@page import="java.util.List"%>
<%@page import="vo.Goods"%>
<%@page import="factory.DaoFactory"%>
<%@ page language="java" contentType="textml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="textml; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#nav {
    display:block;
    margin:0;
    padding:0;
    overflow:hidden;
}
#nav li {
    margin:0;
    display:inline;
    padding:3;
    float:left;
}
</style>
</head>
<body>
<%
	List<Goods> list=DaoFactory.getGoodsDao().findAll();
	request.setAttribute("it", list);
%>
<div style="float:right">
用户:${sessionScope.user.nickname}
<form action="broswer_record"> 
	<input type="submit" value="购物车" style="color:green">
</form>
<br>
</div>
	<ul id="nav">
	<c:forEach items="${it}" var="temp">
			<li>
			<img  src="../upload/${temp.goodsPictureId }"  height="160" width="150" }><br>
			<span>${temp.goodsName }</span><br>
			<span>售价:${temp.goodsPrice }</span>
			<form action="insert_record">
				<input type="hidden" name="goodsName" value=${temp.goodsName }>
				<input type="hidden" name="buyer" value=${sessionScope.user.userAccount }>
				<input type="hidden" name="seller" value=${temp.seller }>
				<input type="submit" value="购买">
			</form>
	</c:forEach>
	</ul>	
</body>
<ml>

