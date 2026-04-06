<%--
  Created by IntelliJ IDEA.
  User: cachiu
  Date: 6/4/26
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<html>
<head>
    <title>Tìm kiếm sự kiện</title>
</head>
<body>


<form action="/search" method="get">
    <input type="text" name="keyword" value="${keyword}" placeholder="Nhập từ khóa...">
    <button type="submit">Tìm</button>
</form>

<hr/>


<h3>Kết quả tìm kiếm cho: <c:out value="${keyword}" /></h3>
<p>Tìm thấy ${totalFound} sự kiện</p>


<c:if test="${totalFound==0}">
    <p>Không có dữ liệu</p>
</c:if>


<c:if test="${totalFound>0}">
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Ngày</th>
            <th>Giá</th>
            <th>Vé</th>
        </tr>

        <c:forEach var="e" items="${events}" varStatus="st">
            <tr>
                <td>${st.count}</td>
                <td><c:out value="${e.name}" /></td>
                <td>${e.eventDate}</td>
                <td>${e.price}</td>
                <td>${e.remainingTickets}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>