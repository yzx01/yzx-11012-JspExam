<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加电影</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">

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
<c:if test="${empty language }">
	<c:redirect url="alllanguage"></c:redirect>
</c:if>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a href="#" class="navbar-brand">添加信息</a>
		</div>
	</div>
	</nav>

	<div class="container">
		<div id = "body">
		<form action="addfilm" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-1  control-label "  >Title</label>
				<div class="cols-sm-8">
					<input type="text" name="title" class="form-control" placeholder="Title">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label">Description</label>
				<div class="cols-sm-6">
					<input type="text" name="description" class="form-control" placeholder="Description">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label">Name</label>
				<select class="span1" name="language_id">
					<c:forEach items="${language }" var="language">
						<option value="${language.language_id }">${language.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-info col-sm-2" id="button">Add</button>
			</div>
		</form>
		</div>
	</div>
	
</body>
</html>