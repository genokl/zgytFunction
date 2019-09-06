<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>CRM</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/quick-layout-min.css">
    <link rel="stylesheet" href="css/main.css">
    <style type="text/css">
    	a:hover{
    		color: #fff;
    	}
    </style>
</head>
<body class="p0 m0">
<div class="top-content">
    <h2 class="p0 m0 white l ml20 logo_color" style="margin-top: 19px; font-size: 23px;">中公远通内容管理系统</h2>
    <div class="r pr30">
        <b class="mr10"><span class="glyphicon glyphicon-user mr5"></span> ${loginName }</b>|
        <a id="exit" href="javascript:void(0)" class="ml10 exit" target="_parent" ><span class="glyphicon glyphicon-off mr5"></span>退出</a>
    </div>
</div>
<input type="hidden" value="<%=basePath%>" id="basePath"/>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" >
 	var websocket = null;
	//判断当前浏览器是否支持WebSocket
	if('WebSocket' in window){
		//websocket = new WebSocket("ws://115.159.70.190:8080/CRM/crmSocket"); // 正式环境
		//websocket = new WebSocket("ws://192.168.1.254:8080/CRM/crmSocket"); // 测试环境
	}else{
		alert('Not support websocket');
	}
	//连接成功建立的回调方法
		//websocket.onopen = function(event){
		//console.log("open")
//	}; 
       
$(function(){
	//退出方法
	$("#exit").click(function(){
		$.get("login_loginOut",function(){
			top.window.location.href=$("#basePath").val()+"login_goToLoginPage";
		});
	});
});

       
    
       

</script>
</body>
</html>