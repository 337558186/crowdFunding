<%--
  Created by ZWQ
  Time: 2019/12/5-15:17
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>网页访问错误</h1>
    <h4>错误原因</h4>
    <p>${requestScope.exception.message}</p>

</body>
</html>
