<%@page import="vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/shopping/css/xyh.css" type="text/css">
<link rel="stylesheet" href="/shopping/css/Table.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div id="formwrapper">
<fieldset>
            <legend style="font-weight:bold"> 登入界面</legend>
用户:${sessionScope.user.nickname}<br>
<button style="color:green" onClick="window.location.href='seller.jsp'">我要做卖家</button>
<button style="color:green" onClick="window.location.href='buyer.jsp'">我要做买家</button>
</fieldset>
</div>
</body>
</html>