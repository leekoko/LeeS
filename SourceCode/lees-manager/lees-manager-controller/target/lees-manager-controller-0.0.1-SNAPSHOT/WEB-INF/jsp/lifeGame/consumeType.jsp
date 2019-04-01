<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<style>
</style>
<head>
    <title>编辑类别</title>
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
        <th width="70%">类别名</th>
        <th width="30%">操作</th>
    </tr>
    </thead>

    <tbody id="tableContent">
        <c:forEach items="${typeList}" varStatus="i" var="item" >
            <tr>
                <td><span name="title">${item.typeName}</span></td>
                <td><button type="button" class="btn btn-danger btn-xs" style="float: left;"  data-toggle="modal" data-target="#delModal" onclick="delReady(this)" lang="${item.code}">删除</button></td>
            </tr>
        </c:forEach>
    </tbody>

</table>

<button type="button" class="btn btn-success btn-lg" style="float: left;width: 100%;margin-bottom: 5px;" data-toggle="modal" data-target="#editModal">新增</button>
</div>

<!-- 模态框：编辑计划 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog" style="width: 90%;">
        <div class="modal-content">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">计划新增页面</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="typeName" class="col-sm-2 control-label">类别名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="typeName"
                                   placeholder="请输入类别名">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="save()">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 模态框：删除询问 -->
<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true" >
    <div class="modal-dialog" style="width: 90%;">
        <div class="modal-content">
            <input type="hidden" id="delCode" value=""/>
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2">删除询问</h4>
            </div>
            <div class="modal-body">
                <span>是否确定删除当前计划？</span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-danger" onclick="del()">删除</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
<script type="application/javascript">

    /*回退上一页*/
    function back() {
        window.location.href="${pageContext.request.contextPath}/lifeGame/lifeGameIndex";
    }

    /*生成日记*/
    function save() {
        var typeName = $("#typeName").val();
        $.ajax({
            url : "${pageContext.request.contextPath}/consume/saveType",
            type : "POST",
            async : false,
            data : {"typeName":typeName},
            success:function(data){
                if(data.flag === true){
                    alert("保存成功");
                    window.location.reload();
                }
            }
        });
    }
    /*删除准备*/
    function delReady(el){
        $("#delCode").val(el.lang);
    }
    /*实际删除操作*/
    function del(){
        var delCode = $("#delCode").val();
        //请求删除该Code数据
        $.ajax({
            url : "${pageContext.request.contextPath}/consume/delType",
            type : "POST",
            async : false,
            data : {"code":delCode},
            success:function(data){
                console.log(data)
                if(data === true){
                    window.location.reload();
                }
            }
        });
    }
</script>
</html>
