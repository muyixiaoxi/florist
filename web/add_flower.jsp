<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加花品</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/florist.css">
    <script src="js/florist.js"></script>
</head>
<body>
<div class="login">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="title">增加花品</div>
    <c:if test="${!empty msg }">
        <div class="tips">${msg }</div>
    </c:if>
    <form action="/add_flower" method="post" enctype="multipart/form-data">
        <div class="input">
            <div class="img">
                <img src="img/" class="img-thumbnail" id="img">
            </div>
            <div class="mb-3">
                <label for="file" class="form-label">图片</label>
                <input class="form-control" name="photo" type="file" id="file" required="required">
            </div>
        </div>

        <div class="input">
            <span>花名</span>
            <input type="text" name="name" required="required">
        </div>
        <div class="input">
            <span>价格</span>
            <input type="text" name="price"  required="required">
        </div>
        <div class="input">
            <span>种类</span>
            <input type="text" name="kind" required="required">
        </div>
        <div class="sub">
            <input type="submit" value="提交">
        </div>
    </form>
</div>
</body>
</html>
