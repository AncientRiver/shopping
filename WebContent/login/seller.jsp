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
            
<form action="upload_info"  method="post"
				enctype="multipart/form-data">
		商品名称：<input type="text" name="goodsName" ><br>
		商品价格：<input type="text" name="goodsPrice"><br>
		商品图片:<input type="file" name="goodsPic"><br>
		<input type="submit" >
</form>
</fieldset>
</div>
</body>
</html>