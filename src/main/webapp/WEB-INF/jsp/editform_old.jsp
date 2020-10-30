<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Edit My Tour List</h1>
<form method="POST" action="/editsave">
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="id" /></td>
        </tr>
        <tr>
            <td>Country : </td>
            <td><form:input path="country"  /></td>
        </tr>
        <tr>
            <td>Tour :</td>
            <td><form:input path="tour" /></td>
        </tr>
        <tr>
            <td>Price :</td>
            <td><form:input path="price" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="save" /></td>
        </tr>
    </table>
</form>