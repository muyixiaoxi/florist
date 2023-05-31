<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="title">注册新用户</div>
        <form action="/user_register" method="post">
            <div class="input">
                <span>用户名 <label style="color: #ff0000;">*</label></span>
                <input type="text" name="username" placeholder="请输入用户名" required="required">
            </div>
            <div class="input">
                <span>密码 <label style="color: red;">*</label></span>
                <input type="password" name="password" placeholder="请输入密码" required="required">
            </div>
            <div class="input">
                <span>收货人 <label></label></span>
                <input type="text" name="name"placeholder="请输入收货">
            </div>
            <div class="input">
                <span>收货电话 <label></label></span>
                <input type="text" name="phone" placeholder="请输入电话">
            </div>
            <div class="input">
                <span>收货地址 <label></label></span>
                <input type="text" name="address" placeholder="请输入地址">
            </div>
            <div class="sub">
                <input type="submit" value="提交">
            </div>

        </form>
    </div>
</body>
</html>
