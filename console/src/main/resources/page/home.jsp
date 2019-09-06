<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/quick-layout-min.css">
    <link rel="stylesheet" href="css/main.css">
    <style type="text/css">
		.show-grid [class^=col-] {
		    padding: 10px 5px;
		    margin: 0;
		}
		.row{
			margin: 0;
		}
		.panel-body {
		    padding: 10px;
		}
    </style>
  </head>
  <body>   
  	 <div class="show-grid">
  	 	<div class="p5">
		<ol class="breadcrumb m0">
			<li class="active"><a href="javascript:;"><span class="glyphicon glyphicon-home mr5"></span>Home</a></li>
		</ol>
		</div>
		<div class="panel-group" id="accordion">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-6">
					<div class="panel panel-info">
					  <div class="panel-heading">
					    <h3 class="panel-title">
					    	<span class="glyphicon glyphicon-calendar mr5"></span>登录日志
					    	<a class="r collapseBtn" data-collapse-flag="1" data-toggle="collapse" data-parent="#accordion" href="#showHistoryLoginInfo">
					    	<span class="glyphicon glyphicon-chevron-up"></span>
					    	</a>
					    </h3>
					  </div>
					  <div id="showHistoryLoginInfo" class="panel-body">
					  </div>
					</div>
				</div>


	  			 <div class="col-xs-12 col-sm-12 col-md-6 dn">
					<div class="panel panel-default">
						<div class="panel-heading">
						  <h3 class="panel-title">功能块2</h3>
						</div>
						<div class="panel-body">

						</div>
					</div>
	  			 </div>

			</div>
		</div>
	 </div>
  </body>

  <script src="js/jquery.min.js"></script>
  <script src="js/handlebars-v4.0.5.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/public.js"></script>
  <script id="entry-template" type="text/x-handlebars-template">
		<div class="entry">
  			<h1>{{title}}</h1>
  			<div class="body">
    			{{{body}}}
  			</div>
		</div>
  </script>
  <script id="loginLogTpl" type="text/x-handlebars-template">
	{{#each items}}
	<span class='db'>
		IP地址：<a href="javascript:">{{loginIp}}</a>
		&emsp;&emsp;时间：<span class="gray">{{loginTime}}</span>
		&emsp;&emsp;状态：
		{{#if loginStatus}}
		<span class='green b'>成功</span>
		{{else}}
		<span class='red b'>失败</span>
		{{/if}}
	</span>
	{{/each}}
  </script>
  <script type="text/javascript">
  	function tipModal(text){
  		//$("#tipModal").find(".modal-body").html("<img src='img/load.gif'> 正在加载中...");
  		//$("#tipModal").modal({backdrop:"static"},"toggle"); //show,hide modal({backdrop:"static"},"toggle")
  	}
  </script>
  <script src="js/home.js?"></script>
</html>
