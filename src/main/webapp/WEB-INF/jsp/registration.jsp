<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/registration.css">
        <title>Registration</title>
    </head>
     <img src="https://images.creativemarket.com/0.1.0/ps/7901653/580/387/m2/fpnw/wm0/creativee-05-.jpg?1583899424&s=d71db22c9c5e2e23e2e705269887971f" alt="Logo">
    <body>
        <div>
            <form:form method="POST" modelAttribute='userForm'>
                <h1>Registration</h1>
                <div>
                    <form:input type="text" path="username" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                        ${usernameError}
                </div>
                <div>
                    <form:input type="password" path="password" placeholder="Password"></form:input>
                </div>
                <div>
                    <form:input type="password" path="passwordConfirm"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="password"></form:errors>
                        ${passwordError}
                </div>
                <button type="submit">Registration</button>
                <br>
                <a href="/login">Main Page!</a>
            </form:form>
        </div>
    </body>
</html>
