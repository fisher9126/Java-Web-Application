<%--
  Created by IntelliJ IDEA.
  User: cachiu
  Date: 5/4/26
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Gọi đồ ăn 🍜</h2>

<form method="post" action="order">
  Username: <input type="text" name="username"/><br/>
  Món ăn: <input type="text" name="foodName"/><br/>
  Số lượng: <input type="number" name="quantity"/><br/>
  <button type="submit">Order</button>
</form>

<h3>${message}</h3>
</body>
</html>
