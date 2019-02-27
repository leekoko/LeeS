<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<style>
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
            <td><span name="title">明天安排</span></td>
            <td><textarea type="text" name="content" class="form-control" style="height: 50px;" placeholder="输入内容"></textarea></td>
        </tr>
        <tr>
            <td><span name="title">80%</span></td>
            <td><textarea type="text" name="content" class="form-control" style="height: 100px;" placeholder="输入内容"></textarea></td>
        </tr>
    </tbody>

</table>
<button type="button" class="btn btn-success btn-lg" style="float: left;width: 100%;margin-bottom: 5px;" onclick="createDiary()">生成</button>
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
            var content = $(trEl[i]).find("textarea[name='content']").val();
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

</script>
</html>
