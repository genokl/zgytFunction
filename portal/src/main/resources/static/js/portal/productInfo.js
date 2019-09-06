
/**
 * 头部页面
 */
$(function(){
	var dataUrl=getUrlArgObject("dataUrl");
	loadInfoData(decodeURIComponent(dataUrl))
});

function loadInfoData(dataUrl){
	if(notNull("dataUrl")){
		$.get(dataUrl,function(d){
			initInfoData(d)
		},"json")
	}
}

function initInfoData(d){
	$(".main-title").html(d["title"])
	$(".showDate").html(d["showDate"])
	$(".productDetail").html(d["productDetail"])
	
	console.log($("#detail .w .productDetail p").html())
}