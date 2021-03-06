<%--
  Created by ZWQ
  Time: 2019/12/3-17:21
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <title>❤汇聚点滴力量，成就你我梦想❤</title>
    <%--base相当于   http://localhost:8080/--%>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />

    <link rel="stylesheet" href="../../static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../static/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../static/css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form class="form-signin" role="form" method="post" action="${pageContext.request.contextPath}/admin/login.html">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 管理员登录</h2>

        <%--用于显示登录失败的信息--%>
        <p style="color: red">${requestScope.MESSAGE}</p>

        <div class="form-group has-success has-feedback">
            <input type="text" name="loginAcct" class="form-control" id="inputSuccess4" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" name="userPswd" class="form-control" id="inputSuccess4" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>

        </div>
        <input type="submit" value="登录" class="btn btn-lg btn-success btn-block">
        <%--<a class="btn btn-lg btn-success btn-block" > 登录</a>--%>
    </form>
</div>
<script src="../../static/jquery/jquery-2.1.1.min.js"></script>
<script src="../../static/bootstrap/js/bootstrap.min.js"></script>
<script>
    function dologin() {

            window.location.href = "main.html";
    }
</script>
</body>
</html>
