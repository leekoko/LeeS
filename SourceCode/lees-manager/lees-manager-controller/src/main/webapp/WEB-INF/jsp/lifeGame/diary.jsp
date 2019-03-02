<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<style>
    .input-margin-bottom{
        margin-bottom: 5px;
        margin-right: 5px;
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
                <input type="hidden" id="planCode1" value="">
                <input type="hidden" id="planCode2" value="">
                <input type="hidden" id="planCode3" value="">
                <%--初始化保存标志 0否 1是--%>
                <input type="hidden" id="saveFlag1" value="1">
                <input type="hidden" id="saveFlag2" value="1">
                <input type="hidden" id="saveFlag3" value="1">
                <input type="text" style="width: 75%;float: left;" id="plan1" name="content" class="form-control input-margin-bottom" placeholder="事项1"></input>
                <input type="text" style="width: 20%;float: left;" id="planMoney1" name="content" class="form-control input-margin-bottom" placeholder="￥"></input>
                <input type="text" style="width: 75%;float: left;" id="plan2" name="content" class="form-control input-margin-bottom" placeholder="事项2"></input>
                <input type="text" style="width: 20%;float: left;" id="planMoney2" name="content" class="form-control input-margin-bottom" placeholder="￥"></input>
                <input type="text" style="width: 75%;float: left;" id="plan3" name="content" class="form-control input-margin-bottom" placeholder="事项3"></input>
                <input type="text" style="width: 20%;float: left;" id="planMoney3" name="content" class="form-control input-margin-bottom" placeholder="￥"></input>
                <label id="status" style="color: red;">未保存</label>
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
    
    $(function () {
        //回显今日计划
        getTodayPlan();
    });

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
        //保存本日计划
        saveTodayPlan();
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
        //填写内容
        fillContent(code, planName, money, true);
    }

    /**
     * 保存今日长期计划
     */
    function saveTodayPlan(){
        for (var index = 1; index < 4; index++) {
            var saveFlag = $("#saveFlag"+index).val();
            if(saveFlag === '0'){ //为0标识不执行保存，下一个
                continue;
            }
            var plan = $("#plan"+index).val();
            if($.trim(plan).length == 0){
                return;
            }
            var planCode = $("#planCode"+index).val();
            var planMoney = $("#planMoney"+index).val();

            //保存临时计划到数据库
            $.ajax({
                url : "${pageContext.request.contextPath}/tempPlan/saveTempPlan",
                type : "POST",
                async : false,
                data : {"plan":plan, "planCode":planCode, "planMoney":planMoney},
                success:function(data){
                    if(data){
                        $("#status").css("color","green");
                        $("#status").text("已保存");
                    }else{
                        $("#status").css("color","yellow");
                        $("#status").text("保存失败");
                    }
                }
            });


        }
    }

    /**
     * 重新加载今日已填计划
     */
    function getTodayPlan() {
        $.ajax({
            url : "${pageContext.request.contextPath}/tempPlan/getTodayChosePlan",
            type : "POST",
            async : false,
            success:function(data){
                for (var i = 0; i < data.length; i++) {
                    //填写内容
                    fillContent(data[i].code, data[i].planName, data[i].money,false);
                }
            }
        });
    }

    /**
     * 填写内容
     */
    function fillContent(code, planName, money, canSave){ //canSave:是否能够再次保存，true是 false否
        if($.trim($("#plan1").val()).length === 0){
            $("#plan1").val(planName);
            $("#plan1").attr("readonly","readonly");
            $("#planCode1").val(code);
            $("#planMoney1").val(money);
            $("#planMoney1").attr("readonly","readonly");
            if(!canSave){
                $("#saveFlag1").val("0");   //能否被保存 0否 1是
            }
        }else{
            if($.trim($("#plan2").val()).length === 0){
                $("#plan2").val(planName);
                $("#plan2").attr("readonly","readonly");
                $("#planCode2").val(code);
                $("#planMoney2").val(money);
                $("#planMoney2").attr("readonly","readonly");
                if(!canSave){
                    $("#saveFlag2").val("0");   //能否被保存 0否 1是
                }
            }else{
                if($.trim($("#plan3").val()).length === 0){
                    $("#plan3").val(planName);
                    $("#plan3").attr("readonly","readonly");
                    $("#planCode3").val(code);
                    $("#planMoney3").val(money);
                    $("#planMoney3").attr("readonly","readonly");
                    if(!canSave){
                        $("#saveFlag3").val("0");   //能否被保存 0否 1是
                    }
                }else{
                    alert("文本框已满");
                }
            }
        }
    }


</script>
</html>
