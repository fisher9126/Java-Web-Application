<%--
  Created by IntelliJ IDEA.
  User: cachiu
  Date: 5/4/26
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>🍜 Gọi đồ ăn tại chỗ</h2>

<form method="post" action="order">
    <label>Username:</label>
    <input type="text" name="username" required/><br/><br/>

    <label>Món ăn:</label>
    <input type="text" name="foodName" required/><br/><br/>

    <label>Số lượng:</label>
    <input type="number" name="quantity" min="1" required/><br/><br/>

    <button type="submit">Order</button>
</form>

<br/>

<h3 style="color: green;">
    ${message}
</h3>
</body>
</html>
