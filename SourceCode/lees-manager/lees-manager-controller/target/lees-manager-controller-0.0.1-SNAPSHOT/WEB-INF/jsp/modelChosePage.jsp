<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<html>
<body>
<button type="button" class="btn btn-default pull-right" onclick="refresh();">刷新</button>
<table class="table">
    <thead>
    <tr>
        <th width="40%">标题</th>
        <th width="40%">简介</th>
        <th width="20%">按钮</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty templateList}">
        <c:forEach items="${templateList}" var="item" varStatus="status">

            <tr>
                <td>${item.title}</td>
                <td>${item.summary}</td>
                <td>
                    <input type="hidden" id="code" name="code" value="${item.code}"></input>
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
var curContent = "";
var curSummary = "";
var curTitle = "";
var curCode = "";
function chose(el){
    var td = el.parentNode;
    var code = $(td).find("input[name='code']").val();
    getContentByCode(code);
    parent.hideModal();
}
function getContentByCode(code){
    //获取模板内容
    $.ajax({
        url : "${pageContext.request.contextPath}/template/getContentByCode",
        type : "POST",
        async : false,
        data : {"code":code},
        success:function(data){
            curContent = data.content;
            curSummary = data.summary;
            curTitle = data.title;
            curCode = data.code;
        }
    });
}
/*删除模板*/
function del(el){
    var td = el.parentNode;
    code = $(td).find("input[name='code']").val();
    $.ajax({
        url : "${pageContext.request.contextPath}/template/delete",
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
