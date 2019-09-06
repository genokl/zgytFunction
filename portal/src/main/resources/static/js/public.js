var roleId,//角色ID 
resourceId, //角色资源ID
loginUserId;	//当前登陆者ID 
var paginationInfo = ""; //分页
var usersList = ""; //用户列表
var myLabelList = ""; //我的标签列表

/**
 * 生成跳转页面Url
 */
function genJumpInfoUrl(type_id,dataUrl){
	var url="/jump/p?name=product/productInfo&dataUrl="+dataUrl+"&type_id="+type_id;
	return url;
}
function genJumpListUrl(type_id,listUrl){///jump/p?name=product/productList&type_id=5&listUrl=/product/datalist
	var url="/jump/p?name=product/productList&type_id="+type_id+"&listUrl="+listUrl;
	return url;
}
function currentProductTypeName(){
	return $("#titlelist li.current a").html();
}

function setSynoBannerImg(type_id){
	var res=""
	if(type_id==1){//公司概况
		///zgytimg/upload/20190810/1565439558404.jpg
		res= "/zgytimg/banner/company_situation.jpg";
	}else if(type_id==4){//公司产品
		res= "/zgytimg/banner/productbanner.jpg";
	}else if(type_id==5){//科研技术
		res= "/zgytimg/banner/techbanner.jpg";
	}else if(type_id==6){//人力资源
		res= "/zgytimg/banner/hr_banner.jpg";
	}else if(type_id==3){//新闻中心
		res= "/zgytimg/banner/newsbanner.jpg";
	}else if(type_id==2){//联系我们
		res= "/zgytimg/banner/contactus.jpg";
	}
	return res;
}


/**
 * 弹出层
 */
function myDialog(){
	var tipModal = "<div id='tipModal' class='modal fade bs-example-modal-sm' tabindex='-1' role='dialog' aria-labelledby='mySmallModalLabel'>"
			+ "		<div class='modal-dialog modal-sm'>"
			+ "			<div class='modal-content'>"
	        + "				<div class='modal-body'></div>"
	        + "			</div>"
	        + "		</div>"
	        + "</div>";
	var loadModal = "<div id='loadModal' class='modal fade bs-example-modal-sm' tabindex='-1' role='dialog' aria-labelledby='mySmallModalLabel'>"
		+ "		<div class='modal-dialog modal-sm'>"
		+ "			<div class='modal-content'>"
		+ "				<div class='modal-body'></div>"
		+ "			</div>"
		+ "		</div>"
		+ "</div>";
	var msgModal = "<div class='modal fade' id='msgModal' tabindex='-1' role='dialog'  aria-hidden='true'>"
				 + "	<div class='modal-dialog'>"
				 + "		<div class='modal-content'>"
				 + "			<div class='modal-header'>"
				 + "				<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>"
				 + "				<h4 class='modal-title'>提示框</h4>"
				 + " 			</div>"
			     + "			<div class='modal-body'></div>"
			     + "			<div class='modal-footer'>"
			     + "			   <button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>"
			     + "   			   <button type='button' class='btn btn-primary'>提交</button>"
			     + "			</div>"
			     + "		</div>"
			     + "	</div>"
			     + "</div>";
	$("body").append(msgModal);
	$("body").append(tipModal);
	$("body").append(loadModal);
}
function getUrlArgObject(key){  
    var args=new Object();  
    var query=location.search.substring(1);//获取查询串  
    var pairs=query.split(",");//在逗号处断开  
    var parr=query.split("&");
    for(var i=0;i<parr.length;i++){  
    	var p=parr[i];
    	if(notNull(p)){
    		var pa=p.split("=");
    		if(pa[0]==key){
    			return pa[1]
    		}
    	}
//        var pos=pairs[i].indexOf('=');//查找name=value  
//        if(pos==-1){//如果没有找到就跳过  
//            continue;  
//        }  
//        var argname=pairs[i].substring(0,pos);//提取name  
//        var value=pairs[i].substring(pos+1);//提取value  
//        args[argname]=unescape(value);//存为属性  
    }  
//    return args;//返回对象  
}  

/**
 * 隐藏弹出层
 */
function closeDialog(){
	$("#tipModal").modal("hide");
}


/**
 * 验证是否为数字
 * @param str
 * @returns true:是数字，false:不是数字
 */
function isNumber(str){
	var reg = new RegExp("^[0-9]*$");
	return reg.test(str);
}

/**
 * 验证字符串是否为空
 * @param s
 * @returns {Boolean}
 */
function notNull(s){
	if(s===""||s===null||s==="null"||s===undefined){
		return false;
	}
	if(s.toString().replace(/^\s+/, "" ).replace(/\s+$/, "" ).length===0){
		return false;
	}
	return true;
}
/**
 * 根据键 获取cookie 值
 * @param key
 * @returns
 */
function getCookieValue(key){
	var arrStr = document.cookie;
	var _theArray = arrStr.split(";");	//得到Cookie组
	for(var i = 0;i < _theArray.length;i ++){
		var temp = _theArray[i].split("=");		
		if(temp[0].replace(/[ ]/g,"") == key) {
			return unescape(temp[1].replace(/"/g,""));
		};	
	}
}
/**
 * 拓展Array 添加删除指定下标方法
 * @param dx 需要删除的下标
 * @returns 返回对象本身
 */
Array.prototype.remove=function(dx){
    if(!notNull(dx)||dx>this.length){
    	return this;
    }
    for(var i=0,n=0;i<this.length;i++){
        if(this[i]!=this[dx]){
            this[n++]=this[i];
        }
    }
    this.length--;
    return this;
} ;
/**
 * 截取字符串最后一个 逗号
 * @param str
 * @returns {String}
 */
function subStr(str){
	return str.substring(0, str.length-1);
}
/**
 * 根据性别下标  获取性别
 * @param i 0 女  1男  其他不详
 * @returns {String}  返回处理后的性别
 */
function getSex(i){
	i=parseInt(i);
	if(i===0){
		return '女';
	}else if(i===1){
		return '男';
	}else{
		return '不详';
	}
}
/**
 * 格式化字符串
 * @param str -123*张三,-123*张李四,-123*王老五,
 * @return {"ids":"123,123,123","names":"张三,赵四,王五"}
 */
function formatStr1(str){
	if(!notNull(str)){
		return;
	}
	var strArr = str.split(","),ids = "",names = "",urlStr="";
	for (var int = 0; int < strArr.length; int++) {
		if(notNull(strArr[int])){
			var itemsArr = strArr[int].split("*");
			ids += itemsArr[0].replace("-","")+",";
			names += itemsArr[1]+",";
			urlStr += "<a href='client_toClientInfo?clientId="+itemsArr[0]+"'>"+itemsArr[1]+"</a>,";
		}
	}
	ids = ids.substring(0,ids.length-1);
	names = names.substring(0,names.length-1);
	urlStr = urlStr.substring(0,urlStr.length-1);
	return {"ids":ids,"names":names,"urlStr":urlStr};
};
/**
 * 模版工具
 * @param temp 模版(jquery选择器)
 * @param json json
 * @param dest 展示位置(jquery选择器)
 * @return templateStr
 */
function handleUtil(temp,json,dest){
	var tempStr = Handlebars.compile($(temp).html())(json);
	$(dest).html(tempStr);
	return tempStr;
}

/**
 * 用户相关功能对象
 */
var userAct = {};
/**
 * 跳转发送消息页面
 * ids: 客户资料id
 */
userAct.toMsg = function(ids){
	if(notNull(ids)){
		//申请发送消息
		var url = $("#basePath").val()+"msg_toMsg?cids="+ids;
		location.href = url;
	}else{
  		$("#tipModal").find(".modal-body").html("请选择至少一个客户!");
  		$("#tipModal").modal("show");
	}
};
/**
 * 我的收藏
 */
userAct.collect = function(ids){
	if(notNull(ids)){
		var url = $("#basePath").val()+"collect_addCollect";
		$.post(url,{"clientIds":ids},function(data){
			if(data.statusCode == "1"){
		  		$("#tipModal").find(".modal-body").html("收藏成功！");
			}else{
		  		$("#tipModal").find(".modal-body").html("收藏失败！Error:"+data.statusCode);
			}
			$("#tipModal").modal("show");
		});
	}else{
  		$("#tipModal").find(".modal-body").html("请选择至少一个客户!");
  		$("#tipModal").modal("show");
	}
};


/**
 * 获取当前日期
 * @param t 1中间带横杠  	1991-08-03
 * 			 2中间不带横杠	19910803
 * @returns {Date}
 */
function getPresentDate(t){
	var date=new Date();
	var month=date.getMonth()+1;
	var day=date.getDate();
	if (day<10) {
		day="0"+day;
	}
	if (month<10) {
		month="0"+month;
	}
	
	if (1==t) {//日期中间带横杠"-"
		date=date.getFullYear()+"-"+month+"-"+day;
	}else{//日期中间不带横杠"-"
		date=date.getFullYear()+""+month+""+day;
	}
	return date;
}

function pageActive(){
}

function dealImg(t){
	var imgs=t.split(",");
	var t="";
	var h=self.location.host;
	for ( var i = 0; i < imgs.length-1; i++) {
//		t+=h+"/zgyt/"+imgs[i]+","
		if (imgs[i].indexOf(h)==-1) { //新上传的图片
//			t+=h+"/zgyt/"+imgs[i]+",";
			t+=h+"/"+imgs[i]+",";
		}else {						  //之前上传的图片
			t+=imgs[i]+",";
		}
	}
	return t;
};