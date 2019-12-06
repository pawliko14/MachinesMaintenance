<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Contact List</h1>
	        <h3><a href="newContact">New Contact</a></h3>
	        <table border="1">
	        	<th>ID</th>
	        	<th>Nr_Maszyny</th>
	        	<th>Kod</th>
	        	<th>Wydzial</th>
	        	<th>Gniazdo</th>
	        	<th>Sprawnosc</th>
	        	
	 <c:forEach items="${listCustomer}" var="customer">
        <tr>
            <td>${Machine.ID}</td>
            <td>${Machine.Nr_Maszyny}</td>
            <td>${Machine.Kod}</td>
            <td>${Machine.Wydzial}</td>
            <td>${Machine.Gniazdo}</td>
            <td>${Machine.Sprawnosc}</td>
            
            <td>
                <a href="/edit?id=${Machine.ID}">Edit</a>
                <a href="/delete?id=${Machine.ID}">Delete</a>
            </td>
        </tr>
        </c:forEach>	
			        	
			        	
			</table>
    	</div>
    </body>
</html>
