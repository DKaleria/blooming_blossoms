<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>Menu</h1>

<form action="redirect" method="post">
    <input type="hidden" name="page" value="categories" />
    <input type="submit" value="Go to Categories" />
</form>

<form action="redirect" method="post">
    <input type="hidden" name="page" value="catalog" />
    <input type="submit" value="Go to Product Catalog" />
</form>
</body>
</html>