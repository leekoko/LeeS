<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书馆</title>
</head>
<body>

	<div class="col-md-12 column">
		<div class="form-group">
			我坐在哪里：<input type="text" id="seatNum"/>
			<div class="radio">
				<label>
					<input type="radio" name="optionsRadios" id="radios1" value="1" checked/>准备临时离开
					&nbsp;&nbsp;|&nbsp;&nbsp;
					时间：<input type="text" class="time"/>
				</label>
				<label>
					<input type="radio" name="optionsRadios" id="radios2" value="2"/>准备离开，继承位置
					&nbsp;&nbsp;|&nbsp;&nbsp;
					时间：<input type="text" class="time"/>
				</label>
			</div>	
			<!-- 按钮组 -->
			<div class="form-group pull-right">
				<button class="btn btn-primary btn-success" onclick="confirm();">确认</button>
			</div>
			<!-- 按钮组 -->
		</div>
	</div>
	<div class="col-md-12 column">
		<div class="form-group">
			<h3>A模式</h3>
			<c:forEach items="${seatListA}" var="item" varStatus="status">
				<span>${item.seatnum}</span>
			</c:forEach>
		</div>
		<div class="form-group">
			<h3>B模式</h3>
			<c:forEach items="${seatListB}" var="item" varStatus="status">
				<span>${item.seatnum}</span>
			</c:forEach>
		</div>
	</div>

</body>

<script>
function confirm(){
	var seatNum = $("#seatNum").val();
	var letOutType = $("input[name='optionsRadios']:checked").val();
	var letOutTime = $("input[name='optionsRadios']:checked").parent().children(".time").val();
 	$.ajax({
        type:"post",
        async:false,
        dataType:"json",
        url: "${pageContext.request.contextPath}/library/letOutSeat",
        data:{"seatNum":seatNum,"letOutType":letOutType,"letOutTime":letOutTime},
		success:function(data){
			if(data.result == true){
				alert("发布成功！");
				window.location.reload();
			}
		}
	});   
	
}

</script>


</html>