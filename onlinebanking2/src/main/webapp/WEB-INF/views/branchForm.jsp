<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>

<html>
	<head>
		<title>branchForm</title>
		<h1>Loggin in User: ${pageContext.request.userPrincipal.name}</h1>
		<style type="text/css" >
			.error{color:red}
		</style>
	</head>
	<body>
		<form:form action="saveBranchForm" method="post" modelAttribute="branch">
			<table>
			
				<tr>
					<td>Branch Code<form:input type="number" min="0" path="bCode"/>
<%-- 					<form:errors path="bCode"/> --%>
					</td>
				</tr>
				<tr><td>Branch Name <form:input path="name"/></td>
<%-- 					<td><form:errors path="name"/></td> --%>
				</tr>
				<tr><td>Branch Location<form:input path="location"/></td>
<%-- 					<td><form:errors path="location"/></td> --%>
				</tr>
<%-- 				<tr><td>Branch Account(s)<form:input path="accounts"/></td> --%>
<%-- 					<td><form:errors path="location"/></td> --%>
<!-- 				</tr> -->
				
				<tr><td colspan="2"><input type="submit" value="submit"> </td></tr>
			</table>
			<form:errors path="*" cssClass="error"/>
		
		</form:form>
	
	</body>
</html>