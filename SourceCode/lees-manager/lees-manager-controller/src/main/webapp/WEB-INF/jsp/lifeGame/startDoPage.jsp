<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<style>
#circle {
    width: 200px;
    height: 200px;
    background: red;
    -moz-border-radius: 200px;
    -webkit-border-radius: 200px;
    border-radius: 200px;
    margin:auto;
    margin-top: 200px;
 }
 #ready{
     padding-top: 55px;
     font-size: 60px;
     color: white;
 }
</style>
<head>
    <title>启动计划</title>
</head>
<body>
<div class="container" id="container">
    <div class="col-md-12 column ">
        <h2 onclick="back();">
            lifeGame
        </h2>
    </div>

    <div id="circle" onclick="startDay()">
        <div id="ready">Ready!</div>
    </div>
</div>
</body>
<script type="application/javascript">

    /*回退上一页*/
    function back() {
        window.location.href="${pageContext.request.contextPath}/lifeGame/lifeGameIndex";
    }
    /*今日计划开始*/
    function startDay() {
        $.ajax({
            url : "${pageContext.request.contextPath}/tempPlan/startNewDay",
            type : "POST",
            async : false,
            success:function(data){
                alert("请求成功"+data);
                if(data){
                    //刷新
                    window.location.href="/tempPlan/toDoList";
                }
            }
        });
    }


</script>
</html>
