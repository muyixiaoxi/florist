<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/florist.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="login">
    <c:if test="${!empty msg }">
        <div class="tips">${msg }</div>
    </c:if>
    <div class="title">个人中心</div>
    <form action="/user_update" method="post">
        <div class="input">
            <span>用户名</span>
            <input type="text" name="username"value="${user.username}" readonly>
        </div>
        <div class="input">
            <span>密码</span>
            <input type="text" name="password" value="${user.password}" required="required">
        </div>
        <div class="input">
            <span>姓名</span>
            <input type="text" name="name"value="${user.name}"required="required" >
        </div>
        <div class="input">
            <span>电话</span>
            <input type="text" name="phone"value="${user.phone}"required="required">
        </div>
        <div class="input">
            <span>地址</span>
            <input type="text" name="address"value="${user.address}"required="required">
        </div>
        <div class="sub">
            <input type="submit" value="修改">
        </div>
    </form>
</div>
</body>
</html>
