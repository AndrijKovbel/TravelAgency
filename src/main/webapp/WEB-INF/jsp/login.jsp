<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/loginforma.css">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Login</title>
</head>
<img src="https://images.creativemarket.com/0.1.0/ps/7901653/580/387/m2/fpnw/wm0/creativee-05-.jpg?1583899424&s=d71db22c9c5e2e23e2e705269887971f"
     alt="Logo">
<body>
<h1>Hello my friend nice to see you please Login to see Information about tours.</h1>
<form name='f' action="login" method='POST'>
    <div class="form-group">
        <label for="exampleInputEmail1">User Name</label>
        <input input type='text' name='username' value='' class="form-control" id="exampleInputEmail1"
               aria-describedby="emailHelp">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input input type='password' name='password' class="form-control" id="exampleInputPassword1">
    </div>
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button input name="submit" type="submit" value="submit" class="btn btn-primary">Submit</button>
    <div>
        <button>
            <a href="/registration">Registration</a>
        </button>
    </div>
    <p class="mt-5 mb-3 text-muted">&copy; 2020-2021</p>
</form>

</body>
</html>