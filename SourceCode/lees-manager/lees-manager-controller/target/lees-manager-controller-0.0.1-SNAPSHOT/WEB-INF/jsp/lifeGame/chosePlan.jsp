<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<style>
</style>
<head>
    <title>选择计划</title>
</head>
<body>
<table class="table" name="table" id="table">
    <thead>
    <tr>
        <th width="70%">任务名</th>
        <th width="15%">金额</th>
        <th width="15%">操作</th>
    </tr>
    </thead>

    <tbody id="tableContent">
        <c:if test="${not empty planList}">
            <c:forEach items="${planList}" var="item" varStatus="status">

                <tr>
                    <td>${item.planName}</td>
                    <td>${item.money}</td>
                    <td>
                        <input type="hidden" name="code" value="${item.code}">
                        <input type="hidden" name="planName" value="${item.planName}">
                        <input type="hidden" name="money" value="${item.money}">
                        <button type="button" class="btn btn-primary" onclick="chose(this);" lang="">选择</button>
                    </td>
                </tr>
            </c:forEach>
        </c:if>

    </tbody>
</table>
</body>
<script type="application/javascript">

    var code = "";
    var planName = "";
    var money = "";

    /*回退上一页*/
    function back() {
        window.location.href="${pageContext.request.contextPath}/lifeGame/lifeGameIndex";
    }
    /*选择元素*/
    function chose(el){
        var td = el.parentNode;
        code = $(td).find("input[name='code']").val();
        planName = $(td).find("input[name='planName']").val();
        money = $(td).find("input[name='money']").val();
        parent.hideModal();
    }



</script>
</html>
