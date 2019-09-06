/**
\ * 登录页面JS
 */
//var isFirm = ($("#isFirm").val() == "true");

$(function() {
	getVerify()
	   var aa=new Array();
	   for(var i=0;i<20;i++){
		   aa[i]=new Array(); 
		   for(var j=0;j<2;j++){
			   aa[i][j]=1;
		   }
	   }
	
	
	var f1 = $("#firmIp1").val();
	var f2 = $("#firmIp2").val();
	var r = $("#requestIP").val();
	if (r == f1 || r == f2) {
		isFirm = true;
	}
	// 验证该用户是否已经登录
	$.post("/login/testLogin", function(data) {
		if (parseInt(data) == 1) {
			checkBrowser()
			/*
			// 检测平台
			var p = navigator.platform;
			alert(p)
			p.win = p.indexOf("Win") == 0;
			p.mac = p.indexOf("Mac") == 0;
			p.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
			// 跳转语句
			if (p.win || p.mac || p.xll) {// 转向后台登陆页面
				// alert("PC")
			} else {
				// alert("phone")
			}
		*/
			}
	},"json");

	// 初始化显示隐藏激活码
	if (isFirm) {
		// 内网
		$("#checkImg").show();
	} else {
		// 外网
		$("#send_vc").show();
	}
	// 用户名
	$("#name").blur(function() {
		var val = $.trim($(this).val());
		if (val != "") {
			$(this).next().hide();
			$(this).parent().parent().removeClass("has-error");
			$(this).parent().parent().addClass("has-success");
		} else {
			$(this).val("");
			$(this).next().hide();
			$(this).parent().parent().removeClass("has-success");
			$(this).parent().parent().addClass("has-error");
		}
	});
	$("#name").focus(function() {
		$(this).next().hide();
	});
	// 密码
	$("#pwd").blur(function() {
		var val = $.trim($(this).val());
		if (val != "") {
			$(this).next().hide();
			$(this).parent().parent().removeClass("has-error");
			$(this).parent().parent().addClass("has-success");
		} else {
			$(this).val("");
			$(this).next().hide();
			$(this).parent().parent().removeClass("has-success");
			$(this).parent().parent().addClass("has-error");
		}
	});
	$("#pwd").focus(function() {
		$(this).next().hide();
	});
	/**
	 * 普通验证码 失去焦点方法
	 */
	$("#cpwd").blur(function() {
		$("#vMsg").hide().html("");
		var $cpwd = $("#cpwd");
		if (isFirm) {
			$.get("tool/getNum.jsp", function(data) {
				if ($cpwd.val() == parseInt(data)) {
					$cpwd.attr("data-value", "true");
					$cpwd.parent().parent().removeClass("has-error");
					$cpwd.parent().parent().addClass("has-success");
				} else {
					$cpwd.attr("data-value", "false");
					$cpwd.parent().parent().removeClass("has-success");
					$cpwd.parent().parent().addClass("has-error");
				}
			});
		} else {
			if ($.trim($cpwd.val()).length == 4) {
				$cpwd.parent().parent().removeClass("has-error");
				$cpwd.parent().parent().addClass("has-success");
			} else {
				$cpwd.parent().parent().removeClass("has-success");
				$cpwd.parent().parent().addClass("has-error");
			}
		}
	});
	$("#cpwd").focus(function() {
		$("#vcMsg").hide();
	});
	/**
	 * 发送手机验证码方法
	 */
//	$("#send_vc").click(function() {
//		var $name = $("#name");
//		var $pwd = $("#pwd");
//		var $send_vc = $("#send_vc");
//		// 检查用户名合法性
//		if ($.trim($name.val()).length != 0) {
//			// 检查密码合法性
//			if ($.trim($pwd.val()).length != 0) {
//				sendPhoneNum($send_vc, $name, $pwd);
//			} else {
//				$name.parent().parent().removeClass("has-success");
//				$name.parent().parent().addClass("has-error");
//				$name.val("");
//				$name.attr("placeholder", "请输入密码");
//			}
//		} else {
//			$name.parent().parent().removeClass("has-success");
//			$name.parent().parent().addClass("has-error");
//			$name.val("");
//			$name.attr("placeholder", "请输入用户名");
//		}
//	});

	/**
	 * 登录按钮
	 */
//	$("#login-btn").click(function() {
//						$("#login-btn").button('loading');
//						var $name = $("#name");
//						var $pwd = $("#pwd");
//						var $cpwd = $("#cpwd");
//						var vnFlag = true;
//						if ($.trim($name.val()) != "") {
//							if ($.trim($pwd.val()) != "") {
//								if (isFirm) {
//									if ($cpwd.attr("data-value") == "true") {
//										$("#checkImg").attr("src",
//														"/login/verifyCode?time="+ (new Date().getTime().toString()));
//										var br = navigator.userAgent.toLowerCase();
//										// 拼接所有数据对象
//										var o = getLoginInfo(br, $name.val(), $.md5($.trim($pwd.val())), $("#cpwd").val());
//										// 提交请求
//										action($name, $pwd, o);
//									} else {
//										$("#login-btn").button('reset');
//										$cpwd.parent().parent().removeClass(
//												"has-success");
//										$cpwd.parent().parent().addClass(
//												"has-error");
//									}
//								} else {
//									if ($.trim($cpwd.val()).length == 4) {
//										var br = navigator.userAgent
//												.toLowerCase();
//										var o = getLoginInfo(br, $name.val(), $
//												.md5($.trim($pwd.val())), $(
//												"#cpwd").val());
//										action($name, $pwd, o);
//									} else {
//										$("#login-btn").button('reset');
//										$cpwd.parent().parent().removeClass(
//												"has-success");
//										$cpwd.parent().parent().addClass(
//												"has-error");
//									}
//								}
//							} else {
//								$("#login-btn").button('reset');
//								$pwd.parent().parent().removeClass("has-success");
//								$pwd.parent().parent().addClass("has-error");
//								$pwd.val("");
//								$pwd.attr("placeholder", "请输入密码");
//							}
//						} else {
//							$("#login-btn").button('reset');
//							$name.parent().parent().removeClass("has-success");
//							$name.parent().parent().addClass("has-error");
//							$name.val("");
//							$name.attr("placeholder", "请输入用户名");
//						}
//					});
});

/**
 * 提交登录请求
 * 
 * @param $name
 *            登录名
 * @param $pwd
 *            密码
 * @param securityCode
 *            验证码
 */
function action($name, $pwd, o) {
	$.post("/login/userLogin", o, function(data) {
		data = parseInt(data);
		switch (data) {
		case -10:
			$("#login-btn").button('reset');
			alert("ip获取错误");
			break;
		case -9:
			$("#login-btn").button('reset');
			$name.val("");
			$name.focus();
			$name.next().show().html("用户不存在！");
			break;
		case -8:
			$("#login-btn").button('reset');
			$pwd.val("");
			$pwd.focus();
			$pwd.next().show().html("密码错误！");
			break;
		case -7:
			$("#login-btn").button('reset');
			$name.val("");
			$pwd.val("");
			$("#cpwd").val("");
			$name.focus();
			$name.next().show().html("该用户被禁用20分钟！");
			break;
		case -6:
			$("#login-btn").button('reset');
			$name.val("");
			$pwd.val("");
			$("#cpwd").val("");
			$name.focus();
			$name.next().show().html("该用户已被管理员封停！");
			break;
		case -12:
			$("#login-btn").button('reset');
			var $v = $("#vMsg");
			$v.show().html("验证码错误！");
			break;
		case -13:
			$("#login-btn").button('reset');
			var $v = $("#vMsg");
			$v.show().html("验证码过期！");
			break;
		case -14:
			$("#login-btn").button('reset');
			var $v = $("#vMsg");
			$v.show().html("验证码错误！");
			break;
		case 1:
			var system = {
				win : false,
				mac : false,
				xll : false
			};
			// 检测平台
			var p = navigator.platform;
			system.win = p.indexOf("Win") == 0;
			system.mac = p.indexOf("Mac") == 0;
			system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
			// 跳转语句
			if (system.win || system.mac || system.xll) {// 转向后台登陆页面
				window.location.href = $("#basepath").val() + "page/console/index.jsp";
				;
				// alert("PC")
			} else {
				// alert("phone")
				window.location.href = $("#basepath").val()
						+ "mobile/customer/search.jsp";
				;
			}
			break;
		default:
			alert(data);
			break;
		}
	});

}
/**
 * 开启发送短信的定时器
 * 
 * @param $send_vc
 */
function startTime($send_vc) {
	var num = 60;
	var time = setInterval(function() {
		$send_vc.html("已发送(" + num-- + ")");
		if (num <= 0) {
			// 关闭定时器
			clearInterval(time);
			// 重启发送按钮
			$send_vc.removeClass("disabled");
			$send_vc.html("发送验证码");
		}
	}, 1000);
}
/**
 * 发送手机验证码
 * 
 * @param $name
 * @param $pwd
 */
function sendPhoneNum($send_vc, $name, $pwd) {
	$send_vc.addClass("disabled");
	$.post($("#basepath").val() + "login_sendVerificationCode", {
		"user.name" : $.trim($("#name").val()),
		"user.password" : $.md5($.trim($pwd.val()))
	}, function(data) {
		data = parseInt(data);
		switch (data) {
		case 1:
			startTime($send_vc);
			break;
		case -10:
			$name.val("");
			$name.focus();
			$name.next().show().html("用户名错误！");
			$send_vc.removeClass("disabled");
			$send_vc.html("发送验证码");
			break;
		case -9:
			$name.val("");
			$name.focus();
			$name.next().show().html("用户不存在！");
			$send_vc.removeClass("disabled");
			$send_vc.html("发送验证码");
			break;
		case -8:
			$pwd.val("");
			$pwd.focus();
			$pwd.next().show().html("密码错误！");
			$send_vc.removeClass("disabled");
			$send_vc.html("发送验证码");
			break;
		case 14:// 一个小时内只能发送三条
			$("#vcMsg").show().html("每小时最多发送三条验证消息!");
			$send_vc.removeClass("disabled");
			$send_vc.html("发送验证码");
			break;
		case 15:// 一分钟内只能发送一条
			$("#vcMsg").show().html("一分钟内只能发送一条短信！");
			$send_vc.removeClass("disabled");
			$send_vc.html("发送验证码");
			break;
		case 20:// 一天最大的发送次数 20次
			$("#vcMsg").show().html("一天最多只能发送 20次短信！");
			$send_vc.removeClass("disabled");
			$send_vc.html("发送验证码");
			break;
		default:
			alert("后台异常请联系管理员!状态码为【" + data + "】");
			break;
		}
	}, "text");
}
/**
 * 拆分登录信息对象
 * 
 * @param info
 *            登录信息
 * @returns 返回拆分后的对象
 */
function getLoginInfo(info, name, pwd, securityCode) {
	// alert("info=="+info)
	// 获取当前操作系统
	var os = getOs(window.navigator.appVersion);
	// 获取系统版本
	var osvr = getOsVersion(os, info);
	// 获取当前运行设备 日过是windows 系统则是pc 其他获取手机设备名称
	var device = getDevice(os, info);
	// 获取浏览器型号
	var br = getBrowser(info);
	// 浏览器版本
	var brvr = (info.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [ 0, '0' ])[1];
	// 封装数据
	return {
		"securityCode" : securityCode,
		"user.name" : $.trim(name),
		"user.password" : pwd
//		,
//		"info.loginOs" : os,
//		"info.loginOsVersion" : osvr,
//		"info.loginSource" : device,
//		"info.loginBrowser" : br,
//		"info.loginBrowserCore" : brvr,
//		"info.loginOther" : info,
//		"info.loginStatus" : 0
	};

}
/**
 * 获取浏览器型号
 */
function getBrowser(browserName) {
	// trident 是ie 11 特有标示
	if ((/trident/i.test(browserName) && /rv:11.0/.test(browserName))
			|| (/msie/i.test(browserName) && !/opera/.test(browserName))) {
		return "ie";
	} else if (/firefox/i.test(browserName)) {
		return "firefox";
	} else if (/chrome/i.test(browserName) && /webkit/i.test(browserName)
			&& /mozilla/i.test(browserName)) {
		return "chrome";
	} else if (/opera/i.test(browserName)) {
		return "opera";
	} else if (/webkit/i.test(browserName)
			&& !(/chrome/i.test(browserName) && /webkit/i.test(browserName) && /mozilla/i
					.test(browserName))) {
		return "safari";
	} else {
		return "unKnow";
	}
}
/**
 * 获取当前操作系统
 * 
 * @param str
 *            appVersion 信息
 * @returns {String} 系统名称
 */
function getOs(str) {
	str = str.toLowerCase();
	if (/windows/i.test(str)) {
		return "windows";
	} else if (/iphone/i.test(str)) {
		return "iphone";
	} else if (/android/i.test(str)) {
		return "android";
	} else {
		return "unKnow";
	}
}
/**
 * 获取当前系统的版本号
 * 
 * @param 返回系统版本号
 */
function getOsVersion(os, app) {
	if (os == "windows") {
		var s = app.split(";")[0];
		s = s.substring(s.lastIndexOf("nt"));
		return s;
	} else if (os == "iphone") {
		var s = app.split(";")[1];
		s = s.substring(s.indexOf("os"), s.indexOf("like"));
		return s;
	} else if (os == "android") {
		var s = app.split(";")[1];
		return s;
	} else {
		return "unKnow";
	}
}
/**
 * 获取当前设备信息
 * 
 * @returns {String}
 */
function getDevice(os, info) {
	if (os == "windows") {
		return "pc";
	} else if (os == "iphone") {
		return "iphone";
	} else if (os == "android") {
		if (info.indexOf("samsung") >= 0) {
			return "samsung";
		} else if (info.indexOf("mi") >= 0) {
			return "mi";
		} else if (info.indexOf("honor") >= 0) {
			return "huawei";
		} else {
			return "unKnow";
		}
	} else {
		return "unKnow";
	}
}
function checkBrowser() {
	var browser = {
		versions : function() {
			var u = navigator.userAgent, app = navigator.appVersion;
			return {
				// 移动终端浏览器版本信息
				trident : u.indexOf('Trident') > -1, // IE内核
				presto : u.indexOf('Presto') > -1, // opera内核
				webKit : u.indexOf('AppleWebKit') > -1, // 苹果、谷歌内核
				gecko : u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, // 火狐内核
				mobile : !!u.match(/AppleWebKit.*Mobile.*/)
						|| !!u.match(/AppleWebKit/), // 是否为移动终端
				ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), // ios终端
				android : u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, // android终端或者uc浏览器
				iPhone : u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, // 是否为iPhone或者QQHD浏览器
				iPad : u.indexOf('iPad') > -1, // 是否iPad
				webApp : u.indexOf('Safari') == -1
				// 是否web应该程序，没有头部与底部
			};
		}(),
		language : (navigator.browserLanguage || navigator.language)
				.toLowerCase()
	}
	if (!(browser.versions.android || browser.versions.iPhone || browser.versions.iPad)) {
		//alert("PC浏览页面");
		window.location.href = $("#basepath").val() + "page/index.jsp";
	}
}

function getVerify(){
	$.get("/login/verifyCode", function(d) {
//		console.log(321321)
//		console.log(d)
//		console.log($('#checkImg').attr("src"))
		$('#checkImg').attr("src",d.vc)
	},"json")
//	$('#checkImg').src = '/login/verifyCode?ts=' + new Date().getTime();  
}