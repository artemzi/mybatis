<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rikki
  Date: 14.11.2018
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="phone" items="${phones}">
        <TR>
            <TD>${phone.id}</TD>
            <TD>${phone.model}</TD>
            <TD>${phone.cost}</TD>
        </TR>
    </c:forEach>
</table>
</body>
</html>
