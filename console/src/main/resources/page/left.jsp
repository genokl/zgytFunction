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
    <style>
        .home_link{
            padding: 1px;
            background-color: #FFF;
            border-bottom: 1px solid rgb(188, 194, 199);
        }
        .home_link a{
            display: block;
            text-decoration: none;
            color: #333;
            padding: 10px 10px 10px 30px;
            font-size: 14px;
            /*background-color: #b63b4d;*/
        }
    </style>
</head>
<body class="sidebar_bg" style="border-right: 1px solid rgb(188, 194, 199);">
    <!--<a target="rightFrame" href="http://www.baidu.com">百度</a>-->
    <!-- Contenedor -->
    <div class="home_link">
        <a href="home_page" class="b"><span class="glyphicon glyphicon-home mr10 "></span>首页</a>
    </div>
    <ul id="accordion" class="accordion">
        <li class="role" data-role='10'>
            <div class="link"><i class="fa fa-paint-brush"></i><span class="glyphicon glyphicon-th-large mr10 "></span>内容管理<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li class="role" data-role='10'><a href="page/console/article/article_add.jsp"><span class="glyphicon glyphicon-search mr10 "></span>新建内容</a></li>
                <li class="role" data-role='10'><a href="page/console/article/article_list.jsp"><span class="glyphicon glyphicon-plus mr10 "></span>新闻列表</a></li>
                <li class="role" data-role='10'><a href="article_toArticleDetailPage?articleId=5"><span class="glyphicon glyphicon-plus mr10 "></span>公司概况</a></li>
                <li class="role" data-role='10'><a href="article_toArticleDetailPage?articleId=6"><span class="glyphicon glyphicon-plus mr10 "></span>联系我们</a></li>
                <li class="role" data-role='10'><a href="article_toArticleDetailPage?articleId=7"><span class="glyphicon glyphicon-plus mr10 "></span>人力资源</a></li>
                <!-- <li class="role" data-role='2'><a href="page/customer/customer_repeat_mgt.jsp"><span class="glyphicon glyphicon-erase mr10 "></span>客户资料排重</a></li>
                <li class="role" data-role='2'><a href="page/customer/customer_del.jsp"><span class="glyphicon glyphicon-trash mr10 "></span>已删除客户资料</a></li>
                <li class="role" data-role='2'><a href="page/customer/customer_alot_mgt.jsp"><span class="glyphicon glyphicon-check mr10 "></span>客户资料分配管理</a></li>
                <li class="role" data-role='2'><a href="page/customer/customer_field_set.jsp"><span class="glyphicon glyphicon-eye-close mr10 "></span>客户隐私设置</a></li>
                <li class="role" data-role='10'><a href="page/customer/customer_excel.jsp"><span class="glyphicon glyphicon-open mr10 "></span>导入客户资料</a></li> -->
            </ul>
        </li>
        <li class="role" data-role='2'>
            <div class="link"><i class="fa fa-mobile"></i><span class="glyphicon glyphicon-user mr10 "></span>用户管理<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="page/user/user_mgt.jsp"><span class="glyphicon glyphicon-tasks mr10 "></span>用户信息管理</a></li>
                <li><a href="page/user/role_mgt.jsp"><span class="glyphicon glyphicon-queen mr10 "></span>角色管理</a></li>
                <li><a href="page/user/permission_mgt.jsp"><span class="glyphicon glyphicon-pawn mr10 "></span>权限管理</a></li>
            </ul>
        </li>
        <%--<li>
        	<div class="link"><i class="fa fa-globe"></i>数据分析中心<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="page/blank.jsp">数据分析中心</a></li>
                <li><a href="page/blank.jsp">所有数据分析图</a></li>
                <li><a href="page/blank.jsp">抓取其他项目中的数据</a></li>
            </ul>
        </li>--%>
        <%--  <li>
            <div class="link"><i class="fa fa-globe"></i><span class="glyphicon glyphicon-cog mr10 "></span>系统工具<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="page/user/user_update.jsp"><span class="glyphicon glyphicon-wrench mr10 "></span>个人中心</a></li>
                <li><a href="javascript:void(0)" id="apply"><span class="glyphicon glyphicon-random mr10 "></span>我的申请</a></li>
                <li id="mangApply" style="display: none;"><a href="page/user/manage_apply.jsp" ><span class="glyphicon glyphicon-random mr10 "></span>流程管理</a></li>
                <li><a href="page/user/user_collect.jsp"><span class="glyphicon glyphicon-heart mr10 "></span>我的收藏</a></li>
            </ul>
        </li>
         <li>
            <div class="link"><i class="fa fa-globe"></i><span class="glyphicon glyphicon-tree-deciduous mr10 "></span>会员关系系统<i class="fa fa-chevron-down"></i></div>
           <ul class="submenu">
                <li><a href="toPage_toActivityList"><span class="glyphicon glyphicon-heart mr10 "></span>活动列表</a></li>
                <!-- <li><a href="page/member/activity/createActivity.jsp"><span class="glyphicon glyphicon-wrench mr10 "></span>创建活动</a></li> -->
                <li><a href="toPage_toSyncData?data=<%=new Date().getTime()%>"><span class="glyphicon glyphicon-wrench mr10 "></span>会员数据同步</a></li>
                <li><a href="page/member/activityModel/activityModelList.jsp"><span class="glyphicon glyphicon-wrench mr10 "></span>活动管理</a></li>
            </ul> activityModelList.jsp 
        </li>--%>
    </ul>
</body>
<script src='js/jquery.min.js'></script>
<script src='js/public.js'></script>
<script>
    $(function() {
        $("a").attr("target","rightFrame");
        var Accordion = function(el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;

            // Variables privadas
            var links = this.el.find('.link');
            // Evento
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
        }

        Accordion.prototype.dropdown = function(e) {
            var $el = e.data.el;
            $this = $(this),
                    $next = $this.next();

            $next.slideToggle();
            $this.parent().toggleClass('open');

            /*收起其他开启的导航*/
          if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
            };
        }

        var accordion = new Accordion($('#accordion'), false);

        /*设置A标签的选中状态*/
        $(".submenu a").on("click",function(){
            $(".submenu a").removeClass("selected");
            $(this).addClass("selected");
        });
		
        //权限设置
        var cookie = getCookieValue("roleInfo");
        var role = cookie.split(":")[0];
        $(".role").each(function(){
        	var current = $(this);
        	var roleLevel = current.data("role");
        	//alert(roleLevel+",,"+role);
        	if(role <= roleLevel){
        		//具备管理员权限
        		
        		//显示流程管理页面
        		$("#mangApply").show();
        		current.show();
        	}else{
        		 $("#apply").attr("href","page/user/user_apply.jsp").html("<span class='glyphicon glyphicon-random mr10 '></span>我的申请");
        		 //判断该角色是否拥有  流程管理权限
        		 if(cookie.split(":")[1].indexOf("13")>0){
	        		 //显示流程管理页面
	        		 $("#mangApply").show();
        		 }
        		current.hide();
        	}
        });
    });
	
</script>
<script src="js/jquery-1.11.3.js"></script>
<script src="js/jquery.min.js"></script>
</html>
