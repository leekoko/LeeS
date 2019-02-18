<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DZM页面</title>

<script type="text/javascript" src="${ctx}/js/plupload.full.min.js"></script>
<style type="text/css">
.form-control-feedback{
	left:0;
	top:30px;
}
.textareStyle{
	width: 100%;
	height: 300px;
	overflow-y:scroll;
	overflow-x:scroll;
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
		<button type="button" class="btn btn-info" onclick="addOne();">新增行</button>
	</div>
	<table class="table">
		<thead>
		<tr>
			<th width="10%">操作</th>
			<th width="20%">模板(~m~作为占位符)</th>
			<th width="70%">信息(|分割，$多个换行)</th>
		</tr>
		</thead>
		<tbody id="tableContent">
		<tr>
			<td>
				<h2>1</h2>
				<button type="button" class="btn btn-success" style="margin-top: 5px;">选择模板</button>
				<button type="button" class="btn btn-success" style="margin-top: 5px;" onclick="getThisModel(this)">生成代码</button>
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

</body>
<script type="text/javascript">
var modelCount = 1;
/*新增一行*/
function addOne(){
	$("#tableContent").prepend("<tr><td><h2>"+(++modelCount)+"</h2><button type='button' class='btn btn-success' style='margin-top: 5px;'>选择模板</button><button type='button' class='btn btn-success' style='margin-top: 5px;' onclick='getThisModel(this)'>生成代码</button></td><td><textarea class='textareStyle' name='modelCode'></textarea></td><td><textarea class='textareStyle' name='dataCode'></textarea></td></tr>");
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

function createOut(content,replaceContent) {
//替换内容
	var replaceArr = replaceContent.split("|");
	content = content.replaceAll("&gt;", ">");
	content = content.replaceAll("&lt;", "<");
	for (var i = 0; i < replaceArr.length; i++) {
		content = content.replace("~m~", replaceArr[i]);
	}
	$("#showCode").val($("#showCode").val() + content );
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

</script>





</html>