<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title></title>
</head>
<body>
<frameset cols="187,*" frameborder="no" border="0" framespacing="0"
	name="Frame">
	<frame src="toConsolePage_left" scrolling="auto" noresize="noresize"
		id="leftFrame" name="leftFrame">
	<frame src="toConsolePage_home" name="rightFrame" id="rightFrame">
</frameset>
</body>
</html>
