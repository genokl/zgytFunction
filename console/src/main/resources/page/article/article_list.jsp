<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title >文章列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/quick-layout-min.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/page.css">
<style>
body {
	margin: 0px;
	padding: 20px;
	font-family: "lucida Grande",Verdana,"Microsoft YaHei";
    font-size: 12px;
}

/* 设置条件condition样式 */
.condition{
	text-decoration: none;
    padding: 2px;
    display: inline-block;
    border: 1px solid #ccc;
    margin: 2px;
}
.condition:hover{
	text-decoration: none;
    padding: 2px;
    display: inline-block;
    border: 1px solid #ef3333;
    margin: 2px;
}

#bd div {
	margin: 10px 0px;
	display: none;
	font-size: 12px;
}
#tj {
	-webkit-column-count: 1; /* Safari 和 Chrome */
	column-count: 1;
	text-align: left;
}
#tj input {
	margin: 10px;
}
#activityBaseInfo div{
    width:80%;
    height:20px;
    display:block;
    margin-bottom:10px
}
#activityRule div{
    width:80%;
    height:20px;
    display:block;
    margin-bottom:10px
}
h3{
    margin-bottom:5px;
}
.hiden{
	display: none;
}
</style>
</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/quick-layout-min.css">
<link rel="stylesheet" href="css/page.css">
<body>
	<div id="selectButtonList">
		<input type="button" value="公司新闻" id="selectButton1" data-isSelect="0" data-type="3" onclick="addSelectCondition(this)">
		<input type="button" value="公司产品" id="selectButton2" data-isSelect="0" data-type="4" onclick="addSelectCondition(this)">
		<input type="button" value="科研技术" id="selectButton3" data-isSelect="0" data-type="5" onclick="addSelectCondition(this)">
		<!-- <input id="queryCondition" > -->
	</div>
	筛选条件
	<div id="conditionList">
		<!-- <a href="#" class="condition">hehe1</a> -->
		<input class="button" value="新建"/>
	</div>
	
	<table
		class="table table-bordered table-condensed table-responsive table-hover table-striped">
		<thead>
			<tr class="bg-555 white">
				<th>文章预览图</th>
				<th>文章标题</th>
				<th>创建时间</th>
				<th>文章类型</th>
				<th>文章展示状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="table-hover" id="articlesList">
	<!-- 	<tr>
				<td>活动1</td>
				<td>类型2</td>
				<td>异常</td>
				<td>查看</td>
			</tr>
			<tr>
				<td>活动2</td>
				<td>类型2</td>
				<td>异常</td>
				<td>查看</td>
			</tr> -->
			
		</tbody>
	</table>
	
	<ul class="pagination pagination-sm " style="margin-top: -10px; margin-left: 15px;" id="pageul"></ul>
	<div class="fixed-bottom-box" style="background-color: rgb(255, 255, 255)">
		<div id="pagination"></div> 
	<input id="pageCount" value="20">
	</div>
	
	<input type="hidden" id="basePath" value="<%=basePath%>">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.myPagination6.0.js"></script>
	<script src="js/public.js"></script>
	<script src="js/console/article/article_list.js?data=<%=new Date().getTime()%>"></script>
    
</body>
</html>
