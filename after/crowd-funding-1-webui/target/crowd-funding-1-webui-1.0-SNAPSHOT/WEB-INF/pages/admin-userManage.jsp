<%--
  Created by ZWQ
  Time: 2019/12/4-16:06
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="UTF-8">
<%--引入头部，样式等--%>
<%@ include file="/WEB-INF/pages/include-head.jsp" %>

<body>
<%--引入公共标题栏--%>
<%@ include file="/WEB-INF/pages/include-nav.jsp" %>

<div class="container-fluid">
    <div class="row">

        <%--引入公共导航栏--%>
        <%@ include file="/WEB-INF/pages/include-sidebar.jsp"%>


        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <c:forEach var="admin" items="${requestScope.pageInfo.list}" >
                <c:out value="${admin}"></c:out><br>
            </c:forEach>


        </div>
    </div>
</div>


</body>
</html>

