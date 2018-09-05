<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DZM页面</title>
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css" />



</head>
<body>
<div class="container">
	<div class="col-md-12 column ">
		<h1>
			LeeS
		</h1>
	</div>
	
	<div class="col-md-12 column ">
		<header class="codrops-header">
			<h1>生活辅助类</h1>	
			<nav class="codrops-demos">
				<a class="current-demo" href="${pageContext.request.contextPath}/contentDB">ContentMD</a>
				<a class="current-demo" href="${pageContext.request.contextPath}/collection">页面收藏</a>
			</nav>
		</header>
	</div>
	<div class="col-md-12 column ">
		<header class="codrops-header">
			<h1>线上工具类</h1>	
			<nav class="codrops-demos">
				<a class="current-demo" href="${pageContext.request.contextPath}/library">图书馆</a>
			</nav>
		</header>
	</div>
	<div class="col-md-12 column ">
		<header class="codrops-header">
			<h1>手机端页面Test</h1>
			<nav class="codrops-demos">
				<a class="current-demo" href="${pageContext.request.contextPath}/mobile/login">登录</a>
				<a class="current-demo" href="${pageContext.request.contextPath}/mobile/camera">相机</a>
				<a class="current-demo" href="${pageContext.request.contextPath}/mobile/mainFrame">主页面</a>
			</nav>
		</header>
	</div>
	<div class="col-md-12 column ">
		<header class="codrops-header">
			<h1>手机平台</h1>
			<nav class="codrops-demos">
				<a class="current-demo" href="${pageContext.request.contextPath}/selectColumnPage">选择列页面</a>
			</nav>
		</header>
	</div>
</div>

</body>



</html>