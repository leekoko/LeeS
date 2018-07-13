<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DZM页面</title>
<!-- 引入 Bootstrap -->
<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/TableDnD/0.9.1/jquery.tablednd.js" integrity="sha256-d3rtug+Hg1GZPB7Y/yTcRixO/wlI78+2m08tosoRn7A=" crossorigin="anonymous"></script>

<!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
<!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
<!--[if lt IE 9]>
   <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
   <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<style type="text/css">
.form-control-feedback{
	left:0;
	top:30px;
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
	<div class="row clearfix">
		<!-- 左边区 -->
		<div class="col-md-6 column">
			<form role="form">
				<div class="form-group">
					<div class="radio">
						<label>
							<input type="radio" name="optionsRadios" id="radios1" value="D：" checked>D
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios2" value="Z：">Z
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios3" value="M：">M
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios4" value="# ">#
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios5" value="## ">##
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios6" value="### ">###
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios7" value="```java">java
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios8" value="```">代码块						
						</label>
					</div>
	
				</div>	

				<div class="form-group">
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
					<textarea style="height:200px;width:450px;margin-left: 20px;" class="form-control" id="content" autofocus></textarea>
				</div>
				<button type="button" class="btn btn-default" id="sendWord">提交</button>
				<div class="form-group">
					<p class="help-block">
						快捷键：ctrl + D、Z、M选择角色，+1、2、3选择标题类型，+a进入通用代码块，+j进入java代码块
					</p>
				</div>
				<div class="form-group">
					<button type="button" class="btn btn-default btn-success">导出文件</button>
					<button type="button" class="btn btn-default btn-primary">导入文件</button>
				</div>
			</form>
		</div>
		<!-- 左边区 -->
		<!-- 右边区 -->
		<div class="col-md-6 column" style="height:600px;overflow:scroll;">
			<table id="table-1" cellspacing="0" style="overflow:scroll;width:100%;">
			    <tr class="list-group-item"><td>1D：免费域名注册免费域名注册免费域名注册<button type="button" class="btn btn-link btn-xs" style="float:right;">修改</button></td></tr>
			    <tr class="list-group-item"><td>2图像的数量</td></tr>
			    <tr class="list-group-item"><td>324*7 支持</td></tr>
			    <tr class="list-group-item"><td>4免费域名注册免费域名注册免费域名注册</td></tr>
			    <tr class="list-group-item"><td>5免费域名注册免费域名注册免费域名注册</td></tr>
			    <tr class="list-group-item"><td>6免费域名注册免费域名注册免费域名注册</td></tr>
			</table>
		</div>
		<!-- 右边区 -->
	</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
    // Initialise the table
    $("#table-1").tableDnD();
});


$("#sendWord").click(function() {
	var content = $("#content").val();
	var sign = $("input[name='optionsRadios']:checked").val();
	$("#table-1").prepend("<tr class='list-group-item'><td>" + sign + content + "</td></tr>");
	$("#content").val("");
});

</script>


</body>
</html>