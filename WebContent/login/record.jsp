<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/shopping/css/xyh.css" type="text/css">
<link rel="stylesheet" href="/shopping/css/Table.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div style="align:center">
	用户:${sessionScope.user.nickname}
	<br>
	<table class="default">
		<tr>
			<th>购买物品</th>
			<th>购买时间</th>
		</tr>
		<c:forEach items="${recordList}" var="temp">
			<tr>
				<td>${temp.goodsName }</td>
				<td>${temp.time}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>