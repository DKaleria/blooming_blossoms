<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Catalog</title>
</head>
<body>
<h1>Product Catalog</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Availability</th>
        <th>Category</th>
        <th>Quantity in Stock</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}" >
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.availability}</td>
            <td>${product.categories.name}</td>
            <td>${product.quantityInStock}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>