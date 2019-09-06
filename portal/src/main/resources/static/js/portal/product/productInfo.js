
/**
 * 头部页面
 */
$(function(){
	var dataUrl=getUrlArgObject("dataUrl");
	var type_id=getUrlArgObject("type_id");
	loadInfoData(decodeURIComponent(dataUrl))
	
//	$("#titlelist li").prop("class","")
//	$(".down-panel #titlelist").find("a").each(function(){
//		var ss=$(this);
//		if(ss.attr("data-id")==productType_["id"]){
//			ss.parent().addClass("current")
//		}
//	})
	
//	$("#title_name").html(currentProductTypeName())
//	var p=getUrlArgObject("type_id");
//	if(!notNull(p)){
//		
//	}
});

function loadInfoData(dataUrl){
	if(notNull("dataUrl")){
		$.get(dataUrl,function(d){
			initInfoData(d)
		},"json")
	}
}

function initInfoData(d){
	console.log(d)
	$(".main-title").html(d["title"])
	$(".showDate").html("发布日期："+d["showDate"])
	$(".productDetail").html(d["productDetail"])
	
//	console.log($("#detail .w .productDetail p").html())
}