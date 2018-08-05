<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
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

<script type="text/javascript" src="${ctx}/js/plupload.full.min.js"></script>
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
							<input type="radio" name="optionsRadios" id="radios1" value="" checked/>空
							&nbsp;&nbsp;|&nbsp;&nbsp;
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios2" value="D："/>D
							&nbsp;&nbsp;|&nbsp;&nbsp;
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios3" value="Z："/>Z
							&nbsp;&nbsp;|&nbsp;&nbsp;
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios4" value="M："/>M
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios5" value="# "/>#
							&nbsp;&nbsp;|&nbsp;&nbsp;
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios6" value="## "/>##
								&nbsp;&nbsp;|&nbsp;&nbsp;
						</label>
						<label>
							<input type="radio" name="optionsRadios" id="radios7" value="### "/>###
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
				<!-- 上传控件 -->
				<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">导入文件</button>
				<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">清空</button>
			<br/><br/>
			</div>
			<!-- 按钮触发模态框 -->

			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								MD文件导入
							</h4>
						</div>
						<div class="modal-body">
							<div id="container">
			    				<a id="pickfiles" href="javascript:;">[Select files]</a> 
			    				<a id="uploadfiles" href="javascript:;">[Upload files]</a>
							</div>
							<div id="filelist">Your browser doesn't have Flash, Silverlight or HTML5 support.</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭
							</button>
							<button type="button" class="btn btn-primary" onclick="ConfirmImport();">
								确认
							</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div>

			
 
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">确认框</h4>
			      </div>
			      <div class="modal-body">
			        <form>
			       	<div class="form-group">
			            <label for="message-text" class="control-label">确定要清空内容吗？</label>
			          </div>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
			        <button type="button" class="btn btn-primary" onclick="del();">确认</button>
			      </div>
			    </div>
			  </div>
			</div>			
			
			
			<div class="form-group">
				<p class="help-block">
					快捷键：ctrl + ←/→ 可以调整单选按钮位置。
				</p>
			</div>
		</div>
		<!-- 左边区 -->
		<!-- 右边区 -->
		<div class="col-md-6 column" style="height:500px;overflow-y:scroll;">
			<table id="contentList" cellspacing="0" style="width:100%;">
				<c:if test="${not empty list}">
					<c:forEach items="${list}" var="item" varStatus="status">
						<tr class='list-group-item'><td class='cont'>${item}</td></tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<!-- 右边区 -->
	</div>
</div>

</body>
<script type="text/javascript">
$(document).ready(function() {
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
		if(bNum < 1){
			bNum = 7;
		}
//		$("input[name='optionsRadios'][id='radios"+bNum+"']").attr('checked',true);
		$("input[name='optionsRadios'][id='radios"+bNum+"']").click();
	} 
	//向右
	if (event.ctrlKey && event.which == 39){

		var cNum = $("input[name='optionsRadios']:checked").attr('id').substring(6);
		$("input[name='optionsRadios']:checked").removeAttr('checked');
		var dNum = parseInt(cNum)+1;   //右加1
		if(dNum > 7){
			dNum = 1;
		}
		$("input[name='optionsRadios'][id='radios"+dNum+"']").click();
	} 
	
});

/*发送文字*/
function sendWord(){
	var content = $.trim($("#content").val());
	if(content.length > 1){
 		var sign = $("input[name='optionsRadios']:checked").val();
		$("#contentList").prepend("<tr class='list-group-item'><td class='cont'>" + sign + content + "</td></tr>"); 
		$("#content").val("");
		$.ajax({
			url : "${pageContext.request.contextPath}" +"/content/insert",
			type : "POST",
			data : {"content":sign + content},
			async : false,
			success:function(data){
				//window.location.reload();
			}
		});
	}
}



/*导出md文件 */
function exportFile(){
	var arr = [];
	var contObject = $(".cont");
	for (var i = 0; i < contObject.length; i++) {
		arr.push(contObject[i].innerHTML);
	}
 	var reverArr = arr.reverse();
	var str = reverArr.toString();
	if($.trim(str).length < 1){
		return;
	}
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

function ConfirmImport(){
	//刷新页面
	window.location.reload();
}

function del(){
	//刷新页面
	$.ajax({
		url : "${pageContext.request.contextPath}" +"/content/delete",
		type : "POST",
		async : false,
		success:function(data){
			window.location.reload();
		}
	});
}
	


</script>

<!-- 上传文件 -->
<script type="text/javascript">

var uploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : 'pickfiles', // you can pass an id...
	container: document.getElementById('container'), // ... or DOM Element itself
	url : "${pageContext.request.contextPath}" +"/content/uploadMD",
 	flash_swf_url : '${ctx}/js/Moxie.swf',
	silverlight_xap_url : '${ctx}/js/Moxie.xap', 
	
	filters : {
		max_file_size : '10mb',
		mime_types: [
			{title : "doc files", extensions : "md"},
		]
	},

	init: {
		PostInit: function() {
			document.getElementById('filelist').innerHTML = '';
			
			document.getElementById('uploadfiles').onclick = function() {
				uploader.start();
				return false;
			};
		},
		FilesAdded: function(up, files) {      //上传完毕触发
			plupload.each(files, function(file) {
				document.getElementById('filelist').innerHTML += '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ') <b></b></div>';
			});
		},
		UploadProgress: function(up, file) {
			document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
		},
		Error: function(up, err) {
			
		}
	}
});

uploader.init();

</script>



</html>