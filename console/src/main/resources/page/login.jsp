<%-- <%@page import="com.frameWork.utils.CacheUtil"%>
<%@page import="com.crm.basic.util.CommonUtils"%> --%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//String requestIP=CommonUtils.getIpAddr(request);
//String firmIp1=CacheUtil.FIRM_IP_ADD;
//String firmIp2=CacheUtil.FIRM_IP_ADD2;
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand"><!--强制360浏览器使用webkit解析-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <title>中公远通内容管理系统</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/quick-layout-min.css">
    <link rel="stylesheet" href="css/main.css">
    <style type="text/css">
        #main{
            position: absolute;
            width:30%;
            left:50%;
            top:50%;
            -webkit-transform: translate(-50%,-65%);
            -moz-transform: translate(-50%,-65%);
            transform: translate(-50%,-65%);
        }
        @media screen and (max-width: 767px) {
		    #main{
		      	width:90%;
		        -webkit-transform: translate(-50%,-50%);
            	-moz-transform: translate(-50%,-50%);
            	transform: translate(-50%,-50%);
		    }
		}
	    @media screen and (max-width: 480px) {
		    #main{
		       width:95%;
		        -webkit-transform: translate(-50%,-50%);
            	-moz-transform: translate(-50%,-50%);
            	transform: translate(-50%,-50%);
		    }
		}

    </style>
</head>
<body class="bg-silver">
    <div class="top-content">
        <h2 class="p0 m0 white l ml20 logo_color" style="line-height: 70px;font-size: 1.5em; font-weight: bold;">中公远通内容管理系统</h2>
    </div>
    <div id="main" class="panel panel-primary pct40 auto">
        <div class="panel-heading">
            <h3 class="panel-title">登录</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">用户名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="name" placeholder="请输入用户名">
                          <div id="nameMsg" class="alert alert-danger" style="margin: 0px; padding: 5px;display: none; "></div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="pwd" class="col-sm-3 control-label">密&emsp;码</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="pwd" placeholder="请输入密码">
                          <div id="pwdMsg" class="alert alert-danger" style="margin: 0px; padding: 5px;display: none;"></div>
                    </div>
                </div>
                <div class="form-group ">
                    <label for="cpwd" class="col-sm-3 control-label">验证码</label>
                    <div class="col-sm-5">
                        <input  type="text" class="form-control" id="cpwd" placeholder="验证码"  
                        	onkeyup="this.value=this.value.replace(/(^-)|\D/g,'$1')" >
                        <div id="vMsg" class="alert alert-danger" style="margin: 0px; padding: 5px; display: none;"></div>
                    </div>
                    <div class="col-sm-4 tc">
    <img id="checkImg" style="width:100%;height:30px; display: none;" title="太难了，换个简单的..." 
	src="<%=basePath%>tool/VerificationCode.jsp" class="tt1 VerificationCode"
	onClick="document.getElementById('checkImg').src='<%=basePath%>tool/VerificationCode.jsp?time='+ (new Date().getTime().toString()); return false" >
					 <button id="send_vc" style="display: none;" type="button" class="btn btn-default pct100">发送验证码</button>
                    </div>
                </div>
                 <div id="vcMsg" class="alert alert-danger" style="margin: 0px; padding: 5px;display:none;"></div>
                 
                <div class="form-group pl15 pr15 pt10">
                    <button id="login-btn" type="button" class="btn btn-success pct100" data-loading-text="Loading...">登&emsp;录</button>
                </div>
            </form>
        </div>
    </div>
    <input id="basepath" value="<%=basePath%>"  type="hidden"/>
    <%-- <input id="isFirm" value="${isFirm}"  type="hidden"/>
    <input id="firmIp1" value="<%=firmIp1%>"  type="hidden"/>
    <input id="firmIp2" value="<%=firmIp2%>"  type="hidden"/>
    <input id="requestIP" value="<%=requestIP%>" type="hidden"> --%>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/md5.js"></script>
<script src="js/console/login/login.js"></script>
</html>