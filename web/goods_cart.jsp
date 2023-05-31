<%@ page import="java.util.Map" %>
<%@ page import="model.Flower" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="service.FlowerService" %>
<%@ page import="service.CartService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的购物车</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/florist.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">商品</th>
            <th scope="col">单价</th>
            <th scope="col">数量</th>
            <th scope="col" style="width: 25%">操作</th>
        </tr>
        </thead>
        <tbody>
        <%--        遍历输出--%>
        <c:forEach items="${cart.keySet()}" var="c">
            <tr>
                <td>
                  <div class="td1">
                      <div class="cart_img">
                          <img src="img/${c.path}">
                      </div>
                      <div class="cart_name">
                              ${c.name}
                      </div>
                  </div>
                </td>
                <td>
                    <div class="cart_price">
                            ${c.price}
                    </div>
                </td>
                <td>
                    <div class="cart_count">
                            ${cart.get(c)}
                    </div>
                </td>
                <td>
                    <div class="cart_update">
                        <a href="CartAddServlet?id=${c.id}" class="btn btn-primary">增加</a>
                        <a href="CartCutServlet?id=${c.id}" class="btn btn-success">减少</a>
                        <a href="CartDeleteServlet?id=${c.id}" class="btn btn-danger">删除</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        <%--总价--%>
        </tbody>
    </table>
    <div class="price">
        <%
            Map<Flower,Integer> cart =(HashMap<Flower,Integer>)request.getSession().getAttribute("cart");
            out.print(CartService.priceGoods(cart));
        %>
    </div>
</div>
</body>
</html>
