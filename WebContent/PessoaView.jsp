<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="pessoa" scope="request" class="com.javaee.wilhanbotelho.PessoaModel"></jsp:useBean>
<html>
<head>
	<jsp:include page="header.jsp" />
</head>
<body>
	Nome: <jsp:getProperty property="nome" name="pessoa"/>
	Email: <jsp:getProperty property="email" name="pessoa"/>
</body>
</html>