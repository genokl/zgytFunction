
/**
 * 头部页面
 */
$(function(){
	loadIndexData()
});

function loadIndexData(){
	$.get("/index/indexData",function(d){
		console.log(d)
		if(d!=null){
			initProductData(d["products"])
//			initListData(d["products"])
		}
	},"json")
}

function initProductData(d){
	var s="<ul>"
	for (var i = 0; i < d.length; i++) {
		console.log(d)
		 s+="<li style='width:229px'>"
			 if(d[i]["links"][0]["rel"]=="_self"){
				 s+="  <a href='"+genJumpInfoUrl(d[i].productType.id,d[i]["links"][0]["href"])+"'>"
			 }
		 s+="    <img style='border: 1px solid #0000004a;' src='"+d[i]["productSynopsisImg"].replace(",","")+"' alt=''>"
		 s+="      <span>"+d[i]["title"]+"</span>"
		 s+="   </a>"
		 s+="</li>"
	}
	s+="</ul>"
	$(".productList").html(s)
}

