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
			<c:if test="${not empty pessoaalterada}">
				<div class="alert alert-success" role="alert">
					Pessoa código <c:out value="${pessoaalterada.id}" /> salva com sucesso.
				</div>
			</c:if>
			<c:if test="${not empty pessoaexcluida}">
				<div class="alert alert-danger" role="alert">
					Pessoa código <c:out value="${pessoaexcluida.id}" /> excluída com sucesso.
				</div>
			</c:if>
			<c:choose>
				<c:when test="${not empty listapessoa}">
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
						  		<tr>
									<th>Id</th>
									<th>Nome</th>
									<th>Email</th>
									<th>Ativo</th>
									<th>Editar</th>
									<th>Excluir</th>
						   		</tr>
						 	</thead>
						 	<tbody>
						   		<c:forEach var="item" items="${listapessoa}">
									<tr>
										<td>${item.id}</td>
							       		<td>${item.nome}</td>
							       		<td>${item.email}</td>
							       		<td><input type="checkbox" class="disabled" <c:if test="${item.ativo}">checked</c:if> value="${item.ativo}"></td>
							       		<td><a href="./pessoa?q=editar&id=${item.id}"><button type="button" class="btn btn-info">Editar</button></a></td>
							       		<td><a href="./pessoa?q=excluir&id=${item.id}"><button type="button" class="btn btn-danger">Excluir</button></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<div class="alert alert-success" role="alert">
						Sem Pessoas para exibir.</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>