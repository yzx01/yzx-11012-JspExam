<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<style type="text/css">
	#body{
		margin-top:100px;
		width:60%;
		text-align:center;
		margin-left:200px;
		margin-right:270px;
	}
	#id{
		padding-left:-50px;
	}
	select{
		margin-left:-95%;
		margin-top:40px;
	}
	#button{
		margin-right:100px;
	}
</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a href="#" class="navbar-brand">登录界面</a>
		</div>
	</div>
	</nav>
	<div class="container col-sm-offset-2">
		<div id = "body">
		<form action="loginservlet" method="post" class="form-horizontal " role="form">
			<div class="form-group">
				<label class="col-sm-1  control-label "  >User</label>
				<div class="col-sm-6">
					<input type="text" name="user_name" class="form-control col-sm-2" placeholder="User">
				</div>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-info col-sm-2 col-sm-offset-5" id="button">Login</button>
			</div>
		</form>
		</div>
	</div>

</body>
</html>