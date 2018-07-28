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
			<form>
				<div class="form-group">
					<div class="radio">
						<label>
							<input type="radio" name="optionsRadios" id="radios1" value="D：" checked/>D
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios2" value="Z："/>Z
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios3" value="M："/>M
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios4" value="# "/>#
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios5" value="## "/>##
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios6" value="### "/>###
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios7" value="```java"/>java
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios8" value="```"/>代码块						
						</label>
					</div>
				</div>	
				<div class="form-group">
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
					<textarea style="height:200px;width:450px;margin-left: 20px;" class="form-control" id="content" autofocus></textarea>
				</div>
			</form>
			<div class="form-group">
				<button type="button" class="btn btn-default" id="sendWord" onclick="sendWord()">提交</button>
				<button type="button" class="btn btn-default btn-success" id="exportFile" onclick="exportFile()">导出文件</button>
				<button type="button" class="btn btn-default btn-primary">导入文件</button>
			</div>
			<div class="form-group">
				<p class="help-block">
					快捷键：ctrl + D、Z、M选择角色，+1、2、3选择标题类型，+a进入通用代码块，+j进入java代码块
				</p>
			</div>
		</div>
		<!-- 左边区 -->
		<!-- 右边区 -->
		<div class="col-md-6 column" style="height:500px;overflow-y:scroll;">
			<table id="contentList" cellspacing="0" style="width:100%;">
				<tr class="list-group-item"><td class="cont">D：1111</td></tr>
				<tr class="list-group-item"><td class="cont">D：2222</td></tr>
				<tr class="list-group-item"><td class="cont">D：3333</td></tr>
			</table>
		</div>
		<!-- 右边区 -->
	</div>
</div>

</body>
<script type="text/javascript">
$(document).ready(function() {
    // Initialise the table
    $("#table-1").tableDnD();
});
/*鼠标触发事件*/
$(document).keyup(function(event){
	if(event.keyCode ==13){
		sendWord();
	}
	//向左
	if (event.ctrlKey && event.which == 37){

		var aNum = $("input[name='optionsRadios']:checked").attr('id').substring(6);
		$("input[name='optionsRadios']:checked").removeAttr('checked');
		var bNum = parseInt(aNum)-1;   //右加1
		if(aNum < 1){
			bNum = 8;
		}
		$("input[name='optionsRadios'][id='radios"+bNum+"']").attr('checked',true);
	} 
	//向右
	if (event.ctrlKey && event.which == 39){

		var cNum = $("input[name='optionsRadios']:checked").attr('id').substring(6);
		$("input[name='optionsRadios']:checked").removeAttr('checked');
		var dNum = parseInt(cNum)+1;   //右加1
		if(cNum > 8){
			dNum = 1;
		}
		$("input[name='optionsRadios'][id='radios"+dNum+"']").attr('checked',true);
	} 

	
});

/*发送文字*/
function sendWord(){
	var content = $.trim($("#content").val());
	if(content.length > 1){
		var sign = $("input[name='optionsRadios']:checked").val();
		$("#contentList").prepend("<tr class='list-group-item'><td>" + sign + content + "</td></tr>");
		$("#content").val("");
	}
}



/*导出md文件 */
function exportFile(){
/* 	var strArr = $("#contentList").children();
	var str = strArr[0].innerText;
	exportList(str); */
/* 	$('#contentList tr').each(function(i){                   // 遍历 tr
	    $(this).children('td').each(function(j){  // 遍历 tr 的各个 td
	       alert("第"+(i+1)+"行，第"+(j+1)+"个td的值："+$(this).text()+"。");
	    });
	}); */
	var arr = [];
	var contObject = $(".cont");
	for (var i = 0; i < contObject.length; i++) {
		arr.push(contObject[i].innerHTML);
	}
 	var reverArr = arr.reverse();
	var str = reverArr.toString();
	exportList(str);      //str格式   A,B,C
}


//导出ajax
function exportList(str){
    var data={};
    data.content = str;
    downLoadFile({url:"${pageContext.request.contextPath}" +"/content/exportMD",data:data});
}

//导出通用方法
function downLoadFile(options){
	var config = $.extend(true, { method: 'post' }, options);  
    var $iframe = $('<iframe id="down-file-iframe" />');  
    var $form = $('<form target="down-file-iframe" method="' + config.method + '" />');  
    $form.attr('action', config.url);  
    $form.attr('target', '');
    for (var key in config.data) {  
        $form.append('<input type="hidden" name="' + key + '" value="' + config.data[key] + '" />');  
    }  
    $iframe.append($form);
    $(document.body).append($iframe);
    $form[0].submit();
    $iframe.remove();
}

</script>
</html>