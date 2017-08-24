<%@ page language="java" contentType="textml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="textml; charset=UTF-8">
<link rel="stylesheet" href="/shopping/css/xyh.css" type="text/css">
<link rel="stylesheet" href="/shopping/css/Table.css" type="text/css">
<title>登录</title>
</head>
<body> 
    <div id="formwrapper"> 
    <h3>图书商店用户登录</h3>     
    <form action="do_login"  method="post">         
    <fieldset> 
            <legend>登录/注册</legend>             
            <div> 
                <label for="UName">用户名</label> 
                <input type="text" name="userAccount" class="input" id="UName" size="18" maxlength="30" /><br/>             
            </div>             
            <div> 
                <label for="PWord">密码</label> 
                <input type="password" name="userPassword" class="input" id="PWord" size="18" maxlength="30" /><br/>             
            </div> 
            <div class="cookiechk">                                           
                <a href="#" title="选择是否记录您的信息"></a> 
                <input type="submit" value="登录" style="font-size:20px;color:green"> 
                <input type="button" value="注册" style="font-size:20px;color:green" onClick="window.location.href='do_register.jsp'">  
            </div> 
                 
     </fieldset>     
     </form> 
     </div> 
     <hr align="center" noshade color="#FF0000"> <p> 
</body> 
</html>
