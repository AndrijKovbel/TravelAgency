<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>ID</th><th>Tour</th><th>Country</th><th>Price</th><th>Edit</th><th>Delete</th></tr>
    <d:forEach var="info" items="${list}">
        <tr>
            <td>${info.id}</td>
            <td>${info.tour}</td>
            <td>${info.country}</td>
            <td>${info.price}</td>
            <td><a href="edit/${info.id}">Edit</a></td>
            <td><a href="delete/${info.id}">Delete</a></td>
        </tr>
    </d:forEach>
</table>
<br/>
<a href="form">Add New Tour Info</a>
