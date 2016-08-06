<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
	#container{
		margin:40px auto;
		width:75%;
	    
	}
</style>
</head>
<body>
	<div id= "container">
		<h1>用户登录</h1>
		<div id="login_system">
		<form action="loginservlet" method="post">
			登录名:<input type="text" name="user_name" ><br/>
				  <input type="submit" value="登录">
		</form>
		</div>
	</div>

</body>
</html>