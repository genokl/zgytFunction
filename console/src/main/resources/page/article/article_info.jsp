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
<title >修改文章</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/quick-layout-min.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" type="text/css" href="js/uploadifive/uploadifive.css">
<!-- <link rel="stylesheet" type="text/css" href="js/uploadifive/uploadifive.css">
 --><style>
body {
	margin: 0px;
	padding: 20px;
	font-family: "lucida Grande",Verdana,"Microsoft YaHei";
    font-size: 12px;
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
<body>
	<input type="hidden" id="basePath" value="<%=basePath%>">
	
	<h1 id="pageTitle"></h1>
	<!-- 图片上传 -->
	<form>
		<div id="queue" style="display: none;"></div>
		<input id="file_upload" name="file_upload" type="file" multiple="true">
		<!-- <a style="position: relative; top: 8px;" href="javascript:$('#file_upload').uploadifive('upload')">Upload Files</a> -->
		<div style="" id="image"></div>
	</form>
	
	
	<input type="hidden" id="imgUrls">
			
	<form id="f1">
		<div id="ad0">
			<input type="hidden" id="id" name="article.id">
			<input type="hidden" id="isShow" name="article.isShow">
			<input type="hidden" id="articleHtmlAddress" name="article.articleHtmlAddress">
			<input type="hidden" id="articleType" name="article.articleType">
			<input type="hidden" id="createDate" name="article.createDate">
			<input type="hidden" id="isDel" name="article.isDel">
			<input type="hidden" id="isShow" name="article.isShow">
			<input type="hidden" id="articleHtmlAddress" name="article.articleHtmlAddress">
		</div>
		<br><br><br><br>
		<div id="ad1">
		  <span style="width:85px;display:inline-block" data-value="false">文章题目：</span>
		  <textarea rows="" cols="" name="article.articleTitle" id="articleTitle" data-value="false"></textarea>
		  <div id="articleTitleMsg" class="alert " style="display:inline-block;width:20%;margin: 0px;color: #f00;padding: 0px;vertical-align: top;"></div>
		</div>
		<br>
		<div id="ad2">
		  <span style="width:85px;display:inline-block" data-value="false">文章概述：</span>
		  <textarea rows="" cols="" name="article.articleSynopsis" id="articleSynopsis" data-value="false"></textarea>
		  <div id="articleSynopsisMsg" class="alert " style="display:inline-block;width:20%;margin: 0px;color: #f00;padding: 0px;vertical-align: top;"></div>
		</div>
		<br>
		 <div id="ad3">
		 	<span style="width:85px;display:inline-block">文章类型：</span>
		 	<input disabled="disabled">
		 </div> 
		<br><br>
		<div id="ad4">文章创建时间：
			<input id="articleCreateTime" disabled="disabled">
		</div>
		<br>
		<div id="ad5">
		  <span style="width:85px;display:inline-block" data-value="false">关键词：</span>
		  <textarea rows="" cols="" name="article.keyWords" id="keyWords" data-value="false"></textarea>
		  <div id="keyWordsMsg" class="alert " style="display:inline-block;width:20%;margin: 0px;color: #f00;padding: 0px;vertical-align: top;"></div>
		</div>	
		<br><br><br><br><br>
	</form>
	
	
	
	<script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
	
	<!-- <input type="button" value="创建内容" id="createArticle" style="display: dispaly;"> -->
	<div class="fixed-bottom-box">
		<button type="button" id="save" class="btn btn-primary pl20 pr20">修改内容</button>
	</div>
	<input type="hidden"  id="onUpload" onclick="$('#file_upload').uploadifive('upload')">
	
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/public.js?d=1"></script>
	<script type="text/javascript" src="js/uploadifive/jquery.uploadifive.min.js"></script>
	<script src="js/console/article/article_info.js?data=<%=new Date().getTime()%>"></script>
	
 	<script type="text/javascript" charset="utf-8" src="js/baiduUE/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/baiduUE/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="js/baiduUE/lang/zh-cn/zh-cn.js"></script> 
    
	<!-- <script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.all.js"> </script>
    <script type="text/javascript" charset="utf-8" src="js/ueditor/lang/zh-cn/zh-cn.js"></script> -->
    
</body>
</html>
