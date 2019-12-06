<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Contact</h1>
		<form:form action="saveContact" method="post" modelAttribute="contact">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Nr_Maszyny:</td>
				<td><form:input path="Nr_Maszyny" /></td>
			</tr>
			<tr>
				<td>Kod:</td>
				<td><form:input path="Kod" /></td>
			</tr>
			<tr>
				<td>Wydzial:</td>
				<td><form:input path="Wydzial" /></td>
			</tr>
			<tr>
				<td>Gniazdo:</td>
				<td><form:input path="Gniazdo" /></td>
			</tr>
			<tr>
				<td>Sprawnosc:</td>
				<td><form:input path="Sprawnosc" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>