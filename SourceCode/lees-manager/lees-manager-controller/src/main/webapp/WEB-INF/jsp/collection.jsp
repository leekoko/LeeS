<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>干货</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/chosen.css"/>
<script type="text/javascript" src="${ctx}/js/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${ctx}/js/plupload.full.min.js"></script>
<script src="${ctx}/js/chosen.jquery.js" type="text/javascript"></script>
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" media="all" />

<style type="text/css">
	a:link {
	 font-size: 12px;
	 color: #000000;
	 text-decoration: none;
	}
	a:visited {
	 font-size: 12px;
	 color: #000000;
	 text-decoration: none;
	}
	a:hover {
	 font-size: 12px;
	 color: #999999;
	 text-decoration: underline;
	}
</style>
		
</head>
<body>
<div class="container">
	<div class="col-md-12 column ">
		<a href="${pageContext.request.contextPath}/">
			<h1>
				LeeS
			</h1>
		</a>
	</div>
	<!-- 按钮组 -->
	<div class="form-group pull-right">
		<button class="btn btn-primary btn-success" data-toggle="modal" data-target="#myModal">添加页面</button>
		<button class="btn btn-primary" data-toggle="modal" data-target="#myModal2">添加类别</button>

	</div>
	<!-- 按钮组 -->
 
	<!-- 内容区域 -->
	<div class="col-md-12 column" id="content"></div>
	<!-- 内容区域 -->
	<!-- 模态框1 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						添加收藏页面
					</h4>
				</div>
				<div class="modal-body">
					<div id="container">
	    				<a id="pickfiles" href="javascript:;">[Select files]</a> 
	    				<a id="uploadfiles" href="javascript:;">[Upload files]</a>
						<div id="filelist">Your browser doesn't have Flash, Silverlight or HTML5 support.</div>
 						<div class="form-group">
							 <label>标题</label><input type="text" class="form-control" id="title"/>
						</div>
 						<div class="form-group">
							 <label>URL</label><input type="text" class="form-control" id="pageUrl"/>
						</div>
 						<div class="form-group">
							 <label>介绍</label><input type="text" class="form-control" id="intro"/>
						</div>
						<c:forEach items="${typeList}" varStatus="i" var="item" >  
							<label>
								<input type="radio" name="optionsRadios" value="${item.id}"/>${item.typename}
								&nbsp;&nbsp;|&nbsp;&nbsp;
							</label>
						</c:forEach>
						<input type="hidden" value="${uuid}" id="uuid" /> 
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="confirm();">确认</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 模态框1 -->
	<!-- 模态框2 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						添加类别
					</h4>
				</div>
				<div class="modal-body">
					<div id="container">
 						<div class="form-group">
							 <label>类别名称</label><input type="text" class="form-control" id="typeName"/>
						</div>
						<c:forEach items="${typeList}" varStatus="i" var="item" >  
							<label>
								${item.typename} &nbsp;&nbsp;|&nbsp;&nbsp;
							</label>
						</c:forEach>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="confirmTypeName();">确认</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 模态框2 -->
</div>

</body>


<script type="text/javascript">
$(function(){
	$.ajaxSetup({async:false});
	var html="";
	/*var htmlSearch="";*/
	$.post("${pageContext.request.contextPath}/collection/collectionType",function(data){
		$.each(data,function (i,item) {
			html += "<div class='panel panel-default' style='height:400px;overflow-x: hidden;'><div class='panel-heading'><h4 class='panel-title'><p data-toggle='collapse' data-parent='#accordion' >"+item.typename+"</p></h4></div><div id='"+item.id+"' class='panel-collapse collapse in'><div class='panel-body grid_s'>";   /*href='#"+item.id+"'*/
			$.post("${pageContext.request.contextPath}/collection/getContentList",{'parentId':item.id},function(data2){
				$.each(data2,function(i,item2){
					html+="<div class='grid' style='width:330px;height:300px;margin-top:20px; display:block;'><input type='hidden' class='id' value='"+item2.id+"'/><a href='"+item2.pageurl+"' target='_blank'><div class='gallery'><img src='"+item2.imgurl+"' title='image-name' style='height:180px;'></div><h4 style='font-family:Arial;'>"+item2.title+"</h4><div class='grid_p'><p>"+item2.intro+"</p></div></a></div>";
					/* htmlSearch+="<option value='"+item2.pageurl+"'>"+item2.title+"</option>"; */
				});
			});
			html+="</div></div></div>";
		}); 
	});
	$("#content").append(html);
	/* $("#search").html("111"); */
	/*更新点击时间*/
	$(".grid").click(function(){
		$.ajax({
	        type:"post",
	        async:false,
	        dataType:"json",
	        url: "${pageContext.request.contextPath}/collection/updateClickDate",
	        data:{"id":$(this).children().val()}
    	});  
	});

	
});
</script>
	

<script>


function confirm(){
	var title = $("#title").val();
	var pageUrl = $("#pageUrl").val();
	var uuid = $("#uuid").val();
	var intro = $("#intro").val();
	var typeId = $("input[name='optionsRadios']:checked").val();
    $.ajax({
        type:"post",
        async:false,
        dataType:"json",
        url: "${pageContext.request.contextPath}/collection/save",
        data:{"id":uuid,"title":title,"pageUrl":pageUrl,"intro":intro,"typeId":typeId},
        success : function(data) {
            if(data.result==true){
    			window.location.reload();
            }
        }
    }); 
}
/*添加类别名*/
function confirmTypeName(){
	var typeName = $("#typeName").val();
    $.ajax({
        type:"post",
        async:false,
        dataType:"json",
        url: "${pageContext.request.contextPath}/collection/addType",
        data:{"typeName":typeName},
        success : function(data) {
            if(data.result==true){
            	window.location.reload();
            }
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
	url : "${pageContext.request.contextPath}" +"/collection/uploadImg?id=${uuid}",
 	flash_swf_url : '../js/Moxie.swf',
	silverlight_xap_url : '../js/Moxie.xap', 
	
	filters : {
		max_file_size : '10mb',
		mime_types: [
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