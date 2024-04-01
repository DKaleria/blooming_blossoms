<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<h1>Categories</h1>
<ul>
    <c:forEach items="${categories}" var="category">
        <li>${category.name}</li>
    </c:forEach>
</ul>
</body>
</html>