<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小熙花店</title>
    <link rel="stylesheet" type="text/css" href="css/florist.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="login">
    <c:if test="${!empty msg }">
        <div class="tips">${msg }</div>
    </c:if>
    <div class="title">管理员登录</div>
    <form action="/manager_login" method="post">
        <div class="input">
            <span>管理员 <label style="color: #ff0000;">*</label></span>
            <input type="text" name="name" placeholder="请输入管理员账号" required="required">
        </div>
        <div class="input">
            <span>密码 <label style="color: red;">*</label></span>
            <input type="password" name="password" placeholder="请输入密码" required="required">
        </div>
        <div class="sub">
            <input type="submit" value="提交">
        </div>
    </form>
</div>
</body>
</html>

</body>
</html>
