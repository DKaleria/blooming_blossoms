<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Catalog</title>
</head>
<body>
<%@include file="header.jsp"%>
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
            <td>${product.category_id.name}</td>
            <td>${product.quantity_in_stock}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>