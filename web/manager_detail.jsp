<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2022/12/27
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户货物管理</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/florist.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <p class="lead">
        商品信息
    </p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">商品</th>
            <th scope="col">单价</th>
            <th scope="col">种类</th>
            <th scope="col" style="width: 15%">操作</th>
        </tr>
        </thead>
        <tbody>
        <%--        遍历输出--%>
        <c:forEach items="${flowers}" var="f">
            <tr>
                <td>
                    <div class="td1">
                        <div class="cart_img">
                            <img src="img/${f.path}">
                        </div>
                        <div class="cart_name">
                                ${f.name}
                        </div>
                    </div>
                </td>
                <td>
                    <div class="cart_price">
                            ${f.price}
                    </div>
                </td>
                <td>
                    <div class="cart_count">
                            ${f.kind}
                    </div>
                </td>
                <td>
                    <div class="cart_update">
                        <a href="manager_action?id=${f.id}" class="btn btn-success">修改</a>
                        <a href="delete_flower?id=${f.id}" class="btn btn-danger">删除</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p class="lead">
        用户信息
    </p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">用户名</th>
            <th scope="col">密码</th>
            <th scope="col">姓名</th>
            <th scope="col">电话</th>
            <th scope="col">地址</th>
            <th scope="col" style="width: 15%">操作</th>
        </tr>
        </thead>
        <tbody>
        <%--        遍历输出--%>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>
                        ${u.username}
                </td>
                <td>
                        ${u.password}
                </td>
                <td>
                        ${u.name}
                </td>
                <td>
                        ${u.phone}
                </td>
                <td>
                        ${u.address}
                </td>
                <td>
                    <div class="cart_update">
                        <a href="delete_user?id=${u.id}" class="btn btn-danger">删除</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
