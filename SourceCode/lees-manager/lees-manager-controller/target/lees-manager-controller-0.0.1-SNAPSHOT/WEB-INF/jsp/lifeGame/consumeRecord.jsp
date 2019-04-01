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
    #curMoney{
        padding-top: 55px;
        padding-left: 50px;
        font-size: 60px;
        color: white;
    }
</style>
<head>
    <title>消费记录</title>
</head>
<body>
<div class="container" id="container">
    <div class="col-md-12 column ">
        <h2 onclick="back();">
            lifeGame
        </h2>
    </div>

    <div id="circle" onclick="consume()">
        <div id="curMoney" data-toggle="modal" data-target="#modal">${curMoney}</div>
    </div>
</div>


<!-- 模态框：编辑计划 -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog" style="width: 90%;">
        <div class="modal-content">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">计划新增页面</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="type" class="col-sm-2 control-label">消费类别</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="type">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="consumeName" class="col-sm-2 control-label">消费内容</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="consumeName"
                                   placeholder="请输入消费内容">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="consumeMoney" class="col-sm-2 control-label">金额</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="consumeMoney"
                                   placeholder="请输入金额">
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="consume()">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
<script type="application/javascript">

    $(function () {
        //获取类别下拉框
        $.ajax({
            url : "${pageContext.request.contextPath}/consume/getTypeList",
            type : "POST",
            async : false,
            success:function(data){
                for (var i = 0; i < data.length; i++) {
                    $("#type").append("<option lang='"+data[i].code+"'>"+data[i].typeName+"</option>")
                }
            }
        });
    });
    
    /*回退上一页*/
    function back() {
        window.location.href="${pageContext.request.contextPath}/lifeGame/lifeGameIndex";
    }
    /*今日计划开始*/
    function consume() {
        var typeCode = $("#type option:selected").attr("lang");
        var consumeName = $("#consumeName").val();
        var consumeMoney = $("#consumeMoney").val();
        $.ajax({
            url : "${pageContext.request.contextPath}/consume/saveConsume",
            type : "POST",
            async : false,
            data: {"parentcode":typeCode, "consumeName":consumeName, "money":consumeMoney},
            success:function(data){
                if(data){
                    window.location.reload();
                }
            }
        });

    }


</script>
</html>
