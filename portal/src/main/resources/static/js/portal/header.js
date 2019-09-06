
/**
 * 头部页面
 */
$(function(){
	var p=getUrlArgObject("type_id");
//	console.log(p)
	if(notNull(p)){
		$(".down-panel #titlelist").find("a").each(function(){
			var ss=$(this);
			if(ss.attr("data-id")==p){
				ss.parent().addClass("current")
			}
		})
	}if(notNull(p)){
		
	}else {
		$($(".down-panel #titlelist").children("li").get(0)).addClass("current")
	}
	
});

//function loadHeraderDate(p){
//	$.post(url,function(data){
//		if (data.statusCode==1) {//请求成功
//			custAct.initData(data);
//			custAct.paginationInfo(data,20);
//		}
//	},"json");
//}