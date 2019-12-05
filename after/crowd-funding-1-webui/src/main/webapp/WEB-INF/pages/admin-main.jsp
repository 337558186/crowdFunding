<%--
  Created by ZWQ
  Time: 2019/12/4-16:06
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    ${sessionScope.LOGIN_ADMIN}
    <br>
    <a href="${pageContext.request.contextPath}/admin/logout.html">退出登录</a>
</body>
</html>
