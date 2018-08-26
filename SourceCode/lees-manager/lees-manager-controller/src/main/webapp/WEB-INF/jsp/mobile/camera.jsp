<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>拍照页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

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
<style>
    .btn-circle.btn-xl {
        width: 150px;
        height: 150px;
        font-size: 24px;
        line-height: 1.33;
        border-radius: 100px;
    }
    #camearLog{
        margin-top: 100px;
    }
</style>

</head>
<body>
    <div class="container" id="camearLog">
        <div class="row clearfix">
            <div class="col-xs-2"></div>
            <div class="col-xs-8 center-block" >
                <button type="button" class="btn btn-default btn-circle btn-xl center-block" >
                    <i class="glyphicon glyphicon-camera"></i>
                </button>
            </div>
            <div class="col-xs-2"></div>
            <div class="col-xs-12">
                <div class="wrap flex flex-row">
                    <div class="control flex flex-column">
                        <p class="open">开启摄像头</p>
                        <p class="recognition">显示到Canvas</p>
                        <p class="close">关闭摄像头</p>
                    </div>
                    <div class="scan reference">
                        <div class="strainer"></div>
                        <video class="capture" width="320" height="456" src=""></video>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>

<script type="application/javascript">
    var buffer;
    var oCapture = document.querySelector(".capture"),
        open = document.querySelector(".open"),
        recognition = document.querySelector(".recognition"),
        close = document.querySelector(".close");
    var control = document.querySelector(".control");

    window.navigator.getUserMedia = navigator.getUserMedia || navigator.webKitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;

    function invokingCarera(){
        if(navigator.mediaDevices&&navigator.mediaDevices.getUserMedia){
            navigator.mediaDevices.getUserMedia({
                'audio':true,
                'video':{ 'facingMode': "user" }//调用前置摄像头，后置摄像头使用video: { facingMode: { exact: "environment" } }
            })
                .then(function(mediaStream) {console.log(555);getVideoStream(mediaStream)})
                .catch(function(error) { console.log(666);console.log(error) })
        }else if(navigator.getUserMedia){
            navigator.getUserMedia({
                'video':true,
                'audio':true
            },getVideoStream,getFail)
        }else{
            alert('不支持摄像头调用！')
        }
    }
    //调用成功
    function getVideoStream(stream){
        buffer = stream;
        if(oCapture.mozSrcObject !== undefined){
            oCapture.mozSrcObject = buffer;
        }else{
            oCapture.src = window.URL && window.URL.createObjectURL(buffer);
        }
        oCapture.play();
    }
    function getFail(){

    }
    recognition.onclick = function(){

    }
    control.addEventListener('click',function(e){
        e = e || window.event;
        var className = e.target.className;
        switch(className){
            case 'open':
                invokingCarera();
                break;
            case 'close':
                closeCamera();
                break;
            case 'recognition':
                screenShot();
                break;
            default:
                break;
        }
    })
    function closeCamera(){
        buffer&&buffer.getTracks()[1].stop();//关闭摄像头
    }
    window.requestAnimFrame = (function(){
        return  window.requestAnimationFrame       ||
            window.webkitRequestAnimationFrame ||
            window.mozRequestAnimationFrame    ||
            function( callback ){
                window.setTimeout(callback, 1000 / 60);
            };
    })();
    function screenShot(){
        var canvas = document.createElement('canvas');
        canvas.width=320,canvas.height = 456;
        document.querySelector(".wrap").appendChild(canvas);
        var ctx =  canvas.getContext('2d');
        function drawVideo(){
            ctx.drawImage(oCapture,0,0,320,456);
            ctx.font = "30px sans-serif";
            ctx.fillStyle = "blue";
            ctx.fillText("请眨眼", 50, 50);
            requestAnimationFrame(drawVideo);
        }
        window.requestAnimationFrame(drawVideo);
    }
</script>