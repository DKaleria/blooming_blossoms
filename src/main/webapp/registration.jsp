<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="/registration" method="post">
  <label for="name">Name:
    <input type="text" name="name" id="name">
  </label><br/>
  <label for="birthday">Birthday:
    <input type="date" name="birthday" id="birthday">
  </label><br/>
  <label for="email">Email:
    <input type="text" name="email" id="email">
  </label><br/>
  <label for="pwd">Password:
    <input type="password" name="pwd" id="pwd">
  </label><br/>
  <select name="role">
    <c:forEach var="role" items="${roles}">
      <option value="${role}">${role}</option>
    </c:forEach>
  </select>
  <br/>
  <c:forEach var="gender" items="${genders}">
    <input type="radio" name="gender" value="${gender}">${gender}
    <br/>
  </c:forEach>
  <input type="submit" value="Send">
</form>

<c:if test="${not empty errors}">
  <div style="color: red">
    <c:forEach var="error" items="${errors}">
      <span>${error.message}</span>
      <br>
    </c:forEach>
  </div>
</c:if>
</body>
</html>
