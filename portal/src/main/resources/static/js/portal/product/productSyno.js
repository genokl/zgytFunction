
/**
 * 头部页面
 */
$(function(){
	var dataUrl=getUrlArgObject("dataUrl");
	var type_id=getUrlArgObject("type_id");
	$(".productType").val(type_id)
	$(".pagehref").html(currentProductTypeName());
	$(".content .w .content-right .top .tit div").html(currentProductTypeName());
	loadInfoData(dataUrl,type_id)
	$(".bannerImg").attr("src",setSynoBannerImg(type_id))
});

function loadInfoData(dataUrl,type_id){
	console.log(type_id)
	if(notNull(dataUrl)){
		$.get(dataUrl,function(d){
			initInfoData(d)
		},"json")
	}
}

function initInfoData(d,type_id){
	
	$(".main-title").html(d["title"])
	$(".showDate").html(d["showDate"])
	$(".productDetail").html(d["productDetail"])
	
//	console.log($("#detail .w .productDetail p").html())
}

