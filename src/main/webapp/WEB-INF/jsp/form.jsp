<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Tour</h1>
<form:form method="post" action="save">
    <table >
        <tr>
            <td>Tour : </td>
            <td><form:input path="tour"  /></td>
        </tr>
        <tr>
            <td>Country :</td>
           <td><form:input path="country" /></td>
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
</form:form>