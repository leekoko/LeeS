<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=Edge"> <!--IE8标准渲染模式-->
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>广东省供销合作联社直属企业监管平台</title>
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap-maizi.css" /> <!-- 覆盖原生样式-->
    <style>
        a{
            color: black;
        }
        a:hover{
            text-decoration:none;
        }
        span{
            font-size: 10px;
        }
    </style>
</head>
<body>


<div class="container">
    <div class="row">
        <!--用户列表小导航s-->

        <!--用户列表小导航e-->

        <!--用户列表内容s-->
        <div class="col-md-10">
            <div class="page-header">
                <h1>个人待办</h1>
            </div>
            <!--					<ul class="nav nav-tabs">
                                    <li class="active">
                                        <a href="user_list.html">用户列表</a>
                                    </li>
                                    <li>
                                        <a href="user_search.html">用户搜索</a>
                                    </li>
                                    <li>
                                        <a href="" data-toggle="modal" data-target="#myModal">添加用户</a>
                                    </li>
                                </ul>-->
            <div>
                <form action="#">
                    <div class="form-group">
                        <label for="addname">步骤名称</label>
                        <input type="text" id="addname" class="form-control" placeholder="用户名" />
                    </div>
                    <div class="form-group">
                        <label for="addpassword">申报单位</label>
                        <input type="text" id="addpassword" class="form-control" placeholder="请输入密码" />
                    </div>
                    <button type="button" class="btn btn-default" style="float: right;margin-bottom: 10px;">搜索</button>
                </form>
            </div>
            <table class="table">
                <tbody>

                <tr>
                    <td>
                        <a href="" data-toggle="modal" data-target="#myModal">
                            <h5>标题的内容</h5>
                            <div style="margin-left: 15px;">
                                <span>当前步骤：</span><span>开始步骤</span><br />
                                <span>接收日期：</span><span>2018-07-30</span><br />
                                <span>发件人名称：</span><span>李某某</span><br />
                                <span>上报单位：</span><span>上报单位股份有限公司</span>
                            </div>

                        </a>
                    </td>
                </tr>

                <tr>
                    <td>
                        <a href="" data-toggle="modal" data-target="#myModal">
                            <h5>标题的内容</h5>
                            <div style="margin-left: 15px;">
                                <span>当前步骤：</span><span>开始步骤</span><br />
                                <span>接收日期：</span><span>2018-07-30</span><br />
                                <span>发件人名称：</span><span>李某某</span><br />
                                <span>上报单位：</span><span>上报单位股份有限公司</span>
                            </div>
                        </a>
                    </td>
                </tr>

                <tr>
                    <td>
                        <a href="" data-toggle="modal" data-target="#myModal">
                            <h5>标题的内容</h5>
                            <div style="margin-left: 15px;">
                                <span>当前步骤：</span><span>开始步骤</span><br />
                                <span>接收日期：</span><span>2018-07-30</span><br />
                                <span>发件人名称：</span><span>李某某</span><br />
                                <span>上报单位：</span><span>上报单位股份有限公司</span>
                            </div>
                        </a>
                    </td>
                </tr>

                <tr>
                    <td>
                        <a href="" data-toggle="modal" data-target="#myModal">
                            <h5>标题的内容</h5>
                            <div style="margin-left: 15px;">
                                <span>当前步骤：</span><span>开始步骤</span><br />
                                <span>接收日期：</span><span>2018-07-30</span><br />
                                <span>发件人名称：</span><span>李某某</span><br />
                                <span>上报单位：</span><span>上报单位股份有限公司</span>
                            </div>
                        </a>
                    </td>
                </tr>
                </tbody>
            </table>
            <!--导航内容-->
            <nav aria-label="Page navigation" class="pull-right">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">5</a>
                    </li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>

        </div>
        <!--用户列表内容e-->

    </div>
</div>

<!--弹出框s-->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">详情页面</h4>
            </div>
            <div class="modal-body">
                <form action="#">
                    <div class="form-group">
                        <label for="addname">标题</label>
                        <input type="text" id="addname" class="form-control" placeholder="用户名" value="标题的内容" readonly="readonly"/>
                    </div>
                    <div class="form-group">
                        <label for="addpassword">当前步骤</label>
                        <input type="text" id="addpassword" class="form-control" placeholder="请输入密码" value="开始步骤" readonly="readonly"/>
                    </div>
                    <div class="form-group">
                        <label for="addemail">接收日期：</label>
                        <input type="email" id="addemail" class="form-control" placeholder="请输入邮箱" value="2018-07-30" readonly="readonly"/>
                    </div>
                    <div class="form-group">
                        <label for="addpassword">发件人名称</label>
                        <input type="text" id="addpassword" class="form-control" placeholder="请输入密码" value="李某某" readonly="readonly"/>
                    </div>
                    <div class="form-group">
                        <label for="addpassword">上报单位</label>
                        <input type="text" id="addpassword" class="form-control" placeholder="请输入密码" value="上报单位股份有限公司" readonly="readonly"/>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>

<!--弹出框e-->
</body>
</html>
