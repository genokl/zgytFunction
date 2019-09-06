
/**
 * 文章添加页面js
 */
var custAct = {}; //当前页面对象
  
$(function(){
	var p=getUrlArgObject("type_id");
	$("#type_id").val(p);
	var c=prepareCondition(p)
	custAct.loadProductListData(c);
});

function prepareCondition(p){
	var p={};
	p["productType"]=$(".productType").val()
	p["page"]=$(".page").val()
	p["size"]=$(".size").val()
	return p;
}

/**
 * 加载页面初始化数据
 */
custAct.loadProductListData=function(condition){
	var url="/product/datalist";
//	if (notNull(condition)) {
//		url+="?"+condition;
//	}
	$.post(url,condition,function(data){
//		if (data.statusCode==1) {//请求成功
//			console.log(data)
			custAct.initData(data);
			custAct.paginationInfo(data,20);
//		}
	},"json");
};

/**
 * 初始化页面数据
 */
custAct.initData=function(data){
	var val="";
	var d=data["_embedded"]["products"];
	for ( var i = 0; i < d.length; i++) {
//		console.log(d[i])
		val+="<tr style='height:38px;'>";
		//预览图路径
		if (notNull(d[i].productSynopsisImg)) {
			val+="<td><img alt='' style='width:19px;' src='"+d[i].productSynopsisImg+"'></td>";
		}else {
			val+="<td></td>";
		}
		//文章标题
		if (notNull(d[i].title)) {
			val+="<td>"+d[i].title+"</td>";
		}else {
			val+="<td></td>";
		}
		//创建时间
		if (notNull(d[i].createDate)) {
			val+="<td>"+d[i].showDate+"</td>";
		}else {
			val+="<td></td>";
		}
		//文章类型
			var productType=d[i].productType_;
			val+="<td>"+productType.productTypeName+"</td>";
		//文章排序
		var productType=d[i].productType_;
		val+="<td>"+productType.productTypeName+"</td>";
		//文章展示状态   草稿/发表
		var isSale="";
		if (d[i].isSale==1) {
			isSale="草稿";
		}else {
			isSale="发表";
		}
		val+="<td><div class='toggle toggle--knob'><input type='checkbox' id='toggle--knob' class='toggle--checkbox isSale'>" +
				"<label class='toggle--btn' for='toggle--knob'><span class='toggle--feature' data-label-on='on'  data-label-off='off'></span></label>" +
				"</div></td>";
		
		//操作
		var dataUrl=d[i]["_links"]["_self"]["href"];
		val+="<td><input type='hidden' value="+d[i].id+" />";
//		val+="<button href='"+genJumpInfoUrl($("#type_id").val(),dataUrl)+"' >查看文章</button>" +
		val+="<button class='btn btn-primary editProductInfo' data-title='"+d[i].title+"' data-url='"+genJumpInfoUrl($("#type_id").val(),dataUrl)+"' data-pageurl='"+dataUrl+"' >" +
				"<i class='layui-icon'></i>编辑" +
			"</button>";
		val+="</td></tr>";
	}
	$("#articlesList").html(val);
}

$("#articlesList").on("click",".isSale",function(){
	console.log($(this).val())
})

$("#articlesList").on("click",".editProductInfo",function(){
	var url=$(this).attr("data-url")
	var pageurl=$(this).attr("data-pageurl")
	var title=$(this).attr("data-title")
//	console.log(url)
	window.open(url);
})

function openNowTab(title,url){
	console.log($(".layui-tab-title").find("li").length)
	tab.tabAdd(title,"jump/p?name=product/add&dataUrl="+url,index+1);
//    tab.tabChange(index+1);
}
//分页
custAct.paginationInfo=function(data,pageCount){
	//分页
	console.log(data)
	var page=data["page"]
	if(notNull(data._embedded.products.length)){
		paginationInfo = {
				pageCount:page.totalPages,//总页数
				pageNumber:page.totalPages,//每页显示数
				currPage:page.number+1
			  };
		console.log(paginationInfo)
        $("#pagination").myPagination({
            cssStyle:'flickr',//配置样式属性
            pageCount:page.totalPages,//配置总页数
            pageNumber:paginationInfo.pageNumber,//配置页码数量
            currPage:paginationInfo.currPage,//配置当前页
            first_on:true,//配置首页是否显示
            last_on:true,//配置尾页是否显示
            first:"首页",//配置首页显示值
            last:"尾页",//配置尾页显示值
            panel:{
                tipInfo_on:true,//配置提示信息
                tipInfo:'转{input}/{sumPage}页',//配置提示信息
                tipInfo_css:{//配置面板中国输入框样式
                    width:'25px',
                    height:'25px',
                    border:"1px solid #ff9600",
                    padding:"0px 0px 0px 5px",
                    margin:"0px 5px 0px 5px",
                    color:"#000",
                    "box-sizing":"border-box",
                    "-moz-box-sizing":"border-box"
                }
            },
         ajax:{
        	 on:false,
             onClick:function(page){
             	$(".page").val(page-1)
             	var p=prepareCondition(type_id);
             	var listUrl=getUrlArgObject("listUrl");
//             	loadListData(listUrl, p)
             	var c=prepareCondition(p)
            	custAct.loadProductListData(c);
//             
             }
            }
        });
	}
               
};

/**
 * 表单提交动作
 */
$("#createArticle").click(function(){
	
	//获取表单元素
	var o=custAct.getArticleData();
	//提交动作
	custAct.createArticle(o);
	
});

/**
 * 处理图片 添加域名
 * ps:192.168.1.43:8080/zgyt/upload/20160808/1470629115046.jpg
 */
custAct.dealImg=function(t){
	h=self.location.host;
	return h+"/zgyt/"+t;
}

/**
 * 处理图片 添加域名
 * ps:192.168.1.43:8080/zgyt/upload/20160808/1470629115046.jpg
 */
custAct.createArticle=function(o){
	//提交数据
	$.post("article_createArticle",o,function(data){
		if (data.statusCode==1) {
			alert("创建文章成功！");
		}
	},"json");
}

/**
 * 获取表单元素
 */
custAct.getArticleData=function(){
	//获取表单元素
	param1 = $("#f1").serializeArray();
	var o = {};
	for(var i =0;i<param1.length;i++){
		o[param1[i].name]=param1[i].value;
	}
	// 获取富文本编辑器中的内容
	o["article.articleDetail"] = UE.getEditor('editor').getContent();
//	var $t =$("<div>"+articleDetail+"</div>");
//	o["article.articleDetail"]=$t;
	//文章类型
	o["article.articleType"]=$("#f1").find("select[name='article.articleType']").find("option:selected").val();
	//处理图片
	o["article.articleSynopsisImg"]=custAct.dealImg($("#imgUrls").val());
	
	return o;
}


//$("#conditionQuery").click(function(){
//	alert()
//	style="rgb(53, 87, 138) none repeat scroll 0% 0%;";
//	$(this).attr("style",style);
//})

/**
 * 点击筛选查询按钮时，获取该按钮的属性，回显到conditionList中
 */
function addSelectCondition(t){
	var $t=$(t);
	$(t).prop("disabled",true);
	var tag="<a href='javascript:void(0);' class='condition' id='"+$(t).attr("data-type")+"' onclick='removeSelectCondition(this)'>" +$t.val()+"&nbsp&nbspX</a>";
	$("#conditionList").append(tag);//添加筛选条件
	
	//发送带条件的分页查询请求
	custAct.querySelectCondition();
}

/**
 * 点击查询条件标签时，获取该按钮的属性，在查询列表的条件中去除该条件
 */
/*function removeSelectCondition(t){
	var $t=$(t);
	$("#selectButtonList").find("input[type=button]").each(function(){
		if ($(this).attr("data-type")==$t.attr("id")) {
			$(this).prop("disabled",false);
			$t.remove();
		}
	});
	
	//发送带条件的分页查询请求
	custAct.querySelectCondition();
}*/

/**
 * 获取筛选条件并发送条件筛选请求
 */
custAct.querySelectCondition=function(){
	var articleType="";
	$("#conditionList").find("a").each(function(){
		articleType+=$(this).attr("id")+",";
	});
	if (notNull(articleType)) {
		custAct.loadArticleListData("articleType="+subStr(articleType));
	}else {
		custAct.loadArticleListData();
//		alert("请求参数错误，刷新网页重试！");
	}
}

$(".newProduct").click(function(){
	window.open("/jump/p?name=product/add");
})
