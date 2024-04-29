<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Blooming blossoms</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Blooming blossoms</h1>
<hr>
<h4>Панель администратора</h4>
<table>
    <tr>
        <th>Имя</th>
        <th>Gmail</th>
        <th>Дата рождения</th>
        <th>Роли</th>
        <th>Пользователь заблокирован</th>
        <th>Бан</th>
        <th>Разблокировать</th>
        <th>Редактирование</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.personalInfo.name}</td>
            <td>${user.email}</td>
            <td>${user.personalInfo.birthday}</td>
            <td> ${user.role}
            </td>
            <td> ${user.banned}
            </td>
            <td>
                <form action="${request.contextPath}/admin" method="post">
                    <input type="hidden" name="action" value="ban">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Бан">
                </form>
            </td>
            <td>
                <form action="${request.contextPath}/admin" method="post">
                    <input type="hidden" name="action" value="unlock">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Разблокировать">
                </form>
            </td>

            <td>
                <form action="${request.contextPath}/admin" method="post">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="id" value="${user.id}">

                    <label for="role">Роль:</label>
                    <select name="role" id="role">
                        <c:forEach var="role" items="${roles}">
                            <option value="${role}" ${role == user.role ? 'selected' : ''}>${role}</option>
                        </c:forEach>
                    </select>

                    <input type="submit" value="Редактировать">
                </form>
            </td>

        </tr>
    </c:forEach>
    <div style="color: red">
        <c:if test="${empty users}">
            <tr>
                <td colspan="7"><h3>Пользователей нет</h3></td>
            </tr>
        </c:if>
    </div>
</table>

</body>
</html>