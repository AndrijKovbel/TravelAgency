<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>





<h1>Edit My Tour List</h1>
<form method="POST" action="/editsave" modelAttribute="info">
    <table >
        <tr>
            <td></td>
            <td></td>
            <input type="text" name="id" style="display: none;" value="${info.id}"/>
        </tr>
        <tr>
            <td>Country : </td>
            <td><input type="text" name="country" value="${info.country}"/></td>
        </tr>
        <tr>
            <td>Tour :</td>
            <td><input name="tour" type="text" value="${info.tour}"/> </td>
        </tr>
        <tr>
            <td>Price :</td>
            <td><input type="text" name="price" value="${info.price}"/> </td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="save" /></td>
        </tr>
    </table>
</form>