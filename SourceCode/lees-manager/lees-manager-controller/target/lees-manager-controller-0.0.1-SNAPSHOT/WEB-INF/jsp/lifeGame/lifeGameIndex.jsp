<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<style>
.rowStyle{
    background: #ebebeb;
    margin-bottom: 10px;
    float: left;
    width: 100%;
}
.btnStyle{
    margin-left: 5px;
    margin-bottom: 5px;
    float: left;
}
.titleStyle2{
    color: #C02B43;
    float: left;
    margin-top: 5px;
    margin-left: 5px;
}
.titleStyle{
    float: right;
    margin: 5px;
}
</style>
<head>
    <title>LifeGame首页</title>
</head>
<body>
<div class="container">
    <div class="col-md-12 column ">
        <h2>
            LeeS
        </h2>
    </div>
    <table class="table" name="table">

        <tbody id="tableContent">
        <tr>
            <td>
                <div class="rowStyle">
                    <strong class="titleStyle">日常记录</strong><br/>
                    <button type="button" class="btn btn-success btn-sm btnStyle" onclick="fillDiary()">填写</button>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="rowStyle">
                    <div style="margin-bottom: 5px;">
                        <strong class="titleStyle2">${curMoney}</strong>
                        <strong class="titleStyle">任务列表</strong><br/>
                    </div>
                    <button type="button" class="btn btn-success btn-sm btnStyle" onclick="toDoList()">TO DO LIST</button>
                    <button type="button" class="btn btn-warning btn-sm btnStyle" onclick="editPlan()">日常计划</button>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="rowStyle">
                    <div style="margin-bottom: 5px;">
                        <strong class="titleStyle">账单本</strong><br/>
                    </div>
                    <button type="button" class="btn btn-success btn-sm btnStyle" onclick="consumeRecord()">支出记录</button>
                    <button type="button" class="btn btn-warning btn-sm btnStyle" onclick="consumeType()">类别管理</button>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
<script type="application/javascript">
    /*填写日记*/
    function fillDiary() {
        window.location.href="${pageContext.request.contextPath}/tempPlan/diary";
    }

    /*编辑计划*/
    function editPlan(){
        window.location.href="${pageContext.request.contextPath}/lifeGame/editPlan";
    }

    /*计划列表*/
    function toDoList(){
        window.location.href="${pageContext.request.contextPath}/tempPlan/toDoList";
    }

    /*消费类别*/
    function consumeRecord() {
        window.location.href="${pageContext.request.contextPath}/consume/consumeRecord";
    }

    /*消费内容*/
    function consumeType() {
        window.location.href="${pageContext.request.contextPath}/consume/consumeType";
    }
    
</script>

</html>
