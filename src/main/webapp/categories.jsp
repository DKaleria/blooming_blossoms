<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
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
<h1>Выберите категорию</h1>
<div class="category-buttons">
    <form action="${request.contextPath}/categories" method="POST">
        <c:forEach items="${categories}" var="category_id">
            <button type="submit" class="button-lists" name="category_id" value="${category_id.category_id}">
                    ${category_id.name}
            </button>
        </c:forEach>
    </form>
</div>
</body>
</html>