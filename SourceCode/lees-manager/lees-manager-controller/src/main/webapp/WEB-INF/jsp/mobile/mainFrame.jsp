<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机页面主框架</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <%-- 引入mobileNav css --%>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/mobileNav/style.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/mobileNav/framework.css"/>


    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <%--引入mobileNav js--%>
    <script type="text/javascript" src="${ctx}/js/mobileNav/snap.js"></script>
    <script type="text/javascript" src="${ctx}/js/mobileNav/custom.js"></script>
    <script type="text/javascript" src="${ctx}/js/mobileNav/framework.launcher.js"></script>


</head>
<body>

<div class="all-elements">
    <!-- 侧边导航内容s  -->
    <div id="sidebar" class="page-sidebar">
        <div class="page-sidebar-scroll">
            <div class="sidebar-section">
                <p>Navigation</p>
                <a href="#" class="sidebar-close"></a>
            </div>

            <div class="navigation-items">
                <div class="nav-item">
                    <a href="index.html" class="home-nav">Home<em class="selected-nav"></em></a>
                </div>
                <div class="nav-item">
                    <a href="#" class="features-nav submenu-deploy">Features<em class="dropdown-nav"></em></a>
                    <div class="nav-item-submenu">
                        <a href="intro.html">Introduction	 <em class="unselected-sub-nav"></em></a>
                    </div>
                </div>
                <div class="nav-item">
                    <a href="#" class="media-nav submenu-deploy">Media<em class="dropdown-nav"></em></a>
                    <div class="nav-item-submenu">
                        <a href="widefolio.html">Wide Portfolio	 		  <em class="unselected-sub-nav"></em></a>
                        <a href="onefolio.html">1 Column folio	  	  	   <em class="unselected-sub-nav"></em></a>
                    </div>
                </div>

                <div class="nav-item">
                    <a href="#" class="close-nav">Close<em class="unselected-nav"></em></a>
                </div>
                <div class="sidebar-decoration"></div>
            </div>


        </div>
    </div>
    <!-- 侧边导航内容e  -->

    <!-- 内容区域s -->
    <div id="content" class="page-content">

        <div class="page-header" style="margin-top: 0px;">
            <a href="#" class="deploy-sidebar"></a>
            <p class="bread-crumb">welcome</p>
            <!-- <a href="contact.html" class="deploy-contact"></a> -->
        </div>

        <div class="content">      <!--需改成动态获取高度 -->
            <iframe id="homecontentDiv" name="homecontentDiv" src="${pageContext.request.contextPath}/mobile/mainPage" width="99%" height="850px;" frameborder="0" scrolling="no">
            </iframe>
        </div>
    </div>
    <!-- 内容区域e -->

</div>

</body>

<script>
</script>

</html>
