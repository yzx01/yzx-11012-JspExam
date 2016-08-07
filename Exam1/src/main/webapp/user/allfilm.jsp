<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored ="false" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<style>
	#body{
		padding-top:60px;
		
	}
	.description{
	     width:500px;
	}
	th{
		text-align: center;
	}
</style>
</head>
<c:if test="${empty pager }">
	<c:redirect url="allfilm"></c:redirect>
</c:if>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a href="#" class="navbar-brand">所有电影</a>
		</div>
	</div>
	</nav>

	<div class="container">
     	<div id="body">
     	<table class="table table-stripea " align="center" cellpadding="0" cellspacing="0">
     		<thead>
     		<tr>
     			<th>电影ID</th>
     			<th>电影名</th>
     			<th>描述</th>
     			<th>语言</th>
     			<th>编辑</th>
     			<th>删除</th>
     		</tr>
     		</thead>
     		<c:forEach items="${pager.list }" var="film">
     			<tr align="center">
     				<td>${film.film.film_id }</td>
     				<td>${film.film.title }</td>
     				<td class="description">${film.film.description }</td>
     				<td>${film.language.name }</td>
     				<td><a href="editfilm?film_id=${film.film.film_id }">编辑</a></td>
     				<td><a href="deletefilm?film_id=${film.film.film_id }">删除</a></td>
     			</tr>
     		</c:forEach>
     		<tr>
				<td colspan="6" align="center">
					<c:choose>
  					<c:when test="${pager.totalPage==1 }">
  					<div class="row">
  						<div class="col-md-1 col-md-offset-3">首页</div>
  						<div class="col-md-1">上一页</div>
  						<div class="col-md-1">下一页</div>
  						<div class="col-md-1">当前第${pager.page}页</div>
  						<div class="col-md-1">总共${pager.totalPage }页</div>
  					</div>
  					</c:when>
  					<c:when test="${pager.totalPage!=1 }">
  						<c:choose>
  						<c:when test="${pager.page==1 }">
  						    <div class="row">
		  						<div class="col-md-1 col-md-offset-3">首页</div>
		  						<div class="col-md-1">上一页</div>
		  						<div class="col-md-1"><a href='allfilm?page=${pager.page+1 }'>下一页</a></div>
		  						<div class="col-md-1">当前第${pager.page}页</div>
		  						<div class="col-md-1">总共${pager.totalPage }页</div>
  							</div>
  							
  						</c:when>
  						<c:when test="${pager.page==pager.totalPage }">
  							 <div class="row">
		  						<div class="col-md-1 col-md-offset-3"><a href='allfilm?page=1'>首页</a></div>
		  						<div class="col-md-1"><a href='allfilm?page=${pager.page-1 }'>上一页</a></div>
		  						<div class="col-md-1">下一页</div>
		  						<div class="col-md-1">当前第${pager.page}页</div>
		  						<div class="col-md-1">总共${pager.totalPage }页</div>
  							</div>
  	
  						</c:when>
  						<c:otherwise>
  							 <div class="row">
		  						<div class="col-md-1 col-md-offset-3"><a href='allfilm?page=1'>首页</a></div>
		  						<div class="col-md-1"><a href='allfilm?page=${pager.page-1 }'>上一页</a></div>
		  						<div class="col-md-1"><a href='allfilm?page=${pager.page+1 }'>下一页</a></div>
		  						<div class="col-md-1">当前第${pager.page}页</div>
		  						<div class="col-md-1">总共${pager.totalPage }页</div>
  							</div>

  						</c:otherwise>
  						</c:choose>
  					</c:when>
  				</c:choose>
				</td>
			</tr>
     		<tr>
     			<td colspan="6" align="right">
     				<div class="row"><div class="col-md-1 col-md-offset-11"><a href="addfilm.jsp">[添加信息]</a></div></div>
     			</td>
     		</tr>
     	</table>
     	</div>
     </div>
</body>
</html>