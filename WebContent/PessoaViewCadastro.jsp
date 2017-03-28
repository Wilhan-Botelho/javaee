<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="pessoa" scope="request" class="com.javaee.wilhanbotelho.PessoaModel"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.jsp" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
  
	<div class="panel panel-default">
		<div class="panel-body">
			<form method="post" action="./pessoa">
			  	<div class="form-group">
			  		<label for="id">ID:</label>
				  	<input type="number" class="form-control" name="id" id="id" value="<jsp:getProperty property="id" name="pessoa"/>">
				</div>
			  	<div class="form-group">
				  <label for="nome">Nome:</label>
				  <input type="text" class="form-control" name="nome" id="nome" value="<jsp:getProperty property="nome" name="pessoa"/>">
				</div>
				<div class="form-group">
				  <label for="email">Email:</label>
				  <input type="text" class="form-control" name="email" id="email" value="<jsp:getProperty property="email" name="pessoa"/>">
				</div>
				<div class="form-group">
					  <label for="ativo">Ativo:</label>
					  <select class="form-control" name="ativo" id="ativo">
					    <option value="false" <c:if test="${not pessoa.ativo}">selected</c:if> >Não</option>
					    <option value="true" <c:if test="${pessoa.ativo}">selected</c:if> >Sim</option>
					  </select>
				</div>
				<div class="form-group">
				  <button type="submit" class="btn btn-info">Salvar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>