<%--
  Created by IntelliJ IDEA.
  User: cachiu
  Date: 7/4/26
  Time: 07:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Employee List</h1>
<table style="width:100%" border="1">
    <thead>
    <tr>
        <th>Employee ID</th>
        <th>Full Name</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Đánh giá</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.fullName}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <c:if test="${emp.salary>=10000}">
                <td>Mức lương cao</td>

            </c:if>
            <c:if test="${emp.salary<10000}">
                <td>Mức lương cơ bản</td>
            </c:if>

        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
