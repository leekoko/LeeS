<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<head>
    <title>图书馆</title>
    <style>
        .buttonType{
            margin-top: 460px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="col-md-12 column ">
        <a href="${pageContext.request.contextPath}/">
            <h1>
                LeeS
            </h1>
        </a>
    </div>
    <div class="btn-toolbar" class="buttonType">
        <div class="btn-group btn-group-lg">
            <button class="btn btn-primary">求位</button>
            <button type="button" class="btn btn-default dropdown-toggle"
                    data-toggle="dropdown">
                让位
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">临时借位</a></li>
                <li><a href="#">直接让位</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
