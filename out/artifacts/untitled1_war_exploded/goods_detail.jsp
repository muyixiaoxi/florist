<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/florist.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="bg"><img src="img/bg.jpeg"></div>
    <div class="flo_div">
        <c:forEach items="${goods}" var="g">
            <div>
                <img src="img/${g.path}">
                <div class="price">￥${g.price} <span class="goodName">${g.name}</span></div>
                <a href="PurchaseServlet?id=${g.id}" class="btn btn-danger">加入购物车</a>
            </div>
        </c:forEach>
    </div>

</div>

</body>
</html>
