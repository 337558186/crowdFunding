<%--
  Created by ZWQ
  Time: 2019/12/1-14:12
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${!empty admins}">
        <c:forEach items="${admins}" var="admin">
            ${admin}<br>
        </c:forEach>
    </c:if>

</body>
</html>
