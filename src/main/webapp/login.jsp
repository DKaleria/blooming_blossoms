<%--
  Created by IntelliJ IDEA.
  User: valeryia
  Date: 02.04.2024
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="${pageContext.request.contextPath}/login" method="post">
  <label for="email">Email:
    <input type="text" name="email" id="email" value="${param.email}" required>
  </label><br/>
  <label for="password">Password:
    <input type="password" name="password" id="password" required>
  </label><br/>
  <button type="submit" class="button-record">Login</button>
  <a href="${pageContext.request.contextPath}/registration">
    <button type="button" class="button-record">Register</button>
  </a>
  <c:if test="${param.error != null}">
    <div style="color: red">
      <span>Email or password is not correct</span>
    </div>
  </c:if>
</form>
</body>
</html>
