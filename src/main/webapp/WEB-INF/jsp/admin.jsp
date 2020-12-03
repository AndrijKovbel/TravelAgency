<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="css/admin.css" rel="stylesheet">
    <title>Travel Agency</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Travel Agency</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <sec:authorize access="hasAnyRole('ADMIN','SUPER_ADMIN')">
                <li class="nav-item active">
                    <a class="nav-link" href="form">Add new Tour <span class="sr-only">(current)</span></a>
                </li>
            </sec:authorize>
            <li class="nav-item">
                <a class="nav-link" href="view">View All Tours</a>
            </li>
        </ul>
    </div>
    <sec:authorize access="hasAnyRole('ADMIN')">
        <div class="list_user">
            <a href="/admin">List of registered User</a>
        </div>
    </sec:authorize>
    <div>
        <div>
            <a href="/logout">Logout</a>
        </div>
    </div>
</nav>
    <h1>Hello Admin This List of registered User</h1>
<br>
    <table border = "1" cellpadding = "5" cellspacing = "5">
            <thead>
            <th>UserName</th>
            <th>Password</th>
            <th>Roles</th>
            <th>Action</th>
            </thead>
            <c:forEach items="${allUsers}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>
                        <c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/admin" method="post">

                            <input type="hidden" name="userId" value="${user.id}"/>
                            <input type="hidden" name="action" value="delete"/>

                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
    </table>
<br>
<br>
        <a class="main-page" href="/">Main Page</a>
</body>
</html>