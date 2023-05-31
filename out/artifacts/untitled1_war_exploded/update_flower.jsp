<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改花朵信息</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/florist.css">
    <script type="text/javascript" src="js/florist.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="login">
    <div class="title">信息修改</div>
    <form action="/update_flower" method="post" enctype="multipart/form-data">
        <div class="input" style="display: none">
            <span>id</span>
            <input type="text"  name="id" value=${flower.id} readonly>
        </div>

        <div class="input">
            <div class="img">
                <img src="img/${flower.path}" class="img-thumbnail" id="img">
            </div>
            <div class="mb-3">
                <label for="file" class="form-label">图片</label>
                <input class="form-control" name="photo" type="file" id="file">
            </div>
        </div>

        <div class="input">
            <span>花名</span>
            <input type="text" name="name" value=${flower.name} readonly>
        </div>
        <div class="input">
            <span>价格</span>
            <input type="text" name="price" value="${flower.price}" required="required">
        </div>
        <div class="input">
            <span>种类</span>
            <input type="text" name="kind" value="${flower.kind}" required="required" >
        </div>
        <div class="sub">
            <input type="submit" value="提交">
        </div>
    </form>
</div>
</body>
</html>
