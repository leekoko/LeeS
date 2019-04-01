<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<html>
<body>
<button type="button" class="btn btn-default pull-right" onclick="refresh();">刷新</button>
<table class="table">
    <thead>
    <tr>
        <th width="20%">标题</th>
        <th width="30%">简介</th>
        <th width="30%">模块</th>
        <th width="20%">按钮</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty templateFlowList}">
        <c:forEach items="${templateFlowList}" var="item" varStatus="status">

            <tr>
                <td>${item.flowname}</td>
                <td>${item.flowsummary}</td>
                <td>${item.titlearr}</td>
                <td>
                    <input type="hidden" name="modelCode" value="${item.codearr}"/>
                    <input type="hidden" name="code" value="${item.code}"/>
                    <button type="button" class="btn btn-primary" onclick="chose(this);">选择</button>
                    <button type="button" class="btn btn-danger" onclick="del(this);">删除</button>
                </td>
            </tr>
        </c:forEach>
    </c:if>

    </tbody>
</table>

</body>
<script type="text/javascript">
var modelCodes = "";
function chose(el){
    var td = el.parentNode;
    modelCodes = $(td).find("input[name='modelCode']").val();
    parent.showFlowModel();
}
/*删除流程*/
function del(el){
    var td = el.parentNode;
    code = $(td).find("input[name='code']").val();
    $.ajax({
        url : "${pageContext.request.contextPath}/templateFlow/delete",
        type : "POST",
        async : false,
        data : {"code":code},
        success:function(data){
            if(data){
                alert("删除成功");
                window.location.reload();
            }
        }
    });
}

function refresh(){
    window.location.reload();
}

</script>

</html>
