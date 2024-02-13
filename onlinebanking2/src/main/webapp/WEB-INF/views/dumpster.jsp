<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<head>
		<title>Hello</title>
		<style type="text/css" >
			.error{color:red}
		</style>
	</head>
	<body>
		
			Welcome to ${pageContext.request.userPrincipal.name}<br>
			<h1>Logged as: ${pageContext.request.userPrincipal.name}</h1>
			
			<security:authorize access="hasAuthority('ADMIN')">
					<a href="/createAccount">Create your account</a><br>
			</security:authorize>
			<security:authentication property="principal"/>
			
			<br><a class="btn btn-warning" href="/edit-todo">Edit Todo</a>
			<div><a class="btn btn-default" href="/add-todo">Add a Todo</a></div>
	</body>
	<br>
	<security:authorize access="isAuthenticated()">
		<jsp:include page="menu.jsp"></jsp:include>
	</security:authorize>

	<form:form action="saveTransfer" method="POST" modelAttribute="transaction">
			<table>
			
				<tr>
					<td>Account Transfer From<form:input path="fromAcc"/>
<%-- 					<form:errors path="fromAcc" cssClass="error"/></td> --%>
				</tr>
				<tr><td>Account Transfer To<form:input path="toAcc"/></td>
<%-- 					<td><form:errors path="toAcc" cssClass="error"/></td> --%>
				</tr>
				<tr><td>Transfer Amount<form:input path="accTx"/></td>
<%-- 					<td><form:errors path="accTx" cssClass="error"/></td> --%>
				</tr>
				<tr><td>Comments<form:input path="comments"/></td>
<%-- 					<td><form:errors path="comments" cssClass="error"/></td> --%>
				</tr>
				<tr><td colspan="2"><input type="submit" value="submit"> </td></tr>
			</table>
			<form:errors path="*" cssClass="error"/>
			
		
		</form:form>

<form:form action="saveCustomer" method="post" modelAttribute="customer">
		
			<table>
			
				<tr>
					<td>First Name: <form:input path="customerfName"/>
					<form:errors path="customerfName" cssClass="error"/></td>
				</tr>
				<tr><td>Last Name: <form:input path="customerlName"/></td>
					<td><form:errors path="customerlName" cssClass="error"/></td>
				</tr>
				<tr><td>Gender: <form:input path="gender"/></td>
					<td><form:errors path="gender" cssClass="error"/></td>
				</tr>
				<tr><td>Mobile: <form:input path="mobile"/></td>
					<td><form:errors path="mobile" cssClass="error"/></td>
				</tr>
				<tr><td>Email: <form:input type="email" path="email"/></td>
					<td><form:errors path="email" cssClass="error"/></td>
				</tr>
				
				<tr><td colspan="2"><input type="submit" value="submit"> </td></tr>
			</table>
			<form:errors path="*" cssClass="error"/>
		
		</form:form>


</html>