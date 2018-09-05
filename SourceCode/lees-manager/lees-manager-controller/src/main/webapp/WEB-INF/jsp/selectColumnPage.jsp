<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<html>
<head>
    <title>列选择页面</title>
</head>
<script type="text/javascript" src="${ctx}/js/multiselect.min.js"></script>
<body>
<input type="hidden" value="${id}" id="${id}"/>
<input type="hidden" value="${sql}" id="${sql}"/>
<div class="container">
    <div class="row" style="margin-top: 30px;">
        <div class="col-xs-5">
            <select name="from" id="multiselect" class="form-control" size="8" multiple="multiple">
                <c:if test="${not empty list}">
                    <c:forEach items="${list}" var="item" varStatus="status">
                        <option value="${item}">${item}</option>
                    </c:forEach>
                </c:if>
            </select>
        </div>
        <div class="col-xs-2">
            <button type="button" id="multiselect_rightAll" class="btn btn-block"><i class="glyphicon glyphicon-forward"></i></button>
            <button type="button" id="multiselect_rightSelected" class="btn btn-block"><i class="glyphicon glyphicon-chevron-right"></i></button>
            <button type="button" id="multiselect_leftSelected" class="btn btn-block"><i class="glyphicon glyphicon-chevron-left"></i></button>
            <button type="button" id="multiselect_leftAll" class="btn btn-block"><i class="glyphicon glyphicon-backward"></i></button>
        </div>
        <div class="col-xs-5">
            <select name="to" id="multiselect_to" class="form-control" size="8" multiple="multiple"></select>
        </div>
    </div>
    <div class="row" style="margin-top: 30px;">
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="saveColumn();">保存</button>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $('#multiselect').multiselect();
    });
</script>

<script type="text/javascript">
    function saveColumn(){
        var arr = $("#multiselect_to").children();
        var value = "";
        for (var i = 0; i < arr.length ; i++) {
            value += arr[i].label + ",";
        }
        value = value.substring(0, value.length - 1);
        var id = $("#id").val();
        var sql = $("#sql").val();
        $.ajax({
            type:"post",
            async:false,
            dataType:"json",
            url: "${pageContext.request.contextPath}/mobileColumn/save",
            data:{"id":id,"sql":sql,"value":value},
            success : function(data) {
                if(data.result == true){
                    alert("保存成功");
                }
            }
        });
    }

</script>