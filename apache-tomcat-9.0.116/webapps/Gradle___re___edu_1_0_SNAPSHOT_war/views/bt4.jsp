<%--
  Created by IntelliJ IDEA.
  User: cachiu
  Date: 5/4/26
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>📩 Gửi thông báo</h2>

<form method="post" action="notify">
    Nội dung: <input type="text" name="message"/>
    <button type="submit">Gửi</button>
</form>

<p>${result}</p>
</body>
</html>
