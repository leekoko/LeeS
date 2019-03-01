<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<style>
    .input-margin-bottom{
        margin-bottom: 5px;
    }
</style>
<head>
    <title>日记页面</title>
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
        <th width="30%">事项</th>
        <th width="70%">内容</th>
    </tr>
    </thead>

    <tbody id="tableContent">
        <tr>
            <td><span name="title">今天流水账</span></td>
            <td><textarea type="text" name="content" class="form-control" style="height: 150px;" placeholder="输入内容"></textarea></td>
        </tr>
        <tr>
            <td><span name="title">今日感触</span></td>
            <td><textarea type="text" name="content" class="form-control" style="height: 150px;" placeholder="输入内容"></textarea></td>
        </tr>
        <tr>
            <td><span name="title">我想做什么，怎么实现</span></td>
            <td><textarea type="text" name="content" class="form-control" style="height: 150px;" placeholder="输入内容"></textarea></td>
        </tr>
        <tr>
            <td><span name="title">昨天安排检查</span></td>
            <td><textarea type="text" name="content" class="form-control" style="height: 50px;" placeholder="输入内容"></textarea></td>
        </tr>
        <tr>
            <td>
                <span name="title">明天安排</span>
                <button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#choseModel">选择已有</button>
            </td>
            <td>
                <input type="hidden" id="planId1" value="">
                <input type="hidden" id="planId2" value="">
                <input type="hidden" id="planId3" value="">
                <input type="hidden" id="planMoney1" value="">
                <input type="hidden" id="planMoney2" value="">
                <input type="hidden" id="planMoney3" value="">
                <input type="text" id="plan1" name="content" class="form-control input-margin-bottom" placeholder="事项1"></input>
                <input type="text" id="plan2" name="content" class="form-control input-margin-bottom" placeholder="事项2"></input>
                <input type="text" id="plan3" name="content" class="form-control input-margin-bottom" placeholder="事项3"></input>
            </td>
        </tr>
        <tr>
            <td><span name="title">80%</span></td>
            <td><textarea type="text" name="content" class="form-control" style="height: 100px;" placeholder="输入内容"></textarea></td>
        </tr>
    </tbody>

</table>
<button type="button" class="btn btn-success btn-lg" style="float: left;width: 100%;margin-bottom: 5px;" onclick="createDiary()">生成</button>
</div>

<div class="modal fade" id="choseModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog" style="width: 90%;">
        <div class="modal-content">
            <input type="hidden" id="delCode" value=""/>
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">选择计划</h4>
            </div>
            <div class="modal-body">
                <%--iframe--%>
                <iframe id="choseIframe" src="${pageContext.request.contextPath}/lifeGame/chosePlan" height="70%" width="100%" frameborder="0"></iframe>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
    function createDiary() {
        var trEl = $("#tableContent tr");
        var date = new Date();
        var result = (date.getMonth()+1)+"."+date.getDate()+"\n";
        for(var i = 0; i < trEl.length; i++){
            var title = $(trEl[i]).find("span[name='title']").text();
            var content = "";
            if(i == 4){
                content += "\n\t计划1："+$("#plan1").val();
                content += "\n\t计划2："+$("#plan2").val();
                content += "\n\t计划3："+$("#plan3").val();
            }else {
                content = $(trEl[i]).find("textarea[name='content']").val();
            }
            result += title+":"+content + "\n";
        }
        var resultHtml = "<textarea type='text' id='outContent' class='form-control' style='height: 300px;width: 100%;margin-bottom: 5px;' placeholder='输入内容'>"+result+"</textarea>";
        var oldEl = $("#outContent");
        if(oldEl.length != 0){
            oldEl.remove()
        }
        $("#container").append(resultHtml);
        copyOut();
    }
    /*复制输出内容*/
    function copyOut() {
        $("#outContent").select();
        document.execCommand("copy");
    }

    /*隐藏模态框*/
    function hideModal() {
        $('#choseModel').modal('hide');
        showContent();
    }

    /*显示内容*/
    function showContent() {
        var code = document.getElementById("choseIframe").contentWindow.code;
        var planName = document.getElementById("choseIframe").contentWindow.planName;
        var money = document.getElementById("choseIframe").contentWindow.money;
        if($.trim($("#plan1").val()).length === 0){
            $("#plan1").val(planName);
            $("#planId1").val(planName);
            $("#planMoney1").val(planName);
        }else{
            if($.trim($("#plan2").val()).length === 0){
                $("#plan2").val(planName);
                $("#planId2").val(planName);
                $("#planMoney2").val(planName);
            }else{
                if($.trim($("#plan3").val()).length === 0){
                    $("#plan3").val(planName);
                    $("#planId3").val(planName);
                    $("#planMoney3").val(planName);
                }else{
                    alert("文本框已满");
                }
            }
        }
    }
</script>
</html>
