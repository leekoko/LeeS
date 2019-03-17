<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<style>
</style>
<head>
    <title>登录页面</title>
</head>
<body>
<div class="container">
    <div class="col-md-12 column ">
        <h2 onclick="back();">
            LeeS
        </h2>
    </div>
    <form class="form-horizontal">
        <div class="form-group">
            <label for="userName" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="userName"
                       placeholder="请输入账号">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password"
                       placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-default" onclick="loginUser();">登录</button>
            </div>
            <label style="color: red;margin-left: 20px;">${message}</label>
        </div>
    </form>
</div>
</body>
<script type="application/javascript">
    /*回退上一页*/
    function back() {
        window.location.href="${pageContext.request.contextPath}/lifeGame/lifeGameIndex";
    }
    //登录用户
    function loginUser() {
        var userName = $("#userName").val();
        var password = $("#password").val();
        $.ajax({
            url : "${pageContext.request.contextPath}/author/loginUser",
            type : "POST",
            data : {"userName":userName,"tsm1":password},
            async : false,
            success:function(data){
                if(data){
                    alert("登录成功");
                    <%--window.location.href="${pageContext.request.contextPath}/lifeGame/lifeGameIndex";--%>
                }else{
                    alert("账号密码错误，登录失败")
                }
            }
        });
        
    }
</script>

</html>
