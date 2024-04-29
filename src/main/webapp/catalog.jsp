<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Blooming blossoms</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
<%@include file="header.jsp"%>
</div>
<form action="redirect" method="post">
    <input type="hidden" name="page" value="categories" />
    <button type="submit" class="button-record">ПЕРЕЙТИ В КАТАЛОГ</button>
</form>
</div>
<h1>Product Catalog</h1>
<table>
    <thead>
    <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Availability</th>
        <th>Category</th>
        <th>Quantity in Stock</th>
        <th>Заказать</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}" >
        <tr>
            <td><img src="${product.image}" alt="Product Image" /></td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.availability}</td>
            <td>${product.category_id.name}</td>
            <td>${product.quantity_in_stock}</td>
            <td>
                <button class="button-record" onclick="window.location.href='record.jsp';">Заказать</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>