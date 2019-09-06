
/**
 * 文章添加页面js
 */
var custAct = {}; //当前页面对象
var editor={};
$(function(){
	initSummernote()
	
	var p=getUrlArgObject("type_id");
	var url=getUrlArgObject("dataUrl");
	$("#type_id").val(p);
	custAct.loadProductData(url)
//	var c=prepareCondition(p)
//	custAct.loadArticleListData(c);
});
/**
 * 初始化富文本内容
 */
function initSummernote(){
	editor=$('#summernote').summernote({
        height: 400,
        lang: 'zh-CN',
        focus:true,
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
	});
}

function sendFile(files, editor, $editable) {
    var formdata = new FormData();
    formdata.append("file", $('.note-image-input')[0].files[0]);
    $.ajax({
        data : formdata,
        type : "POST",
        url : "/file/upload", //图片上传出来的url，返回的是图片上传后的路径，http格式
        cache : false,
        contentType : false,
        processData : false,
        dataType : "json",
        success: function(d) {
            console.info("插入的图片：" + d.filePath);
            //data是返回的hash,key之类的值，key是定义的文件名
            $('#summernote').summernote('insertImage', d.filePath);
        },
        error:function(){
            alert("上传失败");
        }
    });
}

function prepareCondition(p){
	var ss={};
	ss["pageNumber"]=$("#pageNumber").val()
	ss["pageSize"]=$("#pageSize").val()
	ss["productType"]=p
	console.log(p)
	return ss;
}
$("#uploadfileButton").click(function(){
	var formData = new FormData($("#addfile")[0]);
	console.log(formData)
		$.ajax({
			//接口地址
			url: '/file/upload' ,
			type: 'POST',
			data: formData,
			async: false,
			cache: false,
			contentType: false,
			processData: false,
			success: function (data) {
				//成功的回调
				var url=JSON.parse(data);
				showImg(url.filePath)
			},
			error: function (returndata) {
				//请求异常的回调
				// modals.warn("网络访问失败，请稍后重试!");
			}
		});
})
/**
 * 显示图片，
 * 隐藏上传按钮
 * @param url
 */
function showImg(imgurl){
	$("#addfile").addClass("hidden");
	var ss=$("#image")
	ss.attr("src",imgurl)
	ss.removeClass("hidden")
	$(".delimg").removeClass("hidden")
}
/**
 * 隐藏图片，
 * 显示上传按钮
 * @param url
 */
$(".delimg").click(function(){
	$("#addfile").addClass("hidden");
	var ss=$("#image")
	ss.attr("src","")
	ss.addClass("hidden")
	$(".delimg").addClass("hidden")
	$("#addfile").removeClass("hidden");
})

/**
 * 加载页面初始化数据
 */
custAct.loadProductData=function(url){
	$.get(url,function(data){
			custAct.initData(data);
	},"json");
};

/**
 * 初始化页面数据
 */
custAct.initData=function(d){
	var val="";
	console.log(d)
	showImg(d.productSynopsisImg)
	$("#id").val(d.id)
	$("#isDel").val(d.isDel)
	$("#isSale").val(d.isSale)
	$("#showDate").val(d.showDate)
	$("#createDate").val(d.createDate)
	$("#productHtmlAddress").val(d.productHtmlAddress)
	$("#title").val(d.title)
	$("#orderCode").val(d.orderCode)
	$("#submitUrl").val(d["_links"]["_save"]["href"])
	$("#productSynopsis").val(d.productSynopsis)
	$("#title").val(d.title)
	var types=d.productTypeS;
	var seleType=d.productType_
	var seleInfo="";
	for(var i=0;i<types.length;i++){
		if(types[i]["id"]==seleType["id"]){
			seleInfo+="<option value='"+seleType["id"]+"' selected >"+seleType["productTypeName"]+"</option>"
		}else {
			seleInfo+="<option value='"+types[i]["id"]+"'>"+types[i]["productTypeName"]+"</option>"
		}
	}
	$("#productType").html(seleInfo);
	$("#product_detail").val(d.productDetail);
	$('#summernote').summernote('code', d.productDetail);
//	editor.txt.html(d.productDetail)
}


/**
 * 表单提交动作
 */
$("#save").click(function(){
	
	//获取表单元素
	var o=custAct.getData();
	//提交动作
	custAct.saveData(o);
	
});


/**
 * 处理图片 添加域名
 * ps:192.168.1.43:8080/zgyt/upload/20160808/1470629115046.jpg
 */
custAct.saveData=function(o){
	
	//提交数据
	var submitUrl=o["submitUrl"]
	if(!notNull(submitUrl)){
		submitUrl="/product/add"
	}
	console.log(submitUrl)
//	$.post(submitUrl,JSON.stringify(o),function(data){
//		if (data.statusCode==1) {
//			alert("创建文章成功！");
//		}
//	},"json");
	
//	$.post(submitUrl,o,function(d){
//		console.log(d)
//    	alert("创建文章成功！");
//	},"json");
	
	$.ajax({
	    url:submitUrl,    //请求的url地址
	    dataType:"json",   //返回格式为json
	    async:true,//请求是否异步，默认为异步，这也是ajax重要特性
	    data:JSON.stringify(o),    //参数值
	    contentType: "application/json;charset-UTF-8",
	    type:"POST",   //请求方式
	    success:function(d){
	        //请求成功时处理
	    	console.log(d)
//	    	custAct.initData(d)
	    	alert("创建文章成功！");
	    	window.close();
	    },
	    error:function(d){
	        //请求出错处理
	    }
	});
}

/**
 * 获取表单元素
 */
custAct.getData=function(){
	//获取表单元素
	var o = {};
//	param1 = $("#f1").serializeArray();
//	for(var i =0;i<param1.length;i++){
//		o[param1[i].name]=param1[i].value;
//	}
	// 获取富文本编辑器中的内容
	o["productSynopsisImg"] =$("#image").attr("src");
	o["title"] =$("#title").val();
	o["productSynopsis"] =$("#productSynopsis").val();
	o["productTypeId"] =$("#productType").val();
	console.log($('#summernote').summernote('removeFormat'));
	o["productDetail"] =$("#summernote").summernote("code")//.replace("<p><br></p>","");
	o["id"] =$("#id").val();
	o["isDel"] =$("#isDel").val();
	o["isSale"] =$("#isSale").val();
	o["showDate"] =$("#showDate").val();
	o["createDate"] =$("#createDate").val();
	o["productHtmlAddress"] =$("#productHtmlAddress").val();
	o["submitUrl"] =$("#submitUrl").val();
	o["orderCode"]=$("#orderCode").val()
//	var $t =$("<div>"+articleDetail+"</div>");
//	o["article.articleDetail"]=$t;
	//文章类型
//	o["article.articleType"]=$("#f1").find("select[name='article.articleType']").find("option:selected").val();
	//处理图片
//	console.log(o)
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

