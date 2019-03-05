<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<style>
</style>
<head>
    <title>编辑计划</title>
</head>
<body>
<div class="container" id="container">
<div class="col-md-12 column ">
    <h2 onclick="back();">
        lifeGame
    </h2>
</div>
<table class="table" name="table" id="table">
    <thead>
    <tr>
        <th width="70%">任务名</th>
        <th width="15%">金额</th>
        <th width="15%">操作</th>
    </tr>
    </thead>

    <tbody id="tableContent">
        <c:forEach items="${planList}" varStatus="i" var="item" >
            <tr>
                <td><span name="title" style="<c:if test="${item.finish == '1'}">text-decoration:line-through</c:if>">${item.planName}</span></td>
                <td><span name="money" style="<c:if test="${item.finish == '1'}">text-decoration:line-through</c:if>">${item.money}</span></td>
                <td><input type="checkbox" onchange="planChange(this);" lang="${item.code}"
                    <c:if test="${item.finish == '1'}">checked</c:if>
                    ></td>
            </tr>
        </c:forEach>

    </tbody>
</table>

</div>


</body>
<script type="application/javascript">

    /*回退上一页*/
    function back() {
        window.location.href="${pageContext.request.contextPath}/lifeGame/lifeGameIndex";
    }

    /*计划改变方法*/
    function planChange(el) {
        var tr = el.parentNode.parentNode;
        var title = $(tr).find("span[name='title']");
        var money = $(tr).find("span[name='money']");
        if($(el).is(':checked')){
            title.css("text-decoration","line-through");
            money.css("text-decoration","line-through");
            changeStatu(el.lang,"1",money.text()); //true选中 false非选中
        }else{
            title.css("text-decoration","none");
            money.css("text-decoration","none");
            changeStatu(el.lang,"0",money.text());
        }
    }

    /*修改指定code状态*/
    function changeStatu(code,flag,money) {
        $.ajax({
            url : "${pageContext.request.contextPath}/tempPlan/changeStatu",
            type : "POST",
            async : false,
            data : {"code":code,"finish":flag,"money":money},
            success:function(data){
                if(data.flag === true){
                    if(flag){
                        alert("任务已完成！");
                    }else {
                        alert("任务状态已恢复~");
                    }
                }
            }
        });
    }

</script>
</html>
