<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DZM页面</title>

<script type="text/javascript" src="${ctx}/js/plupload.full.min.js"></script>
<style type="text/css">
.textareStyle{
	width: 100%;
	height: 300px;
	overflow-y:scroll;
	overflow-x:scroll;
}
.mt10{
	margin-top: 10px;
}
.status0{
	color: red;
	float: right;
}
.status1{
	color: green;
	float: right;
}
.btn{
	margin-right: 5px;
}
</style>

</head>
<body>
<div class="container">
	<div class="col-md-12 column ">
		<h2>
			LeeS
		</h2>
	</div>
	<div>
		<button type="button" class="btn btn-info" onclick="addOnePrepend();">前面新增行</button>
		<button type="button" class="btn btn-info" onclick="addOneAppend();">后面新增行</button>
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">选择模板</button>

		<button type="button" class="btn btn-warning pull-right" data-toggle="modal" data-target="#modelFlow">保存流程</button>
		<button type="button" class="btn btn-success pull-right" data-toggle="modal" data-target="#modelFlowList">选择流程</button>
	</div>
	<table class="table" name="table">
		<thead>
		<tr>
			<th width="20%">操作</th>
			<th width="20%">模板(~m~作为占位符)</th>
			<th width="60%">信息(|分割，$多个换行)</th>
		</tr>
		</thead>
		<tbody id="tableContent">
		<tr>
			<td>
				<span>【1】</span>
				<input type="hidden" name="code" value=""/>
				<button type="button" class="btn btn-warning btn-sm" style="margin-top: 5px;" onclick="saveModel(this)">保存模板</button>
				<button type="button" class="btn btn-danger btn-sm" style="margin-top: 5px;" onclick="delCol(this)">移除</button>
				<div class="input-group">
					<input type="text" name="title" class="form-control mt10"  placeholder="输入名称">
					<textarea type="text" name="summary" class="form-control mt10" style="height: 170px;" placeholder="输入简介"></textarea>
				</div>
				<button type="button" class="btn btn-success" style="margin-top: 5px;" onclick="getThisModel(this)">生成代码</button>
				<b class="status0" name="status" value="0">未保存</b>
			</td>
			<td>
				<textarea class="textareStyle" name="modelCode"></textarea>
			</td>
			<td>
				<textarea class="textareStyle" name="dataCode"></textarea>
			</td>
		</tr>

		</tbody>
	</table>
	<div style="margin-bottom: 10px;">
		<button type="button" class="btn btn-danger" onclick="delOut();">清空</button>
	</div>
	<%--下边区域--%>
	<textarea id="showCode" class="col-md-12 column" style="height:500px;overflow-y:scroll;"></textarea>
	<%--下边区域--%>

</div>

<!-- 模态框：选择模板列表 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">模板选择页面</h4>
			</div>
			<div class="modal-body">
				<iframe id="choseIframe" src="${pageContext.request.contextPath}/modelChosePage" height="80%" width="100%" frameborder="0"></iframe>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<!-- 模态框：模板流信息填写窗口 -->
<div class="modal fade" id="modelFlow" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel2">模板流程信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form">
					<p style="color: #aaaaaa">流程仅存储"已保存"的模板</p>
					<div class="form-group">
						<label for="flowName" class="col-sm-2 control-label">流程名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="flowName"
								   placeholder="请输入流程名">
						</div>
					</div>
					<div class="form-group">
						<label for="flowSummary" class="col-sm-2 control-label">流程简介</label>
						<div class="col-sm-10">
							<textarea type="text" class="form-control" id="flowSummary"
									  placeholder="请输入流程简介" style="height:200px;overflow-y:scroll;"></textarea>
						</div>
					</div>
				</form>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="saveFlow(this)">保存</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<!-- 模态框：选择模板流程列表 -->
<div class="modal fade" id="modelFlowList" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true" >
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel3">模板流程选择页面</h4>
			</div>
			<div class="modal-body">
				<iframe id="choseFlowIframe" src="${pageContext.request.contextPath}/flowChosePage" height="80%" width="100%" frameborder="0"></iframe>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

</body>
<script type="text/javascript">
var modelCount = 1;	 //模板序号
/*新增一行前面*/
function addOnePrepend(){
	$("#tableContent").prepend("<tr><td><span>【"+ (++modelCount) +"】</span><input type='hidden'  name='code' value=''/><button type='button' class='btn btn-warning btn-sm' style='margin-top: 5px;' onclick='saveModel(this)'>保存模板</button><button type='button' class='btn btn-danger btn-sm' style='margin-top: 5px;' onclick='delCol(this)'>移除</button><div class='input-group'><input type='text'  name='title' class='form-control mt10'  placeholder='输入名称'><textarea type='text'  name='summary' class='form-control mt10' style='height: 170px;' placeholder='输入简介'></textarea></div><button type='button' class='btn btn-success' style='margin-top: 5px;' onclick='getThisModel(this)'>生成代码</button><b class='status0' name='status' value='0'>未保存</b></td><td><textarea class='textareStyle' name='modelCode'></textarea></td><td><textarea class='textareStyle' name='dataCode'></textarea></td></tr>");
}
/*新增一行后面*/
function addOneAppend(){
	$("#tableContent").append("<tr><td><span>【"+ (++modelCount) +"】</span><input type='hidden'  name='code' value=''/><button type='button' class='btn btn-warning btn-sm' style='margin-top: 5px;' onclick='saveModel(this)'>保存模板</button><button type='button' class='btn btn-danger btn-sm' style='margin-top: 5px;' onclick='delCol(this)'>移除</button><div class='input-group'><input type='text'  name='title' class='form-control mt10'  placeholder='输入名称'><textarea type='text'  name='summary' class='form-control mt10' style='height: 170px;' placeholder='输入简介'></textarea></div><button type='button' class='btn btn-success' style='margin-top: 5px;' onclick='getThisModel(this)'>生成代码</button><b class='status0' name='status' value='0'>未保存</b></td><td><textarea class='textareStyle' name='modelCode'></textarea></td><td><textarea class='textareStyle' name='dataCode'></textarea></td></tr>");
}

/*移除当前模板*/
function delCol(el){
	var tr = el.parentNode.parentNode;
	$(tr).remove();
}

/*保存模板信息到数据库*/
function saveModel(el) {
	var td = el.parentNode;
	var tr = td.parentNode;
	var codeEl = $(td).find("input[name='code']");   //code元素
	var statusEl = $(td).find("b[name='status']");   //status元素
	var titleEl = $(tr).find("input[name='title']");

	var content = $(tr).find("textarea[name='modelCode']").val();
	var title = titleEl.val();
	if($.trim(title) == ""){
		alert("模板标题不能为空");
		return;
	}
	var summary = $(tr).find("textarea[name='summary']").val();
	var code = codeEl.val();
	//保存模板信息
	$.ajax({
		url : "${pageContext.request.contextPath}/template/save",
		type : "POST",
		async : false,
		data : {"content":content,"title":title,"summary":summary,"code":code},
		success:function(data){
			if(data.flag){
				codeEl.val(data.code);
				titleEl.attr("readonly","readonly");
				statusEl.text("已保存");
				statusEl.attr("value","1");
				statusEl.attr("class","status1");
				alert("保存成功");
			}
		}
	});
}

/*获取当前模板内容*/
function getThisModel(el){
	var tr = el.parentNode.parentNode;
	var content = $(tr).find("textarea[name='modelCode']").val();
	var replaceContent =  $(tr).find("textarea[name='dataCode']").val();
	//清空输入框内容
    $("textarea[name='dataCode']").val("")
	console.log(replaceContent);
	//获取文本输入框数目
	// var num = patch(content);
	//多个生成
	var replaceArr = replaceContent.split("$");
	for(var i =0 ; i < replaceArr.length; i++){
		createOut(content,replaceArr[i]);
	}
}

/*变量内容替换*/
function createOut(content,replaceContent) {
//替换内容
	var replaceArr = replaceContent.split("|");
	content = content.replaceAll("&gt;", ">");
	content = content.replaceAll("&lt;", "<");
	for (var i = 0; i < replaceArr.length; i++) {
		var replace = $.trim(replaceArr[i]);
		content = content.replace("~m~", replace);
	}
	$("#showCode").val($("#showCode").val()+"\r\n" + content );
}

//匹配字符出现次数
function patch(s){ //参数1正则式，参数2字符串
	var len =s.split("~m~").length-1
	return len;
}

//定义全部替换正则表达式
String.prototype.replaceAll = function (FindText, RepText) {
	regExp = new RegExp(FindText, "g");
	return this.replace(regExp, RepText);
}

/**清空输出窗口**/
function delOut(){
	$("#showCode").val("");
}

/*隐藏模态框*/
function hideModal() {
	$('#myModal').modal('hide');
	showContent();
}

/*显示内容*/
function showContent() {
	//模板内容
	var content = document.getElementById("choseIframe").contentWindow.curContent;
	//模板标题
	var title = document.getElementById("choseIframe").contentWindow.curTitle;
	//模板简介
	var summary = document.getElementById("choseIframe").contentWindow.curSummary;
	//当前模板code
	var code = document.getElementById("choseIframe").contentWindow.curCode;
	//填充元素内容
	fillContent(content,title,summary,code);
}
/*填充元素内容*/
function fillContent(content,title,summary,code){
	$("#tableContent").append("<tr><td><span>【"+ (++modelCount) +"】</span><input type='hidden'  name='code' value='"+code+"'/><button type='button' class='btn btn-warning btn-sm' style='margin-top: 5px;' onclick='saveModel(this)'>保存模板</button><button type='button' class='btn btn-danger btn-sm' style='margin-top: 5px;' onclick='delCol(this)'>移除</button><div class='input-group'><input type='text'  name='title' class='form-control mt10'  placeholder='输入名称' value='"+title+"' readonly><textarea type='text'  name='summary' class='form-control mt10' style='height: 170px;' placeholder='输入简介'>"+summary+"</textarea></div><button type='button' class='btn btn-success' style='margin-top: 5px;' onclick='getThisModel(this)'>生成代码</button><b class='status1' name='status' value='1'>已保存</b></td><td><textarea class='textareStyle' name='modelCode'>"+content+"</textarea></td><td><textarea class='textareStyle' name='dataCode'></textarea></td></tr>");
}

/*保存流程*/
function saveFlow(el) {
	var flowName = $("#flowName").val();
	if($.trim(flowName) == ""){
		alert("流程标题不能为空");
		return;
	}
	var flowSummary = $("#flowSummary").val();
	var trArrEl = $("#tableContent tr");
	var codeArr = [];
	var titleArr = [];
	for (var i = 0; i < trArrEl.length; i++){
		var curCode = $(trArrEl.get(i)).find("input[name='code']").val();
		if(curCode != ''){
			codeArr.push(curCode);
			titleArr.push($(trArrEl.get(i)).find("input[name='title']").val());
		}
	}
	//保存模板流程
	$.ajax({
		url : "${pageContext.request.contextPath}/templateFlow/saveFlow",
		type : "POST",
		async : false,
		data : {"codearr": codeArr.toString(), "titlearr": titleArr.toString(),"flowname": flowName, "flowsummary": flowSummary},
		success:function(data){
			if(data){
				alert("保存成功");
				$('#modelFlow').modal('hide');
			}
		}
	});
}

/*显示流程中的模板*/
function showFlowModel() {
	$('#modelFlowList').modal('hide');
	//模板内容
	var modelCodes = document.getElementById("choseFlowIframe").contentWindow.modelCodes;
	var modelCodeArr = modelCodes.split(",");
	//清空内容
	$("#tableContent").empty();
	for (var i = 0; i < modelCodeArr.length; i++){
		//根据modelCode填充元素
		fillContentByCode(modelCodeArr[i]);
	}
}

/*根据modelCode填充元素*/
function fillContentByCode(modelCode) {
	var curContent = "";
	var curSummary = "";
	var curTitle = "";
	var curCode = "";
	$.ajax({
		url : "${pageContext.request.contextPath}/template/getContentByCode",
		type : "POST",
		async : false,
		data : {"code":modelCode},
		success:function(data){
			if(data.flag){
				curContent = data.content;
				curSummary = data.summary;
				curTitle = data.title;
				curCode = data.code;
				//填充元素内容
				fillContent(curContent,curTitle,curSummary,curCode);
			}
		}
	});
}

</script>





</html>