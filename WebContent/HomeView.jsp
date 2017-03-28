<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="home" scope="request" class="com.javaee.wilhanbotelho.HomeModel"></jsp:useBean>
<html>
<head>
	<jsp:include page="header.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="panel panel-default">
	<div class="panel-body">
		Olá, <jsp:getProperty property="saudacao" name="home" />.
	</div>
</div>

</body>
</html>