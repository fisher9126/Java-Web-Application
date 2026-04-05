<%--
  Created by IntelliJ IDEA.
  User: cachiu
  Date: 5/4/26
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Điều gì đang xảy ra?
PlaySession chỉ được tạo DUY NHẤT 1 INSTANCE
Tất cả máy trạm (user login) đều dùng chung object này

→ nghĩa là:

Máy 01 addTime(10)
Máy 02 addTime(5)

thực chất là:

1 object playTime = 15

=> tiền bị trừ chung → bug đúng kiểu "chia tiền không ai muốn"

️ Vì sao Singleton gây lỗi?
Singleton = 1 object duy nhất trong toàn hệ thống
Trong khi nghiệp vụ cần:
mỗi user → 1 session riêng
mỗi máy → 1 bộ đếm riêng


</body>
</html>
