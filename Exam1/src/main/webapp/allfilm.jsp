<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#body{
		text-align: center;
	}
</style>
</head>
<c:if test="${empty pager }">
	<c:redirect url="allfilm"></c:redirect>
</c:if>
<body>
     <div id= "body">
     	<h1>所有电影</h1>
     	<table border="1px">
     		
     	</table>
     </div>
</body>
</html>