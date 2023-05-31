<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">小熙花店</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <c:if test="${!empty manager}">
                            <a class="nav-link active" aria-current="page" href="manager_detail">首页</a>
                        </c:if>
                        <c:if test="${empty manager}">
                            <a class="nav-link active" aria-current="page" href="goods_detail">首页</a>
                        </c:if>
                    </li>
                    <c:if test="${!empty user}">
                        <li class="nav-item">
                            <a class="nav-link" href="user_update.jsp">个人中心</a>
                        </li>
                    </c:if>
                    <c:if test="${empty user && empty manager}">
                        <li class="nav-item">
                            <a class="nav-link" href="user_register.jsp">注册</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="user_login.jsp">登录</a>
                        <li class="nav-item">
                            <a class="nav-link" href="manager_login.jsp">管理员</a>
                        </li>
                    </c:if>
                    <c:if test="${!empty manager}">
                        <li class="nav-item">
                            <a class="nav-link" href="add_flower.jsp">增加花品</a>
                        </li>
                    </c:if>
                    <c:if test="${!empty user||!empty manager}">
                        <li class="nav-item">
                            <a class="nav-link" href="SignOut">退出登录</a>
                        </li>
                    </c:if>
                </ul>
            </div>
            <div class="d-flex">
                <c:if test="${empty manager}">
                    <form class="d-flex" role="search" action="user_search" method="get">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                               name="flowerName">
                        <button class="btn btn-outline-info" type="submit">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-search" viewBox="0 0 16 16">
                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                            </svg>
                        </button>
                    </form>
                    <div class="header-right">
                        <a class="nav-link" href="/goods_cart">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-cart-dash-fill" viewBox="0 0 16 16">
                                <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM6.5 7h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1 0-1z"/>
                            </svg>
                        </a>
                    </div>
            </div>
        </c:if>
        </div>
    </nav>

</div>
</body>
</html>
